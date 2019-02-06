package com.progwml6.ironshulkerbox.common.items;

import com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType;
import com.progwml6.ironshulkerbox.common.util.ItemNames;
import net.minecraft.util.ResourceLocation;

import static com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType.COPPER;
import static com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType.CRYSTAL;
import static com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType.DIAMOND;
import static com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType.GOLD;
import static com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType.IRON;
import static com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType.OBSIDIAN;
import static com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType.SILVER;
import static com.progwml6.ironshulkerbox.common.blocks.IronShulkerBoxType.VANILLA;

public enum ShulkerBoxChangerType
{
    //@formatter:off
    IRON_GOLD(IRON, GOLD, ItemNames.IRON_GOLD_UPGRADE),
    GOLD_DIAMOND(GOLD, DIAMOND, ItemNames.GOLD_DIAMOND_UPGRADE),
    COPPER_SILVER(COPPER, SILVER, ItemNames.COPPER_SILVER_UPGRADE),
    SILVER_GOLD(SILVER, GOLD, ItemNames.SILVER_GOLD_UPGRADE),
    COPPER_IRON(COPPER, IRON, ItemNames.COPPER_IRON_UPGRADE),
    DIAMOND_CRYSTAL(DIAMOND, CRYSTAL, ItemNames.DIAMOND_CRYSTAL_UPGRADE),
    VANILLA_IRON(VANILLA, IRON, ItemNames.VANILLA_IRON_UPGRADE),
    VANILLA_COPPER(VANILLA, COPPER, ItemNames.VANILLA_COPPER_UPGRADE),
    DIAMOND_OBSIDIAN(DIAMOND, OBSIDIAN, ItemNames.DIAMOND_OBSIDIAN_UPGRADE);
    //@formatter:on

    public final IronShulkerBoxType source;

    public final IronShulkerBoxType target;

    public final ResourceLocation itemName;

    ShulkerBoxChangerType(IronShulkerBoxType source, IronShulkerBoxType target, String itemName)
    {
        this.source = source;
        this.target = target;
        this.itemName = new ResourceLocation(itemName);
    }

    public boolean canUpgrade(IronShulkerBoxType from)
    {
        return from == this.source;
    }
}
