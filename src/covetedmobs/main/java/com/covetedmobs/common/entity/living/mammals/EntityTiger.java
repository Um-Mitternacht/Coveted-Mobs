package com.covetedmobs.common.entity.living.mammals;

import com.covetedmobs.common.entity.util.ModEntityMob;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * Created by Joseph on 3/18/2020.
 */
public class EntityTiger extends ModEntityMob {
	protected EntityTiger(World world, ResourceLocation lootTableLocation) {
		super(world, lootTableLocation);
	}
	
	@Override
	protected boolean isValidLightLevel() {
		return true;
	}
}
