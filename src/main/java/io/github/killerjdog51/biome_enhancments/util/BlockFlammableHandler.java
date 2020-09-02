package io.github.killerjdog51.biome_enhancments.util;

import io.github.killerjdog51.biome_enhancments.init.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;

public class BlockFlammableHandler {

	public static void init()
	{
		FireBlock fireblock = (FireBlock)Blocks.FIRE;
		fireblock.setFireInfo(ModBlocks.BAOBAB_PLANKS, 5, 20);
		fireblock.setFireInfo(ModBlocks.MANGROVE_PLANKS, 5, 20);
		fireblock.setFireInfo(ModBlocks.PALM_PLANKS, 5, 20);
		fireblock.setFireInfo(ModBlocks.BAOBAB_SLAB, 5, 20);
		fireblock.setFireInfo(ModBlocks.MANGROVE_SLAB, 5, 20);
		fireblock.setFireInfo(ModBlocks.PALM_SLAB, 5, 20);
		fireblock.setFireInfo(ModBlocks.BAOBAB_STAIRS, 5, 20);
		fireblock.setFireInfo(ModBlocks.MANGROVE_STAIRS, 5, 20);
		fireblock.setFireInfo(ModBlocks.PALM_STAIRS, 5, 20);
		fireblock.setFireInfo(ModBlocks.BAOBAB_FENCE, 5, 20);
		fireblock.setFireInfo(ModBlocks.MANGROVE_FENCE, 5, 20);
		fireblock.setFireInfo(ModBlocks.PALM_FENCE, 5, 20);
		fireblock.setFireInfo(ModBlocks.BAOBAB_FENCE_GATE, 5, 20);
		fireblock.setFireInfo(ModBlocks.MANGROVE_FENCE_GATE, 5, 20);
		fireblock.setFireInfo(ModBlocks.PALM_FENCE_GATE, 5, 20);
		fireblock.setFireInfo(ModBlocks.BAOBAB_LOG, 5, 5);
		fireblock.setFireInfo(ModBlocks.MANGROVE_LOG, 5, 5);
		fireblock.setFireInfo(ModBlocks.PALM_LOG, 5, 5);
		fireblock.setFireInfo(ModBlocks.BAOBAB_WOOD, 5, 5);
		fireblock.setFireInfo(ModBlocks.MANGROVE_WOOD, 5, 5);
		fireblock.setFireInfo(ModBlocks.PALM_WOOD, 5, 5);
		fireblock.setFireInfo(ModBlocks.STRIPPED_BAOBAB_LOG, 5, 5);
		fireblock.setFireInfo(ModBlocks.STRIPPED_MANGROVE_LOG, 5, 5);
		fireblock.setFireInfo(ModBlocks.STRIPPED_PALM_LOG, 5, 5);
		fireblock.setFireInfo(ModBlocks.STRIPPED_BAOBAB_WOOD, 5, 5);
		fireblock.setFireInfo(ModBlocks.STRIPPED_MANGROVE_WOOD, 5, 5);
		fireblock.setFireInfo(ModBlocks.STRIPPED_PALM_WOOD, 5, 5);
		fireblock.setFireInfo(ModBlocks.BAOBAB_LEAVES, 30, 60);
		fireblock.setFireInfo(ModBlocks.MANGROVE_LEAVES, 30, 60);
		fireblock.setFireInfo(ModBlocks.PALM_LEAVES, 30, 60);
		fireblock.setFireInfo(ModBlocks.DESERT_CANDLE, 60, 100);
	}
}
