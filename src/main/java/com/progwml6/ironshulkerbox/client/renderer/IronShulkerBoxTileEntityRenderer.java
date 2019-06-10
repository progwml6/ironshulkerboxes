package com.progwml6.ironshulkerbox.client.renderer;

import com.google.common.primitives.SignedBytes;
import com.mojang.blaze3d.platform.GlStateManager;
import com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxBlock;
import com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxType;
import com.progwml6.ironshulkerbox.common.tileentity.CrystalShulkerBoxTileEntity;
import com.progwml6.ironshulkerbox.common.tileentity.IronShulkerBoxTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.model.ShulkerModel;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;

import java.util.Random;

public class IronShulkerBoxTileEntityRenderer<T extends TileEntity> extends TileEntityRenderer<T>
{
    private final ShulkerModel<?> shulkerModel;

    private static ItemEntity customItem;

    private Random random;

    private ItemRenderer itemRenderer;

    private static float[][] shifts = { { 0.3F, 0.45F, 0.3F }, { 0.7F, 0.45F, 0.3F }, { 0.3F, 0.45F, 0.7F }, { 0.7F, 0.45F, 0.7F }, { 0.3F, 0.1F, 0.3F }, { 0.7F, 0.1F, 0.3F }, { 0.3F, 0.1F, 0.7F }, { 0.7F, 0.1F, 0.7F }, { 0.5F, 0.32F, 0.5F } };

    public IronShulkerBoxTileEntityRenderer()
    {
        this.shulkerModel = new ShulkerModel();
        this.random = new Random();
    }

