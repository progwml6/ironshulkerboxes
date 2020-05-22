package com.progwml6.ironshulkerbox.common.block;

import com.progwml6.ironshulkerbox.common.block.tileentity.ObsidianShulkerBoxTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class ObsidianShulkerBoxBlock extends GenericIronShulkerBlock {

  public ObsidianShulkerBoxBlock(DyeColor color, Properties properties) {
    super(color, properties, IronShulkerBoxesTypes.OBSIDIAN);
  }

  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return new ObsidianShulkerBoxTileEntity(this.color);
  }
}
