package com.progwml6.ironshulkerbox.common.block;

import com.progwml6.ironshulkerbox.common.block.tileentity.CopperShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.block.tileentity.CrystalShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.block.tileentity.DiamondShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.block.tileentity.GenericIronShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.block.tileentity.GoldShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.block.tileentity.IronShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.block.tileentity.ObsidianShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.block.tileentity.SilverShulkerBoxTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.util.Locale;

public enum IronShulkerBoxesTypes implements IStringSerializable {
  IRON(54, 9, "_iron.png", IronShulkerBoxTileEntity.class, 184, 222, new ResourceLocation("ironshulkerbox", "textures/gui/iron_container.png"), 256, 256),
  GOLD(81, 9, "_gold.png", IronShulkerBoxTileEntity.class, 184, 276, new ResourceLocation("ironshulkerbox", "textures/gui/gold_container.png"), 256, 276),
  DIAMOND(108, 12, "_diamond.png", IronShulkerBoxTileEntity.class, 238, 276, new ResourceLocation("ironshulkerbox", "textures/gui/diamond_container.png"), 256, 276),
  COPPER(45, 9, "_copper.png", IronShulkerBoxTileEntity.class, 184, 204, new ResourceLocation("ironshulkerbox", "textures/gui/copper_container.png"), 256, 256),
  SILVER(72, 9, "_silver.png", IronShulkerBoxTileEntity.class, 184, 258, new ResourceLocation("ironshulkerbox", "textures/gui/silver_container.png"), 256, 276),
  CRYSTAL(108, 12, "_crystal.png", IronShulkerBoxTileEntity.class, 238, 276, new ResourceLocation("ironshulkerbox", "textures/gui/diamond_container.png"), 256, 276),
  OBSIDIAN(108, 12, "_obsidian.png", IronShulkerBoxTileEntity.class, 238, 276, new ResourceLocation("ironshulkerbox", "textures/gui/diamond_container.png"), 256, 276),
  VANILLA(0, 0, "", null, 0, 0, null, 0, 0);

  public final String name;
  public final int size;
  public final int rowLength;
  public final String modelTexture;
  public final Class<? extends TileEntity> clazz;
  public final int xSize;
  public final int ySize;
  public final ResourceLocation guiTexture;
  public final int textureXSize;
  public final int textureYSize;

  IronShulkerBoxesTypes(int size, int rowLength, String modelTexture, Class<? extends IronShulkerBoxTileEntity> clazz, int xSize, int ySize, ResourceLocation guiTexture, int textureXSize, int textureYSize) {
    this.name = this.name().toLowerCase();
    this.size = size;
    this.rowLength = rowLength;
    this.modelTexture = modelTexture;
    this.clazz = clazz;
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
  public String func_176610_l() {
    return this.getEnglishName();
  }

  public int getRowCount() {
    return this.size / this.rowLength;
  }

  public boolean isTransparent() {
    return this == CRYSTAL;
  }

  /*public static IronShulkerBoxesTypes get(ResourceLocation resourceLocation, DyeColor color) {
    switch (resourceLocation.toString()) {
      case BlockNames.IRON_SHULKER_BOX:
        return IRON;
      case BlockNames.GOLD_SHULKER_BOX:
        return GOLD;
      case BlockNames.DIAMOND_SHULKER_BOX:
        return DIAMOND;
      case BlockNames.COPPER_SHULKER_BOX:
        return COPPER;
      case BlockNames.SILVER_SHULKER_BOX:
        return SILVER;
      case BlockNames.CRYSTAL_SHULKER_BOX:
        return CRYSTAL;
      case BlockNames.OBSIDIAN_SHULKER_BOX:
        return OBSIDIAN;
      default:
        return VANILLA;
    }
  }*/

  public static BlockState get(IronShulkerBoxesTypes type, DyeColor color) {
    switch (type) {
      case IRON:
        return ShulkerBoxesBlocks.IRON_SHULKER_BOXES.get(color.getId()).get().getDefaultState();
      case GOLD:
        return ShulkerBoxesBlocks.GOLD_SHULKER_BOXES.get(color.getId()).get().getDefaultState();
      case DIAMOND:
        return ShulkerBoxesBlocks.DIAMOND_SHULKER_BOXES.get(color.getId()).get().getDefaultState();
      case CRYSTAL:
        return ShulkerBoxesBlocks.CRYSTAL_SHULKER_BOXES.get(color.getId()).get().getDefaultState();
      case COPPER:
        return ShulkerBoxesBlocks.COPPER_SHULKER_BOXES.get(color.getId()).get().getDefaultState();
      case SILVER:
        return ShulkerBoxesBlocks.SILVER_SHULKER_BOXES.get(color.getId()).get().getDefaultState();
      case OBSIDIAN:
        return ShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOXES.get(color.getId()).get().getDefaultState();
      default:
        return null;
    }
  }

  public GenericIronShulkerBoxTileEntity makeEntity(@Nullable DyeColor colorIn) {
    switch (this) {
      case IRON:
        return new IronShulkerBoxTileEntity(colorIn);
      case GOLD:
        return new GoldShulkerBoxTileEntity(colorIn);
      case DIAMOND:
        return new DiamondShulkerBoxTileEntity(colorIn);
      case COPPER:
        return new CopperShulkerBoxTileEntity(colorIn);
      case SILVER:
        return new SilverShulkerBoxTileEntity(colorIn);
      case CRYSTAL:
        return new CrystalShulkerBoxTileEntity(colorIn);
      case OBSIDIAN:
        return new ObsidianShulkerBoxTileEntity(colorIn);
      default:
        return null;
    }
  }
}
