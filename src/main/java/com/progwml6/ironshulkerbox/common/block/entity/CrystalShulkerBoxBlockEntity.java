package com.progwml6.ironshulkerbox.common.block.entity;

import com.google.common.collect.ImmutableSet;
import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import com.progwml6.ironshulkerbox.common.inventory.IronShulkerBoxMenu;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesBlockEntityTypes;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class CrystalShulkerBoxBlockEntity extends AbstractIronShulkerBoxBlockEntity implements ICrystalShulkerBox {

  private NonNullList<ItemStack> topStacks;
  private boolean inventoryTouched;
  private boolean hadStuff;

  public CrystalShulkerBoxBlockEntity(BlockPos pPos, BlockState pState) {
    super(IronShulkerBoxesBlockEntityTypes.CRYSTAL_SHULKER_BOX.get(), pPos, pState, IronShulkerBoxesTypes.CRYSTAL);

    this.topStacks = NonNullList.withSize(8, ItemStack.EMPTY);
  }

  public CrystalShulkerBoxBlockEntity(@Nullable DyeColor pColor, BlockPos blockPos, BlockState blockState) {
    super(IronShulkerBoxesBlockEntityTypes.CRYSTAL_SHULKER_BOX.get(), blockPos, blockState, pColor, IronShulkerBoxesTypes.CRYSTAL);

    this.topStacks = NonNullList.withSize(8, ItemStack.EMPTY);
  }

  @Override
  protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
    return IronShulkerBoxMenu.createCrystalContainer(pContainerId, pInventory, this);
  }

  public static void tick(Level pLevel, BlockPos pPos, BlockState pState, AbstractIronShulkerBoxBlockEntity pBlockEntity) {
    pBlockEntity.updateAnimation(pLevel, pPos, pState);

    if (pBlockEntity instanceof CrystalShulkerBoxBlockEntity crystalShulkerBoxBlockEntity) {
      if (!pLevel.isClientSide && crystalShulkerBoxBlockEntity.inventoryTouched) {
        crystalShulkerBoxBlockEntity.inventoryTouched = false;

        crystalShulkerBoxBlockEntity.sortTopStacks();
      }
    }
  }

  @Override
  public void setItems(NonNullList<ItemStack> contents) {
    super.setItems(contents);

    this.inventoryTouched = true;
  }

  @Override
  public ItemStack getItem(int index) {
    this.inventoryTouched = true;

    return super.getItem(index);
  }

  @Override
  public NonNullList<ItemStack> getTopItems() {
    return this.topStacks;
  }

  @Override
  public Level getChestLevel() {
    return this.level;
  }

  @Override
  public BlockPos getChestWorldPosition() {
    return this.worldPosition;
  }

  @Override
  public void receiveMessageFromServer(NonNullList<ItemStack> topStacks) {
    this.topStacks = topStacks;
  }

  @Override
  public void setHadStuff(boolean hadStuff) {
    this.hadStuff = hadStuff;
  }

  @Override
  public boolean getHadStuff() {
    return this.hadStuff;
  }

  @Override
  public NonNullList<ItemStack> getCurrentItems() {
    return this.getItems();
  }

  @Override
  public Block getBlockToUse() {
    if (this.getColor() == null) {
      return IronShulkerBoxesBlocks.CRYSTAL_SHULKER_BOX.get();
    } else {
      return IronShulkerBoxesBlocks.CRYSTAL_SHULKER_BOXES.get(this.getColor()).get();
    }
  }

  public static void buildBlocks(ImmutableSet.Builder<Block> builder) {
    builder.add(IronShulkerBoxesBlocks.CRYSTAL_SHULKER_BOX.get());
    IronShulkerBoxesBlocks.CRYSTAL_SHULKER_BOXES.forEach((dyeColor, block) -> builder.add(block.get()));
  }
}
