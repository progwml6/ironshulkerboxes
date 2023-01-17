package com.progwml6.ironshulkerbox.client.model;

import com.google.common.collect.ImmutableList;
import com.progwml6.ironshulkerbox.IronShulkerBoxes;
import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.stream.Stream;

public class IronShulkerBoxesModels {

  public static final List<ResourceLocation> IRON_COLORED_SHULKER_TEXTURE_LOCATION = Stream.of("white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black").map((color) -> getShulkerBoxResourceLocation("iron", color)).collect(ImmutableList.toImmutableList());
  public static final List<ResourceLocation> GOLD_COLORED_SHULKER_TEXTURE_LOCATION = Stream.of("white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black").map((color) -> getShulkerBoxResourceLocation("gold", color)).collect(ImmutableList.toImmutableList());
  public static final List<ResourceLocation> DIAMOND_COLORED_SHULKER_TEXTURE_LOCATION = Stream.of("white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black").map((color) -> getShulkerBoxResourceLocation("diamond", color)).collect(ImmutableList.toImmutableList());
  public static final List<ResourceLocation> COPPER_COLORED_SHULKER_TEXTURE_LOCATION = Stream.of("white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black").map((color) -> getShulkerBoxResourceLocation("copper", color)).collect(ImmutableList.toImmutableList());
  public static final List<ResourceLocation> CRYSTAL_COLORED_SHULKER_TEXTURE_LOCATION = Stream.of("white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black").map((color) -> getShulkerBoxResourceLocation("crystal", color)).collect(ImmutableList.toImmutableList());
  public static final List<ResourceLocation> OBSIDIAN_COLORED_SHULKER_TEXTURE_LOCATION = Stream.of("white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black").map((color) -> getShulkerBoxResourceLocation("obsidian", color)).collect(ImmutableList.toImmutableList());
  public static final List<ResourceLocation> COLORED_SHULKER_TEXTURE_LOCATION = Stream.of("white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black").map(IronShulkerBoxesModels::getShulkerBoxResourceLocation).collect(ImmutableList.toImmutableList());
  public static final ResourceLocation IRON_SHULKER_TEXTURE_LOCATION = new ResourceLocation(IronShulkerBoxes.MOD_ID, "model/default/shulker_iron");
  public static final ResourceLocation GOLD_SHULKER_TEXTURE_LOCATION = new ResourceLocation(IronShulkerBoxes.MOD_ID, "model/default/shulker_gold");
  public static final ResourceLocation DIAMOND_SHULKER_TEXTURE_LOCATION = new ResourceLocation(IronShulkerBoxes.MOD_ID, "model/default/shulker_diamond");
  public static final ResourceLocation COPPER_SHULKER_TEXTURE_LOCATION = new ResourceLocation(IronShulkerBoxes.MOD_ID, "model/default/shulker_copper");
  public static final ResourceLocation CRYSTAL_SHULKER_TEXTURE_LOCATION = new ResourceLocation(IronShulkerBoxes.MOD_ID, "model/default/shulker_crystal");
  public static final ResourceLocation OBSIDIAN_SHULKER_TEXTURE_LOCATION = new ResourceLocation(IronShulkerBoxes.MOD_ID, "model/default/shulker_obsidian");
  public static final ResourceLocation SHULKER_TEXTURE_LOCATION = new ResourceLocation("entity/shulker/shulker");

  private static ResourceLocation getShulkerBoxResourceLocation(String typeName, String colorName) {
    return new ResourceLocation(IronShulkerBoxes.MOD_ID, "model/" + colorName + "/shulker_" + colorName + "_" + typeName);
  }

  private static ResourceLocation getShulkerBoxResourceLocation(String colorName) {
    return new ResourceLocation("entity/shulker/shulker_" + colorName);
  }

  public static ResourceLocation chooseShulkerBoxTexture(IronShulkerBoxesTypes type, int dyeColor) {
    return switch (type) {
      case IRON -> IRON_COLORED_SHULKER_TEXTURE_LOCATION.get(dyeColor);
      case GOLD -> GOLD_COLORED_SHULKER_TEXTURE_LOCATION.get(dyeColor);
      case DIAMOND -> DIAMOND_COLORED_SHULKER_TEXTURE_LOCATION.get(dyeColor);
      case COPPER -> COPPER_COLORED_SHULKER_TEXTURE_LOCATION.get(dyeColor);
      case CRYSTAL -> CRYSTAL_COLORED_SHULKER_TEXTURE_LOCATION.get(dyeColor);
      case OBSIDIAN -> OBSIDIAN_COLORED_SHULKER_TEXTURE_LOCATION.get(dyeColor);
      default -> COLORED_SHULKER_TEXTURE_LOCATION.get(dyeColor);
    };
  }

  public static ResourceLocation chooseShulkerBoxTexture(IronShulkerBoxesTypes type) {
    return switch (type) {
      case IRON -> IRON_SHULKER_TEXTURE_LOCATION;
      case GOLD -> GOLD_SHULKER_TEXTURE_LOCATION;
      case DIAMOND -> DIAMOND_SHULKER_TEXTURE_LOCATION;
      case COPPER -> COPPER_SHULKER_TEXTURE_LOCATION;
      case CRYSTAL -> CRYSTAL_SHULKER_TEXTURE_LOCATION;
      case OBSIDIAN -> OBSIDIAN_SHULKER_TEXTURE_LOCATION;
      default -> SHULKER_TEXTURE_LOCATION;
    };
  }
}
