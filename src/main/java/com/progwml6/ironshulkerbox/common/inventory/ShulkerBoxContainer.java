package com.progwml6.ironshulkerbox.common.inventory;

import com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ShulkerBoxContainer extends Container
{
    private final IInventory inventory;

    private final ShulkerBoxType shulkerBoxType;

    private ShulkerBoxContainer(ContainerType<?> containerType, int windowId, PlayerInventory playerInventory)
    {
        this(containerType, windowId, playerInventory, new Inventory(ShulkerBoxType.VANILLA.size), ShulkerBoxType.VANILLA);
    }

    public static ShulkerBoxContainer createIronContainer(int windowId, PlayerInventory playerInventory)
    {
        return new ShulkerBoxContainer(ShulkerBoxContainerType.IRON_SHULKER_BOX, windowId, playerInventory, new Inventory(ShulkerBoxType.IRON.size), ShulkerBoxType.IRON);
    }

    public static ShulkerBoxContainer createIronContainer(int windowId, PlayerInventory playerInventory, IInventory inventory)
    {
        return new ShulkerBoxContainer(ShulkerBoxContainerType.IRON_SHULKER_BOX, windowId, playerInventory, inventory, ShulkerBoxType.IRON);
    }

    public static ShulkerBoxContainer createGoldContainer(int windowId, PlayerInventory playerInventory)
    {
        return new ShulkerBoxContainer(ShulkerBoxContainerType.GOLD_SHULKER_BOX, windowId, playerInventory, new Inventory(ShulkerBoxType.GOLD.size), ShulkerBoxType.GOLD);
    }

    public static ShulkerBoxContainer createGoldContainer(int windowId, PlayerInventory playerInventory, IInventory inventory)
    {
        return new ShulkerBoxContainer(ShulkerBoxContainerType.GOLD_SHULKER_BOX, windowId, playerInventory, inventory, ShulkerBoxType.GOLD);
    }

    public static ShulkerBoxContainer createDiamondContainer(int windowId, PlayerInventory playerInventory)
    {
        return new ShulkerBoxContainer(ShulkerBoxContainerType.DIAMOND_SHULKER_BOX, windowId, playerInventory, new Inventory(ShulkerBoxType.DIAMOND.size), ShulkerBoxType.DIAMOND);
    }

    public static ShulkerBoxContainer createDiamondContainer(int windowId, PlayerInventory playerInventory, IInventory inventory)
    {
        return new ShulkerBoxContainer(ShulkerBoxContainerType.DIAMOND_SHULKER_BOX, windowId, playerInventory, inventory, ShulkerBoxType.DIAMOND);
    }

    public static ShulkerBoxContainer createCrystalContainer(int windowId, PlayerInventory playerInventory)
    {
        return new ShulkerBoxContainer(ShulkerBoxContainerType.CRYSTAL_SHULKER_BOX, windowId, playerInventory, new Inventory(ShulkerBoxType.CRYSTAL.size), ShulkerBoxType.CRYSTAL);
    }

    public static ShulkerBoxContainer createCrystalContainer(int windowId, PlayerInventory playerInventory, IInventory inventory)
    {
        return new ShulkerBoxContainer(ShulkerBoxContainerType.CRYSTAL_SHULKER_BOX, windowId, playerInventory, inventory, ShulkerBoxType.CRYSTAL);
    }

    public static ShulkerBoxContainer createCopperContainer(int windowId, PlayerInventory playerInventory)
    {
        return new ShulkerBoxContainer(ShulkerBoxContainerType.COPPER_SHULKER_BOX, windowId, playerInventory, new Inventory(ShulkerBoxType.COPPER.size), ShulkerBoxType.COPPER);
    }

    public static ShulkerBoxContainer createCopperContainer(int windowId, PlayerInventory playerInventory, IInventory inventory)
    {
        return new ShulkerBoxContainer(ShulkerBoxContainerType.COPPER_SHULKER_BOX, windowId, playerInventory, inventory, ShulkerBoxType.COPPER);
    }

    public static ShulkerBoxContainer createSilverContainer(int windowId, PlayerInventory playerInventory)
    {
        return new ShulkerBoxContainer(ShulkerBoxContainerType.SILVER_SHULKER_BOX, windowId, playerInventory, new Inventory(ShulkerBoxType.CRYSTAL.size), ShulkerBoxType.SILVER);
    }

    public static ShulkerBoxContainer createSilverContainer(int windowId, PlayerInventory playerInventory, IInventory inventory)
    {
        return new ShulkerBoxContainer(ShulkerBoxContainerType.SILVER_SHULKER_BOX, windowId, playerInventory, inventory, ShulkerBoxType.SILVER);
    }

    public static ShulkerBoxContainer createObsidianContainer(int windowId, PlayerInventory playerInventory)
    {
        return new ShulkerBoxContainer(ShulkerBoxContainerType.OBSIDIAN_SHULKER_BOX, windowId, playerInventory, new Inventory(ShulkerBoxType.OBSIDIAN.size), ShulkerBoxType.OBSIDIAN);
    }

    public static ShulkerBoxContainer createObsidianContainer(int windowId, PlayerInventory playerInventory, IInventory inventory)
    {
        return new ShulkerBoxContainer(ShulkerBoxContainerType.OBSIDIAN_SHULKER_BOX, windowId, playerInventory, inventory, ShulkerBoxType.OBSIDIAN);
    }

    public ShulkerBoxContainer(ContainerType<?> containerType, int windowId, PlayerInventory playerInventory, IInventory inventory, ShulkerBoxType shulkerBoxType)
    {
        super(containerType, windowId);
        func_216962_a(inventory, shulkerBoxType.size);

        this.inventory = inventory;
        this.shulkerBoxType = shulkerBoxType;

        inventory.openInventory(playerInventory.player);

        for (int shulkerBoxRow = 0; shulkerBoxRow < shulkerBoxType.getRowCount(); shulkerBoxRow++)
        {
            for (int shulkerBoxCol = 0; shulkerBoxCol < shulkerBoxType.rowLength; shulkerBoxCol++)
            {
                this.addSlot(new ShulkerBoxSlot(inventory, shulkerBoxCol + shulkerBoxRow * shulkerBoxType.rowLength, 12 + shulkerBoxCol * 18, 18 + shulkerBoxRow * 18));
            }
        }

        int leftCol = (shulkerBoxType.xSize - 162) / 2 + 1;

        for (int playerInvRow = 0; playerInvRow < 3; playerInvRow++)
        {
            for (int playerInvCol = 0; playerInvCol < 9; playerInvCol++)
            {
                this.addSlot(new Slot(playerInventory, playerInvCol + playerInvRow * 9 + 9, leftCol + playerInvCol * 18, shulkerBoxType.ySize - (4 - playerInvRow) * 18 - 10));
            }

        }

        for (int hotbarSlot = 0; hotbarSlot < 9; hotbarSlot++)
        {
            this.addSlot(new Slot(playerInventory, hotbarSlot, leftCol + hotbarSlot * 18, shulkerBoxType.ySize - 24));
        }
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn)
    {
        return this.inventory.isUsableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < this.shulkerBoxType.size)
            {
                if (!this.mergeItemStack(itemstack1, this.shulkerBoxType.size, this.inventorySlots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, this.shulkerBoxType.size, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    @Override
    public void onContainerClosed(PlayerEntity playerIn)
    {
        super.onContainerClosed(playerIn);
        this.inventory.closeInventory(playerIn);
    }

    @OnlyIn(Dist.CLIENT)
    public ShulkerBoxType getShulkerBoxType()
    {
        return this.shulkerBoxType;
    }
}