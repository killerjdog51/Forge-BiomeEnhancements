package io.github.killerjdog51.biome_enhancments.blocks;

import io.github.killerjdog51.biome_enhancments.tileentity.ModSignTileEntity;
import net.minecraft.block.WallSignBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class ModWallSignBlock extends WallSignBlock {

	public ModWallSignBlock(Properties properties) {
		super(properties);
	}

	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
	      return new ModSignTileEntity();
	   }
}
