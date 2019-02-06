package com.progwml6.ironshulkerbox.common.blocks;

import com.progwml6.ironshulkerbox.common.tileentity.TileEntitySilverShulkerBox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class BlockSilverShulkerBox extends BlockShulkerBox
{
    public BlockSilverShulkerBox(EnumDyeColor color, Builder properties)
    {
        super(color, properties, IronShulkerBoxType.SILVER);
    }

    @Override
    public TileEntity createTileEntity(IBlockState state, IBlockReader world)
    {
        return new TileEntitySilverShulkerBox(this.color);
    }
}
