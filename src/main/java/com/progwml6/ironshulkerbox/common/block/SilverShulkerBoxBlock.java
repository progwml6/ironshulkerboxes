package com.progwml6.ironshulkerbox.common.block;

import com.progwml6.ironshulkerbox.common.block.tileentity.SilverShulkerBoxTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class SilverShulkerBoxBlock extends GenericIronShulkerBlock {

  public SilverShulkerBoxBlock(DyeColor color, Properties properties) {
    super(color, properties, IronShulkerBoxesTypes.SILVER);
  }

  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return new SilverShulkerBoxTileEntity(this.color);
  }
}
