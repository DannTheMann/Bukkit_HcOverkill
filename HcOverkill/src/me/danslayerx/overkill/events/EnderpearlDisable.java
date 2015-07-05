package me.danslayerx.overkill.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class EnderpearlDisable implements Listener{
	
	@EventHandler
	public void enderpearlDisable(PlayerInteractEvent e){
		
		if(e.getPlayer().hasPermission("HcRaid.OWNER")){
			return;
		}
		
		if(e.getPlayer().getItemInHand() != null){
		
		if(!e.getPlayer().getWorld().getName().equalsIgnoreCase("upperClass")){
			return;
		}
			
		if((e.getAction() == Action.RIGHT_CLICK_AIR)
			|| (e.getAction() == Action.RIGHT_CLICK_BLOCK)){
			
			if(e.getPlayer().getItemInHand().getType().equals(Material.ENDER_PEARL)
					|| (e.getPlayer().getItemInHand().getType().equals(Material.WATER_BUCKET))
					|| (e.getPlayer().getItemInHand().getType().equals(Material.LAVA_BUCKET)))
				e.setCancelled(true);
				
			}
		
		}
		
	}

}
