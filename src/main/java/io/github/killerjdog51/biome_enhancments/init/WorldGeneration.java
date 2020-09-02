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


public class WorldGeneration {

	// Register our biome to exist
	public static Biome OASIS = new OasisBiome();
	
	// Since Forge has it's own registry thing, we need to add our Biome to the Biome Dictionary/Manager
	public static void registerBiome(Biome biome, Type... types)
	{
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}
	
	public static void init()
	{
		// Uses reflection to remove Minecraft swamp trees from Swamp generation
		// This works in Forge because we're looking for the class/instance instead of a field (Classes/instances can not be obfuscated)
		// Gets all vegetation features for the Swamp biome
		Iterator<ConfiguredFeature<?>> it = Biomes.SWAMP.getFeatures(Decoration.VEGETAL_DECORATION).iterator();
		
		// Iterates through each feature
		while(it.hasNext())
		{
			ConfiguredFeature<?> feature = it.next();
			
			// Checks if the feature is the swamp tree
			if(feature.config instanceof DecoratedFeatureConfig)
			{
				DecoratedFeatureConfig dfconfig = (DecoratedFeatureConfig)feature.config;
				if(dfconfig.feature.config instanceof IFeatureConfig)
				{
					Feature<?> featureconfig = dfconfig.feature.feature;
					if(featureconfig == Feature.SWAMP_TREE)
					{
						it.remove();
						break;
					}
				}
			}
		}
		
		// Uses reflection to remove Minecraft swamp trees from Swamp hills generation
		// Gets all vegatation features for the swamp biome
		it = Biomes.SWAMP_HILLS.getFeatures(Decoration.VEGETAL_DECORATION).iterator();
		
		// Iterates through each feature
		while(it.hasNext())
		{
			ConfiguredFeature<?> feature = it.next();
			
			// Checks if the feature is the swamp tree
			if(feature.config instanceof DecoratedFeatureConfig)
			{
				DecoratedFeatureConfig dfconfig = (DecoratedFeatureConfig)feature.config;
				if(dfconfig.feature.config instanceof IFeatureConfig)
				{
					Feature<?> featureconfig = dfconfig.feature.feature;
					if(featureconfig == Feature.SWAMP_TREE)
					{
						it.remove();
						break;
					}
				}
			}
		}
			
		// Adds mangrove trees to the Swamp
		Biomes.SWAMP.addFeature(
		                Decoration.VEGETAL_DECORATION,
		                Biome.createDecoratedFeature(
		                        WorldFeatures.MANGROVE_TREE,
		                        IFeatureConfig.NO_FEATURE_CONFIG,
		                        Placement.COUNT_EXTRA_HEIGHTMAP,
		                        new AtSurfaceWithExtraConfig(2, 0.1F, 1))
		        );
		
		// Adds mangrove trees to the Swamp Hills
		Biomes.SWAMP_HILLS.addFeature(
                Decoration.VEGETAL_DECORATION,
                Biome.createDecoratedFeature(
                        WorldFeatures.MANGROVE_TREE,
                        IFeatureConfig.NO_FEATURE_CONFIG,
                        Placement.COUNT_EXTRA_HEIGHTMAP,
                        new AtSurfaceWithExtraConfig(2, 0.1F, 1))
        );
		
		// Adds baobab trees to the Savanna
		Biomes.SAVANNA.addFeature(
		                Decoration.VEGETAL_DECORATION,
		                Biome.createDecoratedFeature(
		                        WorldFeatures.BAOBAB_TREE,
		                        IFeatureConfig.NO_FEATURE_CONFIG,
		                        Placement.COUNT_EXTRA_HEIGHTMAP,
		                        new AtSurfaceWithExtraConfig(0, 0.05F, 1))
		        );
		
		
		// Adds palm trees to beaches
		Biomes.BEACH.addFeature(
                Decoration.VEGETAL_DECORATION,
                Biome.createDecoratedFeature(
                        WorldFeatures.PALM_TREE,
                        IFeatureConfig.NO_FEATURE_CONFIG,
                        Placement.COUNT_EXTRA_HEIGHTMAP,
                        new AtSurfaceWithExtraConfig(0, 0.06F, 1))
        );
					
		// Adds oasis to the desert
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
