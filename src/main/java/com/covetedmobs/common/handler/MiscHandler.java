package com.covetedmobs.common.handler;

import com.covetedmobs.common.entity.living.mammals.EntityTiger;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Joseph on 4/22/2020.
 */
public class MiscHandler {
    @SubscribeEvent
    public void onFindAttackEntity(LivingSetAttackTargetEvent event) {
        if (event.getEntityLiving() instanceof EntityTiger && event.getTarget() instanceof EntityTiger) {
            ((EntityTiger) event.getEntityLiving()).setAttackTarget(null);
        }
    }
}
