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

    public ShulkerBoxScreen(ShulkerBoxContainer container, PlayerInventory playerInventory, ITextComponent title)
    {
        super(container, playerInventory, title);

        this.shulkerBoxType = container.getShulkerBoxType();
        System.out.println("getShulkerBoxType: " + container.getShulkerBoxType());
        System.out.println("xSize: " + container.getShulkerBoxType().xSize);
        System.out.println("ySize: " + container.getShulkerBoxType().ySize);
        this.xSize = this.shulkerBoxType.xSize;
        this.ySize = this.shulkerBoxType.ySize;

        this.passEvents = false;
    }

    @Override
    protected void init()
    {
        super.init();
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        System.out.println(mouseX);
        System.out.println(mouseY);
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseX);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.minecraft.getTextureManager().bindTexture(this.shulkerBoxType.guiTexture);

        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;

        this.blit(x, y, 0, 0, this.xSize, this.ySize);
    }

}
