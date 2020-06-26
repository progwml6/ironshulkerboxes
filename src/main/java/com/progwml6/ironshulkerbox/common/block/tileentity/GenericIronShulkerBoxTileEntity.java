package com.progwml6.ironshulkerbox.common.block.tileentity;

import com.progwml6.ironshulkerbox.common.block.GenericIronShulkerBlock;
import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import com.progwml6.ironshulkerbox.common.inventory.IronShulkerBoxContainer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShulkerBoxBlock;
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
import net.minecraft.tileentity.ShulkerBoxTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.IntStream;

public class GenericIronShulkerBoxTileEntity extends LockableLootTileEntity implements ISidedInventory, ITickableTileEntity {

  private final int[] SLOTS;
  private NonNullList<ItemStack> items;
  private int openCount;
  private GenericIronShulkerBoxTileEntity.AnimationStatus animationStatus = GenericIronShulkerBoxTileEntity.AnimationStatus.CLOSED;
  private float progress;
  private float progressOld;
  private DyeColor color;
  private final List<Block> blocksToUse;
  private boolean needsColorFromWorld;

  public GenericIronShulkerBoxTileEntity(TileEntityType<?> typeIn, @Nullable DyeColor colorIn, IronShulkerBoxesTypes shulkerBoxTypeIn, List<Block> blockListIn) {
    super(typeIn);

    this.SLOTS = IntStream.range(0, shulkerBoxTypeIn.size).toArray();
    this.items = NonNullList.<ItemStack>withSize(shulkerBoxTypeIn.size, ItemStack.EMPTY);

    this.color = colorIn;
    this.blocksToUse = blockListIn;

    if (colorIn == null) {
      this.needsColorFromWorld = true;
    }
  }

  @Override
  public void tick() {
    this.updateAnimation();

    if (this.animationStatus == GenericIronShulkerBoxTileEntity.AnimationStatus.OPENING || this.animationStatus == GenericIronShulkerBoxTileEntity.AnimationStatus.CLOSING) {
      this.moveCollidedEntities();
    }
  }

  protected void updateAnimation() {
    this.progressOld = this.progress;

    switch (this.animationStatus) {
      case CLOSED:
        this.progress = 0.0F;

        break;
      case OPENING:
        this.progress += 0.1F;

        if (this.progress >= 1.0F) {
          this.moveCollidedEntities();
          this.animationStatus = GenericIronShulkerBoxTileEntity.AnimationStatus.OPENED;
          this.progress = 1.0F;
          this.updateNeighbors();
        }

        break;
      case CLOSING:
        this.progress -= 0.1F;

        if (this.progress <= 0.0F) {
          this.animationStatus = GenericIronShulkerBoxTileEntity.AnimationStatus.CLOSED;
          this.progress = 0.0F;
          this.updateNeighbors();
        }

        break;
      case OPENED:
        this.progress = 1.0F;
    }
  }

  public GenericIronShulkerBoxTileEntity.AnimationStatus getAnimationStatus() {
    return this.animationStatus;
  }

  public AxisAlignedBB getBoundingBox(BlockState blockState) {
    return this.getBoundingBox(blockState.get(GenericIronShulkerBlock.FACING));
  }

  public AxisAlignedBB getBoundingBox(Direction directionIn) {
    float f = this.getProgress(1.0F);

    return VoxelShapes.fullCube().getBoundingBox().expand((double) (0.5F * f * (float) directionIn.getXOffset()), (double) (0.5F * f * (float) directionIn.getYOffset()), (double) (0.5F * f * (float) directionIn.getZOffset()));
  }

  private AxisAlignedBB getTopBoundingBox(Direction directionIn) {
    Direction direction = directionIn.getOpposite();
    return this.getBoundingBox(directionIn).contract((double) direction.getXOffset(), (double) direction.getYOffset(), (double) direction.getZOffset());
  }

  private void moveCollidedEntities() {
    BlockState blockstate = this.world.getBlockState(this.getPos());

    if (blockstate.getBlock() instanceof GenericIronShulkerBlock) {
      Direction direction = blockstate.get(GenericIronShulkerBlock.FACING);
      AxisAlignedBB axisalignedbb = this.getTopBoundingBox(direction).offset(this.pos);
      List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity((Entity) null, axisalignedbb);

      if (!list.isEmpty()) {
        for (Entity entity : list) {
          if (entity.getPushReaction() != PushReaction.IGNORE) {
            double d0 = 0.0D;
            double d1 = 0.0D;
            double d2 = 0.0D;
            AxisAlignedBB boundingBox = entity.getBoundingBox();

            switch (direction.getAxis()) {
              case X:
                if (direction.getAxisDirection() == Direction.AxisDirection.POSITIVE) {
                  d0 = axisalignedbb.maxX - boundingBox.minX;
                }
                else {
                  d0 = boundingBox.maxX - axisalignedbb.minX;
                }

                d0 = d0 + 0.01D;

                break;
              case Y:
                if (direction.getAxisDirection() == Direction.AxisDirection.POSITIVE) {
                  d1 = axisalignedbb.maxY - boundingBox.minY;
                }
                else {
                  d1 = boundingBox.maxY - axisalignedbb.minY;
                }

                d1 = d1 + 0.01D;

                break;
              case Z:
                if (direction.getAxisDirection() == Direction.AxisDirection.POSITIVE) {
                  d2 = axisalignedbb.maxZ - boundingBox.minZ;
                }
                else {
                  d2 = boundingBox.maxZ - axisalignedbb.minZ;
                }

                d2 = d2 + 0.01D;
            }

            entity.move(MoverType.SHULKER_BOX, new Vector3d(d0 * (double) direction.getXOffset(), d1 * (double) direction.getYOffset(), d2 * (double) direction.getZOffset()));
          }
        }
      }
    }
  }

