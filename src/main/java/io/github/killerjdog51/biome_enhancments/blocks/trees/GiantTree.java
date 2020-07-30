package io.github.killerjdog51.biome_enhancments.blocks.trees;

import java.util.Random;
import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public abstract class GiantTree extends Tree {
   public boolean spawn(IWorld worldIn, BlockPos pos, BlockState blockUnder, Random random) {
	   BlockPos blockpos = findEdge(worldIn, pos);
      for(int i = 0; i >= -3; --i) {
         for(int j = 0; j >= -3; --j) {
            if (canBigTreeSpawnAt(blockUnder, worldIn, blockpos, i, j)) {
               return this.spawnBigTree(worldIn, blockpos, blockUnder, random, i, j);
            }
         }
      }

      return super.spawn(worldIn, blockpos, blockUnder, random);
   }

   @Nullable
   protected abstract AbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random);

   public boolean spawnBigTree(IWorld worldIn, BlockPos pos, BlockState blockUnder, Random random, int xOffset, int zOffset) {
      AbstractTreeFeature<NoFeatureConfig> abstracttreefeature = this.getBigTreeFeature(random);
      if (abstracttreefeature == null) {
         return false;
      } else {
         BlockState blockstate = Blocks.AIR.getDefaultState();
         worldIn.setBlockState(pos.add(xOffset, 0, zOffset), blockstate, 4);
         worldIn.setBlockState(pos.add(xOffset, 0, zOffset + 1), blockstate, 4);
         worldIn.setBlockState(pos.add(xOffset, 0, zOffset + 2), blockstate, 4);
         worldIn.setBlockState(pos.add(xOffset, 0, zOffset + 3), blockstate, 4);

         worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset), blockstate, 4);
         worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset + 1), blockstate, 4);
         worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset + 2), blockstate, 4);
         worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset + 3), blockstate, 4);

         worldIn.setBlockState(pos.add(xOffset + 2, 0, zOffset), blockstate, 4);
         worldIn.setBlockState(pos.add(xOffset + 2, 0, zOffset + 1), blockstate, 4);
         worldIn.setBlockState(pos.add(xOffset + 2, 0, zOffset + 2), blockstate, 4);
         worldIn.setBlockState(pos.add(xOffset + 2, 0, zOffset + 3), blockstate, 4);

         worldIn.setBlockState(pos.add(xOffset + 3, 0, zOffset), blockstate, 4);
         worldIn.setBlockState(pos.add(xOffset + 3, 0, zOffset + 1), blockstate, 4);
         worldIn.setBlockState(pos.add(xOffset + 3, 0, zOffset + 2), blockstate, 4);
         worldIn.setBlockState(pos.add(xOffset + 3, 0, zOffset + 3), blockstate, 4);

         if (abstracttreefeature.place(worldIn, worldIn.getChunkProvider().getChunkGenerator(), random, pos.add(xOffset, 0, zOffset), IFeatureConfig.NO_FEATURE_CONFIG)) {
            return true;
         } else {
        	 worldIn.setBlockState(pos.add(xOffset, 0, zOffset), blockUnder, 4);
             worldIn.setBlockState(pos.add(xOffset, 0, zOffset + 1), blockUnder, 4);
             worldIn.setBlockState(pos.add(xOffset, 0, zOffset + 2), blockUnder, 4);
             worldIn.setBlockState(pos.add(xOffset, 0, zOffset + 3), blockUnder, 4);

             worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset), blockUnder, 4);
             worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset + 1), blockUnder, 4);
             worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset + 2), blockUnder, 4);
             worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset + 3), blockUnder, 4);

             worldIn.setBlockState(pos.add(xOffset + 2, 0, zOffset), blockUnder, 4);
             worldIn.setBlockState(pos.add(xOffset + 2, 0, zOffset + 1), blockUnder, 4);
             worldIn.setBlockState(pos.add(xOffset + 2, 0, zOffset + 2), blockUnder, 4);
             worldIn.setBlockState(pos.add(xOffset + 2, 0, zOffset + 3), blockUnder, 4);

             worldIn.setBlockState(pos.add(xOffset + 3, 0, zOffset), blockUnder, 4);
             worldIn.setBlockState(pos.add(xOffset + 3, 0, zOffset + 1), blockUnder, 4);
             worldIn.setBlockState(pos.add(xOffset + 3, 0, zOffset + 2), blockUnder, 4);
             worldIn.setBlockState(pos.add(xOffset + 3, 0, zOffset + 3), blockUnder, 4);
            return true;
         }
      }
   }

   public static boolean canBigTreeSpawnAt(BlockState blockUnder, IBlockReader worldIn, BlockPos pos, int xOffset, int zOffset) {
      Block block = blockUnder.getBlock();
      return isTypeAt(worldIn, pos.add(xOffset, 0, zOffset), block) && isTypeAt(worldIn, pos.add(xOffset + 1, 0, zOffset), block) && isTypeAt(worldIn, pos.add(xOffset + 2, 0, zOffset), block) && isTypeAt(worldIn, pos.add(xOffset + 3, 0, zOffset), block)
      		&& isTypeAt(worldIn, pos.add(xOffset, 0, zOffset + 1), block) && isTypeAt(worldIn, pos.add(xOffset + 1, 0, zOffset + 1), block) && isTypeAt(worldIn, pos.add(xOffset + 2, 0, zOffset + 1), block) && isTypeAt(worldIn, pos.add(xOffset + 3, 0, zOffset + 1), block)
      		&& isTypeAt(worldIn, pos.add(xOffset, 0, zOffset + 2), block) && isTypeAt(worldIn, pos.add(xOffset + 1, 0, zOffset + 2), block) && isTypeAt(worldIn, pos.add(xOffset + 2, 0, zOffset + 2), block) && isTypeAt(worldIn, pos.add(xOffset + 3, 0, zOffset + 2), block)
      		&& isTypeAt(worldIn, pos.add(xOffset, 0, zOffset + 3), block) && isTypeAt(worldIn, pos.add(xOffset + 1, 0, zOffset + 3), block) && isTypeAt(worldIn, pos.add(xOffset + 2, 0, zOffset + 3), block) && isTypeAt(worldIn, pos.add(xOffset + 3, 0, zOffset + 3), block);
      
      }
   
   public static boolean isTypeAt(IBlockReader worldIn, BlockPos pos, Block block)
   {
       return block == worldIn.getBlockState(pos).getBlock();
   }
   
   private BlockPos findEdge(IWorld worldIn, BlockPos position)
	{
		BlockPos pos = position;
		int X = 0;
		int Z = 0;
		
		if (worldIn.getBlockState(pos.north()).isIn(BlockTags.SAPLINGS))
		{
			while (worldIn.getBlockState(pos.north()).isIn(BlockTags.SAPLINGS))
			{
				if(Z >= 3)
				{
					break;
				}
				pos = pos.north();
				Z++;
			} 
		}
		
		if (worldIn.getBlockState(pos.west()).isIn(BlockTags.SAPLINGS))
		{
			while (worldIn.getBlockState(pos.west()).isIn(BlockTags.SAPLINGS)) 
			{
				if(X >= 3)
				{
					break;
				}
				pos = pos.west();
				X++;
			} 
		}
		
		return pos;
	}
}