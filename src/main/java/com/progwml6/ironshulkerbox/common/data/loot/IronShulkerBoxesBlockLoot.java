package com.progwml6.ironshulkerbox.common.data.loot;

import com.google.common.collect.ImmutableSet;
import com.progwml6.ironshulkerbox.common.block.AbstractIronShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.block.entity.AbstractIronShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesBlockEntityTypes;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.DynamicLoot;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import net.minecraft.world.level.storage.loot.functions.SetContainerContents;
import net.minecraft.world.level.storage.loot.providers.nbt.ContextNbtProvider;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IronShulkerBoxesBlockLoot extends BlockLootSubProvider {

  private static final Set<Item> EXPLOSION_RESISTANT = getExplosionResistance().stream().map(ItemLike::asItem).collect(Collectors.toSet());

  public IronShulkerBoxesBlockLoot() {
    super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags());
  }

  @Override
  protected void generate() {
    this.add(IronShulkerBoxesBlocks.IRON_SHULKER_BOX.get(), (block) -> this.createShulkerBoxDrop(block, IronShulkerBoxesBlockEntityTypes.IRON_SHULKER_BOX.get()));
    this.add(IronShulkerBoxesBlocks.GOLD_SHULKER_BOX.get(), (block) -> this.createShulkerBoxDrop(block, IronShulkerBoxesBlockEntityTypes.GOLD_SHULKER_BOX.get()));
    this.add(IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOX.get(), (block) -> this.createShulkerBoxDrop(block, IronShulkerBoxesBlockEntityTypes.DIAMOND_SHULKER_BOX.get()));
    this.add(IronShulkerBoxesBlocks.COPPER_SHULKER_BOX.get(), (block) -> this.createShulkerBoxDrop(block, IronShulkerBoxesBlockEntityTypes.COPPER_SHULKER_BOX.get()));
    this.add(IronShulkerBoxesBlocks.CRYSTAL_SHULKER_BOX.get(), (block) -> this.createShulkerBoxDrop(block, IronShulkerBoxesBlockEntityTypes.CRYSTAL_SHULKER_BOX.get()));
    this.add(IronShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOX.get(), (block) -> this.createShulkerBoxDrop(block, IronShulkerBoxesBlockEntityTypes.OBSIDIAN_SHULKER_BOX.get()));

    for (DyeColor color : DyeColor.values()) {
      this.add(IronShulkerBoxesBlocks.IRON_SHULKER_BOXES.get(color).get(), (block) -> this.createShulkerBoxDrop(block, IronShulkerBoxesBlockEntityTypes.IRON_SHULKER_BOX.get()));
      this.add(IronShulkerBoxesBlocks.GOLD_SHULKER_BOXES.get(color).get(), (block) -> this.createShulkerBoxDrop(block, IronShulkerBoxesBlockEntityTypes.GOLD_SHULKER_BOX.get()));
      this.add(IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOXES.get(color).get(), (block) -> this.createShulkerBoxDrop(block, IronShulkerBoxesBlockEntityTypes.DIAMOND_SHULKER_BOX.get()));
      this.add(IronShulkerBoxesBlocks.COPPER_SHULKER_BOXES.get(color).get(), (block) -> this.createShulkerBoxDrop(block, IronShulkerBoxesBlockEntityTypes.COPPER_SHULKER_BOX.get()));
      this.add(IronShulkerBoxesBlocks.CRYSTAL_SHULKER_BOXES.get(color).get(), (block) -> this.createShulkerBoxDrop(block, IronShulkerBoxesBlockEntityTypes.CRYSTAL_SHULKER_BOX.get()));
      this.add(IronShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOXES.get(color).get(), (block) -> this.createShulkerBoxDrop(block, IronShulkerBoxesBlockEntityTypes.OBSIDIAN_SHULKER_BOX.get()));
    }
  }

  @Override
  protected Iterable<Block> getKnownBlocks() {
    return IronShulkerBoxesBlocks.BLOCKS.getEntries() // Get all registered entries
      .stream() // Stream the wrapped objects
      .flatMap(RegistryObject::stream) // Get the object if available
      ::iterator; // Create the iterable
  }

  protected LootTable.Builder createShulkerBoxDrop(Block pBlock, BlockEntityType<? extends AbstractIronShulkerBoxBlockEntity> blockEntityType) {
    return LootTable.lootTable().withPool(this.applyExplosionCondition(pBlock, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
      .add(LootItem.lootTableItem(pBlock).apply(CopyNameFunction.copyName(CopyNameFunction.NameSource.BLOCK_ENTITY))
        .apply(CopyNbtFunction.copyData(ContextNbtProvider.BLOCK_ENTITY).copy("Lock", "BlockEntityTag.Lock").copy("LootTable", "BlockEntityTag.LootTable").copy("LootTableSeed", "BlockEntityTag.LootTableSeed"))
        .apply(SetContainerContents.setContents(blockEntityType).withEntry(DynamicLoot.dynamicEntry(AbstractIronShulkerBoxBlock.CONTENTS))))));
  }

  protected static Set<Block> getExplosionResistance() {
    ImmutableSet.Builder<Block> blocks = new ImmutableSet.Builder<>();

    blocks.add(IronShulkerBoxesBlocks.IRON_SHULKER_BOX.get());
    blocks.add(IronShulkerBoxesBlocks.GOLD_SHULKER_BOX.get());
    blocks.add(IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOX.get());
    blocks.add(IronShulkerBoxesBlocks.COPPER_SHULKER_BOX.get());
    blocks.add(IronShulkerBoxesBlocks.CRYSTAL_SHULKER_BOX.get());
    blocks.add(IronShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOX.get());

    IronShulkerBoxesBlocks.IRON_SHULKER_BOXES.forEach((dyeColor, block) -> blocks.add(block.get()));
    IronShulkerBoxesBlocks.GOLD_SHULKER_BOXES.forEach((dyeColor, block) -> blocks.add(block.get()));
    IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOXES.forEach((dyeColor, block) -> blocks.add(block.get()));
    IronShulkerBoxesBlocks.COPPER_SHULKER_BOXES.forEach((dyeColor, block) -> blocks.add(block.get()));
    IronShulkerBoxesBlocks.CRYSTAL_SHULKER_BOXES.forEach((dyeColor, block) -> blocks.add(block.get()));
    IronShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOXES.forEach((dyeColor, block) -> blocks.add(block.get()));

    return blocks.build();
  }
}
