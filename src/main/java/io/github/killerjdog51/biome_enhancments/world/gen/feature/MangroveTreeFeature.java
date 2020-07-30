package io.github.killerjdog51.biome_enhancments.world.gen.feature;

import com.mojang.datafixers.Dynamic;

import io.github.killerjdog51.biome_enhancments.init.ModBlocks;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.VineBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class MangroveTreeFeature extends AbstractTreeFeature<NoFeatureConfig> {
   private static BlockState LOG = ModBlocks.MANGROVE_LOG.getDefaultState();
   private static final BlockState LEAF = ModBlocks.MANGROVE_LEAVES.getDefaultState();
   private final int minHeight = 5;

   public MangroveTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
      super(config, false);
      setSapling((net.minecraftforge.common.IPlantable)ModBlocks.MANGROVE_SAPLING);

   }

   public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox box)
   {
      int height = this.minHeight + rand.nextInt(3);
      position = worldIn.getHeight(Heightmap.Type.OCEAN_FLOOR, position);
      boolean flag = true;
      boolean roots = false;
  	  int water = 0;
      int x = position.getX();
      int y = position.getY();
      int z = position.getZ();
      
      if (y >= 1 && y + height + 1 <= worldIn.getMaxHeight())
      {
         for(int yPos = y; yPos <= y + 1 + height; ++yPos)
         {
            int b0 = 1;
            if (yPos == y) {
               b0 = 0;
            }

            if (yPos >= y + 1 + height - 2) {
               b0 = 3;
            }

            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

            for(int xPos = x - b0; xPos <= x + b0 && flag; ++xPos)
            {
               for(int zPos = z - b0; zPos <= z + b0 && flag; ++zPos)
               {
                  if (yPos >= 0 && yPos < worldIn.getMaxHeight())
                  {
                     blockpos$mutableblockpos.setPos(xPos, yPos, zPos);
                     if (!isAirOrLeaves(worldIn, blockpos$mutableblockpos))
                     {
                        if (isWater(worldIn, blockpos$mutableblockpos))
                        {
                        	BlockPos pos = blockpos$mutableblockpos;
                        	roots = true;
                        	int i;
                        	 for (i = 1; isWater(worldIn, pos); pos = pos.up())
                             {
                                 i++;
                             }
                        	 if (water < i)
                        	 {
                             	water = i;
                        	 }
                        	
                           if (water > 3) {
                              flag = false;
                           }
                        } else {
                           flag = false;
                        }
                     }
                  } else {
                     flag = false;
                  }
               }
            }
         }

         if (!flag) {
            return false;
         } else if (isSoil(worldIn, position.down(), getSapling()) && y < worldIn.getMaxHeight() - height - 1)
         {
            this.setDirtAt(worldIn, position.down(), position);

            //Trunk
            for (int block = 0; block < height; ++block)
            {
            	LOG = ModBlocks.MANGROVE_LOG.getDefaultState();
                BlockPos pos = position.up(block + water);
                placeLogAt(changedBlocks, worldIn, pos, box);
             }
            
            //roots
            if(roots) {
	            for (Direction direction : Direction.Plane.HORIZONTAL)
	            {
	            	for (int i = 0; i <= water; i++)
	        	   	{
	        	   		placeLogAt(changedBlocks, worldIn, position.down(i), box);
	        	   	}
	            	LOG = ModBlocks.MANGROVE_WOOD.getDefaultState();
	            	BlockPos pos = position.offset(direction).up(water);
	            	createRoots(changedBlocks, worldIn, pos, box, rand, water);
	            	
	            	if (rand.nextInt(10) == 1 && height < 7)
	            	{
		            	pos = position.offset(direction).up(water);
		            	pos = position.offset(direction).up(water + 1);
		    	   		placeLogAt(changedBlocks, worldIn, pos, box);
	            	}
	            }
            }
            //Leaves
            for (int yPos = y - 3 + (height + water); yPos <= y + (height + water); ++yPos)
            {
               int leafHeight = yPos - (y + (height + water));
               int leafWidth = 2 - leafHeight / 2;

               for(int xPos = x - leafWidth; xPos <= x + leafWidth; ++xPos)
               {
                  int xWidth = xPos - x;

                  for(int zPos = z - leafWidth; zPos <= z + leafWidth; ++zPos)
                  {
                     int zWidth = zPos - z;
                     if (Math.abs(xWidth) != leafWidth || Math.abs(zWidth) != leafWidth || rand.nextInt(2) != 0 && leafHeight != 0)
                     {
                        BlockPos pos = new BlockPos(xPos, yPos, zPos);
                        placeLeafAt(changedBlocks, worldIn, pos, box);
                     }
                  }
               }
            }

            //Vines
            for(int yPos = y - 3 + (height + water); yPos <= y + (height + water); ++yPos)
            {
               int leafHeight = yPos - (y + (height + water));
               int leafWidth = 2 - leafHeight / 2;
               
               BlockPos.MutableBlockPos blockpos$mutableblockpos1 = new BlockPos.MutableBlockPos();

               for(int xPos = x - leafWidth; xPos <= x + leafWidth; ++xPos)
               {
                  for(int zPos = z - leafWidth; zPos <= z + leafWidth; ++zPos)
                  {
                     blockpos$mutableblockpos1.setPos(xPos, yPos, zPos);
                     
                     if (isLeaves(worldIn, blockpos$mutableblockpos1))
                     {
                        BlockPos westBlock = blockpos$mutableblockpos1.west();
                        BlockPos eastBlock = blockpos$mutableblockpos1.east();
                        BlockPos northBlock = blockpos$mutableblockpos1.north();
                        BlockPos southBlock = blockpos$mutableblockpos1.south();
                        
                        if (rand.nextInt(4) == 0 && isAir(worldIn, westBlock))
                        {
                           this.addVine(worldIn, westBlock, VineBlock.EAST);
                        }

                        if (rand.nextInt(4) == 0 && isAir(worldIn, eastBlock)) {
                           this.addVine(worldIn, eastBlock, VineBlock.WEST);
                        }

                        if (rand.nextInt(4) == 0 && isAir(worldIn, northBlock)) {
                           this.addVine(worldIn, northBlock, VineBlock.SOUTH);
                        }

                        if (rand.nextInt(4) == 0 && isAir(worldIn, southBlock)) {
                           this.addVine(worldIn, southBlock, VineBlock.NORTH);
                        }
                     }
                  }
               }
            }

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private void addVine(IWorldGenerationReader worldIn, BlockPos pos, BooleanProperty prop) {
      BlockState blockstate = Blocks.VINE.getDefaultState().with(prop, Boolean.valueOf(true));
      this.setBlockState(worldIn, pos, blockstate);
      int i = 4;

      for(BlockPos blockpos = pos.down(); isAir(worldIn, blockpos) && i > 0; --i) {
         this.setBlockState(worldIn, blockpos, blockstate);
         blockpos = blockpos.down();
      }

   }
   
   private void createRoots(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, BlockPos pos, MutableBoundingBox box, Random rand, int water)
   {
	   Direction direction = Direction.Plane.HORIZONTAL.random(rand);
	   
		for (int i = 0; i <= water; i++)
	   	{
	   		if (rand.nextInt(2) == 1) {createRoots(changedBlocks, worldIn, pos.offset(direction).down(water - i), box, rand, i);}
	   		if (rand.nextInt(10) == 1) {continue;}
	   		placeLogAt(changedBlocks, worldIn, pos.down(i), box);
	   		
	   		int waterBlock = 1;
	   		while (isWater(worldIn, pos.down(i + waterBlock)) || isAir(worldIn, pos.down(i + waterBlock)) || isGrass(worldIn, pos.down(i + waterBlock)))
	   		{
		   		placeLogAt(changedBlocks, worldIn, pos.down(i + waterBlock), box);
		   		waterBlock++;
	   		}
	   	}
   }
   
   protected static boolean isGrass(IWorldGenerationBaseReader worldIn, BlockPos pos) {
	      return worldIn.hasBlockState(pos, (state) -> {
	         return state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.SEAGRASS;
	      });
	   }
   
   private void placeLogAt(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, BlockPos pos, MutableBoundingBox box)
   {
	   if (isAirOrLeaves(worldIn, pos) || isWater(worldIn, pos))
       {
          this.setLogState(changedBlocks, worldIn, pos, LOG, box);
       }
   }
   
   private void placeLeafAt(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, BlockPos pos, MutableBoundingBox box)
   {
       if (isAirOrLeaves(worldIn, pos) || func_214576_j(worldIn, pos))
       {
   		this.setLogState(changedBlocks, worldIn, pos, LEAF, box);
       }
   }
}