package io.github.killerjdog51.biome_enhancments.blocks.trees;

import java.util.Random;
import javax.annotation.Nullable;

import io.github.killerjdog51.biome_enhancments.world.gen.feature.PalmTreeFeature;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class PalmTree extends Tree {
   @Nullable
   protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
      return new PalmTreeFeature(NoFeatureConfig::deserialize);
   }
}