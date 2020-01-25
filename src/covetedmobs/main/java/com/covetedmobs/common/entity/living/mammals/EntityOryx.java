package com.covetedmobs.common.entity.living.mammals;

import com.covetedmobs.CovetedMobs;
import com.covetedmobs.common.entity.util.ModEntityAnimal;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * Created by Joseph on 12/31/2019.
 */
public class EntityOryx extends ModEntityAnimal {
	protected EntityOryx(World world) {
		super(world, new ResourceLocation(CovetedMobs.MODID, "entities/oryx"));
		setSize(1.6f, 2.3f);
	}
	
	@Override
	protected int getSkinTypes() {
		return 2;
	}
}
