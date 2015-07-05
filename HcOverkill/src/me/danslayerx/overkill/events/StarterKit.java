package me.danslayerx.overkill.events;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StarterKit implements Listener{
	
	@EventHandler
	public void playerJoinFirstTime(PlayerJoinEvent e){
		
		if(e.getPlayer().hasPlayedBefore()){
			return;
		}
		
		Player p = e.getPlayer();
		
		ItemStack is = new ItemStack(Material.DIAMOND_HELMET);
		setEnchantment(is, Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY, 2, 2);
		p.getInventory().addItem(is);
		is = new ItemStack(Material.DIAMOND_CHESTPLATE);
		setEnchantment(is, Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY, 2, 2);
		p.getInventory().addItem(is);
		is = new ItemStack(Material.DIAMOND_LEGGINGS);
		setEnchantment(is, Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY, 2, 2);
		p.getInventory().addItem(is);
		is = new ItemStack(Material.DIAMOND_BOOTS);
		setEnchantment(is, Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY, 2, 2);
		p.getInventory().addItem(is);
		is = new ItemStack(Material.IRON_SWORD);
		setEnchantment(is, Enchantment.DAMAGE_ALL, Enchantment.KNOCKBACK, 2, 1);
		p.getInventory().addItem(is);
		is = new ItemStack(Material.BOW);
		setEnchantment(is, Enchantment.ARROW_DAMAGE, Enchantment.ARROW_KNOCKBACK, 3, 2);
		p.getInventory().addItem(is);
		
		is = new ItemStack(Material.COOKED_CHICKEN, 16);
		p.getInventory().addItem(is);
		
		is = new ItemStack(Material.ARROW, 64);
		p.getInventory().addItem(is);
		
		is = new ItemStack(Material.DIAMOND_PICKAXE);
		p.getInventory().addItem(is);
		
		p.getInventory().addItem(new ItemStack(Material.DIAMOND_AXE));
		p.getInventory().addItem(new ItemStack(Material.DIAMOND_SPADE));
		p.getInventory().addItem(new ItemStack(Material.DIAMOND_BLOCK, 2));
		
		
		
	}

	private ItemStack setName(ItemStack is, String string) {
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(string);
		is.setItemMeta(im);
		return is;			
	}
	
	private ItemStack setEnchantment(ItemStack is, Enchantment id1, Enchantment id2, int level1, int level2){
		is.addEnchantment(id1, level1);
		is.addEnchantment(id2, level2);
		return is;		
	}
	
	
	
}
