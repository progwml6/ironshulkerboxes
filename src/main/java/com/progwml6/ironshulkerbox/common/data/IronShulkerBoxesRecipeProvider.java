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
    this.addUpgradesRecipes(consumer);
  }

  private void addBlackShulkerBoxRecipes(Consumer<IFinishedRecipe> consumer) {
    String color = "black/";
    String group = "ironshulkerbox:black_shulker_box";

    this.registerCopperBoxRecipe(consumer, ShulkerBoxesBlocks.BLACK_COPPER_SHULKER_BOX.get(), Items.BLACK_SHULKER_BOX,
      color, group);
    this.registerCrystalBoxRecipe(consumer, ShulkerBoxesBlocks.BLACK_CRYSTAL_SHULKER_BOX.get(),
      ShulkerBoxesBlocks.BLACK_DIAMOND_SHULKER_BOX.get(), color, group);
    this.registerDiamondBoxRecipe(consumer, ShulkerBoxesBlocks.BLACK_DIAMOND_SHULKER_BOX.get(),
      ShulkerBoxesBlocks.BLACK_GOLD_SHULKER_BOX.get(), ShulkerBoxesBlocks.BLACK_SILVER_SHULKER_BOX.get(), color, group);
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

  private void registerCrystalBoxRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider result, IItemProvider input,
    String color, String group) {
    IronShulkerBoxRecipeBuilder.shapedRecipe(result)
      .setGroup(group)
      .key('G', Tags.Items.GLASS)
      .key('S', input)
      .patternLine("GGG")
      .patternLine("GSG")
      .patternLine("GGG")
      .addCriterion("has_glass", hasItem(Tags.Items.GLASS))
      .build(consumer, location("shulkerboxes/" + color + "diamond_crystal_shulker_box"));
  }

  private void registerDiamondBoxRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider result, IItemProvider input,
    IItemProvider inputTwo, String color, String group) {
    IronShulkerBoxRecipeBuilder.shapedRecipe(result)
      .setGroup(group)
      .key('G', Tags.Items.GLASS)
      .key('S', input)
      .key('M', Tags.Items.GEMS_DIAMOND)
      .patternLine("GGG")
      .patternLine("MSM")
      .patternLine("GGG")
      .addCriterion("has_diamonds", hasItem(Tags.Items.GEMS_DIAMOND))
      .build(consumer, location("shulkerboxes/" + color + "gold_diamond_shulker_box"));

    ResourceLocation silverToDiamondShulkerBox = location("shulkerboxes/" + color + "silver_diamond_shulker_box");
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
      .setAdvancement(location("recipes/ironshulkerbox/shulkerboxes/" + color + "silver_diamond_shulker_box"),
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

  private void registerCopperBoxRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider result, IItemProvider input,
    String color, String group) {
    ResourceLocation vanillaToCopperShulkerBox = location("shulkerboxes/" + color + "vanilla_copper_shulker_box");
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
      .setAdvancement(location("recipes/ironshulkerbox/shulkerboxes/" + color + "vanilla_copper_shulker_box"),
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
}
