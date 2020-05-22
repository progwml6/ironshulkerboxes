package com.progwml6.ironshulkerbox.common.block.tileentity;

import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import com.progwml6.ironshulkerbox.common.block.ShulkerBoxesBlocks;
import com.progwml6.ironshulkerbox.common.inventory.IronShulkerBoxContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.DyeColor;

import javax.annotation.Nullable;

public class CopperShulkerBoxTileEntity extends GenericIronShulkerBoxTileEntity {

  public CopperShulkerBoxTileEntity() {
    this(null);
  }

  public CopperShulkerBoxTileEntity(@Nullable DyeColor colorIn) {
    super(IronShulkerBoxesTileEntityTypes.COPPER_SHULKER_BOX.get(), colorIn, IronShulkerBoxesTypes.COPPER, IronShulkerBoxesTileEntityTypes.createBlockList(IronShulkerBoxesTileEntityTypes.createBlockSet(ShulkerBoxesBlocks.COPPER_SHULKER_BOXES)));
  }

  @Override
  protected Container createMenu(int id, PlayerInventory playerInventory) {
    return IronShulkerBoxContainer.createCopperContainer(id, playerInventory, this);
  }
}
