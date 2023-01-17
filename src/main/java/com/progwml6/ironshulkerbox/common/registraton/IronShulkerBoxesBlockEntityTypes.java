package com.progwml6.ironshulkerbox.common.registraton;

import com.google.common.collect.ImmutableSet;
import com.progwml6.ironshulkerbox.IronShulkerBoxes;
import com.progwml6.ironshulkerbox.common.block.entity.CopperShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.block.entity.CrystalShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.block.entity.DiamondShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.block.entity.GoldShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.block.entity.IronShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.block.entity.ObsidianShulkerBoxBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

public class IronShulkerBoxesBlockEntityTypes {

  public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, IronShulkerBoxes.MOD_ID);

  public static final RegistryObject<BlockEntityType<IronShulkerBoxBlockEntity>> IRON_SHULKER_BOX = BLOCK_ENTITIES.register("iron_shulker_box", () -> typeOf(IronShulkerBoxBlockEntity::new, IronShulkerBoxBlockEntity::buildBlocks));
  public static final RegistryObject<BlockEntityType<GoldShulkerBoxBlockEntity>> GOLD_SHULKER_BOX = BLOCK_ENTITIES.register("gold_shulker_box", () -> typeOf(GoldShulkerBoxBlockEntity::new, GoldShulkerBoxBlockEntity::buildBlocks));
  public static final RegistryObject<BlockEntityType<DiamondShulkerBoxBlockEntity>> DIAMOND_SHULKER_BOX = BLOCK_ENTITIES.register("diamond_shulker_box", () -> typeOf(DiamondShulkerBoxBlockEntity::new, DiamondShulkerBoxBlockEntity::buildBlocks));
  public static final RegistryObject<BlockEntityType<CopperShulkerBoxBlockEntity>> COPPER_SHULKER_BOX = BLOCK_ENTITIES.register("copper_shulker_box", () -> typeOf(CopperShulkerBoxBlockEntity::new, CopperShulkerBoxBlockEntity::buildBlocks));
  public static final RegistryObject<BlockEntityType<CrystalShulkerBoxBlockEntity>> CRYSTAL_SHULKER_BOX = BLOCK_ENTITIES.register("crystal_shulker_box", () -> typeOf(CrystalShulkerBoxBlockEntity::new, CrystalShulkerBoxBlockEntity::buildBlocks));
  public static final RegistryObject<BlockEntityType<ObsidianShulkerBoxBlockEntity>> OBSIDIAN_SHULKER_BOX = BLOCK_ENTITIES.register("obsidian_shulker_box", () -> typeOf(ObsidianShulkerBoxBlockEntity::new, ObsidianShulkerBoxBlockEntity::buildBlocks));

  private static <T extends BlockEntity> BlockEntityType<T> typeOf(BlockEntityType.BlockEntitySupplier<T> entity, Block... blocks) {
    return BlockEntityType.Builder.of(entity, blocks).build(null);
  }

  private static <T extends BlockEntity> BlockEntityType<T> typeOf(BlockEntityType.BlockEntitySupplier<T> entity, Consumer<ImmutableSet.Builder<Block>> blockCollector) {
    ImmutableSet.Builder<Block> blocks = new ImmutableSet.Builder<>();
    blockCollector.accept(blocks);
    return new BlockEntityType<>(entity, blocks.build(), null);
  }
}
