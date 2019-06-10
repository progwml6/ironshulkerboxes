package com.progwml6.ironshulkerbox.common.inventory;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.FMLPlayMessages;

public class GuiHandler
{
    public static Screen openGui(FMLPlayMessages.OpenContainer openContainer)
    {
        BlockPos pos = openContainer.getAdditionalData().readBlockPos();

        /*for (GUIShulkerBox.GUI type : GUIShulkerBox.GUI.values())
        {
            if (type.getGuiId().equals(openContainer.getWindowId()))
            {
                return new GUIShulkerBox(type, (IInventory) Minecraft.getInstance().field_71439_g.field_71071_by, (IInventory) Minecraft.getInstance().field_71441_e.getTileEntity(pos));
            }
        }*/

        return null;
    }
}
