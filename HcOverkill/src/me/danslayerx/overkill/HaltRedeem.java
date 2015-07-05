package me.danslayerx.overkill;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class HaltRedeem implements Listener{
	
	@EventHandler
	public void execute(PlayerCommandPreprocessEvent e){
		
		if(e.getMessage().split(" ")[0].equalsIgnoreCase("/redeem")){
			e.setCancelled(true);
			e.getPlayer().sendMessage(Main.title + "Redeem will be enabled on the 5th of July! This is to LET everyone have a fair start!");
		}
		
	}

}
