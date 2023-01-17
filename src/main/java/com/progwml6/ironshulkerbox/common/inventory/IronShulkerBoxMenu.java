package com.progwml6.ironshulkerbox.common.inventory;

import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesMenuTypes;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.ShulkerBoxSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class IronShulkerBoxMenu extends AbstractContainerMenu {

  private final Container container;

  private final IronShulkerBoxesTypes shulkerBoxTypes;

  private IronShulkerBoxMenu(@Nullable MenuType<?> menuType, int containerId, Inventory playerInventory) {
    this(menuType, containerId, playerInventory, new SimpleContainer(IronShulkerBoxesTypes.VANILLA.size), IronShulkerBoxesTypes.VANILLA);
  }

  public static IronShulkerBoxMenu createIronContainer(int containerId, Inventory playerInventory) {
    return new IronShulkerBoxMenu(IronShulkerBoxesMenuTypes.IRON_SHULKER_BOX.get(), containerId, playerInventory, new SimpleContainer(IronShulkerBoxesTypes.IRON.size), IronShulkerBoxesTypes.IRON);
  }

  public static IronShulkerBoxMenu createIronContainer(int containerId, Inventory playerInventory, Container inventory) {
    return new IronShulkerBoxMenu(IronShulkerBoxesMenuTypes.IRON_SHULKER_BOX.get(), containerId, playerInventory, inventory, IronShulkerBoxesTypes.IRON);
  }

  public static IronShulkerBoxMenu createGoldContainer(int containerId, Inventory playerInventory) {
    return new IronShulkerBoxMenu(IronShulkerBoxesMenuTypes.GOLD_SHULKER_BOX.get(), containerId, playerInventory, new SimpleContainer(IronShulkerBoxesTypes.GOLD.size), IronShulkerBoxesTypes.GOLD);
  }

  public static IronShulkerBoxMenu createGoldContainer(int containerId, Inventory playerInventory, Container inventory) {
    return new IronShulkerBoxMenu(IronShulkerBoxesMenuTypes.GOLD_SHULKER_BOX.get(), containerId, playerInventory, inventory, IronShulkerBoxesTypes.GOLD);
  }

  public static IronShulkerBoxMenu createDiamondContainer(int containerId, Inventory playerInventory) {
    return new IronShulkerBoxMenu(IronShulkerBoxesMenuTypes.DIAMOND_SHULKER_BOX.get(), containerId, playerInventory, new SimpleContainer(IronShulkerBoxesTypes.DIAMOND.size), IronShulkerBoxesTypes.DIAMOND);
  }

  public static IronShulkerBoxMenu createDiamondContainer(int containerId, Inventory playerInventory, Container inventory) {
    return new IronShulkerBoxMenu(IronShulkerBoxesMenuTypes.DIAMOND_SHULKER_BOX.get(), containerId, playerInventory, inventory, IronShulkerBoxesTypes.DIAMOND);
  }

  public static IronShulkerBoxMenu createCrystalContainer(int containerId, Inventory playerInventory) {
    return new IronShulkerBoxMenu(IronShulkerBoxesMenuTypes.CRYSTAL_SHULKER_BOX.get(), containerId, playerInventory, new SimpleContainer(IronShulkerBoxesTypes.CRYSTAL.size), IronShulkerBoxesTypes.CRYSTAL);
  }

  public static IronShulkerBoxMenu createCrystalContainer(int containerId, Inventory playerInventory, Container inventory) {
    return new IronShulkerBoxMenu(IronShulkerBoxesMenuTypes.CRYSTAL_SHULKER_BOX.get(), containerId, playerInventory, inventory, IronShulkerBoxesTypes.CRYSTAL);
  }

  public static IronShulkerBoxMenu createCopperContainer(int containerId, Inventory playerInventory) {
    return new IronShulkerBoxMenu(IronShulkerBoxesMenuTypes.COPPER_SHULKER_BOX.get(), containerId, playerInventory, new SimpleContainer(IronShulkerBoxesTypes.COPPER.size), IronShulkerBoxesTypes.COPPER);
  }

  public static IronShulkerBoxMenu createCopperContainer(int containerId, Inventory playerInventory, Container inventory) {
    return new IronShulkerBoxMenu(IronShulkerBoxesMenuTypes.COPPER_SHULKER_BOX.get(), containerId, playerInventory, inventory, IronShulkerBoxesTypes.COPPER);
  }

  public static IronShulkerBoxMenu createObsidianContainer(int containerId, Inventory playerInventory) {
    return new IronShulkerBoxMenu(IronShulkerBoxesMenuTypes.OBSIDIAN_SHULKER_BOX.get(), containerId, playerInventory, new SimpleContainer(IronShulkerBoxesTypes.OBSIDIAN.size), IronShulkerBoxesTypes.OBSIDIAN);
  }

  public static IronShulkerBoxMenu createObsidianContainer(int containerId, Inventory playerInventory, Container inventory) {
    return new IronShulkerBoxMenu(IronShulkerBoxesMenuTypes.OBSIDIAN_SHULKER_BOX.get(), containerId, playerInventory, inventory, IronShulkerBoxesTypes.OBSIDIAN);
  }

  protected IronShulkerBoxMenu(@Nullable MenuType<?> menuType, int containerId, Inventory playerInventory, Container inventory, IronShulkerBoxesTypes shulkerBoxTypes) {
    super(menuType, containerId);

    checkContainerSize(inventory, shulkerBoxTypes.size);

    this.container = inventory;
    this.shulkerBoxTypes = shulkerBoxTypes;

    inventory.startOpen(playerInventory.player);

    for (int shulkerBoxRow = 0; shulkerBoxRow < shulkerBoxTypes.getRowCount(); shulkerBoxRow++) {
      for (int shulkerBoxCol = 0; shulkerBoxCol < shulkerBoxTypes.rowLength; shulkerBoxCol++) {
        this.addSlot(new ShulkerBoxSlot(inventory, shulkerBoxCol + shulkerBoxRow * shulkerBoxTypes.rowLength, 12 + shulkerBoxCol * 18, 18 + shulkerBoxRow * 18));
      }
    }

    int leftCol = (shulkerBoxTypes.xSize - 162) / 2 + 1;

    for (int playerInvRow = 0; playerInvRow < 3; playerInvRow++) {
      for (int playerInvCol = 0; playerInvCol < 9; playerInvCol++) {
        this.addSlot(new Slot(playerInventory, playerInvCol + playerInvRow * 9 + 9, leftCol + playerInvCol * 18, shulkerBoxTypes.ySize - (4 - playerInvRow) * 18 - 10));
      }

    }

    for (int hotHarSlot = 0; hotHarSlot < 9; hotHarSlot++) {
      this.addSlot(new Slot(playerInventory, hotHarSlot, leftCol + hotHarSlot * 18, shulkerBoxTypes.ySize - 24));
    }
  }

  @Override
  public boolean stillValid(Player player) {
    return this.container.stillValid(player);
  }

  @Override
  public ItemStack quickMoveStack(Player player, int index) {
    ItemStack itemStack = ItemStack.EMPTY;
    Slot slot = this.slots.get(index);

    if (slot != null && slot.hasItem()) {
      ItemStack itemStackInSlot = slot.getItem();
      itemStack = itemStackInSlot.copy();

      if (index < this.shulkerBoxTypes.size) {
        if (!this.moveItemStackTo(itemStackInSlot, this.shulkerBoxTypes.size, this.slots.size(), true)) {
          return ItemStack.EMPTY;
        }
      } else if (!this.moveItemStackTo(itemStackInSlot, 0, this.shulkerBoxTypes.size, false)) {
        return ItemStack.EMPTY;
      }

      if (itemStackInSlot.isEmpty()) {
        slot.set(ItemStack.EMPTY);
      } else {
        slot.setChanged();
      }
    }

    return itemStack;
  }

  @Override
  public void removed(Player playerIn) {
    super.removed(playerIn);
    this.container.stopOpen(playerIn);
  }

  public Container getContainer() {
    return this.container;
  }

  @OnlyIn(Dist.CLIENT)
  public IronShulkerBoxesTypes getShulkerBoxType() {
    return this.shulkerBoxTypes;
  }
}
