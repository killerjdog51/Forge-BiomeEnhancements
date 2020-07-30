package io.github.killerjdog51.biome_enhancments.world.gen.feature;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import io.github.killerjdog51.biome_enhancments.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class PalmTreeFeature extends AbstractTreeFeature<NoFeatureConfig>
{

	private static BlockState LOG = ModBlocks.PALM_LOG.getDefaultState();
    private static final BlockState LEAF = ModBlocks.PALM_LEAVES.getDefaultState();
    private final int minHeight = 5;
    
	public PalmTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn)
	{
		super(configIn, false);
	    setSapling((net.minecraftforge.common.IPlantable)ModBlocks.PALM_SAPLING);
	}

	public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader world, Random rand, BlockPos pos, MutableBoundingBox box)
	{

		int height = this.minHeight + rand.nextInt(4);
		boolean flag = true;
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		
		 if (y >= 1 && y + height + 1 <= world.getMaxHeight())
		 {
			for(int yPos = y; yPos <= y + 1 + height; yPos++)
			{
				int b0 = 1;
				if(yPos == y) b0 = 0;
				if(yPos >= y + 1 + height - 2) b0 = 2;
	            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
	            
	            for(int xPos = x - b0; xPos <= x + b0 && flag; xPos++)
	            {
	            	for(int zPos = z - b0; zPos <= z + b0 && flag; zPos++)
	            	{
	            		if(yPos >= 0 && yPos < world.getMaxHeight())
	            		{
	            			if(!func_214587_a(world, blockpos$mutableblockpos.setPos(xPos, yPos, zPos)))
	            			{
	            				flag = false;
	            			}
	            		}
	            		else 
	            		{
	            			flag = false;
	            		}
	            	}
	            }
			}
			
			if(!flag)
			{
				return false;
			}
			else if ((isSoil(world, pos.down(), getSapling()) || world.hasBlockState(pos.down(), (state) -> state.isIn(BlockTags.SAND))) && y < world.getMaxHeight() - height - 1)
			{
	            this.setDirtAt(world, pos.down(), pos);
                Direction direction = Direction.Plane.HORIZONTAL.random(rand);
                int xPos = pos.getX();
				int zPos = pos.getZ();
				int top = 0;
					
				for(int block = 0; block <= height; block++)
				{
					int yPos = y + block;
						
					if(yPos > y && yPos <= (y + (height - 3)))
					{
						if(rand.nextInt(10) == 1)
						{
						xPos += direction.getXOffset();
						zPos += direction.getZOffset();
						}
					}
					if(yPos == (y + height))
					{
						LOG = ModBlocks.PALM_WOOD.getDefaultState();
					}
						BlockPos blockpos = new BlockPos(xPos, yPos, zPos);
	
	                    if (isAirOrLeaves(world, blockpos))
	                    {
	                        this.placeLogAt(changedBlocks, world, blockpos, box);
	                        top = yPos;
	                    }
					}
					LOG = ModBlocks.PALM_LOG.getDefaultState();
	                BlockPos topBlock = new BlockPos(xPos, top, zPos);
                    this.placeLeafAt(changedBlocks, world, topBlock.add(0, 1, 0), box);

	                for(Direction side : Direction.Plane.HORIZONTAL)
	                {
	                	
	                	leafLayer1(changedBlocks, world, topBlock, side, box);
	                	leafLayer2(changedBlocks, world, topBlock, side, box);
	                	leafLayer3(changedBlocks, world, topBlock, side, box);

	                }
	
	                return true;
				}
				else
				{
					return false;
				}
		}
		 else
		 {
			 return false;
		 }
	}

	private void leafLayer1(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, BlockPos pos, Direction side, MutableBoundingBox box)
	{
		int X = side.getXOffset();
		int Z = side.getZOffset();
		this.placeLeafAt(changedBlocks, worldIn, pos.add(X, -1, Z), box);
		
		X += side.getXOffset();
		Z += side.getZOffset();
		this.placeLeafAt(changedBlocks, worldIn, pos.add(X, -1, Z), box);
		this.placeLeafAt(changedBlocks, worldIn, pos.add(X, -2, Z), box);

	}
	
	private void leafLayer2(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, BlockPos pos, Direction side, MutableBoundingBox box)
	{
		int X = side.getXOffset();
		int Z = side.getZOffset();
		this.placeLeafAt(changedBlocks, worldIn, pos.add(X, 0, Z), box);
		
		X += side.getXOffset();
		Z += side.getZOffset();
		this.placeLeafAt(changedBlocks, worldIn, pos.add(X, 0, Z), box);

		X += side.getXOffset();
		Z += side.getZOffset();
		this.placeLeafAt(changedBlocks, worldIn, pos.add(X, 0, Z), box);

		X += side.getXOffset();
		Z += side.getZOffset();
		this.placeLeafAt(changedBlocks, worldIn, pos.add(X, 0, Z), box);
		this.placeLeafAt(changedBlocks, worldIn, pos.add(X, -1, Z), box);
	}
	
	private void leafLayer3(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, BlockPos pos, Direction side, MutableBoundingBox box)
	{
		int X = side.getXOffset();
		int Z = side.getZOffset();
		this.placeLeafAt(changedBlocks, worldIn, pos.add(X, 1, Z), box);
		this.placeLeafAt(changedBlocks, worldIn, pos.add(X, 2, Z), box);

		X += side.getXOffset();
		Z += side.getZOffset();
		this.placeLeafAt(changedBlocks, worldIn, pos.add(X, 2, Z), box);
		this.placeLeafAt(changedBlocks, worldIn, pos.add(X, 3, Z), box);

		X += side.getXOffset();
		Z += side.getZOffset();
		this.placeLeafAt(changedBlocks, worldIn, pos.add(X, 3, Z), box);
		
		X += side.getXOffset();
		Z += side.getZOffset();
		this.placeLeafAt(changedBlocks, worldIn, pos.add(X, 3, Z), box);
		this.placeLeafAt(changedBlocks, worldIn, pos.add(X, 2, Z), box);

		X += side.getXOffset();
		Z += side.getZOffset();
		this.placeLeafAt(changedBlocks, worldIn, pos.add(X, 2, Z), box);
		this.placeLeafAt(changedBlocks, worldIn, pos.add(X, 1, Z), box);
	}
	
	private void placeLogAt(Set<BlockPos> changedBlocks, IWorldWriter worldIn, BlockPos pos, MutableBoundingBox box)
    {
		this.setLogState(changedBlocks, worldIn, pos, LOG, box);
    }

    private void placeLeafAt(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, BlockPos pos, MutableBoundingBox box)
    {
        if (isAirOrLeaves(worldIn, pos))
        {
    		this.setLogState(changedBlocks, worldIn, pos, LEAF, box);
        }
    }
}
