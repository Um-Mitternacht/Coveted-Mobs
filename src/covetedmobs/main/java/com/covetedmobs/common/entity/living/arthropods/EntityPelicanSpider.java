package com.covetedmobs.common.entity.living.arthropods;

import com.covetedmobs.CovetedMobs;
import com.covetedmobs.common.entity.util.ModEntityTameable;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Joseph on 1/30/2020.
 */
public class EntityPelicanSpider extends ModEntityTameable {
	
	
	protected EntityPelicanSpider(World world) {
		super(world, new ResourceLocation(CovetedMobs.MODID, "entities/pelican_spider"), Items.SPIDER_EYE, Items.FERMENTED_SPIDER_EYE);
		setSize(2.5f, 2.5f);
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
		if (entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue())) {
			applyEnchantments(this, entity);
			if (entity instanceof EntityLivingBase) ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.POISON, 500, 1, false, false));
		}
		return super.attackEntityAsMob(entity);
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (this.getHealth() < this.getMaxHealth() && !(ticksExisted % 200 > 5)) this.heal(2);
	}
	
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_SPIDER_AMBIENT;
	}
	
	protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15F, 1.0F);
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
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
		this.tasks.addTask(1, new EntityAIAttackMelee(this, getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue(), false));
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
}
