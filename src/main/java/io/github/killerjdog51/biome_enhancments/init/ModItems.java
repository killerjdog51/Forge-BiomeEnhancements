package io.github.killerjdog51.biome_enhancments.init;

import io.github.killerjdog51.biome_enhancments.items.ModSignItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.TallBlockItem;

public class ModItems {

	//BlockItems
	public static final Item BAOBAB_PLANKS = new BlockItem(ModBlocks.BAOBAB_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MANGROVE_PLANKS = new BlockItem(ModBlocks.MANGROVE_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PALM_PLANKS = new BlockItem(ModBlocks.PALM_PLANKS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));

	public static final Item BAOBAB_SAPLING = new BlockItem(ModBlocks.BAOBAB_SAPLING, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item MANGROVE_SAPLING = new BlockItem(ModBlocks.MANGROVE_SAPLING, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item PALM_SAPLING = new BlockItem(ModBlocks.PALM_SAPLING, new Item.Properties().group(ItemGroup.DECORATIONS));
	
	public static final Item DESERT_CANDLE = new BlockItem(ModBlocks.DESERT_CANDLE, new Item.Properties().group(ItemGroup.DECORATIONS));

	public static final Item BAOBAB_LOG = new BlockItem(ModBlocks.BAOBAB_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MANGROVE_LOG = new BlockItem(ModBlocks.MANGROVE_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PALM_LOG = new BlockItem(ModBlocks.PALM_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));

	public static final Item STRIPPED_BAOBAB_LOG = new BlockItem(ModBlocks.STRIPPED_BAOBAB_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item STRIPPED_MANGROVE_LOG = new BlockItem(ModBlocks.STRIPPED_MANGROVE_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item STRIPPED_PALM_LOG = new BlockItem(ModBlocks.STRIPPED_PALM_LOG, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));

	public static final Item BAOBAB_WOOD = new BlockItem(ModBlocks.BAOBAB_WOOD, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MANGROVE_WOOD = new BlockItem(ModBlocks.MANGROVE_WOOD, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PALM_WOOD = new BlockItem(ModBlocks.PALM_WOOD, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));

	public static final Item STRIPPED_BAOBAB_WOOD = new BlockItem(ModBlocks.STRIPPED_BAOBAB_WOOD, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item STRIPPED_MANGROVE_WOOD = new BlockItem(ModBlocks.STRIPPED_MANGROVE_WOOD, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item STRIPPED_PALM_WOOD = new BlockItem(ModBlocks.STRIPPED_PALM_WOOD, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));

	public static final Item BAOBAB_LEAVES = new BlockItem(ModBlocks.BAOBAB_LEAVES, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item MANGROVE_LEAVES = new BlockItem(ModBlocks.MANGROVE_LEAVES, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item PALM_LEAVES = new BlockItem(ModBlocks.PALM_LEAVES, new Item.Properties().group(ItemGroup.DECORATIONS));

	public static final Item BAOBAB_STAIRS = new BlockItem(ModBlocks.BAOBAB_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MANGROVE_STAIRS = new BlockItem(ModBlocks.MANGROVE_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PALM_STAIRS = new BlockItem(ModBlocks.PALM_STAIRS, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	
	public static final Item BAOBAB_SLAB = new BlockItem(ModBlocks.BAOBAB_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item MANGROVE_SLAB = new BlockItem(ModBlocks.MANGROVE_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	public static final Item PALM_SLAB = new BlockItem(ModBlocks.PALM_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));

	public static final Item BAOBAB_FENCE = new BlockItem(ModBlocks.BAOBAB_FENCE, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item MANGROVE_FENCE = new BlockItem(ModBlocks.MANGROVE_FENCE, new Item.Properties().group(ItemGroup.DECORATIONS));
	public static final Item PALM_FENCE = new BlockItem(ModBlocks.PALM_FENCE, new Item.Properties().group(ItemGroup.DECORATIONS));

	public static final Item BAOBAB_FENCE_GATE = new BlockItem(ModBlocks.BAOBAB_FENCE_GATE, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item MANGROVE_FENCE_GATE = new BlockItem(ModBlocks.MANGROVE_FENCE_GATE, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item PALM_FENCE_GATE = new BlockItem(ModBlocks.PALM_FENCE_GATE, new Item.Properties().group(ItemGroup.REDSTONE));

	public static final Item BAOBAB_PRESSURE_PLATE = new BlockItem(ModBlocks.BAOBAB_PRESSURE_PLATE, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item MANGROVE_PRESSURE_PLATE = new BlockItem(ModBlocks.MANGROVE_PRESSURE_PLATE, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item PALM_PRESSURE_PLATE = new BlockItem(ModBlocks.PALM_PRESSURE_PLATE, new Item.Properties().group(ItemGroup.REDSTONE));

	public static final Item BAOBAB_BUTTON = new BlockItem(ModBlocks.BAOBAB_BUTTON, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item MANGROVE_BUTTON = new BlockItem(ModBlocks.MANGROVE_BUTTON, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item PALM_BUTTON = new BlockItem(ModBlocks.PALM_BUTTON, new Item.Properties().group(ItemGroup.REDSTONE));
	
	public static final Item BAOBAB_SIGN = new ModSignItem(new Item.Properties().maxStackSize(16).group(ItemGroup.DECORATIONS), ModBlocks.BAOBAB_SIGN, ModBlocks.BAOBAB_WALL_SIGN);
	public static final Item MANGROVE_SIGN = new ModSignItem(new Item.Properties().maxStackSize(16).group(ItemGroup.DECORATIONS), ModBlocks.MANGROVE_SIGN, ModBlocks.MANGROVE_WALL_SIGN);
	public static final Item PALM_SIGN = new ModSignItem(new Item.Properties().maxStackSize(16).group(ItemGroup.DECORATIONS), ModBlocks.PALM_SIGN, ModBlocks.PALM_WALL_SIGN);
	
	public static final Item BAOBAB_TRAPDOOR = new BlockItem(ModBlocks.BAOBAB_TRAPDOOR, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item MANGROVE_TRAPDOOR = new BlockItem(ModBlocks.MANGROVE_TRAPDOOR, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item PALM_TRAPDOOR = new BlockItem(ModBlocks.PALM_TRAPDOOR, new Item.Properties().group(ItemGroup.REDSTONE));

	public static final Item BAOBAB_DOOR = new TallBlockItem(ModBlocks.BAOBAB_DOOR, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item MANGROVE_DOOR = new TallBlockItem(ModBlocks.MANGROVE_DOOR, new Item.Properties().group(ItemGroup.REDSTONE));
	public static final Item PALM_DOOR = new TallBlockItem(ModBlocks.PALM_DOOR, new Item.Properties().group(ItemGroup.REDSTONE));

}
