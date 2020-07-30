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

    @SubscribeEvent
    public void onBlockClicked(PlayerInteractEvent.RightClickBlock event) {
        if (event.getItemStack().getItem() instanceof AxeItem) {
            World world = event.getWorld();
            BlockPos blockpos = event.getPos();
            BlockState blockstate = world.getBlockState(blockpos);
            Block block = BLOCK_STRIPPING_MAP.get(blockstate.getBlock());
            if (block != null) {
                PlayerEntity playerentity = event.getPlayer();
                world.playSound(playerentity, blockpos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
                if (!world.isRemote) {
                	if (blockstate.getBlock() == ModBlocks.PALM_LOG)
                	{
                		 world.setBlockState(blockpos, block.getDefaultState()
                                 .with(RotatedBlock.FACING, blockstate.get(RotatedBlock.FACING)), 11);
                	} else {
                    world.setBlockState(blockpos, block.getDefaultState()
                            .with(RotatedPillarBlock.AXIS, blockstate.get(RotatedPillarBlock.AXIS)), 11);
                	}
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