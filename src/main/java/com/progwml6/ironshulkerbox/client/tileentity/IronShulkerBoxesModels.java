package com.progwml6.ironshulkerbox.client.tileentity;

import com.google.common.collect.ImmutableList;
import com.progwml6.ironshulkerbox.IronShulkerBoxes;
import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.stream.Stream;

@Mod.EventBusSubscriber(modid = IronShulkerBoxes.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class IronShulkerBoxesModels {

  public static final List<ResourceLocation> IRON_SHULKER_BOX_TEXTURES = Stream.of("white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black").map((color) -> getShulkerBoxResourceLocation("iron", color)).collect(ImmutableList.toImmutableList());
  public static final List<ResourceLocation> GOLD_SHULKER_BOX_TEXTURES = Stream.of("white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black").map((color) -> getShulkerBoxResourceLocation("gold", color)).collect(ImmutableList.toImmutableList());
  public static final List<ResourceLocation> DIAMOND_SHULKER_BOX_TEXTURES = Stream.of("white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black").map((color) -> getShulkerBoxResourceLocation("diamond", color)).collect(ImmutableList.toImmutableList());
  public static final List<ResourceLocation> COPPER_SHULKER_BOX_TEXTURES = Stream.of("white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black").map((color) -> getShulkerBoxResourceLocation("copper", color)).collect(ImmutableList.toImmutableList());
  public static final List<ResourceLocation> SILVER_SHULKER_BOX_TEXTURES = Stream.of("white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black").map((color) -> getShulkerBoxResourceLocation("silver", color)).collect(ImmutableList.toImmutableList());
  public static final List<ResourceLocation> CRYSTAL_SHULKER_BOX_TEXTURES = Stream.of("white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black").map((color) -> getShulkerBoxResourceLocation("crystal", color)).collect(ImmutableList.toImmutableList());
  public static final List<ResourceLocation> OBSIDIAN_SHULKER_BOX_TEXTURES = Stream.of("white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black").map((color) -> getShulkerBoxResourceLocation("obsidian", color)).collect(ImmutableList.toImmutableList());
  public static final List<ResourceLocation> VANILLA_SHULKER_BOX_TEXTURES = Stream.of("white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black").map(IronShulkerBoxesModels::getShulkerBoxResourceLocation).collect(ImmutableList.toImmutableList());

  private static ResourceLocation getShulkerBoxResourceLocation(String typeName, String colorName) {
    return new ResourceLocation(IronShulkerBoxes.MOD_ID, "model/" + colorName + "/shulker_" + colorName + "_" + typeName);
  }

  private static ResourceLocation getShulkerBoxResourceLocation(String colorName) {
    return new ResourceLocation("entity/shulker/shulker_" + colorName);
  }

  public static ResourceLocation chooseShulkerBoxModel(IronShulkerBoxesTypes type, int dyeColor) {
    switch (type) {
      case IRON:
        return IRON_SHULKER_BOX_TEXTURES.get(dyeColor);
      case GOLD:
        return GOLD_SHULKER_BOX_TEXTURES.get(dyeColor);
      case DIAMOND:
        return DIAMOND_SHULKER_BOX_TEXTURES.get(dyeColor);
      case COPPER:
        return COPPER_SHULKER_BOX_TEXTURES.get(dyeColor);
      case SILVER:
        return SILVER_SHULKER_BOX_TEXTURES.get(dyeColor);
      case CRYSTAL:
        return CRYSTAL_SHULKER_BOX_TEXTURES.get(dyeColor);
      case OBSIDIAN:
        return OBSIDIAN_SHULKER_BOX_TEXTURES.get(dyeColor);
      case VANILLA:
      default:
        return VANILLA_SHULKER_BOX_TEXTURES.get(dyeColor);
    }
  }

  @SubscribeEvent
  public static void onStitch(final TextureStitchEvent.Pre event) {
    if (!event.getMap().getTextureLocation().equals(Atlases.SHULKER_BOX_ATLAS)) {
      return;
    }

    IRON_SHULKER_BOX_TEXTURES.forEach(event::addSprite);
    GOLD_SHULKER_BOX_TEXTURES.forEach(event::addSprite);
    DIAMOND_SHULKER_BOX_TEXTURES.forEach(event::addSprite);
    COPPER_SHULKER_BOX_TEXTURES.forEach(event::addSprite);
    SILVER_SHULKER_BOX_TEXTURES.forEach(event::addSprite);
    CRYSTAL_SHULKER_BOX_TEXTURES.forEach(event::addSprite);
    OBSIDIAN_SHULKER_BOX_TEXTURES.forEach(event::addSprite);
  }
}
