package com.progwml6.ironshulkerbox.common.network;

import com.progwml6.ironshulkerbox.IronShulkerBox;
import com.progwml6.ironshulkerbox.common.network.packets.PacketTopStackSyncShulkerBox;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public final class PacketHandler
{
    private static final String PROTOCOL_VERSION = Integer.toString(1);

    private static final SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(IronShulkerBox.MOD_ID, "main_channel"))
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .simpleChannel();

    public static void register()
    {
        int disc = 0;

        HANDLER.registerMessage(disc++, PacketTopStackSyncShulkerBox.class, PacketTopStackSyncShulkerBox::encode, PacketTopStackSyncShulkerBox::decode,
                PacketTopStackSyncShulkerBox.Handler::handle);
    }

    public static void sendTo(Object msg, EntityPlayerMP player)
    {
        if (!(player instanceof FakePlayer))
        {
            HANDLER.sendTo(msg, player.connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
        }
    }
}
