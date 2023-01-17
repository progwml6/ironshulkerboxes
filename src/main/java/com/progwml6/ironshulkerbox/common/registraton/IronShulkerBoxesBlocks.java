package com.progwml6.ironshulkerbox.common.registraton;

import com.google.common.collect.ImmutableMap;
import com.progwml6.ironshulkerbox.IronShulkerBoxes;
import com.progwml6.ironshulkerbox.common.block.CopperShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.block.CrystalShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.block.DiamondShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.block.GoldShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import com.progwml6.ironshulkerbox.common.block.ObsidianShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.block.entity.AbstractIronShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.item.IronShulkerBoxBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class IronShulkerBoxesBlocks {

  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, IronShulkerBoxes.MOD_ID);

  public static final DeferredRegister<Item> ITEMS = IronShulkerBoxesItems.ITEMS;

  static BlockBehaviour.StatePredicate positionPredicate = (state, level, pos) -> {
    BlockEntity blockEntity = level.getBlockEntity(pos);

    if (!(blockEntity instanceof AbstractIronShulkerBoxBlockEntity shulkerBoxBlockEntity)) {
      return true;
    } else {
      return shulkerBoxBlockEntity.isClosed();
    }
  };

  private static final BlockBehaviour.Properties STANDARD = BlockBehaviour.Properties.of(Material.METAL).strength(3.0F).dynamicShape().noOcclusion().isSuffocating(positionPredicate).isViewBlocking(positionPredicate);
  private static final BlockBehaviour.Properties REINFORCED = BlockBehaviour.Properties.of(Material.METAL).strength(3.0F, 10000.0F).dynamicShape().noOcclusion().isSuffocating(positionPredicate).isViewBlocking(positionPredicate);

  //Default uncolored
  public static final RegistryObject<IronShulkerBoxBlock> IRON_SHULKER_BOX = register("iron_shulker_box", () -> new IronShulkerBoxBlock(STANDARD, null), IronShulkerBoxesTypes.IRON, null);
  public static final RegistryObject<GoldShulkerBoxBlock> GOLD_SHULKER_BOX = register("gold_shulker_box", () -> new GoldShulkerBoxBlock(STANDARD, null), IronShulkerBoxesTypes.GOLD, null);
  public static final RegistryObject<DiamondShulkerBoxBlock> DIAMOND_SHULKER_BOX = register("diamond_shulker_box", () -> new DiamondShulkerBoxBlock(STANDARD, null), IronShulkerBoxesTypes.DIAMOND, null);
  public static final RegistryObject<CopperShulkerBoxBlock> COPPER_SHULKER_BOX = register("copper_shulker_box", () -> new CopperShulkerBoxBlock(STANDARD, null), IronShulkerBoxesTypes.COPPER, null);
  public static final RegistryObject<CrystalShulkerBoxBlock> CRYSTAL_SHULKER_BOX = register("crystal_shulker_box", () -> new CrystalShulkerBoxBlock(STANDARD, null), IronShulkerBoxesTypes.CRYSTAL, null);
  public static final RegistryObject<ObsidianShulkerBoxBlock> OBSIDIAN_SHULKER_BOX = register("obsidian_shulker_box", () -> new ObsidianShulkerBoxBlock(REINFORCED, null), IronShulkerBoxesTypes.OBSIDIAN, null);

  public static final ImmutableMap<DyeColor, RegistryObject<IronShulkerBoxBlock>> IRON_SHULKER_BOXES = ImmutableMap.copyOf(Arrays.stream(DyeColor.values()).collect(Collectors.toMap(Function.identity(), type -> register("iron_shulker_box_" + type.name().toLowerCase(Locale.ROOT), () -> new IronShulkerBoxBlock(STANDARD, type), IronShulkerBoxesTypes.IRON, type))));
  public static final ImmutableMap<DyeColor, RegistryObject<GoldShulkerBoxBlock>> GOLD_SHULKER_BOXES = ImmutableMap.copyOf(Arrays.stream(DyeColor.values()).collect(Collectors.toMap(Function.identity(), type -> register("gold_shulker_box_" + type.name().toLowerCase(Locale.ROOT), () -> new GoldShulkerBoxBlock(STANDARD, type), IronShulkerBoxesTypes.GOLD, type))));
  public static final ImmutableMap<DyeColor, RegistryObject<DiamondShulkerBoxBlock>> DIAMOND_SHULKER_BOXES = ImmutableMap.copyOf(Arrays.stream(DyeColor.values()).collect(Collectors.toMap(Function.identity(), type -> register("diamond_shulker_box_" + type.name().toLowerCase(Locale.ROOT), () -> new DiamondShulkerBoxBlock(STANDARD, type), IronShulkerBoxesTypes.DIAMOND, type))));
  public static final ImmutableMap<DyeColor, RegistryObject<CopperShulkerBoxBlock>> COPPER_SHULKER_BOXES = ImmutableMap.copyOf(Arrays.stream(DyeColor.values()).collect(Collectors.toMap(Function.identity(), type -> register("copper_shulker_box_" + type.name().toLowerCase(Locale.ROOT), () -> new CopperShulkerBoxBlock(STANDARD, type), IronShulkerBoxesTypes.COPPER, type))));
  public static final ImmutableMap<DyeColor, RegistryObject<CrystalShulkerBoxBlock>> CRYSTAL_SHULKER_BOXES = ImmutableMap.copyOf(Arrays.stream(DyeColor.values()).collect(Collectors.toMap(Function.identity(), type -> register("crystal_shulker_box_" + type.name().toLowerCase(Locale.ROOT), () -> new CrystalShulkerBoxBlock(STANDARD, type), IronShulkerBoxesTypes.CRYSTAL, type))));
  public static final ImmutableMap<DyeColor, RegistryObject<ObsidianShulkerBoxBlock>> OBSIDIAN_SHULKER_BOXES = ImmutableMap.copyOf(Arrays.stream(DyeColor.values()).collect(Collectors.toMap(Function.identity(), type -> register("obsidian_shulker_box_" + type.name().toLowerCase(Locale.ROOT), () -> new ObsidianShulkerBoxBlock(REINFORCED, type), IronShulkerBoxesTypes.OBSIDIAN, type))));

  //HELPERS
  private static <T extends Block> RegistryObject<T> register(String name, Supplier<? extends T> sup, IronShulkerBoxesTypes shulkerBoxesType, @Nullable DyeColor color) {
    return register(name, sup, block -> item(block, () -> () -> shulkerBoxesType, () -> () -> color));
  }

  private static <T extends Block> RegistryObject<T> register(String name, Supplier<? extends T> sup, Function<RegistryObject<T>, Supplier<? extends Item>> itemCreator) {
    RegistryObject<T> ret = registerNoItem(name, sup);
    ITEMS.register(name, itemCreator.apply(ret));
    return ret;
  }

  private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<? extends T> sup) {
    return BLOCKS.register(name, sup);
  }

  private static Supplier<BlockItem> item(final RegistryObject<? extends Block> block, Supplier<Callable<IronShulkerBoxesTypes>> shulkerBoxesType, Supplier<Callable<DyeColor>> color) {
    return () -> new IronShulkerBoxBlockItem(block.get(), new Item.Properties(), shulkerBoxesType, color);
  }
}
