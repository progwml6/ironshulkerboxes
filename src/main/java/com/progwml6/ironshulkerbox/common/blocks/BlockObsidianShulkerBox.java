package com.progwml6.ironshulkerbox.common.blocks;

import com.progwml6.ironshulkerbox.common.tileentity.TileEntityObsidianShulkerBox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class BlockObsidianShulkerBox extends BlockShulkerBox
{
    public BlockObsidianShulkerBox(EnumDyeColor color, Builder properties)
    {
        super(color, properties, IronShulkerBoxType.OBSIDIAN);
    }

    @Override
    public TileEntity createTileEntity(IBlockState state, IBlockReader world)
    {
        return new TileEntityObsidianShulkerBox(this.color);
    }
}
