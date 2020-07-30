package io.github.killerjdog51.biome_enhancments.init;

import io.github.killerjdog51.biome_enhancments.blocks.MangroveSaplingBlock;
import io.github.killerjdog51.biome_enhancments.blocks.ModDoorBlock;
import io.github.killerjdog51.biome_enhancments.blocks.ModPressurePlateBlock;
import io.github.killerjdog51.biome_enhancments.blocks.ModSaplingBlock;
import io.github.killerjdog51.biome_enhancments.blocks.ModStandingSignBlock;
import io.github.killerjdog51.biome_enhancments.blocks.ModTrapDoorBlock;
import io.github.killerjdog51.biome_enhancments.blocks.ModWallSignBlock;
import io.github.killerjdog51.biome_enhancments.blocks.ModWoodButtonBlock;
import io.github.killerjdog51.biome_enhancments.blocks.PalmLeavesBlock;
import io.github.killerjdog51.biome_enhancments.blocks.PalmLogBlock;
import io.github.killerjdog51.biome_enhancments.blocks.trees.BaobabTree;
import io.github.killerjdog51.biome_enhancments.blocks.trees.MangroveTree;
import io.github.killerjdog51.biome_enhancments.blocks.trees.PalmTree;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.potion.Effects;

@SuppressWarnings("deprecation")
public class ModBlocks {

