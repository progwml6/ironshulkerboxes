package com.progwml6.ironshulkerbox.common.crafting;

import com.progwml6.ironshulkerbox.common.blocks.BlockShulkerBox;
import com.progwml6.ironshulkerbox.common.core.IronShulkerBoxRecipes;
import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeHidden;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class IronShulkerBoxColoringRecipe extends IRecipeHidden
{
    public IronShulkerBoxColoringRecipe(ResourceLocation p_i48159_1_)
    {
        super(p_i48159_1_);
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    @Override
    public boolean matches(IInventory inv, World worldIn)
    {
        if (!(inv instanceof InventoryCrafting))
        {
            return false;
        }
        else
        {
            int i = 0;
            int j = 0;

            for (int k = 0; k < inv.getSizeInventory(); ++k)
            {
                ItemStack itemstack = inv.getStackInSlot(k);
                if (!itemstack.isEmpty())
                {
                    if (Block.getBlockFromItem(itemstack.getItem()) instanceof BlockShulkerBox)
                    {
                        ++i;
                    }
                    else
                    {
                        if (!itemstack.getItem().isIn(net.minecraftforge.common.Tags.Items.DYES))
                        {
                            return false;
                        }

                        ++j;
                    }

                    if (j > 1 || i > 1)
                    {
                        return false;
                    }
                }
            }

            return i == 1 && j == 1;
        }
    }

    /**
     * Returns an Item that is the result of this recipe
     */
    @Override
    public ItemStack getCraftingResult(IInventory inv)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        net.minecraft.item.EnumDyeColor color = net.minecraft.item.EnumDyeColor.WHITE;

        for (int i = 0; i < inv.getSizeInventory(); ++i)
        {
            ItemStack itemstack1 = inv.getStackInSlot(i);
            if (!itemstack1.isEmpty())
            {
                Item item = itemstack1.getItem();
                if (Block.getBlockFromItem(item) instanceof BlockShulkerBox)
                {
                    itemstack = itemstack1;
                }
                else
                {
                    net.minecraft.item.EnumDyeColor tmp = net.minecraft.item.EnumDyeColor.getColor(itemstack1);
                    if (tmp != null)
                    {
                        color = tmp;
                    }
                }
            }
        }

        ItemStack itemstack2 = BlockShulkerBox.getColoredItemStack(color, BlockShulkerBox.getTypeFromItem(itemstack.getItem()));
        if (itemstack.hasTag())
        {
            itemstack2.setTag(itemstack.getTag().copy());
        }

        return itemstack2;
    }

    /**
     * Used to determine if this recipe can fit in a grid of the given width/height
     */
    @Override
    public boolean canFit(int width, int height)
    {
        return width * height >= 2;
    }

    @Override
    public IRecipeSerializer<?> getSerializer()
    {
        return IronShulkerBoxRecipes.CRAFTING_SPECIAL_SHULKERBOXCOLORING;
    }
}