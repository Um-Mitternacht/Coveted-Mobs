package com.covetedmobs.common.entity.living.mammals;

import com.covetedmobs.CovetedMobs;
import com.covetedmobs.common.entity.util.ModEntityTameable;
import com.google.common.base.Optional;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.UUID;

/**
 * Created by Joseph on 12/1/2019.
 */
public class EntityElephant extends ModEntityTameable {
	protected EntityElephant(World world) {
		super(world, new ResourceLocation(CovetedMobs.MODID, "entities/elephant"), Items.CAKE, Items.GOLDEN_APPLE, Items.PUMPKIN_PIE, Items.GOLDEN_CARROT, Items.SPECKLED_MELON, Items.MELON, Items.APPLE);
		setSize(2.7f, 2.7f);
	}
	
	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == Items.MELON || stack.getItem() == Items.PUMPKIN_PIE || stack.getItem() == Items.GOLDEN_APPLE || stack.getItem() == Items.SPECKLED_MELON || stack.getItem() == Items.GOLDEN_CARROT || stack.getItem() == Items.MELON || stack.getItem() == Items.APPLE;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.7);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32);
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50);
		getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(1.4);
		getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(1.4);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4);
	}
	
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		
		if (this.rand.nextInt(5) == 0) {
			this.setGrowingAge(-24000);
		}
		
		return livingdata;
	}
	
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		
		if (this.getOwnerUniqueId() != null) {
			compound.setString("OwnerUUID", this.getOwnerUniqueId().toString());
		}
	}
	
	@Override
	protected int getSkinTypes() {
		return 2;
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