  @Override
  public int getSizeInventory() {
    return this.items.size();
  }

  @Override
  public boolean receiveClientEvent(int id, int type) {
    if (id == 1) {
      this.openCount = type;

      if (type == 0) {
        this.animationStatus = GenericIronShulkerBoxTileEntity.AnimationStatus.CLOSING;
        this.updateNeighbors();
      }

      if (type == 1) {
        this.animationStatus = GenericIronShulkerBoxTileEntity.AnimationStatus.OPENING;
        this.updateNeighbors();
      }

      return true;
    }
    else {
      return super.receiveClientEvent(id, type);
    }
  }

  private void updateNeighbors() {
    this.getBlockState().func_235734_a_(this.getWorld(), this.getPos(), 3);
  }

  @Override
  public void openInventory(PlayerEntity player) {
    if (!player.isSpectator()) {
      if (this.openCount < 0) {
        this.openCount = 0;
      }

      ++this.openCount;
      this.world.addBlockEvent(this.pos, this.getBlockState().getBlock(), 1, this.openCount);

      if (this.openCount == 1) {
        this.world.playSound((PlayerEntity) null, this.pos, SoundEvents.BLOCK_SHULKER_BOX_OPEN, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
      }
    }
  }

  @Override
  public void closeInventory(PlayerEntity player) {
    if (!player.isSpectator()) {
      --this.openCount;
      this.world.addBlockEvent(this.pos, this.getBlockState().getBlock(), 1, this.openCount);

      if (this.openCount <= 0) {
        this.world.playSound((PlayerEntity) null, this.pos, SoundEvents.BLOCK_SHULKER_BOX_CLOSE, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
      }
    }
  }

  @Override
  protected ITextComponent getDefaultName() {
    return new TranslationTextComponent("container.shulkerBox");
  }

  @Override
  public void func_230337_a_(BlockState blockState, CompoundNBT compound) {
    super.func_230337_a_(blockState, compound);

    this.loadFromNbt(compound);
  }

  @Override
  public CompoundNBT write(CompoundNBT compound) {
    super.write(compound);

    return this.saveToNbt(compound);
  }

  public void loadFromNbt(CompoundNBT compound) {
    this.items = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);

    if (!this.checkLootAndRead(compound) && compound.contains("Items", 9)) {
      ItemStackHelper.loadAllItems(compound, this.items);
    }
  }

  public CompoundNBT saveToNbt(CompoundNBT compound) {
    if (!this.checkLootAndWrite(compound)) {
      ItemStackHelper.saveAllItems(compound, this.items, false);
    }

    return compound;
  }

  @Override
  public NonNullList<ItemStack> getItems() {
    return this.items;
  }

  @Override
  public void setItems(NonNullList<ItemStack> itemsIn) {
    this.items = NonNullList.<ItemStack>withSize(this.getShulkerBoxType().size, ItemStack.EMPTY);

    for (int i = 0; i < itemsIn.size(); i++) {
      if (i < this.items.size()) {
        this.getItems().set(i, itemsIn.get(i));
      }
    }
  }

  @Override
  public int[] getSlotsForFace(Direction side) {
    return SLOTS;
  }

  @Override
  public boolean canInsertItem(int index, ItemStack itemStackIn, @Nullable Direction direction) {
    return !(Block.getBlockFromItem(itemStackIn.getItem()) instanceof ShulkerBoxBlock) || !(Block.getBlockFromItem(itemStackIn.getItem()) instanceof GenericIronShulkerBlock);
  }

  @Override
  public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
    return true;
  }

  public float getProgress(float p_190585_1_) {
    return MathHelper.lerp(p_190585_1_, this.progressOld, this.progress);
  }

  @Nullable
  @OnlyIn(Dist.CLIENT)
  public DyeColor getColor() {
    if (this.needsColorFromWorld) {
      this.color = GenericIronShulkerBlock.getColorFromBlock(this.getBlockState().getBlock());
      this.needsColorFromWorld = false;
    }

    return this.color;
  }

  @Override
  protected Container createMenu(int windowId, PlayerInventory playerInventory) {
    return IronShulkerBoxContainer.createIronContainer(windowId, playerInventory, this);
  }

  @Override
  protected net.minecraftforge.items.IItemHandler createUnSidedHandler() {
    return new net.minecraftforge.items.wrapper.SidedInvWrapper(this, Direction.UP);
  }

  public IronShulkerBoxesTypes getShulkerBoxType() {
    IronShulkerBoxesTypes type = IronShulkerBoxesTypes.IRON;

    if (this.hasWorld()) {
      IronShulkerBoxesTypes typeNew = GenericIronShulkerBlock.getTypeFromBlock(this.getBlockState().getBlock());

      if (typeNew != null) {
        type = typeNew;
      }
    }

    return type;
  }

  public Block getBlockToUse() {
    return this.blocksToUse.get(color.getId());
  }

  public boolean isClosed() {
    return this.animationStatus == GenericIronShulkerBoxTileEntity.AnimationStatus.CLOSED;
  }

  public enum AnimationStatus {
    CLOSED,
    OPENING,
    OPENED,
    CLOSING;
  }
}
