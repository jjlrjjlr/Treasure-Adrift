package jjlr.treasure_drift.items;

import jjlr.treasure_drift.treasureAdriftMain;
import jjlr.treasure_drift.configuration;
import jjlr.treasure_drift.references;
import jjlr.treasure_drift.items.basicItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class basicItem extends Item {
	
	protected String name;

	public basicItem(String name, String modid) {
		
		this.name = name;
		
		setUnlocalizedName(name);
		setRegistryName(name);
		
		/* Debug start */
		if(configuration.debugStatus == true) {
			System.out.println(references.MODID + ": " + name + " created.");
		}
		/* Debug end */
	}
	
	// Register item renderer with proxy.
	public void registerItemModel() {
		
		treasureAdriftMain.proxy.registerItemRenderer(this, 0, name);
		
	}
	
	// Set creative tab.
	@Override
	public basicItem setCreativeTab(CreativeTabs tab) {
		
		super.setCreativeTab(tab);
		return this;
		
	}

}
