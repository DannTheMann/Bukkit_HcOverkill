package me.danslayerx.overkill.farm;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RareDrops implements Listener{
	
	int rand = 0;
	int rand2 = 0;
	
	@EventHandler
	public void breakCactus(BlockBreakEvent e){
		
		if(e.getBlock().getType().equals(Material.CACTUS)){
			
			rand = getRandom(500);
			rand2 = getRandom(4);
			ItemStack is = new ItemStack(0);
			
			if(rand == 1){
				
				switch(rand2){
				case 1:
					is.setType(Material.DIAMOND_HELMET);
					break;
				case 2:
					is.setType(Material.DIAMOND_CHESTPLATE);
					break;
				case 3:
					is.setType(Material.DIAMOND_LEGGINGS);
					break;
				case 4:
					is.setType(Material.DIAMOND_BOOTS);
					break;
				default:
					is.setType(Material.DIAMOND_HELMET);
					break;
				}
				
				is.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				is.addEnchantment(Enchantment.THORNS, 2);
				is.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
				is.addEnchantment(Enchantment.PROTECTION_FALL, 2);
				is.addEnchantment(Enchantment.PROTECTION_FIRE, 2);
				is.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
				is.addEnchantment(Enchantment.DURABILITY, 2);
				
				setName(is, ChatColor.RED + "Cactus Power!");
				
				dropItem(is, e.getBlock().getLocation());
				
			}else if(rand <= 5){
				
				rand2 = getRandom(4);
				
				switch(rand2){
				case 1:
					is.setType(Material.IRON_HELMET);
					break;
				case 2:
					is.setType(Material.IRON_CHESTPLATE);
					break;
				case 3:
					is.setType(Material.IRON_LEGGINGS);
					break;
				case 4:
					is.setType(Material.IRON_BOOTS);
					break;
				default:
					is.setType(Material.IRON_HELMET);
					break;
				}
				
				is.addEnchantment(Enchantment.THORNS, 2);
				
				setName(is, ChatColor.BLUE + "Cactus Power!");
			
				dropItem(is, e.getBlock().getLocation());
				
			}else if(rand <= 30){
				is.setType(Material.IRON_SWORD);
				is.addEnchantment(Enchantment.DAMAGE_ALL, 1);
				dropItem(is, e.getBlock().getLocation());
				
			}
			
		}
		
	}

	@EventHandler
	public void breakReed(BlockBreakEvent e){
		
		if(e.getBlock().getType().equals(Material.SUGAR_CANE_BLOCK)){
			
			rand = getRandom(100);
			rand2 = getRandom(10);
			
			ItemStack is = new ItemStack(0);
			
			if(rand <= 5){
				
				switch(rand2){
				case 1:
					is.setType(Material.REDSTONE_WIRE);
					break;
				case 2:
					is.setType(Material.SULPHUR);
					break;
				case 3:
					is.setType(Material.SUGAR);
					break;
				case 4:
					is.setType(Material.GLOWSTONE_DUST);
					break;
				case 5:
					is.setType(Material.NETHER_WARTS);
					break;
				case 6:
					is.setType(Material.GLOWSTONE_DUST);
					break;
				case 7:
					is.setType(Material.NETHER_WARTS);
					break;
				case 8:
					is.setType(Material.GHAST_TEAR);
					break;
				case 9:
					is.setType(Material.BLAZE_POWDER);
					break;
				case 10:
					is.setType(Material.MAGMA_CREAM);
					break;
				case 11:
					is.setType(Material.FERMENTED_SPIDER_EYE);
					break;
				case 12:
					is.setType(Material.SPIDER_EYE);
					break;
				case 13:
					is.setType(Material.SPECKLED_MELON);
					break;
				}
				
			}
			
			
		}
		
	}
	
	@EventHandler
	public void breakPumpkin(BlockBreakEvent e){
		
		if(e.getBlock().getType().equals(Material.PUMPKIN)){
			
			rand = getRandom(100);
			rand2 = getRandom(10);
			
			ItemStack is = new ItemStack(0);
			
			if(rand <= 5){
				
				switch(rand2){
				case 1:
					is.setType(Material.IRON_INGOT);
					break;
				case 2:
					is.setType(Material.ARROW);
					break;
				case 3:
					is.setType(Material.EGG);
					break;
				case 4:
					is.setType(Material.WOOD_BUTTON);
					break;
				case 5:
					is.setType(Material.STEP);
					break;
				case 6:
					is.setType(Material.BAKED_POTATO);
					break;
				case 7:
					is.setType(Material.YELLOW_FLOWER);
					break;
				case 8:
					is.setType(Material.BONE);
					break;
				case 9:
					is.setType(Material.TORCH);
					break;
				case 10:
					is.setType(Material.DAYLIGHT_DETECTOR);
					break;
				case 11:
					is.setType(Material.PORK);
					break;
				case 12:
					is.setType(Material.FLINT);
					break;
				case 13:
					is.setType(Material.VINE);
					break;
				}
				
			}
			
		}
		
	}
	
	@EventHandler
	public void breakMelon(BlockBreakEvent e){
		
		if(e.getBlock().getType().equals(Material.MELON_BLOCK)){
			

			rand = getRandom(100);
			rand2 = getRandom(10);
			
			ItemStack is = new ItemStack(0);
			
			if(rand <= 5){
				
				switch(rand2){
				case 1:
					is.setType(Material.IRON_INGOT);
					break;
				case 2:
					is.setType(Material.ARROW);
					break;
				case 3:
					is.setType(Material.EGG);
					break;
				case 4:
					is.setType(Material.WOOD_BUTTON);
					break;
				case 5:
					is.setType(Material.STEP);
					break;
				case 6:
					is.setType(Material.BAKED_POTATO);
					break;
				case 7:
					is.setType(Material.YELLOW_FLOWER);
					break;
				case 8:
					is.setType(Material.BONE);
					break;
				case 9:
					is.setType(Material.TORCH);
					break;
				case 10:
					is.setType(Material.DAYLIGHT_DETECTOR);
					break;
				case 11:
					is.setType(Material.PORK);
					break;
				case 12:
					is.setType(Material.FLINT);
					break;
				case 13:
					is.setType(Material.VINE);
					break;
				}
				
			}
			
		}
		
	}

	private int getRandom(int i) {
		return new Random().nextInt(i)+1;
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
