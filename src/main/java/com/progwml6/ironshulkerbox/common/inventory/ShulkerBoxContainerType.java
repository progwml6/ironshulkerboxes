package com.progwml6.ironshulkerbox.common.inventory;

import com.progwml6.ironshulkerbox.IronShulkerBox;
import com.progwml6.ironshulkerbox.client.inventory.ShulkerBoxScreen;
import com.progwml6.ironshulkerbox.common.util.ContainerNames;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

public class ShulkerBoxContainerType
{
    @ObjectHolder(ContainerNames.IRON_SHULKER_BOX)
    public static ContainerType<ShulkerBoxContainer> IRON_SHULKER_BOX;

    @ObjectHolder(ContainerNames.GOLD_SHULKER_BOX)
    public static ContainerType<ShulkerBoxContainer> GOLD_SHULKER_BOX;

    @ObjectHolder(ContainerNames.DIAMOND_SHULKER_BOX)
    public static ContainerType<ShulkerBoxContainer> DIAMOND_SHULKER_BOX;

    @ObjectHolder(ContainerNames.CRYSTAL_SHULKER_BOX)
    public static ContainerType<ShulkerBoxContainer> CRYSTAL_SHULKER_BOX;

    @ObjectHolder(ContainerNames.COPPER_SHULKER_BOX)
    public static ContainerType<ShulkerBoxContainer> COPPER_SHULKER_BOX;

    @ObjectHolder(ContainerNames.SILVER_SHULKER_BOX)
    public static ContainerType<ShulkerBoxContainer> SILVER_SHULKER_BOX;

    @ObjectHolder(ContainerNames.OBSIDIAN_SHULKER_BOX)
    public static ContainerType<ShulkerBoxContainer> OBSIDIAN_SHULKER_BOX;

    @Mod.EventBusSubscriber(modid = IronShulkerBox.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration
    {
        @SubscribeEvent
        public static void onContainerTypeRegistry(final RegistryEvent.Register<ContainerType<?>> e)
        {
            e.getRegistry().registerAll(
                    new ContainerType<>(ShulkerBoxContainer::createIronContainer).setRegistryName(ContainerNames.IRON_SHULKER_BOX),
                    new ContainerType<>(ShulkerBoxContainer::createGoldContainer).setRegistryName(ContainerNames.GOLD_SHULKER_BOX),
                    new ContainerType<>(ShulkerBoxContainer::createDiamondContainer).setRegistryName(ContainerNames.DIAMOND_SHULKER_BOX),
                    new ContainerType<>(ShulkerBoxContainer::createCrystalContainer).setRegistryName(ContainerNames.CRYSTAL_SHULKER_BOX),
                    new ContainerType<>(ShulkerBoxContainer::createCopperContainer).setRegistryName(ContainerNames.COPPER_SHULKER_BOX),
                    new ContainerType<>(ShulkerBoxContainer::createSilverContainer).setRegistryName(ContainerNames.SILVER_SHULKER_BOX),
                    new ContainerType<>(ShulkerBoxContainer::createObsidianContainer).setRegistryName(ContainerNames.OBSIDIAN_SHULKER_BOX)
            );
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerScreenFactories() {

        ScreenManager.registerFactory(IRON_SHULKER_BOX, ShulkerBoxScreen::new);
        ScreenManager.registerFactory(GOLD_SHULKER_BOX, ShulkerBoxScreen::new);
        ScreenManager.registerFactory(DIAMOND_SHULKER_BOX, ShulkerBoxScreen::new);
        ScreenManager.registerFactory(CRYSTAL_SHULKER_BOX, ShulkerBoxScreen::new);
        ScreenManager.registerFactory(COPPER_SHULKER_BOX, ShulkerBoxScreen::new);
        ScreenManager.registerFactory(SILVER_SHULKER_BOX, ShulkerBoxScreen::new);
        ScreenManager.registerFactory(OBSIDIAN_SHULKER_BOX, ShulkerBoxScreen::new);
    }
}
