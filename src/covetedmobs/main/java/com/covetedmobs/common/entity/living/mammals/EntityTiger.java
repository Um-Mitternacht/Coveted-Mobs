package com.covetedmobs.common.entity.living.mammals;

import com.covetedmobs.CovetedMobs;
import com.covetedmobs.common.entity.util.ModEntityMob;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * Created by Joseph on 3/18/2020.
 */
public class EntityTiger extends ModEntityMob {
	protected EntityTiger(World world) {
		super(world, new ResourceLocation(CovetedMobs.MODID, "entities/tiger"));
	}
	
	@Override
	protected boolean isValidLightLevel() {
		return true;
	}
	
	@Override
	public int getMaxSpawnedInChunk() {
		return 2;
	}
	
	@Override
	protected int getSkinTypes() {
		return 5;
	}
}
