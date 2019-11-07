package com.covetedmobs.client.render.entity.living.herps;

import com.covetedmobs.CovetedMobs;
import com.covetedmobs.client.model.entity.herps.ModelBlindworm;
import com.covetedmobs.common.entity.living.herps.EntityBlindworm;
import com.covetedmobs.registry.ModTextures;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Joseph on 11/6/2019.
 */
@SideOnly(Side.CLIENT)
public class RenderBlindworm extends RenderLiving<EntityBlindworm> {
	
	public RenderBlindworm(RenderManager manager) {
		super(manager, new ModelBlindworm(), 0.1f);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityBlindworm entity) {
		return new ResourceLocation(CovetedMobs.MODID, "textures/entity/blindworm.png");
	}
	
	@Override
	protected void preRenderCallback(EntityBlindworm entity, float partialTickTime) {
		super.preRenderCallback(entity, partialTickTime);
		if (entity.isChild()) GlStateManager.scale(0.4, 0.4, 0.4);
		else GlStateManager.scale(0.6, 0.6, 0.6);
	}
}