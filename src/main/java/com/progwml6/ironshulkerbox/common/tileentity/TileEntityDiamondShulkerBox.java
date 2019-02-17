package com.progwml6.ironshulkerbox.common.tileentity;

import com.progwml6.ironshulkerbox.client.gui.GUIShulkerBox;
import com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType;
import com.progwml6.ironshulkerbox.common.core.IronShulkerBoxBlocks;
import net.minecraft.item.EnumDyeColor;

import javax.annotation.Nullable;

public class TileEntityDiamondShulkerBox extends TileEntityIronShulkerBox
{
    public TileEntityDiamondShulkerBox()
    {
        this(null);
    }

    public TileEntityDiamondShulkerBox(@Nullable EnumDyeColor colorIn)
    {
        super(IronShulkerBoxEntityType.DIAMOND_SHULKER_BOX, colorIn, IronShulkerBoxType.DIAMOND, IronShulkerBoxBlocks.diamondShulkerBoxes);
    }

    @Override
    public String getGuiID()
    {
        return GUIShulkerBox.GUI.DIAMOND.getGuiId().toString();
    }
}
