package com.covetedmobs.client.render.entity.living.mammals;

import com.covetedmobs.CovetedMobs;
import com.covetedmobs.client.model.entity.mammals.ModelTiger;
import com.covetedmobs.common.entity.living.mammals.EntityTiger;
import com.covetedmobs.common.entity.util.ModEntityMob;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Joseph on 3/18/2020.
 */
public class RenderTiger extends RenderLiving<EntityTiger> {
	
	
	private static final ResourceLocation[] TEX = {new ResourceLocation(CovetedMobs.MODID, "textures/entity/tigers/tiger_standard.png"), new ResourceLocation(CovetedMobs.MODID, "textures/entity/tigers/tiger_standard.png"), new ResourceLocation(CovetedMobs.MODID, "textures/entity/tigers/tiger_standard.png"), new ResourceLocation(CovetedMobs.MODID, "textures/entity/tigers/tiger_standard.png"), new ResourceLocation(CovetedMobs.MODID, "textures/entity/tigers/tiger_maltese.png"), new ResourceLocation(CovetedMobs.MODID, "textures/entity/tigers/tiger_white.png"), new ResourceLocation(CovetedMobs.MODID, "textures/entity/tigers/tiger_melanistic.png"), new ResourceLocation(CovetedMobs.MODID, "textures/entity/tigers/tiger_golden.png")};
	
	public RenderTiger(RenderManager manager) {
		super(manager, new ModelTiger(), 0.1f);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityTiger entity) {
		return TEX[entity.getDataManager().get(ModEntityMob.SKIN)];
	}
	
	@Override
	protected void preRenderCallback(EntityTiger entity, float partialTickTime) {
		super.preRenderCallback(entity, partialTickTime);
		if (entity.isChild()) GlStateManager.scale(0.6, 0.6, 0.6);
		else GlStateManager.scale(1.0, 1.0, 1.0);
	}
	
}