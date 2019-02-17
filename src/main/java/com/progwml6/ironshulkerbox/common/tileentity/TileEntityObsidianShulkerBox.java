package com.progwml6.ironshulkerbox.common.tileentity;

import com.progwml6.ironshulkerbox.client.gui.GUIShulkerBox;
import com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType;
import com.progwml6.ironshulkerbox.common.core.IronShulkerBoxBlocks;
import net.minecraft.item.EnumDyeColor;

import javax.annotation.Nullable;

public class TileEntityObsidianShulkerBox extends TileEntityIronShulkerBox
{
    public TileEntityObsidianShulkerBox()
    {
        this(null);
    }

    public TileEntityObsidianShulkerBox(@Nullable EnumDyeColor colorIn)
    {
        super(IronShulkerBoxEntityType.OBSIDIAN_SHULKER_BOX, colorIn, IronShulkerBoxType.OBSIDIAN, IronShulkerBoxBlocks.obsidianShulkerBoxes);
    }

    @Override
    public String getGuiID()
    {
        return GUIShulkerBox.GUI.OBSIDIAN.getGuiId().toString();
    }
}
