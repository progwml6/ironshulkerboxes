package com.progwml6.ironshulkerbox.common.data;

import com.progwml6.ironshulkerbox.IronShulkerBoxes;
import com.progwml6.ironshulkerbox.common.block.ShulkerBoxesBlocks;
import com.progwml6.ironshulkerbox.common.items.IronShulkerBoxesItems;
import com.progwml6.ironshulkerbox.common.items.IronShulkerBoxesUpgradeType;
import com.progwml6.ironshulkerbox.common.recipes.IronShulkerBoxRecipeBuilder;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.IRequirementsStrategy;
import net.minecraft.advancements.criterion.RecipeUnlockedTrigger;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalAdvancement;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.common.crafting.conditions.TagEmptyCondition;

import java.util.Objects;
import java.util.function.Consumer;

public class IronShulkerBoxesRecipeProvider extends RecipeProvider implements IConditionBuilder {

  public IronShulkerBoxesRecipeProvider(DataGenerator generatorIn) {
    super(generatorIn);
  }

  @Override
  protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
    this.addBlackShulkerBoxRecipes(consumer);
    this.addBlueShulkerBoxRecipes(consumer);
    this.addBrownShulkerBoxRecipes(consumer);
    this.addCyanShulkerBoxRecipes(consumer);
    this.addGrayShulkerBoxRecipes(consumer);
    this.addGreenShulkerBoxRecipes(consumer);
    this.addLightBlueShulkerBoxRecipes(consumer);
    this.addLightGrayShulkerBoxRecipes(consumer);
    this.addLimeShulkerBoxRecipes(consumer);
    this.addMagentaShulkerBoxRecipes(consumer);
    this.addOrangeShulkerBoxRecipes(consumer);
    this.addPinkShulkerBoxRecipes(consumer);
    this.addPurpleShulkerBoxRecipes(consumer);
    this.addRedShulkerBoxRecipes(consumer);
    this.addWhiteShulkerBoxRecipes(consumer);
    this.addYellowShulkerBoxRecipes(consumer);

