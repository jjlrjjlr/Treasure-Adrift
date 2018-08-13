package jjlr.treasure_drift.items;

import jjlr.treasure_drift.configuration;
import jjlr.treasure_drift.references;
//import jjlr.treasure_drift.items.basicItem;
import jjlr.treasure_drift.items.bottleBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class modItems {
	
	public static bottleBase basicBottle = new bottleBase("basic_bottle", references.MODID).setCreativeTab(CreativeTabs.MATERIALS);
		
		public static void register(IForgeRegistry<Item> registry) {
			
			registry.registerAll(
					
					basicBottle
			);
			
			/* Debug start */
			if(configuration.debugStatus == true) {
				System.out.println(references.MODID + ": Items all registered.");
			}
			/* Debug end */
		}
		
		public static void registerModels() {
			
			basicBottle.registerItemModel();
		}

}
