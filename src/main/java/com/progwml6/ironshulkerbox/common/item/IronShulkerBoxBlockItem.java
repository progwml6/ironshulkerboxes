package com.progwml6.ironshulkerbox.common.item;

import com.progwml6.ironshulkerbox.client.model.inventory.IronShulkerBoxItemStackRenderer;
import com.progwml6.ironshulkerbox.common.block.AbstractIronShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import com.progwml6.ironshulkerbox.common.block.entity.CopperShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.block.entity.CrystalShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.block.entity.DiamondShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.block.entity.GoldShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.block.entity.IronShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.block.entity.ObsidianShulkerBoxBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.DistExecutor;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class IronShulkerBoxBlockItem extends BlockItem {

  protected Supplier<IronShulkerBoxesTypes> type;
  protected Supplier<DyeColor> color;

  public IronShulkerBoxBlockItem(Block block, Properties properties, Supplier<Callable<IronShulkerBoxesTypes>> type, Supplier<Callable<DyeColor>> color) {
    super(block, properties);

    IronShulkerBoxesTypes tempType = DistExecutor.unsafeCallWhenOn(Dist.CLIENT, type);
    DyeColor tempColor = DistExecutor.unsafeCallWhenOn(Dist.CLIENT, color);

    this.type = tempType == null ? null : () -> tempType;
    this.color = tempColor == null ? null : () -> tempColor;
  }

  @Override
  public void initializeClient(Consumer<IClientItemExtensions> consumer) {
    super.initializeClient(consumer);

    consumer.accept(new IClientItemExtensions() {
      @Override
      public BlockEntityWithoutLevelRenderer getCustomRenderer() {
        Supplier<BlockEntity> modelToUse;

        DyeColor dyeColor;

        if (color != null) {
          dyeColor = color.get();
        } else {
          dyeColor = null;
        }

        switch (type.get()) {
          case GOLD -> modelToUse = () -> new GoldShulkerBoxBlockEntity(BlockPos.ZERO, IronShulkerBoxesTypes.get(type.get(), dyeColor).defaultBlockState());
          case DIAMOND -> modelToUse = () -> new DiamondShulkerBoxBlockEntity(BlockPos.ZERO, IronShulkerBoxesTypes.get(type.get(), dyeColor).defaultBlockState());
          case COPPER -> modelToUse = () -> new CopperShulkerBoxBlockEntity(BlockPos.ZERO, IronShulkerBoxesTypes.get(type.get(), dyeColor).defaultBlockState());
          case CRYSTAL -> modelToUse = () -> new CrystalShulkerBoxBlockEntity(BlockPos.ZERO, IronShulkerBoxesTypes.get(type.get(), dyeColor).defaultBlockState());
          case OBSIDIAN -> modelToUse = () -> new ObsidianShulkerBoxBlockEntity(BlockPos.ZERO, IronShulkerBoxesTypes.get(type.get(), dyeColor).defaultBlockState());
          default -> modelToUse = () -> new IronShulkerBoxBlockEntity(BlockPos.ZERO, IronShulkerBoxesTypes.get(type.get(), dyeColor).defaultBlockState());
        }

        return new IronShulkerBoxItemStackRenderer<>(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels(), modelToUse);
      }
    });
  }

  @Override
  public boolean canFitInsideContainerItems() {
    return !(this.getBlock() instanceof AbstractIronShulkerBoxBlock);
  }

  @Override
  public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
    return new IronShulkerBoxItemStackInvWrapper(stack, type);
  }
}
