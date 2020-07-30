package io.github.killerjdog51.biome_enhancments.world.gen.feature;

import com.mojang.datafixers.Dynamic;

import io.github.killerjdog51.biome_enhancments.init.ModBlocks;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class BaobabTreeFeature extends AbstractTreeFeature<NoFeatureConfig> {
   private static BlockState LOG = ModBlocks.BAOBAB_LOG.getDefaultState();
   private static final BlockState LEAVES = ModBlocks.BAOBAB_LEAVES.getDefaultState();
   private final int minHeight = 8;

   public BaobabTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> config)
   {
      super(config, false);
      setSapling((net.minecraftforge.common.IPlantable)ModBlocks.BAOBAB_SAPLING);
   }

   public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos pos, MutableBoundingBox box)
   {
	   Random newRand = new Random();
		
		int height = this.minHeight + newRand.nextInt(4);
		 if(newRand.nextBoolean()) {height += newRand.nextInt(6);}
		
		if (!this.ensureGrowable(worldIn, pos, height))
       {
           return false;
       }
		else
		{			
			// generate trunk
			for (int currentX = 0; currentX < 4; ++currentX)
			{
				for (int currentZ = 0; currentZ < 4; ++currentZ)
				{
					for (int currentY = 0; currentY < height; currentY++)
		            {
		                if (isAirOrLeaves(worldIn, pos.add(currentX, currentY, currentZ)))
		                {
		                	if (currentY == (height - 1))
							{
								LOG = ModBlocks.BAOBAB_WOOD.getDefaultState();
							}
		                	else
		                	{
								LOG = ModBlocks.BAOBAB_LOG.getDefaultState();	
		                	}
		                	
							 BlockPos blockpos = pos.add(currentX, currentY, currentZ);
							 this.placeLogAt(changedBlocks, worldIn, blockpos, box);
		                }
		            }
				}
			}
			
			// generate branches/leaves
           this.createCrown(changedBlocks, worldIn, box, pos.getX(), pos.getZ(), pos.getY() + (height - 1), newRand);
           this.createSideBranch(changedBlocks, worldIn, box, pos.getX(), pos.getZ(), pos.getY() + (height - 5), newRand);
           if (height >= 15)
           {
               this.createSideBranch(changedBlocks, worldIn, box, pos.getX(), pos.getZ(), pos.getY() + (height - 9), newRand);
           }
           
           // generate roots
           if (newRand.nextBoolean())
           {
           	for (Direction direction : Direction.Plane.HORIZONTAL)
           	{
           		if (newRand.nextInt(5) == 1) { continue; }
           		
   	    		int block = rand.nextInt(3);
   	    		int xPos = pos.getX();
   	    		int zPos = pos.getZ();
   	    		
					LOG = ModBlocks.BAOBAB_WOOD.getDefaultState();

   	    		if (direction == Direction.NORTH || direction == Direction.SOUTH)
   				{
   					xPos += block;
   					if (direction == Direction.SOUTH) { zPos += 3;}
   				}
   				else if (direction == Direction.EAST || direction == Direction.WEST)
   				{
   					zPos += block;
   					if (direction == Direction.EAST) { xPos += 3;} 
   				}
   	    		
   	    		xPos += direction.getXOffset();
   	    		zPos += direction.getZOffset();
   	    		BlockPos blockpos = new BlockPos(xPos, pos.getY(), zPos);

   		    	this.placeLogAt(changedBlocks, worldIn, blockpos, box);
   		    	if (newRand.nextInt(5) == 1)
   		    	{
       		    	this.placeLogAt(changedBlocks, worldIn, new BlockPos(xPos, pos.getY()+1, zPos), box);

   		    	}

           	}
           }

			return true;
		}
      } 
   
   private void createCrown(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, MutableBoundingBox box, int x, int z, int y, Random rand)
	{
   	int maxBranches = 1 + rand.nextInt(2);
   	this.createBranches(changedBlocks, worldIn, box, x, z, y, rand, maxBranches, true);

	}
	
	private void createSideBranch(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, MutableBoundingBox box, int x, int z, int y, Random rand)
   {
		int maxBranches = rand.nextInt(3);
   	this.createBranches(changedBlocks, worldIn, box, x, z, y, rand, maxBranches, false);
   }
	
   private void createBranches(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, MutableBoundingBox box, int x, int z, int y, Random rand, int maxBranches, boolean top)
   {
   	int branches = 0;
   	while (branches < maxBranches)
   	{    		
	    	for (Direction direction : Direction.Plane.HORIZONTAL)
	    	{
	    		if(rand.nextInt(5) == 1) { continue;}

	    		int block = rand.nextInt(3);
	    		int xPos = x;
	    		int yPos = y;
	    		int zPos = z;
	    		
	    		if (direction == Direction.NORTH || direction == Direction.SOUTH)
				{
					LOG = ModBlocks.BAOBAB_LOG.getDefaultState().with(LogBlock.AXIS, Direction.Axis.Z);
					xPos += block;
					if (direction == Direction.SOUTH) { zPos += 3;}
				}
				else if (direction == Direction.EAST || direction == Direction.WEST)
				{
					LOG = ModBlocks.BAOBAB_LOG.getDefaultState().with(LogBlock.AXIS, Direction.Axis.X);
					zPos += block;
					if (direction == Direction.EAST) { xPos += 3;}
				}
				else 
				{
					LOG = ModBlocks.BAOBAB_WOOD.getDefaultState();
				}
	    		
	    		BlockPos blockpos = new BlockPos(xPos, yPos, zPos);
				if(top)
				{
					this.generateTopBranch(changedBlocks, worldIn, blockpos, box, direction, rand);
				}
				else
				{
					this.generateSideBranch(changedBlocks, worldIn, blockpos, box, direction, rand);
				}
	    	}
	    	branches++;
   	}
   }
   private void generateTopBranch(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, BlockPos pos, MutableBoundingBox box, Direction direction, Random rand)
   {
	   	int xPos = direction.getXOffset();
		int zPos = direction.getZOffset();
		int yPos = direction.getYOffset();
	
	   	for(int block = 0; block < 4; block++)
	   	{
	   		if(block == 3)
	   		{
					LOG = ModBlocks.BAOBAB_WOOD.getDefaultState();
	   		}
	   		
	   		this.placeLogAt(changedBlocks, worldIn, pos.add(xPos, yPos, zPos), box);
	   		if(block == 3) { break;}
	   		
	   		xPos += direction.getXOffset();
			zPos += direction.getZOffset();
			yPos += direction.getYOffset();
	   	}
	   	
	   	
		LOG = ModBlocks.BAOBAB_LOG.getDefaultState().with(LogBlock.AXIS, Direction.Axis.Y);
		int top = 1 + rand.nextInt(3);
			
		for(int i = 0; i < top; i++)
		{
	    	this.placeLogAt(changedBlocks, worldIn, pos.add(xPos, yPos + (i + 1), zPos), box);
		}
   	
   	
		xPos += direction.getXOffset();
		zPos += direction.getZOffset();
		BlockPos blockpos = pos.add(xPos, yPos + top, zPos);
		this.growLeavesLayer(changedBlocks, worldIn, blockpos, box, 3);
		this.growLeavesLayer(changedBlocks, worldIn, blockpos.add(0, 1, 0), box, 2);

   }
   
   private void generateSideBranch(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, BlockPos pos, MutableBoundingBox box, Direction direction, Random rand)
   {
   	int xPos = direction.getXOffset();
		int zPos = direction.getZOffset();
		int yPos = direction.getYOffset() + rand.nextInt(2);
		int length = 4 + rand.nextInt(3);

   	for(int block = 0; block < length; block++)
   	{
   		if(block == (length - 1))
   		{
				LOG = ModBlocks.BAOBAB_WOOD.getDefaultState();
   		}
   		
   		this.placeLogAt(changedBlocks, worldIn, pos.add(xPos, yPos, zPos), box);
   		if(block == (length - 1)) { break;}
   		
   		xPos += direction.getXOffset();
			zPos += direction.getZOffset();
			yPos += direction.getYOffset();
   	}
   	
		BlockPos blockpos = pos.add(xPos, yPos + 1, zPos);
   	this.growLeavesLayer(changedBlocks, worldIn, blockpos, box, 2);


   }
   
   private void growLeavesLayer(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, BlockPos layerCenter, MutableBoundingBox box, int width)
   {
       int max = width * width;

       for (int x = -width; x <= width; ++x)
       {
           for (int z = -width; z <= width; ++z)
           {
               if (x * x + z * z <= max)
               {
                   BlockPos blockpos = layerCenter.add(x, 0, z);
                   this.placeLeafAt(changedBlocks, worldIn, blockpos, box);
               }
           }
       }
   }
   private void placeLogAt(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, BlockPos pos, MutableBoundingBox box) {
      if (func_214587_a(worldIn, pos)) {
         this.setLogState(changedBlocks, worldIn, pos, LOG, box);
      }

   }

   private void placeLeafAt(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, BlockPos pos, MutableBoundingBox box) {
      if (isAir(worldIn, pos)) {
         this.setLogState(changedBlocks, worldIn, pos, LEAVES, box);
      }

   }
   
   protected boolean ensureGrowable(IWorldGenerationReader worldIn, BlockPos treePos, int height)
   {
       return this.isSpaceAt(worldIn, treePos, height) && this.ensureDirtsUnderneath(treePos, worldIn);
   }
	
	private boolean isSpaceAt(IWorldGenerationBaseReader worldIn, BlockPos leavesPos, int height)
   {
       boolean flag = true;
       int y = leavesPos.getY();
       int x = leavesPos.getX();
       int z = leavesPos.getZ();
       
       if (y >= 1 && y + height + 1 <= worldIn.getMaxHeight())
       {
           for (int yPos = y; yPos <= y + 1 + height; ++yPos)
           {
               int b0 = 1;

               if (yPos == y)
               {
                   b0 = 0;
               }
               else if (yPos >= y + 1 + height - 2)
               {
                   b0 = 2;
               }

               BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

               for (int xPos = x - b0; xPos <= x + b0 && flag; ++xPos)
               {
                   for (int zPos = z - b0; zPos <= z + b0 && flag; ++zPos)
                   {
                       blockpos$mutableblockpos.setPos(xPos, yPos, zPos);

                       if (y + yPos < 0 || y + yPos >= worldIn.getMaxHeight() || !func_214587_a(worldIn, blockpos$mutableblockpos))
                       {
                           flag = false;
                       }
                   }
               }
           }

           return flag;
       }
       else
       {
           return false;
       }
   }
	
	private boolean ensureDirtsUnderneath(BlockPos pos, IWorldGenerationReader worldIn)
   {
       BlockPos down = pos.down();
       BlockState blockstate = Blocks.AIR.getDefaultState();

       if (isSoil(worldIn, down, getSapling()))
       {
           this.setDirtAt(worldIn, down, pos);
           this.setDirtAt(worldIn, down.east(1), pos);
           this.setDirtAt(worldIn, down.east(2), pos);
           this.setDirtAt(worldIn, down.east(3), pos);
           this.setDirtAt(worldIn, down.south(1), pos);
           this.setDirtAt(worldIn, down.south(1).east(1), pos);
           this.setDirtAt(worldIn, down.south(1).east(2), pos);
           this.setDirtAt(worldIn, down.south(1).east(3), pos);
           this.setDirtAt(worldIn, down.south(2), pos);
           this.setDirtAt(worldIn, down.south(2).east(1), pos);
           this.setDirtAt(worldIn, down.south(2).east(2), pos);
           this.setDirtAt(worldIn, down.south(2).east(3), pos);
           this.setDirtAt(worldIn, down.south(3), pos);
           this.setDirtAt(worldIn, down.south(3).east(1), pos);
           this.setDirtAt(worldIn, down.south(3).east(2), pos);
           this.setDirtAt(worldIn, down.south(3).east(3), pos);

           this.setBlockState(worldIn, pos, blockstate);
           this.setBlockState(worldIn, pos.east(1), blockstate);
           this.setBlockState(worldIn, pos.east(2), blockstate);
           this.setBlockState(worldIn, pos.east(3), blockstate);
           this.setBlockState(worldIn, pos.south(1), blockstate);
           this.setBlockState(worldIn, pos.south(1).east(1), blockstate);
           this.setBlockState(worldIn, pos.south(1).east(2), blockstate);
           this.setBlockState(worldIn, pos.south(1).east(3), blockstate);
           this.setBlockState(worldIn, pos.south(2), blockstate);
           this.setBlockState(worldIn, pos.south(2).east(1), blockstate);
           this.setBlockState(worldIn, pos.south(2).east(2), blockstate);
           this.setBlockState(worldIn, pos.south(2).east(3), blockstate);
           this.setBlockState(worldIn, pos.south(3), blockstate);
           this.setBlockState(worldIn, pos.south(3).east(1), blockstate);
           this.setBlockState(worldIn, pos.south(3).east(2), blockstate);
           this.setBlockState(worldIn, pos.south(3).east(3), blockstate);

           return true;
       }
       else
       {
           return false;
       }
   }
}