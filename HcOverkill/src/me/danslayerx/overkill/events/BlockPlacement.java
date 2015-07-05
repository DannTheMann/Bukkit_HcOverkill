package me.danslayerx.overkill.events;

import java.util.List;

import me.danslayerx.overkill.Main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Pig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.inventory.ItemStack;

import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class BlockPlacement implements Listener{
	
	int[] itemValues = {8,9,10,11,327,326};
	
	@EventHandler
	public void blockPlacement(final BlockBreakEvent e){
		
		if((e.getBlock().getTypeId() == 11)
		|| (e.getBlock().getTypeId() == 10)
		|| (e.getBlock().getTypeId() == 9)
		|| (e.getBlock().getTypeId() == 8)){
			
			
			
		}

	}
	
	@EventHandler
	public void move(PlayerMoveEvent e){
		
		if(e.getPlayer().getWorld().getName().equalsIgnoreCase("upperClass")){
			
			if(!e.getPlayer().hasPermission("HcRaid.OWNER")){
				
				List<String> list = getBedrockRegions();
				
				for(int i = 0 ; i < list.size() ; i++ ){

					for(ProtectedRegion pr : Main.getWorldGuard().getRegionManager(e.getPlayer().getWorld()).getRegions().values()){
						
						if(pr.getPriority() != 0)
						if(pr.contains(e.getPlayer().getLocation().getBlock().getX(), 
								e.getPlayer().getLocation().getBlock().getY(), 
								e.getPlayer().getLocation().getBlock().getZ())){
								return;

						}
					
				
				}
					e.getPlayer().teleport(Bukkit.getWorld("world").getSpawnLocation());
				
				}
			}
		}
	}
	
	@EventHandler
	public void dispense(BlockDispenseEvent e){
		
		if(e.getBlock().getWorld().getName().equalsIgnoreCase("upperClass")){
			
			for(int i : itemValues){
				if(e.getItem().getTypeId() == i){
					e.setItem(new ItemStack(Material.BAKED_POTATO));
					e.getBlock().breakNaturally();
				}
			}
			
			
		}
		
	}
	
	@EventHandler
	public void pigInteract(PlayerInteractEntityEvent e){
		
		if(e.getRightClicked().getLocation().getWorld().getName().equalsIgnoreCase("upperClass")){
			
			if(e.getRightClicked() instanceof Pig){
				e.setCancelled(true);
			}
			
		}
	
	}
	
	@EventHandler
	public void moveVehicle(VehicleMoveEvent e){
		
		if(e.getVehicle().getLocation().getWorld().getName().equalsIgnoreCase("upperClass")){
			
			List<String> list = getBedrockRegions();
			
			for(int i = 0 ; i < list.size() ; i++ ){

				for(ProtectedRegion pr : Main.getWorldGuard().getRegionManager(e.getVehicle().getWorld()).getRegions().values()){
					
					if(pr.getPriority() != 0)
					if(pr.contains(e.getVehicle().getLocation().getBlock().getX(), 
							e.getVehicle().getLocation().getBlock().getY(), 
							e.getVehicle().getLocation().getBlock().getZ())){
							return;

					}
				
				}
			}
			
			if(e.getVehicle().getPassenger() != null){
				Entity e2 = e.getVehicle().getPassenger();
				e2.teleport(Bukkit.getWorld("world").getSpawnLocation());
			}
			e.getVehicle().remove();
			
		}
		
	}
	
	private List<String> getBedrockRegions() {
		return Main.p.getConfig().getStringList("Region.List");
	}
	
	@SuppressWarnings("unused")
	private void messageDan(String s){
		if(Bukkit.getPlayer("danslayerx") != null){
			Bukkit.getPlayer("danslayerx").sendMessage("DEBUG // " + s);
		}
	}

}
