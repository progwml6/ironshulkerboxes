package com.progwml6.ironshulkerbox.common.recipes;

import com.progwml6.ironshulkerbox.common.block.AbstractIronShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesRecipes;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class IronShulkerBoxesColoringRecipe extends CustomRecipe {

  public IronShulkerBoxesColoringRecipe(CraftingBookCategory pCategory) {
    super(pCategory);
  }

  /**
   * Used to check if a recipe matches current crafting inventory
   */
  public boolean matches(CraftingContainer pInv, Level pLevel) {
    int i = 0;
    int j = 0;

    for (int k = 0; k < pInv.getContainerSize(); ++k) {
      ItemStack itemstack = pInv.getItem(k);
      if (!itemstack.isEmpty()) {
        if (Block.byItem(itemstack.getItem()) instanceof AbstractIronShulkerBoxBlock) {
          ++i;
        } else {
          if (!itemstack.is(net.minecraftforge.common.Tags.Items.DYES)) {
            return false;
          }

          ++j;
        }

        if (j > 1 || i > 1) {
          return false;
        }
      }
    }

    return i == 1 && j == 1;
  }

  /**
   * Returns an Item that is the result of this recipe
   */
  public ItemStack assemble(CraftingContainer pInv, RegistryAccess registryAccess) {
    ItemStack itemStack = ItemStack.EMPTY;
    DyeColor dyeColor = DyeColor.WHITE;

    for (int i = 0; i < pInv.getContainerSize(); ++i) {
      ItemStack itemStackInInv = pInv.getItem(i);

      if (!itemStackInInv.isEmpty()) {
        Item item = itemStackInInv.getItem();

        if (Block.byItem(item) instanceof AbstractIronShulkerBoxBlock) {
          itemStack = itemStackInInv;
        } else {
          DyeColor tmp = DyeColor.getColor(itemStackInInv);
          if (tmp != null) dyeColor = tmp;
        }
      }
    }

    ItemStack newItemStack = AbstractIronShulkerBoxBlock.getColoredItemStack(dyeColor, AbstractIronShulkerBoxBlock.getTypeFromItem(itemStack.getItem()));
    if (itemStack.hasTag()) {
      if (itemStack.getTag() != null) {
        newItemStack.setTag(itemStack.getTag().copy());
      }
    }

    return newItemStack;
  }

  /**
   * Used to determine if this recipe can fit in a grid of the given width/height
   */
  public boolean canCraftInDimensions(int pWidth, int pHeight) {
    return pWidth * pHeight >= 2;
  }

  public RecipeSerializer<?> getSerializer() {
    return IronShulkerBoxesRecipes.SHULKER_BOX_COLORING.get();
  }
}
