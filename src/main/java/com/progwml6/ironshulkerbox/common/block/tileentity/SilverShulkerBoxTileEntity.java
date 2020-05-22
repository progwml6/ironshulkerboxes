package com.progwml6.ironshulkerbox.common.block.tileentity;

import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import com.progwml6.ironshulkerbox.common.block.ShulkerBoxesBlocks;
import com.progwml6.ironshulkerbox.common.inventory.IronShulkerBoxContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.DyeColor;

import javax.annotation.Nullable;

public class SilverShulkerBoxTileEntity extends GenericIronShulkerBoxTileEntity {

  public SilverShulkerBoxTileEntity() {
    this(null);
  }

  public SilverShulkerBoxTileEntity(@Nullable DyeColor colorIn) {
    super(IronShulkerBoxesTileEntityTypes.SILVER_SHULKER_BOX.get(), colorIn, IronShulkerBoxesTypes.SILVER, IronShulkerBoxesTileEntityTypes.createBlockList(IronShulkerBoxesTileEntityTypes.createBlockSet(ShulkerBoxesBlocks.SILVER_SHULKER_BOXES)));
  }

  @Override
  protected Container createMenu(int id, PlayerInventory playerInventory) {
    return IronShulkerBoxContainer.createSilverContainer(id, playerInventory, this);
  }
}
