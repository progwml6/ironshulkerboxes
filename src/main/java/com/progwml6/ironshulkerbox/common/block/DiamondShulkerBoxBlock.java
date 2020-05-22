package com.progwml6.ironshulkerbox.common.block;

import com.progwml6.ironshulkerbox.common.block.tileentity.DiamondShulkerBoxTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class DiamondShulkerBoxBlock extends GenericIronShulkerBlock {

  public DiamondShulkerBoxBlock(DyeColor color, Properties properties) {
    super(color, properties, IronShulkerBoxesTypes.DIAMOND);
  }

  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return new DiamondShulkerBoxTileEntity(this.color);
  }
}
