package me.danslayerx.overkill;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class LeavesDrop implements Listener {
	
	@EventHandler
	public void harvestLoot(final BlockBreakEvent e){
		
		if(!e.getPlayer().isOp()){
		for(ProtectedRegion u : Main.getWorldGuard().getRegionManager(e.getBlock().getWorld()).getRegions().values()){
			
			if(Main.getWorldGuard().getRegionManager(e.getBlock().getWorld()).getRegionExact(u.getId())
					.contains(e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ())){
				e.setCancelled(true);
				return;
			}
			
		}
		}
		
		if(e.getPlayer().getItemInHand() != null){
			
			if(e.getPlayer().getItemInHand().getType().equals(Material.SHEARS)){
				return;
			}
			
		}
		
		if(e.getBlock().getTypeId() == 18){
			
			ItemStack is = new ItemStack(0);
			
			int randomNumber = new Random().nextInt(8999)+1;
			
			if(randomNumber == 1){
				
				is = new ItemStack(Material.DIAMOND_CHESTPLATE);
				is.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
				is = setName(is, ChatColor.GOLD + "Awesome Chestplate");
				dropItem(is, e.getBlock().getLocation());
				is = new ItemStack(Material.DIAMOND_HELMET);
				is = setName(is, ChatColor.GOLD + "Awesome Helmet");
				is.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
				dropItem(is, e.getBlock().getLocation());
				is = new ItemStack(Material.DIAMOND_LEGGINGS);
				is = setName(is, ChatColor.GOLD + "Awesome Leggings");
				is.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
				dropItem(is, e.getBlock().getLocation());
				is = new ItemStack(Material.DIAMOND_BOOTS);
				is = setName(is, ChatColor.GOLD + "Awesome Boots");
				is.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
				dropItem(is, e.getBlock().getLocation());
				
			}else if(randomNumber <= 300){
				
				is.setType(Material.GOLDEN_APPLE);
				
				dropItem(is, e.getBlock().getLocation());
				
			}else if(randomNumber <= 3000){
				
				is.setType(Material.APPLE);
				dropItem(is, e.getBlock().getLocation());
				
			}
			
		}
		
	}

	private void messageAll(String string) {
		for(Player p : Bukkit.getOnlinePlayers()){
			
			if(p.hasPermission("HcRaid.Debug")){
				p.sendMessage(string);
			}
			
		}
		
	}

	private ItemStack setName(ItemStack is, String string) {
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(string);
		is.setItemMeta(im);
		return is;
		
		
	}

	private void dropItem(ItemStack is, Location lov) {
		Bukkit.getWorld(lov.getWorld().getName()).dropItemNaturally(lov, is);
		
	}

}
