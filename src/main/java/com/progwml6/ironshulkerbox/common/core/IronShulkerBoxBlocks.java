package com.progwml6.ironshulkerbox.common.core;

import com.progwml6.ironshulkerbox.IronShulkerBox;
import com.progwml6.ironshulkerbox.client.renderer.TileEntityIronShulkerBoxItemRenderer;
import com.progwml6.ironshulkerbox.common.blocks.BlockCopperShulkerBox;
import com.progwml6.ironshulkerbox.common.blocks.BlockCrystalShulkerBox;
import com.progwml6.ironshulkerbox.common.blocks.BlockDiamondShulkerBox;
import com.progwml6.ironshulkerbox.common.blocks.BlockGoldShulkerBox;
import com.progwml6.ironshulkerbox.common.blocks.BlockIronShulkerBox;
import com.progwml6.ironshulkerbox.common.blocks.BlockObsidianShulkerBox;
import com.progwml6.ironshulkerbox.common.blocks.BlockShulkerBox;
import com.progwml6.ironshulkerbox.common.blocks.BlockSilverShulkerBox;
import com.progwml6.ironshulkerbox.common.items.ItemShulkerBox;
import com.progwml6.ironshulkerbox.common.util.BlockColors;
import com.progwml6.ironshulkerbox.common.util.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import java.util.Arrays;
import java.util.List;

public class IronShulkerBoxBlocks
{
    public static Item.Builder itemBuilder;

