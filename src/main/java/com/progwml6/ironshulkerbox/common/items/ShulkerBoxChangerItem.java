package com.progwml6.ironshulkerbox.common.items;

import com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxType;
import com.progwml6.ironshulkerbox.common.tileentity.IronShulkerBoxTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.ShulkerBoxTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class ShulkerBoxChangerItem extends Item
{
    public final ShulkerBoxChangerType type;

    public ShulkerBoxChangerItem(Properties propertiesIn, ShulkerBoxChangerType shulkerBoxChangerTypeIn)
    {
        super(propertiesIn);
        this.type = shulkerBoxChangerTypeIn;
        this.setRegistryName(shulkerBoxChangerTypeIn.itemName);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        if (I18n.hasKey("ironshulkerbox.upgrade.tooltip"))
        {
            if (I18n.hasKey("ironshulkerbox." + this.type.source.name) && I18n.hasKey("ironshulkerbox." + this.type.target.name))
            {
                tooltip.add((new TranslationTextComponent("ironshulkerbox.upgrade.tooltip", new TranslationTextComponent("ironshulkerbox." + this.type.source.name).applyTextStyle(TextFormatting.BOLD), new TranslationTextComponent("ironshulkerbox." + this.type.target.name).applyTextStyle(TextFormatting.BOLD))).applyTextStyle(TextFormatting.DARK_RED));
            }
        }
        if (I18n.hasKey("ironshulkerbox.color.tooltip"))
        {
            tooltip.add((new TranslationTextComponent("ironshulkerbox.color.tooltip", 0)).applyTextStyle(TextFormatting.GOLD));
        }

        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context)
    {
        PlayerEntity entityPlayer = context.getPlayer();
        BlockPos blockPos = context.getPos();
        World world = context.getWorld();
        ItemStack itemStack = context.getItem();

        if (world.isRemote)
        {
            return ActionResultType.PASS;
        }

        if (this.type.canUpgrade(ShulkerBoxType.VANILLA))
        {
            if (!(world.getBlockState(blockPos).getBlock() instanceof ShulkerBoxBlock))
            {
                return ActionResultType.PASS;
            }
        }
        else
        {
            if (!(world.getBlockState(blockPos).getBlock() instanceof ShulkerBoxBlock))
            {
                return ActionResultType.PASS;
            }
            else
            {
                ShulkerBoxBlock block = (ShulkerBoxBlock) world.getBlockState(blockPos).getBlock();
                if (block.getDefaultState() != ShulkerBoxType.get(this.type.source, block.getColor()))
                {
                    return ActionResultType.PASS;
                }
            }
        }

        TileEntity tileEntity = world.getTileEntity(blockPos);
        IronShulkerBoxTileEntity newShulkerBox = new IronShulkerBoxTileEntity();

        ITextComponent customName = null;

        NonNullList<ItemStack> shulkerBoxContents = NonNullList.<ItemStack>withSize(27, ItemStack.EMPTY);
        Direction shulkerBoxFacing = Direction.UP;
        DyeColor shulkerBoxColor = DyeColor.PURPLE;

        if (tileEntity != null)
        {
            if (tileEntity instanceof IronShulkerBoxTileEntity)
            {
                IronShulkerBoxTileEntity shulkerBox = (IronShulkerBoxTileEntity) tileEntity;
                BlockState shulkerBoxState = world.getBlockState(blockPos);

                shulkerBoxContents = shulkerBox.getItems();
                shulkerBoxFacing = shulkerBoxState.get(ShulkerBoxBlock.FACING);
                customName = shulkerBox.getCustomName();
                shulkerBoxColor = shulkerBox.getColor();
                newShulkerBox = this.type.target.makeEntity(shulkerBoxColor);

                shulkerBox.clear();
                //shulkerBox.setDestroyedByCreativePlayer(true);

                if (newShulkerBox == null)
                {
                    return ActionResultType.PASS;
                }
            }
            else if (tileEntity instanceof ShulkerBoxTileEntity)
            {
                BlockState shulkerBoxState = world.getBlockState(blockPos);
                shulkerBoxFacing = shulkerBoxState.get(ShulkerBoxBlock.FACING);
                ShulkerBoxTileEntity shulkerBox = (ShulkerBoxTileEntity) tileEntity;

                if (!this.type.canUpgrade(ShulkerBoxType.VANILLA))
                {
                    return ActionResultType.PASS;
                }

                shulkerBoxContents = NonNullList.<ItemStack>withSize(shulkerBox.getSizeInventory(), ItemStack.EMPTY);

                for (int i = 0; i < shulkerBoxContents.size(); i++)
                {
                    shulkerBoxContents.set(i, shulkerBox.getStackInSlot(i));
                }

                shulkerBoxColor = shulkerBox.getColor();

                customName = shulkerBox.getCustomName();

                shulkerBox.clear();
                //shulkerBox.setDestroyedByCreativePlayer(true);

                newShulkerBox = this.type.target.makeEntity(shulkerBoxColor);
            }
        }

        tileEntity.updateContainingBlockInfo();

        world.removeBlock(blockPos, false);
        world.removeTileEntity(blockPos);

        BlockState iBlockState = ShulkerBoxType.get(this.type.target, shulkerBoxColor).with(ShulkerBoxBlock.FACING, shulkerBoxFacing);

        world.setTileEntity(blockPos, newShulkerBox);
        world.setBlockState(blockPos, iBlockState, 3);

        world.notifyBlockUpdate(blockPos, iBlockState, iBlockState, 3);

        TileEntity tileEntity2 = world.getTileEntity(blockPos);

        if (tileEntity2 instanceof IronShulkerBoxTileEntity)
        {
            if (customName != null)
            {
                ((IronShulkerBoxTileEntity) tileEntity2).setCustomName(customName);
            }

            ((IronShulkerBoxTileEntity) tileEntity2).setItems(shulkerBoxContents);
        }

        if (!entityPlayer.abilities.isCreativeMode)
        {
            itemStack.shrink(1);
        }

        return ActionResultType.SUCCESS;
    }
}
