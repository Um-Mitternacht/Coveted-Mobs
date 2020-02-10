package com.covetedmobs;

import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Joseph on 11/4/2019.
 */
public class ModConfig {
	
	@Config.Comment("Mob spawn settings")
	public static final MobSpawns mobSpawns = new MobSpawns();
	
	public static class MobSpawns {
		public final Newt newt = new Newt();
		public final Blindworm blindworm = new Blindworm();
		public final Elephant elephant = new Elephant();
		public final Oryx oryx = new Oryx();
		public final PelicanSpider pelicanspider = new PelicanSpider();
		
		public static class Blindworm {
			@Config.Comment("The list of BiomeDictionary types that the blindworm will spawn in.")
			public String[] blindwormBiomes = {BiomeDictionary.Type.FOREST.getName()};
			
			@Config.Comment("The weight chance for blindworm to spawn.")
			@Config.RangeInt(min = 0, max = Byte.MAX_VALUE)
			public int blindwormWeight = 6;
			
			@Config.Comment("The minimum amount of blindworms to spawn at once.")
			@Config.RangeInt(min = 0, max = Byte.MAX_VALUE)
			public int blindwormMin = 0;
			
			@Config.Comment("The maximum amount of blindworms to spawn at once.")
			@Config.RangeInt(min = 0, max = Byte.MAX_VALUE)
			public int blindwormMax = 2;
		}
		
		public static class Newt {
			@Config.Comment("The list of BiomeDictionary types that the newt will spawn in.")
			public String[] newtBiomes = {BiomeDictionary.Type.SWAMP.getName(), BiomeDictionary.Type.WET.getName()};
			
			@Config.Comment("The weight chance for newts to spawn.")
			@Config.RangeInt(min = 0, max = Byte.MAX_VALUE)
			public int newtWeight = 6;
			
			@Config.Comment("The minimum amount of newts to spawn at once.")
			@Config.RangeInt(min = 0, max = Byte.MAX_VALUE)
			public int newtMin = 0;
			
			@Config.Comment("The maximum amount of newts to spawn at once.")
			@Config.RangeInt(min = 0, max = Byte.MAX_VALUE)
			public int newtMax = 2;
		}
		
		public static class Elephant {
			@Config.Comment("The list of BiomeDictionary types that the elephant will spawn in.")
			public String[] elephantBiomes = {BiomeDictionary.Type.SAVANNA.getName(), BiomeDictionary.Type.JUNGLE.getName()};
			
			@Config.Comment("The weight chance for elephants to spawn.")
			@Config.RangeInt(min = 0, max = Byte.MAX_VALUE)
			public int elephantWeight = 20;
			
			@Config.Comment("The minimum amount of elephants to spawn at once.")
			@Config.RangeInt(min = 0, max = Byte.MAX_VALUE)
			public int elephantMin = 1;
			
			@Config.Comment("The maximum amount of elephants to spawn at once.")
			@Config.RangeInt(min = 0, max = Byte.MAX_VALUE)
			public int elephantMax = 6;
		}
		
		public static class Oryx {
			@Config.Comment("The list of BiomeDictionary types that the oryx will spawn in.")
			public String[] oryxBiomes = {BiomeDictionary.Type.SAVANNA.getName(), BiomeDictionary.Type.SANDY.getName()};
			
			@Config.Comment("The weight chance for oryxes to spawn.")
			@Config.RangeInt(min = 0, max = Byte.MAX_VALUE)
			public int oryxWeight = 20;
			
			@Config.Comment("The minimum amount of oryxes to spawn at once.")
			@Config.RangeInt(min = 0, max = Byte.MAX_VALUE)
			public int oryxMin = 1;
			
			@Config.Comment("The maximum amount of oryxes to spawn at once.")
			@Config.RangeInt(min = 0, max = Byte.MAX_VALUE)
			public int oryxMax = 8;
		}
		
		public static class PelicanSpider {
			@Config.Comment("The list of BiomeDictionary types that the pelican spider will spawn in.")
			public String[] pelicanspiderBiomes = {BiomeDictionary.Type.JUNGLE.getName()};
			
			@Config.Comment("The weight chance for pelican spiders to spawn.")
			@Config.RangeInt(min = 0, max = Byte.MAX_VALUE)
			public int pelicanspiderWeight = 10;
			
			@Config.Comment("The minimum amount of pelican spiders to spawn at once.")
			@Config.RangeInt(min = 0, max = Byte.MAX_VALUE)
			public int pelicanspiderMin = 0;
			
			@Config.Comment("The maximum amount of pelican spiders to spawn at once.")
			@Config.RangeInt(min = 0, max = Byte.MAX_VALUE)
			public int pelicanspiderMax = 2;
		}
		
		@Mod.EventBusSubscriber(modid = CovetedMobs.MODID)
		private static class SyncConfig {
			@SubscribeEvent
			public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
				if (event.getModID().equals(CovetedMobs.MODID)) {
					ConfigManager.sync(CovetedMobs.MODID, net.minecraftforge.common.config.Config.Type.INSTANCE);
				}
			}
		}
	}
}
