package com.covetedmobs.common.entity.living.mammals;

import com.covetedmobs.CovetedMobs;
import com.covetedmobs.common.entity.util.ModEntityAnimal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * Created by Joseph on 12/31/2019.
 */
public class EntityOryx extends ModEntityAnimal {
	protected static final DataParameter<Integer> GRAZE_TIME = EntityDataManager.<Integer>createKey(EntityOryx.class, DataSerializers.VARINT);
	
	protected EntityOryx(World world) {
		super(world, new ResourceLocation(CovetedMobs.MODID, "entities/oryx"));
		setSize(1.6f, 2.3f);
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(GRAZE_TIME, Integer.valueOf(0));
	}
	
	private int getNewGraze() {
		return this.rand.nextInt(2000) + 80;
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
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
	
	public int getGrazeTime() {
		return this.dataManager.get(GRAZE_TIME).intValue();
	}
	
	public int setGrazeTime(int time) {
		this.dataManager.set(GRAZE_TIME, Integer.valueOf(time));
		return time;
	}
	
	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == Items.WHEAT;
	}
	
	@Override
	protected void initEntityAI() {
		super.initEntityAI();
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.5);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16);
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.1D);
	}
	
	@Override
	protected int getSkinTypes() {
		return 2;
	}
}
