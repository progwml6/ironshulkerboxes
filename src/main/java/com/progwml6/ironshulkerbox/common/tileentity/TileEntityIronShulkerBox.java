package com.progwml6.ironshulkerbox.common.tileentity;

import com.progwml6.ironshulkerbox.common.blocks.BlockShulkerBox;
import com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType;
import com.progwml6.ironshulkerbox.common.core.IronShulkerBoxBlocks;
import com.progwml6.ironshulkerbox.common.gui.ContainerIronShulkerBox;
import net.minecraft.block.Block;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.shapes.ShapeUtils;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.IntStream;

public class TileEntityIronShulkerBox extends TileEntityLockableLoot implements ISidedInventory, ITickable
{
    private final int[] SLOTS;

    private NonNullList<ItemStack> items;

    private boolean hasBeenCleared;

    private int openCount;

    private AnimationStatus animationStatus;

    private float progress;

    private float progressOld;

    private EnumDyeColor color;

    private boolean destroyedByCreativePlayer;

    private IronShulkerBoxType shulkerBoxType;

    private List<BlockShulkerBox> blocksToUse;

    private boolean needsColorFromWorld;

    public TileEntityIronShulkerBox()
    {
        this(null);
    }

    public TileEntityIronShulkerBox(@Nullable EnumDyeColor colorIn)
    {
        this(IronShulkerBoxEntityType.IRON_SHULKER_BOX, colorIn, IronShulkerBoxType.IRON, IronShulkerBoxBlocks.ironShulkerBoxes);
    }

    public TileEntityIronShulkerBox(TileEntityType<?> typeIn, @Nonnull EnumDyeColor colorIn, IronShulkerBoxType shulkerBoxTypeIn,
            List<BlockShulkerBox> blocksIn)
    {
        super(typeIn);

        this.SLOTS = IntStream.range(0, shulkerBoxTypeIn.size).toArray();
        this.items = NonNullList.<ItemStack>withSize(shulkerBoxTypeIn.size, ItemStack.EMPTY);
        this.animationStatus = AnimationStatus.CLOSED;
        this.color = colorIn;
        this.shulkerBoxType = shulkerBoxTypeIn;
        this.blocksToUse = blocksIn;

        if (colorIn == null)
        {
            this.needsColorFromWorld = true;
        }
    }