    this.addUpgradesRecipes(consumer);
  }

  private void addBlackShulkerBoxRecipes(Consumer<IFinishedRecipe> consumer) {
    String color = "black/";
    String group = "ironshulkerbox:black_shulker_box";

    this.registerSilverBoxRecipe(consumer, ShulkerBoxesBlocks.BLACK_SILVER_SHULKER_BOX.get(), ShulkerBoxesBlocks.BLACK_COPPER_SHULKER_BOX.get(), ShulkerBoxesBlocks.BLACK_IRON_SHULKER_BOX.get(), color, group);
    this.registerCopperBoxRecipe(consumer, ShulkerBoxesBlocks.BLACK_COPPER_SHULKER_BOX.get(), Items.BLACK_SHULKER_BOX, color, group);
    this.registerIronBoxRecipe(consumer, ShulkerBoxesBlocks.BLACK_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.BLACK_COPPER_SHULKER_BOX.get(), Items.BLACK_SHULKER_BOX, color, group);
    this.registerGoldBoxRecipe(consumer, ShulkerBoxesBlocks.BLACK_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.BLACK_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.BLACK_SILVER_SHULKER_BOX.get(), color, group);
    this.registerDiamondBoxRecipe(consumer, ShulkerBoxesBlocks.BLACK_DIAMOND_SHULKER_BOX.get(), ShulkerBoxesBlocks.BLACK_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.BLACK_SILVER_SHULKER_BOX.get(), color, group);
    this.registerCrystalBoxRecipe(consumer, ShulkerBoxesBlocks.BLACK_CRYSTAL_SHULKER_BOX.get(), ShulkerBoxesBlocks.BLACK_DIAMOND_SHULKER_BOX.get(), color, group);
    this.registerObsidianBoxRecipe(consumer, ShulkerBoxesBlocks.BLACK_OBSIDIAN_SHULKER_BOX.get(), ShulkerBoxesBlocks.BLACK_DIAMOND_SHULKER_BOX.get(), color, group);
  }

  private void addBlueShulkerBoxRecipes(Consumer<IFinishedRecipe> consumer) {
    String color = "blue/";
    String group = "ironshulkerbox:blue_shulker_box";

    this.registerSilverBoxRecipe(consumer, ShulkerBoxesBlocks.BLUE_SILVER_SHULKER_BOX.get(), ShulkerBoxesBlocks.BLUE_COPPER_SHULKER_BOX.get(), ShulkerBoxesBlocks.BLUE_IRON_SHULKER_BOX.get(), color, group);
    this.registerCopperBoxRecipe(consumer, ShulkerBoxesBlocks.BLUE_COPPER_SHULKER_BOX.get(), Items.BLUE_SHULKER_BOX, color, group);
    this.registerIronBoxRecipe(consumer, ShulkerBoxesBlocks.BLUE_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.BLUE_COPPER_SHULKER_BOX.get(), Items.BLUE_SHULKER_BOX, color, group);
    this.registerGoldBoxRecipe(consumer, ShulkerBoxesBlocks.BLUE_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.BLUE_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.BLUE_SILVER_SHULKER_BOX.get(), color, group);
    this.registerDiamondBoxRecipe(consumer, ShulkerBoxesBlocks.BLUE_DIAMOND_SHULKER_BOX.get(), ShulkerBoxesBlocks.BLUE_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.BLUE_SILVER_SHULKER_BOX.get(), color, group);
    this.registerCrystalBoxRecipe(consumer, ShulkerBoxesBlocks.BLUE_CRYSTAL_SHULKER_BOX.get(), ShulkerBoxesBlocks.BLUE_DIAMOND_SHULKER_BOX.get(), color, group);
    this.registerObsidianBoxRecipe(consumer, ShulkerBoxesBlocks.BLUE_OBSIDIAN_SHULKER_BOX.get(), ShulkerBoxesBlocks.BLUE_DIAMOND_SHULKER_BOX.get(), color, group);
  }

  private void addBrownShulkerBoxRecipes(Consumer<IFinishedRecipe> consumer) {
    String color = "brown/";
    String group = "ironshulkerbox:brown_shulker_box";

    this.registerSilverBoxRecipe(consumer, ShulkerBoxesBlocks.BROWN_SILVER_SHULKER_BOX.get(), ShulkerBoxesBlocks.BROWN_COPPER_SHULKER_BOX.get(), ShulkerBoxesBlocks.BROWN_IRON_SHULKER_BOX.get(), color, group);
    this.registerCopperBoxRecipe(consumer, ShulkerBoxesBlocks.BROWN_COPPER_SHULKER_BOX.get(), Items.BROWN_SHULKER_BOX, color, group);
    this.registerIronBoxRecipe(consumer, ShulkerBoxesBlocks.BROWN_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.BROWN_COPPER_SHULKER_BOX.get(), Items.BROWN_SHULKER_BOX, color, group);
    this.registerGoldBoxRecipe(consumer, ShulkerBoxesBlocks.BROWN_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.BROWN_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.BROWN_SILVER_SHULKER_BOX.get(), color, group);
    this.registerDiamondBoxRecipe(consumer, ShulkerBoxesBlocks.BROWN_DIAMOND_SHULKER_BOX.get(), ShulkerBoxesBlocks.BROWN_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.BROWN_SILVER_SHULKER_BOX.get(), color, group);
    this.registerCrystalBoxRecipe(consumer, ShulkerBoxesBlocks.BROWN_CRYSTAL_SHULKER_BOX.get(), ShulkerBoxesBlocks.BROWN_DIAMOND_SHULKER_BOX.get(), color, group);
    this.registerObsidianBoxRecipe(consumer, ShulkerBoxesBlocks.BROWN_OBSIDIAN_SHULKER_BOX.get(), ShulkerBoxesBlocks.BROWN_DIAMOND_SHULKER_BOX.get(), color, group);
  }

  private void addCyanShulkerBoxRecipes(Consumer<IFinishedRecipe> consumer) {
    String color = "cyan/";
    String group = "ironshulkerbox:cyan_shulker_box";

    this.registerSilverBoxRecipe(consumer, ShulkerBoxesBlocks.CYAN_SILVER_SHULKER_BOX.get(), ShulkerBoxesBlocks.CYAN_COPPER_SHULKER_BOX.get(), ShulkerBoxesBlocks.CYAN_IRON_SHULKER_BOX.get(), color, group);
    this.registerCopperBoxRecipe(consumer, ShulkerBoxesBlocks.CYAN_COPPER_SHULKER_BOX.get(), Items.CYAN_SHULKER_BOX, color, group);
    this.registerIronBoxRecipe(consumer, ShulkerBoxesBlocks.CYAN_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.CYAN_COPPER_SHULKER_BOX.get(), Items.CYAN_SHULKER_BOX, color, group);
    this.registerGoldBoxRecipe(consumer, ShulkerBoxesBlocks.CYAN_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.CYAN_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.CYAN_SILVER_SHULKER_BOX.get(), color, group);
    this.registerDiamondBoxRecipe(consumer, ShulkerBoxesBlocks.CYAN_DIAMOND_SHULKER_BOX.get(), ShulkerBoxesBlocks.CYAN_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.CYAN_SILVER_SHULKER_BOX.get(), color, group);
    this.registerCrystalBoxRecipe(consumer, ShulkerBoxesBlocks.CYAN_CRYSTAL_SHULKER_BOX.get(), ShulkerBoxesBlocks.CYAN_DIAMOND_SHULKER_BOX.get(), color, group);
    this.registerObsidianBoxRecipe(consumer, ShulkerBoxesBlocks.CYAN_OBSIDIAN_SHULKER_BOX.get(), ShulkerBoxesBlocks.CYAN_DIAMOND_SHULKER_BOX.get(), color, group);
  }

  private void addGrayShulkerBoxRecipes(Consumer<IFinishedRecipe> consumer) {
    String color = "gray/";
    String group = "ironshulkerbox:gray_shulker_box";

    this.registerSilverBoxRecipe(consumer, ShulkerBoxesBlocks.GRAY_SILVER_SHULKER_BOX.get(), ShulkerBoxesBlocks.GRAY_COPPER_SHULKER_BOX.get(), ShulkerBoxesBlocks.GRAY_IRON_SHULKER_BOX.get(), color, group);
    this.registerCopperBoxRecipe(consumer, ShulkerBoxesBlocks.GRAY_COPPER_SHULKER_BOX.get(), Items.GRAY_SHULKER_BOX, color, group);
    this.registerIronBoxRecipe(consumer, ShulkerBoxesBlocks.GRAY_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.GRAY_COPPER_SHULKER_BOX.get(), Items.GRAY_SHULKER_BOX, color, group);
    this.registerGoldBoxRecipe(consumer, ShulkerBoxesBlocks.GRAY_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.GRAY_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.GRAY_SILVER_SHULKER_BOX.get(), color, group);
    this.registerDiamondBoxRecipe(consumer, ShulkerBoxesBlocks.GRAY_DIAMOND_SHULKER_BOX.get(), ShulkerBoxesBlocks.GRAY_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.GRAY_SILVER_SHULKER_BOX.get(), color, group);
    this.registerCrystalBoxRecipe(consumer, ShulkerBoxesBlocks.GRAY_CRYSTAL_SHULKER_BOX.get(), ShulkerBoxesBlocks.GRAY_DIAMOND_SHULKER_BOX.get(), color, group);
    this.registerObsidianBoxRecipe(consumer, ShulkerBoxesBlocks.GRAY_OBSIDIAN_SHULKER_BOX.get(), ShulkerBoxesBlocks.GRAY_DIAMOND_SHULKER_BOX.get(), color, group);
  }

  private void addGreenShulkerBoxRecipes(Consumer<IFinishedRecipe> consumer) {
    String color = "green/";
    String group = "ironshulkerbox:green_shulker_box";

    this.registerSilverBoxRecipe(consumer, ShulkerBoxesBlocks.GREEN_SILVER_SHULKER_BOX.get(), ShulkerBoxesBlocks.GREEN_COPPER_SHULKER_BOX.get(), ShulkerBoxesBlocks.GREEN_IRON_SHULKER_BOX.get(), color, group);
    this.registerCopperBoxRecipe(consumer, ShulkerBoxesBlocks.GREEN_COPPER_SHULKER_BOX.get(), Items.GREEN_SHULKER_BOX, color, group);
    this.registerIronBoxRecipe(consumer, ShulkerBoxesBlocks.GREEN_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.GREEN_COPPER_SHULKER_BOX.get(), Items.GREEN_SHULKER_BOX, color, group);
    this.registerGoldBoxRecipe(consumer, ShulkerBoxesBlocks.GREEN_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.GREEN_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.GREEN_SILVER_SHULKER_BOX.get(), color, group);
    this.registerDiamondBoxRecipe(consumer, ShulkerBoxesBlocks.GREEN_DIAMOND_SHULKER_BOX.get(), ShulkerBoxesBlocks.GREEN_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.GREEN_SILVER_SHULKER_BOX.get(), color, group);
    this.registerCrystalBoxRecipe(consumer, ShulkerBoxesBlocks.GREEN_CRYSTAL_SHULKER_BOX.get(), ShulkerBoxesBlocks.GREEN_DIAMOND_SHULKER_BOX.get(), color, group);
    this.registerObsidianBoxRecipe(consumer, ShulkerBoxesBlocks.GREEN_OBSIDIAN_SHULKER_BOX.get(), ShulkerBoxesBlocks.GREEN_DIAMOND_SHULKER_BOX.get(), color, group);
  }

  private void addLightBlueShulkerBoxRecipes(Consumer<IFinishedRecipe> consumer) {
    String color = "light_blue/";
    String group = "ironshulkerbox:light_blue_shulker_box";

    this.registerSilverBoxRecipe(consumer, ShulkerBoxesBlocks.LIGHT_BLUE_SILVER_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIGHT_BLUE_COPPER_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIGHT_BLUE_IRON_SHULKER_BOX.get(), color, group);
    this.registerCopperBoxRecipe(consumer, ShulkerBoxesBlocks.LIGHT_BLUE_COPPER_SHULKER_BOX.get(), Items.LIGHT_BLUE_SHULKER_BOX, color, group);
    this.registerIronBoxRecipe(consumer, ShulkerBoxesBlocks.LIGHT_BLUE_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIGHT_BLUE_COPPER_SHULKER_BOX.get(), Items.LIGHT_BLUE_SHULKER_BOX, color, group);
    this.registerGoldBoxRecipe(consumer, ShulkerBoxesBlocks.LIGHT_BLUE_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIGHT_BLUE_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIGHT_BLUE_SILVER_SHULKER_BOX.get(), color, group);
    this.registerDiamondBoxRecipe(consumer, ShulkerBoxesBlocks.LIGHT_BLUE_DIAMOND_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIGHT_BLUE_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIGHT_BLUE_SILVER_SHULKER_BOX.get(), color, group);
    this.registerCrystalBoxRecipe(consumer, ShulkerBoxesBlocks.LIGHT_BLUE_CRYSTAL_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIGHT_BLUE_DIAMOND_SHULKER_BOX.get(), color, group);
    this.registerObsidianBoxRecipe(consumer, ShulkerBoxesBlocks.LIGHT_BLUE_OBSIDIAN_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIGHT_BLUE_DIAMOND_SHULKER_BOX.get(), color, group);
  }

  private void addLightGrayShulkerBoxRecipes(Consumer<IFinishedRecipe> consumer) {
    String color = "light_gray/";
    String group = "ironshulkerbox:light_gray_shulker_box";

    this.registerSilverBoxRecipe(consumer, ShulkerBoxesBlocks.LIGHT_GRAY_SILVER_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIGHT_GRAY_COPPER_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIGHT_GRAY_IRON_SHULKER_BOX.get(), color, group);
    this.registerCopperBoxRecipe(consumer, ShulkerBoxesBlocks.LIGHT_GRAY_COPPER_SHULKER_BOX.get(), Items.LIGHT_GRAY_SHULKER_BOX, color, group);
    this.registerIronBoxRecipe(consumer, ShulkerBoxesBlocks.LIGHT_GRAY_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIGHT_GRAY_COPPER_SHULKER_BOX.get(), Items.LIGHT_GRAY_SHULKER_BOX, color, group);
    this.registerGoldBoxRecipe(consumer, ShulkerBoxesBlocks.LIGHT_GRAY_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIGHT_GRAY_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIGHT_GRAY_SILVER_SHULKER_BOX.get(), color, group);
    this.registerDiamondBoxRecipe(consumer, ShulkerBoxesBlocks.LIGHT_GRAY_DIAMOND_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIGHT_GRAY_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIGHT_GRAY_SILVER_SHULKER_BOX.get(), color, group);
    this.registerCrystalBoxRecipe(consumer, ShulkerBoxesBlocks.LIGHT_GRAY_CRYSTAL_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIGHT_GRAY_DIAMOND_SHULKER_BOX.get(), color, group);
    this.registerObsidianBoxRecipe(consumer, ShulkerBoxesBlocks.LIGHT_GRAY_OBSIDIAN_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIGHT_GRAY_DIAMOND_SHULKER_BOX.get(), color, group);
  }

  private void addLimeShulkerBoxRecipes(Consumer<IFinishedRecipe> consumer) {
    String color = "lime/";
    String group = "ironshulkerbox:lime_shulker_box";

    this.registerSilverBoxRecipe(consumer, ShulkerBoxesBlocks.LIME_SILVER_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIME_COPPER_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIME_IRON_SHULKER_BOX.get(), color, group);
    this.registerCopperBoxRecipe(consumer, ShulkerBoxesBlocks.LIME_COPPER_SHULKER_BOX.get(), Items.LIME_SHULKER_BOX, color, group);
    this.registerIronBoxRecipe(consumer, ShulkerBoxesBlocks.LIME_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIME_COPPER_SHULKER_BOX.get(), Items.LIME_SHULKER_BOX, color, group);
    this.registerGoldBoxRecipe(consumer, ShulkerBoxesBlocks.LIME_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIME_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIME_SILVER_SHULKER_BOX.get(), color, group);
    this.registerDiamondBoxRecipe(consumer, ShulkerBoxesBlocks.LIME_DIAMOND_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIME_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIME_SILVER_SHULKER_BOX.get(), color, group);
    this.registerCrystalBoxRecipe(consumer, ShulkerBoxesBlocks.LIME_CRYSTAL_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIME_DIAMOND_SHULKER_BOX.get(), color, group);
    this.registerObsidianBoxRecipe(consumer, ShulkerBoxesBlocks.LIME_OBSIDIAN_SHULKER_BOX.get(), ShulkerBoxesBlocks.LIME_DIAMOND_SHULKER_BOX.get(), color, group);
  }

  private void addMagentaShulkerBoxRecipes(Consumer<IFinishedRecipe> consumer) {
    String color = "magenta/";
    String group = "ironshulkerbox:magenta_shulker_box";

    this.registerSilverBoxRecipe(consumer, ShulkerBoxesBlocks.MAGENTA_SILVER_SHULKER_BOX.get(), ShulkerBoxesBlocks.MAGENTA_COPPER_SHULKER_BOX.get(), ShulkerBoxesBlocks.MAGENTA_IRON_SHULKER_BOX.get(), color, group);
    this.registerCopperBoxRecipe(consumer, ShulkerBoxesBlocks.MAGENTA_COPPER_SHULKER_BOX.get(), Items.MAGENTA_SHULKER_BOX, color, group);
    this.registerIronBoxRecipe(consumer, ShulkerBoxesBlocks.MAGENTA_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.MAGENTA_COPPER_SHULKER_BOX.get(), Items.MAGENTA_SHULKER_BOX, color, group);
    this.registerGoldBoxRecipe(consumer, ShulkerBoxesBlocks.MAGENTA_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.MAGENTA_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.MAGENTA_SILVER_SHULKER_BOX.get(), color, group);
    this.registerDiamondBoxRecipe(consumer, ShulkerBoxesBlocks.MAGENTA_DIAMOND_SHULKER_BOX.get(), ShulkerBoxesBlocks.MAGENTA_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.MAGENTA_SILVER_SHULKER_BOX.get(), color, group);
    this.registerCrystalBoxRecipe(consumer, ShulkerBoxesBlocks.MAGENTA_CRYSTAL_SHULKER_BOX.get(), ShulkerBoxesBlocks.MAGENTA_DIAMOND_SHULKER_BOX.get(), color, group);
    this.registerObsidianBoxRecipe(consumer, ShulkerBoxesBlocks.MAGENTA_OBSIDIAN_SHULKER_BOX.get(), ShulkerBoxesBlocks.MAGENTA_DIAMOND_SHULKER_BOX.get(), color, group);
  }

  private void addOrangeShulkerBoxRecipes(Consumer<IFinishedRecipe> consumer) {
    String color = "orange/";
    String group = "ironshulkerbox:orange_shulker_box";

    this.registerSilverBoxRecipe(consumer, ShulkerBoxesBlocks.ORANGE_SILVER_SHULKER_BOX.get(), ShulkerBoxesBlocks.ORANGE_COPPER_SHULKER_BOX.get(), ShulkerBoxesBlocks.ORANGE_IRON_SHULKER_BOX.get(), color, group);
    this.registerCopperBoxRecipe(consumer, ShulkerBoxesBlocks.ORANGE_COPPER_SHULKER_BOX.get(), Items.ORANGE_SHULKER_BOX, color, group);
    this.registerIronBoxRecipe(consumer, ShulkerBoxesBlocks.ORANGE_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.ORANGE_COPPER_SHULKER_BOX.get(), Items.ORANGE_SHULKER_BOX, color, group);
    this.registerGoldBoxRecipe(consumer, ShulkerBoxesBlocks.ORANGE_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.ORANGE_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.ORANGE_SILVER_SHULKER_BOX.get(), color, group);
    this.registerDiamondBoxRecipe(consumer, ShulkerBoxesBlocks.ORANGE_DIAMOND_SHULKER_BOX.get(), ShulkerBoxesBlocks.ORANGE_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.ORANGE_SILVER_SHULKER_BOX.get(), color, group);
    this.registerCrystalBoxRecipe(consumer, ShulkerBoxesBlocks.ORANGE_CRYSTAL_SHULKER_BOX.get(), ShulkerBoxesBlocks.ORANGE_DIAMOND_SHULKER_BOX.get(), color, group);
    this.registerObsidianBoxRecipe(consumer, ShulkerBoxesBlocks.ORANGE_OBSIDIAN_SHULKER_BOX.get(), ShulkerBoxesBlocks.ORANGE_DIAMOND_SHULKER_BOX.get(), color, group);
  }

  private void addPinkShulkerBoxRecipes(Consumer<IFinishedRecipe> consumer) {
    String color = "pink/";
    String group = "ironshulkerbox:pink_shulker_box";

    this.registerSilverBoxRecipe(consumer, ShulkerBoxesBlocks.PINK_SILVER_SHULKER_BOX.get(), ShulkerBoxesBlocks.PINK_COPPER_SHULKER_BOX.get(), ShulkerBoxesBlocks.PINK_IRON_SHULKER_BOX.get(), color, group);
    this.registerCopperBoxRecipe(consumer, ShulkerBoxesBlocks.PINK_COPPER_SHULKER_BOX.get(), Items.PINK_SHULKER_BOX, color, group);
    this.registerIronBoxRecipe(consumer, ShulkerBoxesBlocks.PINK_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.PINK_COPPER_SHULKER_BOX.get(), Items.PINK_SHULKER_BOX, color, group);
    this.registerGoldBoxRecipe(consumer, ShulkerBoxesBlocks.PINK_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.PINK_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.PINK_SILVER_SHULKER_BOX.get(), color, group);
    this.registerDiamondBoxRecipe(consumer, ShulkerBoxesBlocks.PINK_DIAMOND_SHULKER_BOX.get(), ShulkerBoxesBlocks.PINK_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.PINK_SILVER_SHULKER_BOX.get(), color, group);
    this.registerCrystalBoxRecipe(consumer, ShulkerBoxesBlocks.PINK_CRYSTAL_SHULKER_BOX.get(), ShulkerBoxesBlocks.PINK_DIAMOND_SHULKER_BOX.get(), color, group);
    this.registerObsidianBoxRecipe(consumer, ShulkerBoxesBlocks.PINK_OBSIDIAN_SHULKER_BOX.get(), ShulkerBoxesBlocks.PINK_DIAMOND_SHULKER_BOX.get(), color, group);
  }

  private void addPurpleShulkerBoxRecipes(Consumer<IFinishedRecipe> consumer) {
    String color = "purple/";
    String group = "ironshulkerbox:purple_shulker_box";

    this.registerSilverBoxRecipe(consumer, ShulkerBoxesBlocks.PURPLE_SILVER_SHULKER_BOX.get(), ShulkerBoxesBlocks.PURPLE_COPPER_SHULKER_BOX.get(), ShulkerBoxesBlocks.PURPLE_IRON_SHULKER_BOX.get(), color, group);
    this.registerCopperBoxRecipe(consumer, ShulkerBoxesBlocks.PURPLE_COPPER_SHULKER_BOX.get(), Items.PURPLE_SHULKER_BOX, color, group);
    this.registerIronBoxRecipe(consumer, ShulkerBoxesBlocks.PURPLE_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.PURPLE_COPPER_SHULKER_BOX.get(), Items.PURPLE_SHULKER_BOX, color, group);
    this.registerGoldBoxRecipe(consumer, ShulkerBoxesBlocks.PURPLE_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.PURPLE_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.PURPLE_SILVER_SHULKER_BOX.get(), color, group);
    this.registerDiamondBoxRecipe(consumer, ShulkerBoxesBlocks.PURPLE_DIAMOND_SHULKER_BOX.get(), ShulkerBoxesBlocks.PURPLE_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.PURPLE_SILVER_SHULKER_BOX.get(), color, group);
    this.registerCrystalBoxRecipe(consumer, ShulkerBoxesBlocks.PURPLE_CRYSTAL_SHULKER_BOX.get(), ShulkerBoxesBlocks.PURPLE_DIAMOND_SHULKER_BOX.get(), color, group);
    this.registerObsidianBoxRecipe(consumer, ShulkerBoxesBlocks.PURPLE_OBSIDIAN_SHULKER_BOX.get(), ShulkerBoxesBlocks.PURPLE_DIAMOND_SHULKER_BOX.get(), color, group);
  }

  private void addRedShulkerBoxRecipes(Consumer<IFinishedRecipe> consumer) {
    String color = "red/";
    String group = "ironshulkerbox:red_shulker_box";

    this.registerSilverBoxRecipe(consumer, ShulkerBoxesBlocks.RED_SILVER_SHULKER_BOX.get(), ShulkerBoxesBlocks.RED_COPPER_SHULKER_BOX.get(), ShulkerBoxesBlocks.RED_IRON_SHULKER_BOX.get(), color, group);
    this.registerCopperBoxRecipe(consumer, ShulkerBoxesBlocks.RED_COPPER_SHULKER_BOX.get(), Items.RED_SHULKER_BOX, color, group);
    this.registerIronBoxRecipe(consumer, ShulkerBoxesBlocks.RED_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.RED_COPPER_SHULKER_BOX.get(), Items.RED_SHULKER_BOX, color, group);
    this.registerGoldBoxRecipe(consumer, ShulkerBoxesBlocks.RED_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.RED_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.RED_SILVER_SHULKER_BOX.get(), color, group);
    this.registerDiamondBoxRecipe(consumer, ShulkerBoxesBlocks.RED_DIAMOND_SHULKER_BOX.get(), ShulkerBoxesBlocks.RED_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.RED_SILVER_SHULKER_BOX.get(), color, group);
    this.registerCrystalBoxRecipe(consumer, ShulkerBoxesBlocks.RED_CRYSTAL_SHULKER_BOX.get(), ShulkerBoxesBlocks.RED_DIAMOND_SHULKER_BOX.get(), color, group);
    this.registerObsidianBoxRecipe(consumer, ShulkerBoxesBlocks.RED_OBSIDIAN_SHULKER_BOX.get(), ShulkerBoxesBlocks.RED_DIAMOND_SHULKER_BOX.get(), color, group);
  }

  private void addWhiteShulkerBoxRecipes(Consumer<IFinishedRecipe> consumer) {
    String color = "white/";
    String group = "ironshulkerbox:white_shulker_box";

    this.registerSilverBoxRecipe(consumer, ShulkerBoxesBlocks.WHITE_SILVER_SHULKER_BOX.get(), ShulkerBoxesBlocks.WHITE_COPPER_SHULKER_BOX.get(), ShulkerBoxesBlocks.WHITE_IRON_SHULKER_BOX.get(), color, group);
    this.registerCopperBoxRecipe(consumer, ShulkerBoxesBlocks.WHITE_COPPER_SHULKER_BOX.get(), Items.WHITE_SHULKER_BOX, color, group);
    this.registerIronBoxRecipe(consumer, ShulkerBoxesBlocks.WHITE_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.WHITE_COPPER_SHULKER_BOX.get(), Items.WHITE_SHULKER_BOX, color, group);
    this.registerGoldBoxRecipe(consumer, ShulkerBoxesBlocks.WHITE_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.WHITE_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.WHITE_SILVER_SHULKER_BOX.get(), color, group);
    this.registerDiamondBoxRecipe(consumer, ShulkerBoxesBlocks.WHITE_DIAMOND_SHULKER_BOX.get(), ShulkerBoxesBlocks.WHITE_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.WHITE_SILVER_SHULKER_BOX.get(), color, group);
    this.registerCrystalBoxRecipe(consumer, ShulkerBoxesBlocks.WHITE_CRYSTAL_SHULKER_BOX.get(), ShulkerBoxesBlocks.WHITE_DIAMOND_SHULKER_BOX.get(), color, group);
    this.registerObsidianBoxRecipe(consumer, ShulkerBoxesBlocks.WHITE_OBSIDIAN_SHULKER_BOX.get(), ShulkerBoxesBlocks.WHITE_DIAMOND_SHULKER_BOX.get(), color, group);
  }

  private void addYellowShulkerBoxRecipes(Consumer<IFinishedRecipe> consumer) {
    String color = "yellow/";
    String group = "ironshulkerbox:yellow_shulker_box";

    this.registerSilverBoxRecipe(consumer, ShulkerBoxesBlocks.YELLOW_SILVER_SHULKER_BOX.get(), ShulkerBoxesBlocks.YELLOW_COPPER_SHULKER_BOX.get(), ShulkerBoxesBlocks.YELLOW_IRON_SHULKER_BOX.get(), color, group);
    this.registerCopperBoxRecipe(consumer, ShulkerBoxesBlocks.YELLOW_COPPER_SHULKER_BOX.get(), Items.YELLOW_SHULKER_BOX, color, group);
    this.registerIronBoxRecipe(consumer, ShulkerBoxesBlocks.YELLOW_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.YELLOW_COPPER_SHULKER_BOX.get(), Items.YELLOW_SHULKER_BOX, color, group);
    this.registerGoldBoxRecipe(consumer, ShulkerBoxesBlocks.YELLOW_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.YELLOW_IRON_SHULKER_BOX.get(), ShulkerBoxesBlocks.YELLOW_SILVER_SHULKER_BOX.get(), color, group);
    this.registerDiamondBoxRecipe(consumer, ShulkerBoxesBlocks.YELLOW_DIAMOND_SHULKER_BOX.get(), ShulkerBoxesBlocks.YELLOW_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.YELLOW_SILVER_SHULKER_BOX.get(), color, group);
    this.registerCrystalBoxRecipe(consumer, ShulkerBoxesBlocks.YELLOW_CRYSTAL_SHULKER_BOX.get(), ShulkerBoxesBlocks.YELLOW_DIAMOND_SHULKER_BOX.get(), color, group);
    this.registerObsidianBoxRecipe(consumer, ShulkerBoxesBlocks.YELLOW_OBSIDIAN_SHULKER_BOX.get(), ShulkerBoxesBlocks.YELLOW_DIAMOND_SHULKER_BOX.get(), color, group);
  }

  private void addUpgradesRecipes(Consumer<IFinishedRecipe> consumer) {
    String folder = "upgrades/";

    ShapedRecipeBuilder
      .shapedRecipe(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.VANILLA_TO_IRON).get())
      .key('M', Tags.Items.INGOTS_IRON)
      .key('S', Items.SHULKER_SHELL)
      .patternLine("MMM")
      .patternLine("MSM")
      .patternLine("MMM")
      .addCriterion("has_iron_ingot", hasItem(Tags.Items.INGOTS_IRON))
      .build(consumer,
        prefix(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.VANILLA_TO_IRON).get(), folder));

    ShapedRecipeBuilder.shapedRecipe(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.IRON_TO_GOLD).get())
      .key('S', Tags.Items.INGOTS_IRON)
      .key('M', Tags.Items.INGOTS_GOLD)
      .patternLine("MSM")
      .patternLine("MMM")
      .patternLine("MMM")
      .addCriterion("has_iron_ingot", hasItem(Tags.Items.INGOTS_IRON))
      .build(consumer,
        prefix(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.IRON_TO_GOLD).get(), folder));

    ShapedRecipeBuilder
      .shapedRecipe(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.GOLD_TO_DIAMOND).get())
      .key('M', Tags.Items.GEMS_DIAMOND)
      .key('S', Tags.Items.INGOTS_GOLD)
      .key('G', Tags.Items.GLASS)
      .patternLine("GMG")
      .patternLine("GSG")
      .patternLine("GMG")
      .addCriterion("has_glass", hasItem(Tags.Items.GLASS))
      .build(consumer,
        prefix(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.GOLD_TO_DIAMOND).get(), folder));

    ShapedRecipeBuilder
      .shapedRecipe(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.DIAMOND_TO_OBSIDIAN).get())
      .key('M', Blocks.OBSIDIAN)
      .key('G', Tags.Items.GLASS)
      .patternLine("MGM")
      .patternLine("MMM")
      .patternLine("MMM")
      .addCriterion("has_glass", hasItem(Tags.Items.GLASS))
      .build(consumer,
        prefix(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.DIAMOND_TO_OBSIDIAN).get(), folder));

    ShapedRecipeBuilder
      .shapedRecipe(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.DIAMOND_TO_CRYSTAL).get())
      .key('S', Blocks.OBSIDIAN)
      .key('G', Tags.Items.GLASS)
      .patternLine("GSG")
      .patternLine("GGG")
      .patternLine("GGG")
      .addCriterion("has_glass", hasItem(Tags.Items.GLASS))
      .build(consumer,
        prefix(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.DIAMOND_TO_CRYSTAL).get(), folder));

    ResourceLocation woodToCopperChestUpgradeId = prefix(
      IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.VANILLA_TO_COPPER).get(), folder);
    ConditionalRecipe.builder()
      .addCondition(not(new TagEmptyCondition("forge:ingots/copper")))
      .addRecipe(ShapedRecipeBuilder
        .shapedRecipe(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.VANILLA_TO_COPPER).get())
        .key('M', ItemTags.makeWrapperTag("forge:ingots/copper"))
        .key('S', Items.SHULKER_SHELL)
        .patternLine("MMM")
        .patternLine("MSM")
        .patternLine("MMM")
        .addCriterion("has_item", hasItem(Items.SHULKER_SHELL))::build)
      .setAdvancement(location("recipes/ironshulkerbox/upgrades/vanilla_to_copper_shulker_box_upgrade"),
        ConditionalAdvancement.builder()
          .addCondition(not(new TagEmptyCondition("forge:ingots/copper")))
          .addAdvancement(Advancement.Builder.builder()
            .withParentId(new ResourceLocation("recipes/root"))
            .withRewards(AdvancementRewards.Builder.recipe(woodToCopperChestUpgradeId))
            .withCriterion("has_item", hasItem(Items.SHULKER_SHELL))
            .withCriterion("has_the_recipe", RecipeUnlockedTrigger.create(woodToCopperChestUpgradeId))
            .withRequirementsStrategy(IRequirementsStrategy.OR))
      ).build(consumer, woodToCopperChestUpgradeId);

    ResourceLocation copperToIronChestUpgrade = prefix(
      IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.COPPER_TO_IRON).get(), folder);
    ConditionalRecipe.builder()
      .addCondition(not(new TagEmptyCondition("forge:ingots/copper")))
      .addRecipe(ShapedRecipeBuilder
        .shapedRecipe(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.COPPER_TO_IRON).get())
        .key('M', Tags.Items.INGOTS_IRON)
        .key('S', ItemTags.makeWrapperTag("forge:ingots/copper"))
        .key('G', Tags.Items.GLASS)
        .patternLine("GGG")
        .patternLine("MSM")
        .patternLine("MGM")
        .addCriterion("has_item", hasItem(ItemTags.PLANKS))::build)
      .setAdvancement(location("recipes/ironshulkerbox/upgrades/copper_to_iron_shulker_box_upgrade"),
        ConditionalAdvancement.builder()
          .addCondition(not(new TagEmptyCondition("forge:ingots/copper")))
          .addAdvancement(Advancement.Builder.builder()
            .withParentId(new ResourceLocation("recipes/root"))
            .withRewards(AdvancementRewards.Builder.recipe(copperToIronChestUpgrade))
            .withCriterion("has_item", hasItem(Tags.Items.GLASS))
            .withCriterion("has_the_recipe", RecipeUnlockedTrigger.create(copperToIronChestUpgrade))
            .withRequirementsStrategy(IRequirementsStrategy.OR))
      ).build(consumer, copperToIronChestUpgrade);

    ResourceLocation copperToSilverChestUpgrade = prefix(
      IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.COPPER_TO_SILVER).get(), folder);
    ConditionalRecipe.builder()
      .addCondition(
        and(not(new TagEmptyCondition("forge:ingots/copper")), not(new TagEmptyCondition("forge:ingots/silver"))))
      .addRecipe(ShapedRecipeBuilder
        .shapedRecipe(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.COPPER_TO_SILVER).get())
        .key('M', ItemTags.makeWrapperTag("forge:ingots/silver"))
        .key('S', ItemTags.makeWrapperTag("forge:ingots/copper"))
        .patternLine("MSM")
        .patternLine("MMM")
        .patternLine("MMM")
        .addCriterion("has_item", hasItem(ItemTags.makeWrapperTag("forge:ingots/copper")))::build)
      .setAdvancement(location("recipes/ironshulkerbox/upgrades/copper_to_silver_shulker_box_upgrade"),
        ConditionalAdvancement.builder()
          .addCondition(
            and(not(new TagEmptyCondition("forge:ingots/copper")), not(new TagEmptyCondition("forge:ingots/silver"))))
          .addAdvancement(Advancement.Builder.builder()
            .withParentId(new ResourceLocation("recipes/root"))
            .withRewards(AdvancementRewards.Builder.recipe(copperToSilverChestUpgrade))
            .withCriterion("has_item", hasItem(ItemTags.makeWrapperTag("forge:ingots/copper")))
            .withCriterion("has_the_recipe", RecipeUnlockedTrigger.create(copperToSilverChestUpgrade))
            .withRequirementsStrategy(IRequirementsStrategy.OR))
      ).build(consumer, copperToSilverChestUpgrade);

    ResourceLocation silverToGoldChestUpgrade = prefix(
      IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.SILVER_TO_GOLD).get(), folder);
    ConditionalRecipe.builder()
      .addCondition(not(new TagEmptyCondition("forge:ingots/silver")))
      .addRecipe(ShapedRecipeBuilder
        .shapedRecipe(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.SILVER_TO_GOLD).get())
        .key('M', Tags.Items.INGOTS_GOLD)
        .key('S', ItemTags.makeWrapperTag("forge:ingots/copper"))
        .key('G', Tags.Items.GLASS)
        .patternLine("MSM")
        .patternLine("GGG")
        .patternLine("MGM")
        .addCriterion("has_item", hasItem(Tags.Items.GLASS))::build)
      .setAdvancement(location("recipes/ironshulkerbox/upgrades/silver_to_gold_shulker_box_upgrade"),
        ConditionalAdvancement.builder()
          .addCondition(not(new TagEmptyCondition("forge:ingots/silver")))
          .addAdvancement(Advancement.Builder.builder()
            .withParentId(new ResourceLocation("recipes/root"))
            .withRewards(AdvancementRewards.Builder.recipe(silverToGoldChestUpgrade))
            .withCriterion("has_item", hasItem(Tags.Items.GLASS))
            .withCriterion("has_the_recipe", RecipeUnlockedTrigger.create(silverToGoldChestUpgrade))
            .withRequirementsStrategy(IRequirementsStrategy.OR))
      ).build(consumer, silverToGoldChestUpgrade);
  }

  protected static ResourceLocation prefix(IItemProvider item, String prefix) {
    ResourceLocation loc = Objects.requireNonNull(item.asItem().getRegistryName());
    return location(prefix + loc.getPath());
  }

  private static ResourceLocation location(String id) {
    return new ResourceLocation(IronShulkerBoxes.MOD_ID, id);
  }

  private void registerCopperBoxRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider result, IItemProvider input, String color, String group) {
    ResourceLocation vanillaToCopperShulkerBox = location("shulkerboxes/" + color + "copper/vanilla_copper_shulker_box");
    ConditionalRecipe.builder()
      .addCondition(not(new TagEmptyCondition("forge:ingots/copper")))
      .addRecipe(IronShulkerBoxRecipeBuilder.shapedRecipe(result)
        .setGroup(group)
        .key('M', ItemTags.makeWrapperTag("forge:ingots/copper"))
        .key('S', input)
        .patternLine("MMM")
        .patternLine("MSM")
        .patternLine("MMM")
        .addCriterion("has_item", hasItem(ItemTags.makeWrapperTag("forge:ingots/copper")))::build)
      .setAdvancement(location("recipes/ironshulkerbox/shulkerboxes/" + color + "copper/vanilla_copper_shulker_box"),
        ConditionalAdvancement.builder()
          .addCondition(not(new TagEmptyCondition("forge:ingots/copper")))
          .addAdvancement(Advancement.Builder.builder()
            .withParentId(new ResourceLocation("recipes/root"))
            .withRewards(AdvancementRewards.Builder.recipe(vanillaToCopperShulkerBox))
            .withCriterion("has_item", hasItem(ItemTags.makeWrapperTag("forge:ingots/copper")))
            .withCriterion("has_the_recipe", RecipeUnlockedTrigger.create(vanillaToCopperShulkerBox))
            .withRequirementsStrategy(IRequirementsStrategy.OR))
      ).build(consumer, vanillaToCopperShulkerBox);
  }

  private void registerSilverBoxRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider result, IItemProvider input, IItemProvider inputTwo, String color, String group) {
    ResourceLocation copperToSilverShulkerBox = location("shulkerboxes/" + color + "silver/copper_silver_shulker_box");
    ConditionalRecipe.builder()
      .addCondition(not(new TagEmptyCondition("forge:ingots/copper")))
      .addRecipe(IronShulkerBoxRecipeBuilder.shapedRecipe(result)
        .setGroup(group)
        .key('M', ItemTags.makeWrapperTag("forge:ingots/silver"))
        .key('S', input)
        .patternLine("MMM")
        .patternLine("MSM")
        .patternLine("MMM")
        .addCriterion("has_item", hasItem(ItemTags.makeWrapperTag("forge:ingots/silver")))::build)
      .setAdvancement(location("recipes/ironshulkerbox/shulkerboxes/" + color + "silver/copper_silver_shulker_box"),
        ConditionalAdvancement.builder()
          .addCondition(not(new TagEmptyCondition("forge:ingots/silver")))
          .addAdvancement(Advancement.Builder.builder()
            .withParentId(new ResourceLocation("recipes/root"))
            .withRewards(AdvancementRewards.Builder.recipe(copperToSilverShulkerBox))
            .withCriterion("has_item", hasItem(ItemTags.makeWrapperTag("forge:ingots/silver")))
            .withCriterion("has_the_recipe", RecipeUnlockedTrigger.create(copperToSilverShulkerBox))
            .withRequirementsStrategy(IRequirementsStrategy.OR))
      ).build(consumer, copperToSilverShulkerBox);

    ResourceLocation ironToSilverShulkerBox = location("shulkerboxes/" + color + "silver/iron_silver_shulker_box");
    ConditionalRecipe.builder()
      .addCondition(not(new TagEmptyCondition("forge:ingots/copper")))
      .addRecipe(IronShulkerBoxRecipeBuilder.shapedRecipe(result)
        .setGroup(group)
        .key('M', ItemTags.makeWrapperTag("forge:ingots/silver"))
        .key('S', inputTwo)
        .key('G', Tags.Items.GLASS)
        .patternLine("MGM")
        .patternLine("GSG")
        .patternLine("MGM")
        .addCriterion("has_item", hasItem(ItemTags.makeWrapperTag("forge:ingots/silver")))::build)
      .setAdvancement(location("recipes/ironshulkerbox/shulkerboxes/" + color + "silver/iron_silver_shulker_box"),
        ConditionalAdvancement.builder()
          .addCondition(not(new TagEmptyCondition("forge:ingots/silver")))
          .addAdvancement(Advancement.Builder.builder()
            .withParentId(new ResourceLocation("recipes/root"))
            .withRewards(AdvancementRewards.Builder.recipe(ironToSilverShulkerBox))
            .withCriterion("has_item", hasItem(ItemTags.makeWrapperTag("forge:ingots/silver")))
            .withCriterion("has_the_recipe", RecipeUnlockedTrigger.create(ironToSilverShulkerBox))
            .withRequirementsStrategy(IRequirementsStrategy.OR))
      ).build(consumer, ironToSilverShulkerBox);
  }

  private void registerIronBoxRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider result, IItemProvider input, IItemProvider inputTwo, String color, String group) {
    IronShulkerBoxRecipeBuilder.shapedRecipe(result)
      .setGroup(group)
      .key('G', Tags.Items.GLASS)
      .key('S', input)
      .key('M', Tags.Items.INGOTS_IRON)
      .patternLine("MGM")
      .patternLine("GSG")
      .patternLine("MGM")
      .addCriterion("has_gold", hasItem(Tags.Items.INGOTS_IRON))
      .build(consumer, location("shulkerboxes/" + color + "iron/copper_iron_shulker_box"));

    IronShulkerBoxRecipeBuilder.shapedRecipe(result)
      .setGroup(group)
      .key('S', inputTwo)
      .key('M', Tags.Items.INGOTS_IRON)
      .patternLine("MMM")
      .patternLine("MSM")
      .patternLine("MMM")
      .addCriterion("has_gold", hasItem(Tags.Items.INGOTS_GOLD))
      .build(consumer, location("shulkerboxes/" + color + "iron/vanilla_iron_shulker_box"));
  }

  private void registerGoldBoxRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider result, IItemProvider input, IItemProvider inputTwo, String color, String group) {
    IronShulkerBoxRecipeBuilder.shapedRecipe(result)
      .setGroup(group)
      .key('S', input)
      .key('M', Tags.Items.INGOTS_GOLD)
      .patternLine("MMM")
      .patternLine("MSM")
      .patternLine("MMM")
      .addCriterion("has_gold", hasItem(Tags.Items.INGOTS_GOLD))
      .build(consumer, location("shulkerboxes/" + color + "gold/iron_gold_shulker_box"));

    IronShulkerBoxRecipeBuilder.shapedRecipe(result)
      .setGroup(group)
      .key('G', Tags.Items.GLASS)
      .key('S', inputTwo)
      .key('M', Tags.Items.INGOTS_GOLD)
      .patternLine("MGM")
      .patternLine("GSG")
      .patternLine("MGM")
      .addCriterion("has_gold", hasItem(Tags.Items.INGOTS_GOLD))
      .build(consumer, location("shulkerboxes/" + color + "gold/silver_gold_shulker_box"));
  }

  private void registerDiamondBoxRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider result, IItemProvider input, IItemProvider inputTwo, String color, String group) {
    IronShulkerBoxRecipeBuilder.shapedRecipe(result)
      .setGroup(group)
      .key('G', Tags.Items.GLASS)
      .key('S', input)
      .key('M', Tags.Items.GEMS_DIAMOND)
      .patternLine("GGG")
      .patternLine("MSM")
      .patternLine("GGG")
      .addCriterion("has_diamonds", hasItem(Tags.Items.GEMS_DIAMOND))
      .build(consumer, location("shulkerboxes/" + color + "diamond/gold_diamond_shulker_box"));

    ResourceLocation silverToDiamondShulkerBox = location("shulkerboxes/" + color + "diamond/silver_diamond_shulker_box");
    ConditionalRecipe.builder()
      .addCondition(not(new TagEmptyCondition("forge:ingots/silver")))
      .addRecipe(IronShulkerBoxRecipeBuilder.shapedRecipe(result)
        .setGroup(group)
        .key('G', Tags.Items.GLASS)
        .key('M', Tags.Items.GEMS_DIAMOND)
        .key('S', inputTwo)
        .patternLine("GGG")
        .patternLine("GSG")
        .patternLine("MMM")
        .addCriterion("has_item", hasItem(Tags.Items.GEMS_DIAMOND))::build)
      .setAdvancement(location("recipes/ironshulkerbox/shulkerboxes/" + color + "diamond/silver_diamond_shulker_box"),
        ConditionalAdvancement.builder()
          .addCondition(not(new TagEmptyCondition("forge:ingots/silver")))
          .addAdvancement(Advancement.Builder.builder()
            .withParentId(new ResourceLocation("recipes/root"))
            .withRewards(AdvancementRewards.Builder.recipe(silverToDiamondShulkerBox))
            .withCriterion("has_item", hasItem(Tags.Items.GEMS_DIAMOND))
            .withCriterion("has_the_recipe", RecipeUnlockedTrigger.create(silverToDiamondShulkerBox))
            .withRequirementsStrategy(IRequirementsStrategy.OR))
      ).build(consumer, silverToDiamondShulkerBox);
  }

  private void registerCrystalBoxRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider result, IItemProvider input, String color, String group) {
    IronShulkerBoxRecipeBuilder.shapedRecipe(result)
      .setGroup(group)
      .key('G', Tags.Items.GLASS)
      .key('S', input)
      .patternLine("GGG")
      .patternLine("GSG")
      .patternLine("GGG")
      .addCriterion("has_glass", hasItem(Tags.Items.GLASS))
      .build(consumer, location("shulkerboxes/" + color + "crystal/diamond_crystal_shulker_box"));
  }

  private void registerObsidianBoxRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider result, IItemProvider input, String color, String group) {
    IronShulkerBoxRecipeBuilder.shapedRecipe(result)
      .setGroup(group)
      .key('M', Items.OBSIDIAN)
      .key('S', input)
      .patternLine("MMM")
      .patternLine("MSM")
      .patternLine("MMM")
      .addCriterion("has_obsidian", hasItem(Items.OBSIDIAN))
      .build(consumer, location("shulkerboxes/" + color + "obsidian/diamond_obsidian_shulker_box"));
  }
}