    //@formatter:off
    // IRON START
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.WHITE)
    public static BlockShulkerBox whiteIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.WHITE)
    public static Item whiteIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    public static BlockShulkerBox orangeIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    public static Item orangeIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    public static BlockShulkerBox magentaIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    public static Item magentaIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    public static BlockShulkerBox lightBlueIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    public static Item lightBlueIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    public static BlockShulkerBox yellowIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    public static Item yellowIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.LIME)
    public static BlockShulkerBox limeIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.LIME)
    public static Item limeIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.PINK)
    public static BlockShulkerBox pinkIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.PINK)
    public static Item pinkIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.GRAY)
    public static BlockShulkerBox grayIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.GRAY)
    public static Item grayIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    public static BlockShulkerBox lightGrayIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    public static Item lightGrayIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.CYAN)
    public static BlockShulkerBox cyanIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.CYAN)
    public static Item cyanIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    public static BlockShulkerBox purpleIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    public static Item purpleIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.BLUE)
    public static BlockShulkerBox blueIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.BLUE)
    public static Item blueIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.BROWN)
    public static BlockShulkerBox brownIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.BROWN)
    public static Item brownIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.GREEN)
    public static BlockShulkerBox greenIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.GREEN)
    public static Item greenIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.RED)
    public static BlockShulkerBox redIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.RED)
    public static Item redIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.BLACK)
    public static BlockShulkerBox blackIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.BLACK)
    public static Item blackIronShulkerBoxItemBlock;
    // IRON END

    // GOLD START
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.WHITE)
    public static BlockShulkerBox whiteGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.WHITE)
    public static Item whiteGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    public static BlockShulkerBox orangeGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    public static Item orangeGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    public static BlockShulkerBox magentaGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    public static Item magentaGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    public static BlockShulkerBox lightBlueGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    public static Item lightBlueGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    public static BlockShulkerBox yellowGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    public static Item yellowGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.LIME)
    public static BlockShulkerBox limeGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.LIME)
    public static Item limeGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.PINK)
    public static BlockShulkerBox pinkGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.PINK)
    public static Item pinkGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.GRAY)
    public static BlockShulkerBox grayGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.GRAY)
    public static Item grayGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    public static BlockShulkerBox lightGrayGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    public static Item lightGrayGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.CYAN)
    public static BlockShulkerBox cyanGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.CYAN)
    public static Item cyanGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    public static BlockShulkerBox purpleGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    public static Item purpleGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.BLUE)
    public static BlockShulkerBox blueGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.BLUE)
    public static Item blueGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.BROWN)
    public static BlockShulkerBox brownGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.BROWN)
    public static Item brownGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.GREEN)
    public static BlockShulkerBox greenGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.GREEN)
    public static Item greenGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.RED)
    public static BlockShulkerBox redGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.RED)
    public static Item redGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.BLACK)
    public static BlockShulkerBox blackGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.BLACK)
    public static Item blackGoldShulkerBoxItemBlock;
    // GOLD END

    // DIAMOND START
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.WHITE)
    public static BlockShulkerBox whiteDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.WHITE)
    public static Item whiteDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    public static BlockShulkerBox orangeDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    public static Item orangeDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    public static BlockShulkerBox magentaDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    public static Item magentaDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    public static BlockShulkerBox lightBlueDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    public static Item lightBlueDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    public static BlockShulkerBox yellowDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    public static Item yellowDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.LIME)
    public static BlockShulkerBox limeDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.LIME)
    public static Item limeDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.PINK)
    public static BlockShulkerBox pinkDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.PINK)
    public static Item pinkDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.GRAY)
    public static BlockShulkerBox grayDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.GRAY)
    public static Item grayDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    public static BlockShulkerBox lightGrayDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    public static Item lightGrayDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.CYAN)
    public static BlockShulkerBox cyanDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.CYAN)
    public static Item cyanDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    public static BlockShulkerBox purpleDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    public static Item purpleDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.BLUE)
    public static BlockShulkerBox blueDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.BLUE)
    public static Item blueDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.BROWN)
    public static BlockShulkerBox brownDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.BROWN)
    public static Item brownDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.GREEN)
    public static BlockShulkerBox greenDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.GREEN)
    public static Item greenDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.RED)
    public static BlockShulkerBox redDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.RED)
    public static Item redDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.BLACK)
    public static BlockShulkerBox blackDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.BLACK)
    public static Item blackDiamondShulkerBoxItemBlock;
    // DIAMOND END

    // COPPER START
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.WHITE)
    public static BlockShulkerBox whiteCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.WHITE)
    public static Item whiteCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    public static BlockShulkerBox orangeCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    public static Item orangeCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    public static BlockShulkerBox magentaCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    public static Item magentaCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    public static BlockShulkerBox lightBlueCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    public static Item lightBlueCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    public static BlockShulkerBox yellowCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    public static Item yellowCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.LIME)
    public static BlockShulkerBox limeCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.LIME)
    public static Item limeCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.PINK)
    public static BlockShulkerBox pinkCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.PINK)
    public static Item pinkCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.GRAY)
    public static BlockShulkerBox grayCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.GRAY)
    public static Item grayCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    public static BlockShulkerBox lightGrayCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    public static Item lightGrayCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.CYAN)
    public static BlockShulkerBox cyanCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.CYAN)
    public static Item cyanCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    public static BlockShulkerBox purpleCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    public static Item purpleCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.BLUE)
    public static BlockShulkerBox blueCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.BLUE)
    public static Item blueCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.BROWN)
    public static BlockShulkerBox brownCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.BROWN)
    public static Item brownCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.GREEN)
    public static BlockShulkerBox greenCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.GREEN)
    public static Item greenCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.RED)
    public static BlockShulkerBox redCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.RED)
    public static Item redCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.BLACK)
    public static BlockShulkerBox blackCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.BLACK)
    public static Item blackCopperShulkerBoxItemBlock;
    // COPPER END

    // SILVER START
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.WHITE)
    public static BlockShulkerBox whiteSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.WHITE)
    public static Item whiteSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    public static BlockShulkerBox orangeSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    public static Item orangeSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    public static BlockShulkerBox magentaSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    public static Item magentaSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    public static BlockShulkerBox lightBlueSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    public static Item lightBlueSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    public static BlockShulkerBox yellowSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    public static Item yellowSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.LIME)
    public static BlockShulkerBox limeSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.LIME)
    public static Item limeSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.PINK)
    public static BlockShulkerBox pinkSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.PINK)
    public static Item pinkSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.GRAY)
    public static BlockShulkerBox graySilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.GRAY)
    public static Item graySilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    public static BlockShulkerBox lightGraySilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    public static Item lightGraySilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.CYAN)
    public static BlockShulkerBox cyanSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.CYAN)
    public static Item cyanSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    public static BlockShulkerBox purpleSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    public static Item purpleSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.BLUE)
    public static BlockShulkerBox blueSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.BLUE)
    public static Item blueSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.BROWN)
    public static BlockShulkerBox brownSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.BROWN)
    public static Item brownSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.GREEN)
    public static BlockShulkerBox greenSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.GREEN)
    public static Item greenSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.RED)
    public static BlockShulkerBox redSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.RED)
    public static Item redSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.BLACK)
    public static BlockShulkerBox blackSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.BLACK)
    public static Item blackSilverShulkerBoxItemBlock;
    // SILVER END

    // CRYSTAL START
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.WHITE)
    public static BlockShulkerBox whiteCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.WHITE)
    public static Item whiteCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    public static BlockShulkerBox orangeCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    public static Item orangeCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    public static BlockShulkerBox magentaCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    public static Item magentaCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    public static BlockShulkerBox lightBlueCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    public static Item lightBlueCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    public static BlockShulkerBox yellowCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    public static Item yellowCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.LIME)
    public static BlockShulkerBox limeCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.LIME)
    public static Item limeCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.PINK)
    public static BlockShulkerBox pinkCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.PINK)
    public static Item pinkCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.GRAY)
    public static BlockShulkerBox grayCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.GRAY)
    public static Item grayCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    public static BlockShulkerBox lightGrayCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    public static Item lightGrayCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.CYAN)
    public static BlockShulkerBox cyanCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.CYAN)
    public static Item cyanCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    public static BlockShulkerBox purpleCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    public static Item purpleCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.BLUE)
    public static BlockShulkerBox blueCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.BLUE)
    public static Item blueCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.BROWN)
    public static BlockShulkerBox brownCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.BROWN)
    public static Item brownCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.GREEN)
    public static BlockShulkerBox greenCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.GREEN)
    public static Item greenCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.RED)
    public static BlockShulkerBox redCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.RED)
    public static Item redCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.BLACK)
    public static BlockShulkerBox blackCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.BLACK)
    public static Item blackCrystalShulkerBoxItemBlock;
    // CRYSTAL END

    // OBSIDIAN START
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.WHITE)
    public static BlockShulkerBox whiteObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.WHITE)
    public static Item whiteObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    public static BlockShulkerBox orangeObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    public static Item orangeObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    public static BlockShulkerBox magentaObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    public static Item magentaObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    public static BlockShulkerBox lightBlueObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    public static Item lightBlueObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    public static BlockShulkerBox yellowObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    public static Item yellowObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.LIME)
    public static BlockShulkerBox limeObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.LIME)
    public static Item limeObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.PINK)
    public static BlockShulkerBox pinkObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.PINK)
    public static Item pinkObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.GRAY)
    public static BlockShulkerBox grayObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.GRAY)
    public static Item grayObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    public static BlockShulkerBox lightGrayObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    public static Item lightGrayObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.CYAN)
    public static BlockShulkerBox cyanObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.CYAN)
    public static Item cyanObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    public static BlockShulkerBox purpleObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    public static Item purpleObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.BLUE)
    public static BlockShulkerBox blueObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.BLUE)
    public static Item blueObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.BROWN)
    public static BlockShulkerBox brownObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.BROWN)
    public static Item brownObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.GREEN)
    public static BlockShulkerBox greenObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.GREEN)
    public static Item greenObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.RED)
    public static BlockShulkerBox redObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.RED)
    public static Item redObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.BLACK)
    public static BlockShulkerBox blackObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.BLACK)
    public static Item blackObsidianShulkerBoxItemBlock;
    // OBSIDIAN END

    public static List<BlockShulkerBox> ironShulkerBoxes;
    public static List<BlockShulkerBox> goldShulkerBoxes;
    public static List<BlockShulkerBox> diamondShulkerBoxes;
    public static List<BlockShulkerBox> copperShulkerBoxes;
    public static List<BlockShulkerBox> silverShulkerBoxes;
    public static List<BlockShulkerBox> crystalShulkerBoxes;
    public static List<BlockShulkerBox> obsidianShulkerBoxes;
    public static List<BlockShulkerBox> allShulkerBoxes;
    public static List<Item> shulkerBoxItemBlocks;
    //@formatter:on

    public IronShulkerBoxBlocks()
    {

    }

    @Mod.EventBusSubscriber(modid = IronShulkerBox.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration
    {
        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event)
        {
            IForgeRegistry<Block> blockRegistry = event.getRegistry();

            for (EnumDyeColor color : EnumDyeColor.values())
            {
                blockRegistry.register(new BlockIronShulkerBox(color, Block.Builder.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)));
                blockRegistry.register(new BlockGoldShulkerBox(color, Block.Builder.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)));
                blockRegistry.register(new BlockDiamondShulkerBox(color, Block.Builder.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)));
                blockRegistry.register(new BlockCopperShulkerBox(color, Block.Builder.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)));
                blockRegistry.register(new BlockSilverShulkerBox(color, Block.Builder.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)));
                blockRegistry.register(new BlockCrystalShulkerBox(color, Block.Builder.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)));
                blockRegistry.register(new BlockObsidianShulkerBox(color, Block.Builder.create(Material.IRON).hardnessAndResistance(3.0F, 10000.0F)));

            }
        }

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event)
        {
            IForgeRegistry<Item> itemRegistry = event.getRegistry();

            //@formatter:off
            ironShulkerBoxes = Arrays.asList(whiteIronShulkerBoxBlock, orangeIronShulkerBoxBlock, magentaIronShulkerBoxBlock, lightBlueIronShulkerBoxBlock, yellowIronShulkerBoxBlock, limeIronShulkerBoxBlock, pinkIronShulkerBoxBlock, grayIronShulkerBoxBlock, lightGrayIronShulkerBoxBlock, cyanIronShulkerBoxBlock, purpleIronShulkerBoxBlock, blueIronShulkerBoxBlock, brownIronShulkerBoxBlock, greenIronShulkerBoxBlock, redIronShulkerBoxBlock, blackIronShulkerBoxBlock);
            goldShulkerBoxes = Arrays.asList(whiteGoldShulkerBoxBlock, orangeGoldShulkerBoxBlock, magentaGoldShulkerBoxBlock, lightBlueGoldShulkerBoxBlock, yellowGoldShulkerBoxBlock, limeGoldShulkerBoxBlock, pinkGoldShulkerBoxBlock, grayGoldShulkerBoxBlock, lightGrayGoldShulkerBoxBlock, cyanGoldShulkerBoxBlock, purpleGoldShulkerBoxBlock, blueGoldShulkerBoxBlock, brownGoldShulkerBoxBlock, greenGoldShulkerBoxBlock, redGoldShulkerBoxBlock, blackGoldShulkerBoxBlock);
            diamondShulkerBoxes = Arrays.asList(whiteDiamondShulkerBoxBlock, orangeDiamondShulkerBoxBlock, magentaDiamondShulkerBoxBlock, lightBlueDiamondShulkerBoxBlock, yellowDiamondShulkerBoxBlock, limeDiamondShulkerBoxBlock, pinkDiamondShulkerBoxBlock, grayDiamondShulkerBoxBlock, lightGrayDiamondShulkerBoxBlock, cyanDiamondShulkerBoxBlock, purpleDiamondShulkerBoxBlock, blueDiamondShulkerBoxBlock, brownDiamondShulkerBoxBlock, greenDiamondShulkerBoxBlock, redDiamondShulkerBoxBlock, blackDiamondShulkerBoxBlock);
            copperShulkerBoxes = Arrays.asList(whiteCopperShulkerBoxBlock, orangeCopperShulkerBoxBlock, magentaCopperShulkerBoxBlock, lightBlueCopperShulkerBoxBlock, yellowCopperShulkerBoxBlock, limeCopperShulkerBoxBlock, pinkCopperShulkerBoxBlock, grayCopperShulkerBoxBlock, lightGrayCopperShulkerBoxBlock, cyanCopperShulkerBoxBlock, purpleCopperShulkerBoxBlock, blueCopperShulkerBoxBlock, brownCopperShulkerBoxBlock, greenCopperShulkerBoxBlock, redCopperShulkerBoxBlock, blackCopperShulkerBoxBlock);
            silverShulkerBoxes = Arrays.asList(whiteSilverShulkerBoxBlock, orangeSilverShulkerBoxBlock, magentaSilverShulkerBoxBlock, lightBlueSilverShulkerBoxBlock, yellowSilverShulkerBoxBlock, limeSilverShulkerBoxBlock, pinkSilverShulkerBoxBlock, graySilverShulkerBoxBlock, lightGraySilverShulkerBoxBlock, cyanSilverShulkerBoxBlock, purpleSilverShulkerBoxBlock, blueSilverShulkerBoxBlock, brownSilverShulkerBoxBlock, greenSilverShulkerBoxBlock, redSilverShulkerBoxBlock, blackSilverShulkerBoxBlock);
            crystalShulkerBoxes = Arrays.asList(whiteCrystalShulkerBoxBlock, orangeCrystalShulkerBoxBlock, magentaCrystalShulkerBoxBlock, lightBlueCrystalShulkerBoxBlock, yellowCrystalShulkerBoxBlock, limeCrystalShulkerBoxBlock, pinkCrystalShulkerBoxBlock, grayCrystalShulkerBoxBlock, lightGrayCrystalShulkerBoxBlock, cyanCrystalShulkerBoxBlock, purpleCrystalShulkerBoxBlock, blueCrystalShulkerBoxBlock, brownCrystalShulkerBoxBlock, greenCrystalShulkerBoxBlock, redCrystalShulkerBoxBlock, blackCrystalShulkerBoxBlock);
            obsidianShulkerBoxes = Arrays.asList(whiteObsidianShulkerBoxBlock, orangeObsidianShulkerBoxBlock, magentaObsidianShulkerBoxBlock, lightBlueObsidianShulkerBoxBlock, yellowObsidianShulkerBoxBlock, limeObsidianShulkerBoxBlock, pinkObsidianShulkerBoxBlock, grayObsidianShulkerBoxBlock, lightGrayObsidianShulkerBoxBlock, cyanObsidianShulkerBoxBlock, purpleObsidianShulkerBoxBlock, blueObsidianShulkerBoxBlock, brownObsidianShulkerBoxBlock, greenObsidianShulkerBoxBlock, redObsidianShulkerBoxBlock, blackObsidianShulkerBoxBlock);

            allShulkerBoxes = Arrays.asList(whiteIronShulkerBoxBlock, orangeIronShulkerBoxBlock, magentaIronShulkerBoxBlock, lightBlueIronShulkerBoxBlock, yellowIronShulkerBoxBlock, limeIronShulkerBoxBlock, pinkIronShulkerBoxBlock, grayIronShulkerBoxBlock, lightGrayIronShulkerBoxBlock, cyanIronShulkerBoxBlock, purpleIronShulkerBoxBlock, blueIronShulkerBoxBlock, brownIronShulkerBoxBlock, greenIronShulkerBoxBlock, redIronShulkerBoxBlock, blackIronShulkerBoxBlock, whiteGoldShulkerBoxBlock, orangeGoldShulkerBoxBlock, magentaGoldShulkerBoxBlock, lightBlueGoldShulkerBoxBlock, yellowGoldShulkerBoxBlock, limeGoldShulkerBoxBlock, pinkGoldShulkerBoxBlock, grayGoldShulkerBoxBlock, lightGrayGoldShulkerBoxBlock, cyanGoldShulkerBoxBlock, purpleGoldShulkerBoxBlock, blueGoldShulkerBoxBlock, brownGoldShulkerBoxBlock, greenGoldShulkerBoxBlock, redGoldShulkerBoxBlock, blackGoldShulkerBoxBlock, whiteDiamondShulkerBoxBlock, orangeDiamondShulkerBoxBlock, magentaDiamondShulkerBoxBlock, lightBlueDiamondShulkerBoxBlock, yellowDiamondShulkerBoxBlock, limeDiamondShulkerBoxBlock, pinkDiamondShulkerBoxBlock, grayDiamondShulkerBoxBlock, lightGrayDiamondShulkerBoxBlock, cyanDiamondShulkerBoxBlock, purpleDiamondShulkerBoxBlock, blueDiamondShulkerBoxBlock, brownDiamondShulkerBoxBlock, greenDiamondShulkerBoxBlock, redDiamondShulkerBoxBlock, blackDiamondShulkerBoxBlock, whiteCopperShulkerBoxBlock, orangeCopperShulkerBoxBlock, magentaCopperShulkerBoxBlock, lightBlueCopperShulkerBoxBlock, yellowCopperShulkerBoxBlock, limeCopperShulkerBoxBlock, pinkCopperShulkerBoxBlock, grayCopperShulkerBoxBlock, lightGrayCopperShulkerBoxBlock, cyanCopperShulkerBoxBlock, purpleCopperShulkerBoxBlock, blueCopperShulkerBoxBlock, brownCopperShulkerBoxBlock, greenCopperShulkerBoxBlock, redCopperShulkerBoxBlock, blackCopperShulkerBoxBlock, whiteSilverShulkerBoxBlock, orangeSilverShulkerBoxBlock, magentaSilverShulkerBoxBlock, lightBlueSilverShulkerBoxBlock, yellowSilverShulkerBoxBlock, limeSilverShulkerBoxBlock, pinkSilverShulkerBoxBlock, graySilverShulkerBoxBlock, lightGraySilverShulkerBoxBlock, cyanSilverShulkerBoxBlock, purpleSilverShulkerBoxBlock, blueSilverShulkerBoxBlock, brownSilverShulkerBoxBlock, greenSilverShulkerBoxBlock, redSilverShulkerBoxBlock, blackSilverShulkerBoxBlock, whiteCrystalShulkerBoxBlock, orangeCrystalShulkerBoxBlock, magentaCrystalShulkerBoxBlock, lightBlueCrystalShulkerBoxBlock, yellowCrystalShulkerBoxBlock, limeCrystalShulkerBoxBlock, pinkCrystalShulkerBoxBlock, grayCrystalShulkerBoxBlock, lightGrayCrystalShulkerBoxBlock, cyanCrystalShulkerBoxBlock, purpleCrystalShulkerBoxBlock, blueCrystalShulkerBoxBlock, brownCrystalShulkerBoxBlock, greenCrystalShulkerBoxBlock, redCrystalShulkerBoxBlock, blackCrystalShulkerBoxBlock, whiteObsidianShulkerBoxBlock, orangeObsidianShulkerBoxBlock, magentaObsidianShulkerBoxBlock, lightBlueObsidianShulkerBoxBlock, yellowObsidianShulkerBoxBlock, limeObsidianShulkerBoxBlock, pinkObsidianShulkerBoxBlock, grayObsidianShulkerBoxBlock, lightGrayObsidianShulkerBoxBlock, cyanObsidianShulkerBoxBlock, purpleObsidianShulkerBoxBlock, blueObsidianShulkerBoxBlock, brownObsidianShulkerBoxBlock, greenObsidianShulkerBoxBlock, redObsidianShulkerBoxBlock, blackObsidianShulkerBoxBlock);
            //@formatter:on

            itemBuilder = (new Item.Builder()).group(IronShulkerBoxCreativeTabs.IRON_SHULKER_BOX).setTEISR(() -> TileEntityIronShulkerBoxItemRenderer::new);

            for (BlockShulkerBox shulkerBox : allShulkerBoxes)
            {
                itemRegistry.register(new ItemShulkerBox(shulkerBox, itemBuilder));
            }
        }
    }

    public static void createShulkerItemList()
    {
        //@formatter:off
        shulkerBoxItemBlocks = Arrays.asList(whiteIronShulkerBoxItemBlock, orangeIronShulkerBoxItemBlock, magentaIronShulkerBoxItemBlock, lightBlueIronShulkerBoxItemBlock, yellowIronShulkerBoxItemBlock, limeIronShulkerBoxItemBlock, pinkIronShulkerBoxItemBlock, grayIronShulkerBoxItemBlock, lightGrayIronShulkerBoxItemBlock, cyanIronShulkerBoxItemBlock, purpleIronShulkerBoxItemBlock, blueIronShulkerBoxItemBlock, brownIronShulkerBoxItemBlock, greenIronShulkerBoxItemBlock, redIronShulkerBoxItemBlock, blackIronShulkerBoxItemBlock, whiteGoldShulkerBoxItemBlock, orangeGoldShulkerBoxItemBlock, magentaGoldShulkerBoxItemBlock, lightBlueGoldShulkerBoxItemBlock, yellowGoldShulkerBoxItemBlock, limeGoldShulkerBoxItemBlock, pinkGoldShulkerBoxItemBlock, grayGoldShulkerBoxItemBlock, lightGrayGoldShulkerBoxItemBlock, cyanGoldShulkerBoxItemBlock, purpleGoldShulkerBoxItemBlock, blueGoldShulkerBoxItemBlock, brownGoldShulkerBoxItemBlock, greenGoldShulkerBoxItemBlock, redGoldShulkerBoxItemBlock, blackGoldShulkerBoxItemBlock, whiteDiamondShulkerBoxItemBlock, orangeDiamondShulkerBoxItemBlock, magentaDiamondShulkerBoxItemBlock, lightBlueDiamondShulkerBoxItemBlock, yellowDiamondShulkerBoxItemBlock, limeDiamondShulkerBoxItemBlock, pinkDiamondShulkerBoxItemBlock, grayDiamondShulkerBoxItemBlock, lightGrayDiamondShulkerBoxItemBlock, cyanDiamondShulkerBoxItemBlock, purpleDiamondShulkerBoxItemBlock, blueDiamondShulkerBoxItemBlock, brownDiamondShulkerBoxItemBlock, greenDiamondShulkerBoxItemBlock, redDiamondShulkerBoxItemBlock, blackDiamondShulkerBoxItemBlock, whiteCopperShulkerBoxItemBlock, orangeCopperShulkerBoxItemBlock, magentaCopperShulkerBoxItemBlock, lightBlueCopperShulkerBoxItemBlock, yellowCopperShulkerBoxItemBlock, limeCopperShulkerBoxItemBlock, pinkCopperShulkerBoxItemBlock, grayCopperShulkerBoxItemBlock, lightGrayCopperShulkerBoxItemBlock, cyanCopperShulkerBoxItemBlock, purpleCopperShulkerBoxItemBlock, blueCopperShulkerBoxItemBlock, brownCopperShulkerBoxItemBlock, greenCopperShulkerBoxItemBlock, redCopperShulkerBoxItemBlock, blackCopperShulkerBoxItemBlock, whiteSilverShulkerBoxItemBlock, orangeSilverShulkerBoxItemBlock, magentaSilverShulkerBoxItemBlock, lightBlueSilverShulkerBoxItemBlock, yellowSilverShulkerBoxItemBlock, limeSilverShulkerBoxItemBlock, pinkSilverShulkerBoxItemBlock, graySilverShulkerBoxItemBlock, lightGraySilverShulkerBoxItemBlock, cyanSilverShulkerBoxItemBlock, purpleSilverShulkerBoxItemBlock, blueSilverShulkerBoxItemBlock, brownSilverShulkerBoxItemBlock, greenSilverShulkerBoxItemBlock, redSilverShulkerBoxItemBlock, blackSilverShulkerBoxItemBlock, whiteCrystalShulkerBoxItemBlock, orangeCrystalShulkerBoxItemBlock, magentaCrystalShulkerBoxItemBlock, lightBlueCrystalShulkerBoxItemBlock, yellowCrystalShulkerBoxItemBlock, limeCrystalShulkerBoxItemBlock, pinkCrystalShulkerBoxItemBlock, grayCrystalShulkerBoxItemBlock, lightGrayCrystalShulkerBoxItemBlock, cyanCrystalShulkerBoxItemBlock, purpleCrystalShulkerBoxItemBlock, blueCrystalShulkerBoxItemBlock, brownCrystalShulkerBoxItemBlock, greenCrystalShulkerBoxItemBlock, redCrystalShulkerBoxItemBlock, blackCrystalShulkerBoxItemBlock, whiteObsidianShulkerBoxItemBlock, orangeObsidianShulkerBoxItemBlock, magentaObsidianShulkerBoxItemBlock, lightBlueObsidianShulkerBoxItemBlock, yellowObsidianShulkerBoxItemBlock, limeObsidianShulkerBoxItemBlock, pinkObsidianShulkerBoxItemBlock, grayObsidianShulkerBoxItemBlock, lightGrayObsidianShulkerBoxItemBlock, cyanObsidianShulkerBoxItemBlock, purpleObsidianShulkerBoxItemBlock, blueObsidianShulkerBoxItemBlock, brownObsidianShulkerBoxItemBlock, greenObsidianShulkerBoxItemBlock, redObsidianShulkerBoxItemBlock, blackObsidianShulkerBoxItemBlock);
        //@formatter:on
    }
}