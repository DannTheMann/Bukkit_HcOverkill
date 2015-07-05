package me.danslayerx.overkill;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatColour implements Listener{
	
	@EventHandler
	public void playerChat(AsyncPlayerChatEvent e){
		
		Player p = e.getPlayer();
		
		if(p.hasPermission("HcRaid.ADMIN")){
			e.setMessage(ChatColor.YELLOW + e.getMessage());
		}else if(p.hasPermission("HcRaid.MOD")){
			e.setMessage(ChatColor.RED + e.getMessage());
		}
		
		
	}

}
