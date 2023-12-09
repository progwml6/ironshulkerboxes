package com.progwml6.ironshulkerbox.common.registraton;

import com.google.common.collect.ImmutableMap;
import com.progwml6.ironshulkerbox.IronShulkerBoxes;
import com.progwml6.ironshulkerbox.common.item.IronShulkerBoxUpgradeItem;
import com.progwml6.ironshulkerbox.common.item.IronShulkerBoxesUpgradeType;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class IronShulkerBoxesItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IronShulkerBoxes.MOD_ID);

  public static final ImmutableMap<IronShulkerBoxesUpgradeType, RegistryObject<IronShulkerBoxUpgradeItem>> UPGRADES = ImmutableMap.copyOf(Arrays.stream(IronShulkerBoxesUpgradeType.values()).collect(Collectors.toMap(Function.identity(), type -> register(type.name().toLowerCase(Locale.ROOT) + "_shulker_box_upgrade", () -> new IronShulkerBoxUpgradeItem(type, new Item.Properties().stacksTo(1))))));

  private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> sup) {
    return ITEMS.register(name, sup);
  }
}
