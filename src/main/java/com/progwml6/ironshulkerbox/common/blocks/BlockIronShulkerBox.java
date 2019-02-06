package com.progwml6.ironshulkerbox.common.blocks;

import com.progwml6.ironshulkerbox.common.tileentity.TileEntityIronShulkerBox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class BlockIronShulkerBox extends BlockShulkerBox
{
    public BlockIronShulkerBox(EnumDyeColor color, Builder properties)
    {
        super(color, properties, IronShulkerBoxType.IRON);
    }

    @Override
    public TileEntity createTileEntity(IBlockState state, IBlockReader world)
    {
        return new TileEntityIronShulkerBox(this.color);
    }
}
