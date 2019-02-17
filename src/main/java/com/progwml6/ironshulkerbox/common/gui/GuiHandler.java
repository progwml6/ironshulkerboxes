package com.progwml6.ironshulkerbox.common.gui;

import com.progwml6.ironshulkerbox.client.gui.GUIShulkerBox;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.FMLPlayMessages;

public class GuiHandler
{
    public static GuiScreen openGui(FMLPlayMessages.OpenContainer openContainer)
    {
        BlockPos pos = openContainer.getAdditionalData().readBlockPos();

        for (GUIShulkerBox.GUI type : GUIShulkerBox.GUI.values())
        {
            if (type.getGuiId().equals(openContainer.getId()))
            {
                return new GUIShulkerBox(type, (IInventory) Minecraft.getInstance().player.inventory, (IInventory) Minecraft.getInstance().world.getTileEntity(pos));
            }
        }

        return null;
    }
}
