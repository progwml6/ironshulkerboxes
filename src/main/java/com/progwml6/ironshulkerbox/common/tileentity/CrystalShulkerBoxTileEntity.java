package com.progwml6.ironshulkerbox.common.tileentity;

import com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxType;
import com.progwml6.ironshulkerbox.common.core.IronShulkerBoxBlocks;
import com.progwml6.ironshulkerbox.common.inventory.ShulkerBoxContainer;
import com.progwml6.ironshulkerbox.common.network.PacketHandler;
import com.progwml6.ironshulkerbox.common.network.packets.PacketTopStackSyncShulkerBox;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.network.PacketDistributor;

import javax.annotation.Nullable;

public class CrystalShulkerBoxTileEntity extends IronShulkerBoxTileEntity
{
    private NonNullList<ItemStack> topStacks;

    private boolean inventoryTouched;

    private boolean hadStuff;

    public CrystalShulkerBoxTileEntity()
    {
        this(null);
    }

    public CrystalShulkerBoxTileEntity(@Nullable DyeColor colorIn)
    {
        super(ShulkerBoxTileEntityType.CRYSTAL_SHULKER_BOX, colorIn, ShulkerBoxType.CRYSTAL, IronShulkerBoxBlocks.crystalShulkerBoxes);
        this.topStacks = NonNullList.<ItemStack>withSize(8, ItemStack.EMPTY);
    }

    @Override
    protected Container createMenu(int id, PlayerInventory playerInventory)
    {
        return ShulkerBoxContainer.createCrystalContainer(id, playerInventory, this);
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
        this.fillWithLoot((PlayerEntity) null);

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

        NonNullList<ItemStack> tempCopy = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);

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
                BlockState iblockstate = this.world.getBlockState(this.pos);

                this.world.notifyBlockUpdate(this.pos, iblockstate, iblockstate, 3);
            }

            return;
        }

        this.hadStuff = true;

        tempCopy.sort((stack1, stack2) -> {
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
            BlockState iblockstate = this.world.getBlockState(this.pos);

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

        PacketHandler.send(PacketDistributor.TRACKING_CHUNK.with(() -> this.getWorld().getChunk(this.getPos())), new PacketTopStackSyncShulkerBox(this.getWorld().getDimension().getType().getId(), this.getPos(), stacks));
    }

    public void receiveMessageFromServer(NonNullList<ItemStack> topStacks)
    {
        this.topStacks = topStacks;
    }
}
