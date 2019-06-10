package com.progwml6.ironshulkerbox.common.items;

import com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxType;
import com.progwml6.ironshulkerbox.common.util.ItemNames;
import net.minecraft.util.ResourceLocation;

import static com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxType.COPPER;
import static com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxType.CRYSTAL;
import static com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxType.DIAMOND;
import static com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxType.GOLD;
import static com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxType.IRON;
import static com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxType.OBSIDIAN;
import static com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxType.SILVER;
import static com.progwml6.ironshulkerbox.common.blocks.ShulkerBoxType.VANILLA;

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

    public final ShulkerBoxType source;

    public final ShulkerBoxType target;

    public final ResourceLocation itemName;

    ShulkerBoxChangerType(ShulkerBoxType source, ShulkerBoxType target, String itemName)
    {
        this.source = source;
        this.target = target;
        this.itemName = new ResourceLocation(itemName);
    }

    public boolean canUpgrade(ShulkerBoxType from)
    {
        return from == this.source;
    }
}
