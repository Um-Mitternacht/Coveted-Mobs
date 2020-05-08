package com.covetedmobs.registry;

/**
 * Created by Joseph on 11/4/2019.
 */

import com.covetedmobs.CovetedMobs;
import com.covetedmobs.ModConfig;
import com.covetedmobs.common.entity.living.arthropods.EntityPelicanSpider;
import com.covetedmobs.common.entity.living.herps.EntityBlindworm;
import com.covetedmobs.common.entity.living.herps.EntityNewt;
import com.covetedmobs.common.entity.living.mammals.EntityElephant;
import com.covetedmobs.common.entity.living.mammals.EntityOryx;
import com.covetedmobs.common.entity.living.mammals.EntityTiger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings({"unused", "SameParameterValue", "WeakerAccess"})
public class ModEntities {
	public static int entity_id = 0;
	
	public static final EntityEntry blindworm = createEntityEntry(EntityBlindworm.class, "blindworm", 0x954535, 0xEDC9AF, EnumCreatureType.AMBIENT, ModConfig.mobSpawns.blindworm.blindwormWeight, ModConfig.mobSpawns.blindworm.blindwormMin, ModConfig.mobSpawns.blindworm.blindwormMax, Arrays.asList(ModConfig.mobSpawns.blindworm.blindwormBiomes));
	public static final EntityEntry newt = createEntityEntry(EntityNewt.class, "newt", 0x555D50, 0xFF8C00, EnumCreatureType.AMBIENT, ModConfig.mobSpawns.newt.newtWeight, ModConfig.mobSpawns.newt.newtMin, ModConfig.mobSpawns.newt.newtMax, Arrays.asList(ModConfig.mobSpawns.newt.newtBiomes));
	public static final EntityEntry elephant = createEntityEntry(EntityElephant.class, "elephant", 0xC0C0C0, 0x555555);
	public static final EntityEntry oryx = createEntityEntry(EntityOryx.class, "oryx", 0xFFF8DC, 0xD2691E, EnumCreatureType.CREATURE, ModConfig.mobSpawns.oryx.oryxWeight, ModConfig.mobSpawns.oryx.oryxMin, ModConfig.mobSpawns.oryx.oryxMax, Arrays.asList(ModConfig.mobSpawns.oryx.oryxBiomes));
	public static final EntityEntry pelicanspider = createEntityEntry(EntityPelicanSpider.class, "pelicanspider", 0x9F8170, 0xDAA520, EnumCreatureType.CREATURE, ModConfig.mobSpawns.pelicanspider.pelicanspiderWeight, ModConfig.mobSpawns.pelicanspider.pelicanspiderMin, ModConfig.mobSpawns.pelicanspider.pelicanspiderMax, Arrays.asList(ModConfig.mobSpawns.pelicanspider.pelicanspiderBiomes));
	public static final EntityEntry tiger = createEntityEntry(EntityTiger.class, "tiger", 0xFFF8DC, 0xD2691E);
	
	
	private static EntityEntry createEntityEntry(Class<? extends Entity> clazz, String name) {
		return EntityEntryBuilder.create().entity(clazz).id(new ResourceLocation(CovetedMobs.MODID, name), entity_id++).name(CovetedMobs.MODID + "." + name).tracker(128, 1, true).build();
	}
	
	private static EntityEntry createEntityEntry(Class<? extends Entity> clazz, String name, int solidColor, int spotColor) {
		return EntityEntryBuilder.create().entity(clazz).id(new ResourceLocation(CovetedMobs.MODID, name), entity_id++).name(CovetedMobs.MODID + "." + name).tracker(64, 1, true).egg(solidColor, spotColor).build();
	}
	
	private static EntityEntry createEntityEntry(Class<? extends Entity> clazz, String name, int solidColor, int spotColor, EnumCreatureType type, int weight, int min, int max, List<String> types) {
		Set<Biome> biomes = new HashSet<>();
		for (String typeName : types) biomes.addAll(BiomeDictionary.getBiomes(Type.getType(typeName)));
		return EntityEntryBuilder.create().entity(clazz).id(new ResourceLocation(CovetedMobs.MODID, name), entity_id++).name(CovetedMobs.MODID + "." + name).tracker(64, 1, true).egg(solidColor, spotColor).spawn(type, weight, min, max, biomes).build();
	}
}