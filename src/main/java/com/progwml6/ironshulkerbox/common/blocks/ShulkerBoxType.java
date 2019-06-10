package com.progwml6.ironshulkerbox.common.blocks;

import com.progwml6.ironshulkerbox.common.core.IronShulkerBoxBlocks;
import com.progwml6.ironshulkerbox.common.tileentity.CopperShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.tileentity.CrystalShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.tileentity.DiamondShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.tileentity.GoldShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.tileentity.IronShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.tileentity.ObsidianShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.tileentity.SilverShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.util.BlockNames;
import net.minecraft.block.BlockState;
import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public enum ShulkerBoxType implements IStringSerializable
{
    IRON(54, 9, "_iron.png", IronShulkerBoxTileEntity.class, BlockNames.IRON_SHULKER_BOX, 184, 202, new ResourceLocation("ironshulkerbox", "textures/gui/iron_container.png")),
    GOLD(81, 9, "_gold.png", GoldShulkerBoxTileEntity.class, BlockNames.GOLD_SHULKER_BOX, 184, 256, new ResourceLocation("ironshulkerbox", "textures/gui/gold_container.png")),
    DIAMOND(108, 12, "_diamond.png", DiamondShulkerBoxTileEntity.class, BlockNames.DIAMOND_SHULKER_BOX, 238, 256, new ResourceLocation("ironshulkerbox", "textures/gui/diamond_container.png")),
    COPPER(45, 9, "_copper.png", CopperShulkerBoxTileEntity.class, BlockNames.COPPER_SHULKER_BOX, 184, 184, new ResourceLocation("ironshulkerbox", "textures/gui/copper_container.png")),
    SILVER(72, 9, "_silver.png", SilverShulkerBoxTileEntity.class, BlockNames.SILVER_SHULKER_BOX, 184, 238, new ResourceLocation("ironshulkerbox", "textures/gui/silver_container.png")),
    CRYSTAL(108, 12, "_crystal.png", CrystalShulkerBoxTileEntity.class, BlockNames.CRYSTAL_SHULKER_BOX, 238, 256, new ResourceLocation("ironshulkerbox", "textures/gui/diamond_container.png")),
    OBSIDIAN(108, 12, "_obsidian.png", ObsidianShulkerBoxTileEntity.class, BlockNames.OBSIDIAN_SHULKER_BOX, 238, 256, new ResourceLocation("ironshulkerbox", "textures/gui/diamond_container.png")),
    VANILLA(0, 0, "", null, null, 0, 0, null);

    public static final ShulkerBoxType VALUES[] = values();

    public final String name;

    public final int size;

    public final int rowLength;

    public final String modelTexture;

    public final Class<? extends TileEntity> clazz;

    public final int xSize;

    public final int ySize;

    public final String itemName;

    public final ResourceLocation guiTexture;

    ShulkerBoxType(int size, int rowLength, String modelTexture, Class<? extends IronShulkerBoxTileEntity> clazz, String itemName, int xSize, int ySize, ResourceLocation guiTexture)
    {
        this.name = this.name().toLowerCase();
        this.size = size;
        this.rowLength = rowLength;
        this.modelTexture = modelTexture;
        this.clazz = clazz;
        this.itemName = itemName;

        this.xSize = xSize;
        this.ySize = ySize;
        this.guiTexture = guiTexture;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    public int getRowCount()
    {
        return this.size / this.rowLength;
    }

    public boolean isTransparent()
    {
        return this == CRYSTAL;
    }

    public static ShulkerBoxType get(ResourceLocation resourceLocation, DyeColor color)
    {
        switch (resourceLocation.toString())
        {
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
    }

    public static BlockState get(ShulkerBoxType type, DyeColor color)
    {
        switch (type)
        {
            case IRON:
                return IronShulkerBoxBlocks.ironShulkerBoxes.get(color.getId()).getDefaultState();
            case GOLD:
                return IronShulkerBoxBlocks.goldShulkerBoxes.get(color.getId()).getDefaultState();
            case DIAMOND:
                return IronShulkerBoxBlocks.diamondShulkerBoxes.get(color.getId()).getDefaultState();
            case CRYSTAL:
                return IronShulkerBoxBlocks.crystalShulkerBoxes.get(color.getId()).getDefaultState();
            case COPPER:
                return IronShulkerBoxBlocks.copperShulkerBoxes.get(color.getId()).getDefaultState();
            case SILVER:
                return IronShulkerBoxBlocks.silverShulkerBoxes.get(color.getId()).getDefaultState();
            case OBSIDIAN:
                return IronShulkerBoxBlocks.obsidianShulkerBoxes.get(color.getId()).getDefaultState();
            default:
                return null;
        }
    }

    public IronShulkerBoxTileEntity makeEntity(@Nullable DyeColor colorIn)
    {
        switch (this)
        {
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
