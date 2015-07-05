package me.danslayerx.overkill.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class CatchExpression implements Listener{
	
	@EventHandler
	public void catchWrongTerm(AsyncPlayerChatEvent e){
	
		Player p = e.getPlayer();
		
		if(p.hasPermission("HcRaid.OWNER")){
			return;
		}
		
		e.setMessage(e.getMessage().
				replaceAll("(?i)donation", "payment").
				replaceAll("(?i)donar|donor|donator|donater", "Subscriber").replaceAll("(?i)donate", "pay"));
		
		
		
	}

}
