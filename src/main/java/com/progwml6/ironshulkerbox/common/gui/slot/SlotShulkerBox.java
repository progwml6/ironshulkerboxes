package com.progwml6.ironshulkerbox.common.gui.slot;

import com.progwml6.ironshulkerbox.common.blocks.BlockShulkerBox;
import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotShulkerBox extends Slot
{
    public SlotShulkerBox(IInventory inventoryIn, int slotIndexIn, int xPosition, int yPosition)
    {
        super(inventoryIn, slotIndexIn, xPosition, yPosition);
    }

    /**
     * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
     */
    @Override
    public boolean isItemValid(ItemStack stack)
    {
        return !(Block.getBlockFromItem(stack.getItem()) instanceof BlockShulkerBox) && !(Block.getBlockFromItem(stack.getItem()) instanceof net.minecraft.block.BlockShulkerBox);
    }
}
