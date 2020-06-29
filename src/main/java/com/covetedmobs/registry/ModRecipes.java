package com.covetedmobs.registry;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Joseph on 5/13/2020.
 */
public class ModRecipes {

    public static void init() {
        furnaceInit();
    }

    private static void furnaceInit() {
        GameRegistry.addSmelting(ModObjects.bushmeat_raw, new ItemStack(ModObjects.bushmeat_cooked), 0.35f);
    }
}
