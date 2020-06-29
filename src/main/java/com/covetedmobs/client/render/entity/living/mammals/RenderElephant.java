package com.covetedmobs.client.render.entity.living.mammals;

import com.covetedmobs.CovetedMobs;
import com.covetedmobs.client.model.entity.mammals.ModelElephant;
import com.covetedmobs.common.entity.living.mammals.EntityElephant;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

/**
 * Created by Joseph on 12/1/2019.
 */
public class RenderElephant extends RenderLiving<EntityElephant> {

    private static final ResourceLocation AFRICAN = new ResourceLocation(CovetedMobs.MODID, "textures/entity/elephants/african_elephant.png");
    private static final ResourceLocation ASIAN = new ResourceLocation(CovetedMobs.MODID, "textures/entity/elephants/asian_elephant.png");

    public RenderElephant(RenderManager manager) {
        super(manager, new ModelElephant(), 0.1f);
        //addLayer(new LayerElephantSwords());
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityElephant entity) {
        switch (entity.getElephantType()) {
            case 0:
            default:
                return AFRICAN;
            case 1:
                return ASIAN;
        }
    }

    @Override
    protected void preRenderCallback(EntityElephant entity, float partialTickTime) {
        super.preRenderCallback(entity, partialTickTime);
        if (entity.isChild()) GlStateManager.scale(1.2, 1.2, 1.2);
        else GlStateManager.scale(2.0, 2.0, 2.0);
    }
}
