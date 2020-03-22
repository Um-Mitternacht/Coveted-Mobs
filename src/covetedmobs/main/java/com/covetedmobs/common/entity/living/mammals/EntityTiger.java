package com.covetedmobs.common.entity.living.mammals;

import com.covetedmobs.CovetedMobs;
import com.covetedmobs.common.entity.util.ModEntityAnimal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * Created by Joseph on 3/18/2020.
 */
public class EntityTiger extends ModEntityAnimal {
	protected EntityTiger(World world) {
		super(world, new ResourceLocation(CovetedMobs.MODID, "entities/tiger"));
		setSize(2.3f, 2.9f);
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
	}
	
	@Override
	protected int getSkinTypes() {
		return 8;
	}
	
	@Override
	protected void initEntityAI() {
		super.initEntityAI();
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.5);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32);
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.65);
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.3D);
	}
	
	@Override
	public int getMaxSpawnedInChunk() {
		return 2;
	}
}
