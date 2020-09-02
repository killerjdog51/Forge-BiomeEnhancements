package io.github.killerjdog51.biome_enhancments.entity.boat;

import io.github.killerjdog51.biome_enhancments.init.ModEntityTypes;
import io.github.killerjdog51.biome_enhancments.init.ModItems;
import io.github.killerjdog51.biome_enhancments.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class ModChestBoatEntity extends BoatEntity
{
	private static final DataParameter<Integer> BOAT_TYPE = EntityDataManager.createKey(ModChestBoatEntity.class, DataSerializers.VARINT);
	private BoatEntity.Status status;
	private double lastYd;



	public ModChestBoatEntity(EntityType<? extends BoatEntity> entity, World worldIn)
	{
		super(entity, worldIn);
	}

	public ModChestBoatEntity(World worldIn, double x, double y, double z)
	{
	      this(ModEntityTypes.BOAT, worldIn);
	      this.setPosition(x, y, z);
	      this.setMotion(Vec3d.ZERO);
	      this.prevPosX = x;
	      this.prevPosY = y;
	      this.prevPosZ = z;
	   }
	
	@Override
	protected void registerData()
	{
		   super.registerData();
		   this.dataManager.register(BOAT_TYPE, ModChestBoatEntity.Type.OAK.ordinal());
	}
	   
	/**
	    * Called when the entity is attacked.
	    */
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		if (this.isInvulnerableTo(source))
		{
			return false;
		}
		else if (!this.world.isRemote && !this.removed)
		{
			if (source instanceof IndirectEntityDamageSource && source.getTrueSource() != null && this.isPassenger(source.getTrueSource()))
			{
				return false;
			}
			else
			{
				this.setForwardDirection(-this.getForwardDirection());
				this.setTimeSinceHit(10);
				this.setDamageTaken(this.getDamageTaken() + amount * 10.0F);
				this.markVelocityChanged();
				boolean flag = source.getTrueSource() instanceof PlayerEntity && ((PlayerEntity)source.getTrueSource()).abilities.isCreativeMode;
				
				if (flag || this.getDamageTaken() > 40.0F)
				{
					if (!flag && this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS))
					{
						this.entityDropItem(Items.CHEST);
						this.entityDropItem(this.getItemBoat());
					}

					this.remove();
				}

				return true;
			}
		}
		else
		{
			return true;
		}
	}	
	
	@Override
	public Item getItemBoat()
	{
		switch(this.getModBoatType())
		{
			case OAK:
			default:
				return Items.OAK_BOAT;
			case SPRUCE:
				return Items.SPRUCE_BOAT;
			case BIRCH:
				return Items.BIRCH_BOAT;
			case JUNGLE:
				return Items.JUNGLE_BOAT;
			case ACACIA:
				return Items.ACACIA_BOAT;
			case DARK_OAK:
				return Items.DARK_OAK_BOAT;
			case BAOBAB:
				return ModItems.BAOBAB_BOAT;
			case MANGROVE:
				return ModItems.MANGROVE_BOAT;
			case PALM:
				return ModItems.PALM_BOAT;

		}
	}
	
	@Override
	protected void writeAdditional(CompoundNBT compound)
	{
	      compound.putString("Type", this.getModBoatType().getName());
	   }

	@Override
	protected void readAdditional(CompoundNBT compound)
	{
	   if (compound.contains("Type", 8))
	   {
		   this.setModBoatType(ModChestBoatEntity.Type.getTypeFromString(compound.getString("Type")));
		   
		   }

	   }
	
	@Override
   protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	      this.lastYd = this.getMotion().y;
	      if (!this.isPassenger()) {
	         if (onGroundIn) {
	            if (this.fallDistance > 3.0F) {
	               if (this.status != ModBoatEntity.Status.ON_LAND) {
	                  this.fallDistance = 0.0F;
	                  return;
	               }

	               this.fall(this.fallDistance, 1.0F);
	               if (!this.world.isRemote && !this.removed) {
	                  this.remove();
	                  if (this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
	                     for(int i = 0; i < 3; ++i) {
	                        this.entityDropItem(this.getModBoatType().asPlank());
	                     }

	                     for(int j = 0; j < 2; ++j) {
	                        this.entityDropItem(Items.STICK);
	                     }
	                  }
	               }
	            }

	            this.fallDistance = 0.0F;
	         } else if (!this.world.getFluidState((new BlockPos(this)).down()).isTagged(FluidTags.WATER) && y < 0.0D) {
	            this.fallDistance = (float)((double)this.fallDistance - y);
	         }

	      }
	   }
	   
	public void setModBoatType(ModChestBoatEntity.Type boatType)
	{
		this.dataManager.set(BOAT_TYPE, boatType.ordinal());
	}

	public ModChestBoatEntity.Type getModBoatType()
	{
		return ModChestBoatEntity.Type.byId(this.dataManager.get(BOAT_TYPE));
	}
	
	
   public static enum Type
   {
	      OAK(Blocks.OAK_PLANKS, "oak"),
	      SPRUCE(Blocks.SPRUCE_PLANKS, "spruce"),
	      BIRCH(Blocks.BIRCH_PLANKS, "birch"),
	      JUNGLE(Blocks.JUNGLE_PLANKS, "jungle"),
	      ACACIA(Blocks.ACACIA_PLANKS, "acacia"),
	      DARK_OAK(Blocks.DARK_OAK_PLANKS, "dark_oak"),
	      BAOBAB(ModBlocks.BAOBAB_PLANKS, "baobab"),
	      MANGROVE(ModBlocks.MANGROVE_PLANKS, "mangrove"),
	      PALM(ModBlocks.PALM_PLANKS, "palm");

	      private final String name;
	      private final Block block;

	      private Type(Block p_i48146_3_, String p_i48146_4_) {
	         this.name = p_i48146_4_;
	         this.block = p_i48146_3_;
	      }

	      public String getName() {
	         return this.name;
	      }

	      public Block asPlank() {
	         return this.block;
	      }

	      public String toString() {
	         return this.name;
	      }

	      /**
	       * Get a boat type by it's enum ordinal
	       */
	      public static ModChestBoatEntity.Type byId(int id) {
	         ModChestBoatEntity.Type[] aboatentity$type = values();
	         if (id < 0 || id >= aboatentity$type.length) {
	            id = 0;
	         }

	         return aboatentity$type[id];
	      }

	      public static ModChestBoatEntity.Type getTypeFromString(String nameIn) {
	         ModChestBoatEntity.Type[] aboatentity$type = values();

	         for(int i = 0; i < aboatentity$type.length; ++i) {
	            if (aboatentity$type[i].getName().equals(nameIn)) {
	               return aboatentity$type[i];
	            }
	         }

	         return aboatentity$type[0];
	      }
	   }
	
   @Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
