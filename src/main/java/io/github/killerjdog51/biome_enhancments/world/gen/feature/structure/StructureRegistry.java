package io.github.killerjdog51.biome_enhancments.world.gen.feature.structure;

import io.github.killerjdog51.biome_enhancments.BiomeEnhancements;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.structure.Structure;

public class StructureRegistry {

	
    //public static final Structure<?> OASIS = register("oasis", WorldFeatures.OASIS);

    
    private static Structure<?> register(String key, Structure<?> type) {
        return Registry.register(Registry.STRUCTURE_FEATURE, new ResourceLocation(BiomeEnhancements.MOD_ID, key), type);
    }

}
