package com.progwml6.ironshulkerbox.common.blocks;

import com.progwml6.ironshulkerbox.common.core.IronShulkerBoxBlocks;
import com.progwml6.ironshulkerbox.common.tileentity.TileEntityIronShulkerBox;
import com.progwml6.ironshulkerbox.common.util.BlockNames;
import io.netty.buffer.Unpooled;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.INameable;
import net.minecraft.util.Mirror;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.List;

public abstract class BlockShulkerBox extends Block
{
    public static final EnumProperty<EnumFacing> FACING = BlockDirectional.FACING;

    protected final EnumDyeColor color;

    private final IronShulkerBoxType type;

    public BlockShulkerBox(EnumDyeColor colorIn, Block.Properties properties, IronShulkerBoxType typeIn)
    {
        super(properties);
        this.color = colorIn;
        this.type = typeIn;
        this.setDefaultState((IBlockState) (this.stateContainer.getBaseState()).with(FACING, EnumFacing.UP));

        this.setRegistryName(new ResourceLocation(BlockNames.getNameWithColor(typeIn.itemName, colorIn)));
    }

    /**
     * @deprecated call via {@link IBlockState#causesSuffocation()} whenever possible. Implementing/overriding is fine.
     */
    @Override
    public boolean causesSuffocation(IBlockState state)
    {
        return true;
    }

    /**
     * @deprecated call via {@link IBlockState#isFullCube()} whenever possible. Implementing/overriding is fine.
     */
    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    /**
     * @deprecated call via {@link IBlockState#hasCustomBreakingProgress()} whenever possible. Implementing/overriding is
     * fine.
     */
    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean hasCustomBreakingProgress(IBlockState state)
    {
        return true;
    }

