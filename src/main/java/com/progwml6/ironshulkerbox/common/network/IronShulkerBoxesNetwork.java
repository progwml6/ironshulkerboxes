package com.progwml6.ironshulkerbox.common.network;

import com.progwml6.ironshulkerbox.IronShulkerBoxes;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.Channel;
import net.minecraftforge.network.ChannelBuilder;
import net.minecraftforge.network.SimpleChannel;

public class IronShulkerBoxesNetwork {

  private static final int NPC_VERSION = 1;

  public static SimpleChannel INSTANCE;

  public static void setup() {
    INSTANCE = ChannelBuilder.named(new ResourceLocation(IronShulkerBoxes.MOD_ID, "network"))
      .networkProtocolVersion(NPC_VERSION)
      .clientAcceptedVersions(Channel.VersionTest.exact(NPC_VERSION))
      .serverAcceptedVersions(Channel.VersionTest.exact(NPC_VERSION))
      .simpleChannel();

    INSTANCE.messageBuilder(PacketTopStacksSync.class)
      .encoder(PacketTopStacksSync::encode)
      .decoder(PacketTopStacksSync::decode)
      .consumerNetworkThread(PacketTopStacksSync::handle)
      .add();
  }
}
