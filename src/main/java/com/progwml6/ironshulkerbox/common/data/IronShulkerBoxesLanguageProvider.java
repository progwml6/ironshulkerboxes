package com.progwml6.ironshulkerbox.common.data;

import com.progwml6.ironshulkerbox.IronShulkerBoxes;
import com.progwml6.ironshulkerbox.common.block.IronShulkerBoxesTypes;
import com.progwml6.ironshulkerbox.common.item.IronShulkerBoxesUpgradeType;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesBlocks;
import com.progwml6.ironshulkerbox.common.registraton.IronShulkerBoxesItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.common.data.LanguageProvider;
import org.apache.commons.lang3.text.WordUtils;

public class IronShulkerBoxesLanguageProvider extends LanguageProvider {

  public IronShulkerBoxesLanguageProvider(PackOutput output, String locale) {
    super(output, IronShulkerBoxes.MOD_ID, locale);
  }

  @Override
  protected void addTranslations() {
    this.addShulkerBox(IronShulkerBoxesTypes.IRON);
    this.addShulkerBox(IronShulkerBoxesTypes.GOLD);
    this.addShulkerBox(IronShulkerBoxesTypes.DIAMOND);
    this.addShulkerBox(IronShulkerBoxesTypes.COPPER);
    this.addShulkerBox(IronShulkerBoxesTypes.CRYSTAL);
    this.addShulkerBox(IronShulkerBoxesTypes.OBSIDIAN);

    this.addBlock(IronShulkerBoxesBlocks.IRON_SHULKER_BOX, "Iron Shulker Box");
    this.addBlock(IronShulkerBoxesBlocks.GOLD_SHULKER_BOX, "Gold Shulker Box");
    this.addBlock(IronShulkerBoxesBlocks.DIAMOND_SHULKER_BOX, "Diamond Shulker Box");
    this.addBlock(IronShulkerBoxesBlocks.COPPER_SHULKER_BOX, "Copper Shulker Box");
    this.addBlock(IronShulkerBoxesBlocks.CRYSTAL_SHULKER_BOX, "Crystal Shulker Box");
    this.addBlock(IronShulkerBoxesBlocks.OBSIDIAN_SHULKER_BOX, "Obsidian Shulker Box");

    this.addItem(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.IRON_TO_GOLD), "Iron to Gold Shulker Box Upgrade");
    this.addItem(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.GOLD_TO_DIAMOND), "Gold to Diamond Shulker Box Upgrade");
    this.addItem(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.COPPER_TO_IRON), "Copper to Iron Shulker Box Upgrade");
    this.addItem(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.DIAMOND_TO_CRYSTAL), "Diamond to Crystal Shulker Box Upgrade");
    this.addItem(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.VANILLA_TO_IRON), "Vanilla to Iron Shulker Box Upgrade");
    this.addItem(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.VANILLA_TO_COPPER), "Vanilla to Copper Shulker Box Upgrade");
    this.addItem(IronShulkerBoxesItems.UPGRADES.get(IronShulkerBoxesUpgradeType.DIAMOND_TO_OBSIDIAN), "Diamond to Obsidian Shulker Box Upgrade");

    this.add("item.ironshulkerbox.shulker_box_upgrade.upgrade", "Used to upgrade a %s Shulker Box to a %s Shulker Box.");
    this.add("item.ironshulkerbox.shulker_box_upgrade.color", "The color of the Shulker Box will stay the same.");

    this.add("ironshulkerbox.iron", "Iron");
    this.add("ironshulkerbox.gold", "Gold");
    this.add("ironshulkerbox.diamond", "Diamond");
    this.add("ironshulkerbox.crystal", "Crystal");
    this.add("ironshulkerbox.copper", "Copper");
    this.add("ironshulkerbox.obsidian", "Obsidian");
    this.add("ironshulkerbox.vanilla", "Vanilla");

    this.add("itemGroup.ironshulkerbox", "Iron Shulker Boxes");
  }

  public void addShulkerBox(IronShulkerBoxesTypes type) {
    for (DyeColor color : DyeColor.values()) {
      this.add("block.ironshulkerbox." + type.getEnglishName().toLowerCase() + "_shulker_box_" + color.getName(), WordUtils.capitalize(color.getName().replace('_', ' ')) + " " + WordUtils.capitalize(type.getEnglishName().toLowerCase()) + " Shulker Box");
    }
  }
}
