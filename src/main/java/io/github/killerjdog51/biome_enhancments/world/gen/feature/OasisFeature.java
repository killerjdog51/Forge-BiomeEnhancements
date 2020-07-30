package io.github.killerjdog51.biome_enhancments.world.gen.feature;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import io.github.killerjdog51.biome_enhancments.blocks.ModSaplingBlock;
import io.github.killerjdog51.biome_enhancments.init.ModBlocks;
import io.github.killerjdog51.biome_enhancments.init.WorldGeneration;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.LightType;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class OasisFeature extends Feature<NoFeatureConfig> {

	public OasisFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn)
	{
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		
		int size = 1 + rand.nextInt(2);
		
		while(pos.getY() > 65 && worldIn.isAirBlock(pos))
		{
	         pos = pos.down();
	      }
		
		while(!(worldIn.getLightFor(LightType.SKY, pos) > 0))
		{
			pos = pos.up();
		}
		
	      if (pos.getY() <= 65)
	      {
	         return false;
	      } else {
	    	  
	    	  ChunkPos chunkpos = new ChunkPos(pos);
	          if (!worldIn.getChunk(chunkpos.x, chunkpos.z, ChunkStatus.STRUCTURE_REFERENCES).getStructureReferences(Feature.VILLAGE.getStructureName()).isEmpty()) {
	             return false;
	          }
	          
	          if (!worldIn.getChunk(chunkpos.x, chunkpos.z, ChunkStatus.STRUCTURE_REFERENCES).getStructureReferences(Feature.DESERT_PYRAMID.getStructureName()).isEmpty()) {
		             return false;
		          }
	          if (!worldIn.getChunk(chunkpos.x, chunkpos.z, ChunkStatus.STRUCTURE_REFERENCES).getStructureReferences(Feature.PILLAGER_OUTPOST.getStructureName()).isEmpty()) {
		             return false;
		          }
	          
	    	  for (int xPos = -(11*size); xPos <= (12*size); ++xPos)
		       {
		           for (int zPos = -(11*size); zPos <= (12*size); ++zPos)
		           {
		        	   for (int yPos = -(8*size); yPos <0; ++yPos)
		        	   {
			               if (xPos * xPos + zPos * zPos >= (11*(size*size)) && !worldIn.getBlockState(pos.add(xPos, yPos, zPos)).isSolid())
			               {
			                   return false;
			               }
		        	   }
		           }
		       }
	    	  
	        	 this.GenerateOasis(worldIn, generator, pos, size, rand);
	         
	            System.out.println("Oasis spawn at: " + pos.getX() + ", " + pos.getY() + ", " + pos.getZ());
	            
	            return true;
	         }
	      
	}
	
	private void GenerateOasis (IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, BlockPos pos, int size, Random rand)
	{
		for (int depth = 0; depth <= (5*size); depth++)
		{
			Layer(worldIn, pos, (11*size), Blocks.SAND.getDefaultState());
		}
         Layer(worldIn, pos, (10*size), Blocks.GRASS_BLOCK.getDefaultState());
         for (int depth = 1; depth <= (4*size); depth++)
         {
        	 Layer(worldIn, pos.down(depth), ((10-depth)*size), Blocks.DIRT.getDefaultState());
         }
         for (int depth = 0; depth < (3*size); depth++)
         {
        	 Layer(worldIn, pos.down(depth), ((8-depth)*size), Blocks.WATER.getDefaultState());
         }
         for (int air = 1; air <= 12; air++)
         {
        	 Layer(worldIn, pos.up(air), (11*size), Blocks.AIR.getDefaultState());
         }
         
         GeneratePlant (worldIn, pos.up(), (10*size), ((3*size) + rand.nextInt(3)), ModBlocks.PALM_SAPLING.getDefaultState(), rand);
         GeneratePlant (worldIn, pos.up(), (8*size), ((3*size) + rand.nextInt(3)), Blocks.LILY_PAD.getDefaultState(), rand);
         GeneratePlant (worldIn, pos.up(), (10*size), ((20*size) + rand.nextInt(5*size)), Blocks.GRASS.getDefaultState(), rand);
         GeneratePlant (worldIn, pos.up(), (10*size), ((3*size) + rand.nextInt(3)), ModBlocks.DESERT_CANDLE.getDefaultState(), rand);
         GeneratePlant (worldIn, pos.up(), (10*size), ((4*size) + rand.nextInt(3)), Blocks.SUGAR_CANE.getDefaultState(), rand);

         if (rand.nextBoolean())
         {
        	 int x = randomInt((5*size), rand);
        	 int z = randomInt((5*size), rand);
        	 BlockPos blockpos = pos.add(x, 0, z);
        	 this.GenerateOasis(worldIn, generator, blockpos, (1 + rand.nextInt(2)), rand);
         }
	}
	private void Layer(IWorld worldIn, BlockPos layerCenter, int width, BlockState state)
   {
       int max = width * width;

       for (int x = -width; x <= width; ++x)
       {
           for (int z = -width; z <= width; ++z)
           {
               if (x * x + z * z <= max)
               {
                   BlockPos blockpos = layerCenter.add(x, 0, z);
                   if (worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER)
                   {
                	   continue;
                   }
					worldIn.setBlockState(blockpos, state, 2);
					try {
						worldIn.getChunk(blockpos).getBiomes()[(blockpos.getX() & 15) << 4 | (blockpos.getZ() & 15)] = WorldGeneration.OASIS;
					} catch (Exception e) {
						continue;
					}
               }
           }
       }
   }

	private void GeneratePlant (IWorld worldIn, BlockPos layerCenter, int width, int amount, BlockState state, Random rand)
	{
		int max = width * width;
		int plant = 0;

		while (plant <= amount)
		{
			int x = randomInt(width, rand);
			int z = randomInt(width, rand);
			
	        if (x * x + z * z <= max)
	        {
				BlockPos blockpos = layerCenter.add(x, 0, z);
				if (worldIn.getBlockState(blockpos.down()).getBlock() == Blocks.WATER)
				{
					if (state.getBlock() == Blocks.LILY_PAD)
					{
						worldIn.setBlockState(blockpos, state, 2);
						plant++;
						continue;
					}
	
				}
				if (worldIn.getBlockState(blockpos.down()).getBlock() == Blocks.GRASS_BLOCK)
				{
	            	   
					if (state.getBlock() == ModBlocks.PALM_SAPLING)
					{
						 boolean tree = false;

						   for (Direction direction : Direction.Plane.HORIZONTAL)
						   {
							   if (worldIn.getBlockState(blockpos.offset(direction)).getBlock() == ModBlocks.PALM_SAPLING || worldIn.getBlockState(blockpos.offset(direction)).getBlock() == ModBlocks.PALM_LOG)
							   {
								   tree = true;
							   }
						   }
						   
						   if (tree)
						   {
							   continue;
						   }
						GenerateTree(worldIn, blockpos, state, rand);
						plant++;
						continue;
					}
	           	   
					if (state.getBlock() == Blocks.SUGAR_CANE)
					{
						GenerateReed(worldIn, blockpos, state, rand);
						plant++;
						continue;
					}
					

					worldIn.setBlockState(blockpos, state, 2);
					plant++;
				}
        	}
        }
	}
	
	private void GenerateReed (IWorld worldIn, BlockPos pos, BlockState state, Random rand)
	{
		 boolean water = false;

		   for (Direction direction : Direction.Plane.HORIZONTAL)
		   {
			   if (worldIn.getBlockState(pos.down().offset(direction)).getBlock() == Blocks.WATER)
			   {
				   water = true;
			   }
		   }
		   
		   if (!water)
		   {
			   return;
		   }
		   
		   worldIn.setBlockState(pos, state, 2);
		   
		   if (rand.nextInt(10) == 1)
		   {
			   worldIn.setBlockState(pos.up(), state, 2);
		   }
	   }
	
	
	private void GenerateTree (IWorld worldIn, BlockPos pos, BlockState state, Random rand)
	{
 	   state = state.with(ModSaplingBlock.STAGE, Integer.valueOf(1));
	   worldIn.setBlockState(pos, state, 2);
	   ModSaplingBlock block = (ModSaplingBlock) state.getBlock();
	   block.grow(worldIn, pos, state, rand);
	}
	   
	private static int randomInt (int num, Random rand)
	{
		int pos = rand.nextInt(num);
		
		if(rand.nextBoolean())
		{
			pos = -pos;
		}
		
		return pos;
	}
}
