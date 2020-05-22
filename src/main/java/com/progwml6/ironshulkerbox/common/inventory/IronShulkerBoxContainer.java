package com.progwml6.ironshulkerbox.common.inventory;

import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
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

public class IronShulkerBoxContainer extends Container {

  private final IInventory inventory;

  private final IronShulkerBoxesTypes shulkerBoxType;

  private IronShulkerBoxContainer(ContainerType<?> containerType, int windowId, PlayerInventory playerInventory) {
    this(containerType, windowId, playerInventory, new Inventory(IronShulkerBoxesTypes.VANILLA.size), IronShulkerBoxesTypes.VANILLA);
  }

  public static IronShulkerBoxContainer createIronContainer(int windowId, PlayerInventory playerInventory) {
    return new IronShulkerBoxContainer(IronShulkerBoxesContainerTypes.IRON_SHULKER_BOX.get(), windowId, playerInventory, new Inventory(IronShulkerBoxesTypes.IRON.size), IronShulkerBoxesTypes.IRON);
  }

  public static IronShulkerBoxContainer createIronContainer(int windowId, PlayerInventory playerInventory, IInventory inventory) {
    return new IronShulkerBoxContainer(IronShulkerBoxesContainerTypes.IRON_SHULKER_BOX.get(), windowId, playerInventory, inventory, IronShulkerBoxesTypes.IRON);
  }

  public static IronShulkerBoxContainer createGoldContainer(int windowId, PlayerInventory playerInventory) {
    return new IronShulkerBoxContainer(IronShulkerBoxesContainerTypes.GOLD_SHULKER_BOX.get(), windowId, playerInventory, new Inventory(IronShulkerBoxesTypes.GOLD.size), IronShulkerBoxesTypes.GOLD);
  }

  public static IronShulkerBoxContainer createGoldContainer(int windowId, PlayerInventory playerInventory, IInventory inventory) {
    return new IronShulkerBoxContainer(IronShulkerBoxesContainerTypes.GOLD_SHULKER_BOX.get(), windowId, playerInventory, inventory, IronShulkerBoxesTypes.GOLD);
  }

  public static IronShulkerBoxContainer createDiamondContainer(int windowId, PlayerInventory playerInventory) {
    return new IronShulkerBoxContainer(IronShulkerBoxesContainerTypes.DIAMOND_SHULKER_BOX.get(), windowId, playerInventory, new Inventory(IronShulkerBoxesTypes.DIAMOND.size), IronShulkerBoxesTypes.DIAMOND);
  }

  public static IronShulkerBoxContainer createDiamondContainer(int windowId, PlayerInventory playerInventory, IInventory inventory) {
    return new IronShulkerBoxContainer(IronShulkerBoxesContainerTypes.DIAMOND_SHULKER_BOX.get(), windowId, playerInventory, inventory, IronShulkerBoxesTypes.DIAMOND);
  }

  public static IronShulkerBoxContainer createCrystalContainer(int windowId, PlayerInventory playerInventory) {
    return new IronShulkerBoxContainer(IronShulkerBoxesContainerTypes.CRYSTAL_SHULKER_BOX.get(), windowId, playerInventory, new Inventory(IronShulkerBoxesTypes.CRYSTAL.size), IronShulkerBoxesTypes.CRYSTAL);
  }

  public static IronShulkerBoxContainer createCrystalContainer(int windowId, PlayerInventory playerInventory, IInventory inventory) {
    return new IronShulkerBoxContainer(IronShulkerBoxesContainerTypes.CRYSTAL_SHULKER_BOX.get(), windowId, playerInventory, inventory, IronShulkerBoxesTypes.CRYSTAL);
  }

  public static IronShulkerBoxContainer createCopperContainer(int windowId, PlayerInventory playerInventory) {
    return new IronShulkerBoxContainer(IronShulkerBoxesContainerTypes.COPPER_SHULKER_BOX.get(), windowId, playerInventory, new Inventory(IronShulkerBoxesTypes.COPPER.size), IronShulkerBoxesTypes.COPPER);
  }

  public static IronShulkerBoxContainer createCopperContainer(int windowId, PlayerInventory playerInventory, IInventory inventory) {
    return new IronShulkerBoxContainer(IronShulkerBoxesContainerTypes.COPPER_SHULKER_BOX.get(), windowId, playerInventory, inventory, IronShulkerBoxesTypes.COPPER);
  }

