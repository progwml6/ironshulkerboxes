package com.progwml6.ironshulkerbox.common.tileentity;

import com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxType;
import com.progwml6.ironshulkerbox.common.core.IronShulkerBoxBlocks;
import com.progwml6.ironshulkerbox.common.inventory.ShulkerBoxContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.DyeColor;

import javax.annotation.Nullable;

public class DiamondShulkerBoxTileEntity extends IronShulkerBoxTileEntity
{
    public DiamondShulkerBoxTileEntity()
    {
        this(null);
    }

    public DiamondShulkerBoxTileEntity(@Nullable DyeColor colorIn)
    {
        super(ShulkerBoxTileEntityType.DIAMOND_SHULKER_BOX, colorIn, ShulkerBoxType.DIAMOND, IronShulkerBoxBlocks.diamondShulkerBoxes);
    }

    @Override
    protected Container createMenu(int id, PlayerInventory playerInventory)
    {
        return ShulkerBoxContainer.createDiamondContainer(id, playerInventory, this);
    }
}
