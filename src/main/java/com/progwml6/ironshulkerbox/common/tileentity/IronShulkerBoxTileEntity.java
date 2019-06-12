package com.progwml6.ironshulkerbox.common.tileentity;

import com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxType;
import com.progwml6.ironshulkerbox.common.core.IronShulkerBoxBlocks;
import com.progwml6.ironshulkerbox.common.inventory.ShulkerBoxContainer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.IntStream;

public class IronShulkerBoxTileEntity extends LockableLootTileEntity implements ISidedInventory, ITickableTileEntity
{
    private final int[] SLOTS;

    private NonNullList<ItemStack> items;

    private int openCount;

    private IronShulkerBoxTileEntity.AnimationStatus animationStatus = IronShulkerBoxTileEntity.AnimationStatus.CLOSED;

    private float progress;

    private float progressOld;

    private DyeColor color;

    private ShulkerBoxType shulkerBoxType;

    private List<ShulkerBoxBlock> blocksToUse;

    private boolean needsColorFromWorld;

    public IronShulkerBoxTileEntity()
    {
        this(null);
        this.needsColorFromWorld = true;
    }

    public IronShulkerBoxTileEntity(@Nullable DyeColor colorIn)
    {
        this(ShulkerBoxTileEntityType.IRON_SHULKER_BOX, colorIn, ShulkerBoxType.IRON, IronShulkerBoxBlocks.ironShulkerBoxes);
    }

    public IronShulkerBoxTileEntity(TileEntityType<?> typeIn, @Nullable DyeColor colorIn, ShulkerBoxType shulkerBoxTypeIn, List<ShulkerBoxBlock> blockListIn)
    {
        super(typeIn);

        this.SLOTS = IntStream.range(0, shulkerBoxTypeIn.size).toArray();
        this.items = NonNullList.<ItemStack>withSize(shulkerBoxTypeIn.size, ItemStack.EMPTY);

        this.color = colorIn;
        this.shulkerBoxType = shulkerBoxTypeIn;
        this.blocksToUse = blockListIn;

        if (colorIn == null)
        {
            this.needsColorFromWorld = true;
        }
    }

    @Override
    public void tick()
    {
        this.updateAnimation();

        if (this.animationStatus == IronShulkerBoxTileEntity.AnimationStatus.OPENING || this.animationStatus == IronShulkerBoxTileEntity.AnimationStatus.CLOSING)
        {
            this.moveCollidedEntities();
        }
    }

    protected void updateAnimation()
    {
        this.progressOld = this.progress;

        switch (this.animationStatus)
        {
            case CLOSED:
                this.progress = 0.0F;
                break;
            case OPENING:
                this.progress += 0.1F;
                if (this.progress >= 1.0F)
                {
                    this.moveCollidedEntities();
                    this.animationStatus = IronShulkerBoxTileEntity.AnimationStatus.OPENED;
                    this.progress = 1.0F;
                    this.updateNeighbors();
                }
                break;
            case CLOSING:
                this.progress -= 0.1F;
                if (this.progress <= 0.0F)
                {
                    this.animationStatus = IronShulkerBoxTileEntity.AnimationStatus.CLOSED;
                    this.progress = 0.0F;
                    this.updateNeighbors();
                }
                break;
            case OPENED:
                this.progress = 1.0F;
        }
    }

    public IronShulkerBoxTileEntity.AnimationStatus getAnimationStatus()
    {
        return this.animationStatus;
    }

    public AxisAlignedBB getBoundingBox(BlockState state)
    {
        return this.getBoundingBox(state.get(ShulkerBoxBlock.FACING));
    }

    public AxisAlignedBB getBoundingBox(Direction direction)
    {
        float f = this.getProgress(1.0F);
        return VoxelShapes.fullCube().getBoundingBox().expand((double) (0.5F * f * (float) direction.getXOffset()), (double) (0.5F * f * (float) direction.getYOffset()), (double) (0.5F * f * (float) direction.getZOffset()));
    }

    private AxisAlignedBB getTopBoundingBox(Direction direction)
    {
        Direction opposite = direction.getOpposite();
        return this.getBoundingBox(direction).contract((double) opposite.getXOffset(), (double) opposite.getYOffset(), (double) opposite.getZOffset());
    }

    private void moveCollidedEntities()
    {
        BlockState blockstate = this.world.getBlockState(this.getPos());

        if (blockstate.getBlock() instanceof ShulkerBoxBlock)
        {
            Direction direction = blockstate.get(ShulkerBoxBlock.FACING);
            AxisAlignedBB axisalignedbb = this.getTopBoundingBox(direction).offset(this.pos);
            List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(null, axisalignedbb);

            if (!list.isEmpty())
            {
                for (int i = 0; i < list.size(); ++i)
                {
                    Entity entity = list.get(i);

                    if (entity.getPushReaction() != PushReaction.IGNORE)
                    {
                        double d0 = 0.0D;
                        double d1 = 0.0D;
                        double d2 = 0.0D;

                        AxisAlignedBB axisalignedbb1 = entity.getBoundingBox();

                        switch (direction.getAxis())
                        {
                            case X:
                                if (direction.getAxisDirection() == Direction.AxisDirection.POSITIVE)
                                {
                                    d0 = axisalignedbb.maxX - axisalignedbb1.minX;
                                }
                                else
                                {
                                    d0 = axisalignedbb1.maxX - axisalignedbb.minX;
                                }

                                d0 = d0 + 0.01D;
                                break;
                            case Y:
                                if (direction.getAxisDirection() == Direction.AxisDirection.POSITIVE)
                                {
                                    d1 = axisalignedbb.maxY - axisalignedbb1.minY;
                                }
                                else
                                {
                                    d1 = axisalignedbb1.maxY - axisalignedbb.minY;
                                }

                                d1 = d1 + 0.01D;
                                break;
                            case Z:
                                if (direction.getAxisDirection() == Direction.AxisDirection.POSITIVE)
                                {
                                    d2 = axisalignedbb.maxZ - axisalignedbb1.minZ;
                                }
                                else
                                {
                                    d2 = axisalignedbb1.maxZ - axisalignedbb.minZ;
                                }

                                d2 = d2 + 0.01D;
                        }

                        entity.move(MoverType.SHULKER_BOX, new Vec3d(d0 * (double) direction.getXOffset(), d1 * (double) direction.getYOffset(), d2 * (double) direction.getZOffset()));
                    }
                }
            }
        }
    }

