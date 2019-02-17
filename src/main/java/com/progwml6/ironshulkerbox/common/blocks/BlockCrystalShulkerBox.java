package com.progwml6.ironshulkerbox.common.blocks;

import com.progwml6.ironshulkerbox.common.tileentity.TileEntityCrystalShulkerBox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class BlockCrystalShulkerBox extends BlockShulkerBox
{
    public BlockCrystalShulkerBox(EnumDyeColor color, Properties properties)
    {
        super(color, properties, IronShulkerBoxType.CRYSTAL);
    }

    @Override
    public TileEntity createTileEntity(IBlockState state, IBlockReader world)
    {
        return new TileEntityCrystalShulkerBox(this.color);
    }
}
