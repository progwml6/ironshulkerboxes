package com.progwml6.ironshulkerbox.common.blocks;

import com.progwml6.ironshulkerbox.common.tileentity.TileEntityDiamondShulkerBox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class BlockDiamondShulkerBox extends BlockShulkerBox
{
    public BlockDiamondShulkerBox(EnumDyeColor color, Builder properties)
    {
        super(color, properties, IronShulkerBoxType.DIAMOND);
    }

    @Override
    public TileEntity createTileEntity(IBlockState state, IBlockReader world)
    {
        return new TileEntityDiamondShulkerBox(this.color);
    }
}
