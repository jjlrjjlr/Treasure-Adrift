package jjlr.treasure_drift.events;

import jjlr.treasure_drift.items.modItems;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class registerItems {

	/*
	 * Used to register items.
	 */
	@Mod.EventBusSubscriber
	public static class RegistrationHandler{
		
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			modItems.register(event.getRegistry());
		}
		
		@SubscribeEvent
		public static void registerItem(ModelRegistryEvent event) {
			modItems.registerModels();
		}
	}
}
