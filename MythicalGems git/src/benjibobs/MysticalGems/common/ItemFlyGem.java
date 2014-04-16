package benjibobs.MysticalGems.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemFlyGem extends Item {

	public ItemFlyGem(){
		this.setCreativeTab(MythicGems.tabMGems);
		this.setMaxDamage(60);
		this.canRepair = false;
		this.maxStackSize = 1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {

		itemIcon = iconRegister.registerIcon(MythicGems.modid + ":" + "flightgem");

	}
	
}
