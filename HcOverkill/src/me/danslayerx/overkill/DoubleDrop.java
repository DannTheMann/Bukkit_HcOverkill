package me.danslayerx.overkill;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class DoubleDrop implements Listener{
	
	public static List<Integer> blockList = new ArrayList<Integer>();
	
	@EventHandler
	public void breakBlock(final BlockBreakEvent e){
		
 	    Main.p.getServer().getScheduler().scheduleSyncDelayedTask(Main.p, new Runnable() {
		    @Override 
		    public void run(){
		    	if(e.isCancelled()){
		    		return;
		    	}
		
		int randChance = new Random().nextInt(19)+1;
		int randDropAmount = new Random().nextInt(4)+1;
		
		if(playerHasValidItem(e.getPlayer())){
		
		if(blockIsOnList(e.getBlock())){
			
			if(randChance == 1){
				
				ItemStack[] drop = new ItemStack[e.getBlock().getDrops().size()];
				
				int inte = 0;
				
				for(ItemStack i : e.getBlock().getDrops()){
					
					drop[inte] = i;
					drop[inte].setAmount(randDropAmount);
					drop[inte].setDurability(i.getDurability());
					drop[inte].setData(i.getData());
					inte++;
				}

				e.getBlock().breakNaturally();
				
				for(ItemStack i : drop){
				Bukkit.getWorld(e.getBlock().getWorld().getName()).dropItemNaturally(e.getBlock().getLocation(), 
						i);
					}
				}
			
			}
		
		}
		
		    }								
 	    }, 2L); 
		
	}

	public static void loadList(){
		blockList.add(56);
		blockList.add(21);
		blockList.add(14);
		blockList.add(17);
		blockList.add(15);
		blockList.add(129);
		blockList.add(153);
	}
	
	private boolean playerHasValidItem(Player player) {
		if(player.getItemInHand() != null){
			if(!player.getItemInHand().containsEnchantment(Enchantment.SILK_TOUCH)){
				return true;
			}
		}
		return false;
	}

	private boolean blockIsOnList(Block block) {
		int blockId = block.getTypeId();
		for(int i = 0; i < blockList.size(); i++){
			if(blockList.get(i) == blockId){
				return true;
			}
		}
		return false;
	}

}
