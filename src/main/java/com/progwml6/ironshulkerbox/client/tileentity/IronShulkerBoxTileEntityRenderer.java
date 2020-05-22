package com.progwml6.ironshulkerbox.client.tileentity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.progwml6.ironshulkerbox.common.block.GenericIronShulkerBlock;
import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import com.progwml6.ironshulkerbox.common.block.tileentity.GenericIronShulkerBoxTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.model.ShulkerModel;
import net.minecraft.client.renderer.model.Material;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.DyeColor;
import net.minecraft.util.Direction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class IronShulkerBoxTileEntityRenderer extends TileEntityRenderer<GenericIronShulkerBoxTileEntity> {

  private final ShulkerModel<?> model;

  public IronShulkerBoxTileEntityRenderer(TileEntityRendererDispatcher tileEntityRendererDispatcher) {
    super(tileEntityRendererDispatcher);
    this.model = new ShulkerModel();
  }

  @Override
  public void render(GenericIronShulkerBoxTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
    Direction direction = Direction.UP;

    if (tileEntityIn.hasWorld()) {
      BlockState blockstate = tileEntityIn.getWorld().getBlockState(tileEntityIn.getPos());
      if (blockstate.getBlock() instanceof GenericIronShulkerBlock) {
        direction = blockstate.get(GenericIronShulkerBlock.FACING);
      }
    }

    BlockState blockState = tileEntityIn.hasWorld() ? tileEntityIn.getBlockState() : (BlockState) tileEntityIn.getBlockToUse().getDefaultState().with(GenericIronShulkerBlock.FACING, Direction.NORTH);
    IronShulkerBoxesTypes boxType = IronShulkerBoxesTypes.IRON;
    IronShulkerBoxesTypes typeFromTileEntity = tileEntityIn.getShulkerBoxType();
    IronShulkerBoxesTypes typeFromBlock = GenericIronShulkerBlock.getTypeFromBlock(blockState.getBlock());

    if (typeFromTileEntity != null) {
      boxType = typeFromTileEntity;
    }

    if (boxType != typeFromBlock || typeFromTileEntity != typeFromBlock) {
      if (typeFromBlock != null) {
        boxType = typeFromBlock;
      }
    }

    DyeColor dyecolor = tileEntityIn.getColor();

    Material material = new Material(Atlases.SHULKER_BOX_ATLAS, IronShulkerBoxesModels.chooseShulkerBoxModel(boxType, dyecolor.getId()));

    matrixStackIn.push();
    matrixStackIn.translate(0.5D, 0.5D, 0.5D);
    float f = 0.9995F;
    matrixStackIn.scale(0.9995F, 0.9995F, 0.9995F);
    matrixStackIn.rotate(direction.getRotation());
    matrixStackIn.scale(1.0F, -1.0F, -1.0F);
    matrixStackIn.translate(0.0D, -1.0D, 0.0D);
    IVertexBuilder ivertexbuilder = material.getBuffer(bufferIn, RenderType::getEntityCutoutNoCull);
    this.model.getBase().render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
    matrixStackIn.translate(0.0D, (double) (-tileEntityIn.getProgress(partialTicks) * 0.5F), 0.0D);
    matrixStackIn.rotate(Vector3f.YP.rotationDegrees(270.0F * tileEntityIn.getProgress(partialTicks)));
    this.model.getLid().render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
    matrixStackIn.pop();
  }
}
