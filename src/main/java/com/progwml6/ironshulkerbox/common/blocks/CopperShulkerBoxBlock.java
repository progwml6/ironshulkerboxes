package com.progwml6.ironshulkerbox.common.blocks;

import com.progwml6.ironshulkerbox.common.tileentity.CopperShulkerBoxTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class CopperShulkerBoxBlock extends ShulkerBoxBlock
{
    public CopperShulkerBoxBlock(DyeColor color, Properties properties)
    {
        super(color, properties, ShulkerBoxType.COPPER);
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
        return new CopperShulkerBoxTileEntity(this.color);
    }
}
