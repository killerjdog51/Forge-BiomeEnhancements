package io.github.killerjdog51.biome_enhancments.items;

import javax.annotation.Nullable;

import io.github.killerjdog51.biome_enhancments.tileentity.ModSignTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SignItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModSignItem extends SignItem{

	public ModSignItem(Properties propertiesIn, Block floorBlockIn, Block wallBlockIn) {
		super(propertiesIn, floorBlockIn, wallBlockIn);
	}

	@Override
	protected boolean onBlockPlaced(BlockPos pos, World worldIn, @Nullable PlayerEntity player, ItemStack stack, BlockState state) {
	      boolean flag = super.onBlockPlaced(pos, worldIn, player, stack, state);
	      if (!worldIn.isRemote && !flag && player != null) {
	         player.openSignEditor((ModSignTileEntity)worldIn.getTileEntity(pos));
	      }

	      return flag;
	   }
}
