package jjlr.treasure_drift.items;

import java.util.List;

import jjlr.treasure_drift.configuration;
import jjlr.treasure_drift.references;
import jjlr.treasure_drift.treasureAdriftMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraftforge.items.wrapper.EntityEquipmentInvWrapper;

public class bottleBase extends Item {
	
	protected String name;
	
	public bottleBase(String name, String modid) {
		
		this.name = name;
		
		setUnlocalizedName(name);
		setRegistryName(name);
		
		setMaxStackSize(1);
		
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
		public bottleBase setCreativeTab(CreativeTabs tab) {
			
			super.setCreativeTab(tab);
			return this;
			
		}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
		
		int Slot = playerIn.inventory.currentItem;
		
		ItemStack item = playerIn.getHeldItem(handIn);
		
		if(configuration.debugStatus == true) {
			System.out.println(references.NAME + ": Bottle right clicked...");
		}
		
		if(!worldIn.isRemote) {
			if(!playerIn.isCreative()) {
				item.shrink(1);
			}
			
			
			//Loot Table ; TODO: Move loot table to separate external method.
			LootTable table = worldIn.getLootTableManager().getLootTableFromLocation(new ResourceLocation(references.MODID + ":simple_bottle"));
			
			LootContext ctx = new LootContext.Builder((WorldServer) worldIn).build();
			
			List<ItemStack> stacks = table.generateLootForPools(worldIn.rand, ctx);
			
			ItemStack stack = stacks.get(0);
			
			playerIn.replaceItemInInventory(Slot, stack);
			
			//Loot Table end
			
			playerIn.sendMessage(new TextComponentString("Item right clicked"));
			
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
		} else {
			return new ActionResult<ItemStack>(EnumActionResult.FAIL, item);
		}
	}
	
}