	//Blocks
	public static final Block BAOBAB_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD));
	public static final Block MANGROVE_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD));
	public static final Block PALM_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.SAND).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD));
	
	public static final Block BAOBAB_SAPLING = new ModSaplingBlock(new BaobabTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.PLANT));
	public static final Block MANGROVE_SAPLING = new MangroveSaplingBlock(new MangroveTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.PLANT));
	public static final Block PALM_SAPLING = new ModSaplingBlock(new PalmTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.PLANT));
	
	public static final Block DESERT_CANDLE = new FlowerBlock(Effects.ABSORPTION, 7, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.PLANT));
	
	public static final Block BAOBAB_LOG = new LogBlock(MaterialColor.ADOBE, Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0F).sound(SoundType.WOOD));
	public static final Block MANGROVE_LOG = new LogBlock(MaterialColor.OBSIDIAN, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD));
	public static final Block PALM_LOG = new PalmLogBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F).sound(SoundType.WOOD));

	public static final Block STRIPPED_BAOBAB_LOG = new LogBlock(MaterialColor.ADOBE, Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0F).sound(SoundType.WOOD));
	public static final Block STRIPPED_MANGROVE_LOG = new LogBlock(MaterialColor.OBSIDIAN, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD));
	public static final Block STRIPPED_PALM_LOG = new PalmLogBlock(Block.Properties.create(Material.WOOD, MaterialColor.SAND).hardnessAndResistance(2.0F).sound(SoundType.WOOD));

	public static final Block BAOBAB_WOOD = new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0F).sound(SoundType.WOOD));
	public static final Block MANGROVE_WOOD = new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD));
	public static final Block PALM_WOOD = new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F).sound(SoundType.WOOD));

	public static final Block STRIPPED_BAOBAB_WOOD = new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0F).sound(SoundType.WOOD));
	public static final Block STRIPPED_MANGROVE_WOOD = new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD));
	public static final Block STRIPPED_PALM_WOOD = new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.SAND).hardnessAndResistance(2.0F).sound(SoundType.WOOD));
	
	public static final Block BAOBAB_LEAVES = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT));
	public static final Block MANGROVE_LEAVES = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT));
	public static final Block PALM_LEAVES = new PalmLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT));
	
	public static final Block BAOBAB_STAIRS = new StairsBlock(() -> BAOBAB_PLANKS.getDefaultState(), Block.Properties.from(BAOBAB_PLANKS));
	public static final Block MANGROVE_STAIRS = new StairsBlock(() -> MANGROVE_PLANKS.getDefaultState(), Block.Properties.from(MANGROVE_PLANKS));
	public static final Block PALM_STAIRS = new StairsBlock(() -> PALM_PLANKS.getDefaultState(), Block.Properties.from(PALM_PLANKS));
	
	public static final Block BAOBAB_SLAB = new SlabBlock(Block.Properties.from(BAOBAB_PLANKS));
	public static final Block MANGROVE_SLAB = new SlabBlock(Block.Properties.from(MANGROVE_PLANKS));
	public static final Block PALM_SLAB = new SlabBlock(Block.Properties.from(PALM_PLANKS));

	public static final Block BAOBAB_FENCE = new FenceBlock(Block.Properties.from(BAOBAB_PLANKS));
	public static final Block MANGROVE_FENCE = new FenceBlock(Block.Properties.from(MANGROVE_PLANKS));
	public static final Block PALM_FENCE = new FenceBlock(Block.Properties.from(PALM_PLANKS));
	
	public static final Block BAOBAB_FENCE_GATE = new FenceGateBlock(Block.Properties.from(BAOBAB_PLANKS));
	public static final Block MANGROVE_FENCE_GATE = new FenceGateBlock(Block.Properties.from(MANGROVE_PLANKS));
	public static final Block PALM_FENCE_GATE = new FenceGateBlock(Block.Properties.from(PALM_PLANKS));
	
	public static final Block BAOBAB_PRESSURE_PLATE = new ModPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD));
	public static final Block MANGROVE_PRESSURE_PLATE = new ModPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD));
	public static final Block PALM_PRESSURE_PLATE = new ModPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.SAND).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD));
	
	public static final Block BAOBAB_BUTTON = new ModWoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD));
	public static final Block MANGROVE_BUTTON = new ModWoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD));
	public static final Block PALM_BUTTON = new ModWoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD));
	
	public static final Block POTTED_BAOBAB_SAPLING = new FlowerPotBlock(BAOBAB_SAPLING, Block.Properties.from(Blocks.FLOWER_POT));
	public static final Block POTTED_MANGROVE_SAPLING = new FlowerPotBlock(MANGROVE_SAPLING, Block.Properties.from(Blocks.FLOWER_POT));
	public static final Block POTTED_PALM_SAPLING = new FlowerPotBlock(PALM_SAPLING, Block.Properties.from(Blocks.FLOWER_POT));
	public static final Block POTTED_DESERT_CANDLE = new FlowerPotBlock(DESERT_CANDLE, Block.Properties.from(Blocks.FLOWER_POT));
	
	public static final Block BAOBAB_SIGN = new ModStandingSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD));
	public static final Block BAOBAB_WALL_SIGN = new ModWallSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD).lootFrom(BAOBAB_SIGN));
	public static final Block MANGROVE_SIGN = new ModStandingSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD));
	public static final Block MANGROVE_WALL_SIGN = new ModWallSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD).lootFrom(MANGROVE_SIGN));
	public static final Block PALM_SIGN = new ModStandingSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.SAND).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD));
	public static final Block PALM_WALL_SIGN = new ModWallSignBlock(Block.Properties.create(Material.WOOD, MaterialColor.SAND).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD).lootFrom(PALM_SIGN));
	
	public static final Block BAOBAB_TRAPDOOR = new ModTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(3.0F).sound(SoundType.WOOD));
	public static final Block MANGROVE_TRAPDOOR = new ModTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD));
	public static final Block PALM_TRAPDOOR = new ModTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.SAND).hardnessAndResistance(3.0F).sound(SoundType.WOOD));
	
	public static final Block BAOBAB_DOOR = new ModDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(3.0F).sound(SoundType.WOOD));
	public static final Block MANGROVE_DOOR = new ModDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD));
	public static final Block PALM_DOOR = new ModDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.SAND).hardnessAndResistance(3.0F).sound(SoundType.WOOD));


}
