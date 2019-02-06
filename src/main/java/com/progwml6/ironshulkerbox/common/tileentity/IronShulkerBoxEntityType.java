package com.progwml6.ironshulkerbox.common.tileentity;

import com.mojang.datafixers.DataFixUtils;
import com.mojang.datafixers.types.Type;
import com.progwml6.ironshulkerbox.IronShulkerBox;
import com.progwml6.ironshulkerbox.common.util.TileEntityNames;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.datafix.DataFixesManager;
import net.minecraft.util.datafix.TypeReferences;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;

public class IronShulkerBoxEntityType
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

    public IronShulkerBoxEntityType()
    {

    }

    @Mod.EventBusSubscriber(modid = IronShulkerBox.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration
    {
        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> e)
        {
            registerTileEntityType(e.getRegistry(), register("iron_shulker_box", TileEntityType.Builder.create(TileEntityIronShulkerBox::new)),
                    TileEntityNames.IRON_SHULKER_BOX);
            registerTileEntityType(e.getRegistry(), register("gold_shulker_box", TileEntityType.Builder.create(TileEntityGoldShulkerBox::new)),
                    TileEntityNames.GOLD_SHULKER_BOX);
            registerTileEntityType(e.getRegistry(), register("diamond_shulker_box", TileEntityType.Builder.create(TileEntityDiamondShulkerBox::new)),
                    TileEntityNames.DIAMOND_SHULKER_BOX);
            registerTileEntityType(e.getRegistry(), register("crystal_shulker_box", TileEntityType.Builder.create(TileEntityCrystalShulkerBox::new)),
                    TileEntityNames.CRYSTAL_SHULKER_BOX);
            registerTileEntityType(e.getRegistry(), register("copper_shulker_box", TileEntityType.Builder.create(TileEntityCopperShulkerBox::new)),
                    TileEntityNames.COPPER_SHULKER_BOX);
            registerTileEntityType(e.getRegistry(), register("silver_shulker_box", TileEntityType.Builder.create(TileEntitySilverShulkerBox::new)),
                    TileEntityNames.SILVER_SHULKER_BOX);
            registerTileEntityType(e.getRegistry(), register("obsidian_shulker_box", TileEntityType.Builder.create(TileEntityObsidianShulkerBox::new)),
                    TileEntityNames.OBSIDIAN_SHULKER_BOX);
        }
    }

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
            type = DataFixesManager.getDataFixer().getSchema(DataFixUtils.makeKey(1519)).getChoiceType(TypeReferences.BLOCK_ENTITY, id);
        }
        catch (IllegalArgumentException illegalstateexception)
        {
            if (SharedConstants.developmentMode)
            {
                throw illegalstateexception;
            }
        }

        TileEntityType<T> tileEntityType = builder.build(type);
        return tileEntityType;
    }
}
