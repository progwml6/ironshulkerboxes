package com.progwml6.ironshulkerbox.common.tileentity;

import com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType;
import com.progwml6.ironshulkerbox.common.core.IronShulkerBoxBlocks;
import net.minecraft.item.EnumDyeColor;

import javax.annotation.Nullable;

public class TileEntityGoldShulkerBox extends TileEntityIronShulkerBox
{
    public TileEntityGoldShulkerBox()
    {
        this(null);
    }

    public TileEntityGoldShulkerBox(@Nullable EnumDyeColor colorIn)
    {
        super(IronShulkerBoxEntityType.GOLD_SHULKER_BOX, colorIn, IronShulkerBoxType.GOLD, IronShulkerBoxBlocks.goldShulkerBoxes);
    }
}
