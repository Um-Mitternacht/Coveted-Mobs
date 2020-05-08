package com.covetedmobs.client.render.entity.living.arthropods;

import com.covetedmobs.CovetedMobs;
import com.covetedmobs.client.model.entity.arthropods.ModelPelicanSpider;
import com.covetedmobs.common.entity.living.arthropods.EntityPelicanSpider;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Joseph on 1/30/2020.
 */
public class RenderPelicanSpider extends RenderLiving<EntityPelicanSpider> {
	
	private static final ResourceLocation TEX = new ResourceLocation(CovetedMobs.MODID, "textures/entity/pelican_spider/pelican_spider.png");
	
	public RenderPelicanSpider(RenderManager manager) {
		super(manager, new ModelPelicanSpider(), 0.1f);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityPelicanSpider entity) {
		return TEX;
	}
	
	@Override
	protected void preRenderCallback(EntityPelicanSpider entity, float partialTickTime) {
		super.preRenderCallback(entity, partialTickTime);
		if (entity.isChild()) GlStateManager.scale(0.3, 0.3, 0.3);
		else GlStateManager.scale(1.2, 1.2, 1.2);
	}
}
