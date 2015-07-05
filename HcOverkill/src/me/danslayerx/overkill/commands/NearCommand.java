package me.danslayerx.overkill.commands;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import me.danslayerx.overkill.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class NearCommand implements CommandExecutor{
	
	public static HashSet<String> nearCooldown = new HashSet<String>();
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l,
			String[] args) {
		if(c.getName().equalsIgnoreCase("near")){
			
			if(s instanceof Player){
				
				if(!s.hasPermission("HcOverkill.Creeper")){
					s.sendMessage(Main.title + ChatColor.RED + "This command is reserved for Subscribers of Creeper +");
					return false;
				}
				
				if(nearCooldown.contains(s.getName())){
					s.sendMessage(Main.title + ChatColor.RED + "Command is currently on cooldown.");
					return false;
				}
				
				if(args.length != 1){
					s.sendMessage(Main.title + "/near <radius>");
					return false;
				}
				
				Player p = (Player) s;
				
				int radius = 0;
				
				try{
					radius = Integer.parseInt(args[0]);
				}catch(NumberFormatException e){
					p.sendMessage(Main.title + ChatColor.RED + "Error! Enter a VALID number!");
					return false;
				}
				
				if(!p.hasPermission("HcOverkill.Hero")){
					
					if(!p.hasPermission("HcOverkill.Enderdragon")){
						
						if(!p.hasPermission("HcOverkill.Ghast")){
							
							if(!p.hasPermission("HcOverkill.Blaze")){
								
								if(radius > 100){
									p.sendMessage(Main.title + "Radius Max Limit Reached [100]. Purchase Blaze for wider radius.");
									return false;
								}
								
							}
							
							if(radius > 250){
								p.sendMessage(Main.title + "Radius Max Limit Reached [250]. Purchase Ghast for wider radius.");
								return false;
							}
							
						}
						
						if(radius > 500){
							p.sendMessage(Main.title + "Radius Max Limit Reached [500]. Purchase Enderdragon for wider radius.");
							return false;
						}
						
					}
					
					if(radius > 1000){
						p.sendMessage(Main.title + "Radius Max Limit Reached [1000]. Purchase Hero for wider radius.");
						return false;
					}
					
				}
				
				if(radius > 2000){
					p.sendMessage(Main.title + "Radius Max Limit Reached [2000].");
					return false;
				}
				
				List<Player> plist = new ArrayList<Player>();
				Player target = null;
				
				for(Entity e : p.getNearbyEntities(radius, radius, radius)){
					
					if(e instanceof Player){
						
						target = (Player)e;
						plist.add(target);
						
					}
						
				}
				
				if(target == null){
					p.sendMessage(Main.title + ChatColor.RED + "No Players found.");
					return false;
				}
				
				StringBuilder sb = new StringBuilder();
				int distance = 0;
				
				String perm = "";
				
				if(p.hasPermission("HcOverkill.HERO")){
					perm = "HcOverkill.Hero";
				}else if(p.hasPermission("HcOverkill.ENDERDRAGON")){
					perm = "HcOverkill.Enderdragon";
				}else if(p.hasPermission("HcOverkill.GHAST")){
					perm = "HcOverkill.Ghast";
				}else if(p.hasPermission("HcOverkill.BLAZE")){
					perm = "HcOverkill.Blaze";
				}else{
					perm = "HcOverkill.Creeper";
				}
				
				for(Player pt : plist){
					
					distance = (int) p.getEyeLocation().distance(pt.getLocation());
					
					if(!p.hasPermission(perm) && (pt.hasPermission(perm))){
						
						int rand = new Random().nextInt(499)+1;
						
						if(distance >= 1000){
							distance = 1000 + rand;
						}else if(distance >= 500){
							distance = 500 + rand;
						}else if(distance >= 100){
							distance = 100 + rand;
						}else{
							distance = rand + rand;
						}
						
						pt.sendMessage(ChatColor.RED + " >>> Someone tried to locate you using /near.");
						
					sb.append(ChatColor.RED + "?" + ChatColor.BLUE + " [" + distance + "m], ");
					}
					
					sb.append(ChatColor.RESET + pt.getName() + ChatColor.BLUE + " [" + distance + "m], ");
					
				}
				
				p.sendMessage(Main.title + " The following players have been located!");
				p.sendMessage(ChatColor.GOLD + "> " + sb.toString());
				
				
				cooldown(p);
			}
			
		}
		return false;
	}
	
	private void cooldown(final Player p){
		nearCooldown.add(p.getName());
 	    Main.p.getServer().getScheduler().scheduleSyncDelayedTask(Main.p, new Runnable() {
		    @Override 
		    public void run(){
				nearCooldown.remove(p.getName());
		    }								
 	    }, 200L); 
		
	}
	
}
