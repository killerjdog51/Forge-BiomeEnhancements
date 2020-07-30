package io.github.killerjdog51.biome_enhancments.blocks.trees;

import java.util.Random;
import javax.annotation.Nullable;

import io.github.killerjdog51.biome_enhancments.world.gen.feature.BaobabTreeFeature;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class BaobabTree extends GiantTree {
   @Nullable
   protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
      return null;
   }

   @Nullable
   protected AbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
      return new BaobabTreeFeature(NoFeatureConfig::deserialize);
   }
}