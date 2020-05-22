package com.progwml6.ironshulkerbox.common.block.tileentity;

import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import com.progwml6.ironshulkerbox.common.block.ShulkerBoxesBlocks;
import com.progwml6.ironshulkerbox.common.inventory.IronShulkerBoxContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.DyeColor;

import javax.annotation.Nullable;

public class GoldShulkerBoxTileEntity extends GenericIronShulkerBoxTileEntity {

  public GoldShulkerBoxTileEntity() {
    this(null);
  }

  public GoldShulkerBoxTileEntity(@Nullable DyeColor colorIn) {
    super(IronShulkerBoxesTileEntityTypes.GOLD_SHULKER_BOX.get(), colorIn, IronShulkerBoxesTypes.GOLD, IronShulkerBoxesTileEntityTypes.createBlockList(IronShulkerBoxesTileEntityTypes.createBlockSet(ShulkerBoxesBlocks.GOLD_SHULKER_BOXES)));
  }

  @Override
  protected Container createMenu(int id, PlayerInventory playerInventory) {
    return IronShulkerBoxContainer.createGoldContainer(id, playerInventory, this);
  }
}
