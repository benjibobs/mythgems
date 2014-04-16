package benjibobs.MysticalGems.event;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import benjibobs.MysticalGems.common.MythicGems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class CommonEvents {

	public final MythicGems mg = MythicGems.instance;
	Minecraft mc = Minecraft.getMinecraft();
	RepairGemEvents rge = RepairGemEvents.instance;
	public static boolean shouldRun = true;
	RepairGemTask rgt = RepairGemTask.instance;
	private static long cur = 0;
	private static long fcur = 0;
	
	//TODO: Decide finalised tick timers
	
	@SubscribeEvent
	public void repairGemTickHandler(TickEvent.WorldTickEvent event){
	
		if(cur <= 100){
			cur++;
		}else{
			cur = 0;
			rgt.rgts(mg.p);
		}
		
	}
	
	@SubscribeEvent
	public void flightGemTickHandler(TickEvent.WorldTickEvent event){
	
		if(fcur <= 6000){
			fcur++;
		}else{
			fcur = 0;
			rgt.rgts(mg.p);
		}
		
		if((mg.p != null) && (mg.p.inventory != null) && (mg.p.inventory.hasItem(mg.flygem) && !mg.p.capabilities.isCreativeMode)){
			mg.p.capabilities.allowFlying = true;
		}else if((mg.p != null) && (mg.p.inventory != null) && !mg.p.capabilities.isCreativeMode){
			mg.p.capabilities.allowFlying = false;
			mg.p.capabilities.isFlying = false;
		}
		
	}
	
	@SubscribeEvent
	public void onPlayerJoin(EntityJoinWorldEvent event){
		if(event.entity instanceof EntityPlayer){
			mg.p = (EntityPlayer)event.entity;
		}
	}
}