    @Override
    public int getSizeInventory()
    {
        return this.items.size();
    }

    @Override
    public boolean receiveClientEvent(int id, int type)
    {
        if (id == 1)
        {
            this.openCount = type;
            if (type == 0)
            {
                this.animationStatus = IronShulkerBoxTileEntity.AnimationStatus.CLOSING;
                this.updateNeighbors();
            }

            if (type == 1)
            {
                this.animationStatus = IronShulkerBoxTileEntity.AnimationStatus.OPENING;
                this.updateNeighbors();
            }

            return true;
        }
        else
        {
            return super.receiveClientEvent(id, type);
        }
    }

    private void updateNeighbors()
    {
        this.getBlockState().updateNeighbors(this.getWorld(), this.getPos(), 3);
    }

    @Override
    public void openInventory(PlayerEntity player)
    {
        if (!player.isSpectator())
        {
            if (this.openCount < 0)
            {
                this.openCount = 0;
            }

            ++this.openCount;
            this.world.addBlockEvent(this.pos, this.getBlockState().getBlock(), 1, this.openCount);
            if (this.openCount == 1)
            {
                this.world.playSound((PlayerEntity) null, this.pos, SoundEvents.BLOCK_SHULKER_BOX_OPEN, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
            }
        }
    }

    @Override
    public void closeInventory(PlayerEntity player)
    {
        if (!player.isSpectator())
        {
            --this.openCount;
            this.world.addBlockEvent(this.pos, this.getBlockState().getBlock(), 1, this.openCount);
            if (this.openCount <= 0)
            {
                this.world.playSound((PlayerEntity) null, this.pos, SoundEvents.BLOCK_SHULKER_BOX_CLOSE, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
            }
        }
    }

    @Override
    protected ITextComponent getDefaultName()
    {
        return new TranslationTextComponent("container.shulkerBox");
    }

    @Override
    public void read(CompoundNBT compound)
    {
        super.read(compound);
        this.loadFromNbt(compound);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound)
    {
        super.write(compound);
        return this.saveToNbt(compound);
    }

    public void loadFromNbt(CompoundNBT compound)
    {
        this.items = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);

        if (!this.checkLootAndRead(compound) && compound.contains("Items", 9))
        {
            ItemStackHelper.loadAllItems(compound, this.items);
        }
    }

    public CompoundNBT saveToNbt(CompoundNBT compound)
    {
        if (!this.checkLootAndWrite(compound))
        {
            ItemStackHelper.saveAllItems(compound, this.items, false);
        }

        return compound;
    }

    @Override
    public NonNullList<ItemStack> getItems()
    {
        return this.items;
    }

    @Override
    public void setItems(NonNullList<ItemStack> itemsIn)
    {
        this.items = NonNullList.<ItemStack>withSize(this.getShulkerBoxType().size, ItemStack.EMPTY);

        for (int i = 0; i < itemsIn.size(); i++)
        {
            if (i < this.items.size())
            {
                this.getItems().set(i, itemsIn.get(i));
            }
        }
    }

    @Override
    public boolean isEmpty()
    {
        for (ItemStack itemstack : this.items)
        {
            if (!itemstack.isEmpty())
            {
                return false;
            }
        }

        return true;
    }

    @Override
    public int[] getSlotsForFace(Direction side)
    {
        return SLOTS;
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, @Nullable Direction direction)
    {
        return !(Block.getBlockFromItem(itemStackIn.getItem()) instanceof ShulkerBoxBlock) || !(Block.getBlockFromItem(itemStackIn.getItem()) instanceof net.minecraft.block.ShulkerBoxBlock);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, Direction direction)
    {
        return true;
    }

    public float getProgress(float p_190585_1_)
    {
        return MathHelper.func_219799_g(p_190585_1_, this.progressOld, this.progress);
    }

    @OnlyIn(Dist.CLIENT)
    public DyeColor getColor()
    {
        if (this.needsColorFromWorld)
        {
            this.color = ShulkerBoxBlock.getColorFromBlock(this.getBlockState().getBlock());
            this.needsColorFromWorld = false;
        }

        return this.color;
    }

    @Override
    protected Container createMenu(int id, PlayerInventory playerInventory)
    {
        return ShulkerBoxContainer.createIronContainer(id, playerInventory, this);
    }

    public ShulkerBoxType getShulkerBoxType()
    {
        ShulkerBoxType type = ShulkerBoxType.IRON;

        if (this.hasWorld())
        {
            ShulkerBoxType typeNew = ShulkerBoxBlock.getTypeFromBlock(this.getBlockState().getBlock());

            if (typeNew != null)
            {
                type = typeNew;
            }
        }

        return type;
    }

    public Block getBlockToUse()
    {
        return this.blocksToUse.get(color.getId());
    }

    public enum AnimationStatus
    {
        CLOSED,
        OPENING,
        OPENED,
        CLOSING
    }
}
