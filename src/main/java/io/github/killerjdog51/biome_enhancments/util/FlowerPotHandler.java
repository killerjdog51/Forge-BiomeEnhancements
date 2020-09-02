package io.github.killerjdog51.biome_enhancments.util;

import io.github.killerjdog51.biome_enhancments.init.ModBlocks;
import io.github.killerjdog51.biome_enhancments.init.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

// Since Forge uses it's own registry to register blocks and items, it is necessary to use a function for the flower pots.
// Fabric uses Minecraft's native registry, so plants/saplings/flowers are automatically handled
public class FlowerPotHandler {

	@SubscribeEvent
	public void PlaceFlowerPot(PlayerInteractEvent.RightClickBlock event)
	{
		// Get block, player, and world variables
		BlockPos pos = event.getPos();
		World world = event.getWorld();
		ItemStack itemstack = event.getItemStack();
		PlayerEntity player = event.getPlayer();
		
		// If the block being right-clicked on is a flower pot continue
		if (world.getBlockState(pos).getBlock() == Blocks.FLOWER_POT)
		{
			// Replace the flower pot with the flower pot containing the corresponding plant in hand
			if (itemstack.getItem() == ModItems.BAOBAB_SAPLING)
			{
				world.setBlockState(pos, ModBlocks.POTTED_BAOBAB_SAPLING.getDefaultState());
				
				// If the player isn't in creative subtract the quantity of the plant in hand
				if(!player.abilities.isCreativeMode)
				{
					itemstack.shrink(1);
				}
			}
			
			if (itemstack.getItem() == ModItems.MANGROVE_SAPLING)
			{
				world.setBlockState(pos, ModBlocks.POTTED_MANGROVE_SAPLING.getDefaultState());
				if(!player.abilities.isCreativeMode)
				{
					itemstack.shrink(1);
				}
			}
			
			if (itemstack.getItem() == ModItems.PALM_SAPLING)
			{
				world.setBlockState(pos, ModBlocks.POTTED_PALM_SAPLING.getDefaultState());
				if(!player.abilities.isCreativeMode)
				{
					itemstack.shrink(1);
				}
			}
			
			if (itemstack.getItem() == ModItems.DESERT_CANDLE)
			{
				world.setBlockState(pos, ModBlocks.POTTED_DESERT_CANDLE.getDefaultState());
				if(!player.abilities.isCreativeMode)
				{
					itemstack.shrink(1);
				}
			}
		}
	}
}
