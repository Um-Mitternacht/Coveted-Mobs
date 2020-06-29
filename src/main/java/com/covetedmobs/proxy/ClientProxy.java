package com.covetedmobs.proxy;

import com.covetedmobs.client.render.entity.living.arthropods.RenderPelicanSpider;
import com.covetedmobs.client.render.entity.living.herps.RenderBlindworm;
import com.covetedmobs.client.render.entity.living.herps.RenderNewt;
import com.covetedmobs.client.render.entity.living.mammals.RenderElephant;
import com.covetedmobs.client.render.entity.living.mammals.RenderOryx;
import com.covetedmobs.client.render.entity.living.mammals.RenderTiger;
import com.covetedmobs.common.entity.living.arthropods.EntityPelicanSpider;
import com.covetedmobs.common.entity.living.herps.EntityBlindworm;
import com.covetedmobs.common.entity.living.herps.EntityNewt;
import com.covetedmobs.common.entity.living.mammals.EntityElephant;
import com.covetedmobs.common.entity.living.mammals.EntityOryx;
import com.covetedmobs.common.entity.living.mammals.EntityTiger;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;


@SuppressWarnings({"ConstantConditions", "unused", "WeakerAccess"})
@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends ServerProxy {
    public static final Map<Item, ModelBase> IDOL_MODELS = new HashMap<>();
    public static final Map<Item, ResourceLocation> IDOL_TEXTURES = new HashMap<>();

    @SubscribeEvent
    public static void stitch(TextureStitchEvent.Pre event) {
    }

    public static void registerIdol(Item item, ModelBase model, ResourceLocation texture) {
        IDOL_MODELS.put(item, model);
        IDOL_TEXTURES.put(item, texture);
    }

    @Override
    public List<ItemStack> getEntireInventory(EntityPlayer unused) {
        return super.getEntireInventory(Minecraft.getMinecraft().player);
    }

    @Override
    public boolean isFancyGraphicsEnabled() {
        return Minecraft.getMinecraft().gameSettings.fancyGraphics;
    }

    @Override
    public void registerRendersInit() {
    }

    @Override
    public void registerRendersPreInit() {
        RenderingRegistry.registerEntityRenderingHandler(EntityBlindworm.class, RenderBlindworm::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityNewt.class, RenderNewt::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityElephant.class, RenderElephant::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityOryx.class, RenderOryx::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityPelicanSpider.class, RenderPelicanSpider::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTiger.class, RenderTiger::new);
    }

    @Override
    public void registerTexture(Item item, String variant) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), variant));
    }

    @Override
    public void registerTextureVariant(Item item, List<Predicate<ItemStack>> predicates) {
        ResourceLocation[] names = new ResourceLocation[predicates.size() + 1];
        for (int i = 0; i <= predicates.size(); i++)
            names[i] = new ResourceLocation(item.getRegistryName().toString() + (i == 0 ? "" : "_variant" + (predicates.size() == 1 ? "" : (i - 1))));
        ModelBakery.registerItemVariants(item, names);
        ModelLoader.setCustomMeshDefinition(item, stack -> {
            for (int i = 0; i < predicates.size(); i++)
                if (predicates.get(i).test(stack)) return new ModelResourceLocation(names[i + 1], "inventory");
            return new ModelResourceLocation(item.getRegistryName(), "inventory");
        });
    }

    @Override
    public void ignoreProperty(Block block, IProperty<?>... properties) {
        ModelLoader.setCustomStateMapper(block, new StateMap.Builder().ignore(properties).build());
    }
}