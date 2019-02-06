package com.progwml6.ironshulkerbox.common.blocks;

import com.progwml6.ironshulkerbox.common.tileentity.TileEntityGoldShulkerBox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class BlockGoldShulkerBox extends BlockShulkerBox
{
    public BlockGoldShulkerBox(EnumDyeColor color, Builder properties)
    {
        super(color, properties, IronShulkerBoxType.GOLD);
    }

    @Override
    public TileEntity createTileEntity(IBlockState state, IBlockReader world)
    {
        return new TileEntityGoldShulkerBox(this.color);
    }
}
