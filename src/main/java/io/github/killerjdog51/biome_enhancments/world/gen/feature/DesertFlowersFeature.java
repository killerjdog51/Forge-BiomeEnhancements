package io.github.killerjdog51.biome_enhancments.world.gen.feature;

import com.mojang.datafixers.Dynamic;

import io.github.killerjdog51.biome_enhancments.init.ModBlocks;

import java.util.Random;
import java.util.function.Function;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class DesertFlowersFeature extends FlowersFeature {
   public DesertFlowersFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
      super(config);
   }

   public BlockState getRandomFlower(Random random, BlockPos pos) {
      return ModBlocks.DESERT_CANDLE.getDefaultState();
   }
}