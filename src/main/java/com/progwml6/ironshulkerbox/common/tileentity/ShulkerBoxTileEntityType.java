package com.progwml6.ironshulkerbox.common.tileentity;

import com.progwml6.ironshulkerbox.IronShulkerBox;
import com.progwml6.ironshulkerbox.common.core.IronShulkerBoxBlocks;
import com.progwml6.ironshulkerbox.common.util.TileEntityNames;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;

public class ShulkerBoxTileEntityType
{
    @ObjectHolder(TileEntityNames.IRON_SHULKER_BOX)
    public static TileEntityType<?> IRON_SHULKER_BOX;

    @ObjectHolder(TileEntityNames.GOLD_SHULKER_BOX)
    public static TileEntityType<?> GOLD_SHULKER_BOX;

    @ObjectHolder(TileEntityNames.DIAMOND_SHULKER_BOX)
    public static TileEntityType<?> DIAMOND_SHULKER_BOX;

    @ObjectHolder(TileEntityNames.CRYSTAL_SHULKER_BOX)
    public static TileEntityType<?> CRYSTAL_SHULKER_BOX;

    @ObjectHolder(TileEntityNames.COPPER_SHULKER_BOX)
    public static TileEntityType<?> COPPER_SHULKER_BOX;

    @ObjectHolder(TileEntityNames.SILVER_SHULKER_BOX)
    public static TileEntityType<?> SILVER_SHULKER_BOX;

    @ObjectHolder(TileEntityNames.OBSIDIAN_SHULKER_BOX)
    public static TileEntityType<?> OBSIDIAN_SHULKER_BOX;

    public ShulkerBoxTileEntityType()
    {

    }

    @Mod.EventBusSubscriber(modid = IronShulkerBox.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration
    {
        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> e)
        {
            e.getRegistry().registerAll(
                    TileEntityType.Builder.create((Supplier<TileEntity>) IronShulkerBoxTileEntity::new, IronShulkerBoxBlocks.ironShulkerBoxes.toArray(new Block[0])).build(null).setRegistryName(TileEntityNames.IRON_SHULKER_BOX),
                    TileEntityType.Builder.create((Supplier<TileEntity>) GoldShulkerBoxTileEntity::new, IronShulkerBoxBlocks.goldShulkerBoxes.toArray(new Block[0])).build(null).setRegistryName(TileEntityNames.GOLD_SHULKER_BOX),
                    TileEntityType.Builder.create((Supplier<TileEntity>) DiamondShulkerBoxTileEntity::new, IronShulkerBoxBlocks.diamondShulkerBoxes.toArray(new Block[0])).build(null).setRegistryName(TileEntityNames.DIAMOND_SHULKER_BOX),
                    TileEntityType.Builder.create((Supplier<TileEntity>) CrystalShulkerBoxTileEntity::new, IronShulkerBoxBlocks.crystalShulkerBoxes.toArray(new Block[0])).build(null).setRegistryName(TileEntityNames.CRYSTAL_SHULKER_BOX),
                    TileEntityType.Builder.create((Supplier<TileEntity>) CopperShulkerBoxTileEntity::new, IronShulkerBoxBlocks.copperShulkerBoxes.toArray(new Block[0])).build(null).setRegistryName(TileEntityNames.COPPER_SHULKER_BOX),
                    TileEntityType.Builder.create((Supplier<TileEntity>) SilverShulkerBoxTileEntity::new, IronShulkerBoxBlocks.silverShulkerBoxes.toArray(new Block[0])).build(null).setRegistryName(TileEntityNames.SILVER_SHULKER_BOX),
                    TileEntityType.Builder.create((Supplier<TileEntity>) ObsidianShulkerBoxTileEntity::new, IronShulkerBoxBlocks.obsidianShulkerBoxes.toArray(new Block[0])).build(null).setRegistryName(TileEntityNames.OBSIDIAN_SHULKER_BOX)
            );

            /*registerTileEntityType(e.getRegistry(),
                    register("iron_shulker_box", TileEntityType.Builder.create(IronShulkerBoxTileEntity::new, IronShulkerBoxBlocks.ironShulkerBoxes.toArray(new Block[0]))),
                    TileEntityNames.IRON_SHULKER_BOX);
            registerTileEntityType(e.getRegistry(),
                    register("gold_shulker_box", TileEntityType.Builder.create(GoldShulkerBoxTileEntity::new, IronShulkerBoxBlocks.goldShulkerBoxes.toArray(new Block[0]))),
                    TileEntityNames.GOLD_SHULKER_BOX);
            registerTileEntityType(e.getRegistry(),
                    register("diamond_shulker_box", TileEntityType.Builder.create(DiamondShulkerBoxTileEntity::new, IronShulkerBoxBlocks.diamondShulkerBoxes.toArray(new Block[0]))),
                    TileEntityNames.DIAMOND_SHULKER_BOX);
            registerTileEntityType(e.getRegistry(),
                    register("crystal_shulker_box", TileEntityType.Builder.create(CrystalShulkerBoxTileEntity::new, IronShulkerBoxBlocks.crystalShulkerBoxes.toArray(new Block[0]))),
                    TileEntityNames.CRYSTAL_SHULKER_BOX);
            registerTileEntityType(e.getRegistry(),
                    register("copper_shulker_box", TileEntityType.Builder.create(CopperShulkerBoxTileEntity::new, IronShulkerBoxBlocks.copperShulkerBoxes.toArray(new Block[0]))),
                    TileEntityNames.COPPER_SHULKER_BOX);
            registerTileEntityType(e.getRegistry(),
                    register("silver_shulker_box", TileEntityType.Builder.create(SilverShulkerBoxTileEntity::new, IronShulkerBoxBlocks.silverShulkerBoxes.toArray(new Block[0]))),
                    TileEntityNames.SILVER_SHULKER_BOX);
            registerTileEntityType(e.getRegistry(),
                    register("obsidian_shulker_box", TileEntityType.Builder.create(ObsidianShulkerBoxTileEntity::new, IronShulkerBoxBlocks.obsidianShulkerBoxes.toArray(new Block[0]))),
                    TileEntityNames.OBSIDIAN_SHULKER_BOX);*/
        }
    }

    /*
    protected static <T extends TileEntityType<?>> T registerTileEntityType(IForgeRegistry<TileEntityType<?>> registry, T thing, String name)
    {
        register(registry, thing, new ResourceLocation(name));
        return thing;
    }

    protected static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T thing, ResourceLocation name)
    {
        thing.setRegistryName(name);
        registry.register(thing);
        return thing;
    }

    public static <T extends TileEntity> TileEntityType<T> register(String id, TileEntityType.Builder<T> builder)
    {
        Type<?> type = null;

        try
        {
            type = DataFixesManager.getDataFixer().getSchema(DataFixUtils.makeKey(SharedConstants.getVersion().getWorldVersion())).getChoiceType(TypeReferences.BLOCK_ENTITY, id);
        }
        catch (IllegalArgumentException illegalstateexception)
        {
            if (SharedConstants.developmentMode)
            {
                throw illegalstateexception;
            }

            LOGGER.warn("No data fixer registered for block entity {}", (Object) id);
        }

        return Registry.register(Registry.BLOCK_ENTITY_TYPE, id, builder.build(type));
    }*/
}
