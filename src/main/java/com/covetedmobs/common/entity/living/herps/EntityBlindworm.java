package com.covetedmobs.common.entity.living.herps;

import com.covetedmobs.CovetedMobs;
import com.covetedmobs.common.entity.util.ModEntityAnimal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * Created by Joseph on 11/5/2019.
 */
public class EntityBlindworm extends ModEntityAnimal {
	public EntityBlindworm(World world) {
		super(world, new ResourceLocation(CovetedMobs.MODID, "entities/blindworm"));
		setSize(1, 0.3f);
	}
	
	@Override
	protected int getSkinTypes() {
		return 1;
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (this.getHealth() < this.getMaxHealth() && !(ticksExisted % 200 > 5)) this.heal(2);
	}
	
	@Override
	protected boolean canDespawn() {
		return !hasCustomName();
	}
	
	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == Items.SPIDER_EYE;
	}
	
	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAIPanic(this, getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIMate(this, getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));
		tasks.addTask(2, new EntityAIWatchClosest2(this, EntityPlayer.class, 5, 1));
		tasks.addTask(2, new EntityAIFollowParent(this, getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));
		tasks.addTask(3, new EntityAILookIdle(this));
		tasks.addTask(3, new EntityAIWander(this, getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));
		this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.5D));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(6);
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2);
	}
	
	@Override
	public int getMaxSpawnedInChunk() {
		return 2;
	}
}
