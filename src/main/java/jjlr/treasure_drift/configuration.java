package jjlr.treasure_drift;

import java.io.File;

import jjlr.treasure_drift.treasureAdriftMain;
import jjlr.treasure_drift.references;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class configuration {

	public static Configuration config;
	
	public static boolean debugStatus = true;
	
	public static void init(File file) {
		
		config = new Configuration(file);
		
		String category;
		
		category = "Debug";
		
		config.addCustomCategoryComment(category, "Debug settings, configure or disable debugging.");
		
		debugStatus = config.getBoolean("Debug enabled", category, true, "Toggle development debugging.", "en_us");
		
		category = "Features";
		
		//save
		if(config.hasChanged()) {
			config.save();
		}
		
	}
	
	public static void registerConfig(FMLPreInitializationEvent event) {
		treasureAdriftMain.config = new File(event.getModConfigurationDirectory() + "/" + references.MODID);
		treasureAdriftMain.config.mkdirs();
		init(new File(treasureAdriftMain.config.getPath() + File.separator + references.MODID + ".cfg"));
	}
}
