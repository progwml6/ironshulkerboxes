package com.progwml6.ironshulkerbox.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.progwml6.ironshulkerbox.client.model.IronShulkerBoxesModels;
import com.progwml6.ironshulkerbox.client.model.inventory.ModelItem;
import com.progwml6.ironshulkerbox.common.block.AbstractIronShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import com.progwml6.ironshulkerbox.common.block.entity.AbstractIronShulkerBoxBlockEntity;
import com.progwml6.ironshulkerbox.common.block.entity.ICrystalShulkerBox;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ShulkerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Vector3f;

import java.util.Arrays;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class IronShulkerBoxRenderer implements BlockEntityRenderer<AbstractIronShulkerBoxBlockEntity> {

  private final ShulkerModel<?> model;

  private final BlockEntityRenderDispatcher renderer;

  private static final List<ModelItem> MODEL_ITEMS = Arrays.asList(
    new ModelItem(new Vector3f(0.3F, 0.45F, 0.3F), 3.0F),
    new ModelItem(new Vector3f(0.7F, 0.45F, 0.3F), 3.0F),
    new ModelItem(new Vector3f(0.3F, 0.45F, 0.7F), 3.0F),
    new ModelItem(new Vector3f(0.7F, 0.45F, 0.7F), 3.0F),
    new ModelItem(new Vector3f(0.3F, 0.1F, 0.3F), 3.0F),
    new ModelItem(new Vector3f(0.7F, 0.1F, 0.3F), 3.0F),
    new ModelItem(new Vector3f(0.3F, 0.1F, 0.7F), 3.0F),
    new ModelItem(new Vector3f(0.7F, 0.1F, 0.7F), 3.0F),
    new ModelItem(new Vector3f(0.5F, 0.32F, 0.5F), 3.0F)
  );

  public IronShulkerBoxRenderer(BlockEntityRendererProvider.Context context) {
    this.model = new ShulkerModel<>(context.bakeLayer(ModelLayers.SHULKER));
    this.renderer = context.getBlockEntityRenderDispatcher();
  }

  @Override
  public void render(AbstractIronShulkerBoxBlockEntity tileEntityIn, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int combinedLightIn, int combinedOverlayIn) {
    Direction direction = Direction.UP;

    if (tileEntityIn.hasLevel() && tileEntityIn.getLevel() != null) {
      BlockState blockstate = tileEntityIn.getLevel().getBlockState(tileEntityIn.getBlockPos());

      if (blockstate.getBlock() instanceof AbstractIronShulkerBoxBlock) {
        direction = blockstate.getValue(AbstractIronShulkerBoxBlock.FACING);
      }
    }

    Level level = tileEntityIn.getLevel();
    boolean useTileEntityBlockState = level != null;

    BlockState blockState = useTileEntityBlockState ? tileEntityIn.getBlockState() : tileEntityIn.getBlockToUse().defaultBlockState().setValue(AbstractIronShulkerBoxBlock.FACING, Direction.UP);
    Block block = blockState.getBlock();

    IronShulkerBoxesTypes boxType = IronShulkerBoxesTypes.IRON;
    IronShulkerBoxesTypes typeFromTileEntity = tileEntityIn.getShulkerBoxType();
    IronShulkerBoxesTypes typeFromBlock = AbstractIronShulkerBoxBlock.getTypeFromBlock(block);

    if (typeFromTileEntity != null) {
      boxType = typeFromTileEntity;
    }

    if (boxType != typeFromBlock || typeFromTileEntity != typeFromBlock) {
      if (typeFromBlock != null) {
        boxType = typeFromBlock;
      }
    }

    DyeColor dyecolor = tileEntityIn.getColor();
    Material material;

    if (dyecolor == null) {
      material = new Material(Sheets.SHULKER_SHEET, IronShulkerBoxesModels.chooseShulkerBoxTexture(boxType));
    } else {
      material = new Material(Sheets.SHULKER_SHEET, IronShulkerBoxesModels.chooseShulkerBoxTexture(boxType, dyecolor.getId()));
    }

    poseStack.pushPose();
    poseStack.translate(0.5F, 0.5F, 0.5F);
    poseStack.scale(0.9995F, 0.9995F, 0.9995F);
    poseStack.mulPose(direction.getRotation());
    poseStack.scale(1.0F, -1.0F, -1.0F);
    poseStack.translate(0.0F, -1.0F, 0.0F);
    ModelPart modelpart = this.model.getLid();
    modelpart.setPos(0.0F, 24.0F - tileEntityIn.getProgress(partialTicks) * 0.5F * 16.0F, 0.0F);
    modelpart.yRot = 270.0F * tileEntityIn.getProgress(partialTicks) * ((float) Math.PI / 180F);
    VertexConsumer vertexconsumer = material.buffer(bufferSource, RenderType::entityCutoutNoCull);
    this.model.renderToBuffer(poseStack, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
    poseStack.popPose();

    if (boxType.isTransparent() && tileEntityIn instanceof ICrystalShulkerBox crystalShulkerBox && Vec3.atCenterOf(tileEntityIn.getBlockPos()).closerThan(this.renderer.camera.getPosition(), 128d)) {
      float rotation = (float) (360D * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL) - partialTicks;

      for (int j = 0; j < MODEL_ITEMS.size() - 1; j++) {
        renderItem(poseStack, bufferSource, crystalShulkerBox.getTopItems().get(j), MODEL_ITEMS.get(j), rotation, combinedLightIn);
      }
    }
  }

  /**
   * Renders a single item in a TESR
   *
   * @param matrices  Matrix stack instance
   * @param buffer    Buffer instance
   * @param item      Item to render
   * @param modelItem Model items for render information
   * @param light     Model light
   */
  public static void renderItem(PoseStack matrices, MultiBufferSource buffer, ItemStack item, ModelItem modelItem, float rotation, int light) {
    // if no stack, skip
    if (item.isEmpty()) return;

    // start rendering
    matrices.pushPose();
    Vector3f center = modelItem.getCenter();
    matrices.translate(center.x(), center.y(), center.z());

    matrices.mulPose(Axis.YP.rotationDegrees(rotation));

    // scale
    float scale = modelItem.getSizeScaled();
    matrices.scale(scale, scale, scale);

    // render the actual item
    Minecraft.getInstance().getItemRenderer().renderStatic(item, ItemTransforms.TransformType.NONE, light, OverlayTexture.NO_OVERLAY, matrices, buffer, 0);

    matrices.popPose();
  }
}
