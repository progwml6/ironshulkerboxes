package com.progwml6.ironshulkerbox;

import com.progwml6.ironshulkerbox.client.ClientProxy;
import com.progwml6.ironshulkerbox.common.ServerProxy;
import com.progwml6.ironshulkerbox.common.core.IronShulkerBoxBlocks;
import com.progwml6.ironshulkerbox.common.core.IronShulkerBoxRecipes;
import com.progwml6.ironshulkerbox.common.gui.GuiHandler;
import com.progwml6.ironshulkerbox.common.network.PacketHandler;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = IronShulkerBox.MOD_ID)
public class IronShulkerBox
{
    public static final String MOD_ID = "ironshulkerbox";

    public static IronShulkerBox instance;

    public static ServerProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    public IronShulkerBox()
    {
        instance = this;
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::preInit);
        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.GUIFACTORY, () -> GuiHandler::openGui);
    }

    private void preInit(final FMLCommonSetupEvent event)
    {
        proxy.preInit();

        IronShulkerBoxBlocks.createShulkerItemList();

        PacketHandler.register();

        IronShulkerBoxRecipes.register();
    }
}
