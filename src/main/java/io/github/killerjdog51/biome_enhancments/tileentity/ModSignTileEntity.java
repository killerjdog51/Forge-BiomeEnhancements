package io.github.killerjdog51.biome_enhancments.tileentity;

import io.github.killerjdog51.biome_enhancments.init.ModTileEntityTypes;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;

public class ModSignTileEntity extends SignTileEntity
{
	@Override
	public TileEntityType<?> getType() {
	      return ModTileEntityTypes.SIGN;
	   }

}
