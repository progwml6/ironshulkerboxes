package com.progwml6.ironshulkerbox.common.registraton;

import com.progwml6.ironshulkerbox.IronShulkerBoxes;
import com.progwml6.ironshulkerbox.common.inventory.IronShulkerBoxMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IronShulkerBoxesMenuTypes {

  public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, IronShulkerBoxes.MOD_ID);

  public static final RegistryObject<MenuType<IronShulkerBoxMenu>> IRON_SHULKER_BOX = MENU_TYPES.register("iron_shulker_box", () -> new MenuType<>(IronShulkerBoxMenu::createIronContainer));
  public static final RegistryObject<MenuType<IronShulkerBoxMenu>> GOLD_SHULKER_BOX = MENU_TYPES.register("gold_shulker_box", () -> new MenuType<>(IronShulkerBoxMenu::createGoldContainer));
  public static final RegistryObject<MenuType<IronShulkerBoxMenu>> DIAMOND_SHULKER_BOX = MENU_TYPES.register("diamond_shulker_box", () -> new MenuType<>(IronShulkerBoxMenu::createDiamondContainer));
  public static final RegistryObject<MenuType<IronShulkerBoxMenu>> CRYSTAL_SHULKER_BOX = MENU_TYPES.register("crystal_shulker_box", () -> new MenuType<>(IronShulkerBoxMenu::createCrystalContainer));
  public static final RegistryObject<MenuType<IronShulkerBoxMenu>> COPPER_SHULKER_BOX = MENU_TYPES.register("copper_shulker_box", () -> new MenuType<>(IronShulkerBoxMenu::createCopperContainer));
  public static final RegistryObject<MenuType<IronShulkerBoxMenu>> OBSIDIAN_SHULKER_BOX = MENU_TYPES.register("obsidian_shulker_box", () -> new MenuType<>(IronShulkerBoxMenu::createObsidianContainer));
}
