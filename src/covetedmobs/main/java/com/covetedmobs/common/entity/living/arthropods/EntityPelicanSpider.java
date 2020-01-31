package com.covetedmobs.common.entity.living.arthropods;

import com.covetedmobs.common.entity.util.ModEntityTameable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * Created by Joseph on 1/30/2020.
 */
public class EntityPelicanSpider extends ModEntityTameable {
	
	
	protected EntityPelicanSpider(World world, ResourceLocation lootTableLocation, Item... tameItems) {
		super(world, lootTableLocation, tameItems);
	}
	
	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == Items.SPIDER_EYE;
	}
}
