package me.danslayerx.overkill;

import java.util.HashMap;
import java.util.HashSet;

import me.danslayerx.overkill.exp.XFile;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class KeepEXP implements Listener {
	
	static HashMap<String, Integer> keepExp = new HashMap<String, Integer>();
	static HashSet<String> returning = new HashSet<String>();
	
	@EventHandler
	public void playerDeath(PlayerDeathEvent e){
		
		if(e.getEntity() instanceof Player){
			
			Player p = (Player) e.getEntity();
			
			if(p.hasPermission("HcOverkill.Hero")){
				getLevelsToKeep(p, 100 );
			}else if(p.hasPermission("HcOverkill.Enderdragon")){
				getLevelsToKeep(p, 80);
			}else if(p.hasPermission("HcOverkill.Ghast")){
				getLevelsToKeep(p, 60);
			}else if(p.hasPermission("HcOverkill.Blaze")){
				getLevelsToKeep(p, 40);
			}else if(p.hasPermission("HcOverkill.Creeper")){
				getLevelsToKeep(p, 20);
			}
			
			if(p.hasPermission("HcOverkill.HERO")){
				e.setDroppedExp(0);
			}
			
		}
		
	}
	
	@EventHandler
	public void respawn(final PlayerRespawnEvent e){
		
	    Main.p.getServer().getScheduler().scheduleSyncDelayedTask(Main.p, new Runnable() {
		    @Override 
		    public void run(){
		
		Player p = e.getPlayer();
		
		if(keepExp.containsKey(p.getName())){
			
			p.setLevel(keepExp.get(p.getName()));
			
			p.sendMessage(Main.title + ChatColor.GREEN + "You recovered " + p.getLevel() + " levels from your death!");
			
		}else if(p.hasPermission("HcOverkill.Creeper")){
		
			int exp = XFile.getExp(p.getName());
			
				p.setLevel(exp);
			
				p.sendMessage(Main.title + ChatColor.GREEN + "You recovered " + p.getLevel() + " levels from your death!");
			
		    	}	
		
			returning.remove(p.getName());
		    }
 	    }, 40L); 
		
	}

	private void getLevelsToKeep(Player p, int i) {

		if(returning.contains(p.getName()))
			return;
		
		double level = p.getLevel();
		
		double percentage = level / 100;
		
		int tooKeep = (int) (percentage * i);
		
		XFile.setExp(p.getName(), tooKeep);
		
		keepExp.put(p.getName(), tooKeep);
		returning.add(p.getName());
	}

}
