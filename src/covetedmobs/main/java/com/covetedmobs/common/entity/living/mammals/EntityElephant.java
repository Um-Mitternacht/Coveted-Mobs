package com.covetedmobs.common.entity.living.mammals;

import com.covetedmobs.CovetedMobs;
import com.covetedmobs.common.entity.util.ModEntityTameableGrazer;
import com.covetedmobs.registry.ModObjects;
import com.google.common.base.Optional;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import javax.annotation.Nullable;
import java.util.UUID;

import static net.minecraftforge.common.BiomeDictionary.Type;

/**
 * Created by Joseph on 12/1/2019.
 */
public class EntityElephant extends ModEntityTameableGrazer {
	
	protected static final DataParameter<Integer> GRAZE_TIME = EntityDataManager.<Integer>createKey(EntityElephant.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> TUSK_SWORDED = EntityDataManager.createKey(EntityElephant.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> ELEPHANT_TYPE = EntityDataManager.<Integer>createKey(EntityElephant.class, DataSerializers.VARINT);
	
	protected EntityElephant(World world) {
		super(world, new ResourceLocation(CovetedMobs.MODID, "entities/elephant"), Items.CAKE, Items.GOLDEN_APPLE, Items.PUMPKIN_PIE, Items.GOLDEN_CARROT, Items.SPECKLED_MELON, Items.MELON, Items.APPLE);
		setSize(2.3f, 2.9f);
		this.setGrazeTime(this.getNewGraze());
	}
	
	public int getTuskSword() {
		return Integer.valueOf(this.dataManager.get(TUSK_SWORDED).intValue());
	}
	
	public int getIntFromArmor(ItemStack stack) {
		if (!stack.isEmpty() && stack.getItem() != null && stack.getItem() == ModObjects.iron_tusk_sword) {
			return 1;
		}
		if (!stack.isEmpty() && stack.getItem() != null && stack.getItem() == ModObjects.gold_tusk_sword) {
			return 2;
		}
		if (!stack.isEmpty() && stack.getItem() != null && stack.getItem() == ModObjects.diamond_tusk_sword) {
			return 3;
		}
		return 0;
	}
	
	public boolean attackEntityAsMob(Entity entityIn) {
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) ((int) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));
		
		if (flag) {
			this.applyEnchantments(this, entityIn);
		}
		
		return flag;
	}
	
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isEntityInvulnerable(source)) {
			return false;
		}
		else {
			Entity entity = source.getTrueSource();
			
			if (this.aiSit != null) {
				this.aiSit.setSitting(false);
			}
			
			if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow)) {
				amount = (amount + 1.0F) / 2.0F;
			}
			
			return super.attackEntityFrom(source, amount);
		}
	}
	
	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == Items.MELON || stack.getItem() == Items.PUMPKIN_PIE || stack.getItem() == Items.GOLDEN_APPLE || stack.getItem() == Items.SPECKLED_MELON || stack.getItem() == Items.GOLDEN_CARROT || stack.getItem() == Items.MELON || stack.getItem() == Items.APPLE;
	}
	
	@Override
	protected void initEntityAI() {
		super.initEntityAI();
		this.tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, aiSit);
		this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
		this.targetTasks.addTask(2, new EntityAITargetNonTamed<>(this, EntityPlayer.class, false, p -> p.getDistanceSq(this) < 1));
		this.tasks.addTask(1, new EntityAIAttackMelee(this, getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue(), false));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.5D);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32);
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50);
		getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(1.4);
		getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(0.7);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.9D);
	}
	
	@Nullable
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		int i = this.getRandomElephantType();
		boolean flag = false;
		
		if (livingdata instanceof EntityElephant.ElephantTypeData) {
			i = ((EntityElephant.ElephantTypeData) livingdata).typeData;
			flag = true;
		}
		else {
			livingdata = new EntityElephant.ElephantTypeData(i);
		}
		
		this.setElephantType(i);
		
		return livingdata;
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(ELEPHANT_TYPE, Integer.valueOf(0));
		this.dataManager.register(GRAZE_TIME, Integer.valueOf(0));
	}
	
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setInteger("ElephantType", this.getElephantType());
		//	compound.setInteger("Tusksworded", this.getTuskSword());
		//
		//	if (this.getOwnerUniqueId() != null) {
		//		compound.setString("OwnerUUID", this.getOwnerUniqueId().toString());
		//	}
	}
	
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setElephantType(compound.getInteger("ElephantType"));
	}
	
	//Credit to its_meow for the code used in this section, as it was used in the moose to destroy blocks.
	@Override
	protected void doBlockCollisions() {
		AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
		BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos = BlockPos.PooledMutableBlockPos.retain(axisalignedbb.minX + 0.001D, axisalignedbb.minY + 0.001D, axisalignedbb.minZ + 0.001D);
		BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos1 = BlockPos.PooledMutableBlockPos.retain(axisalignedbb.maxX - 0.001D, axisalignedbb.maxY - 0.001D, axisalignedbb.maxZ - 0.001D);
		BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos2 = BlockPos.PooledMutableBlockPos.retain();
		
		if (this.world.isAreaLoaded(blockpos$pooledmutableblockpos, blockpos$pooledmutableblockpos1)) {
			for (int i = blockpos$pooledmutableblockpos.getX(); i <= blockpos$pooledmutableblockpos1.getX(); ++i) {
				for (int j = blockpos$pooledmutableblockpos.getY(); j <= blockpos$pooledmutableblockpos1.getY(); ++j) {
					for (int k = blockpos$pooledmutableblockpos.getZ(); k <= blockpos$pooledmutableblockpos1.getZ(); ++k) {
						blockpos$pooledmutableblockpos2.setPos(i, j, k);
						IBlockState iblockstate = this.world.getBlockState(blockpos$pooledmutableblockpos2);
						
						try {
							iblockstate.getBlock().onEntityCollision(this.world, blockpos$pooledmutableblockpos2, iblockstate, this);
							this.onInsideBlock(iblockstate);
							if (iblockstate.getMaterial() == Material.LEAVES) {
								iblockstate.getBlock().breakBlock(world, blockpos$pooledmutableblockpos2.toImmutable(), iblockstate);
								world.setBlockToAir(blockpos$pooledmutableblockpos2.toImmutable());
							}
							if (iblockstate.getMaterial() == Material.VINE) {
								iblockstate.getBlock().breakBlock(world, blockpos$pooledmutableblockpos2.toImmutable(), iblockstate);
								world.setBlockToAir(blockpos$pooledmutableblockpos2.toImmutable());
							}
							if (iblockstate.getMaterial() == Material.SNOW) {
								iblockstate.getBlock().breakBlock(world, blockpos$pooledmutableblockpos2.toImmutable(), iblockstate);
								world.setBlockToAir(blockpos$pooledmutableblockpos2.toImmutable());
							}
							if (iblockstate.getMaterial() == Material.CRAFTED_SNOW) {
								iblockstate.getBlock().breakBlock(world, blockpos$pooledmutableblockpos2.toImmutable(), iblockstate);
								world.setBlockToAir(blockpos$pooledmutableblockpos2.toImmutable());
							}
							if (iblockstate.getMaterial() == Material.PLANTS) {
								iblockstate.getBlock().breakBlock(world, blockpos$pooledmutableblockpos2.toImmutable(), iblockstate);
								world.setBlockToAir(blockpos$pooledmutableblockpos2.toImmutable());
							}
							if (iblockstate.getMaterial() == Material.GOURD) {
								iblockstate.getBlock().breakBlock(world, blockpos$pooledmutableblockpos2.toImmutable(), iblockstate);
								world.setBlockToAir(blockpos$pooledmutableblockpos2.toImmutable());
							}
							if (iblockstate.getMaterial() == Material.WEB) {
								iblockstate.getBlock().breakBlock(world, blockpos$pooledmutableblockpos2.toImmutable(), iblockstate);
								world.setBlockToAir(blockpos$pooledmutableblockpos2.toImmutable());
							}
						}
						catch (Throwable throwable) {
							CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Colliding entity with block");
							CrashReportCategory crashreportcategory = crashreport.makeCategory("Block being collided with");
							CrashReportCategory.addBlockInfo(crashreportcategory, blockpos$pooledmutableblockpos2, iblockstate);
							throw new ReportedException(crashreport);
						}
					}
				}
			}
		}
		
		blockpos$pooledmutableblockpos.release();
		blockpos$pooledmutableblockpos1.release();
		blockpos$pooledmutableblockpos2.release();
	}
	
	private int getRandomElephantType() {
		boolean flag = rand.nextBoolean();
		Biome biome = world.getBiome(getPosition());
		if (BiomeDictionary.hasType(biome, Type.SAVANNA)) return 0;
		else if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.JUNGLE)) return 1;
		else return flag ? 0 : 1;
	}
	
	public int getElephantType() {
		return ((Integer) this.dataManager.get(ELEPHANT_TYPE)).intValue();
	}
	
	public void setElephantType(int elephantTypeId) {
		this.dataManager.set(ELEPHANT_TYPE, Integer.valueOf(elephantTypeId));
	}
	
	private int getNewGraze() {
		return this.rand.nextInt(2000) + 80;
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (this.getHealth() < this.getMaxHealth() && !(ticksExisted % 200 > 5)) this.heal(2);
		if (!onGround && motionY <= 0) motionY *= 0.6;
		
		if (!this.onGround || this.getMoveHelper().isUpdating()) {
			if (this.getGrazeTime() <= 81) {
				this.setGrazeTime(80);
			}
		}
		
		if (!this.world.isRemote && this.setGrazeTime(this.getGrazeTime() - 1) <= 0) {
			this.setGrazeTime(this.getNewGraze());
		}
	}
	
	public boolean wearsArmor() {
		return false;
	}
	
	public boolean isArmor(ItemStack stack) {
		return false;
	}
	
	public int getGrazeTime() {
		return this.dataManager.get(GRAZE_TIME).intValue();
	}
	
	public int setGrazeTime(int time) {
		this.dataManager.set(GRAZE_TIME, Integer.valueOf(time));
		return time;
	}
	
	@Override
	public boolean canBeSteered() {
		return this.getControllingPassenger() instanceof EntityLivingBase;
	}
	
	@Nullable
	public UUID getOwnerUniqueId() {
		return (UUID) ((Optional) this.dataManager.get(OWNER_UNIQUE_ID)).orNull();
	}
	
	public void setOwnerUniqueId(@Nullable UUID uniqueId) {
		this.dataManager.set(OWNER_UNIQUE_ID, Optional.fromNullable(uniqueId));
	}
	
	public static class ElephantTypeData implements IEntityLivingData {
		public int typeData;
		
		public ElephantTypeData(int type) {
			this.typeData = type;
		}
	}
	
}
