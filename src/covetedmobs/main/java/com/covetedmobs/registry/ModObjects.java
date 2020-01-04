package com.covetedmobs.registry;

import com.covetedmobs.client.Util;
import net.minecraft.item.Item;

/**
 * Created by Joseph on 12/12/2019.
 */
public class ModObjects {
	
	//Crafted
	public static final Item diamond_tusk_sword = Util.registerItem("diamond_tusk_sword");
	public static final Item iron_tusk_sword = Util.registerItem("iron_tusk_sword");
	public static final Item gold_tusk_sword = Util.registerItem("gold_tusk_sword");
	public static final Item howdah = Util.registerItem("howdah");
	public static final Item garment = Util.registerItem("garment");
	
	//Drops
	public static final Item eye_of_newt = Util.registerItem("eye_of_newt");
	public static final Item blindworms_sting = Util.registerItem("blindworms_sting");
	
	public static void preInit() {
	}
	
}