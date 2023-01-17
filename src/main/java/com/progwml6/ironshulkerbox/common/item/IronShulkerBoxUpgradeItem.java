package com.progwml6.ironshulkerbox.common.item;

import com.progwml6.ironshulkerbox.common.Util;
import com.progwml6.ironshulkerbox.common.block.AbstractIronShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import com.progwml6.ironshulkerbox.common.block.entity.AbstractIronShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class IronShulkerBoxUpgradeItem extends Item {

  private final IronShulkerBoxesUpgradeType type;

  public IronShulkerBoxUpgradeItem(IronShulkerBoxesUpgradeType type, Properties properties) {
    super(properties);
    this.type = type;
  }

  @Override
  public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
    Player entityPlayer = context.getPlayer();
    BlockPos blockPos = context.getClickedPos();
    Level world = context.getLevel();
    ItemStack itemStack = context.getItemInHand();
    boolean passed = false;

    if (world.isClientSide) {
      return InteractionResult.PASS;
    }

    if (entityPlayer == null) {
      return InteractionResult.PASS;
    }

    if (this.type.canUpgrade(IronShulkerBoxesTypes.VANILLA)) {
      if (world.getBlockState(blockPos).getBlock() instanceof ShulkerBoxBlock) {
        passed = true;
      }
    } else {
      if (!(world.getBlockState(blockPos).getBlock() instanceof AbstractIronShulkerBoxBlock block)) {
        passed = true;
      } else {
        if (block.defaultBlockState() == IronShulkerBoxesTypes.get(this.type.source, block.getColor()).defaultBlockState()) {
          passed = true;
        }
      }
    }

    if (!passed) {
      return InteractionResult.PASS;
    }

    BlockEntity blockEntity = world.getBlockEntity(blockPos);

    if (this.type.canUpgrade(IronShulkerBoxesTypes.VANILLA)) {
      if (!(blockEntity instanceof ShulkerBoxBlockEntity)) {
        return InteractionResult.PASS;
      }
    }

    AbstractIronShulkerBoxBlockEntity newShulkerBox = null;
    Component customName = null;
    NonNullList<ItemStack> shulkerBoxContents = NonNullList.withSize(27, ItemStack.EMPTY);
    Direction shulkerBoxFacing;
    DyeColor shulkerBoxColor;
    BlockState iBlockState = IronShulkerBoxesBlocks.COPPER_SHULKER_BOX.get().defaultBlockState();

    if (blockEntity != null) {
      if (blockEntity instanceof AbstractIronShulkerBoxBlockEntity shulkerBox) {
        BlockState shulkerBoxState = world.getBlockState(blockPos);

        if (AbstractIronShulkerBoxBlockEntity.getOpenCount(world, blockPos) > 0) {
          return InteractionResult.PASS;
        }

        if (!shulkerBox.canOpen(entityPlayer)) {
          return InteractionResult.PASS;
        }

        shulkerBoxContents = shulkerBox.getItems();
        shulkerBoxFacing = shulkerBoxState.getValue(AbstractIronShulkerBoxBlock.FACING);
        customName = shulkerBox.getCustomName();
        shulkerBoxColor = shulkerBox.getColor();
        iBlockState = IronShulkerBoxesTypes.get(this.type.target, shulkerBoxColor).defaultBlockState();
        iBlockState = iBlockState.setValue(AbstractIronShulkerBoxBlock.FACING, shulkerBoxFacing);

        newShulkerBox = this.type.target.makeEntity(blockPos, iBlockState, shulkerBoxColor);
      } else if (blockEntity instanceof ShulkerBoxBlockEntity shulkerBox) {
        BlockState shulkerBoxState = world.getBlockState(blockPos);

        if (!shulkerBox.canOpen(entityPlayer)) {
          return InteractionResult.PASS;
        }

        if (!this.type.canUpgrade(IronShulkerBoxesTypes.VANILLA)) {
          return InteractionResult.PASS;
        }

        shulkerBoxContents = NonNullList.withSize(shulkerBox.getContainerSize(), ItemStack.EMPTY);

        for (int slot = 0; slot < shulkerBoxContents.size(); slot++) {
          shulkerBoxContents.set(slot, shulkerBox.getItem(slot));
        }

        shulkerBoxFacing = shulkerBoxState.getValue(ShulkerBoxBlock.FACING);
        customName = shulkerBox.getCustomName();
        shulkerBoxColor = ((ShulkerBoxBlock) shulkerBoxState.getBlock()).getColor();
        iBlockState = IronShulkerBoxesTypes.get(this.type.target, shulkerBoxColor).defaultBlockState();
        iBlockState = iBlockState.setValue(AbstractIronShulkerBoxBlock.FACING, shulkerBoxFacing);

        shulkerBox.clearContent();

        newShulkerBox = this.type.target.makeEntity(blockPos, iBlockState, shulkerBoxColor);
      }
    }

    if (newShulkerBox == null) {
      return InteractionResult.PASS;
    }

    world.removeBlockEntity(blockPos);
    world.removeBlock(blockPos, false);

    world.setBlock(blockPos, iBlockState, 3);
    world.setBlockEntity(newShulkerBox);

    world.sendBlockUpdated(blockPos, iBlockState, iBlockState, 3);

    BlockEntity tileEntity2 = world.getBlockEntity(blockPos);

    if (tileEntity2 instanceof AbstractIronShulkerBoxBlockEntity) {
      if (customName != null) {
        ((AbstractIronShulkerBoxBlockEntity) tileEntity2).setCustomName(customName);
      }

      ((AbstractIronShulkerBoxBlockEntity) tileEntity2).setItems(shulkerBoxContents);
    }

    if (!entityPlayer.getAbilities().instabuild) {
      itemStack.shrink(1);
    }

    return InteractionResult.SUCCESS;
  }

  @Override
  public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
    if (Util.canTranslate("ironshulkerbox.upgrade.tooltip")) {
      if (Util.canTranslate("ironshulkerbox." + this.type.source.getEnglishName().toLowerCase()) && Util.canTranslate("ironshulkerbox." + this.type.target.getEnglishName().toLowerCase())) {
        pTooltipComponents.add((Component.translatable("ironshulkerbox.upgrade.tooltip", Component.translatable("ironshulkerbox." + this.type.source.getEnglishName().toLowerCase()).withStyle(ChatFormatting.BOLD), Component.translatable("ironshulkerbox." + this.type.target.getEnglishName().toLowerCase()).withStyle(ChatFormatting.BOLD))).withStyle(ChatFormatting.DARK_RED));
      }
    }

    if (Util.canTranslate("ironshulkerbox.color.tooltip")) {
      pTooltipComponents.add((Component.translatable("ironshulkerbox.color.tooltip", 0)).withStyle(ChatFormatting.GOLD));
    }

    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
  }
}
