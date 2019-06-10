package com.progwml6.ironshulkerbox.common.tileentity;

import com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxType;
import com.progwml6.ironshulkerbox.common.core.IronShulkerBoxBlocks;
import com.progwml6.ironshulkerbox.common.inventory.ShulkerBoxContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.DyeColor;

import javax.annotation.Nullable;

public class CopperShulkerBoxTileEntity extends IronShulkerBoxTileEntity
{
    public CopperShulkerBoxTileEntity()
    {
        this(null);
    }

    public CopperShulkerBoxTileEntity(@Nullable DyeColor colorIn)
    {
        super(ShulkerBoxTileEntityType.COPPER_SHULKER_BOX, colorIn, ShulkerBoxType.COPPER, IronShulkerBoxBlocks.copperShulkerBoxes);
    }

    @Override
    protected Container createMenu(int id, PlayerInventory playerInventory)
    {
        return ShulkerBoxContainer.createCopperContainer(id, playerInventory, this);
    }
}
