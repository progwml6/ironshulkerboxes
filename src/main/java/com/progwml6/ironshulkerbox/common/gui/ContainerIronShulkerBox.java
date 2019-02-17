package com.progwml6.ironshulkerbox.common.gui;

import com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType;
import com.progwml6.ironshulkerbox.common.gui.slot.SlotShulkerBox;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerIronShulkerBox extends Container
{
    private IronShulkerBoxType ironShulkerBoxType;

    private IInventory inventory;

    public ContainerIronShulkerBox(IInventory playerInventoryIn, IInventory inventoryIn, IronShulkerBoxType ironShulkerBoxTypeIn, EntityPlayer playerIn, int xSizeIn, int ySizeIn)
    {
        this.ironShulkerBoxType = ironShulkerBoxTypeIn;
        this.inventory = inventoryIn;

        inventoryIn.openInventory(playerIn);

        for (int shulkerBoxRow = 0; shulkerBoxRow < ironShulkerBoxTypeIn.getRowCount(); shulkerBoxRow++)
        {
            for (int shulkerBoxCol = 0; shulkerBoxCol < ironShulkerBoxTypeIn.rowLength; shulkerBoxCol++)
            {
                this.addSlot(new SlotShulkerBox(inventoryIn, shulkerBoxCol + shulkerBoxRow * ironShulkerBoxTypeIn.rowLength, 12 + shulkerBoxCol * 18, 8 + shulkerBoxRow * 18));
            }
        }

        int leftCol = (xSizeIn - 162) / 2 + 1;

        for (int playerInvRow = 0; playerInvRow < 3; playerInvRow++)
        {
            for (int playerInvCol = 0; playerInvCol < 9; playerInvCol++)
            {
                this.addSlot(new Slot(playerInventoryIn, playerInvCol + playerInvRow * 9 + 9, leftCol + playerInvCol * 18, ySizeIn - (4 - playerInvRow) * 18 - 10));
            }

        }

        for (int hotbarSlot = 0; hotbarSlot < 9; hotbarSlot++)
        {
            this.addSlot(new Slot(playerInventoryIn, hotbarSlot, leftCol + hotbarSlot * 18, ySizeIn - 24));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.inventory.isUsableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            if (index < this.ironShulkerBoxType.size)
            {
                if (!this.mergeItemStack(itemStack1, this.ironShulkerBoxType.size, this.inventorySlots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemStack1, 0, this.ironShulkerBoxType.size, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemStack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemStack;
    }

    @Override
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);
        this.inventory.closeInventory(playerIn);
    }
}