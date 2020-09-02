package io.github.killerjdog51.biome_enhancments.items;

import java.util.List;
import java.util.function.Predicate;

import io.github.killerjdog51.biome_enhancments.entity.boat.ModBoatEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ModBoatItem extends Item
{

   private static final Predicate<Entity> RIDERS = EntityPredicates.NOT_SPECTATING.and(Entity::canBeCollidedWith);
   private final ModBoatEntity.Type TYPE;

	public ModBoatItem(ModBoatEntity.Type typeIn, Properties properties)
	{
		super(properties);
		this.TYPE = typeIn;
	}

	
   /**
    * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
    * {@link #onItemUse}.
    */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.ANY);
		if (raytraceresult.getType() == RayTraceResult.Type.MISS)
		{
			return new ActionResult<>(ActionResultType.PASS, itemstack);
		}
		else
		{
			Vec3d vec3d = playerIn.getLook(1.0F);
			List<Entity> list = worldIn.getEntitiesInAABBexcluding(playerIn, playerIn.getBoundingBox().expand(vec3d.scale(5.0D)).grow(1.0D), RIDERS);
			if (!list.isEmpty())
			{
				Vec3d vec3d1 = playerIn.getEyePosition(1.0F);

				for(Entity entity : list)
				{
					AxisAlignedBB axisalignedbb = entity.getBoundingBox().grow((double)entity.getCollisionBorderSize());
					if (axisalignedbb.contains(vec3d1))
					{
						return new ActionResult<>(ActionResultType.PASS, itemstack);
					}
				}
			}

			if (raytraceresult.getType() == RayTraceResult.Type.BLOCK)
			{
				ModBoatEntity boatentity = new ModBoatEntity(worldIn, raytraceresult.getHitVec().x, raytraceresult.getHitVec().y, raytraceresult.getHitVec().z);
				boatentity.setModBoatType(this.TYPE);
				boatentity.rotationYaw = playerIn.rotationYaw;
				if (!worldIn.isCollisionBoxesEmpty(boatentity, boatentity.getBoundingBox().grow(-0.1D)))
				{
					return new ActionResult<>(ActionResultType.FAIL, itemstack);
				}
				else
				{
					if (!worldIn.isRemote)
					{
						worldIn.addEntity(boatentity);
					}

					if (!playerIn.abilities.isCreativeMode)
					{
						itemstack.shrink(1);
					}

					playerIn.addStat(Stats.ITEM_USED.get(this));
					return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
				}
			}
			else
			{
				return new ActionResult<>(ActionResultType.PASS, itemstack);
			}
		}
	}
}
