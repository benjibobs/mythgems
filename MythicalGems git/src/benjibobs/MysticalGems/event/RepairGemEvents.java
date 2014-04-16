package benjibobs.MysticalGems.event;

import java.util.Timer;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class RepairGemEvents {

	Minecraft mc = Minecraft.getMinecraft();
	public boolean shouldRepair = true;
	public static RepairGemEvents instance = new RepairGemEvents(); 
	
	public void init(EntityPlayer e){
			//Timer t = new Timer();
			//t.schedule(new RepairGemTask(e), 1000, 1000);
	}
	
}
