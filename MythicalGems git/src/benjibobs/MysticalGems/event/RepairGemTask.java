package benjibobs.MysticalGems.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import benjibobs.MysticalGems.common.MythicGems;

public class RepairGemTask{

	InventoryPlayer inv = null;
	MythicGems mg = MythicGems.instance;
	RepairGemEvents rge = new RepairGemEvents();
	boolean done = false;
	private static EntityPlayer p;
	public static RepairGemTask instance = new RepairGemTask();
	
	public void rgts(EntityPlayer e){
		if(e != null && e.inventory != null){
			inv = e.inventory;
		for(int i = 0; i < 36; i++){
			
			if(!done){
				
			if(inv.getStackInSlot(i) != null && inv.getStackInSlot(i).getItem() instanceof ItemTool){
				ItemStack item = inv.getStackInSlot(i);
				
				if(item.getItemDamage() != 0){
					if(inv.hasItem(mg.repairgem)){
						for(int i2 = 0; i2 < 36; i2++){
							if(inv.getStackInSlot(i2) != null && inv.getStackInSlot(i2).getItem().equals(mg.repairgem)){
								
									inv.getStackInSlot(i2).damageItem(1, e);
									//TODO: Implement max checker
									
									
									i2 = 35;
							}
						}
						item.setItemDamage(item.getItemDamage() - 1);
						done = true;
						
					}
				}
			}
			}
			if(i == 35){
				done = false;
				
			}
		}
		
		rge.shouldRepair = true;
		
		}else{
			rge.shouldRepair = true;
			done = false;
			return;
		}
	}

}
