package benjibobs.MysticalGems.common;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import benjibobs.MysticalGems.event.CommonEvents;
import benjibobs.MysticalGems.event.RepairGemEvents;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.server.FMLServerHandler;

@Mod(modid = MythicGems.modid, version = MythicGems.version)

public class MythicGems {

	public static final String modid = "bmythgems";
	public static final String version = "1.0";
	
	private RepairGemEvents rge = RepairGemEvents.instance;
	private Minecraft mc = Minecraft.getMinecraft();
	
	public static EntityPlayer p;
	
	public static CreativeTabs tabMGems = new CreativeTabs("MythicGems") {

		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return blankgem;
		}
       
	};
	
	public static Item repairgem;
	public static Item blankgem;
	public static Item flygem;
	public static Item craftinggem;
	
	//public static Block tramp;
	
	public final MinecraftServer mcs = FMLServerHandler.instance().getServer();
	
	@Instance("bmythgems") //The instance, this is very important later on
	public static MythicGems instance = new MythicGems();
	
	@EventHandler
    public void init(FMLInitializationEvent event)
    {
		
		repairgem = new ItemRepairGem();
		repairgem.setUnlocalizedName("brepairgem");
		GameRegistry.registerItem(repairgem, "myth_repairgem");
		
		blankgem = new ItemBlankGem();
		blankgem.setUnlocalizedName("bblankgem");
		GameRegistry.registerItem(blankgem, "myth_blankgem");
		
		flygem = new ItemFlyGem();
		flygem.setUnlocalizedName("bflightgem");
		GameRegistry.registerItem(flygem, "myth_flightgem");
		
		craftinggem = new ItemCraftGem();
		craftinggem.setUnlocalizedName("bcraftinggem");
		GameRegistry.registerItem(craftinggem, "myth_craftinggem");
		
		/** RECIPES */
		ItemStack blankGemStack = new ItemStack(blankgem);
		ItemStack diamondStack = new ItemStack(Items.diamond);
		ItemStack goldStack = new ItemStack(Items.gold_ingot);
		ItemStack cobbleStack = new ItemStack(Blocks.cobblestone);
		ItemStack ironStack = new ItemStack(Items.iron_ingot);
		ItemStack paperStack = new ItemStack(Items.paper);
		ItemStack featherStack = new ItemStack(Items.feather);
		ItemStack workbenchStack = new ItemStack(Blocks.crafting_table);
		
		GameRegistry.addRecipe(new ItemStack(repairgem), " y ", "hbe", " x ", 'b', blankGemStack, 'y', diamondStack, 'e', goldStack, 'h', cobbleStack, 'x', ironStack);
		GameRegistry.addRecipe(new ItemStack(blankgem), " p ", "pdp", " p ", 'p', paperStack, 'd', diamondStack);
		GameRegistry.addRecipe(new ItemStack(flygem), " p ", "pdp", " p ", 'p', featherStack, 'd', blankGemStack);
		GameRegistry.addShapelessRecipe(new ItemStack(craftinggem), workbenchStack, blankGemStack);
		
    }
	
	@EventHandler
	public void addEvents(FMLInitializationEvent event){
		FMLCommonHandler.instance().bus().register(new CommonEvents());
		MinecraftForge.EVENT_BUS.register(new CommonEvents());
	}
	
	public void onWorldTick(){
	}
	

	
}
