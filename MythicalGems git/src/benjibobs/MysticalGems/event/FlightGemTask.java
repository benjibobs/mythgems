package benjibobs.MysticalGems.event;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import benjibobs.MysticalGems.common.MythicGems;


public class FlightGemTask {

	public void fgts(EntityPlayer e) {

		MythicGems mg = MythicGems.instance;
		
		if(e != null && e.inventory != null){
			if(e.inventory.hasItem(mg.flygem) && e.capabilities.isFlying){
				for(int i = 0; i < 36; i++){
					if(e.inventory.getStackInSlot(i) != null && e.inventory.getStackInSlot(i).getItem().equals(mg.flygem)){
						if(e.inventory.getStackInSlot(i).getItemDamage() <= 59){
							e.inventory.getStackInSlot(i).setItemDamage(e.inventory.getStackInSlot(i).getItemDamage() + 1);
						}else{
							e.inventory.getStackInSlot(i).setItemDamage(60);
							e.inventory.clearInventory(mg.flygem, 60);
						}
					}
				}
			}
		}
		
	}

}
