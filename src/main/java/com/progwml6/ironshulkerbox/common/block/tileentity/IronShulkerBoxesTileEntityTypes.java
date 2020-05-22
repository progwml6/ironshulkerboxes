package com.progwml6.ironshulkerbox.common.block.tileentity;

import com.google.common.collect.Sets;
import com.progwml6.ironshulkerbox.IronShulkerBoxes;
import com.progwml6.ironshulkerbox.common.block.GenericIronShulkerBlock;
import com.progwml6.ironshulkerbox.common.block.ShulkerBoxesBlocks;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class IronShulkerBoxesTileEntityTypes {

  public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, IronShulkerBoxes.MOD_ID);

  public static final RegistryObject<TileEntityType<IronShulkerBoxTileEntity>> IRON_SHULKER_BOX = TILE_ENTITIES.register("iron_shulker_box",
    () -> new TileEntityType<>(IronShulkerBoxTileEntity::new, createBlockSet(ShulkerBoxesBlocks.IRON_SHULKER_BOXES), null));

  public static final RegistryObject<TileEntityType<GoldShulkerBoxTileEntity>> GOLD_SHULKER_BOX = TILE_ENTITIES.register("gold_shulker_box",
    () -> new TileEntityType<>(GoldShulkerBoxTileEntity::new, createBlockSet(ShulkerBoxesBlocks.GOLD_SHULKER_BOXES), null));

  public static final RegistryObject<TileEntityType<DiamondShulkerBoxTileEntity>> DIAMOND_SHULKER_BOX = TILE_ENTITIES.register("diamond_shulker_box",
    () -> new TileEntityType<>(DiamondShulkerBoxTileEntity::new, createBlockSet(ShulkerBoxesBlocks.DIAMOND_SHULKER_BOXES), null));

  public static final RegistryObject<TileEntityType<CopperShulkerBoxTileEntity>> COPPER_SHULKER_BOX = TILE_ENTITIES.register("copper_shulker_box",
    () -> new TileEntityType<>(CopperShulkerBoxTileEntity::new, createBlockSet(ShulkerBoxesBlocks.COPPER_SHULKER_BOXES), null));

  public static final RegistryObject<TileEntityType<SilverShulkerBoxTileEntity>> SILVER_SHULKER_BOX = TILE_ENTITIES.register("silver_shulker_box",
    () -> new TileEntityType<>(SilverShulkerBoxTileEntity::new, createBlockSet(ShulkerBoxesBlocks.SILVER_SHULKER_BOXES), null));

  public static final RegistryObject<TileEntityType<CrystalShulkerBoxTileEntity>> CRYSTAL_SHULKER_BOX = TILE_ENTITIES.register("crystal_shulker_box",
    () -> new TileEntityType<>(CrystalShulkerBoxTileEntity::new, createBlockSet(ShulkerBoxesBlocks.CRYSTAL_SHULKER_BOXES), null));

  public static final RegistryObject<TileEntityType<ObsidianShulkerBoxTileEntity>> OBSIDIAN_SHULKER_BOX = TILE_ENTITIES.register("obsidian_shulker_box",
    () -> new TileEntityType<>(ObsidianShulkerBoxTileEntity::new, createBlockSet(ShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOXES), null));

  public static Set<Block> createBlockSet(Collection<RegistryObject<? extends GenericIronShulkerBlock>> values) {
    Set<Block> blocks = Sets.newHashSet();

    for (RegistryObject<? extends GenericIronShulkerBlock> block : values) {
      blocks.add(block.get());
    }

    return blocks;
  }

  public static List<Block> createBlockList(Set<Block> blocks) {
    return new ArrayList<>(blocks);
  }
}
