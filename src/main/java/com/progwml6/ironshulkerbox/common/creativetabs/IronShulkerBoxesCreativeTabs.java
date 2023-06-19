package com.progwml6.ironshulkerbox.common.creativetabs;

import com.progwml6.ironshulkerbox.IronShulkerBoxes;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesBlocks;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class IronShulkerBoxesCreativeTabs {
  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IronShulkerBoxes.MOD_ID);

  public static final RegistryObject<CreativeModeTab> IRON_SHULKER_BOX_TAB = CREATIVE_MODE_TABS.register("ironshulkerbox", () -> CreativeModeTab.builder()
    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
    .title(Component.translatable("itemGroup.ironshulkerbox"))
    .icon(() -> new ItemStack(IronShulkerBoxesBlocks.IRON_SHULKER_BOX.get()))
    .displayItems((parameters, output) -> {
      for (final RegistryObject<Item> item : IronShulkerBoxesItems.ITEMS.getEntries())
        output.accept(item.get());
    }).build());

}
