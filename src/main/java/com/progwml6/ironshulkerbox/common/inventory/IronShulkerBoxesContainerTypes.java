package com.progwml6.ironshulkerbox.common.inventory;

import com.progwml6.ironshulkerbox.IronShulkerBoxes;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IronShulkerBoxesContainerTypes {

  public static final DeferredRegister<ContainerType<?>> CONTAINERS = new DeferredRegister<>(ForgeRegistries.CONTAINERS, IronShulkerBoxes.MOD_ID);

  public static final RegistryObject<ContainerType<IronShulkerBoxContainer>> IRON_SHULKER_BOX = CONTAINERS.register("iron_shulker_box", () -> new ContainerType<>(IronShulkerBoxContainer::createIronContainer));

  public static final RegistryObject<ContainerType<IronShulkerBoxContainer>> GOLD_SHULKER_BOX = CONTAINERS.register("gold_shulker_box", () -> new ContainerType<>(IronShulkerBoxContainer::createGoldContainer));

  public static final RegistryObject<ContainerType<IronShulkerBoxContainer>> DIAMOND_SHULKER_BOX = CONTAINERS.register("diamond_shulker_box", () -> new ContainerType<>(IronShulkerBoxContainer::createDiamondContainer));

  public static final RegistryObject<ContainerType<IronShulkerBoxContainer>> CRYSTAL_SHULKER_BOX = CONTAINERS.register("crystal_shulker_box", () -> new ContainerType<>(IronShulkerBoxContainer::createCrystalContainer));

  public static final RegistryObject<ContainerType<IronShulkerBoxContainer>> COPPER_SHULKER_BOX = CONTAINERS.register("copper_shulker_box", () -> new ContainerType<>(IronShulkerBoxContainer::createCopperContainer));

  public static final RegistryObject<ContainerType<IronShulkerBoxContainer>> SILVER_SHULKER_BOX = CONTAINERS.register("silver_shulker_box", () -> new ContainerType<>(IronShulkerBoxContainer::createSilverContainer));

  public static final RegistryObject<ContainerType<IronShulkerBoxContainer>> OBSIDIAN_SHULKER_BOX = CONTAINERS.register("obsidian_shulker_box", () -> new ContainerType<>(IronShulkerBoxContainer::createObsidianContainer));
}
