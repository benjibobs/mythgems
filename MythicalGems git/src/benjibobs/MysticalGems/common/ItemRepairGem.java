package benjibobs.MysticalGems.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemRepairGem extends Item {

	public ItemRepairGem(){
		this.setCreativeTab(MythicGems.tabMGems);
		this.setMaxDamage(2342); //ONE DIAMOND TOOL + A HALF
		this.canRepair = false;
		this.maxStackSize = 1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {

		itemIcon = iconRegister.registerIcon(MythicGems.modid + ":" + "repairgem");

	}
	
}