  public static IronShulkerBoxContainer createSilverContainer(int windowId, PlayerInventory playerInventory) {
    return new IronShulkerBoxContainer(IronShulkerBoxesContainerTypes.SILVER_SHULKER_BOX.get(), windowId, playerInventory, new Inventory(IronShulkerBoxesTypes.CRYSTAL.size), IronShulkerBoxesTypes.SILVER);
  }

  public static IronShulkerBoxContainer createSilverContainer(int windowId, PlayerInventory playerInventory, IInventory inventory) {
    return new IronShulkerBoxContainer(IronShulkerBoxesContainerTypes.SILVER_SHULKER_BOX.get(), windowId, playerInventory, inventory, IronShulkerBoxesTypes.SILVER);
  }

  public static IronShulkerBoxContainer createObsidianContainer(int windowId, PlayerInventory playerInventory) {
    return new IronShulkerBoxContainer(IronShulkerBoxesContainerTypes.OBSIDIAN_SHULKER_BOX.get(), windowId, playerInventory, new Inventory(IronShulkerBoxesTypes.OBSIDIAN.size), IronShulkerBoxesTypes.OBSIDIAN);
  }

  public static IronShulkerBoxContainer createObsidianContainer(int windowId, PlayerInventory playerInventory, IInventory inventory) {
    return new IronShulkerBoxContainer(IronShulkerBoxesContainerTypes.OBSIDIAN_SHULKER_BOX.get(), windowId, playerInventory, inventory, IronShulkerBoxesTypes.OBSIDIAN);
  }

  public IronShulkerBoxContainer(ContainerType<?> containerType, int windowId, PlayerInventory playerInventory, IInventory inventory, IronShulkerBoxesTypes shulkerBoxType) {
    super(containerType, windowId);
    assertInventorySize(inventory, shulkerBoxType.size);

    this.inventory = inventory;
    this.shulkerBoxType = shulkerBoxType;

    inventory.openInventory(playerInventory.player);

    for (int shulkerBoxRow = 0; shulkerBoxRow < shulkerBoxType.getRowCount(); shulkerBoxRow++) {
      for (int shulkerBoxCol = 0; shulkerBoxCol < shulkerBoxType.rowLength; shulkerBoxCol++) {
        this.addSlot(new ShulkerBoxSlot(inventory, shulkerBoxCol + shulkerBoxRow * shulkerBoxType.rowLength, 12 + shulkerBoxCol * 18, 18 + shulkerBoxRow * 18));
      }
    }

    int leftCol = (shulkerBoxType.xSize - 162) / 2 + 1;

    for (int playerInvRow = 0; playerInvRow < 3; playerInvRow++) {
      for (int playerInvCol = 0; playerInvCol < 9; playerInvCol++) {
        this.addSlot(new Slot(playerInventory, playerInvCol + playerInvRow * 9 + 9, leftCol + playerInvCol * 18, shulkerBoxType.ySize - (4 - playerInvRow) * 18 - 10));
      }

    }

    for (int hotbarSlot = 0; hotbarSlot < 9; hotbarSlot++) {
      this.addSlot(new Slot(playerInventory, hotbarSlot, leftCol + hotbarSlot * 18, shulkerBoxType.ySize - 24));
    }
  }

  @Override
  public boolean canInteractWith(PlayerEntity playerIn) {
    return this.inventory.isUsableByPlayer(playerIn);
  }

  @Override
  public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
    ItemStack itemstack = ItemStack.EMPTY;
    Slot slot = this.inventorySlots.get(index);

    if (slot != null && slot.getHasStack()) {
      ItemStack itemstack1 = slot.getStack();
      itemstack = itemstack1.copy();

      if (index < this.shulkerBoxType.size) {
        if (!this.mergeItemStack(itemstack1, this.shulkerBoxType.size, this.inventorySlots.size(), true)) {
          return ItemStack.EMPTY;
        }
      } else if (!this.mergeItemStack(itemstack1, 0, this.shulkerBoxType.size, false)) {
        return ItemStack.EMPTY;
      }

      if (itemstack1.isEmpty()) {
        slot.putStack(ItemStack.EMPTY);
      } else {
        slot.onSlotChanged();
      }
    }

    return itemstack;
  }

  @Override
  public void onContainerClosed(PlayerEntity playerIn) {
    super.onContainerClosed(playerIn);
    this.inventory.closeInventory(playerIn);
  }

  @OnlyIn(Dist.CLIENT)
  public IronShulkerBoxesTypes getShulkerBoxType() {
    return this.shulkerBoxType;
  }
}
