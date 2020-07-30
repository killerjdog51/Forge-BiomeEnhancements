package io.github.killerjdog51.biome_enhancments.util;

import io.github.killerjdog51.biome_enhancments.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.BlockItem;
import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class BlockColorHandler
{
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public void registerBlockColourHandlers(final ColorHandlerEvent.Block event)
	{
		// Use the grass colour of the biome or the default grass colour
		final IBlockColor grassColourHandler = (state, blockAccess, pos, tintIndex) -> {
			
			if (blockAccess != null && pos != null)
			{
				return BiomeColors.getFoliageColor(blockAccess, pos);
			}

			return GrassColors.get(0.5D, 1.0D);
		};

		event.getBlockColors().register(grassColourHandler, ModBlocks.BAOBAB_LEAVES, ModBlocks.MANGROVE_LEAVES, ModBlocks.PALM_LEAVES);
	}
	
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public void registerItemColourHandlers(final ColorHandlerEvent.Item event)
	{
		// Use the Block's colour handler for an ItemBlock
		final IItemColor itemBlockColourHandler = (stack, tintIndex) -> {
			BlockState iblockstate = ((BlockItem) stack.getItem()).getBlock().getDefaultState();
			return event.getBlockColors().getColor(iblockstate, null, null, tintIndex);
		};

		event.getItemColors().register(itemBlockColourHandler, ModBlocks.BAOBAB_LEAVES, ModBlocks.MANGROVE_LEAVES, ModBlocks.PALM_LEAVES);
	}

}
