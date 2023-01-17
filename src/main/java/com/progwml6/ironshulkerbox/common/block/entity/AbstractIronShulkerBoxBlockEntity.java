package com.progwml6.ironshulkerbox.common.block.entity;

import com.progwml6.ironshulkerbox.common.block.AbstractIronShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.IntStream;

public abstract class AbstractIronShulkerBoxBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {

  private final int[] slots;
  private NonNullList<ItemStack> itemStacks;
  private int openCount;
  private AbstractIronShulkerBoxBlockEntity.AnimationStatus animationStatus = AbstractIronShulkerBoxBlockEntity.AnimationStatus.CLOSED;
  private float progress;
  private float progressOld;
  @Nullable
  private final DyeColor color;
  private final IronShulkerBoxesTypes shulkerBoxType;

  public AbstractIronShulkerBoxBlockEntity(BlockEntityType<?> typeIn, BlockPos blockPos, BlockState blockState, @Nullable DyeColor colorIn, IronShulkerBoxesTypes shulkerBoxTypeIn) {
    super(typeIn, blockPos, blockState);

    this.slots = IntStream.range(0, shulkerBoxTypeIn.size).toArray();
    this.itemStacks = NonNullList.withSize(shulkerBoxTypeIn.size, ItemStack.EMPTY);
    this.color = colorIn;
    this.shulkerBoxType = shulkerBoxTypeIn;
  }

  public AbstractIronShulkerBoxBlockEntity(BlockEntityType<?> typeIn, BlockPos blockPos, BlockState blockState, IronShulkerBoxesTypes shulkerBoxTypeIn) {
    super(typeIn, blockPos, blockState);

    this.slots = IntStream.range(0, shulkerBoxTypeIn.size).toArray();
    this.itemStacks = NonNullList.withSize(shulkerBoxTypeIn.size, ItemStack.EMPTY);
    this.color = AbstractIronShulkerBoxBlock.getColorFromBlock(blockState.getBlock());
    this.shulkerBoxType = shulkerBoxTypeIn;
  }

  public static void tick(Level pLevel, BlockPos pPos, BlockState pState, AbstractIronShulkerBoxBlockEntity pBlockEntity) {
    pBlockEntity.updateAnimation(pLevel, pPos, pState);
  }

  protected void updateAnimation(Level pLevel, BlockPos pPos, BlockState pState) {
    this.progressOld = this.progress;
    switch (this.animationStatus) {
      case CLOSED -> this.progress = 0.0F;
      case OPENING -> {
        this.progress += 0.1F;
        if (this.progress >= 1.0F) {
          this.animationStatus = AnimationStatus.OPENED;
          this.progress = 1.0F;
          doNeighborUpdates(pLevel, pPos, pState);
        }
        this.moveCollidedEntities(pLevel, pPos, pState);
      }
      case CLOSING -> {
        this.progress -= 0.1F;
        if (this.progress <= 0.0F) {
          this.animationStatus = AnimationStatus.CLOSED;
          this.progress = 0.0F;
          doNeighborUpdates(pLevel, pPos, pState);
        }
      }
      case OPENED -> this.progress = 1.0F;
    }
  }

  public AbstractIronShulkerBoxBlockEntity.AnimationStatus getAnimationStatus() {
    return this.animationStatus;
  }

  public AABB getBoundingBox(BlockState pState) {
    return Shulker.getProgressAabb(pState.getValue(AbstractIronShulkerBoxBlock.FACING), 0.5F * this.getProgress(1.0F));
  }

  private void moveCollidedEntities(Level pLevel, BlockPos pPos, BlockState pState) {
    if (pState.getBlock() instanceof AbstractIronShulkerBoxBlock) {
      Direction direction = pState.getValue(AbstractIronShulkerBoxBlock.FACING);
      AABB aabb = Shulker.getProgressDeltaAabb(direction, this.progressOld, this.progress).move(pPos);
      List<Entity> list = pLevel.getEntities(null, aabb);

      if (!list.isEmpty()) {
        for (Entity entity : list) {
          if (entity.getPistonPushReaction() != PushReaction.IGNORE) {
            entity.move(MoverType.SHULKER_BOX, new Vec3((aabb.getXsize() + 0.01D) * (double) direction.getStepX(), (aabb.getYsize() + 0.01D) * (double) direction.getStepY(), (aabb.getZsize() + 0.01D) * (double) direction.getStepZ()));
          }
        }
      }
    }
  }

  /**
   * Returns the number of slots in the inventory.
   */
  @Override
  public int getContainerSize() {
    return this.itemStacks.size();
  }

  @Override
  public boolean triggerEvent(int pId, int pType) {
    if (pId == 1) {
      this.openCount = pType;
      if (pType == 0) {
        this.animationStatus = AbstractIronShulkerBoxBlockEntity.AnimationStatus.CLOSING;
        doNeighborUpdates(this.getLevel(), this.worldPosition, this.getBlockState());
      }

      if (pType == 1) {
        this.animationStatus = AbstractIronShulkerBoxBlockEntity.AnimationStatus.OPENING;
        doNeighborUpdates(this.getLevel(), this.worldPosition, this.getBlockState());
      }

      return true;
    } else {
      return super.triggerEvent(pId, pType);
    }
  }

