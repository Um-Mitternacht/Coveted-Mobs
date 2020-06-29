package com.covetedmobs.common.item;

import com.covetedmobs.client.Util;
import net.minecraft.item.ItemFood;

/**
 * Created by Joseph on 5/7/2020.
 */
public class ItemBushMeatRaw extends ItemFood {
    public ItemBushMeatRaw() {
        super(3, 0.4f, true);
        Util.registerItem(this, "bushmeat_raw", "listAllmeatraw");
    }
}
