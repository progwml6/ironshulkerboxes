package com.progwml6.ironshulkerbox.common.blocks;

import com.progwml6.ironshulkerbox.common.tileentity.CrystalShulkerBoxTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class CrystalShulkerBoxBlock extends ShulkerBoxBlock
{
    public CrystalShulkerBoxBlock(DyeColor color, Properties properties)
    {
        super(color, properties, ShulkerBoxType.CRYSTAL);
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
        return new CrystalShulkerBoxTileEntity(this.color);
    }
}
