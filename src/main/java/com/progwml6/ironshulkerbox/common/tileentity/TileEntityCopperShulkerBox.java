package com.progwml6.ironshulkerbox.common.tileentity;

import com.progwml6.ironshulkerbox.client.gui.GUIShulkerBox;
import com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType;
import com.progwml6.ironshulkerbox.common.core.IronShulkerBoxBlocks;
import net.minecraft.item.EnumDyeColor;

import javax.annotation.Nullable;

public class TileEntityCopperShulkerBox extends TileEntityIronShulkerBox
{
    public TileEntityCopperShulkerBox()
    {
        this(null);
    }

    public TileEntityCopperShulkerBox(@Nullable EnumDyeColor colorIn)
    {
        super(IronShulkerBoxEntityType.COPPER_SHULKER_BOX, colorIn, IronShulkerBoxType.COPPER, IronShulkerBoxBlocks.copperShulkerBoxes);
    }

    @Override
    public String getGuiID()
    {
        return GUIShulkerBox.GUI.COPPER.getGuiId().toString();
    }
}
