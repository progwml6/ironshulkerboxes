package com.progwml6.ironshulkerbox.common.registraton;

import com.progwml6.ironshulkerbox.IronShulkerBoxes;
import com.progwml6.ironshulkerbox.common.recipes.IronShulkerBoxesColoringRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IronShulkerBoxesRecipes {

  public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, IronShulkerBoxes.MOD_ID);

  public static final RegistryObject<SimpleCraftingRecipeSerializer<?>> SHULKER_BOX_COLORING = RECIPE_SERIALIZERS.register("shulker_box_coloring", () -> new SimpleCraftingRecipeSerializer<>(IronShulkerBoxesColoringRecipe::new));
}
