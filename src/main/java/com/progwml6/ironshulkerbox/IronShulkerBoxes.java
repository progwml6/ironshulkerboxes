package com.progwml6.ironshulkerbox;

import com.progwml6.ironshulkerbox.client.render.IronShulkerBoxRenderer;
import com.progwml6.ironshulkerbox.client.screen.IronShulkerBoxScreen;
import com.progwml6.ironshulkerbox.common.block.AbstractIronShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import com.progwml6.ironshulkerbox.common.data.IronShulkerBoxesBlockTags;
import com.progwml6.ironshulkerbox.common.data.IronShulkerBoxesRecipeProvider;
import com.progwml6.ironshulkerbox.common.data.IronShulkerBoxesSpriteSourceProvider;
import com.progwml6.ironshulkerbox.common.data.loot.IronShulkerBoxesLootTableProvider;
import com.progwml6.ironshulkerbox.common.network.IronShulkerBoxesNetwork;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesBlockEntityTypes;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesBlocks;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesItems;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesMenuTypes;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesRecipes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.core.dispenser.ShulkerBoxDispenseBehavior;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;

import java.util.concurrent.CompletableFuture;

@Mod(IronShulkerBoxes.MOD_ID)
public class IronShulkerBoxes {

  public static final String MOD_ID = "ironshulkerbox";

  private static CauldronInteraction SHULKER_BOX = (blockState, level, blockPos, player, interactionHand, itemStack) -> {
    Block block = Block.byItem(itemStack.getItem());

    if (!(block instanceof AbstractIronShulkerBoxBlock shulkerBoxBlock)) {
      return InteractionResult.PASS;
    } else {
      if (!level.isClientSide) {
        IronShulkerBoxesTypes type = AbstractIronShulkerBoxBlock.getTypeFromBlock(block);
        ItemStack itemstack = new ItemStack(Blocks.SHULKER_BOX);

        if (type != null) {
          itemstack = switch (type) {
            case IRON -> new ItemStack(IronShulkerBoxesBlocks.IRON_SHULKER_BOX.get());
            case GOLD -> new ItemStack(IronShulkerBoxesBlocks.GOLD_SHULKER_BOX.get());
            case DIAMOND -> new ItemStack(IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOX.get());
            case COPPER -> new ItemStack(IronShulkerBoxesBlocks.COPPER_SHULKER_BOX.get());
            case CRYSTAL -> new ItemStack(IronShulkerBoxesBlocks.CRYSTAL_SHULKER_BOX.get());
            case OBSIDIAN -> new ItemStack(IronShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOX.get());
            case VANILLA -> new ItemStack(Blocks.SHULKER_BOX);
          };
        }

        if (itemStack.hasTag()) {
          itemstack.setTag(itemStack.getTag().copy());
        }

        player.setItemInHand(interactionHand, itemstack);
        player.awardStat(Stats.CLEAN_SHULKER_BOX);

        LayeredCauldronBlock.lowerFillLevel(blockState, level, blockPos);
      }

      return InteractionResult.sidedSuccess(level.isClientSide);
    }
  };

