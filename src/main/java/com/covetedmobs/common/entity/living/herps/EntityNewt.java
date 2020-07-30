package com.covetedmobs.common.entity.living.herps;

import com.covetedmobs.CovetedMobs;
import com.covetedmobs.common.entity.util.ModEntityAnimal;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * Created by Joseph on 11/21/2019.
 */
public class EntityNewt extends ModEntityAnimal {
    public EntityNewt(World world) {
        super(world, new ResourceLocation(CovetedMobs.MODID, "entities/newt"));
        setSize(0.3f, 0.3f);
        experienceValue = 5;
        enumCreatureType();
    }

    @Override
    protected int getSkinTypes() {
        return 4;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (ticksExisted % 20 == 0 && isWet()) heal(1);
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
    protected void despawnEntity() {
        if (!hasCustomName()) {
            super.despawnEntity();
        }
    }

    public EnumCreatureType enumCreatureType() {
        return EnumCreatureType.AMBIENT;
    }

    @Override
    protected void initEntityAI() {
        tasks.addTask(0, new EntityAIPanic(this, getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIMate(this, getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() / 2));
        tasks.addTask(1, new EntityAIAttackMelee(this, getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue(), false));
        tasks.addTask(2, new EntityAIWatchClosest2(this, EntityPlayer.class, 5, 1));
        tasks.addTask(2, new EntityAIFollowParent(this, getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));
        tasks.addTask(3, new EntityAILookIdle(this));
        tasks.addTask(4, new EntityAIWander(this, getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() * 2 / 3));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.5D));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.5);
        getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(6);
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6);
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 6;
    }
}
