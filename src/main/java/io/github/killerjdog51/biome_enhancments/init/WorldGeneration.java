package io.github.killerjdog51.biome_enhancments.init;

import java.util.Iterator;

import io.github.killerjdog51.biome_enhancments.world.biome.OasisBiome;
import io.github.killerjdog51.biome_enhancments.world.gen.feature.WorldFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;


public class WorldGeneration {

	public static Biome OASIS = new OasisBiome();
	
	public static void registerBiome(Biome biome, int weight, BiomeType type, Type... types)
	{
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}
	
	public static void init()
	{
		Iterator<ConfiguredFeature<?>> it = Biomes.SWAMP.getFeatures(Decoration.VEGETAL_DECORATION).iterator();
		while(it.hasNext()) {
			ConfiguredFeature<?> feature = it.next();
			if(feature.config instanceof DecoratedFeatureConfig) {
				DecoratedFeatureConfig dfconfig = (DecoratedFeatureConfig)feature.config;
				if(dfconfig.feature.config instanceof IFeatureConfig) {
					Feature featureconfig = dfconfig.feature.feature;
					if(featureconfig == Feature.SWAMP_TREE)
					{
						it.remove();
						break;
					}
				}
			}
		}
		
		it = Biomes.SWAMP_HILLS.getFeatures(Decoration.VEGETAL_DECORATION).iterator();
		while(it.hasNext()) {
			ConfiguredFeature<?> feature = it.next();
			if(feature.config instanceof DecoratedFeatureConfig) {
				DecoratedFeatureConfig dfconfig = (DecoratedFeatureConfig)feature.config;
				if(dfconfig.feature.config instanceof IFeatureConfig) {
					Feature featureconfig = dfconfig.feature.feature;
					if(featureconfig == Feature.SWAMP_TREE)
					{
						it.remove();
						break;
					}
				}
			}
		}
			
		Biomes.SWAMP.addFeature(
		                Decoration.VEGETAL_DECORATION,
		                Biome.createDecoratedFeature(
		                        WorldFeatures.MANGROVE_TREE,
		                        IFeatureConfig.NO_FEATURE_CONFIG,
		                        Placement.COUNT_EXTRA_HEIGHTMAP,
		                        new AtSurfaceWithExtraConfig(2, 0.1F, 1))
		        );
		
		Biomes.SWAMP_HILLS.addFeature(
                Decoration.VEGETAL_DECORATION,
                Biome.createDecoratedFeature(
                        WorldFeatures.MANGROVE_TREE,
                        IFeatureConfig.NO_FEATURE_CONFIG,
                        Placement.COUNT_EXTRA_HEIGHTMAP,
                        new AtSurfaceWithExtraConfig(2, 0.1F, 1))
        );
		
		Biomes.SAVANNA.addFeature(
		                Decoration.VEGETAL_DECORATION,
		                Biome.createDecoratedFeature(
		                        WorldFeatures.BAOBAB_TREE,
		                        IFeatureConfig.NO_FEATURE_CONFIG,
		                        Placement.COUNT_EXTRA_HEIGHTMAP,
		                        new AtSurfaceWithExtraConfig(0, 0.05F, 1))
		        );
		
		
		Biomes.BEACH.addFeature(
                Decoration.VEGETAL_DECORATION,
                Biome.createDecoratedFeature(
                        WorldFeatures.PALM_TREE,
                        IFeatureConfig.NO_FEATURE_CONFIG,
                        Placement.COUNT_EXTRA_HEIGHTMAP,
                        new AtSurfaceWithExtraConfig(0, 0.06F, 1))
        );
			
		//Biomes.DESERT.addStructure(WorldFeatures.OASIS, IFeatureConfig.NO_FEATURE_CONFIG);
		
		
		Biomes.DESERT.addFeature(
                Decoration.LOCAL_MODIFICATIONS,
                Biome.createDecoratedFeature(
                        WorldFeatures.OASIS,
                        IFeatureConfig.NO_FEATURE_CONFIG,
                        Placement.COUNT_EXTRA_HEIGHTMAP,
                        new AtSurfaceWithExtraConfig(0, 0.1F, 1))
        );
		
		
	}
}
