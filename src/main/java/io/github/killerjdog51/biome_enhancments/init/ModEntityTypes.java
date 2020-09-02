package io.github.killerjdog51.biome_enhancments.init;

import io.github.killerjdog51.biome_enhancments.BiomeEnhancements;
import io.github.killerjdog51.biome_enhancments.entity.boat.ModBoatEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;

public class ModEntityTypes {

	   public static final EntityType<ModBoatEntity> BOAT = EntityType.Builder.<ModBoatEntity>create(ModBoatEntity::new, EntityClassification.MISC).size(1.375F, 0.5625F).build(BiomeEnhancements.MOD_ID + ":boat");

}
