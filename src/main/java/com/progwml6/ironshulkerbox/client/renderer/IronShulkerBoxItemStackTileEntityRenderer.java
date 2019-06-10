package com.progwml6.ironshulkerbox.client.renderer;

import com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxType;
import com.progwml6.ironshulkerbox.common.tileentity.CopperShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.tileentity.CrystalShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.tileentity.DiamondShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.tileentity.GoldShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.tileentity.IronShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.tileentity.ObsidianShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.tileentity.SilverShulkerBoxTileEntity;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.Comparator;

public class IronShulkerBoxItemStackTileEntityRenderer extends ItemStackTileEntityRenderer
{
    private static final IronShulkerBoxTileEntity IRON_SHULKER_BOX = new IronShulkerBoxTileEntity(DyeColor.BLACK);

    private static final IronShulkerBoxTileEntity[] IRON_SHULKER_BOXES = Arrays.stream(DyeColor.values()).sorted(Comparator.comparingInt(DyeColor::getId)).map(IronShulkerBoxTileEntity::new).toArray(IronShulkerBoxTileEntity[]::new);

    private static final GoldShulkerBoxTileEntity[] GOLD_SHULKER_BOXES = Arrays.stream(DyeColor.values()).sorted(Comparator.comparingInt(DyeColor::getId)).map(GoldShulkerBoxTileEntity::new).toArray(GoldShulkerBoxTileEntity[]::new);

    private static final DiamondShulkerBoxTileEntity[] DIAMOND_SHULKER_BOXES = Arrays.stream(DyeColor.values()).sorted(Comparator.comparingInt(DyeColor::getId)).map(DiamondShulkerBoxTileEntity::new).toArray(DiamondShulkerBoxTileEntity[]::new);

    private static final CopperShulkerBoxTileEntity[] COPPER_SHULKER_BOXES = Arrays.stream(DyeColor.values()).sorted(Comparator.comparingInt(DyeColor::getId)).map(CopperShulkerBoxTileEntity::new).toArray(CopperShulkerBoxTileEntity[]::new);

    private static final SilverShulkerBoxTileEntity[] SILVER_SHULKER_BOXES = Arrays.stream(DyeColor.values()).sorted(Comparator.comparingInt(DyeColor::getId)).map(SilverShulkerBoxTileEntity::new).toArray(SilverShulkerBoxTileEntity[]::new);

    private static final CrystalShulkerBoxTileEntity[] CRYSTAL_SHULKER_BOXES = Arrays.stream(DyeColor.values()).sorted(Comparator.comparingInt(DyeColor::getId)).map(CrystalShulkerBoxTileEntity::new).toArray(CrystalShulkerBoxTileEntity[]::new);

    private static final ObsidianShulkerBoxTileEntity[] OBSIDIAN_SHULKER_BOXES = Arrays.stream(DyeColor.values()).sorted(Comparator.comparingInt(DyeColor::getId)).map(ObsidianShulkerBoxTileEntity::new).toArray(ObsidianShulkerBoxTileEntity[]::new);

    public static IronShulkerBoxItemStackTileEntityRenderer instance = new IronShulkerBoxItemStackTileEntityRenderer();

    @Override
    public void renderByItem(ItemStack itemStackIn)
    {
        Item item = itemStackIn.getItem();

        if (Block.getBlockFromItem(item) instanceof ShulkerBoxBlock)
        {
            ShulkerBoxType type = ShulkerBoxBlock.getTypeFromItem(item);
            DyeColor color = ShulkerBoxBlock.getColorFromItem(item);

            if (type == null)
            {
                TileEntityRendererDispatcher.instance.renderAsItem(IRON_SHULKER_BOX);
            }
            else if (color == null)
            {
                TileEntityRendererDispatcher.instance.renderAsItem(IRON_SHULKER_BOX);
            }
            else
            {
                switch (type)
                {
                    case IRON:
                        TileEntityRendererDispatcher.instance.renderAsItem(IRON_SHULKER_BOXES[color.ordinal()]);
                        break;
                    case GOLD:
                        TileEntityRendererDispatcher.instance.renderAsItem(GOLD_SHULKER_BOXES[color.ordinal()]);
                        break;
                    case DIAMOND:
                        TileEntityRendererDispatcher.instance.renderAsItem(DIAMOND_SHULKER_BOXES[color.ordinal()]);
                        break;
                    case COPPER:
                        TileEntityRendererDispatcher.instance.renderAsItem(COPPER_SHULKER_BOXES[color.ordinal()]);
                        break;
                    case SILVER:
                        TileEntityRendererDispatcher.instance.renderAsItem(SILVER_SHULKER_BOXES[color.ordinal()]);
                        break;
                    case CRYSTAL:
                        TileEntityRendererDispatcher.instance.renderAsItem(CRYSTAL_SHULKER_BOXES[color.ordinal()]);
                        break;
                    case OBSIDIAN:
                        TileEntityRendererDispatcher.instance.renderAsItem(OBSIDIAN_SHULKER_BOXES[color.ordinal()]);
                        break;
                    default:
                        TileEntityRendererDispatcher.instance.renderAsItem(IRON_SHULKER_BOX);
                        break;
                }
            }
        }
    }
}