    @Override
    public void render(T tileEntityIn, double x, double y, double z, float partialTicks, int destroyStage)
    {
        Direction direction = Direction.UP;

        IronShulkerBoxTileEntity tileEntity = (IronShulkerBoxTileEntity) tileEntityIn;

        if (tileEntityIn.hasWorld())
        {
            BlockState blockstate = this.getWorld().getBlockState(tileEntityIn.getPos());

            if (blockstate.getBlock() instanceof ShulkerBoxBlock)
            {
                direction = blockstate.get(ShulkerBoxBlock.FACING);
            }
        }

        BlockState iBlockState = tileEntity.hasWorld() ? tileEntity.getBlockState() : (BlockState) tileEntity.getBlockToUse().getDefaultState().with(ShulkerBoxBlock.FACING, Direction.NORTH);
        ShulkerBoxType chestType = ShulkerBoxType.IRON;
        ShulkerBoxType typeNew = ShulkerBoxBlock.getTypeFromBlock(iBlockState.getBlock());

        if (typeNew != null)
        {
            chestType = typeNew;
        }

        GlStateManager.enableDepthTest();
        GlStateManager.depthFunc(515);
        GlStateManager.depthMask(true);
        GlStateManager.disableCull();
        if (destroyStage >= 0)
        {
            this.bindTexture(DESTROY_STAGES[destroyStage]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scalef(4.0F, 4.0F, 1.0F);
            GlStateManager.translatef(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
        }
        else
        {
            ResourceLocation rs = new ResourceLocation("ironshulkerbox", "textures/model/" + tileEntity.getColor().getName() + "/shulker_" + tileEntity.getColor().getName() + chestType.modelTexture);
            this.bindTexture(rs);
        }

        GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();

        if (destroyStage < 0)
        {
            GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        }

        GlStateManager.translatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GlStateManager.scalef(1.0F, -1.0F, -1.0F);
        GlStateManager.translatef(0.0F, 1.0F, 0.0F);
        float f = 0.9995F;
        GlStateManager.scalef(0.9995F, 0.9995F, 0.9995F);
        GlStateManager.translatef(0.0F, -1.0F, 0.0F);

        switch (direction)
        {
            case DOWN:
                GlStateManager.translatef(0.0F, 2.0F, 0.0F);
                GlStateManager.rotatef(180.0F, 1.0F, 0.0F, 0.0F);
            case UP:
            default:
                break;
            case NORTH:
                GlStateManager.translatef(0.0F, 1.0F, 1.0F);
                GlStateManager.rotatef(90.0F, 1.0F, 0.0F, 0.0F);
                GlStateManager.rotatef(180.0F, 0.0F, 0.0F, 1.0F);
                break;
            case SOUTH:
                GlStateManager.translatef(0.0F, 1.0F, -1.0F);
                GlStateManager.rotatef(90.0F, 1.0F, 0.0F, 0.0F);
                break;
            case WEST:
                GlStateManager.translatef(-1.0F, 1.0F, 0.0F);
                GlStateManager.rotatef(90.0F, 1.0F, 0.0F, 0.0F);
                GlStateManager.rotatef(-90.0F, 0.0F, 0.0F, 1.0F);
                break;
            case EAST:
                GlStateManager.translatef(1.0F, 1.0F, 0.0F);
                GlStateManager.rotatef(90.0F, 1.0F, 0.0F, 0.0F);
                GlStateManager.rotatef(90.0F, 0.0F, 0.0F, 1.0F);
        }

        this.shulkerModel.getBase().render(0.0625F);
        GlStateManager.translatef(0.0F, -tileEntity.getProgress(partialTicks) * 0.5F, 0.0F);
        GlStateManager.rotatef(270.0F * tileEntity.getProgress(partialTicks), 0.0F, 1.0F, 0.0F);
        this.shulkerModel.getLid().render(0.0625F);
        GlStateManager.enableCull();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);

        if (destroyStage >= 0)
        {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }

        if (chestType == ShulkerBoxType.CRYSTAL)
        {
            GlStateManager.enableCull();
        }

        if (false && chestType.isTransparent() && tileEntity.getDistanceSq(this.rendererDispatcher.renderInfo.func_216785_c().x, this.rendererDispatcher.renderInfo.func_216785_c().y, this.rendererDispatcher.renderInfo.func_216785_c().z) < 128d)
        {
            this.random.setSeed(254L);

            float shiftX;
            float shiftY;
            float shiftZ;
            int shift = 0;
            float blockScale = 0.70F;
            float timeD = (float) (360D * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL) - partialTicks;

            if (((CrystalShulkerBoxTileEntity) tileEntity).getTopItems().get(1).isEmpty())
            {
                shift = 8;
                blockScale = 0.85F;
            }

            GlStateManager.pushMatrix();
            GlStateManager.translatef((float) x, (float) y, (float) z);

            if (customItem == null)
            {
                customItem = new ItemEntity(EntityType.ITEM, this.getWorld());
            }
            //customitem.hoverStart = 0F;

            for (ItemStack item : ((CrystalShulkerBoxTileEntity) tileEntity).getTopItems())
            {
                if (shift > shifts.length || shift > 8)
                {
                    break;
                }

                if (item.isEmpty())
                {
                    shift++;
                    continue;
                }

                shiftX = shifts[shift][0];
                shiftY = shifts[shift][1];
                shiftZ = shifts[shift][2];
                shift++;

                GlStateManager.pushMatrix();
                GlStateManager.translatef(shiftX, shiftY, shiftZ);
                GlStateManager.rotatef(timeD, 0F, 1F, 0F);
                GlStateManager.scalef(blockScale, blockScale, blockScale);

                customItem.setItem(item);

                if (this.itemRenderer == null)
                {
                    this.itemRenderer = new ItemRenderer(Minecraft.getInstance().getRenderManager(), Minecraft.getInstance().getItemRenderer())
                    {
                        @Override
                        public int getModelCount(ItemStack stack)
                        {
                            return SignedBytes.saturatedCast(Math.min(stack.getCount() / 32, 15) + 1);
                        }

                        @Override
                        public boolean shouldBob()
                        {
                            return false;
                        }

                        @Override
                        public boolean shouldSpreadItems()
                        {
                            return true;
                        }
                    };
                }

                this.itemRenderer.doRender(customItem, 0D, 0D, 0D, 0F, partialTicks);

                GlStateManager.popMatrix();
            }

            GlStateManager.popMatrix();
        }
    }
}
