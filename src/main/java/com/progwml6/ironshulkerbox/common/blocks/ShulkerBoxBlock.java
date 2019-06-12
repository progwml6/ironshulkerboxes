package com.progwml6.ironshulkerbox.common.blocks;

import com.progwml6.ironshulkerbox.IronShulkerBox;
import com.progwml6.ironshulkerbox.common.core.IronShulkerBoxBlocks;
import com.progwml6.ironshulkerbox.common.tileentity.IronShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.util.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.material.PushReaction;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootParameters;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public abstract class ShulkerBoxBlock extends Block
{
    public static final EnumProperty<Direction> FACING = DirectionalBlock.FACING;

    public static final ResourceLocation contents = new ResourceLocation(IronShulkerBox.MOD_ID, "contents");

    protected final DyeColor color;

    private final ShulkerBoxType type;

    public ShulkerBoxBlock(DyeColor color, Properties properties, ShulkerBoxType type)
    {
        super(properties);
        this.color = color;
        this.type = type;
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.UP));

        this.setRegistryName(new ResourceLocation(BlockNames.getNameWithColor(type.itemName, color)));
    }

    @Override
    public boolean causesSuffocation(BlockState blockState, IBlockReader world, BlockPos pos)
    {
        return true;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean hasCustomBreakingProgress(BlockState state)
    {
        return true;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state)
    {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult)
    {
        if (world.isRemote)
        {
            return true;
        }
        else if (player.isSpectator())
        {
            return true;
        }
        else
        {
            TileEntity tileentity = world.getTileEntity(pos);

            if (tileentity instanceof IronShulkerBoxTileEntity)
            {
                Direction direction = state.get(FACING);
                IronShulkerBoxTileEntity shulkerboxtileentity = (IronShulkerBoxTileEntity) tileentity;
                boolean flag;
                if (shulkerboxtileentity.getAnimationStatus() == IronShulkerBoxTileEntity.AnimationStatus.CLOSED)
                {
                    AxisAlignedBB axisalignedbb = VoxelShapes.fullCube().getBoundingBox().expand((double) (0.5F * (float) direction.getXOffset()), (double) (0.5F * (float) direction.getYOffset()), (double) (0.5F * (float) direction.getZOffset())).contract((double) direction.getXOffset(), (double) direction.getYOffset(), (double) direction.getZOffset());
                    flag = world.areCollisionShapesEmpty(axisalignedbb.offset(pos.offset(direction)));
                }
                else
                {
                    flag = true;
                }

                if (flag)
                {
                    player.openContainer(shulkerboxtileentity);
                    player.addStat(Stats.OPEN_SHULKER_BOX);
                }

                return true;
            }
            else
            {
                return false;
            }
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return this.getDefaultState().with(FACING, context.getFace());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(FACING);
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player)
    {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (tileentity instanceof IronShulkerBoxTileEntity)
        {
            IronShulkerBoxTileEntity shulkerboxtileentity = (IronShulkerBoxTileEntity) tileentity;
            if (!worldIn.isRemote && player.isCreative() && !shulkerboxtileentity.isEmpty())
            {
                ItemStack itemstack = getColoredItemStack(this.getColor(), this.getType());
                CompoundNBT compoundnbt = shulkerboxtileentity.saveToNbt(new CompoundNBT());
                if (!compoundnbt.isEmpty())
                {
                    itemstack.setTagInfo("BlockEntityTag", compoundnbt);
                }

                if (shulkerboxtileentity.hasCustomName())
                {
                    itemstack.setDisplayName(shulkerboxtileentity.getCustomName());
                }

                ItemEntity itementity = new ItemEntity(worldIn, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), itemstack);
                itementity.setDefaultPickupDelay();
                worldIn.addEntity(itementity);
            }
            else
            {
                shulkerboxtileentity.fillWithLoot(player);
            }
        }

        super.onBlockHarvested(worldIn, pos, state, player);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder lootBuilder)
    {
        TileEntity tileentity = lootBuilder.get(LootParameters.BLOCK_ENTITY);

        if (tileentity instanceof IronShulkerBoxTileEntity)
        {
            IronShulkerBoxTileEntity shulkerboxtileentity = (IronShulkerBoxTileEntity) tileentity;
            lootBuilder = lootBuilder.withDynamicDrop(contents, (lootContext, itemStackConsumer) -> {
                for (int i = 0; i < shulkerboxtileentity.getSizeInventory(); ++i)
                {
                    itemStackConsumer.accept(shulkerboxtileentity.getStackInSlot(i));
                }

            });
        }

        return super.getDrops(state, lootBuilder);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack)
    {
        if (stack.hasDisplayName())
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof IronShulkerBoxTileEntity)
            {
                ((IronShulkerBoxTileEntity) tileentity).setCustomName(stack.getDisplayName());
            }
        }
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving)
    {
        if (state.getBlock() != newState.getBlock())
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof IronShulkerBoxTileEntity)
            {
                worldIn.updateComparatorOutputLevel(pos, state.getBlock());
            }

            super.onReplaced(state, worldIn, pos, newState, isMoving);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        CompoundNBT compoundnbt = stack.getChildTag("BlockEntityTag");
        if (compoundnbt != null)
        {
            if (compoundnbt.contains("LootTable", 8))
            {
                tooltip.add(new StringTextComponent("???????"));
            }

            if (compoundnbt.contains("Items", 9))
            {
                NonNullList<ItemStack> nonnulllist = NonNullList.withSize(27, ItemStack.EMPTY);
                ItemStackHelper.loadAllItems(compoundnbt, nonnulllist);
                int i = 0;
                int j = 0;

                for (ItemStack itemstack : nonnulllist)
                {
                    if (!itemstack.isEmpty())
                    {
                        ++j;
                        if (i <= 4)
                        {
                            ++i;
                            ITextComponent itextcomponent = itemstack.getDisplayName().deepCopy();
                            itextcomponent.appendText(" x").appendText(String.valueOf(itemstack.getCount()));
                            tooltip.add(itextcomponent);
                        }
                    }
                }

                if (j - i > 0)
                {
                    tooltip.add((new TranslationTextComponent("container.shulkerBox.more", j - i)).applyTextStyle(TextFormatting.ITALIC));
                }
            }
        }
    }

    @Override
    public PushReaction getPushReaction(BlockState state)
    {
        return PushReaction.DESTROY;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context)
    {
        TileEntity tileentity = world.getTileEntity(pos);
        return tileentity instanceof IronShulkerBoxTileEntity ? VoxelShapes.create(((IronShulkerBoxTileEntity) tileentity).getBoundingBox(state)) : VoxelShapes.fullCube();
    }

    @Override
    public boolean isSolid(BlockState state)
    {
        return false;
    }

    @Override
    public boolean hasComparatorInputOverride(BlockState state)
    {
        return true;
    }

    @Override
    public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos)
    {
        return Container.calcRedstoneFromInventory((IInventory) worldIn.getTileEntity(pos));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state)
    {
        ItemStack itemstack = super.getItem(worldIn, pos, state);
        IronShulkerBoxTileEntity shulkerboxtileentity = (IronShulkerBoxTileEntity) worldIn.getTileEntity(pos);
        CompoundNBT compoundnbt = shulkerboxtileentity.saveToNbt(new CompoundNBT());

        if (!compoundnbt.isEmpty())
        {
            itemstack.setTagInfo("BlockEntityTag", compoundnbt);
        }

        return itemstack;
    }

    public static ShulkerBoxType getTypeFromItem(Item itemIn)
    {
        return getTypeFromBlock(Block.getBlockFromItem(itemIn));
    }

    public static ShulkerBoxType getTypeFromBlock(Block blockIn)
    {
        return blockIn instanceof ShulkerBoxBlock ? ((ShulkerBoxBlock) blockIn).getType() : null;
    }

    public ShulkerBoxType getType()
    {
        return this.type;
    }

    @OnlyIn(Dist.CLIENT)
    public static DyeColor getColorFromItem(Item itemIn)
    {
        return getColorFromBlock(Block.getBlockFromItem(itemIn));
    }

    @OnlyIn(Dist.CLIENT)
    public static DyeColor getColorFromBlock(Block blockIn)
    {
        return blockIn instanceof ShulkerBoxBlock ? ((ShulkerBoxBlock) blockIn).getColor() : null;
    }

    public static Block getBlockByColor(DyeColor colorIn, ShulkerBoxType typeIn)
    {
        switch (typeIn)
        {
            case IRON:
                return IronShulkerBoxBlocks.ironShulkerBoxes.get(colorIn.getId());
            case GOLD:
                return IronShulkerBoxBlocks.goldShulkerBoxes.get(colorIn.getId());
            case DIAMOND:
                return IronShulkerBoxBlocks.diamondShulkerBoxes.get(colorIn.getId());
            case COPPER:
                return IronShulkerBoxBlocks.copperShulkerBoxes.get(colorIn.getId());
            case SILVER:
                return IronShulkerBoxBlocks.silverShulkerBoxes.get(colorIn.getId());
            case CRYSTAL:
                return IronShulkerBoxBlocks.crystalShulkerBoxes.get(colorIn.getId());
            case OBSIDIAN:
                return IronShulkerBoxBlocks.obsidianShulkerBoxes.get(colorIn.getId());
            default:
                return IronShulkerBoxBlocks.redIronShulkerBoxBlock;
        }
    }

    @Nullable
    public DyeColor getColor()
    {
        return this.color;
    }

    public static ItemStack getColoredItemStack(DyeColor colorIn, ShulkerBoxType typeIn)
    {
        return new ItemStack(getBlockByColor(colorIn, typeIn));
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot)
    {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn)
    {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    public boolean eventReceived(BlockState state, World worldIn, BlockPos pos, int id, int param)
    {
        super.eventReceived(state, worldIn, pos, id, param);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity == null ? false : tileentity.receiveClientEvent(id, param);
    }

    @Override
    @Nullable
    public INamedContainerProvider getContainer(BlockState state, World world, BlockPos pos)
    {
        TileEntity tileentity = world.getTileEntity(pos);
        return tileentity instanceof INamedContainerProvider ? (INamedContainerProvider) tileentity : null;
    }

    @Override
    public boolean hasTileEntity(BlockState state)
    {
        return true;
    }
}
