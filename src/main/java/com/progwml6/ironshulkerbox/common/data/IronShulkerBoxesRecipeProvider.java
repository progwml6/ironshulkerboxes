package com.progwml6.ironshulkerbox.common.data;

import com.progwml6.ironshulkerbox.IronShulkerBoxes;
import com.progwml6.ironshulkerbox.common.item.IronShulkerBoxesUpgradeType;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesBlocks;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesItems;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesRecipes;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SpecialRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Locale;
import java.util.Objects;
import java.util.function.Consumer;

public class IronShulkerBoxesRecipeProvider extends RecipeProvider implements IConditionBuilder {

  public IronShulkerBoxesRecipeProvider(PackOutput output) {
    super(output);
  }

  @Override
  protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
    this.addDefaultShulkerBoxRecipes(consumer);
    this.addColoredShulkerBoxRecipes(consumer);

    this.addUpgradesRecipes(consumer);

    SpecialRecipeBuilder.special(IronShulkerBoxesRecipes.SHULKER_BOX_COLORING.get()).save(consumer, location("shulker_box_coloring").toString());
  }

  private void addDefaultShulkerBoxRecipes(Consumer<FinishedRecipe> consumer) {
    String color = "default/";
    String group = "ironshulkerbox:shulker_box";

    this.registerCopperBoxRecipe(consumer, IronShulkerBoxesBlocks.COPPER_SHULKER_BOX.get(), Items.SHULKER_BOX, color, group);
    this.registerIronBoxRecipe(consumer, IronShulkerBoxesBlocks.IRON_SHULKER_BOX.get(), IronShulkerBoxesBlocks.COPPER_SHULKER_BOX.get(), Items.SHULKER_BOX, color, group);
    this.registerGoldBoxRecipe(consumer, IronShulkerBoxesBlocks.GOLD_SHULKER_BOX.get(), IronShulkerBoxesBlocks.IRON_SHULKER_BOX.get(), color, group);
    this.registerDiamondBoxRecipe(consumer, IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOX.get(), IronShulkerBoxesBlocks.GOLD_SHULKER_BOX.get(), color, group);
    this.registerCrystalBoxRecipe(consumer, IronShulkerBoxesBlocks.CRYSTAL_SHULKER_BOX.get(), IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOX.get(), color, group);
    this.registerObsidianBoxRecipe(consumer, IronShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOX.get(), IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOX.get(), color, group);
  }

  private void addColoredShulkerBoxRecipes(Consumer<FinishedRecipe> consumer) {
    for (DyeColor color : DyeColor.values()) {
      String colorName = color.name().toLowerCase(Locale.ROOT);
      String folder = colorName + "/";
      String group = "ironshulkerbox:" + colorName + "_shulker_box";

      this.registerCopperBoxRecipe(consumer, IronShulkerBoxesBlocks.COPPER_SHULKER_BOXES.get(color).get(), getShulkerBoxItem(color), folder, group);
      this.registerIronBoxRecipe(consumer, IronShulkerBoxesBlocks.IRON_SHULKER_BOXES.get(color).get(), IronShulkerBoxesBlocks.COPPER_SHULKER_BOXES.get(color).get(), getShulkerBoxItem(color), folder, group);
      this.registerGoldBoxRecipe(consumer, IronShulkerBoxesBlocks.GOLD_SHULKER_BOXES.get(color).get(), IronShulkerBoxesBlocks.IRON_SHULKER_BOXES.get(color).get(), folder, group);
      this.registerDiamondBoxRecipe(consumer, IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOXES.get(color).get(), IronShulkerBoxesBlocks.GOLD_SHULKER_BOXES.get(color).get(), folder, group);
      this.registerCrystalBoxRecipe(consumer, IronShulkerBoxesBlocks.CRYSTAL_SHULKER_BOXES.get(color).get(), IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOXES.get(color).get(), folder, group);
      this.registerObsidianBoxRecipe(consumer, IronShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOXES.get(color).get(), IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOXES.get(color).get(), folder, group);
    }
  }

  private void addUpgradesRecipes(Consumer<FinishedRecipe> consumer) {
    String folder = "upgrades/";

    ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.VANILLA_TO_COPPER).get())
      .define('M', Tags.Items.INGOTS_COPPER)
      .define('S', Items.SHULKER_SHELL)
      .pattern("MMM")
      .pattern("MSM")
      .pattern("MMM")
      .unlockedBy("has_copper_ingot", has(Tags.Items.INGOTS_COPPER))
      .save(consumer, prefix(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.VANILLA_TO_COPPER).get(), folder));

    ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.VANILLA_TO_IRON).get())
      .define('M', Tags.Items.INGOTS_IRON)
      .define('S', Items.SHULKER_SHELL)
      .pattern("MMM")
      .pattern("MSM")
      .pattern("MMM")
      .unlockedBy("has_iron_ingot", has(Tags.Items.INGOTS_IRON))
      .save(consumer, prefix(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.VANILLA_TO_IRON).get(), folder));

    ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.COPPER_TO_IRON).get())
      .define('I', Tags.Items.INGOTS_IRON)
      .define('C', Tags.Items.INGOTS_COPPER)
      .define('G', Tags.Items.GLASS)
      .pattern("IGI")
      .pattern("GCG")
      .pattern("IGI")
      .unlockedBy("has_iron_ingot", has(Tags.Items.INGOTS_IRON))
      .save(consumer, prefix(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.COPPER_TO_IRON).get(), folder));

    ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.IRON_TO_GOLD).get())
      .define('S', Tags.Items.INGOTS_IRON)
      .define('M', Tags.Items.INGOTS_GOLD)
      .pattern("MSM")
      .pattern("MMM")
      .pattern("MMM")
      .unlockedBy("has_iron_ingot", has(Tags.Items.INGOTS_IRON))
      .save(consumer, prefix(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.IRON_TO_GOLD).get(), folder));

    ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.GOLD_TO_DIAMOND).get())
      .define('M', Tags.Items.GEMS_DIAMOND)
      .define('S', Tags.Items.INGOTS_GOLD)
      .define('G', Tags.Items.GLASS)
      .pattern("GMG")
      .pattern("GSG")
      .pattern("GMG")
      .unlockedBy("has_glass", has(Tags.Items.GLASS))
      .save(consumer, prefix(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.GOLD_TO_DIAMOND).get(), folder));

    ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.DIAMOND_TO_OBSIDIAN).get())
      .define('M', Blocks.OBSIDIAN)
      .define('G', Tags.Items.GLASS)
      .pattern("MGM")
      .pattern("MMM")
      .pattern("MMM")
      .unlockedBy("has_glass", has(Tags.Items.GLASS))
      .save(consumer, prefix(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.DIAMOND_TO_OBSIDIAN).get(), folder));

    ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.DIAMOND_TO_CRYSTAL).get())
      .define('S', Blocks.OBSIDIAN)
      .define('G', Tags.Items.GLASS)
      .pattern("GSG")
      .pattern("GGG")
      .pattern("GGG")
      .unlockedBy("has_glass", has(Tags.Items.GLASS))
      .save(consumer, prefix(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.DIAMOND_TO_CRYSTAL).get(), folder));
  }

  protected static ResourceLocation prefix(ItemLike item, String prefix) {
    ResourceLocation loc = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item.asItem()));
    return location(prefix + loc.getPath());
  }

  private static ResourceLocation location(String id) {
    return new ResourceLocation(IronShulkerBoxes.MOD_ID, id);
  }

  private void registerCopperBoxRecipe(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike input, String color, String group) {
    ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result)
      .group(group)
      .define('M', Tags.Items.INGOTS_COPPER)
      .define('S', input)
      .pattern("MMM")
      .pattern("MSM")
      .pattern("MMM")
      .unlockedBy("has_copper", has(Tags.Items.INGOTS_COPPER))
      .save(consumer, location("shulkerboxes/" + color + "copper/vanilla_copper_shulker_box"));
  }

  private void registerIronBoxRecipe(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike input, ItemLike inputTwo, String color, String group) {
    ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result)
      .group(group)
      .define('G', Tags.Items.GLASS)
      .define('S', input)
      .define('M', Tags.Items.INGOTS_IRON)
      .pattern("MGM")
      .pattern("GSG")
      .pattern("MGM")
      .unlockedBy("has_gold", has(Tags.Items.INGOTS_IRON))
      .save(consumer, location("shulkerboxes/" + color + "iron/copper_iron_shulker_box"));

    ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result)
      .group(group)
      .define('S', inputTwo)
      .define('M', Tags.Items.INGOTS_IRON)
      .pattern("MMM")
      .pattern("MSM")
      .pattern("MMM")
      .unlockedBy("has_gold", has(Tags.Items.INGOTS_GOLD))
      .save(consumer, location("shulkerboxes/" + color + "iron/vanilla_iron_shulker_box"));
  }

  private void registerGoldBoxRecipe(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike input, String color, String group) {
    ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result)
      .group(group)
      .define('S', input)
      .define('M', Tags.Items.INGOTS_GOLD)
      .pattern("MMM")
      .pattern("MSM")
      .pattern("MMM")
      .unlockedBy("has_gold", has(Tags.Items.INGOTS_GOLD))
      .save(consumer, location("shulkerboxes/" + color + "gold/iron_gold_shulker_box"));
  }

  private void registerDiamondBoxRecipe(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike input, String color, String group) {
    ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result)
      .group(group)
      .define('G', Tags.Items.GLASS)
      .define('S', input)
      .define('M', Tags.Items.GEMS_DIAMOND)
      .pattern("GGG")
      .pattern("MSM")
      .pattern("GGG")
      .unlockedBy("has_diamonds", has(Tags.Items.GEMS_DIAMOND))
      .save(consumer, location("shulkerboxes/" + color + "diamond/gold_diamond_shulker_box"));
  }

  private void registerCrystalBoxRecipe(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike input, String color, String group) {
    ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result)
      .group(group)
      .define('G', Tags.Items.GLASS)
      .define('S', input)
      .pattern("GGG")
      .pattern("GSG")
      .pattern("GGG")
      .unlockedBy("has_glass", has(Tags.Items.GLASS))
      .save(consumer, location("shulkerboxes/" + color + "crystal/diamond_crystal_shulker_box"));
  }

  private void registerObsidianBoxRecipe(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike input, String color, String group) {
    ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result)
      .group(group)
      .define('M', Items.OBSIDIAN)
      .define('S', input)
      .pattern("MMM")
      .pattern("MSM")
      .pattern("MMM")
      .unlockedBy("has_obsidian", has(Items.OBSIDIAN))
      .save(consumer, location("shulkerboxes/" + color + "obsidian/diamond_obsidian_shulker_box"));
  }


  private ItemLike getShulkerBoxItem(DyeColor color) {
    return switch (color) {
      case WHITE -> Items.WHITE_SHULKER_BOX;
      case ORANGE -> Items.ORANGE_SHULKER_BOX;
      case MAGENTA -> Items.MAGENTA_SHULKER_BOX;
      case LIGHT_BLUE -> Items.LIGHT_BLUE_SHULKER_BOX;
      case YELLOW -> Items.YELLOW_SHULKER_BOX;
      case LIME -> Items.LIME_SHULKER_BOX;
      case PINK -> Items.PINK_SHULKER_BOX;
      case GRAY -> Items.GRAY_SHULKER_BOX;
      case LIGHT_GRAY -> Items.LIGHT_GRAY_SHULKER_BOX;
      case CYAN -> Items.CYAN_SHULKER_BOX;
      case PURPLE -> Items.PURPLE_SHULKER_BOX;
      case BLUE -> Items.BLUE_SHULKER_BOX;
      case BROWN -> Items.BROWN_SHULKER_BOX;
      case GREEN -> Items.GREEN_SHULKER_BOX;
      case RED -> Items.RED_SHULKER_BOX;
      case BLACK -> Items.BLACK_SHULKER_BOX;
    };
  }
}