  public IronShulkerBoxes() {
    IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

    // General mod setup
    modBus.addListener(this::setup);
    modBus.addListener(this::gatherData);

    DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
      // Client setup
      modBus.addListener(this::setupClient);
    });

    IronShulkerBoxesNetwork.setup();

    // Registry objects
    IronShulkerBoxesBlocks.BLOCKS.register(modBus);
    IronShulkerBoxesItems.ITEMS.register(modBus);
    IronShulkerBoxesBlockEntityTypes.BLOCK_ENTITIES.register(modBus);
    IronShulkerBoxesMenuTypes.MENU_TYPES.register(modBus);
    IronShulkerBoxesRecipes.RECIPE_SERIALIZERS.register(modBus);

    modBus.addListener(this::registerCreativeModeTabs);
  }

  @OnlyIn(Dist.CLIENT)
  private void setupClient(final FMLClientSetupEvent event) {
    MenuScreens.register(IronShulkerBoxesMenuTypes.IRON_SHULKER_BOX.get(), IronShulkerBoxScreen::new);
    MenuScreens.register(IronShulkerBoxesMenuTypes.GOLD_SHULKER_BOX.get(), IronShulkerBoxScreen::new);
    MenuScreens.register(IronShulkerBoxesMenuTypes.DIAMOND_SHULKER_BOX.get(), IronShulkerBoxScreen::new);
    MenuScreens.register(IronShulkerBoxesMenuTypes.CRYSTAL_SHULKER_BOX.get(), IronShulkerBoxScreen::new);
    MenuScreens.register(IronShulkerBoxesMenuTypes.COPPER_SHULKER_BOX.get(), IronShulkerBoxScreen::new);
    MenuScreens.register(IronShulkerBoxesMenuTypes.OBSIDIAN_SHULKER_BOX.get(), IronShulkerBoxScreen::new);

    BlockEntityRenderers.register(IronShulkerBoxesBlockEntityTypes.IRON_SHULKER_BOX.get(), IronShulkerBoxRenderer::new);
    BlockEntityRenderers.register(IronShulkerBoxesBlockEntityTypes.GOLD_SHULKER_BOX.get(), IronShulkerBoxRenderer::new);
    BlockEntityRenderers.register(IronShulkerBoxesBlockEntityTypes.DIAMOND_SHULKER_BOX.get(), IronShulkerBoxRenderer::new);
    BlockEntityRenderers.register(IronShulkerBoxesBlockEntityTypes.CRYSTAL_SHULKER_BOX.get(), IronShulkerBoxRenderer::new);
    BlockEntityRenderers.register(IronShulkerBoxesBlockEntityTypes.COPPER_SHULKER_BOX.get(), IronShulkerBoxRenderer::new);
    BlockEntityRenderers.register(IronShulkerBoxesBlockEntityTypes.OBSIDIAN_SHULKER_BOX.get(), IronShulkerBoxRenderer::new);
  }

  private void setup(final FMLCommonSetupEvent event) {
    event.enqueueWork(() -> {
      DispenserBlock.registerBehavior(IronShulkerBoxesBlocks.IRON_SHULKER_BOX.get().asItem(), new ShulkerBoxDispenseBehavior());
      DispenserBlock.registerBehavior(IronShulkerBoxesBlocks.GOLD_SHULKER_BOX.get().asItem(), new ShulkerBoxDispenseBehavior());
      DispenserBlock.registerBehavior(IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOX.get().asItem(), new ShulkerBoxDispenseBehavior());
      DispenserBlock.registerBehavior(IronShulkerBoxesBlocks.COPPER_SHULKER_BOX.get().asItem(), new ShulkerBoxDispenseBehavior());
      DispenserBlock.registerBehavior(IronShulkerBoxesBlocks.CRYSTAL_SHULKER_BOX.get().asItem(), new ShulkerBoxDispenseBehavior());
      DispenserBlock.registerBehavior(IronShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOX.get().asItem(), new ShulkerBoxDispenseBehavior());

      for (DyeColor color : DyeColor.values()) {
        CauldronInteraction.WATER.put(IronShulkerBoxesBlocks.IRON_SHULKER_BOXES.get(color).get().asItem(), SHULKER_BOX);
        CauldronInteraction.WATER.put(IronShulkerBoxesBlocks.GOLD_SHULKER_BOXES.get(color).get().asItem(), SHULKER_BOX);
        CauldronInteraction.WATER.put(IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOXES.get(color).get().asItem(), SHULKER_BOX);
        CauldronInteraction.WATER.put(IronShulkerBoxesBlocks.COPPER_SHULKER_BOXES.get(color).get().asItem(), SHULKER_BOX);
        CauldronInteraction.WATER.put(IronShulkerBoxesBlocks.CRYSTAL_SHULKER_BOXES.get(color).get().asItem(), SHULKER_BOX);
        CauldronInteraction.WATER.put(IronShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOXES.get(color).get().asItem(), SHULKER_BOX);

        DispenserBlock.registerBehavior(IronShulkerBoxesBlocks.IRON_SHULKER_BOXES.get(color).get().asItem(), new ShulkerBoxDispenseBehavior());
        DispenserBlock.registerBehavior(IronShulkerBoxesBlocks.GOLD_SHULKER_BOXES.get(color).get().asItem(), new ShulkerBoxDispenseBehavior());
        DispenserBlock.registerBehavior(IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOXES.get(color).get().asItem(), new ShulkerBoxDispenseBehavior());
        DispenserBlock.registerBehavior(IronShulkerBoxesBlocks.COPPER_SHULKER_BOXES.get(color).get().asItem(), new ShulkerBoxDispenseBehavior());
        DispenserBlock.registerBehavior(IronShulkerBoxesBlocks.CRYSTAL_SHULKER_BOXES.get(color).get().asItem(), new ShulkerBoxDispenseBehavior());
        DispenserBlock.registerBehavior(IronShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOXES.get(color).get().asItem(), new ShulkerBoxDispenseBehavior());
      }
    });
  }

  private void gatherData(GatherDataEvent event) {
    ExistingFileHelper ext = event.getExistingFileHelper();
    DataGenerator gen = event.getGenerator();
    PackOutput packOutput = gen.getPackOutput();
    CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

    gen.addProvider(event.includeServer(), new IronShulkerBoxesLootTableProvider(packOutput));

    gen.addProvider(event.includeClient(), new IronShulkerBoxesRecipeProvider(packOutput));
    gen.addProvider(event.includeClient(), new IronShulkerBoxesSpriteSourceProvider(packOutput, ext));
    gen.addProvider(event.includeClient(), new IronShulkerBoxesBlockTags(packOutput, lookupProvider, ext));
  }

  public void registerCreativeModeTabs(final CreativeModeTabEvent.Register eventIn) {
    eventIn.registerCreativeModeTab(new ResourceLocation(IronShulkerBoxes.MOD_ID, IronShulkerBoxes.MOD_ID), builder -> builder
      .title(Component.translatable("itemGroup." + IronShulkerBoxes.MOD_ID))
      .icon(() -> new ItemStack(IronShulkerBoxesBlocks.IRON_SHULKER_BOX.get()))
      .displayItems((featureFlagSet, output, hasPermissions) -> {
        for (final RegistryObject<Item> item : IronShulkerBoxesItems.ITEMS.getEntries())
          output.accept(item.get());
      }));
  }
}
