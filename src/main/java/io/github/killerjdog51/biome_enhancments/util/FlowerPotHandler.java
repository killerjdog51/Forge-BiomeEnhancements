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

public class FlowerPotHandler {

	@SubscribeEvent
	public void PlaceFlowerPot(PlayerInteractEvent.RightClickBlock event)
	{
		BlockPos pos = event.getPos();
		World world = event.getWorld();
		ItemStack itemstack = event.getItemStack();
		PlayerEntity player = event.getPlayer();
		
		if (world.getBlockState(pos).getBlock() == Blocks.FLOWER_POT)
		{
			if (itemstack.getItem() == ModItems.BAOBAB_SAPLING)
			{
				world.setBlockState(pos, ModBlocks.POTTED_BAOBAB_SAPLING.getDefaultState());
				if(!player.isCreative())
				{
					itemstack.setCount(itemstack.getCount()-1);
				}
			}
			
			if (itemstack.getItem() == ModItems.MANGROVE_SAPLING)
			{
				world.setBlockState(pos, ModBlocks.POTTED_MANGROVE_SAPLING.getDefaultState());
				if(!player.isCreative())
				{
					itemstack.setCount(itemstack.getCount()-1);
				}
			}
			
			if (itemstack.getItem() == ModItems.PALM_SAPLING)
			{
				world.setBlockState(pos, ModBlocks.POTTED_PALM_SAPLING.getDefaultState());
				if(!player.isCreative())
				{
					itemstack.setCount(itemstack.getCount()-1);
				}
			}
			
			if (itemstack.getItem() == ModItems.DESERT_CANDLE)
			{
				world.setBlockState(pos, ModBlocks.POTTED_DESERT_CANDLE.getDefaultState());
				if(!player.isCreative())
				{
					itemstack.setCount(itemstack.getCount()-1);
				}
			}
		}
	}
}
