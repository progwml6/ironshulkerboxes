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

public class ObsidianShulkerBoxBlockEntity extends AbstractIronShulkerBoxBlockEntity {

  public ObsidianShulkerBoxBlockEntity(BlockPos pPos, BlockState pState) {
    super(IronShulkerBoxesBlockEntityTypes.OBSIDIAN_SHULKER_BOX.get(), pPos, pState, IronShulkerBoxesTypes.OBSIDIAN);
  }

  public ObsidianShulkerBoxBlockEntity(@Nullable DyeColor pColor, BlockPos blockPos, BlockState blockState) {
    super(IronShulkerBoxesBlockEntityTypes.OBSIDIAN_SHULKER_BOX.get(), blockPos, blockState, pColor, IronShulkerBoxesTypes.OBSIDIAN);
  }

  @Override
  protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
    return IronShulkerBoxMenu.createObsidianContainer(pContainerId, pInventory, this);
  }

  @Override
  public Block getBlockToUse() {
    if (this.getColor() == null) {
      return IronShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOX.get();
    } else {
      return IronShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOXES.get(this.getColor()).get();
    }
  }

  public static void buildBlocks(ImmutableSet.Builder<Block> builder) {
    builder.add(IronShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOX.get());
    IronShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOXES.forEach((dyeColor, block) -> builder.add(block.get()));
  }
}
