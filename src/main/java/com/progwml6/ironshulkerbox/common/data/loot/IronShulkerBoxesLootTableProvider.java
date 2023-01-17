package com.progwml6.ironshulkerbox.common.data.loot;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class IronShulkerBoxesLootTableProvider extends LootTableProvider {

  public IronShulkerBoxesLootTableProvider(PackOutput pOutput) {
    super(pOutput, Set.of(), List.of(new LootTableProvider.SubProviderEntry(IronShulkerBoxesBlockLoot::new, LootContextParamSets.BLOCK)));
  }
}
