package com.progwml6.ironshulkerbox.common.items;

import com.progwml6.ironshulkerbox.common.Util;
import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;

import static com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes.*;

public enum IronShulkerBoxesUpgradeType {
  IRON_TO_GOLD(IRON, GOLD),
  GOLD_TO_DIAMOND(GOLD, DIAMOND),
  COPPER_TO_SILVER(COPPER, SILVER),
  SILVER_TO_GOLD(SILVER, GOLD),
  COPPER_TO_IRON(COPPER, IRON),
  DIAMOND_TO_CRYSTAL(DIAMOND, CRYSTAL),
  VANILLA_TO_IRON(VANILLA, IRON),
  VANILLA_TO_COPPER(VANILLA, COPPER),
  DIAMOND_TO_OBSIDIAN(DIAMOND, OBSIDIAN);

  public final String name;
  public final IronShulkerBoxesTypes source;
  public final IronShulkerBoxesTypes target;

  IronShulkerBoxesUpgradeType(IronShulkerBoxesTypes source, IronShulkerBoxesTypes target) {
    this.name = Util.toEnglishName(this.name());
    this.source = source;
    this.target = target;
  }

  public boolean canUpgrade(IronShulkerBoxesTypes from) {
    return from == this.source;
  }
}