    @Override
    public void tick()
    {
        this.updateAnimation();

        if (this.animationStatus == AnimationStatus.OPENING || this.animationStatus == AnimationStatus.CLOSING)
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
                    this.animationStatus = AnimationStatus.OPENED;
                    this.progress = 1.0F;
                }
                break;
            case CLOSING:
                this.progress -= 0.1F;
                if (this.progress <= 0.0F)
                {
                    this.animationStatus = AnimationStatus.CLOSED;
                    this.progress = 0.0F;
                }
                break;
            case OPENED:
                this.progress = 1.0F;
        }
    }

    public AnimationStatus getAnimationStatus()
    {
        return this.animationStatus;
    }

    public AxisAlignedBB getBoundingBox(IBlockState state)
    {
        return this.getBoundingBox((EnumFacing) state.get(BlockShulkerBox.FACING));
    }

    public AxisAlignedBB getBoundingBox(EnumFacing facing)
    {
        return ShapeUtils.fullCube().getBoundingBox().expand((double) (0.5F * this.getProgress(1.0F) * (float) facing.getXOffset()),
                (double) (0.5F * this.getProgress(1.0F) * (float) facing.getYOffset()), (double) (0.5F * this.getProgress(1.0F) * (float) facing.getZOffset()));
    }

    private AxisAlignedBB getTopBoundingBox(EnumFacing facing)
    {
        EnumFacing enumfacing = facing.getOpposite();
        return this.getBoundingBox(facing).contract((double) enumfacing.getXOffset(), (double) enumfacing.getYOffset(), (double) enumfacing.getZOffset());
    }

    private void moveCollidedEntities()
    {
        IBlockState iblockstate = this.world.getBlockState(this.getPos());

        if (iblockstate.getBlock() instanceof BlockShulkerBox)
        {
            EnumFacing enumfacing = (EnumFacing) iblockstate.get(BlockShulkerBox.FACING);
            AxisAlignedBB axisalignedbb = this.getTopBoundingBox(enumfacing).offset(this.pos);
            List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity((Entity) null, axisalignedbb);
            if (!list.isEmpty())
            {
                for (int i = 0; i < list.size(); ++i)
                {
                    Entity entity = list.get(i);
                    if (entity.getPushReaction() != EnumPushReaction.IGNORE)
                    {
                        double d0 = 0.0D;
                        double d1 = 0.0D;
                        double d2 = 0.0D;
                        AxisAlignedBB axisalignedbb1 = entity.getBoundingBox();
                        switch (enumfacing.getAxis())
                        {
                            case X:
                                if (enumfacing.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE)
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
                                if (enumfacing.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE)
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
                                if (enumfacing.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE)
                                {
                                    d2 = axisalignedbb.maxZ - axisalignedbb1.minZ;
                                }
                                else
                                {
                                    d2 = axisalignedbb1.maxZ - axisalignedbb.minZ;
                                }

                                d2 = d2 + 0.01D;
                        }

                        entity.move(MoverType.SHULKER_BOX, d0 * (double) enumfacing.getXOffset(), d1 * (double) enumfacing.getYOffset(),
                                d2 * (double) enumfacing.getZOffset());
                    }
                }

            }
        }
    }

    /**
     * Returns the number of slots in the inventory.
     */
    @Override
    public int getSizeInventory()
    {
        return this.items.size();
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended.
     */
    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * See {@link Block#eventReceived} for more information. This must return true serverside before it is called
     * clientside.
     */
    @Override
    public boolean receiveClientEvent(int id, int type)
    {
        if (id == 1)
        {
            this.openCount = type;

            if (type == 0)
            {
                this.animationStatus = AnimationStatus.CLOSING;
            }

            if (type == 1)
            {
                this.animationStatus = AnimationStatus.OPENING;
            }

            return true;
        }
        else
        {
            return super.receiveClientEvent(id, type);
        }
    }

    @Override
    public void openInventory(EntityPlayer player)
    {
        if (!player.isSpectator())
        {
            if (this.openCount < 0)
            {
                this.openCount = 0;
            }

            ++this.openCount;
            System.out.println(this.getBlockState().getBlock());
            this.world.addBlockEvent(this.pos, this.getBlockState().getBlock(), 1, this.openCount);
            if (this.openCount == 1)
            {
                this.world.playSound((EntityPlayer) null, this.pos, SoundEvents.BLOCK_SHULKER_BOX_OPEN, SoundCategory.BLOCKS, 0.5F,
                        this.world.rand.nextFloat() * 0.1F + 0.9F);
            }
        }
    }

    @Override
    public void closeInventory(EntityPlayer player)
    {
        if (!player.isSpectator())
        {
            --this.openCount;
            this.world.addBlockEvent(this.pos, this.getBlockState().getBlock(), 1, this.openCount);
            if (this.openCount <= 0)
            {
                this.world.playSound((EntityPlayer) null, this.pos, SoundEvents.BLOCK_SHULKER_BOX_CLOSE, SoundCategory.BLOCKS, 0.5F,
                        this.world.rand.nextFloat() * 0.1F + 0.9F);
            }
        }
    }

    @Override
    public ITextComponent getName()
    {
        ITextComponent itextcomponent = this.getCustomName();
        return (ITextComponent) (itextcomponent != null ? itextcomponent : new TextComponentTranslation("container.shulkerBox", new Object[0]));
    }

    @Override
    public void read(NBTTagCompound compound)
    {
        super.read(compound);
        this.loadFromNbt(compound);
    }

    @Override
    public NBTTagCompound write(NBTTagCompound compound)
    {
        super.write(compound);
        return this.saveToNbt(compound);
    }

    public void loadFromNbt(NBTTagCompound compound)
    {
        this.items = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        if (!this.checkLootAndRead(compound) && compound.contains("Items", 9))
        {
            ItemStackHelper.loadAllItems(compound, this.items);
        }

        if (compound.contains("CustomName", 8))
        {
            this.customName = ITextComponent.Serializer.fromJson(compound.getString("CustomName"));
        }

    }

    public NBTTagCompound saveToNbt(NBTTagCompound compound)
    {
        if (!this.checkLootAndWrite(compound))
        {
            ItemStackHelper.saveAllItems(compound, this.items, false);
        }

        ITextComponent itextcomponent = this.getCustomName();
        if (itextcomponent != null)
        {
            compound.putString("CustomName", ITextComponent.Serializer.toJson(itextcomponent));
        }

        if (!compound.contains("Lock") && this.isLocked())
        {
            this.getLockCode().write(compound);
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
    public int[] getSlotsForFace(EnumFacing side)
    {
        return SLOTS;
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side.
     */
    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, @Nullable EnumFacing direction)
    {
        return !(Block.getBlockFromItem(itemStackIn.getItem()) instanceof BlockShulkerBox) && !(Block
                .getBlockFromItem(itemStackIn.getItem()) instanceof net.minecraft.block.BlockShulkerBox);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side.
     */
    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction)
    {
        return true;
    }

    @Override
    public void clear()
    {
        this.hasBeenCleared = true;
        super.clear();
    }

    public boolean isCleared()
    {
        return this.hasBeenCleared;
    }

    public float getProgress(float p_190585_1_)
    {
        return this.progressOld + (this.progress - this.progressOld) * p_190585_1_;
    }

    @OnlyIn(Dist.CLIENT)
    public EnumDyeColor getColor()
    {
        if (this.needsColorFromWorld)
        {
            this.color = BlockShulkerBox.getColorFromBlock(this.getBlockState().getBlock());
            this.needsColorFromWorld = false;
        }
        return this.color;
    }

    /**
     * Retrieves packet to send to the client whenever this Tile Entity is resynced via World.notifyBlockUpdate. For
     * modded TE's, this packet comes back to you clientside in {@link #onDataPacket}
     */
    @Override
    @Nullable
    public SPacketUpdateTileEntity getUpdatePacket()
    {
        return new SPacketUpdateTileEntity(this.pos, 10, this.getUpdateTag());
    }

    public boolean isDestroyedByCreativePlayer()
    {
        return this.destroyedByCreativePlayer;
    }

    public void setDestroyedByCreativePlayer(boolean p_190579_1_)
    {
        this.destroyedByCreativePlayer = p_190579_1_;
    }

    public boolean shouldDrop()
    {
        return !this.isDestroyedByCreativePlayer() || !this.isEmpty() || this.hasCustomName() || this.lootTable != null;
    }

    @Override
    protected net.minecraftforge.items.IItemHandler createUnSidedHandler()
    {
        return new net.minecraftforge.items.wrapper.SidedInvWrapper(this, EnumFacing.UP);
    }

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        this.fillWithLoot(playerIn);

        return new ContainerIronShulkerBox(playerInventory, this, this.shulkerBoxType, playerIn, this.shulkerBoxType.xSize, this.shulkerBoxType.ySize);
    }

    @Override
    public String getGuiID()
    {
        return "IronShulkerBox:" + this.getShulkerBoxType().name() + "_shulker_box";
    }

    public IronShulkerBoxType getShulkerBoxType()
    {
        IronShulkerBoxType type = IronShulkerBoxType.IRON;

        if (this.hasWorld())
        {
            IronShulkerBoxType typeNew = BlockShulkerBox.getTypeFromBlock(this.getBlockState().getBlock());

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

    public static enum AnimationStatus
    {
        CLOSED,
        OPENING,
        OPENED,
        CLOSING;
    }
}
