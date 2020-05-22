package com.progwml6.ironshulkerbox.common.recipes;

import com.progwml6.ironshulkerbox.IronShulkerBoxes;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;


public class IronShulkerBoxRecipes
{
  @ObjectHolder("ironshulkerbox:shulker_box_coloring")
  public static IRecipeSerializer<?> SHULKER_BOX_COLORING;

  @ObjectHolder("ironshulkerbox:shulker_box_crafting")
  public static IRecipeSerializer<?> SHULKER_BOX_CRAFTING;

  @Mod.EventBusSubscriber(modid = IronShulkerBoxes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
  public static class Registration
  {
    @SubscribeEvent
    public static void onRecipeRegister(final RegistryEvent.Register<IRecipeSerializer<?>> e)
    {
      e.getRegistry().registerAll(
        new SpecialRecipeSerializer<>(ShulkerBoxColoringRecipe::new).setRegistryName("ironshulkerbox:shulker_box_coloring"),
        new IronShulkerBoxRecipe.Serializer()
      );
    }
  }
}
