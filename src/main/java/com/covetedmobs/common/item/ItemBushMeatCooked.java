package com.covetedmobs.common.item;

import com.covetedmobs.client.Util;
import net.minecraft.item.ItemFood;

/**
 * Created by Joseph on 5/7/2020.
 */
public class ItemBushMeatCooked extends ItemFood {
	public ItemBushMeatCooked() {
		super(6, 0.7f, true);
		Util.registerItem(this, "bushmeat_cooked", "listAllmeatcooked");
	}
}
