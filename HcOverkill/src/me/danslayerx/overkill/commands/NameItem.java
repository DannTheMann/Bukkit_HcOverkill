package me.danslayerx.overkill.commands;

import me.danslayerx.overkill.Main;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

public class NameItem implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l,
			String[] args) {
		if(c.getName().equalsIgnoreCase("name")){
			
			if(s instanceof Player){
				
				Player p = (Player)s;
				
				if(!p.hasPermission("HcOverkill.Ghast")){
					s.sendMessage(Main.title + ChatColor.RED + "This command is reserved for Subscribers of Ghast +");
					return false;
				}
				
				if(args.length == 0){
					s.sendMessage(Main.title + ChatColor.GRAY + "/name <Item Name>");
					return false;
				}
				
				if(p.getItemInHand() == null){
					p.sendMessage(Main.title + ChatColor.RED + "You must be holding a valid item in your hand to issue this command.");
					return false;
				}
				
				if(p.getItemInHand().getType() == Material.AIR){
					p.sendMessage(Main.title + ChatColor.RED + "You must be holding a valid item in your hand to issue this command.");
					return false;			
				}
				
				String sb = "";
				
				sb = ChatColor.AQUA + "[*] " + ChatColor.BLUE;
				
				for(int i = 0; i < args.length; i++){
					
					sb += args[i] + " ";
					
				}
				
				sb.substring(0, sb.length()-1);
				
				if(sb.length() > 30){
					p.sendMessage(Main.title + ChatColor.RED + "Name must not be longer than 30 Characters!");
					return false;
				}
				
				ItemMeta im = p.getItemInHand().getItemMeta();
				
				im.setDisplayName(sb);
				
				p.getItemInHand().setItemMeta(im);
				
				p.sendMessage(Main.title + "Item in hand named to specific request.");
				
			}
			
		}
		return false;
	}

}
