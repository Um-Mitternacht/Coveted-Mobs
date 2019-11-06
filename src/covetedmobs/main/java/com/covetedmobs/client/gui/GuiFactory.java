package com.covetedmobs.client.gui;

import com.covetedmobs.CovetedMobs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;

import java.util.Set;

/**
 * Created by Joseph on 11/6/2019.
 */
public class GuiFactory implements IModGuiFactory {
	public GuiFactory() {
	}
	
	public void initialize(Minecraft minecraftInstance) {
	}
	
	public boolean hasConfigGui() {
		return true;
	}
	
	
	@Override
	public GuiScreen createConfigGui(GuiScreen parentScreen) {
		return new GuiConfig(parentScreen, CovetedMobs.MODID, CovetedMobs.NAME);
	}
	
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
		return null;
	}
}