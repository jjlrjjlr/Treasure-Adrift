package jjlr.treasure_drift.proxy;

import jjlr.treasure_drift.references;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class clientProxy extends commonProxy {

	/*
	 * Used to render items in game.
	 */
	public void registerItemRenderer(Item item, int meta, String id) {
		
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(references.MODID + ":" + id, "inventory"));
	}
}
