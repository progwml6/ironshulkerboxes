package com.progwml6.ironshulkerbox.client.inventory;

import com.mojang.blaze3d.platform.GlStateManager;
import com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxType;
import com.progwml6.ironshulkerbox.common.inventory.ShulkerBoxContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ShulkerBoxScreen extends ContainerScreen<ShulkerBoxContainer>
{
    private ShulkerBoxType shulkerBoxType;

    private int textureXSize;

    private int textureYSize;

    public ShulkerBoxScreen(ShulkerBoxContainer container, PlayerInventory playerInventory, ITextComponent title)
    {
        super(container, playerInventory, title);

        this.shulkerBoxType = container.getShulkerBoxType();
        this.xSize = container.getShulkerBoxType().xSize;
        this.ySize = container.getShulkerBoxType().ySize;
        this.textureXSize = container.getShulkerBoxType().textureXSize;
        this.textureYSize = container.getShulkerBoxType().textureYSize;

        this.passEvents = false;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        this.font.drawString(this.title.getFormattedText(), 8.0F, 6.0F, 4210752);
        this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float) (this.ySize - 96 + 2), 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.minecraft.getTextureManager().bindTexture(this.shulkerBoxType.guiTexture);

        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;

        this.blit(x, y, 0, 0, this.xSize, this.ySize, textureXSize, textureYSize);
    }

}
