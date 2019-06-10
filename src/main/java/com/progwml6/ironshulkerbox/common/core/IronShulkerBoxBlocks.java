package com.progwml6.ironshulkerbox.common.core;

import com.progwml6.ironshulkerbox.IronShulkerBox;
import com.progwml6.ironshulkerbox.client.renderer.IronShulkerBoxItemStackTileEntityRenderer;
import com.progwml6.ironshulkerbox.common.blocks.CopperShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.blocks.CrystalShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.blocks.DiamondShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.blocks.GoldShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.blocks.ObsidianShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.blocks.SilverShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.items.ShulkerBoxBlockItem;
import com.progwml6.ironshulkerbox.common.util.BlockColors;
import com.progwml6.ironshulkerbox.common.util.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;
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
    private static Item.Properties itemBuilder;

    //@formatter:off
    // IRON START
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.WHITE)
    private static ShulkerBoxBlock whiteIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.WHITE)
    private static Item whiteIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    private static ShulkerBoxBlock orangeIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    private static Item orangeIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    private static ShulkerBoxBlock magentaIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    private static Item magentaIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    private static ShulkerBoxBlock lightBlueIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    private static Item lightBlueIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    private static ShulkerBoxBlock yellowIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    private static Item yellowIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.LIME)
    private static ShulkerBoxBlock limeIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.LIME)
    private static Item limeIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.PINK)
    private static ShulkerBoxBlock pinkIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.PINK)
    private static Item pinkIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.GRAY)
    private static ShulkerBoxBlock grayIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.GRAY)
    private static Item grayIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    private static ShulkerBoxBlock lightGrayIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    private static Item lightGrayIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.CYAN)
    private static ShulkerBoxBlock cyanIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.CYAN)
    private static Item cyanIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    private static ShulkerBoxBlock purpleIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    private static Item purpleIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.BLUE)
    private static ShulkerBoxBlock blueIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.BLUE)
    private static Item blueIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.BROWN)
    private static ShulkerBoxBlock brownIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.BROWN)
    private static Item brownIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.GREEN)
    private static ShulkerBoxBlock greenIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.GREEN)
    private static Item greenIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.RED)
    public static ShulkerBoxBlock redIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.RED)
    private static Item redIronShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.BLACK)
    static ShulkerBoxBlock blackIronShulkerBoxBlock;
    @ObjectHolder(BlockNames.IRON_SHULKER_BOX_COLOR + BlockColors.BLACK)
    private static Item blackIronShulkerBoxItemBlock;
    // IRON END

    // GOLD START
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.WHITE)
    private static ShulkerBoxBlock whiteGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.WHITE)
    private static Item whiteGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    private static ShulkerBoxBlock orangeGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    private static Item orangeGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    private static ShulkerBoxBlock magentaGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    private static Item magentaGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    private static ShulkerBoxBlock lightBlueGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    private static Item lightBlueGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    private static ShulkerBoxBlock yellowGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    private static Item yellowGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.LIME)
    private static ShulkerBoxBlock limeGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.LIME)
    private static Item limeGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.PINK)
    private static ShulkerBoxBlock pinkGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.PINK)
    private static Item pinkGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.GRAY)
    private static ShulkerBoxBlock grayGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.GRAY)
    private static Item grayGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    private static ShulkerBoxBlock lightGrayGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    private static Item lightGrayGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.CYAN)
    private static ShulkerBoxBlock cyanGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.CYAN)
    private static Item cyanGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    private static ShulkerBoxBlock purpleGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    private static Item purpleGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.BLUE)
    private static ShulkerBoxBlock blueGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.BLUE)
    private static Item blueGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.BROWN)
    private static ShulkerBoxBlock brownGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.BROWN)
    private static Item brownGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.GREEN)
    private static ShulkerBoxBlock greenGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.GREEN)
    private static Item greenGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.RED)
    private static ShulkerBoxBlock redGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.RED)
    private static Item redGoldShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.BLACK)
    private static ShulkerBoxBlock blackGoldShulkerBoxBlock;
    @ObjectHolder(BlockNames.GOLD_SHULKER_BOX_COLOR + BlockColors.BLACK)
    private static Item blackGoldShulkerBoxItemBlock;
    // GOLD END

    // DIAMOND START
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.WHITE)
    private static ShulkerBoxBlock whiteDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.WHITE)
    private static Item whiteDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    private static ShulkerBoxBlock orangeDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    private static Item orangeDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    private static ShulkerBoxBlock magentaDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    private static Item magentaDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    private static ShulkerBoxBlock lightBlueDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    private static Item lightBlueDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    private static ShulkerBoxBlock yellowDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    private static Item yellowDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.LIME)
    private static ShulkerBoxBlock limeDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.LIME)
    private static Item limeDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.PINK)
    private static ShulkerBoxBlock pinkDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.PINK)
    private static Item pinkDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.GRAY)
    private static ShulkerBoxBlock grayDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.GRAY)
    private static Item grayDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    private static ShulkerBoxBlock lightGrayDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    private static Item lightGrayDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.CYAN)
    private static ShulkerBoxBlock cyanDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.CYAN)
    private static Item cyanDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    private static ShulkerBoxBlock purpleDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    private static Item purpleDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.BLUE)
    private static ShulkerBoxBlock blueDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.BLUE)
    private static Item blueDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.BROWN)
    private static ShulkerBoxBlock brownDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.BROWN)
    private static Item brownDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.GREEN)
    private static ShulkerBoxBlock greenDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.GREEN)
    private static Item greenDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.RED)
    private static ShulkerBoxBlock redDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.RED)
    private static Item redDiamondShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.BLACK)
    private static ShulkerBoxBlock blackDiamondShulkerBoxBlock;
    @ObjectHolder(BlockNames.DIAMOND_SHULKER_BOX_COLOR + BlockColors.BLACK)
    private static Item blackDiamondShulkerBoxItemBlock;
    // DIAMOND END

    // COPPER START
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.WHITE)
    private static ShulkerBoxBlock whiteCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.WHITE)
    private static Item whiteCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    private static ShulkerBoxBlock orangeCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    private static Item orangeCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    private static ShulkerBoxBlock magentaCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    private static Item magentaCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    private static ShulkerBoxBlock lightBlueCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    private static Item lightBlueCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    private static ShulkerBoxBlock yellowCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    private static Item yellowCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.LIME)
    private static ShulkerBoxBlock limeCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.LIME)
    private static Item limeCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.PINK)
    private static ShulkerBoxBlock pinkCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.PINK)
    private static Item pinkCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.GRAY)
    private static ShulkerBoxBlock grayCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.GRAY)
    private static Item grayCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    private static ShulkerBoxBlock lightGrayCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    private static Item lightGrayCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.CYAN)
    private static ShulkerBoxBlock cyanCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.CYAN)
    private static Item cyanCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    private static ShulkerBoxBlock purpleCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    private static Item purpleCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.BLUE)
    private static ShulkerBoxBlock blueCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.BLUE)
    private static Item blueCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.BROWN)
    private static ShulkerBoxBlock brownCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.BROWN)
    private static Item brownCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.GREEN)
    private static ShulkerBoxBlock greenCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.GREEN)
    private static Item greenCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.RED)
    private static ShulkerBoxBlock redCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.RED)
    private static Item redCopperShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.BLACK)
    private static ShulkerBoxBlock blackCopperShulkerBoxBlock;
    @ObjectHolder(BlockNames.COPPER_SHULKER_BOX_COLOR + BlockColors.BLACK)
    private static Item blackCopperShulkerBoxItemBlock;
    // COPPER END

    // SILVER START
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.WHITE)
    private static ShulkerBoxBlock whiteSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.WHITE)
    private static Item whiteSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    private static ShulkerBoxBlock orangeSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    private static Item orangeSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    private static ShulkerBoxBlock magentaSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    private static Item magentaSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    private static ShulkerBoxBlock lightBlueSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    private static Item lightBlueSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    private static ShulkerBoxBlock yellowSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    private static Item yellowSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.LIME)
    private static ShulkerBoxBlock limeSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.LIME)
    private static Item limeSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.PINK)
    private static ShulkerBoxBlock pinkSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.PINK)
    private static Item pinkSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.GRAY)
    private static ShulkerBoxBlock graySilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.GRAY)
    private static Item graySilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    private static ShulkerBoxBlock lightGraySilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    private static Item lightGraySilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.CYAN)
    private static ShulkerBoxBlock cyanSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.CYAN)
    private static Item cyanSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    private static ShulkerBoxBlock purpleSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    private static Item purpleSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.BLUE)
    private static ShulkerBoxBlock blueSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.BLUE)
    private static Item blueSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.BROWN)
    private static ShulkerBoxBlock brownSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.BROWN)
    private static Item brownSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.GREEN)
    private static ShulkerBoxBlock greenSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.GREEN)
    private static Item greenSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.RED)
    private static ShulkerBoxBlock redSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.RED)
    private static Item redSilverShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.BLACK)
    private static ShulkerBoxBlock blackSilverShulkerBoxBlock;
    @ObjectHolder(BlockNames.SILVER_SHULKER_BOX_COLOR + BlockColors.BLACK)
    private static Item blackSilverShulkerBoxItemBlock;
    // SILVER END

    // CRYSTAL START
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.WHITE)
    private static ShulkerBoxBlock whiteCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.WHITE)
    private static Item whiteCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    private static ShulkerBoxBlock orangeCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    private static Item orangeCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    private static ShulkerBoxBlock magentaCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    private static Item magentaCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    private static ShulkerBoxBlock lightBlueCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    private static Item lightBlueCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    private static ShulkerBoxBlock yellowCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    private static Item yellowCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.LIME)
    private static ShulkerBoxBlock limeCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.LIME)
    private static Item limeCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.PINK)
    private static ShulkerBoxBlock pinkCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.PINK)
    private static Item pinkCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.GRAY)
    private static ShulkerBoxBlock grayCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.GRAY)
    private static Item grayCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    private static ShulkerBoxBlock lightGrayCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    private static Item lightGrayCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.CYAN)
    private static ShulkerBoxBlock cyanCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.CYAN)
    private static Item cyanCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    private static ShulkerBoxBlock purpleCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    private static Item purpleCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.BLUE)
    private static ShulkerBoxBlock blueCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.BLUE)
    private static Item blueCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.BROWN)
    private static ShulkerBoxBlock brownCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.BROWN)
    private static Item brownCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.GREEN)
    private static ShulkerBoxBlock greenCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.GREEN)
    private static Item greenCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.RED)
    private static ShulkerBoxBlock redCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.RED)
    private static Item redCrystalShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.BLACK)
    private static ShulkerBoxBlock blackCrystalShulkerBoxBlock;
    @ObjectHolder(BlockNames.CRYSTAL_SHULKER_BOX_COLOR + BlockColors.BLACK)
    private static Item blackCrystalShulkerBoxItemBlock;
    // CRYSTAL END

    // OBSIDIAN START
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.WHITE)
    private static ShulkerBoxBlock whiteObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.WHITE)
    private static Item whiteObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    private static ShulkerBoxBlock orangeObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.ORANGE)
    private static Item orangeObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    private static ShulkerBoxBlock magentaObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.MAGENTA)
    private static Item magentaObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    private static ShulkerBoxBlock lightBlueObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.LIGHT_BLUE)
    private static Item lightBlueObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    private static ShulkerBoxBlock yellowObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.YELLOW)
    private static Item yellowObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.LIME)
    private static ShulkerBoxBlock limeObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.LIME)
    private static Item limeObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.PINK)
    private static ShulkerBoxBlock pinkObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.PINK)
    private static Item pinkObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.GRAY)
    private static ShulkerBoxBlock grayObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.GRAY)
    private static Item grayObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    private static ShulkerBoxBlock lightGrayObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.LIGHT_GRAY)
    private static Item lightGrayObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.CYAN)
    private static ShulkerBoxBlock cyanObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.CYAN)
    private static Item cyanObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    private static ShulkerBoxBlock purpleObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.PURPLE)
    private static Item purpleObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.BLUE)
    private static ShulkerBoxBlock blueObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.BLUE)
    private static Item blueObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.BROWN)
    private static ShulkerBoxBlock brownObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.BROWN)
    private static Item brownObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.GREEN)
    private static ShulkerBoxBlock greenObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.GREEN)
    private static Item greenObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.RED)
    private static ShulkerBoxBlock redObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.RED)
    private static Item redObsidianShulkerBoxItemBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.BLACK)
    private static ShulkerBoxBlock blackObsidianShulkerBoxBlock;
    @ObjectHolder(BlockNames.OBSIDIAN_SHULKER_BOX_COLOR + BlockColors.BLACK)
    private static Item blackObsidianShulkerBoxItemBlock;
    // OBSIDIAN END

    public static List<ShulkerBoxBlock> ironShulkerBoxes;
    public static List<ShulkerBoxBlock> goldShulkerBoxes;
    public static List<ShulkerBoxBlock> diamondShulkerBoxes;
    public static List<ShulkerBoxBlock> copperShulkerBoxes;
    public static List<ShulkerBoxBlock> silverShulkerBoxes;
    public static List<ShulkerBoxBlock> crystalShulkerBoxes;
    public static List<ShulkerBoxBlock> obsidianShulkerBoxes;
    private static List<ShulkerBoxBlock> allShulkerBoxes;
    private static List<Item> shulkerBoxItemBlocks;
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

            for (DyeColor color : DyeColor.values())
            {
                blockRegistry.register(new IronShulkerBoxBlock(color, Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)));
                blockRegistry.register(new GoldShulkerBoxBlock(color, Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)));
                blockRegistry.register(new DiamondShulkerBoxBlock(color, Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)));
                blockRegistry.register(new CopperShulkerBoxBlock(color, Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)));
                blockRegistry.register(new SilverShulkerBoxBlock(color, Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)));
                blockRegistry.register(new CrystalShulkerBoxBlock(color, Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F)));
                blockRegistry.register(new ObsidianShulkerBoxBlock(color, Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 10000.0F)));

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

            itemBuilder = (new Item.Properties()).group(IronShulkerBoxCreativeTabs.IRON_SHULKER_BOX).setTEISR(() -> IronShulkerBoxItemStackTileEntityRenderer::new).maxStackSize(1);

            for (ShulkerBoxBlock shulkerBox : allShulkerBoxes)
            {
                itemRegistry.register(new ShulkerBoxBlockItem(shulkerBox, itemBuilder));
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