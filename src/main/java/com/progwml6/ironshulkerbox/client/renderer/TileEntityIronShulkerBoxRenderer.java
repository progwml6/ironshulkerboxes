package com.progwml6.ironshulkerbox.client.renderer;

import com.google.common.primitives.SignedBytes;
import com.progwml6.ironshulkerbox.common.blocks.BlockShulkerBox;
import com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType;
import com.progwml6.ironshulkerbox.common.tileentity.TileEntityCrystalShulkerBox;
import com.progwml6.ironshulkerbox.common.tileentity.TileEntityIronShulkerBox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderEntityItem;
import net.minecraft.client.renderer.entity.model.ModelShulker;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

import java.util.Random;

public class TileEntityIronShulkerBoxRenderer<T extends TileEntity> extends TileEntityRenderer<T>
{
    private Random random;

    private RenderEntityItem itemRenderer;

    private final ModelShulker model;

    private static float[][] shifts = { { 0.3F, 0.45F, 0.3F }, { 0.7F, 0.45F, 0.3F }, { 0.3F, 0.45F, 0.7F }, { 0.7F, 0.45F, 0.7F }, { 0.3F, 0.1F, 0.3F },
            { 0.7F, 0.1F, 0.3F }, { 0.3F, 0.1F, 0.7F }, { 0.7F, 0.1F, 0.7F }, { 0.5F, 0.32F, 0.5F } };

    private static EntityItem customitem = new EntityItem(null);

    public TileEntityIronShulkerBoxRenderer()
    {
        this.model = new ModelShulker();
        this.random = new Random();
    }

    @Override
    public void render(T tileEntityIn, double x, double y, double z, float partialTicks, int destroyStage)
    {
        EnumFacing enumFacing = EnumFacing.UP;

        TileEntityIronShulkerBox tileEntity = (TileEntityIronShulkerBox) tileEntityIn;

        if (tileEntity.hasWorld())
        {
            IBlockState iblockstate = this.getWorld().getBlockState(tileEntity.getPos());
            if (iblockstate.getBlock() instanceof BlockShulkerBox)
            {
                enumFacing = (EnumFacing) iblockstate.get(BlockShulkerBox.FACING);
            }
        }

        IBlockState iBlockState = tileEntity.hasWorld() ?
                tileEntity.getBlockState() :
                (IBlockState) tileEntity.getBlockToUse().getDefaultState().with(BlockShulkerBox.FACING, EnumFacing.NORTH);
        IronShulkerBoxType chestType = IronShulkerBoxType.IRON;
        IronShulkerBoxType typeNew = BlockShulkerBox.getTypeFromBlock(iBlockState.getBlock());

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
            ResourceLocation rs = new ResourceLocation("ironshulkerbox",
                    "textures/model/" + tileEntity.getColor().getName() + "/shulker_" + tileEntity.getColor().getName() + chestType.modelTexture);
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
        GlStateManager.scalef(0.9995F, 0.9995F, 0.9995F);
        GlStateManager.translatef(0.0F, -1.0F, 0.0F);

        switch (enumFacing)
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

        this.model.getBase().render(0.0625F);

        GlStateManager.translatef(0.0F, -tileEntity.getProgress(partialTicks) * 0.5F, 0.0F);
        GlStateManager.rotatef(270.0F * tileEntity.getProgress(partialTicks), 0.0F, 1.0F, 0.0F);

        this.model.getLid().render(0.0625F);

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

        if (chestType == IronShulkerBoxType.CRYSTAL)
        {
            GlStateManager.enableCull();
        }

        if (chestType.isTransparent()
                && tileEntity.getDistanceSq(this.rendererDispatcher.entityX, this.rendererDispatcher.entityY, this.rendererDispatcher.entityZ) < 128d)
        {
            this.random.setSeed(254L);

            float shiftX;
            float shiftY;
            float shiftZ;
            int shift = 0;
            float blockScale = 0.70F;
            float timeD = (float) (360D * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL) - partialTicks;

            if (((TileEntityCrystalShulkerBox) tileEntity).getTopItems().get(1).isEmpty())
            {
                shift = 8;
                blockScale = 0.85F;
            }

            GlStateManager.pushMatrix();
            GlStateManager.translatef((float) x, (float) y, (float) z);

            customitem.setWorld(this.getWorld());
            customitem.hoverStart = 0F;

            for (ItemStack item : ((TileEntityCrystalShulkerBox) tileEntity).getTopItems())
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

                customitem.setItem(item);

                if (this.itemRenderer == null)
                {
                    this.itemRenderer = new RenderEntityItem(Minecraft.getInstance().getRenderManager(), Minecraft.getInstance().getItemRenderer())
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

                this.itemRenderer.doRender(customitem, 0D, 0D, 0D, 0F, partialTicks);

                GlStateManager.popMatrix();
            }

            GlStateManager.popMatrix();
        }
    }
}
