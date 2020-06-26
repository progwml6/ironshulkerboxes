package com.progwml6.ironshulkerbox.common.block;

import com.progwml6.ironshulkerbox.IronShulkerBoxes;
import com.progwml6.ironshulkerbox.common.block.tileentity.GenericIronShulkerBoxTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.material.PushReaction;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class GenericIronShulkerBlock extends Block {

  public static final EnumProperty<Direction> FACING = DirectionalBlock.FACING;
  public static final ResourceLocation CONTENTS = new ResourceLocation(IronShulkerBoxes.MOD_ID, "contents");
  private final IronShulkerBoxesTypes type;
  protected final DyeColor color;

  public GenericIronShulkerBlock(DyeColor color, Properties properties, IronShulkerBoxesTypes type) {
    super(properties);
    this.color = color;
    this.type = type;
    this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.UP));
  }

  @Override
  public BlockRenderType getRenderType(BlockState state) {
    return BlockRenderType.ENTITYBLOCK_ANIMATED;
  }

  @Override
  public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult p_225533_6_) {
    if (worldIn.isRemote) {
      return ActionResultType.SUCCESS;
    }
    else if (player.isSpectator()) {
      return ActionResultType.SUCCESS;
    }
    else {
      TileEntity tileentity = worldIn.getTileEntity(pos);

      if (tileentity instanceof GenericIronShulkerBoxTileEntity) {
        Direction direction = state.get(FACING);
        GenericIronShulkerBoxTileEntity genericIronShulkerBoxTileEntity = (GenericIronShulkerBoxTileEntity) tileentity;
        boolean flag;

        if (genericIronShulkerBoxTileEntity.getAnimationStatus() == GenericIronShulkerBoxTileEntity.AnimationStatus.CLOSED) {
          AxisAlignedBB axisalignedbb = VoxelShapes.fullCube().getBoundingBox().expand((double) (0.5F * (float) direction.getXOffset()), (double) (0.5F * (float) direction.getYOffset()), (double) (0.5F * (float) direction.getZOffset())).contract((double) direction.getXOffset(), (double) direction.getYOffset(), (double) direction.getZOffset());
          flag = worldIn.hasNoCollisions(axisalignedbb.offset(pos.offset(direction)));
        }
        else {
          flag = true;
        }

        if (flag) {
          player.openContainer(genericIronShulkerBoxTileEntity);
          player.addStat(Stats.OPEN_SHULKER_BOX);
        }

        return ActionResultType.SUCCESS;
      }
      else {
        return ActionResultType.PASS;
      }
    }
  }

  @Override
  public BlockState getStateForPlacement(BlockItemUseContext context) {
    return this.getDefaultState().with(FACING, context.getFace());
  }

  @Override
  protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
    builder.add(FACING);
  }

  @Override
  public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
    TileEntity tileentity = worldIn.getTileEntity(pos);

    if (tileentity instanceof GenericIronShulkerBoxTileEntity) {
      GenericIronShulkerBoxTileEntity genericIronShulkerBoxTileEntity = (GenericIronShulkerBoxTileEntity) tileentity;

      if (!worldIn.isRemote && player.isCreative() && !genericIronShulkerBoxTileEntity.isEmpty()) {
        ItemStack itemstack = getColoredItemStack(this.getColor(), this.getType());
        CompoundNBT compoundnbt = genericIronShulkerBoxTileEntity.saveToNbt(new CompoundNBT());

        if (!compoundnbt.isEmpty()) {
          itemstack.setTagInfo("BlockEntityTag", compoundnbt);
        }

        if (genericIronShulkerBoxTileEntity.hasCustomName()) {
          itemstack.setDisplayName(genericIronShulkerBoxTileEntity.getCustomName());
        }

        ItemEntity itementity = new ItemEntity(worldIn, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), itemstack);
        itementity.setDefaultPickupDelay();
        worldIn.addEntity(itementity);
      }
      else {
        genericIronShulkerBoxTileEntity.fillWithLoot(player);
      }
    }

    super.onBlockHarvested(worldIn, pos, state, player);
  }

  @Override
  public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
    TileEntity tileentity = builder.get(LootParameters.BLOCK_ENTITY);
    if (tileentity instanceof GenericIronShulkerBoxTileEntity) {
      GenericIronShulkerBoxTileEntity genericIronShulkerBoxTileEntity = (GenericIronShulkerBoxTileEntity) tileentity;
      builder = builder.withDynamicDrop(CONTENTS, (p_220168_1_, p_220168_2_) -> {
        for (int i = 0; i < genericIronShulkerBoxTileEntity.getSizeInventory(); ++i) {
          p_220168_2_.accept(genericIronShulkerBoxTileEntity.getStackInSlot(i));
        }
      });
    }

    return super.getDrops(state, builder);
  }


  @Override
  public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
    if (stack.hasDisplayName()) {
      TileEntity tileentity = worldIn.getTileEntity(pos);

      if (tileentity instanceof GenericIronShulkerBoxTileEntity) {
        ((GenericIronShulkerBoxTileEntity) tileentity).setCustomName(stack.getDisplayName());
      }
    }
  }

  @Override
  public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
    if (state.getBlock() != newState.getBlock()) {
      TileEntity tileentity = worldIn.getTileEntity(pos);

      if (tileentity instanceof GenericIronShulkerBoxTileEntity) {
        worldIn.updateComparatorOutputLevel(pos, state.getBlock());
      }

      super.onReplaced(state, worldIn, pos, newState, isMoving);
    }
  }

  @OnlyIn(Dist.CLIENT)
  @Override
  public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
    super.addInformation(stack, worldIn, tooltip, flagIn);
    CompoundNBT compoundnbt = stack.getChildTag("BlockEntityTag");

    if (compoundnbt != null) {
      if (compoundnbt.contains("LootTable", 8)) {
        tooltip.add(new StringTextComponent("???????"));
      }

      if (compoundnbt.contains("Items", 9)) {
        NonNullList<ItemStack> nonnulllist = NonNullList.withSize(27, ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compoundnbt, nonnulllist);
        int i = 0;
        int j = 0;

        for (ItemStack itemstack : nonnulllist) {
          if (!itemstack.isEmpty()) {
            ++j;
            if (i <= 4) {
              ++i;
              IFormattableTextComponent itextcomponent = itemstack.getDisplayName().func_230532_e_();
              itextcomponent.func_240702_b_(" x").func_240702_b_(String.valueOf(itemstack.getCount()));
              tooltip.add(itextcomponent);
            }
          }
        }

        if (j - i > 0) {
          tooltip.add((new TranslationTextComponent("container.shulkerBox.more", j - i)).func_240699_a_(TextFormatting.ITALIC));
        }
      }
    }

  }

  @Override
  public PushReaction getPushReaction(BlockState state) {
    return PushReaction.DESTROY;
  }

  @Override
  public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
    TileEntity tileentity = worldIn.getTileEntity(pos);
    return tileentity instanceof GenericIronShulkerBoxTileEntity ? VoxelShapes.create(((GenericIronShulkerBoxTileEntity) tileentity).getBoundingBox(state)) : VoxelShapes.fullCube();
  }

  @Override
  public boolean hasComparatorInputOverride(BlockState state) {
    return true;
  }

  @Override
  public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
    return Container.calcRedstoneFromInventory((IInventory) worldIn.getTileEntity(pos));
  }

  @Override
  public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
    ItemStack itemstack = super.getItem(worldIn, pos, state);
    GenericIronShulkerBoxTileEntity genericIronShulkerBoxTileEntity = (GenericIronShulkerBoxTileEntity) worldIn.getTileEntity(pos);
    CompoundNBT compoundnbt = genericIronShulkerBoxTileEntity.saveToNbt(new CompoundNBT());
    if (!compoundnbt.isEmpty()) {
      itemstack.setTagInfo("BlockEntityTag", compoundnbt);
    }

    return itemstack;
  }

  public static IronShulkerBoxesTypes getTypeFromItem(Item itemIn) {
    return getTypeFromBlock(Block.getBlockFromItem(itemIn));
  }

  public static IronShulkerBoxesTypes getTypeFromBlock(Block blockIn) {
    return blockIn instanceof GenericIronShulkerBlock ? ((GenericIronShulkerBlock) blockIn).getType() : null;
  }

  public IronShulkerBoxesTypes getType() {
    return this.type;
  }

  @Nullable
  @OnlyIn(Dist.CLIENT)
  public static DyeColor getColorFromItem(Item itemIn) {
    return getColorFromBlock(Block.getBlockFromItem(itemIn));
  }

  @Nullable
  @OnlyIn(Dist.CLIENT)
  public static DyeColor getColorFromBlock(Block blockIn) {
    return blockIn instanceof GenericIronShulkerBlock ? ((GenericIronShulkerBlock) blockIn).getColor() : null;
  }

  public static Block getBlockByColor(DyeColor colorIn, IronShulkerBoxesTypes typeIn) {
    switch (typeIn) {
      case IRON:
        return ShulkerBoxesBlocks.IRON_SHULKER_BOXES.get(colorIn.getId()).get();
      case GOLD:
        return ShulkerBoxesBlocks.GOLD_SHULKER_BOXES.get(colorIn.getId()).get();
      case DIAMOND:
        return ShulkerBoxesBlocks.DIAMOND_SHULKER_BOXES.get(colorIn.getId()).get();
      case COPPER:
        return ShulkerBoxesBlocks.COPPER_SHULKER_BOXES.get(colorIn.getId()).get();
      case SILVER:
        return ShulkerBoxesBlocks.SILVER_SHULKER_BOXES.get(colorIn.getId()).get();
      case CRYSTAL:
        return ShulkerBoxesBlocks.CRYSTAL_SHULKER_BOXES.get(colorIn.getId()).get();
      case OBSIDIAN:
        return ShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOXES.get(colorIn.getId()).get();
      default:
        return ShulkerBoxesBlocks.BLACK_IRON_SHULKER_BOX.get();
    }
  }

  @Nullable
  public DyeColor getColor() {
    return this.color;
  }

  public static ItemStack getColoredItemStack(DyeColor colorIn, IronShulkerBoxesTypes typeIn) {
    return new ItemStack(getBlockByColor(colorIn, typeIn));
  }

  @Override
  public BlockState rotate(BlockState state, Rotation rot) {
    return state.with(FACING, rot.rotate(state.get(FACING)));
  }

  @Override
  public BlockState mirror(BlockState state, Mirror mirrorIn) {
    return state.rotate(mirrorIn.toRotation(state.get(FACING)));
  }

  @Override
  public boolean eventReceived(BlockState state, World worldIn, BlockPos pos, int id, int param) {
    super.eventReceived(state, worldIn, pos, id, param);
    TileEntity tileentity = worldIn.getTileEntity(pos);
    return tileentity == null ? false : tileentity.receiveClientEvent(id, param);
  }

  @Override
  @Nullable
  public INamedContainerProvider getContainer(BlockState state, World world, BlockPos pos) {
    TileEntity tileentity = world.getTileEntity(pos);
    return tileentity instanceof INamedContainerProvider ? (INamedContainerProvider) tileentity : null;
  }

  @Override
  public boolean hasTileEntity(BlockState state) {
    return true;
  }
}
