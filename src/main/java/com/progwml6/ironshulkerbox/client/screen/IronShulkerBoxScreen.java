package com.progwml6.ironshulkerbox.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import com.progwml6.ironshulkerbox.common.inventory.IronShulkerBoxContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

public class IronShulkerBoxScreen extends ContainerScreen<IronShulkerBoxContainer> {

  private IronShulkerBoxesTypes chestType;

  private int textureXSize;

  private int textureYSize;

  public IronShulkerBoxScreen(IronShulkerBoxContainer container, PlayerInventory playerInventory, ITextComponent title) {
    super(container, playerInventory, title);

    this.chestType = container.getShulkerBoxType();
    this.xSize = container.getShulkerBoxType().xSize;
    this.ySize = container.getShulkerBoxType().ySize;
    this.textureXSize = container.getShulkerBoxType().textureXSize;
    this.textureYSize = container.getShulkerBoxType().textureYSize;

    this.passEvents = false;
  }

  @Override
  public void render(int mouseX, int mouseY, float partialTicks) {
    this.renderBackground();
    super.render(mouseX, mouseY, partialTicks);
    this.renderHoveredToolTip(mouseX, mouseY);
  }

  @Override
  protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
    this.font.drawString(this.title.getFormattedText(), 8.0F, 6.0F, 4210752);
    this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float) (this.ySize - 96 + 2), 4210752);
  }

  @Override
  protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
    RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);

    this.minecraft.getTextureManager().bindTexture(this.chestType.guiTexture);

    int x = (this.width - this.xSize) / 2;
    int y = (this.height - this.ySize) / 2;

    blit(x, y, 0, 0, this.xSize, this.ySize, this.textureXSize, this.textureYSize);
  }
}
