package com.progwml6.ironshulkerbox.client;

import com.progwml6.ironshulkerbox.client.renderer.IronShulkerBoxTileEntityRenderer;
import com.progwml6.ironshulkerbox.common.ServerProxy;
import com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxType;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends ServerProxy
{
    public ClientProxy()
    {
    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void preInit()
    {
        super.preInit();

        for (ShulkerBoxType type : ShulkerBoxType.values())
        {
            if (type.clazz != null)
            {
                ClientRegistry.bindTileEntitySpecialRenderer(type.clazz, new IronShulkerBoxTileEntityRenderer());
            }
        }
    }

    @Override
    public World getClientWorld()
    {
        return Minecraft.getInstance().world;
    }
}
