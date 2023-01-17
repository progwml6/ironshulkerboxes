package com.progwml6.ironshulkerbox.common.block;

import com.progwml6.ironshulkerbox.common.Util;
import com.progwml6.ironshulkerbox.common.block.entity.AbstractIronShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.block.entity.CopperShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.block.entity.CrystalShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.block.entity.DiamondShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.block.entity.GoldShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.block.entity.IronShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.block.entity.ObsidianShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.Locale;

public enum IronShulkerBoxesTypes implements StringRepresentable {
  IRON(54, 9, 184, 222, new ResourceLocation("ironshulkerbox", "textures/gui/iron_container.png"), 256, 256),
  GOLD(81, 9, 184, 276, new ResourceLocation("ironshulkerbox", "textures/gui/gold_container.png"), 256, 276),
  DIAMOND(108, 12, 238, 276, new ResourceLocation("ironshulkerbox", "textures/gui/diamond_container.png"), 256, 276),
  COPPER(45, 9, 184, 204, new ResourceLocation("ironshulkerbox", "textures/gui/copper_container.png"), 256, 256),
  CRYSTAL(108, 12, 238, 276, new ResourceLocation("ironshulkerbox", "textures/gui/diamond_container.png"), 256, 276),
  OBSIDIAN(108, 12, 238, 276, new ResourceLocation("ironshulkerbox", "textures/gui/diamond_container.png"), 256, 276),
  VANILLA(0, 0, 0, 0, new ResourceLocation("textures/gui/container/shulker_box.png"), 0, 0);

  private final String name;
  public final int size;
  public final int rowLength;
  public final int xSize;
  public final int ySize;
  public final ResourceLocation guiTexture;
  public final int textureXSize;
  public final int textureYSize;

  IronShulkerBoxesTypes(int size, int rowLength, int xSize, int ySize, ResourceLocation guiTexture, int textureXSize, int textureYSize) {
    this.name = Util.toEnglishName(this.name());
    this.size = size;
    this.rowLength = rowLength;
    this.xSize = xSize;
    this.ySize = ySize;
    this.guiTexture = guiTexture;
    this.textureXSize = textureXSize;
    this.textureYSize = textureYSize;
  }

  public String getId() {
    return this.name().toLowerCase(Locale.ROOT);
  }

  public String getEnglishName() {
    return this.name;
  }

  @Override
  public String getSerializedName() {
    return this.getEnglishName();
  }

  public int getRowCount() {
    return this.size / this.rowLength;
  }

  public boolean isTransparent() {
    return this == CRYSTAL;
  }

  @Nullable
  public AbstractIronShulkerBoxBlockEntity makeEntity(BlockPos blockPos, BlockState blockState, @Nullable DyeColor color) {
    return switch (this) {
      case IRON -> new IronShulkerBoxBlockEntity(color, blockPos, blockState);
      case GOLD -> new GoldShulkerBoxBlockEntity(color, blockPos, blockState);
      case DIAMOND -> new DiamondShulkerBoxBlockEntity(color, blockPos, blockState);
      case COPPER -> new CopperShulkerBoxBlockEntity(color, blockPos, blockState);
      case CRYSTAL -> new CrystalShulkerBoxBlockEntity(color, blockPos, blockState);
      case OBSIDIAN -> new ObsidianShulkerBoxBlockEntity(color, blockPos, blockState);
      default -> null;
    };
  }

  public static Block get(IronShulkerBoxesTypes type, @Nullable DyeColor color) {
    if (color == null) {
      return switch (type) {
        case IRON -> IronShulkerBoxesBlocks.IRON_SHULKER_BOX.get();
        case GOLD -> IronShulkerBoxesBlocks.GOLD_SHULKER_BOX.get();
        case DIAMOND -> IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOX.get();
        case CRYSTAL -> IronShulkerBoxesBlocks.CRYSTAL_SHULKER_BOX.get();
        case COPPER -> IronShulkerBoxesBlocks.COPPER_SHULKER_BOX.get();
        case OBSIDIAN -> IronShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOX.get();
        default -> Blocks.SHULKER_BOX;
      };
    } else {
      return switch (type) {
        case IRON -> IronShulkerBoxesBlocks.IRON_SHULKER_BOXES.get(color).get();
        case GOLD -> IronShulkerBoxesBlocks.GOLD_SHULKER_BOXES.get(color).get();
        case DIAMOND -> IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOXES.get(color).get();
        case CRYSTAL -> IronShulkerBoxesBlocks.CRYSTAL_SHULKER_BOXES.get(color).get();
        case COPPER -> IronShulkerBoxesBlocks.COPPER_SHULKER_BOXES.get(color).get();
        case OBSIDIAN -> IronShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOXES.get(color).get();
        default -> switch (color) {
          case WHITE -> Blocks.WHITE_SHULKER_BOX;
          case ORANGE -> Blocks.ORANGE_SHULKER_BOX;
          case MAGENTA -> Blocks.MAGENTA_SHULKER_BOX;
          case LIGHT_BLUE -> Blocks.LIGHT_BLUE_SHULKER_BOX;
          case YELLOW -> Blocks.YELLOW_SHULKER_BOX;
          case LIME -> Blocks.LIME_SHULKER_BOX;
          case PINK -> Blocks.PINK_SHULKER_BOX;
          case GRAY -> Blocks.GRAY_SHULKER_BOX;
          case LIGHT_GRAY -> Blocks.LIGHT_GRAY_SHULKER_BOX;
          case CYAN -> Blocks.CYAN_SHULKER_BOX;
          case PURPLE -> Blocks.PURPLE_SHULKER_BOX;
          case BLUE -> Blocks.BLUE_SHULKER_BOX;
          case BROWN -> Blocks.BROWN_SHULKER_BOX;
          case GREEN -> Blocks.GREEN_SHULKER_BOX;
          case RED -> Blocks.RED_SHULKER_BOX;
          case BLACK -> Blocks.BLACK_SHULKER_BOX;
        };
      };
    }
  }
}
