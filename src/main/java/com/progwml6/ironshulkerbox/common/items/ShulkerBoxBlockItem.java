package com.progwml6.ironshulkerbox.common.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class ShulkerBoxBlockItem extends BlockItem
{
    public ShulkerBoxBlockItem(Block blockIn, Properties propertiesIn)
    {
        super(blockIn, propertiesIn);

        this.setRegistryName(blockIn.getRegistryName());
    }
}
