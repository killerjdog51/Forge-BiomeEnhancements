package io.github.killerjdog51.biome_enhancments.world.gen.feature.structure;

import io.github.killerjdog51.biome_enhancments.BiomeEnhancements;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class StructurePieceRegistry {

    //public static final IStructurePieceType OASIS_PIECE = register("oasis", OasisStructurePiece::new);

    private static IStructurePieceType register(String key, IStructurePieceType type) {
        return Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(BiomeEnhancements.MOD_ID, key), type);
    }

}
