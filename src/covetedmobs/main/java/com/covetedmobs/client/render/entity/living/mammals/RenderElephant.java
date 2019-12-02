package com.covetedmobs.client.render.entity.living.mammals;

import com.covetedmobs.CovetedMobs;
import com.covetedmobs.client.model.entity.mammals.ModelElephant;
import com.covetedmobs.common.entity.living.mammals.EntityElephant;
import com.covetedmobs.common.entity.util.ModEntityTameable;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Joseph on 12/1/2019.
 */
public class RenderElephant extends RenderLiving<EntityElephant> {
	private static final ResourceLocation[] TEX = {new ResourceLocation(CovetedMobs.MODID, "textures/entity/elephants/african_elephant.png"), new ResourceLocation(CovetedMobs.MODID, "textures/entity/elephants/asian_elephant.png")};
	
	public RenderElephant(RenderManager manager) {
		super(manager, new ModelElephant(), 0.1f);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityElephant entity) {
		return TEX[entity.getDataManager().get(ModEntityTameable.SKIN)];
	}
	
	@Override
	protected void preRenderCallback(EntityElephant entity, float partialTickTime) {
		super.preRenderCallback(entity, partialTickTime);
		if (entity.isChild()) GlStateManager.scale(1.4, 1.4, 1.4);
		else GlStateManager.scale(2.7, 2.7, 2.7);
	}
}
