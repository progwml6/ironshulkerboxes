package com.progwml6.ironshulkerbox.common.block.entity;

import com.google.common.collect.ImmutableSet;
import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import com.progwml6.ironshulkerbox.common.inventory.IronShulkerBoxMenu;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesBlockEntityTypes;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class DiamondShulkerBoxBlockEntity extends AbstractIronShulkerBoxBlockEntity {

  public DiamondShulkerBoxBlockEntity(BlockPos pPos, BlockState pState) {
    super(IronShulkerBoxesBlockEntityTypes.DIAMOND_SHULKER_BOX.get(), pPos, pState, IronShulkerBoxesTypes.DIAMOND);
  }

  public DiamondShulkerBoxBlockEntity(@Nullable DyeColor pColor, BlockPos blockPos, BlockState blockState) {
    super(IronShulkerBoxesBlockEntityTypes.DIAMOND_SHULKER_BOX.get(), blockPos, blockState, pColor, IronShulkerBoxesTypes.DIAMOND);
  }

  @Override
  protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
    return IronShulkerBoxMenu.createDiamondContainer(pContainerId, pInventory, this);
  }

  @Override
  public Block getBlockToUse() {
    if (this.getColor() == null) {
      return IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOX.get();
    } else {
      return IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOXES.get(this.getColor()).get();
    }
  }

  public static void buildBlocks(ImmutableSet.Builder<Block> builder) {
    builder.add(IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOX.get());
    IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOXES.forEach((dyeColor, block) -> builder.add(block.get()));
  }
}
