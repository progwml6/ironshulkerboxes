package com.progwml6.ironshulkerbox.common.tileentity;

import com.progwml6.ironshulkerbox.client.gui.GUIShulkerBox;
import com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType;
import com.progwml6.ironshulkerbox.common.core.IronShulkerBoxBlocks;
import net.minecraft.item.EnumDyeColor;

import javax.annotation.Nullable;

public class TileEntitySilverShulkerBox extends TileEntityIronShulkerBox
{
    public TileEntitySilverShulkerBox()
    {
        this(null);
    }

    public TileEntitySilverShulkerBox(@Nullable EnumDyeColor colorIn)
    {
        super(IronShulkerBoxEntityType.SILVER_SHULKER_BOX, colorIn, IronShulkerBoxType.SILVER, IronShulkerBoxBlocks.silverShulkerBoxes);
    }

    @Override
    public String getGuiID()
    {
        return GUIShulkerBox.GUI.SILVER.getGuiId().toString();
    }
}
