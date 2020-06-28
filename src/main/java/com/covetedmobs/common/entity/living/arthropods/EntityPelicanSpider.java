package com.covetedmobs.common.entity.living.arthropods;

import com.covetedmobs.CovetedMobs;
import com.covetedmobs.common.entity.util.ModEntityTameable;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Set;

/**
 * Created by Joseph on 1/30/2020.
 */

//Credit to Twilight Forest devs for code used for pelican spider grabbing
public class EntityPelicanSpider extends ModEntityTameable {

	public int attackTimer = 0;
	
	protected static final DataParameter<Boolean> ATTACKING = EntityDataManager.<Boolean>createKey(EntityPelicanSpider.class, DataSerializers.BOOLEAN);
	private static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(Items.SPIDER_EYE, Items.FERMENTED_SPIDER_EYE);
	
	public EntityPelicanSpider(World world) {
		super(world, new ResourceLocation(CovetedMobs.MODID, "entities/pelican_spider"), Items.SPIDER_EYE, Items.FERMENTED_SPIDER_EYE);
		setSize(2.5f, 2.5f);
		experienceValue = 25;
	}
	
	@Override
	public void setAttackTarget(EntityLivingBase entitylivingbaseIn) {
		this.setAttackingOnClient(entitylivingbaseIn != null);
		super.setAttackTarget(entitylivingbaseIn);
	}
	
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_SPIDER_AMBIENT;
	}
	
	@Override
	public boolean isPotionApplicable(PotionEffect effect) {
		return effect.getPotion() != MobEffects.SLOWNESS && effect.getPotion() != MobEffects.POISON && super.isPotionApplicable(effect);
	}
	
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_SPIDER_HURT;
	}
	
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SPIDER_DEATH;
	}
	
	public void fall(float distance, float damageMultiplier) {
	}
	
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		float f = this.world.getDifficultyForLocation(new BlockPos(this)).getAdditionalDifficulty();
		
		if (this.getPassengers().isEmpty() && !entity.isRiding()) {
			entity.startRiding(this);
		}
		
		if (entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue())) {
			applyEnchantments(this, entity);
			if (entity instanceof EntityLivingBase) ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.POISON, 500, 1, false, false));
		}
		return super.attackEntityAsMob(entity);
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
		return stack.getItem() == Items.SPIDER_EYE;
	}
	
	protected void initEntityAI() {
		super.initEntityAI();
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.8D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		tasks.addTask(1, aiSit);
		this.tasks.addTask(3, new EntityAITempt(this, 1.0D, false, TEMPTATION_ITEMS));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
		this.tasks.addTask(1, new EntityAIAttackMelee(this, getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue(), false));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAITargetNonTamed<>(this, EntityLivingBase.class, true, e -> e instanceof EntitySpider));
		this.targetTasks.addTask(2, new EntityAITargetNonTamed<>(this, EntityPlayer.class, false, p -> p.getDistanceSq(this) < 1));
		
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.5);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32);
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25);
		getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.5);
		getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(1.0);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30);
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.1D);
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(ATTACKING, Boolean.valueOf(false));
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean("AttackSync", this.isAttackingFromServer());
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setAttackingOnClient(compound.getBoolean("AttackSync"));
	}
	
	@Override
	protected void boostHealth(boolean tamed) {
		if (tamed) getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(35);
		if (tamed) getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(4);
		else getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
	}
	
	public boolean isAttackingFromServer() {
		return this.dataManager.get(ATTACKING).booleanValue();
	}
	
	public void setAttackingOnClient(boolean in) {
		this.dataManager.set(ATTACKING, Boolean.valueOf(in));
	}
	
	private Vec3d getRiderPosition() {
		if (!this.getPassengers().isEmpty()) {
			float distance = 2.0F;
			
			double dx = Math.cos((this.rotationYaw + 90) * Math.PI / 180.0D) * distance;
			double dz = Math.sin((this.rotationYaw + 90) * Math.PI / 180.0D) * distance;
			
			return new Vec3d(this.posX + dx, this.posY + this.getMountedYOffset() + this.getPassengers().get(0).getYOffset(), this.posZ + dz);
		}
		else {
			return new Vec3d(this.posX, this.posY, this.posZ);
		}
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		
		if (!this.getPassengers().isEmpty()) {
			this.setSize(3.0F, 3.0F);
			
			if (this.getPassengers().get(0).isSneaking()) {
				this.getPassengers().get(0).setSneaking(false);
			}
		}
		else {
			this.setSize(2.5F, 2.5F);
			
		}
		
		if (!this.getPassengers().isEmpty()) {
			this.getLookHelper().setLookPositionWithEntity(getPassengers().get(0), 100F, 100F);
			
			// push out of user in wall
			Vec3d riderPos = this.getRiderPosition();
			this.pushOutOfBlocks(riderPos.x, riderPos.y, riderPos.z);
		}
		
		
		if (this.getHealth() < this.getMaxHealth() && !(ticksExisted % 200 > 5)) this.heal(2);
		
		if (!this.world.isRemote && (this.getAttackTarget() == null || this.getAttackTarget().isDead)) {
			this.setAttackingOnClient(false);
		}
	}
	
	protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15F, 1.0F);
	}
	
	@Override
	public void updatePassenger(Entity passenger) {
		if (!this.getPassengers().isEmpty()) {
			Vec3d riderPos = this.getRiderPosition();
			
			this.getPassengers().get(0).setPosition(riderPos.x, riderPos.y, riderPos.z);
		}
	}
	
	@Override
	public double getMountedYOffset() {
		return 2.15D;
	}
	
	@Override
	public boolean canRiderInteract() {
		return true;
	}
}
