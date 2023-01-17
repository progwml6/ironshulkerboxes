package com.progwml6.ironshulkerbox.common.block;

import com.progwml6.ironshulkerbox.common.block.entity.DiamondShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class DiamondShulkerBoxBlock extends AbstractIronShulkerBoxBlock {

  public DiamondShulkerBoxBlock(Properties properties, @Nullable DyeColor color) {
    super(properties, color, IronShulkerBoxesBlockEntityTypes.DIAMOND_SHULKER_BOX::get, IronShulkerBoxesTypes.DIAMOND);
  }

  @Override
  public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
    return new DiamondShulkerBoxBlockEntity(this.color, pPos, pState);
  }
}
