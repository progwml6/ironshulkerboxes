/*******************************************************************************
 * Copyright (c) 2012 cpw.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * <p>
 * Contributors:
 * cpw - initial API and implementation
 ******************************************************************************/
package com.progwml6.ironshulkerbox.common.core;

import com.progwml6.ironshulkerbox.IronShulkerBox;
import com.progwml6.ironshulkerbox.common.items.ItemShulkerBoxChanger;
import com.progwml6.ironshulkerbox.common.items.ShulkerBoxChangerType;
import com.progwml6.ironshulkerbox.common.util.ItemNames;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Builder;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

public class IronShulkerBoxItems
{
    public static Builder itemBuilder;

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

            itemBuilder = (new Builder()).group(IronShulkerBoxCreativeTabs.IRON_SHULKER_BOX).maxStackSize(1);

            itemRegistry.register(new ItemShulkerBoxChanger(itemBuilder, ShulkerBoxChangerType.IRON_GOLD));
            itemRegistry.register(new ItemShulkerBoxChanger(itemBuilder, ShulkerBoxChangerType.GOLD_DIAMOND));
            itemRegistry.register(new ItemShulkerBoxChanger(itemBuilder, ShulkerBoxChangerType.COPPER_SILVER));
            itemRegistry.register(new ItemShulkerBoxChanger(itemBuilder, ShulkerBoxChangerType.SILVER_GOLD));
            itemRegistry.register(new ItemShulkerBoxChanger(itemBuilder, ShulkerBoxChangerType.COPPER_IRON));
            itemRegistry.register(new ItemShulkerBoxChanger(itemBuilder, ShulkerBoxChangerType.DIAMOND_CRYSTAL));
            itemRegistry.register(new ItemShulkerBoxChanger(itemBuilder, ShulkerBoxChangerType.VANILLA_IRON));
            itemRegistry.register(new ItemShulkerBoxChanger(itemBuilder, ShulkerBoxChangerType.VANILLA_COPPER));
            itemRegistry.register(new ItemShulkerBoxChanger(itemBuilder, ShulkerBoxChangerType.DIAMOND_OBSIDIAN));
        }
    }
}
