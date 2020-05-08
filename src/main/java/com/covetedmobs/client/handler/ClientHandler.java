package com.covetedmobs.client.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/**
 * Created by Joseph on 11/7/2019.
 */
@SuppressWarnings({"unused", "ConstantConditions"})
public class ClientHandler {
	
	public static int ticksInGame = 0;
	
	@SubscribeEvent
	public void clientTickEnd(TickEvent.ClientTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			GuiScreen gui = Minecraft.getMinecraft().currentScreen;
			if (gui == null || !gui.doesGuiPauseGame()) ++ticksInGame;
		}
	}
}
