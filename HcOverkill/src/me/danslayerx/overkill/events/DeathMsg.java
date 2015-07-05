package me.danslayerx.overkill.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathMsg implements Listener{
	
	@EventHandler
	public void playerDeath(PlayerDeathEvent e){
		
		if(e.getEntity() instanceof Player){
			
			if(e.getEntity().getKiller() instanceof Player){
				
				if(e.getEntity().getKiller().getItemInHand().getType() != Material.AIR)
					e.setDeathMessage(e.getEntity().getName() + " was killed by " + e.getEntity().getKiller().getName() + " using a " + ChatColor.BLUE + e.getEntity().getKiller().getItemInHand().getType().toString().toLowerCase().replaceAll("_", " ") + "!");
				else
					e.setDeathMessage(e.getEntity().getName() + " was killed by " + e.getEntity().getKiller().getName() + "!");
			}
			
		}
		
	}

}
