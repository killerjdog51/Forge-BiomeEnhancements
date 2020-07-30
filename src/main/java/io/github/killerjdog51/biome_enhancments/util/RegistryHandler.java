package io.github.killerjdog51.biome_enhancments.util;

import io.github.killerjdog51.biome_enhancments.BiomeEnhancements;
import io.github.killerjdog51.biome_enhancments.init.ModBlocks;
import io.github.killerjdog51.biome_enhancments.init.ModItems;
import io.github.killerjdog51.biome_enhancments.init.ModTileEntityTypes;
import io.github.killerjdog51.biome_enhancments.init.WorldGeneration;
import io.github.killerjdog51.biome_enhancments.tileentity.ModSignTileEntity;
import io.github.killerjdog51.biome_enhancments.tileentity.ModSignTileEntityRenderer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, BiomeEnhancements.MOD_ID);
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, BiomeEnhancements.MOD_ID);
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, BiomeEnhancements.MOD_ID);
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, BiomeEnhancements.MOD_ID);

	public static void init()
	{
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
		TILE_ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
		ClientRegistry.bindTileEntitySpecialRenderer(ModSignTileEntity.class, new ModSignTileEntityRenderer());

	}
	//Items
	   //public static final RegistryObject<Item> Example = ITEMS.register("example", ItemBase::new);
	
	//Blocks
		public static final RegistryObject<Block> BAOBAB_PLANKS = BLOCKS.register("baobab_planks", () -> ModBlocks.BAOBAB_PLANKS);
		public static final RegistryObject<Block> MANGROVE_PLANKS = BLOCKS.register("mangrove_planks", () -> ModBlocks.MANGROVE_PLANKS);
		public static final RegistryObject<Block> PALM_PLANKS = BLOCKS.register("palm_planks", () -> ModBlocks.PALM_PLANKS);
		
		public static final RegistryObject<Block> BAOBAB_SAPLING = BLOCKS.register("baobab_sapling", () -> ModBlocks.BAOBAB_SAPLING);
		public static final RegistryObject<Block> MANGROVE_SAPLING = BLOCKS.register("mangrove_sapling",  () -> ModBlocks.MANGROVE_SAPLING);
		public static final RegistryObject<Block> PALM_SAPLING = BLOCKS.register("palm_sapling",  () -> ModBlocks.PALM_SAPLING);
		
		public static final RegistryObject<Block> DESERT_CANDLE = BLOCKS.register("desert_candle", () -> ModBlocks.DESERT_CANDLE);
		
		public static final RegistryObject<Block> BAOBAB_LOG = BLOCKS.register("baobab_log", () -> ModBlocks.BAOBAB_LOG);
		public static final RegistryObject<Block> MANGROVE_LOG = BLOCKS.register("mangrove_log", () -> ModBlocks.MANGROVE_LOG);
		public static final RegistryObject<Block> PALM_LOG = BLOCKS.register("palm_log", () -> ModBlocks.PALM_LOG);
		
		public static final RegistryObject<Block> BAOBAB_WOOD = BLOCKS.register("baobab_wood", () -> ModBlocks.BAOBAB_WOOD);
		public static final RegistryObject<Block> MANGROVE_WOOD = BLOCKS.register("mangrove_wood", () -> ModBlocks.MANGROVE_WOOD);
		public static final RegistryObject<Block> PALM_WOOD = BLOCKS.register("palm_wood", () -> ModBlocks.PALM_WOOD);
		
		public static final RegistryObject<Block> STRIPPED_BAOBAB_LOG = BLOCKS.register("stripped_baobab_log", () -> ModBlocks.STRIPPED_BAOBAB_LOG);
		public static final RegistryObject<Block> STRIPPED_MANGROVE_LOG = BLOCKS.register("stripped_mangrove_log", () -> ModBlocks.STRIPPED_MANGROVE_LOG);
		public static final RegistryObject<Block> STRIPPED_PALM_LOG = BLOCKS.register("stripped_palm_log", () -> ModBlocks.STRIPPED_PALM_LOG);
		
		public static final RegistryObject<Block> STRIPPED_BAOBAB_WOOD = BLOCKS.register("stripped_baobab_wood", () -> ModBlocks.STRIPPED_BAOBAB_WOOD);
		public static final RegistryObject<Block> STRIPPED_MANGROVE_WOOD = BLOCKS.register("stripped_mangrove_wood", () -> ModBlocks.STRIPPED_MANGROVE_WOOD);
		public static final RegistryObject<Block> STRIPPED_PALM_WOOD = BLOCKS.register("stripped_palm_wood", () -> ModBlocks.STRIPPED_PALM_WOOD);
		
		public static final RegistryObject<Block> BAOBAB_LEAVES = BLOCKS.register("baobab_leaves", () -> ModBlocks.BAOBAB_LEAVES);
		public static final RegistryObject<Block> MANGROVE_LEAVES = BLOCKS.register("mangrove_leaves", () -> ModBlocks.MANGROVE_LEAVES);
		public static final RegistryObject<Block> PALM_LEAVES = BLOCKS.register("palm_leaves", () -> ModBlocks.PALM_LEAVES);
		
		public static final RegistryObject<Block> BAOBAB_STAIRS = BLOCKS.register("baobab_stairs", () -> ModBlocks.BAOBAB_STAIRS);
		public static final RegistryObject<Block> MANGROVE_STAIRS = BLOCKS.register("mangrove_stairs", () -> ModBlocks.MANGROVE_STAIRS);
		public static final RegistryObject<Block> PALM_STAIRS = BLOCKS.register("palm_stairs", () -> ModBlocks.PALM_STAIRS);
		
		public static final RegistryObject<Block> BAOBAB_SLAB = BLOCKS.register("baobab_slab", () -> ModBlocks.BAOBAB_SLAB);
		public static final RegistryObject<Block> MANGROVE_SLAB = BLOCKS.register("mangrove_slab", () -> ModBlocks.MANGROVE_SLAB);
		public static final RegistryObject<Block> PALM_SLAB = BLOCKS.register("palm_slab", () -> ModBlocks.PALM_SLAB);
		
		public static final RegistryObject<Block> BAOBAB_FENCE = BLOCKS.register("baobab_fence", () -> ModBlocks.BAOBAB_FENCE);
		public static final RegistryObject<Block> MANGROVE_FENCE = BLOCKS.register("mangrove_fence", () -> ModBlocks.MANGROVE_FENCE);
		public static final RegistryObject<Block> PALM_FENCE = BLOCKS.register("palm_fence", () -> ModBlocks.PALM_FENCE);
		
		public static final RegistryObject<Block> BAOBAB_FENCE_GATE = BLOCKS.register("baobab_fence_gate", () -> ModBlocks.BAOBAB_FENCE_GATE);
		public static final RegistryObject<Block> MANGROVE_FENCE_GATE = BLOCKS.register("mangrove_fence_gate", () -> ModBlocks.MANGROVE_FENCE_GATE);
		public static final RegistryObject<Block> PALM_FENCE_GATE = BLOCKS.register("palm_fence_gate", () -> ModBlocks.PALM_FENCE_GATE);
		
		public static final RegistryObject<Block> BAOBAB_PRESSURE_PLATE = BLOCKS.register("baobab_pressure_plate", () -> ModBlocks.BAOBAB_PRESSURE_PLATE);
		public static final RegistryObject<Block> MANGROVE_PRESSURE_PLATE = BLOCKS.register("mangrove_pressure_plate", () -> ModBlocks.MANGROVE_PRESSURE_PLATE);
		public static final RegistryObject<Block> PALM_PRESSURE_PLATE = BLOCKS.register("palm_pressure_plate", () -> ModBlocks.PALM_PRESSURE_PLATE);
		
		public static final RegistryObject<Block> BAOBAB_BUTTON = BLOCKS.register("baobab_button", () -> ModBlocks.BAOBAB_BUTTON);
		public static final RegistryObject<Block> MANGROVE_BUTTON = BLOCKS.register("mangrove_button", () -> ModBlocks.MANGROVE_BUTTON);
		public static final RegistryObject<Block> PALM_BUTTON = BLOCKS.register("palm_button", () -> ModBlocks.PALM_BUTTON);
		
		public static final RegistryObject<Block> POTTED_BAOBAB_SAPLING = BLOCKS.register("potted_baobab_sapling", () -> ModBlocks.POTTED_BAOBAB_SAPLING);
		public static final RegistryObject<Block> POTTED_MANGROVE_SAPLING = BLOCKS.register("potted_mangrove_sapling", () -> ModBlocks.POTTED_MANGROVE_SAPLING);
		public static final RegistryObject<Block> POTTED_PALM_SAPLING = BLOCKS.register("potted_palm_sapling", () -> ModBlocks.POTTED_PALM_SAPLING);
		public static final RegistryObject<Block> POTTED_DESERT_CANDLE = BLOCKS.register("potted_desert_candle", () -> ModBlocks.POTTED_DESERT_CANDLE);
		
		public static final RegistryObject<Block> BAOBAB_SIGN = BLOCKS.register("baobab_sign", () -> ModBlocks.BAOBAB_SIGN);
		public static final RegistryObject<Block> BAOBAB_WALL_SIGN = BLOCKS.register("baobab_wall_sign", () -> ModBlocks.BAOBAB_WALL_SIGN);
		public static final RegistryObject<Block> MANGROVE_SIGN = BLOCKS.register("mangrove_sign", () -> ModBlocks.MANGROVE_SIGN);
		public static final RegistryObject<Block> MANGROVE_WALL_SIGN = BLOCKS.register("mangrove_wall_sign", () -> ModBlocks.MANGROVE_WALL_SIGN);
		public static final RegistryObject<Block> PALM_SIGN = BLOCKS.register("palm_sign", () -> ModBlocks.PALM_SIGN);
		public static final RegistryObject<Block> PALM_WALL_SIGN = BLOCKS.register("palm_wall_sign", () -> ModBlocks.PALM_WALL_SIGN);
		
		public static final RegistryObject<Block> BAOBAB_DOOR = BLOCKS.register("baobab_door", () -> ModBlocks.BAOBAB_DOOR);
		public static final RegistryObject<Block> MANGROVE_DOOR = BLOCKS.register("mangrove_door", () -> ModBlocks.MANGROVE_DOOR);
		public static final RegistryObject<Block> PALM_DOOR = BLOCKS.register("palm_door", () -> ModBlocks.PALM_DOOR);
		
		public static final RegistryObject<Block> BAOBAB_TRAPDOOR = BLOCKS.register("baobab_trapdoor", () -> ModBlocks.BAOBAB_TRAPDOOR);
		public static final RegistryObject<Block> MANGROVE_TRAPDOOR = BLOCKS.register("mangrove_trapdoor", () -> ModBlocks.MANGROVE_TRAPDOOR);
		public static final RegistryObject<Block> PALM_TRAPDOOR = BLOCKS.register("palm_trapdoor", () -> ModBlocks.PALM_TRAPDOOR);

	//ItemBlocks
		public static final RegistryObject<Item> BAOBAB_PLANKS_ITEM = ITEMS.register("baobab_planks", () -> ModItems.BAOBAB_PLANKS);
		public static final RegistryObject<Item> MANGROVE_PLANKS_ITEM = ITEMS.register("mangrove_planks", () -> ModItems.MANGROVE_PLANKS);
		public static final RegistryObject<Item> PALM_PLANKS_ITEM = ITEMS.register("palm_planks", () -> ModItems.PALM_PLANKS);
		
		public static final RegistryObject<Item> BAOBAB_SAPLING_ITEM = ITEMS.register("baobab_sapling", () -> ModItems.BAOBAB_SAPLING);
		public static final RegistryObject<Item> MANGROVE_SAPLING_ITEM = ITEMS.register("mangrove_sapling",  () -> ModItems.MANGROVE_SAPLING);
		public static final RegistryObject<Item> PALM_SAPLING_ITEM = ITEMS.register("palm_sapling",  () -> ModItems.PALM_SAPLING);
		
		public static final RegistryObject<Item> DESERT_CANDLE_ITEM = ITEMS.register("desert_candle", () -> ModItems.DESERT_CANDLE);

		public static final RegistryObject<Item> BAOBAB_LOG_ITEM = ITEMS.register("baobab_log", () -> ModItems.BAOBAB_LOG);
		public static final RegistryObject<Item> MANGROVE_LOG_ITEM = ITEMS.register("mangrove_log", () -> ModItems.MANGROVE_LOG);
		public static final RegistryObject<Item> PALM_LOG_ITEM = ITEMS.register("palm_log", () -> ModItems.PALM_LOG);
		
		public static final RegistryObject<Item> BAOBAB_WOOD_ITEM = ITEMS.register("baobab_wood", () -> ModItems.BAOBAB_WOOD);
		public static final RegistryObject<Item> MANGROVE_WOOD_ITEM = ITEMS.register("mangrove_wood", () -> ModItems.MANGROVE_WOOD);
		public static final RegistryObject<Item> PALM_WOOD_ITEM = ITEMS.register("palm_wood", () -> ModItems.PALM_WOOD);
		
		public static final RegistryObject<Item> STRIPPED_BAOBAB_LOG_ITEM = ITEMS.register("stripped_baobab_log", () -> ModItems.STRIPPED_BAOBAB_LOG);
		public static final RegistryObject<Item> STRIPPED_MANGROVE_LOG_ITEM = ITEMS.register("stripped_mangrove_log", () -> ModItems.STRIPPED_MANGROVE_LOG);
		public static final RegistryObject<Item> STRIPPED_PALM_LOG_ITEM = ITEMS.register("stripped_palm_log", () -> ModItems.STRIPPED_PALM_LOG);
		
		public static final RegistryObject<Item> STRIPPED_BAOBAB_WOOD_ITEM = ITEMS.register("stripped_baobab_wood", () -> ModItems.STRIPPED_BAOBAB_WOOD);
		public static final RegistryObject<Item> STRIPPED_MANGROVE_WOOD_ITEM = ITEMS.register("stripped_mangrove_wood", () -> ModItems.STRIPPED_MANGROVE_WOOD);
		public static final RegistryObject<Item> STRIPPED_PALM_WOOD_ITEM = ITEMS.register("stripped_palm_wood", () -> ModItems.STRIPPED_PALM_WOOD);
		
		public static final RegistryObject<Item> BAOBAB_LEAVES_ITEM = ITEMS.register("baobab_leaves", () -> ModItems.BAOBAB_LEAVES);
		public static final RegistryObject<Item> MANGROVE_LEAVES_ITEM = ITEMS.register("mangrove_leaves", () -> ModItems.MANGROVE_LEAVES);
		public static final RegistryObject<Item> PALM_LEAVES_ITEM = ITEMS.register("palm_leaves", () -> ModItems.PALM_LEAVES);
		
		public static final RegistryObject<Item> BAOBAB_STAIRS_ITEM = ITEMS.register("baobab_stairs", () -> ModItems.BAOBAB_STAIRS);
		public static final RegistryObject<Item> MANGROVE_STAIRS_ITEM = ITEMS.register("mangrove_stairs", () -> ModItems.MANGROVE_STAIRS);
		public static final RegistryObject<Item> PALM_STAIRS_ITEM = ITEMS.register("palm_stairs", () -> ModItems.PALM_STAIRS);
		
		public static final RegistryObject<Item> BAOBAB_SLAB_ITEM = ITEMS.register("baobab_slab", () -> ModItems.BAOBAB_SLAB);
		public static final RegistryObject<Item> MANGROVE_SLAB_ITEM = ITEMS.register("mangrove_slab", () -> ModItems.MANGROVE_SLAB);
		public static final RegistryObject<Item> PALM_SLAB_ITEM = ITEMS.register("palm_slab", () -> ModItems.PALM_SLAB);
		
		public static final RegistryObject<Item> BAOBAB_FENCE_ITEM = ITEMS.register("baobab_fence", () -> ModItems.BAOBAB_FENCE);
		public static final RegistryObject<Item> MANGROVE_FENCE_ITEM = ITEMS.register("mangrove_fence", () -> ModItems.MANGROVE_FENCE);
		public static final RegistryObject<Item> PALM_FENCE_ITEM = ITEMS.register("palm_fence", () -> ModItems.PALM_FENCE);
		
		public static final RegistryObject<Item> BAOBAB_FENCE_GATE_ITEM = ITEMS.register("baobab_fence_gate", () -> ModItems.BAOBAB_FENCE_GATE);
		public static final RegistryObject<Item> MANGROVE_FENCE_GATE_ITEM = ITEMS.register("mangrove_fence_gate", () -> ModItems.MANGROVE_FENCE_GATE);
		public static final RegistryObject<Item> PALM_FENCE_GATE_ITEM = ITEMS.register("palm_fence_gate", () -> ModItems.PALM_FENCE_GATE);
		
		public static final RegistryObject<Item> BAOBAB_PRESSURE_PLATE_ITEM = ITEMS.register("baobab_pressure_plate", () -> ModItems.BAOBAB_PRESSURE_PLATE);
		public static final RegistryObject<Item> MANGROVE_PRESSURE_PLATE_ITEM = ITEMS.register("mangrove_pressure_plate", () -> ModItems.MANGROVE_PRESSURE_PLATE);
		public static final RegistryObject<Item> PALM_PRESSURE_PLATE_ITEM = ITEMS.register("palm_pressure_plate", () -> ModItems.PALM_PRESSURE_PLATE);
		
		public static final RegistryObject<Item> BAOBAB_BUTTON_ITEM = ITEMS.register("baobab_button", () -> ModItems.BAOBAB_BUTTON);
		public static final RegistryObject<Item> MANGROVE_BUTTON_ITEM = ITEMS.register("mangrove_button", () -> ModItems.MANGROVE_BUTTON);
		public static final RegistryObject<Item> PALM_BUTTON_ITEM = ITEMS.register("palm_button", () -> ModItems.PALM_BUTTON);
		
		public static final RegistryObject<Item> BAOBAB_SIGN_ITEM = ITEMS.register("baobab_sign", () -> ModItems.BAOBAB_SIGN);
		public static final RegistryObject<Item> MANGROVE_SIGN_ITEM = ITEMS.register("mangrove_sign", () -> ModItems.MANGROVE_SIGN);
		public static final RegistryObject<Item> PALM_SIGN_ITEM = ITEMS.register("palm_sign", () -> ModItems.PALM_SIGN);
		
		public static final RegistryObject<Item> BAOBAB_DOOR_ITEM = ITEMS.register("baobab_door", () -> ModItems.BAOBAB_DOOR);
		public static final RegistryObject<Item> MANGROVE_DOOR_ITEM = ITEMS.register("mangrove_door", () -> ModItems.MANGROVE_DOOR);
		public static final RegistryObject<Item> PALM_DOOR_ITEM = ITEMS.register("palm_door", () -> ModItems.PALM_DOOR);
		
		public static final RegistryObject<Item> BAOBAB_TRAPDOOR_ITEM = ITEMS.register("baobab_trapdoor", () -> ModItems.BAOBAB_TRAPDOOR);
		public static final RegistryObject<Item> MANGROVE_TRAPDOOR_ITEM = ITEMS.register("mangrove_trapdoor", () -> ModItems.MANGROVE_TRAPDOOR);
		public static final RegistryObject<Item> PALM_TRAPDOOR_ITEM = ITEMS.register("palm_trapdoor", () -> ModItems.PALM_TRAPDOOR);
		
		//Biomes
		public static final RegistryObject<Biome> OASIS_BIOME = BIOMES.register("oasis",  () -> WorldGeneration.OASIS);
		
		//Tile Entities
		public static final RegistryObject<TileEntityType<ModSignTileEntity>> SIGN = TILE_ENTITY_TYPES.register("sign", () -> ModTileEntityTypes.SIGN);
}
