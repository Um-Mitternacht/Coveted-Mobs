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
		
		public static class Blindworm {
			@Config.Comment("The list of BiomeDictionary types that the blindworm will spawn in.")
			public String[] blindwormBiomes = {BiomeDictionary.Type.FOREST.getName()};
			
			@Config.Comment("The weight chance for blindworm to spawn.")
			@Config.RangeInt(min = 0, max = Byte.MAX_VALUE)
			public int blindwormWeight = 20;
			
			@Config.Comment("The minimum amount of blindworms to spawn at once.")
			@Config.RangeInt(min = 0, max = Byte.MAX_VALUE)
			public int blindwormMin = 1;
			
			@Config.Comment("The maximum amount of blindworms to spawn at once.")
			@Config.RangeInt(min = 0, max = Byte.MAX_VALUE)
			public int blindwormMax = 4;
		}
		
		public static class Newt {
			@Config.Comment("The list of BiomeDictionary types that the newt will spawn in.")
			public String[] newtBiomes = {BiomeDictionary.Type.FOREST.getName(), BiomeDictionary.Type.DENSE.getName()};
			
			@Config.Comment("The weight chance for newts to spawn.")
			@Config.RangeInt(min = 0, max = Byte.MAX_VALUE)
			public int newtWeight = 20;
			
			@Config.Comment("The minimum amount of newts to spawn at once.")
			@Config.RangeInt(min = 0, max = Byte.MAX_VALUE)
			public int newtMin = 1;
			
			@Config.Comment("The maximum amount of newts to spawn at once.")
			@Config.RangeInt(min = 0, max = Byte.MAX_VALUE)
			public int newtMax = 4;
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
