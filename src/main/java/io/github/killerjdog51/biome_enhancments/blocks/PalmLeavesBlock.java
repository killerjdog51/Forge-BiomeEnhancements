package io.github.killerjdog51.biome_enhancments.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import io.github.killerjdog51.biome_enhancments.init.ModBlocks;

public class PalmLeavesBlock extends LeavesBlock {
	   public static final IntegerProperty NEWDISTANCE = IntegerProperty.create("newdistance", 1, 11);
	   public static final EnumProperty<Type> TYPE = EnumProperty.create("type", PalmLeavesBlock.Type.class);


	   public PalmLeavesBlock(Block.Properties properties) {
	      super(properties);
	      this.setDefaultState(this.stateContainer.getBaseState().with(NEWDISTANCE, Integer.valueOf(11)).with(PERSISTENT, Boolean.valueOf(false)).with(TYPE, PalmLeavesBlock.Type.NORMAL));
	   }

	   @Override
	   public boolean ticksRandomly(BlockState state) {
	      return state.get(NEWDISTANCE) == 11 && !state.get(PERSISTENT);
	   }

	   @Override
	   public void randomTick(BlockState state, World worldIn, BlockPos pos, Random random) {
	      if (!state.get(PERSISTENT) && state.get(NEWDISTANCE) == 11) {
	         spawnDrops(state, worldIn, pos);
	         worldIn.removeBlock(pos, false);
	      }

	   }

	   @Override
	   public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
	      worldIn.setBlockState(pos, updateDistance(state, worldIn, pos), 3);
	   }

	   @Override
	   public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
	      int i = getDistance(facingState) + 1;
	      
	      if (i != 1 || stateIn.get(NEWDISTANCE) != i) {
	         worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
	      }

	      return stateIn;
	   }

	   private static BlockState updateDistance(BlockState state, IWorld world, BlockPos pos) {
	      int i = 11;

	      try (BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos = BlockPos.PooledMutableBlockPos.retain()) {
	         for(Direction direction : Direction.values()) {
	            blockpos$pooledmutableblockpos.setPos(pos).move(direction);
	            i = Math.min(i, getDistance(world.getBlockState(blockpos$pooledmutableblockpos)) + 1);
	            if (i == 1) {
	               break;
	            }
	         }
	      }

	      return state.with(NEWDISTANCE, Integer.valueOf(i));
	   }

	   private static int getDistance(BlockState neighbor) {
	      if (BlockTags.LOGS.contains(neighbor.getBlock())) {
	         return 0;
	      } else {
	         return neighbor.getBlock() instanceof PalmLeavesBlock ? neighbor.get(NEWDISTANCE) : 11;
	      }
	   }

	  
	   @Override
	   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
	      builder.add(NEWDISTANCE);
	      builder.add(TYPE);
	      super.fillStateContainer(builder);
	   }
	   
	// We want Palm trees to grow two different crops (or no crops too)
	   public static enum Type implements IStringSerializable{
		      NORMAL(Blocks.AIR, "normal"),
		      COCONUT(ModBlocks.COCONUT, "coconut"),
		      DATE(ModBlocks.DATES, "date");

		      private final String name;
		      private final Block baseBlock;

		      private Type(Block block, String string2) {
		         this.name = string2;
		         this.baseBlock = block;
		      }

		      public String getName() {
		         return this.name;
		      }

		      public Block getBaseBlock() {
		         return this.baseBlock;
		      }

		      public String toString() {
		         return this.name;
		      }

		      public static PalmLeavesBlock.Type getType(int i) {
		         PalmLeavesBlock.Type[] types = values();
		         if (i < 0 || i >= types.length) {
		            i = 0;
		         }

		         return types[i];
		      }

		      public static PalmLeavesBlock.Type getType(String string) {
		         PalmLeavesBlock.Type[] types = values();

		         for(int i = 0; i < types.length; ++i) {
		            if (types[i].getName().equals(string)) {
		               return types[i];
		            }
		         }

		         return types[0];
		      }

			
		   }
	}