package com.progwml6.ironshulkerbox.common.blocks;

import com.progwml6.ironshulkerbox.common.core.IronShulkerBoxBlocks;
import com.progwml6.ironshulkerbox.common.tileentity.TileEntityCopperShulkerBox;
import com.progwml6.ironshulkerbox.common.tileentity.TileEntityCrystalShulkerBox;
import com.progwml6.ironshulkerbox.common.tileentity.TileEntityDiamondShulkerBox;
import com.progwml6.ironshulkerbox.common.tileentity.TileEntityGoldShulkerBox;
import com.progwml6.ironshulkerbox.common.tileentity.TileEntityIronShulkerBox;
import com.progwml6.ironshulkerbox.common.tileentity.TileEntityObsidianShulkerBox;
import com.progwml6.ironshulkerbox.common.tileentity.TileEntitySilverShulkerBox;
import com.progwml6.ironshulkerbox.common.util.BlockNames;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public enum IronShulkerBoxType implements IStringSerializable
{
    IRON(54, 9, "_iron.png", TileEntityIronShulkerBox.class, 184, 202, BlockNames.IRON_SHULKER_BOX),
    GOLD(81, 9, "_gold.png", TileEntityGoldShulkerBox.class, 184, 256, BlockNames.GOLD_SHULKER_BOX),
    DIAMOND(108, 12, "_diamond.png", TileEntityDiamondShulkerBox.class, 184, 256, BlockNames.DIAMOND_SHULKER_BOX),
    COPPER(45, 9, "_copper.png", TileEntityCopperShulkerBox.class, 184, 184, BlockNames.COPPER_SHULKER_BOX),
    SILVER(72, 9, "_silver.png", TileEntitySilverShulkerBox.class, 184, 238, BlockNames.SILVER_SHULKER_BOX),
    CRYSTAL(108, 12, "_crystal.png", TileEntityCrystalShulkerBox.class, 238, 256, BlockNames.CRYSTAL_SHULKER_BOX),
    OBSIDIAN(108, 12, "_obsidian.png", TileEntityObsidianShulkerBox.class, 238, 256, BlockNames.OBSIDIAN_SHULKER_BOX),
    VANILLA(0, 0, "", null, 0, 0, null);

    public static final IronShulkerBoxType VALUES[] = values();

    public final String name;

    public final int size;

    public final int rowLength;

    public final String modelTexture;

    public final Class<? extends TileEntity> clazz;

    public final int xSize;

    public final int ySize;

    public final String itemName;

    IronShulkerBoxType(int size, int rowLength, String modelTexture, Class<? extends TileEntityIronShulkerBox> clazz, int xSize, int ySize, String itemName)
    {
        this.name = this.name().toLowerCase();
        this.size = size;
        this.rowLength = rowLength;
        this.modelTexture = modelTexture;
        this.clazz = clazz;
        this.xSize = xSize;
        this.ySize = ySize;
        this.itemName = itemName;
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

    public static IronShulkerBoxType get(ResourceLocation resourceLocation, EnumDyeColor color)
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

    public static IBlockState get(IronShulkerBoxType type, EnumDyeColor color)
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

    public TileEntityIronShulkerBox makeEntity(@Nullable EnumDyeColor colorIn)
    {
        switch (this)
        {
            case IRON:
                return new TileEntityIronShulkerBox(colorIn);
            case GOLD:
                return new TileEntityGoldShulkerBox(colorIn);
            case DIAMOND:
                return new TileEntityDiamondShulkerBox(colorIn);
            case COPPER:
                return new TileEntityCopperShulkerBox(colorIn);
            case SILVER:
                return new TileEntitySilverShulkerBox(colorIn);
            case CRYSTAL:
                return new TileEntityCrystalShulkerBox(colorIn);
            case OBSIDIAN:
                return new TileEntityObsidianShulkerBox(colorIn);
            default:
                return null;
        }
    }
}