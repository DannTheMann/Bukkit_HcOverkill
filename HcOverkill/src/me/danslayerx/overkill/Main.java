package me.danslayerx.overkill;

import java.io.File;

import me.danslayerx.overkill.commands.BedrockBase;
import me.danslayerx.overkill.commands.ClearWorldMobs;
import me.danslayerx.overkill.commands.NameAll;
import me.danslayerx.overkill.commands.NameItem;
import me.danslayerx.overkill.commands.NearCommand;
import me.danslayerx.overkill.events.BlockPlacement;
import me.danslayerx.overkill.events.CatchExpression;
import me.danslayerx.overkill.events.DeathMsg;
import me.danslayerx.overkill.events.EnderpearlDisable;
import me.danslayerx.overkill.events.FastFood;
import me.danslayerx.overkill.events.StarterKit;
import me.danslayerx.overkill.farm.RareDrops;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class Main extends JavaPlugin{
	
	public static int ver = 1;
	
	public static String title = ChatColor.GREEN + "[" + ChatColor.YELLOW + "HcOverkill" + ChatColor.GREEN + "] " + ChatColor.GRAY;
	
	public static Main p;
	public static String dir;
	
	public void onEnable(){
		p = this;
		dir = getDataFolder().getAbsoluteFile() + "\\PlayerEXP";
		checkDir();
		log("is enabled!");
		registerAllEvents();
		registerAllCommands();
		DoubleDrop.loadList();
		loadConfig();
	}
	
	private void checkDir(){
		File f = new File(dir);
		
		if(!f.exists())
			f.mkdirs();
	}

	private void loadConfig() {
		if(!getConfig().contains("Region.List")){
		getConfig().addDefault("Region.List", BedrockBase.regionList);
			BedrockBase.regionList.add("Example Region");
		}
		
		getConfig().options().copyDefaults(true);
		
		saveConfig();
		
	}

	private void registerAllCommands() {
		getServer().getPluginCommand("setbb").setExecutor(new BedrockBase());
		getServer().getPluginCommand("clearbb").setExecutor(new ClearWorldMobs());
		getServer().getPluginCommand("near").setExecutor(new NearCommand());
		getServer().getPluginCommand("name").setExecutor(new NameItem());
		getServer().getPluginCommand("na").setExecutor(new NameAll());
	}

	public void onDisable(){
		log("is disabled!");
	}

	
	public void registerAllEvents(){
		getServer().getPluginManager().registerEvents(new LeavesDrop(), this);
		getServer().getPluginManager().registerEvents(new KeepEXP(), this);
		getServer().getPluginManager().registerEvents(new EnderpearlDisable(), this);
		getServer().getPluginManager().registerEvents(new DoubleDrop(), this);
		getServer().getPluginManager().registerEvents(new ChatColour(), this);
		getServer().getPluginManager().registerEvents(new RareDrops(), this);
		getServer().getPluginManager().registerEvents(new StarterKit(), this);
		getServer().getPluginManager().registerEvents(new BlockPlacement(), this);
		getServer().getPluginManager().registerEvents(new FastFood(), this);
		getServer().getPluginManager().registerEvents(new CatchExpression(), this);
		getServer().getPluginManager().registerEvents(new DeathMsg(), this);
		getServer().getPluginManager().registerEvents(new HaltRedeem(), this);
	}
	
	public void log(String s){
		System.out.println(title + s);
	}
	
    public static WorldGuardPlugin getWorldGuard() {
    	Plugin wg = Main.p.getServer().getPluginManager().getPlugin("WorldGuard");
     
        // WorldGuard may not be loaded
        if (wg == null || !(wg instanceof WorldGuardPlugin)) {
            return null; // Maybe you want throw an exception instead
        }
     
        return (WorldGuardPlugin) wg;
    }
}