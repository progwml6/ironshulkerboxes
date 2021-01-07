package com.progwml6.ironshulkerbox.common.network;

import com.progwml6.ironshulkerbox.common.block.tileentity.CrystalShulkerBoxTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketTopStackSyncShulkerBox {

  private final BlockPos pos;

  private final NonNullList<ItemStack> topStacks;

  public PacketTopStackSyncShulkerBox(BlockPos pos, NonNullList<ItemStack> topStacks) {
    this.pos = pos;
    this.topStacks = topStacks;
  }

  public static void encode(PacketTopStackSyncShulkerBox msg, PacketBuffer buf) {
    buf.writeInt(msg.pos.getX());
    buf.writeInt(msg.pos.getY());
    buf.writeInt(msg.pos.getZ());
    buf.writeInt(msg.topStacks.size());

    for (ItemStack stack : msg.topStacks) {
      buf.writeItemStack(stack);
    }
  }

  public static PacketTopStackSyncShulkerBox decode(PacketBuffer buf) {
    BlockPos pos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());

    int size = buf.readInt();
    NonNullList<ItemStack> topStacks = NonNullList.withSize(size, ItemStack.EMPTY);

    for (int item = 0; item < size; item++) {
      ItemStack itemStack = buf.readItemStack();

      topStacks.set(item, itemStack);
    }

    return new PacketTopStackSyncShulkerBox(pos, topStacks);
  }

  public static class Handler {

    public static void handle(final PacketTopStackSyncShulkerBox message, Supplier<NetworkEvent.Context> ctx) {
      ctx.get().enqueueWork(() -> {
        World world = DistExecutor.callWhenOn(Dist.CLIENT, () -> () -> Minecraft.getInstance().world);

        if (world != null) {
          TileEntity tile = world.getTileEntity(message.pos);

          if (tile instanceof CrystalShulkerBoxTileEntity) {
            ((CrystalShulkerBoxTileEntity) tile).receiveMessageFromServer(message.topStacks);
          }
        }
      });

      ctx.get().setPacketHandled(true);
    }
  }

}
