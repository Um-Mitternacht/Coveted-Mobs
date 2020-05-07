package com.covetedmobs.registry;

import com.covetedmobs.client.Util;
import com.covetedmobs.common.item.ItemBushMeatRaw;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

/**
 * Created by Joseph on 12/12/2019.
 */
public class ModObjects {
	
	//Crafted
	public static final Item diamond_tusk_sword = Util.registerItem("diamond_tusk_sword");
	public static final Item iron_tusk_sword = Util.registerItem("iron_tusk_sword");
	public static final Item gold_tusk_sword = Util.registerItem("gold_tusk_sword");
	public static final Item howdah = Util.registerItem("howdah");
	public static final Item elephant_garment = Util.registerItem("elephant_garment");
	
	//Drops
	public static final Item eye_of_newt = Util.registerItem("eye_of_newt");
	public static final Item blindworms_sting = Util.registerItem("blindworms_sting");
	public static final Item elephant_skull = Util.registerItem("elephant_skull");
	public static final ItemFood bushmeat_raw = new ItemBushMeatRaw();
	
	public static void preInit() {
	}
	
}