package com.progwml6.ironshulkerbox.common.core;

import com.progwml6.ironshulkerbox.IronShulkerBox;
import com.progwml6.ironshulkerbox.common.crafting.IronShulkerBoxRecipe;
import com.progwml6.ironshulkerbox.common.crafting.ShulkerBoxColoringRecipe;
import com.progwml6.ironshulkerbox.common.util.RecipeNames;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

public class IronShulkerBoxRecipes
{
    @ObjectHolder(RecipeNames.SHULKER_BOX_COLORING)
    public static IRecipeSerializer<?> SHULKER_BOX_COLORING;

    @ObjectHolder(RecipeNames.SHULKER_BOX_CRAFTING)
    public static IRecipeSerializer<?> SHULKER_BOX_CRAFTING;

    @Mod.EventBusSubscriber(modid = IronShulkerBox.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration
    {
        @SubscribeEvent
        public static void onRecipeRegister(final RegistryEvent.Register<IRecipeSerializer<?>> e)
        {
            e.getRegistry().registerAll(
                    new SpecialRecipeSerializer<>(ShulkerBoxColoringRecipe::new).setRegistryName(RecipeNames.SHULKER_BOX_COLORING),
                    new IronShulkerBoxRecipe.Serializer()
            );
        }
    }
}
