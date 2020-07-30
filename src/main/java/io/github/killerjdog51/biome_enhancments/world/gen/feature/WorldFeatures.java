package io.github.killerjdog51.biome_enhancments.world.gen.feature;

import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class WorldFeatures {

	public static Feature<NoFeatureConfig> BAOBAB_TREE = new BaobabTreeFeature(NoFeatureConfig::deserialize);
	public static AbstractTreeFeature<NoFeatureConfig> MANGROVE_TREE = new MangroveTreeFeature(NoFeatureConfig::deserialize);
	public static AbstractTreeFeature<NoFeatureConfig> PALM_TREE = new PalmTreeFeature(NoFeatureConfig::deserialize);
	public static Feature<NoFeatureConfig> OASIS = new OasisFeature(NoFeatureConfig::deserialize);
	public static FlowersFeature DESERT_FLOWER = new DesertFlowersFeature(NoFeatureConfig::deserialize);


}
