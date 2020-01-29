package com.covetedmobs.client.render.entity.living.mammals;

import com.covetedmobs.CovetedMobs;
import com.covetedmobs.client.model.entity.mammals.ModelElephant;
import com.covetedmobs.client.model.entity.mammals.ModelOryx;
import com.covetedmobs.common.entity.living.mammals.EntityElephant;
import com.covetedmobs.common.entity.living.mammals.EntityOryx;
import com.covetedmobs.common.entity.util.ModEntityAnimal;
import com.covetedmobs.common.entity.util.ModEntityTameable;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Joseph on 12/1/2019.
 */
public class RenderOryx extends RenderLiving<EntityOryx> {
	private static final ResourceLocation TEX_BABY = new ResourceLocation(CovetedMobs.MODID, "textures/entity/oryxes/oryx_baby.png");
	private static final ResourceLocation[] TEX = {new ResourceLocation(CovetedMobs.MODID, "textures/entity/oryxes/oryx_1.png"), new ResourceLocation(CovetedMobs.MODID, "textures/entity/oryxes/oryx_2.png")};
	
	public RenderOryx(RenderManager manager) {
		super(manager, new ModelOryx(), 0.1f);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityOryx entity) {
		if (entity.isChild())
			return TEX_BABY;
		else if (!entity.isChild())
			return TEX[entity.getDataManager().get(ModEntityAnimal.SKIN)];
		return null;
	}
	
	
	@Override
	protected void preRenderCallback(EntityOryx entity, float partialTickTime) {
		super.preRenderCallback(entity, partialTickTime);
		if (entity.isChild()) GlStateManager.scale(0.5, 0.5, 0.5);
		else GlStateManager.scale(1.0, 1.0, 1.0);
	}
}
