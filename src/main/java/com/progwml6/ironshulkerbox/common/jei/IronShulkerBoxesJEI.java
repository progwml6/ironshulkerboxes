package com.progwml6.ironshulkerbox.common.jei;

import com.progwml6.ironshulkerbox.IronShulkerBoxes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class IronShulkerBoxesJEI implements IModPlugin {

  private static final ResourceLocation ID = new ResourceLocation(IronShulkerBoxes.MOD_ID, "jei_plugin");

  @Override
  public ResourceLocation getPluginUid() {
    return ID;
  }

  @Override
  public void registerRecipes(IRecipeRegistration registration) {
    registration.addRecipes(RecipeTypes.CRAFTING, ShulkerBoxColoringRecipeMaker.createRecipes());
  }
}
