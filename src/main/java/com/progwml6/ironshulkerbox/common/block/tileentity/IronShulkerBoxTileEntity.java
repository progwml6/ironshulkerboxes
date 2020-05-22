package com.progwml6.ironshulkerbox.common.block.tileentity;

import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import com.progwml6.ironshulkerbox.common.block.ShulkerBoxesBlocks;
import com.progwml6.ironshulkerbox.common.inventory.IronShulkerBoxContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.DyeColor;

import javax.annotation.Nullable;

public class IronShulkerBoxTileEntity extends GenericIronShulkerBoxTileEntity {

  public IronShulkerBoxTileEntity() {
    this(null);
  }

  public IronShulkerBoxTileEntity(@Nullable DyeColor colorIn) {
    super(IronShulkerBoxesTileEntityTypes.IRON_SHULKER_BOX.get(), colorIn, IronShulkerBoxesTypes.IRON,
      IronShulkerBoxesTileEntityTypes.createBlockList(IronShulkerBoxesTileEntityTypes.createBlockSet(ShulkerBoxesBlocks.IRON_SHULKER_BOXES)));
  }

  @Override
  protected Container createMenu(int id, PlayerInventory playerInventory) {
    return IronShulkerBoxContainer.createIronContainer(id, playerInventory, this);
  }
}
