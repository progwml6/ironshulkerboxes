package com.progwml6.ironshulkerbox.common.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemShulkerBox extends ItemBlock
{
    public ItemShulkerBox(Block block, Builder builder)
    {
        super(block, builder);

        this.setRegistryName(block.getRegistryName());
    }
}
