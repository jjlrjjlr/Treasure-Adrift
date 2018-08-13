package jjlr.treasure_drift;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.SidedProxy;

import java.io.File;

//Mod imports
import jjlr.treasure_drift.references;
import jjlr.treasure_drift.proxy.commonProxy;

@Mod(modid = references.MODID, name = references.NAME, version = references.VERSION)
public class treasureAdriftMain {
	
	public static File config;
	
	@Instance
	public static treasureAdriftMain instance;
	
	@SidedProxy(clientSide = references.CLIENT_PROXY, serverSide = references.COMMON_PROXY)
	public static commonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(references.NAME + ": Starting...");
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		
		LootTableList.register(new ResourceLocation(references.MODID, "simple_bottle"));
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println(references.NAME + ": Successfully started...");
	}

}
