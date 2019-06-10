package com.progwml6.ironshulkerbox.common.core;

import com.progwml6.ironshulkerbox.IronShulkerBox;
import com.progwml6.ironshulkerbox.common.items.ShulkerBoxChangerItem;
import com.progwml6.ironshulkerbox.common.items.ShulkerBoxChangerType;
import com.progwml6.ironshulkerbox.common.util.ItemNames;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

public class IronShulkerBoxItems
{
    public static Properties itemBuilder;

    @ObjectHolder(ItemNames.IRON_GOLD_UPGRADE)
    public static Item ironToGoldUpgrade;

    @ObjectHolder(ItemNames.GOLD_DIAMOND_UPGRADE)
    public static Item goldToDiamondUpgrade;

    @ObjectHolder(ItemNames.COPPER_SILVER_UPGRADE)
    public static Item copperToSilverUpgrade;

    @ObjectHolder(ItemNames.SILVER_GOLD_UPGRADE)
    public static Item silverToGoldUpgrade;

    @ObjectHolder(ItemNames.COPPER_IRON_UPGRADE)
    public static Item copperToIronUpgrade;

    @ObjectHolder(ItemNames.DIAMOND_CRYSTAL_UPGRADE)
    public static Item diamondToCrystalUpgrade;

    @ObjectHolder(ItemNames.VANILLA_IRON_UPGRADE)
    public static Item vanillaToIronUpgrade;

    @ObjectHolder(ItemNames.VANILLA_COPPER_UPGRADE)
    public static Item vanillaToCopperUpgrade;

    @ObjectHolder(ItemNames.DIAMOND_OBSIDIAN_UPGRADE)
    public static Item diamondToObsidianUpgrade;

    public IronShulkerBoxItems()
    {

    }

    @Mod.EventBusSubscriber(modid = IronShulkerBox.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration
    {
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event)
        {
            IForgeRegistry<Item> itemRegistry = event.getRegistry();

            itemBuilder = (new Properties()).group(IronShulkerBoxCreativeTabs.IRON_SHULKER_BOX).maxStackSize(1);

            itemRegistry.register(new ShulkerBoxChangerItem(itemBuilder, ShulkerBoxChangerType.IRON_GOLD));
            itemRegistry.register(new ShulkerBoxChangerItem(itemBuilder, ShulkerBoxChangerType.GOLD_DIAMOND));
            itemRegistry.register(new ShulkerBoxChangerItem(itemBuilder, ShulkerBoxChangerType.COPPER_SILVER));
            itemRegistry.register(new ShulkerBoxChangerItem(itemBuilder, ShulkerBoxChangerType.SILVER_GOLD));
            itemRegistry.register(new ShulkerBoxChangerItem(itemBuilder, ShulkerBoxChangerType.COPPER_IRON));
            itemRegistry.register(new ShulkerBoxChangerItem(itemBuilder, ShulkerBoxChangerType.DIAMOND_CRYSTAL));
            itemRegistry.register(new ShulkerBoxChangerItem(itemBuilder, ShulkerBoxChangerType.VANILLA_IRON));
            itemRegistry.register(new ShulkerBoxChangerItem(itemBuilder, ShulkerBoxChangerType.VANILLA_COPPER));
            itemRegistry.register(new ShulkerBoxChangerItem(itemBuilder, ShulkerBoxChangerType.DIAMOND_OBSIDIAN));
        }
    }
}
