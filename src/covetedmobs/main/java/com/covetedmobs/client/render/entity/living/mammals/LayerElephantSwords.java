package com.covetedmobs.client.render.entity.living.mammals;

import com.covetedmobs.common.entity.living.mammals.EntityElephant;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Joseph on 12/12/2019.
 */
public class LayerElephantSwords implements LayerRenderer<EntityElephant> {
	
	private static final ResourceLocation[] ELEPHANT_SWORD_TEXTURES = new ResourceLocation[]{new ResourceLocation("textures/entity/elephants/iron_tusks"), new ResourceLocation("textures/entity/elephants/gold_tusks"), new ResourceLocation("textures/entity/elephants/diamond_tusks")};
	
	@Override
	public void doRenderLayer(EntityElephant entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
	
	}
	
	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
}
