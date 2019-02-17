package com.progwml6.ironshulkerbox.client.renderer;

import com.progwml6.ironshulkerbox.common.blocks.BlockShulkerBox;
import com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType;
import com.progwml6.ironshulkerbox.common.tileentity.TileEntityCopperShulkerBox;
import com.progwml6.ironshulkerbox.common.tileentity.TileEntityCrystalShulkerBox;
import com.progwml6.ironshulkerbox.common.tileentity.TileEntityDiamondShulkerBox;
import com.progwml6.ironshulkerbox.common.tileentity.TileEntityGoldShulkerBox;
import com.progwml6.ironshulkerbox.common.tileentity.TileEntityIronShulkerBox;
import com.progwml6.ironshulkerbox.common.tileentity.TileEntityObsidianShulkerBox;
import com.progwml6.ironshulkerbox.common.tileentity.TileEntitySilverShulkerBox;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.Comparator;

public class TileEntityIronShulkerBoxItemRenderer extends TileEntityItemStackRenderer
{
    private static final TileEntityIronShulkerBox IRON_SHULKER_BOX = new TileEntityIronShulkerBox(EnumDyeColor.BLACK);

    private static final TileEntityIronShulkerBox[] IRON_SHULKER_BOXES = Arrays.stream(EnumDyeColor.values()).sorted(Comparator.comparingInt(EnumDyeColor::getId)).map(TileEntityIronShulkerBox::new).toArray(TileEntityIronShulkerBox[]::new);

    private static final TileEntityGoldShulkerBox[] GOLD_SHULKER_BOXES = Arrays.stream(EnumDyeColor.values()).sorted(Comparator.comparingInt(EnumDyeColor::getId)).map(TileEntityGoldShulkerBox::new).toArray(TileEntityGoldShulkerBox[]::new);

    private static final TileEntityDiamondShulkerBox[] DIAMOND_SHULKER_BOXES = Arrays.stream(EnumDyeColor.values()).sorted(Comparator.comparingInt(EnumDyeColor::getId)).map(TileEntityDiamondShulkerBox::new).toArray(TileEntityDiamondShulkerBox[]::new);

    private static final TileEntityCopperShulkerBox[] COPPER_SHULKER_BOXES = Arrays.stream(EnumDyeColor.values()).sorted(Comparator.comparingInt(EnumDyeColor::getId)).map(TileEntityCopperShulkerBox::new).toArray(TileEntityCopperShulkerBox[]::new);

    private static final TileEntitySilverShulkerBox[] SILVER_SHULKER_BOXES = Arrays.stream(EnumDyeColor.values()).sorted(Comparator.comparingInt(EnumDyeColor::getId)).map(TileEntitySilverShulkerBox::new).toArray(TileEntitySilverShulkerBox[]::new);

    private static final TileEntityCrystalShulkerBox[] CRYSTAL_SHULKER_BOXES = Arrays.stream(EnumDyeColor.values()).sorted(Comparator.comparingInt(EnumDyeColor::getId)).map(TileEntityCrystalShulkerBox::new).toArray(TileEntityCrystalShulkerBox[]::new);

    private static final TileEntityObsidianShulkerBox[] OBSIDIAN_SHULKER_BOXES = Arrays.stream(EnumDyeColor.values()).sorted(Comparator.comparingInt(EnumDyeColor::getId)).map(TileEntityObsidianShulkerBox::new).toArray(TileEntityObsidianShulkerBox[]::new);

    public static TileEntityIronShulkerBoxItemRenderer instance = new TileEntityIronShulkerBoxItemRenderer();

    @Override
    public void renderByItem(ItemStack itemStackIn)
    {
        Item item = itemStackIn.getItem();

        if (Block.getBlockFromItem(item) instanceof BlockShulkerBox)
        {
            IronShulkerBoxType typeOut = BlockShulkerBox.getTypeFromItem(item);
            EnumDyeColor colorOut = BlockShulkerBox.getColorFromItem(item);

            if (typeOut == null)
            {
                TileEntityRendererDispatcher.instance.renderAsItem(IRON_SHULKER_BOX);
            }
            else if (colorOut == null)
            {
                TileEntityRendererDispatcher.instance.renderAsItem(IRON_SHULKER_BOX);
            }
            else
            {
                switch (typeOut)
                {
                    case IRON:
                        TileEntityRendererDispatcher.instance.renderAsItem(IRON_SHULKER_BOXES[colorOut.ordinal()]);
                        break;
                    case GOLD:
                        TileEntityRendererDispatcher.instance.renderAsItem(GOLD_SHULKER_BOXES[colorOut.ordinal()]);
                        break;
                    case DIAMOND:
                        TileEntityRendererDispatcher.instance.renderAsItem(DIAMOND_SHULKER_BOXES[colorOut.ordinal()]);
                        break;
                    case COPPER:
                        TileEntityRendererDispatcher.instance.renderAsItem(COPPER_SHULKER_BOXES[colorOut.ordinal()]);
                        break;
                    case SILVER:
                        TileEntityRendererDispatcher.instance.renderAsItem(SILVER_SHULKER_BOXES[colorOut.ordinal()]);
                        break;
                    case CRYSTAL:
                        TileEntityRendererDispatcher.instance.renderAsItem(CRYSTAL_SHULKER_BOXES[colorOut.ordinal()]);
                        break;
                    case OBSIDIAN:
                        TileEntityRendererDispatcher.instance.renderAsItem(OBSIDIAN_SHULKER_BOXES[colorOut.ordinal()]);
                        break;
                    default:
                        TileEntityRendererDispatcher.instance.renderAsItem(IRON_SHULKER_BOX);
                        break;
                }

            }
        }
        else
        {
            super.renderByItem(itemStackIn);
        }
    }
}
