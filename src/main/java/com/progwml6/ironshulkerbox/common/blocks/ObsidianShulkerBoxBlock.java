package com.progwml6.ironshulkerbox.common.blocks;

import com.progwml6.ironshulkerbox.common.tileentity.ObsidianShulkerBoxTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class ObsidianShulkerBoxBlock extends ShulkerBoxBlock
{
    public ObsidianShulkerBoxBlock(DyeColor color, Properties properties)
    {
        super(color, properties, ShulkerBoxType.OBSIDIAN);
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
        return new ObsidianShulkerBoxTileEntity(this.color);
    }
}
