package com.progwml6.ironshulkerbox.common.tileentity;

import com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxType;
import com.progwml6.ironshulkerbox.common.core.IronShulkerBoxBlocks;
import com.progwml6.ironshulkerbox.common.inventory.ShulkerBoxContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.DyeColor;

import javax.annotation.Nullable;

public class SilverShulkerBoxTileEntity extends IronShulkerBoxTileEntity
{
    public SilverShulkerBoxTileEntity()
    {
        this(null);
    }

    public SilverShulkerBoxTileEntity(@Nullable DyeColor colorIn)
    {
        super(ShulkerBoxTileEntityType.SILVER_SHULKER_BOX, colorIn, ShulkerBoxType.SILVER, IronShulkerBoxBlocks.silverShulkerBoxes);
    }

    @Override
    protected Container createMenu(int id, PlayerInventory playerInventory)
    {
        return ShulkerBoxContainer.createSilverContainer(id, playerInventory, this);
    }
}
