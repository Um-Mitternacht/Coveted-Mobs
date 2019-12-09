package com.covetedmobs.common.entity.living.mammals;

import com.covetedmobs.CovetedMobs;
import com.covetedmobs.common.entity.util.ModEntityTameableGrazer;
import com.google.common.base.Optional;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.UUID;

/**
 * Created by Joseph on 12/1/2019.
 */
public class EntityElephant extends ModEntityTameableGrazer {
	
	protected static final DataParameter<Integer> GRAZE_TIME = EntityDataManager.<Integer>createKey(EntityElephant.class, DataSerializers.VARINT);
	
	protected EntityElephant(World world) {
		super(world, new ResourceLocation(CovetedMobs.MODID, "entities/elephant"), Items.CAKE, Items.GOLDEN_APPLE, Items.PUMPKIN_PIE, Items.GOLDEN_CARROT, Items.SPECKLED_MELON, Items.MELON, Items.APPLE);
		setSize(4.0f, 4.0f);
		this.setGrazeTime(this.getNewGraze());
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
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.7);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32);
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50);
		getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(1.4);
		getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(0.7);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1);
	}
	
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		
		if (this.getOwnerUniqueId() != null) {
			compound.setString("OwnerUUID", this.getOwnerUniqueId().toString());
		}
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(GRAZE_TIME, Integer.valueOf(0));
	}
	
	@Override
	protected int getSkinTypes() {
		return 2;
	}
	
	private int getNewGraze() {
		return this.rand.nextInt(2000) + 60;
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (!onGround && motionY <= 0) motionY *= 0.6;
		
		if (!this.onGround || this.getMoveHelper().isUpdating()) {
			if (this.getGrazeTime() <= 61) {
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
	public boolean canBeSteered() {
		return this.getControllingPassenger() instanceof EntityLivingBase;
	}
	
	public boolean canBeSaddled() {
		return true;
	}
	
	@Nullable
	public UUID getOwnerUniqueId() {
		return (UUID) ((Optional) this.dataManager.get(OWNER_UNIQUE_ID)).orNull();
	}
	
	public void setOwnerUniqueId(@Nullable UUID uniqueId) {
		this.dataManager.set(OWNER_UNIQUE_ID, Optional.fromNullable(uniqueId));
	}
	
}
