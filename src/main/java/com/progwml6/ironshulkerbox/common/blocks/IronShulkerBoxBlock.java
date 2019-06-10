package com.progwml6.ironshulkerbox.common.blocks;

import com.progwml6.ironshulkerbox.common.tileentity.IronShulkerBoxTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class IronShulkerBoxBlock extends ShulkerBoxBlock
{
    public IronShulkerBoxBlock(DyeColor color, Properties properties)
    {
        super(color, properties, ShulkerBoxType.IRON);
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
        return new IronShulkerBoxTileEntity(this.color);
    }
}
