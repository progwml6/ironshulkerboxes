package com.progwml6.ironshulkerbox.common.tileentity;

import com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType;
import com.progwml6.ironshulkerbox.common.core.IronShulkerBoxBlocks;
import com.progwml6.ironshulkerbox.common.network.PacketHandler;
import com.progwml6.ironshulkerbox.common.network.packets.PacketTopStackSyncShulkerBox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Comparator;

public class TileEntityCrystalShulkerBox extends TileEntityIronShulkerBox
{
    /** Crystal Shulker Box top stacks */
    private NonNullList<ItemStack> topStacks;

    /** If the inventory got touched */
    private boolean inventoryTouched;

    /** If the inventory had items */
    private boolean hadStuff;

    public TileEntityCrystalShulkerBox()
    {
        this(null);
    }

    public TileEntityCrystalShulkerBox(@Nullable EnumDyeColor colorIn)
    {
        super(IronShulkerBoxEntityType.CRYSTAL_SHULKER_BOX, colorIn, IronShulkerBoxType.CRYSTAL, IronShulkerBoxBlocks.crystalShulkerBoxes);
        this.topStacks = NonNullList.<ItemStack>withSize(8, ItemStack.EMPTY);
    }

    @Override
    public void tick()
    {
        super.tick();

        if (!this.world.isRemote && this.inventoryTouched)
        {
            this.inventoryTouched = false;

            this.sortTopStacks();
        }
    }

    @Override
    public void setItems(NonNullList<ItemStack> contents)
    {
        super.setItems(contents);

        this.inventoryTouched = true;
    }

    @Override
    public ItemStack getStackInSlot(int index)
    {
        this.fillWithLoot((EntityPlayer) null);

        this.inventoryTouched = true;

        return this.getItems().get(index);
    }

    public NonNullList<ItemStack> getTopItems()
    {
        return this.topStacks;
    }

    protected void sortTopStacks()
    {
        if (!this.getShulkerBoxType().isTransparent() || (this.world != null && this.world.isRemote))
        {
            return;
        }

        NonNullList<ItemStack> tempCopy = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);

        boolean hasStuff = false;

        int compressedIdx = 0;

        mainLoop:
        for (int i = 0; i < this.getSizeInventory(); i++)
        {
            ItemStack itemStack = this.getItems().get(i);

            if (!itemStack.isEmpty())
            {
                for (int j = 0; j < compressedIdx; j++)
                {
                    ItemStack tempCopyStack = tempCopy.get(j);

                    if (ItemStack.areItemsEqualIgnoreDurability(tempCopyStack, itemStack))
                    {
                        if (itemStack.getCount() != tempCopyStack.getCount())
                        {
                            tempCopyStack.grow(itemStack.getCount());
                        }

                        continue mainLoop;
                    }
                }

                tempCopy.set(compressedIdx, itemStack.copy());

                compressedIdx++;

                hasStuff = true;
            }
        }

        if (!hasStuff && this.hadStuff)
        {
            this.hadStuff = false;

            for (int i = 0; i < this.getTopItems().size(); i++)
            {
                this.getTopItems().set(i, ItemStack.EMPTY);
            }

            if (this.world != null)
            {
                IBlockState iblockstate = this.world.getBlockState(this.pos);

                this.world.notifyBlockUpdate(this.pos, iblockstate, iblockstate, 3);
            }

            return;
        }

        this.hadStuff = true;

        Collections.sort(tempCopy, (stack1, stack2) -> {
            if (stack1.isEmpty())
            {
                return 1;
            }
            else if (stack2.isEmpty())
            {
                return -1;
            }
            else
            {
                return stack2.getCount() - stack1.getCount();
            }
        });

        int p = 0;

        for (ItemStack element : tempCopy)
        {
            if (!element.isEmpty() && element.getCount() > 0)
            {
                if (p == this.getTopItems().size())
                {
                    break;
                }

                this.getTopItems().set(p, element);

                p++;
            }
        }

        for (int i = p; i < this.getTopItems().size(); i++)
        {
            this.getTopItems().set(i, ItemStack.EMPTY);
        }

        if (this.world != null)
        {
            IBlockState iblockstate = this.world.getBlockState(this.pos);

            this.world.notifyBlockUpdate(this.pos, iblockstate, iblockstate, 3);
        }

        this.sendTopStacksPacket();
    }

    public NonNullList<ItemStack> buildItemStackDataList()
    {
        if (this.getShulkerBoxType().isTransparent())
        {
            NonNullList<ItemStack> sortList = NonNullList.withSize(this.getTopItems().size(), ItemStack.EMPTY);

            int pos = 0;

            for (ItemStack is : this.topStacks)
            {
                if (!is.isEmpty())
                {
                    sortList.set(pos, is);
                }
                else
                {
                    sortList.set(pos, ItemStack.EMPTY);
                }

                pos++;
            }

            return sortList;
        }

        return NonNullList.withSize(this.getTopItems().size(), ItemStack.EMPTY);
    }

    protected void sendTopStacksPacket()
    {
        NonNullList<ItemStack> stacks = this.buildItemStackDataList();

        for (EntityPlayerMP player : ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers())
        {
            if (player.dimension == this.world.getDimension().getId())
            {
                double d4 = this.getPos().getX() - player.posX;
                double d5 = this.getPos().getY() - player.posY;
                double d6 = this.getPos().getZ() - player.posZ;

                if (d4 * d4 + d5 * d5 + d6 * d6 < 16384)
                {
                    PacketHandler.sendTo(new PacketTopStackSyncShulkerBox(this.getWorld().getDimension().getId(), this.getPos(), stacks), player);
                }
            }
        }
    }

    public void receiveMessageFromServer(NonNullList<ItemStack> topStacks)
    {
        this.topStacks = topStacks;
    }
}
