package com.progwml6.ironshulkerbox.common.blocks;

import com.progwml6.ironshulkerbox.common.tileentity.GoldShulkerBoxTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class GoldShulkerBoxBlock extends ShulkerBoxBlock
{
    public GoldShulkerBoxBlock(DyeColor color, Properties properties)
    {
        super(color, properties, ShulkerBoxType.GOLD);
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
        return new GoldShulkerBoxTileEntity(this.color);
    }
}
