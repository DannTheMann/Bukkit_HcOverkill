package me.danslayerx.overkill.commands;

import me.danslayerx.overkill.Main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;

public class ClearWorldMobs implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command c, String l,
			String[] args) {
		if(c.getName().equalsIgnoreCase("clearbb")){
			
			if(s.hasPermission("HcRaid.OWNER")){
				
				s.sendMessage(Main.title + "Clearing " + Bukkit.getWorld("upperClass").getEntities().size() + " mobs.");
				
				for(Entity e : Bukkit.getWorld("upperClass").getEntities()){
					e.remove();
				}
				
				s.sendMessage(Main.title + "Cleared all entites on upperClass!");
				
			}
			
		}
		return false;
	}

}
