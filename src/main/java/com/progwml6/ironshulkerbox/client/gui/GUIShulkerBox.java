package com.progwml6.ironshulkerbox.client.gui;

import com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType;
import com.progwml6.ironshulkerbox.common.gui.ContainerIronShulkerBox;
import com.progwml6.ironshulkerbox.common.tileentity.TileEntityIronShulkerBox;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GUIShulkerBox extends GuiContainer
{
    public enum ResourceList
    {
        //@formatter:off
        IRON(new ResourceLocation("ironshulkerbox", "textures/gui/iron_container.png")),
        COPPER(new ResourceLocation("ironshulkerbox", "textures/gui/copper_container.png")),
        SILVER(new ResourceLocation("ironshulkerbox", "textures/gui/silver_container.png")),
        GOLD(new ResourceLocation("ironshulkerbox", "textures/gui/gold_container.png")),
        DIAMOND(new ResourceLocation("ironshulkerbox", "textures/gui/diamond_container.png"));
        //@formatter:on

        public final ResourceLocation location;

        ResourceList(ResourceLocation loc)
        {
            this.location = loc;
        }
    }

    public enum GUI
    {
        //@formatter:off
        IRON(184, 202, ResourceList.IRON, IronShulkerBoxType.IRON),
        GOLD(184, 256, ResourceList.GOLD, IronShulkerBoxType.GOLD),
        DIAMOND(238, 256, ResourceList.DIAMOND, IronShulkerBoxType.DIAMOND),
        COPPER(184, 184, ResourceList.COPPER, IronShulkerBoxType.COPPER),
        SILVER(184, 238, ResourceList.SILVER, IronShulkerBoxType.SILVER),
        CRYSTAL(238, 256, ResourceList.DIAMOND, IronShulkerBoxType.CRYSTAL),
        OBSIDIAN(238, 256, ResourceList.DIAMOND,IronShulkerBoxType.OBSIDIAN);
        //@formatter:on

        private int xSize;

        private int ySize;

        private ResourceList resourceList;

        private IronShulkerBoxType ironShulkerBoxType;

        GUI(int xSize, int ySize, ResourceList resourceList, IronShulkerBoxType ironShulkerBoxType)
        {
            this.xSize = xSize;
            this.ySize = ySize;
            this.resourceList = resourceList;
            this.ironShulkerBoxType = ironShulkerBoxType;
        }

        protected Container makeContainer(IInventory playerInventory, IInventory chestInventory, EntityPlayer entityPlayer)
        {
            return new ContainerIronShulkerBox(playerInventory, chestInventory, this.ironShulkerBoxType, entityPlayer, this.xSize, this.ySize);
        }

        public static GUIShulkerBox buildGUI(IronShulkerBoxType type, IInventory playerInventory, TileEntityIronShulkerBox shulkerInventory)
        {
            return new GUIShulkerBox(values()[shulkerInventory.getShulkerBoxType().ordinal()], playerInventory, shulkerInventory);
        }
    }

    private GUI type;

    private GUIShulkerBox(GUI type, IInventory player, IInventory shulker)
    {
        super(type.makeContainer(player, shulker, Minecraft.getInstance().player));

        this.type = type;
        this.xSize = type.xSize;
        this.ySize = type.ySize;
        this.allowUserInput = false;
    }

    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    /**
     * Draws the background layer of this container (behind the items).
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.mc.getTextureManager().bindTexture(this.type.resourceList.location);

        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;

        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
    }
}
