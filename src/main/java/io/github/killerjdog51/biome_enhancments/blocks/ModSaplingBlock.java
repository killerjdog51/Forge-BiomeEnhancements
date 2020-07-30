package io.github.killerjdog51.biome_enhancments.blocks;

import io.github.killerjdog51.biome_enhancments.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class ModSaplingBlock extends SaplingBlock {

	public ModSaplingBlock(Tree p_i48337_1_, Properties properties) {
		super(p_i48337_1_, properties);
	}

	@Override
	 protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
	      Block block = state.getBlock();
	      if (this.getBlock() == ModBlocks.PALM_SAPLING)
	      {
		      return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.FARMLAND || state.isIn(BlockTags.SAND);
	      }
	      return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.FARMLAND;
	   }
}
