package com.covetedmobs.client.render.entity.living.herps;

import com.covetedmobs.CovetedMobs;
import com.covetedmobs.client.model.entity.herps.ModelNewt;
import com.covetedmobs.common.entity.living.herps.EntityNewt;
import com.covetedmobs.common.entity.util.ModEntityAnimal;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Joseph on 11/6/2019.
 */
@SuppressWarnings("NullableProblems")
@SideOnly(Side.CLIENT)
public class RenderNewt extends RenderLiving<EntityNewt> {
	private static final ResourceLocation[] TEX = {new ResourceLocation(CovetedMobs.MODID, "textures/entity/european_newt_one/newt_1.png"), new ResourceLocation(CovetedMobs.MODID, "textures/entity/european_newt_one/newt_2.png"), new ResourceLocation(CovetedMobs.MODID, "textures/entity/european_newt_one/newt_3.png"), new ResourceLocation(CovetedMobs.MODID, "textures/entity/european_newt_one/newt_4.png")};
	
	public RenderNewt(RenderManager manager) {
		super(manager, new ModelNewt(), 0.1f);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityNewt entity) {
		return TEX[entity.getDataManager().get(ModEntityAnimal.SKIN)];
	}
	
	@Override
	protected void preRenderCallback(EntityNewt entity, float partialTickTime) {
		super.preRenderCallback(entity, partialTickTime);
		if (entity.isChild()) GlStateManager.scale(0.2, 0.2, 0.2);
		else GlStateManager.scale(0.3, 0.3, 0.3);
	}
}