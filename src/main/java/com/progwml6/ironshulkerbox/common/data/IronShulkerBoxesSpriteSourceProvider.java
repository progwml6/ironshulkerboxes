package com.progwml6.ironshulkerbox.common.data;

import com.progwml6.ironshulkerbox.IronShulkerBoxes;
import net.minecraft.client.renderer.texture.atlas.sources.DirectoryLister;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SpriteSourceProvider;

public class IronShulkerBoxesSpriteSourceProvider extends SpriteSourceProvider {

  public IronShulkerBoxesSpriteSourceProvider(PackOutput output, ExistingFileHelper fileHelper) {
    super(output, fileHelper, IronShulkerBoxes.MOD_ID);
  }

  @Override
  protected void addSources() {
    atlas(SHULKER_BOXES_ATLAS).addSource(new DirectoryLister("model", "model/"));
  }
}
