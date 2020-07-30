package io.github.killerjdog51.biome_enhancments.blocks;

import net.minecraft.block.BlockState;

public class PalmLogBlock extends RotatedBlock
{

	public PalmLogBlock(Properties properties) {
		super(properties);
	}

	@Override
	public boolean isSolid(BlockState state)
	{
		return false;
	}

}
