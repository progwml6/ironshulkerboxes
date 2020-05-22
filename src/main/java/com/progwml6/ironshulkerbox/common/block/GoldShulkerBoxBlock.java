package com.progwml6.ironshulkerbox.common.block;

import com.progwml6.ironshulkerbox.common.block.GenericIronShulkerBlock;
import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import com.progwml6.ironshulkerbox.common.block.tileentity.GoldShulkerBoxTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class GoldShulkerBoxBlock extends GenericIronShulkerBlock {

  public GoldShulkerBoxBlock(DyeColor color, Properties properties) {
    super(color, properties, IronShulkerBoxesTypes.GOLD);
  }

  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return new GoldShulkerBoxTileEntity(this.color);
  }
}
