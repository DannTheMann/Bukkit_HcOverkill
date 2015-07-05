package me.danslayerx.overkill.commands;

import java.util.ArrayList;
import java.util.List;

import me.danslayerx.overkill.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BedrockBase implements CommandExecutor{

	public static List<String> regionList = new ArrayList<String>();
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l,
			String[] args) {
		if(c.getName().equalsIgnoreCase("setbb")){
			
			if(s instanceof Player){
				
				if(args.length == 0){
					s.sendMessage(Main.title + "/setbb <region>");
					return false;
				}
				
				if(s.hasPermission("HcRaid.OWNER")){
					((Player) s).performCommand("region define " + args[0]);
					((Player) s).performCommand("region priority " + args[0] + " 1");
					((Player) s).performCommand("region flag " + args[0] + " build allow");
					
					s.sendMessage(Main.title + "Set region as bedrock base.");
					
					addToRegion(args[0]);
					
				}
				
			}
			
		}
		return false;
	}

	private void addToRegion(String string) {
		List<String> region = getBedrockRegions();
		region.add(string);
		
		Main.p.getConfig().set("Region.List", region);
		
		Main.p.saveConfig();
		
	}

	private List<String> getBedrockRegions() {
		return Main.p.getConfig().getStringList("Region.List");
	}
	
	

}
