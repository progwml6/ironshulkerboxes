package com.progwml6.ironshulkerbox.common.jei;

import com.progwml6.ironshulkerbox.IronShulkerBoxes;
import com.progwml6.ironshulkerbox.common.block.AbstractIronShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.ShapelessRecipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class ShulkerBoxColoringRecipeMaker {

  private static final String group = "ironshulkerboxes.shulker.color";

  public static List<RecipeHolder<CraftingRecipe>> createRecipes() {
    List<RecipeHolder<CraftingRecipe>> list = new ArrayList<>();

    for (IronShulkerBoxesTypes type : IronShulkerBoxesTypes.values()) {
      if (type == IronShulkerBoxesTypes.VANILLA)
        continue;

      ItemStack baseShulkerStack = new ItemStack(IronShulkerBoxesTypes.get(type, null));
      Ingredient baseShulkerIngredient = Ingredient.of(baseShulkerStack);

      list.addAll(Arrays.stream(DyeColor.values())
        .map(color -> {
          DyeItem dye = DyeItem.byColor(color);
          ItemStack dyeStack = new ItemStack(dye);
          TagKey<Item> colorTag = color.getTag();
          Ingredient.Value dyeList = new Ingredient.ItemValue(dyeStack);
          Ingredient.Value colorList = new Ingredient.TagValue(colorTag);
          Stream<Ingredient.Value> colorIngredientStream = Stream.of(dyeList, colorList);
          Ingredient colorIngredient = Ingredient.fromValues(colorIngredientStream);

          NonNullList<Ingredient> inputs = NonNullList.of(Ingredient.EMPTY, baseShulkerIngredient, colorIngredient);
          ItemStack output = AbstractIronShulkerBoxBlock.getColoredItemStack(color, AbstractIronShulkerBoxBlock.getTypeFromItem(baseShulkerStack.getItem()));
          ResourceLocation id = new ResourceLocation(IronShulkerBoxes.MOD_ID, group + "." + output.getDescriptionId());
          CraftingRecipe recipe = new ShapelessRecipe(group, CraftingBookCategory.MISC, output, inputs);
          return new RecipeHolder<>(id, recipe);
        })
        .toList());
    }

    return list;
//
//    Arrays.stream(IronShulkerBoxesTypes.values()).filter(ironShulkerBoxesTypes -> ironShulkerBoxesTypes != IronShulkerBoxesTypes.VANILLA).map(
//      type -> {
//        System.out.println(type);
//        return null;
//      }).toList();
//
//    return Arrays.stream(DyeColor.values())
//      .map(color -> {
//        DyeItem dye = DyeItem.byColor(color);
//        ItemStack dyeStack = new ItemStack(dye);
//        TagKey<Item> colorTag = color.getTag();
//        Ingredient.Value dyeList = new Ingredient.ItemValue(dyeStack);
//        Ingredient.Value colorList = new Ingredient.TagValue(colorTag);
//        Stream<Ingredient.Value> colorIngredientStream = Stream.of(dyeList, colorList);
//        Ingredient colorIngredient = Ingredient.fromValues(colorIngredientStream);
//
//        NonNullList<Ingredient> inputs = NonNullList.of(Ingredient.EMPTY, baseShulkerIngredient, colorIngredient);
//        ItemStack output = AbstractIronShulkerBoxBlock.getColoredItemStack(color, AbstractIronShulkerBoxBlock.getTypeFromItem(baseShulkerStack.getItem()));
//        ResourceLocation id = new ResourceLocation(IronShulkerBoxes.MOD_ID, group + "." + output.getDescriptionId());
//        CraftingRecipe recipe = new ShapelessRecipe(group, CraftingBookCategory.MISC, output, inputs);
//        return new RecipeHolder<>(id, recipe);
//      })
//      .toList();
  }

  private ShulkerBoxColoringRecipeMaker() {

  }
}
