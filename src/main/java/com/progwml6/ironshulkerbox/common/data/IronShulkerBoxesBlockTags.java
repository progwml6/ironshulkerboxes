package com.progwml6.ironshulkerbox.common.data;

import com.progwml6.ironshulkerbox.IronShulkerBoxes;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class IronShulkerBoxesBlockTags extends BlockTagsProvider {

  public IronShulkerBoxesBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, ExistingFileHelper existingFileHelper) {
    super(output, lookup, IronShulkerBoxes.MOD_ID, existingFileHelper);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {
    IntrinsicTagAppender<Block> SHULKER_BOXES = tag(BlockTags.SHULKER_BOXES);

    SHULKER_BOXES.add(IronShulkerBoxesBlocks.IRON_SHULKER_BOX.get(),
      IronShulkerBoxesBlocks.GOLD_SHULKER_BOX.get(),
      IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOX.get(),
      IronShulkerBoxesBlocks.COPPER_SHULKER_BOX.get(),
      IronShulkerBoxesBlocks.CRYSTAL_SHULKER_BOX.get(),
      IronShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOX.get()
    );

    IronShulkerBoxesBlocks.IRON_SHULKER_BOXES.forEach((dyeColor, block) -> SHULKER_BOXES.add(block.get()));
    IronShulkerBoxesBlocks.GOLD_SHULKER_BOXES.forEach((dyeColor, block) -> SHULKER_BOXES.add(block.get()));
    IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOXES.forEach((dyeColor, block) -> SHULKER_BOXES.add(block.get()));
    IronShulkerBoxesBlocks.COPPER_SHULKER_BOXES.forEach((dyeColor, block) -> SHULKER_BOXES.add(block.get()));
    IronShulkerBoxesBlocks.CRYSTAL_SHULKER_BOXES.forEach((dyeColor, block) -> SHULKER_BOXES.add(block.get()));
    IronShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOXES.forEach((dyeColor, block) -> SHULKER_BOXES.add(block.get()));
  }
}
