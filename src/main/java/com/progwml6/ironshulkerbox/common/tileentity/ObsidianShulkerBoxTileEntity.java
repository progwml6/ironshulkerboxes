package com.progwml6.ironshulkerbox.common.tileentity;

import com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxType;
import com.progwml6.ironshulkerbox.common.core.IronShulkerBoxBlocks;
import com.progwml6.ironshulkerbox.common.inventory.ShulkerBoxContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.DyeColor;

import javax.annotation.Nullable;

public class ObsidianShulkerBoxTileEntity extends IronShulkerBoxTileEntity
{
    public ObsidianShulkerBoxTileEntity()
    {
        this(null);
    }

    public ObsidianShulkerBoxTileEntity(@Nullable DyeColor colorIn)
    {
        super(ShulkerBoxTileEntityType.OBSIDIAN_SHULKER_BOX, colorIn, ShulkerBoxType.OBSIDIAN, IronShulkerBoxBlocks.obsidianShulkerBoxes);
    }

    @Override
    protected Container createMenu(int id, PlayerInventory playerInventory)
    {
        return ShulkerBoxContainer.createObsidianContainer(id, playerInventory, this);
    }
}
