package io.github.killerjdog51.biome_enhancments.init;

import io.github.killerjdog51.biome_enhancments.tileentity.ModSignTileEntity;
import net.minecraft.tileentity.TileEntityType;

public class ModTileEntityTypes {

	public static final TileEntityType<ModSignTileEntity> SIGN = TileEntityType.Builder.create(ModSignTileEntity::new , ModBlocks.BAOBAB_SIGN, ModBlocks.BAOBAB_WALL_SIGN, ModBlocks.MANGROVE_SIGN, ModBlocks.MANGROVE_WALL_SIGN, ModBlocks.PALM_SIGN, ModBlocks.PALM_WALL_SIGN).build(null);
}
