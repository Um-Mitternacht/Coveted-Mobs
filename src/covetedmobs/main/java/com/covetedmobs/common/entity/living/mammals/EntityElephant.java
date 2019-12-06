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
	
	private int grazeTimer;
	private EntityAIEatGrass entityAIEatGrass;
	
	protected EntityElephant(World world) {
		super(world, 5, new ResourceLocation(CovetedMobs.MODID, "entities/elephant"), Items.CAKE, Items.GOLDEN_APPLE, Items.PUMPKIN_PIE, Items.GOLDEN_CARROT, Items.SPECKLED_MELON, Items.MELON, Items.APPLE);
		setSize(4.0f, 4.0f);
	}
	
	protected void initEntityAI() {
		this.entityAIEatGrass = new EntityAIEatGrass(this);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(5, this.entityAIEatGrass);
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
	
	public void eatGrassBonus() {
		if (this.isChild()) {
			this.addGrowth(60);
		}
	}
	
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		
		if (this.getOwnerUniqueId() != null) {
			compound.setString("OwnerUUID", this.getOwnerUniqueId().toString());
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 10) {
			this.grazeTimer = 40;
		}
		else {
			super.handleStatusUpdate(id);
		}
	}
	
	public void onLivingUpdate() {
		if (this.world.isRemote) {
			this.grazeTimer = Math.max(0, this.grazeTimer - 1);
		}
		
		super.onLivingUpdate();
	}
	
	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == Items.MELON || stack.getItem() == Items.PUMPKIN_PIE || stack.getItem() == Items.GOLDEN_APPLE || stack.getItem() == Items.SPECKLED_MELON || stack.getItem() == Items.GOLDEN_CARROT || stack.getItem() == Items.MELON || stack.getItem() == Items.APPLE;
	}
	
	@Override
	protected int getSkinTypes() {
		return 2;
	}
	
	@Override
	public boolean canBeSteered() {
		return this.getControllingPassenger() instanceof EntityLivingBase;
	}
	
	public int getGrazeTime() {
		return grazeTimer;
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