    /**
     * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED for TESR-only,
     * LIQUID for vanilla liquids, INVISIBLE to skip all rendering
     * @deprecated call via {@link IBlockState#getRenderType()} whenever possible. Implementing/overriding is fine.
     */
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else if (player.isSpectator())
        {
            return true;
        }
        else
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof TileEntityIronShulkerBox)
            {
                EnumFacing enumFacing = state.get(FACING);
                boolean flag;

                if (((TileEntityIronShulkerBox) tileentity).getAnimationStatus() == TileEntityIronShulkerBox.AnimationStatus.CLOSED)
                {
                    AxisAlignedBB axisalignedbb = VoxelShapes.fullCube().getBoundingBox().expand((double) (0.5F * (float) enumFacing.getXOffset()), (double) (0.5F * (float) enumFacing.getYOffset()), (double) (0.5F * (float) enumFacing.getZOffset())).contract((double) enumFacing.getXOffset(), (double) enumFacing.getYOffset(), (double) enumFacing.getZOffset());
                    flag = worldIn.isCollisionBoxesEmpty(null, axisalignedbb.offset(pos.offset(enumFacing)));
                }
                else
                {
                    flag = true;
                }

                if (flag)
                {
                    player.addStat(StatList.OPEN_SHULKER_BOX);

                    if (player instanceof EntityPlayerMP && !(player instanceof FakePlayer))
                    {
                        EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;
                        PacketBuffer buffer = new PacketBuffer(Unpooled.buffer());
                        buffer.writeBlockPos(tileentity.getPos());
                        buffer.writeString(((TileEntityIronShulkerBox) tileentity).getShulkerBoxType().getName());

                        NetworkHooks.openGui(entityPlayerMP, (IInteractionObject) tileentity, buffer);
                    }
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
    public IBlockState getStateForPlacement(BlockItemUseContext context)
    {
        return this.getDefaultState().with(FACING, context.getFace());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder)
    {
        builder.add(FACING);
    }

    /**
     * Called before the Block is set to air in the world. Called regardless of if the player's tool can actually collect
     * this block
     */
    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        if (worldIn.getTileEntity(pos) instanceof TileEntityIronShulkerBox)
        {
            TileEntityIronShulkerBox shulkerBox = (TileEntityIronShulkerBox) worldIn.getTileEntity(pos);
            shulkerBox.setDestroyedByCreativePlayer(player.abilities.isCreativeMode);
            shulkerBox.fillWithLoot(player);
        }

        super.onBlockHarvested(worldIn, pos, state, player);
    }

    @Override
    public void dropBlockAsItemWithChance(IBlockState state, World worldIn, BlockPos pos, float chancePerItem, int fortune)
    {
    }

    /**
     * Called by ItemBlocks after a block is set in the world, to allow post-place logic
     */
    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        if (stack.hasDisplayName())
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof TileEntityIronShulkerBox)
            {
                ((TileEntityIronShulkerBox) tileentity).setCustomName(stack.getDisplayName());
            }
        }

    }

    @Override
    public void onReplaced(IBlockState state, World worldIn, BlockPos pos, IBlockState newState, boolean isMoving)
    {
        if (state.getBlock() != newState.getBlock())
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityIronShulkerBox)
            {
                TileEntityIronShulkerBox shulkerBox = (TileEntityIronShulkerBox) tileentity;

                if (!shulkerBox.isCleared() && shulkerBox.shouldDrop())
                {
                    ItemStack itemstack = new ItemStack(this);
                    itemstack.getOrCreateTag().put("BlockEntityTag", ((TileEntityIronShulkerBox) tileentity).saveToNbt(new NBTTagCompound()));

                    if (shulkerBox.hasCustomName())
                    {
                        itemstack.setDisplayName(shulkerBox.getCustomName());
                        shulkerBox.setCustomName((ITextComponent) null);
                    }

                    spawnAsEntity(worldIn, pos, itemstack);
                }

                worldIn.updateComparatorOutputLevel(pos, state.getBlock());
            }

            super.onReplaced(state, worldIn, pos, newState, isMoving);
            worldIn.removeTileEntity(pos);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        NBTTagCompound nbttagcompound = stack.getChildTag("BlockEntityTag");
        if (nbttagcompound != null)
        {
            if (nbttagcompound.contains("LootTable", 8))
            {
                tooltip.add(new TextComponentString("???????"));
            }

            if (nbttagcompound.contains("Items", 9))
            {
                NonNullList<ItemStack> nonnulllist = NonNullList.<ItemStack>withSize(27, ItemStack.EMPTY);
                ItemStackHelper.loadAllItems(nbttagcompound, nonnulllist);
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
                            ITextComponent itextcomponent = itemstack.getDisplayName().shallowCopy();
                            itextcomponent.appendText(" x").appendText(String.valueOf(itemstack.getCount()));
                            tooltip.add(itextcomponent);
                        }
                    }
                }

                if (j - i > 0)
                {
                    tooltip.add((new TextComponentTranslation("container.shulkerBox.more", new Object[] { j - i })).applyTextStyle(TextFormatting.ITALIC));
                }
            }
        }
    }

    /**
     * @deprecated call via {@link IBlockState#getPushReaction()} whenever possible. Implementing/overriding is fine.
     */
    @Override
    public EnumPushReaction getPushReaction(IBlockState state)
    {
        return EnumPushReaction.DESTROY;
    }

    @Override
    public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos)
    {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity instanceof TileEntityIronShulkerBox ? VoxelShapes.create(((TileEntityIronShulkerBox) tileentity).getBoundingBox(state)) : VoxelShapes.fullCube();
    }

    @Override
    public boolean isSolid(IBlockState state)
    {
        return false;
    }

    /**
     * @deprecated call via {@link IBlockState#hasComparatorInputOverride()} whenever possible. Implementing/overriding
     * is fine.
     */
    @Override
    public boolean hasComparatorInputOverride(IBlockState state)
    {
        return true;
    }

    /**
     * @deprecated call via {@link IBlockState#getComparatorInputOverride(World, BlockPos)} whenever possible.
     * Implementing/overriding is fine.
     */
    @Override
    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return Container.calcRedstoneFromInventory((IInventory) worldIn.getTileEntity(pos));
    }

    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, IBlockState state)
    {
        ItemStack itemstack = super.getItem(worldIn, pos, state);
        TileEntityIronShulkerBox shulkerBox = (TileEntityIronShulkerBox) worldIn.getTileEntity(pos);
        NBTTagCompound nbttagcompound = shulkerBox.saveToNbt(new NBTTagCompound());

        if (!nbttagcompound.isEmpty())
        {
            itemstack.setTagInfo("BlockEntityTag", nbttagcompound);
        }

        return itemstack;
    }

    /**
     * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     * @deprecated call via {@link IBlockState#rotate(Rotation)} whenever possible. Implementing/overriding is
     * fine.
     */
    @Override
    public IBlockState rotate(IBlockState state, Rotation rot)
    {
        return (IBlockState) state.with(FACING, rot.rotate((EnumFacing) state.get(FACING)));
    }

    /**
     * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     * @deprecated call via {@link IBlockState#mirror(Mirror)} whenever possible. Implementing/overriding is fine.
     */
    @Override
    public IBlockState mirror(IBlockState state, Mirror mirrorIn)
    {
        return state.rotate(mirrorIn.toRotation((EnumFacing) state.get(FACING)));
    }

    /**
     * Get the geometry of the queried face at the given position and state. This is used to decide whether things like
     * buttons are allowed to be placed on the face, or how glass panes connect to the face, among other things.
     * <p>
     * Common values are {@code SOLID}, which is the default, and {@code UNDEFINED}, which represents something that does
     * not fit the other descriptions and will generally cause other things not to connect to the face.
     *
     * @return an approximation of the form of the given face
     * @deprecated call via {@link IBlockState#getBlockFaceShape(IBlockReader, BlockPos, EnumFacing)} whenever possible.
     * Implementing/overriding is fine.
     */
    @Override
    public BlockFaceShape getBlockFaceShape(IBlockReader worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        EnumFacing enumfacing = (EnumFacing) state.get(FACING);
        TileEntityIronShulkerBox.AnimationStatus animationstatus = ((TileEntityIronShulkerBox) worldIn.getTileEntity(pos)).getAnimationStatus();

        return animationstatus != TileEntityIronShulkerBox.AnimationStatus.CLOSED && (animationstatus != TileEntityIronShulkerBox.AnimationStatus.OPENED || enumfacing != face.getOpposite() && enumfacing != face) ? BlockFaceShape.UNDEFINED : BlockFaceShape.SOLID;
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    public static IronShulkerBoxType getTypeFromItem(Item itemIn)
    {
        return getTypeFromBlock(Block.getBlockFromItem(itemIn));
    }

    public static IronShulkerBoxType getTypeFromBlock(Block blockIn)
    {
        return blockIn instanceof BlockShulkerBox ? ((BlockShulkerBox) blockIn).getType() : null;
    }

    public IronShulkerBoxType getType()
    {
        return this.type;
    }

    public static EnumDyeColor getColorFromItem(Item itemIn)
    {
        return getColorFromBlock(Block.getBlockFromItem(itemIn));
    }

    public static EnumDyeColor getColorFromBlock(Block blockIn)
    {
        return blockIn instanceof BlockShulkerBox ? ((BlockShulkerBox) blockIn).getColor() : null;
    }

    public static Block getBlockByColor(EnumDyeColor colorIn, IronShulkerBoxType typeIn)
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

    public static ItemStack getColoredItemStack(EnumDyeColor colorIn, IronShulkerBoxType typeIn)
    {
        return new ItemStack(getBlockByColor(colorIn, typeIn));
    }

    public EnumDyeColor getColor()
    {
        return this.color;
    }

    /**
     * Called on server when World#addBlockEvent is called. If server returns true, then also called on the client. On
     * the Server, this may perform additional changes to the world, like pistons replacing the block with an extended
     * base. On the client, the update may involve replacing tile entities or effects such as sounds or particles
     * @deprecated call via {@link IBlockState#onBlockEventReceived(World, BlockPos, int, int)} whenever possible.
     * Implementing/overriding is fine.
     */
    @Override
    public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int id, int param)
    {
        super.eventReceived(state, worldIn, pos, id, param);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity == null ? false : tileentity.receiveClientEvent(id, param);
    }

    /**
     * Spawns the block's drops in the world. By the time this is called the Block has possibly been set to air via
     * Block.removedByPlayer
     */
    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
    {
        if (te instanceof INameable && ((INameable) te).hasCustomName())
        {
            player.addStat(StatList.BLOCK_MINED.get(this));
            player.addExhaustion(0.005F);
            if (worldIn.isRemote)
            {
                return;
            }

            int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);
            Item item = this.getItemDropped(state, worldIn, pos, i).asItem();
            if (item == Items.AIR)
            {
                return;
            }

            ItemStack itemstack = new ItemStack(item, this.quantityDropped(state, worldIn.rand));
            itemstack.setDisplayName(((INameable) te).getCustomName());
            spawnAsEntity(worldIn, pos, itemstack);
        }
        else
        {
            super.harvestBlock(worldIn, player, pos, state, (TileEntity) null, stack);
        }
    }
}
