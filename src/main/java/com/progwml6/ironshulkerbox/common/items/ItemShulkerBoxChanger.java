package com.progwml6.ironshulkerbox.common.items;

import com.progwml6.ironshulkerbox.common.blocks.BlockShulkerBox;
import com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType;
import com.progwml6.ironshulkerbox.common.tileentity.TileEntityIronShulkerBox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityShulkerBox;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class ItemShulkerBoxChanger extends Item
{
    public final ShulkerBoxChangerType type;

    public ItemShulkerBoxChanger(Properties properties, ShulkerBoxChangerType shulkerBoxChangerType)
    {
        super(properties);
        this.type = shulkerBoxChangerType;
        this.setRegistryName(shulkerBoxChangerType.itemName);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        if (I18n.hasKey("ironshulkerbox.upgrade.tooltip"))
        {
            if (I18n.hasKey("ironshulkerbox." + this.type.source.name) && I18n.hasKey("ironshulkerbox." + this.type.target.name))
            {
                tooltip.add((new TextComponentTranslation("ironshulkerbox.upgrade.tooltip", new TextComponentTranslation("ironshulkerbox." + this.type.source.name).applyTextStyle(TextFormatting.BOLD), new TextComponentTranslation("ironshulkerbox." + this.type.target.name).applyTextStyle(TextFormatting.BOLD))).applyTextStyle(TextFormatting.DARK_RED));
            }
        }
        if (I18n.hasKey("ironshulkerbox.color.tooltip"))
        {
            tooltip.add((new TextComponentTranslation("ironshulkerbox.color.tooltip", 0)).applyTextStyle(TextFormatting.GOLD));
        }

        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public EnumActionResult onItemUseFirst(ItemStack stack, ItemUseContext context)
    {
        EntityPlayer entityPlayer = context.getPlayer();
        BlockPos blockPos = context.getPos();
        World world = context.getWorld();
        ItemStack itemStack = context.getItem();

        if (world.isRemote)
        {
            return EnumActionResult.PASS;
        }

        if (this.type.canUpgrade(IronShulkerBoxType.VANILLA))
        {
            if (!(world.getBlockState(blockPos).getBlock() instanceof net.minecraft.block.BlockShulkerBox))
            {
                return EnumActionResult.PASS;
            }
        }
        else
        {
            if (!(world.getBlockState(blockPos).getBlock() instanceof BlockShulkerBox))
            {
                return EnumActionResult.PASS;
            }
            else
            {
                BlockShulkerBox block = (BlockShulkerBox) world.getBlockState(blockPos).getBlock();
                if (block.getDefaultState() != IronShulkerBoxType.get(this.type.source, block.getColor()))
                {
                    return EnumActionResult.PASS;
                }
            }
        }

        TileEntity tileEntity = world.getTileEntity(blockPos);
        TileEntityIronShulkerBox newShulkerBox = new TileEntityIronShulkerBox();

        ITextComponent customName = null;

        NonNullList<ItemStack> shulkerBoxContents = NonNullList.<ItemStack>withSize(27, ItemStack.EMPTY);
        EnumFacing shulkerBoxFacing = EnumFacing.UP;
        EnumDyeColor shulkerBoxColor = EnumDyeColor.PURPLE;

        if (tileEntity != null)
        {
            if (tileEntity instanceof TileEntityIronShulkerBox)
            {
                TileEntityIronShulkerBox shulkerBox = (TileEntityIronShulkerBox) tileEntity;
                IBlockState shulkerBoxState = world.getBlockState(blockPos);

                shulkerBoxContents = shulkerBox.getItems();
                shulkerBoxFacing = shulkerBoxState.get(BlockShulkerBox.FACING);
                customName = shulkerBox.getCustomName();
                shulkerBoxColor = shulkerBox.getColor();
                newShulkerBox = this.type.target.makeEntity(shulkerBoxColor);

                shulkerBox.clear();
                shulkerBox.setDestroyedByCreativePlayer(true);

                if (newShulkerBox == null)
                {
                    return EnumActionResult.PASS;
                }
            }
            else if (tileEntity instanceof TileEntityShulkerBox)
            {
                IBlockState shulkerBoxState = world.getBlockState(blockPos);
                shulkerBoxFacing = shulkerBoxState.get(net.minecraft.block.BlockShulkerBox.FACING);
                TileEntityShulkerBox shulkerBox = (TileEntityShulkerBox) tileEntity;

                if (!this.type.canUpgrade(IronShulkerBoxType.VANILLA))
                {
                    return EnumActionResult.PASS;
                }

                shulkerBoxContents = NonNullList.<ItemStack>withSize(shulkerBox.getSizeInventory(), ItemStack.EMPTY);

                for (int i = 0; i < shulkerBoxContents.size(); i++)
                {
                    shulkerBoxContents.set(i, shulkerBox.getStackInSlot(i));
                }

                shulkerBoxColor = shulkerBox.getColor();

                customName = shulkerBox.getCustomName();

                shulkerBox.clear();
                shulkerBox.setDestroyedByCreativePlayer(true);

                newShulkerBox = this.type.target.makeEntity(shulkerBoxColor);
            }
        }

        tileEntity.updateContainingBlockInfo();

        world.removeBlock(blockPos);
        world.removeTileEntity(blockPos);

        IBlockState iBlockState = IronShulkerBoxType.get(this.type.target, shulkerBoxColor).with(BlockShulkerBox.FACING, shulkerBoxFacing);

        world.setTileEntity(blockPos, newShulkerBox);
        world.setBlockState(blockPos, iBlockState, 3);

        world.notifyBlockUpdate(blockPos, iBlockState, iBlockState, 3);

        TileEntity tileEntity2 = world.getTileEntity(blockPos);

        if (tileEntity2 instanceof TileEntityIronShulkerBox)
        {
            if (customName != null)
            {
                ((TileEntityIronShulkerBox) tileEntity2).setCustomName(customName);
            }

            ((TileEntityIronShulkerBox) tileEntity2).setItems(shulkerBoxContents);
        }

        if (!entityPlayer.abilities.isCreativeMode)
        {
            itemStack.shrink(1);
        }

        return EnumActionResult.SUCCESS;
    }
}
