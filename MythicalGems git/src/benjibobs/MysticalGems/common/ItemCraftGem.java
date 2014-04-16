package benjibobs.MysticalGems.common;

import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.server.FMLServerHandler;

public class ItemCraftGem extends Item {

	public ItemCraftGem(){
		this.setCreativeTab(MythicGems.tabMGems);
		this.canRepair = false;
		this.maxStackSize = 1;
	}
	
	Random r = new Random();
	
	MinecraftServer mc = FMLServerHandler.instance().getServer();
	
	int x = r.nextInt(5000);
	int y = r.nextInt(56);
	int z = r.nextInt(5000);
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {

		itemIcon = iconRegister.registerIcon(MythicGems.modid + ":" + "craftgem");

	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack ItemStack, World World, EntityPlayer EntityPlayer) {
		
		check(EntityPlayer);
		
		EntityPlayer.displayGUIWorkbench(x, y, z);
		
		EntityPlayer.worldObj.setBlock(x, y, z, Blocks.air);
		
		return super.onItemRightClick(ItemStack, World, EntityPlayer);
	}
	
	public void check(EntityPlayer p){
		//TODO: Fix null pointer (world related - Also get world server side!)
		if(mc.getEntityWorld().getBlock(x, y, z).equals(null)){
			
			p.worldObj.setBlock(x, y, z, Blocks.crafting_table);
			
			return;
			
		}else{
			x = r.nextInt(5000);
			y = r.nextInt(56);
			z = r.nextInt(5000);
			check(p);
		}
	}
	
}
