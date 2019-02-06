package com.progwml6.ironshulkerbox.common.gui;

import com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerIronShulkerBox extends Container
{
    private IronShulkerBoxType ironShulkerBoxType;

    private EntityPlayer player;

    private IInventory chest;

    public ContainerIronShulkerBox(IInventory playerInventory, IInventory chestInventory, IronShulkerBoxType ironShulkerBoxType, EntityPlayer player, int xSize, int ySize)
    {
        this.chest = chestInventory;
        this.player = player;
        this.ironShulkerBoxType = ironShulkerBoxType;
        chestInventory.openInventory(this.player);
        this.layoutContainer(playerInventory, chestInventory, ironShulkerBoxType, xSize, ySize);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.chest.isUsableByPlayer(playerIn);
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

    protected void layoutContainer(IInventory playerInventory, IInventory chestInventory, IronShulkerBoxType ironShulkerBoxType, int xSize, int ySize)
    {
        for (int chestRow = 0; chestRow < ironShulkerBoxType.getRowCount(); chestRow++)
        {
            for (int chestCol = 0; chestCol < ironShulkerBoxType.rowLength; chestCol++)
            {
                this.addSlot(new Slot(chestInventory, chestCol + chestRow * ironShulkerBoxType.rowLength, 12 + chestCol * 18, 8 + chestRow * 18));
            }
        }

        int leftCol = (xSize - 162) / 2 + 1;

        for (int playerInvRow = 0; playerInvRow < 3; playerInvRow++)
        {
            for (int playerInvCol = 0; playerInvCol < 9; playerInvCol++)
            {
                this.addSlot(new Slot(playerInventory, playerInvCol + playerInvRow * 9 + 9, leftCol + playerInvCol * 18, ySize - (4 - playerInvRow) * 18 - 10));
            }

        }

        for (int hotbarSlot = 0; hotbarSlot < 9; hotbarSlot++)
        {
            this.addSlot(new Slot(playerInventory, hotbarSlot, leftCol + hotbarSlot * 18, ySize - 24));
        }
    }

    public EntityPlayer getPlayer()
    {
        return this.player;
    }

    @Override
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);
        this.chest.closeInventory(playerIn);
    }

    public IInventory getChestInventory()
    {
        return this.chest;
    }
}