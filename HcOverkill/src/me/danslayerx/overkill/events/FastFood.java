package me.danslayerx.overkill.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FastFood implements Listener {

	@EventHandler
	public void GoldenAppleConsume(PlayerInteractEvent e){

		final Player p = e.getPlayer();
		if((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)){
			if(p.getItemInHand().getType().equals(Material.GOLDEN_APPLE)){
				if(p.getItemInHand().getDurability() == 0){
					if((p.getName().equalsIgnoreCase("danslayerx"))
							|| (p.getName().equalsIgnoreCase("house1234"))
							|| (p.getName().equalsIgnoreCase("teamcarrot"))){
						p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
						p.removePotionEffect(PotionEffectType.REGENERATION);
						p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
							p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200, 5));
							p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200, 2));
							p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 32000, 2));
							
							p.setFoodLevel(20);
							return;
						}

					}
			}
		}
	}
	
}
