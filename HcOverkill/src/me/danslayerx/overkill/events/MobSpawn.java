package me.danslayerx.overkill.events;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class MobSpawn implements Listener{
	
	@EventHandler
	public void hipsterSpawn(CreatureSpawnEvent e){
		
		int rand = new Random().nextInt(24)+1;
		if(rand == 1){
		
			String name = "ERROR the ";
			
			try {
			 URL nameGen = new URL("http://gwap.kodingen.com/name.php/");
			 
		        BufferedReader in;
				
					in = new BufferedReader(
					new InputStreamReader(nameGen.openStream()));
				

		        String inputLine;
		        while ((inputLine = in.readLine()) != null)
		            name = inputLine + " the ";
		        in.close();
		       
		        rand = new Random().nextInt(24)+1;
		        if(rand == 1){
		        	rand = new Random().nextInt(Bukkit.getOfflinePlayers().length);
		        	int count = 0;
		        	for(Player p : Bukkit.getOnlinePlayers()){
		        		
		        		if(count == rand){
		        			name = p.getName() + " the ";
		        			break;
		        		}
		        		
		        		
		        		
		        	}
		        }
		        
		} catch (IOException e1) {
		    System.out.println("[HcOverkill] An error occured while trying to retreive information from the URL!");
			e1.printStackTrace();
		}
			
		e.getEntity().setCustomName( getRandomChatColor() + name + e.getEntityType().getName().toLowerCase().replaceAll("_", " "));
		e.getEntity().setCustomNameVisible(true);
		}
	}
		
		private final int maxEntityPer3x3Chunk = 120;
		
		private boolean stop = false;
		
		@EventHandler
		public void entitySpawned(CreatureSpawnEvent cse) {
			if(cse.getLocation().getWorld().getName().equalsIgnoreCase("world_the_end")){
				return;
			}
			if (cse.getEntity().getNearbyEntities(64, 128, 64).size() >= maxEntityPer3x3Chunk) {
				cse.setCancelled(true);
				}
			if (!stop) {
				stop = true;
			}
			return;
		}

	private String getRandomChatColor() {
		int rand = new Random().nextInt(17)+1;
		switch(rand){
		case 1:
			return ChatColor.AQUA + "";
		case 2:
			return ChatColor.BLACK + "";
		case 3:
			return ChatColor.BLUE + "";
		case 4:
			return ChatColor.BOLD + "";
		case 5:
			return ChatColor.DARK_AQUA + "";
		case 6:
			return ChatColor.DARK_BLUE + "";
		case 7:
			return ChatColor.DARK_GRAY + "";
		case 8:
			return ChatColor.DARK_GREEN + "";
		case 9:
			return ChatColor.DARK_PURPLE + "";
		case 10:
			return ChatColor.DARK_RED + "";
		case 11:
			return ChatColor.GOLD + "";
		case 12:
			return ChatColor.DARK_RED + "";
		case 13:
			return ChatColor.GRAY + "";
		case 14:
			return ChatColor.ITALIC + "";
		case 15:
			return ChatColor.LIGHT_PURPLE + "";
		case 16:
			return ChatColor.MAGIC + "";
		case 17:
			return ChatColor.RED + "";
		}
		return ChatColor.AQUA + "";
	}

}
