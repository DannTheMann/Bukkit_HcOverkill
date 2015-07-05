package me.danslayerx.overkill.commands;

import java.util.HashMap;

import me.danslayerx.overkill.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Spawn implements CommandExecutor{
	
	public static HashMap<String, Location> spawnPosition = new HashMap<String, Location>();
	public static HashMap<String, Integer> spawnTimer = new HashMap<String, Integer>();
	public static HashMap<String, Integer> spawnTask = new HashMap<String, Integer>();
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l,
			String[] args) {
		if(c.getName().equalsIgnoreCase("spawn")){
			
			if(s instanceof Player){
				
				if(s.hasPermission("HcRaid.ADMIN")){
					((Player) s).teleport(Bukkit.getWorld("world").getSpawnLocation());
					return false;
				}
				executeTimer((Player) s);
				
			}
			
		}
		return false;
	}

	private void executeTimer(final Player s) {
		
		s.sendMessage(Main.title + ChatColor.YELLOW + "Teleporting to spawn in 7 seconds, do not move.");
		
		if(spawnTask.containsKey(s.getName())){
			Main.p.getServer().getScheduler().cancelTask(spawnTask.get(s.getName()));
			spawnTask.remove(s.getName());
			spawnTimer.remove(s.getName());
			spawnPosition.remove(s.getName());
		}
		
		if(spawnTimer.containsKey(s.getName())){
			Main.p.getServer().getScheduler().cancelTask(spawnTask.get(s.getName()));
			spawnTask.remove(s.getName());
			spawnTimer.remove(s.getName());
			spawnPosition.remove(s.getName());
		}
		
		spawnPosition.put(s.getName(), s.getLocation());
 	    
 	   spawnTimer.put(s.getName(), 0);
 	    
 		spawnTask.put(s.getName(), Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.p, new BukkitRunnable() {
 		    public void run(){
 		    	
		    	if((s.getLocation().getBlockX() != spawnPosition.get(s.getName()).getBlockX()) ||
			    		((s.getLocation().getBlockY() != spawnPosition.get(s.getName()).getBlockY())) ||
			    		 ((s.getLocation().getBlockZ() != spawnPosition.get(s.getName()).getBlockZ()))){
	 	    	
		    		s.sendMessage(Main.title + ChatColor.RED + "Teleportation cancelled.");
					Main.p.getServer().getScheduler().cancelTask(spawnTask.get(s.getName()));
					spawnTask.remove(s.getName());
					spawnTimer.remove(s.getName());
					spawnPosition.remove(s.getName());
	 	    }
		    	
		    	if(spawnTimer.get(s.getName()) >= 7){
		    		if(s != null)
		    			s.sendMessage(Main.title + ChatColor.GREEN + "Teleporting to Spawn! Remember to screenshot all bases you get!");
		    		s.teleport(Bukkit.getWorld("world").getSpawnLocation());
					Main.p.getServer().getScheduler().cancelTask(spawnTask.get(s.getName()));
					spawnTask.remove(s.getName());
					spawnTimer.remove(s.getName());
					spawnPosition.remove(s.getName());
		    	}
		    	
		    	spawnTimer.put(s.getName(), spawnTimer.get(s.getName()) + 1);
 		    	
 		    }
 		}, 0, 20L)); 
		
	}

		
}
			