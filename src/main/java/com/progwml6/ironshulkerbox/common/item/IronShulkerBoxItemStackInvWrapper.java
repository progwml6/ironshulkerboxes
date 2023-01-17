package com.progwml6.ironshulkerbox.common.item;

import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesBlockEntityTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemHandlerHelper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Supplier;

public class IronShulkerBoxItemStackInvWrapper implements IItemHandlerModifiable, ICapabilityProvider {

  private final ItemStack stack;
  private final Supplier<IronShulkerBoxesTypes> type;
  private final LazyOptional<IItemHandler> holder = LazyOptional.of(() -> this);

  private CompoundTag cachedTag;
  private NonNullList<ItemStack> itemStacksCache;

  public IronShulkerBoxItemStackInvWrapper(ItemStack stack, Supplier<IronShulkerBoxesTypes> type) {
    this.stack = stack;
    this.type = type;
  }

  @Override
  public int getSlots() {
    return this.type.get().size;
  }

  @Override
  @Nonnull
  public ItemStack getStackInSlot(int slot) {
    validateSlotIndex(slot);
    return getItemList().get(slot);
  }

  @Override
  @Nonnull
  public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
    if (stack.isEmpty())
      return ItemStack.EMPTY;

    if (!isItemValid(slot, stack))
      return stack;

    validateSlotIndex(slot);

    NonNullList<ItemStack> itemStacks = getItemList();

    ItemStack existing = itemStacks.get(slot);

    int limit = Math.min(getSlotLimit(slot), stack.getMaxStackSize());

    if (!existing.isEmpty()) {
      if (!ItemHandlerHelper.canItemStacksStack(stack, existing))
        return stack;

      limit -= existing.getCount();
    }

    if (limit <= 0)
      return stack;

    boolean reachedLimit = stack.getCount() > limit;

    if (!simulate) {
      if (existing.isEmpty()) {
        itemStacks.set(slot, reachedLimit ? ItemHandlerHelper.copyStackWithSize(stack, limit) : stack);
      } else {
        existing.grow(reachedLimit ? limit : stack.getCount());
      }
      setItemList(itemStacks);
    }

    return reachedLimit ? ItemHandlerHelper.copyStackWithSize(stack, stack.getCount() - limit) : ItemStack.EMPTY;
  }

  @Override
  @Nonnull
  public ItemStack extractItem(int slot, int amount, boolean simulate) {
    NonNullList<ItemStack> itemStacks = getItemList();

    if (amount == 0)
      return ItemStack.EMPTY;

    validateSlotIndex(slot);

    ItemStack existing = itemStacks.get(slot);

    if (existing.isEmpty())
      return ItemStack.EMPTY;

    int toExtract = Math.min(amount, existing.getMaxStackSize());

    if (existing.getCount() <= toExtract) {
      if (!simulate) {
        itemStacks.set(slot, ItemStack.EMPTY);
        setItemList(itemStacks);
        return existing;
      } else {
        return existing.copy();
      }
    } else {
      if (!simulate) {
        itemStacks.set(slot, ItemHandlerHelper.copyStackWithSize(existing, existing.getCount() - toExtract));
        setItemList(itemStacks);
      }

      return ItemHandlerHelper.copyStackWithSize(existing, toExtract);
    }
  }

  private void validateSlotIndex(int slot) {
    if (slot < 0 || slot >= getSlots())
      throw new RuntimeException("Slot " + slot + " not in valid range - [0," + getSlots() + ")");
  }

  @Override
  public int getSlotLimit(int slot) {
    return 64;
  }

  @Override
  public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
    return stack.getItem().canFitInsideContainerItems();
  }

  @Override
  public void setStackInSlot(int slot, @Nonnull ItemStack stack) {
    validateSlotIndex(slot);

    if (!isItemValid(slot, stack))
      throw new RuntimeException("Invalid stack " + stack + " for slot " + slot + ")");

    NonNullList<ItemStack> itemStacks = getItemList();

    itemStacks.set(slot, stack);

    setItemList(itemStacks);
  }

  private NonNullList<ItemStack> getItemList() {
    CompoundTag rootTag = BlockItem.getBlockEntityData(this.stack);

    if (cachedTag == null || !cachedTag.equals(rootTag))
      itemStacksCache = refreshItemList(rootTag);

    return itemStacksCache;
  }

  private NonNullList<ItemStack> refreshItemList(CompoundTag rootTag) {
    NonNullList<ItemStack> itemStacks = NonNullList.withSize(getSlots(), ItemStack.EMPTY);

    if (rootTag != null && rootTag.contains("Items", CompoundTag.TAG_LIST)) {
      ContainerHelper.loadAllItems(rootTag, itemStacks);
    }

    cachedTag = rootTag;

    return itemStacks;
  }

  private void setItemList(NonNullList<ItemStack> itemStacks) {
    CompoundTag existing = BlockItem.getBlockEntityData(this.stack);
    CompoundTag rootTag = ContainerHelper.saveAllItems(existing == null ? new CompoundTag() : existing, itemStacks);

    switch (this.type.get()) {
      case IRON -> BlockItem.setBlockEntityData(this.stack, IronShulkerBoxesBlockEntityTypes.IRON_SHULKER_BOX.get(), rootTag);
      case GOLD -> BlockItem.setBlockEntityData(this.stack, IronShulkerBoxesBlockEntityTypes.GOLD_SHULKER_BOX.get(), rootTag);
      case DIAMOND -> BlockItem.setBlockEntityData(this.stack, IronShulkerBoxesBlockEntityTypes.DIAMOND_SHULKER_BOX.get(), rootTag);
      case COPPER -> BlockItem.setBlockEntityData(this.stack, IronShulkerBoxesBlockEntityTypes.COPPER_SHULKER_BOX.get(), rootTag);
      case CRYSTAL -> BlockItem.setBlockEntityData(this.stack, IronShulkerBoxesBlockEntityTypes.CRYSTAL_SHULKER_BOX.get(), rootTag);
      case OBSIDIAN -> BlockItem.setBlockEntityData(this.stack, IronShulkerBoxesBlockEntityTypes.OBSIDIAN_SHULKER_BOX.get(), rootTag);
    }

    cachedTag = rootTag;
  }

  @Override
  @Nonnull
  public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
    return ForgeCapabilities.ITEM_HANDLER.orEmpty(cap, this.holder);
  }
}
