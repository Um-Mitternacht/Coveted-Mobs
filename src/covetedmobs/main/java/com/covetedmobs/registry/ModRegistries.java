package com.covetedmobs.registry;

import com.covetedmobs.CovetedMobs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Created by Joseph on 11/6/2019.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
@Mod.EventBusSubscriber
public class ModRegistries {
	public static final Map<Item, String[]> ORE_DICTIONARY_ENTRIES = new HashMap<>();
	public static final Map<Item, List<Predicate<ItemStack>>> MODEL_PREDICATES = new HashMap<>();
	
	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
		try {
			for (Field f : ModEntities.class.getFields()) {
				Object obj = f.get(null);
				if (obj instanceof EntityEntry) event.getRegistry().register((EntityEntry) obj);
			}
		}
		catch (Exception ignored) {}
		
		LootTableList.register(new ResourceLocation(CovetedMobs.MODID, "entities/herps/newt"));
		LootTableList.register(new ResourceLocation(CovetedMobs.MODID, "entities/herps/blindworm"));
	}
}