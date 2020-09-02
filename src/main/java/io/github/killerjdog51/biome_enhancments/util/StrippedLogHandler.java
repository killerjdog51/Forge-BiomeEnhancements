package io.github.killerjdog51.biome_enhancments.util;

import java.util.HashMap;
import java.util.Map;

import io.github.killerjdog51.biome_enhancments.blocks.RotatedBlock;
import io.github.killerjdog51.biome_enhancments.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class StrippedLogHandler {

    public static Map<Block, Block> BLOCK_STRIPPING_MAP = new HashMap<>();

    static {
        BLOCK_STRIPPING_MAP.put(ModBlocks.BAOBAB_LOG, ModBlocks.STRIPPED_BAOBAB_LOG);
        BLOCK_STRIPPING_MAP.put(ModBlocks.BAOBAB_WOOD, ModBlocks.STRIPPED_BAOBAB_WOOD);
        BLOCK_STRIPPING_MAP.put(ModBlocks.MANGROVE_LOG, ModBlocks.STRIPPED_MANGROVE_LOG);
        BLOCK_STRIPPING_MAP.put(ModBlocks.MANGROVE_WOOD, ModBlocks.STRIPPED_MANGROVE_WOOD);
        BLOCK_STRIPPING_MAP.put(ModBlocks.PALM_LOG, ModBlocks.STRIPPED_PALM_LOG);
        BLOCK_STRIPPING_MAP.put(ModBlocks.PALM_WOOD, ModBlocks.STRIPPED_PALM_WOOD);
    }

    // I use an event for the forge version of my mod simply because it's easier. Forge obfuscates all functions/methods and Fields,
    //so It's a pain to use recursion in Forge (It's possible, just difficult because you either need to find the name prior to obfuscation or know the obfuscated name)
    @SubscribeEvent
    public void onBlockClicked(PlayerInteractEvent.RightClickBlock event)
    {
    	
		// If the player's holding an axe item continue
        if (event.getItemStack().getItem() instanceof AxeItem) {
        	
        	//Get variables related to the world/block
            World world = event.getWorld();
            BlockPos blockpos = event.getPos();
            BlockState blockstate = world.getBlockState(blockpos);
            
			// If the block clicked on is in our map we return the stripped version, otherwise null
            Block block = BLOCK_STRIPPING_MAP.get(blockstate.getBlock());
            
			// If block isn't null continue
            if (block != null)
            {
            	// Get the player instance
                PlayerEntity playerentity = event.getPlayer();
                
				// Play the sound for stripping the log
                world.playSound(playerentity, blockpos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
                
                if (!world.isRemote)
                {
					// Replace our log block with the stripped version with the correct orientation
                	// Palm Logs aren't an instance of LogBlock, so we use the facing enum instead of the axis enum
                	if (blockstate.getBlock() == ModBlocks.PALM_LOG)
                	{
                		 world.setBlockState(blockpos, block.getDefaultState()
                                 .with(RotatedBlock.FACING, blockstate.get(RotatedBlock.FACING)), 11);
                	}
                	else
                	{
                    world.setBlockState(blockpos, block.getDefaultState()
                            .with(RotatedPillarBlock.AXIS, blockstate.get(RotatedPillarBlock.AXIS)), 11);
                	}
                	
					// Damage the axe if the player isn't in creative
                    if (playerentity != null) {
                        event.getItemStack().damageItem(1, playerentity, (p_220040_1_) -> {
                            p_220040_1_.sendBreakAnimation(event.getHand());
                        });
                    }
                }
            }
        }

    }

}