  private static void doNeighborUpdates(Level pLevel, BlockPos pPos, BlockState pState) {
    pState.updateNeighbourShapes(pLevel, pPos, 3);
  }

  @Override
  public void startOpen(Player pPlayer) {
    if (!this.remove && !pPlayer.isSpectator()) {
      if (this.openCount < 0) {
        this.openCount = 0;
      }

      ++this.openCount;
      this.level.blockEvent(this.worldPosition, this.getBlockState().getBlock(), 1, this.openCount);

      if (this.openCount == 1) {
        this.level.gameEvent(pPlayer, GameEvent.CONTAINER_OPEN, this.worldPosition);
        this.level.playSound(null, this.worldPosition, SoundEvents.SHULKER_BOX_OPEN, SoundSource.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
      }
    }
  }

  @Override
  public void stopOpen(Player pPlayer) {
    if (!this.remove && !pPlayer.isSpectator()) {
      --this.openCount;
      this.level.blockEvent(this.worldPosition, this.getBlockState().getBlock(), 1, this.openCount);

      if (this.openCount <= 0) {
        this.level.gameEvent(pPlayer, GameEvent.CONTAINER_CLOSE, this.worldPosition);
        this.level.playSound((Player) null, this.worldPosition, SoundEvents.SHULKER_BOX_CLOSE, SoundSource.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
      }
    }
  }

  @Override
  protected Component getDefaultName() {
    return Component.translatable("container.shulkerBox");
  }

  @Override
  public void load(CompoundTag pTag) {
    super.load(pTag);
    this.loadFromTag(pTag);
  }

  @Override
  protected void saveAdditional(CompoundTag pTag) {
    super.saveAdditional(pTag);

    if (!this.trySaveLootTable(pTag)) {
      ContainerHelper.saveAllItems(pTag, this.itemStacks, false);
    }
  }

  public void loadFromTag(CompoundTag pTag) {
    this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);

    if (!this.tryLoadLootTable(pTag) && pTag.contains("Items", 9)) {
      ContainerHelper.loadAllItems(pTag, this.itemStacks);
    }
  }

  @Override
  public NonNullList<ItemStack> getItems() {
    return this.itemStacks;
  }

  @Override
  public void setItems(NonNullList<ItemStack> itemsIn) {
    this.itemStacks = NonNullList.withSize(this.getShulkerBoxType().size, ItemStack.EMPTY);

    for (int i = 0; i < itemsIn.size(); i++) {
      if (i < this.itemStacks.size()) {
        this.getItems().set(i, itemsIn.get(i));
      }
    }
  }

  @Override
  public int[] getSlotsForFace(Direction pSide) {
    return this.slots;
  }

  /**
   * Returns {@code true} if automation can insert the given item in the given slot from the given side.
   */
  @Override
  public boolean canPlaceItemThroughFace(int pIndex, ItemStack pItemStack, @Nullable Direction pDirection) {
    return !(Block.byItem(pItemStack.getItem()) instanceof ShulkerBoxBlock) || !(Block.byItem(pItemStack.getItem()) instanceof AbstractIronShulkerBoxBlock);
  }

  /**
   * Returns {@code true} if automation can extract the given item in the given slot from the given side.
   */
  @Override
  public boolean canTakeItemThroughFace(int pIndex, ItemStack pStack, Direction pDirection) {
    return true;
  }

  public float getProgress(float pPartialTicks) {
    return Mth.lerp(pPartialTicks, this.progressOld, this.progress);
  }

  @Nullable
  public DyeColor getColor() {
    return this.color;
  }

  public boolean isClosed() {
    return this.animationStatus == AbstractIronShulkerBoxBlockEntity.AnimationStatus.CLOSED;
  }

  @Override
  protected net.minecraftforge.items.IItemHandler createUnSidedHandler() {
    return new net.minecraftforge.items.wrapper.SidedInvWrapper(this, Direction.UP);
  }

  public IronShulkerBoxesTypes getShulkerBoxType() {
    IronShulkerBoxesTypes type = IronShulkerBoxesTypes.IRON;

    if (this.hasLevel()) {
      IronShulkerBoxesTypes typeNew = AbstractIronShulkerBoxBlock.getTypeFromBlock(this.getBlockState().getBlock());

      if (typeNew != null) {
        type = typeNew;
      }
    }

    return type;
  }

  public abstract Block getBlockToUse();

  public static int getOpenCount(BlockGetter blockGetter, BlockPos blockPos) {
    BlockState blockstate = blockGetter.getBlockState(blockPos);

    if (blockstate.hasBlockEntity()) {
      BlockEntity blockentity = blockGetter.getBlockEntity(blockPos);

      if (blockentity instanceof AbstractIronShulkerBoxBlockEntity) {
        return ((AbstractIronShulkerBoxBlockEntity) blockentity).openCount;
      }
    }

    return 0;
  }

  public static enum AnimationStatus {
    CLOSED,
    OPENING,
    OPENED,
    CLOSING;
  }
}
