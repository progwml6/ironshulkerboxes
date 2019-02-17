package com.progwml6.ironshulkerbox.common.core;

import com.progwml6.ironshulkerbox.common.crafting.IronShulkerBoxColoringRecipe;
import com.progwml6.ironshulkerbox.common.crafting.IronShulkerBoxRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.RecipeSerializers;

public class IronShulkerBoxRecipes
{
    public static RecipeSerializers.SimpleSerializer<IronShulkerBoxColoringRecipe> CRAFTING_SPECIAL_SHULKERBOXCOLORING;

    public static IRecipeSerializer<IronShulkerBoxRecipe> CRAFTING_IRON_SHULKER_BOX;

    public static void register()
    {
        CRAFTING_SPECIAL_SHULKERBOXCOLORING = RecipeSerializers.register(new RecipeSerializers.SimpleSerializer<IronShulkerBoxColoringRecipe>("ironshulkerbox:crafting_special_shulkerboxcoloring", IronShulkerBoxColoringRecipe::new));

        CRAFTING_IRON_SHULKER_BOX = RecipeSerializers.register(new IronShulkerBoxRecipe.Serializer());
    }
}
