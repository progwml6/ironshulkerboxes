package com.progwml6.ironshulkerbox.common.block;

import com.progwml6.ironshulkerbox.common.block.entity.IronShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class IronShulkerBoxBlock extends AbstractIronShulkerBoxBlock {

  public IronShulkerBoxBlock(Properties properties, @Nullable DyeColor color) {
    super(properties, color, IronShulkerBoxesBlockEntityTypes.IRON_SHULKER_BOX::get, IronShulkerBoxesTypes.IRON);
  }

  @Override
  public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
    return new IronShulkerBoxBlockEntity(this.color, pPos, pState);
  }
}
