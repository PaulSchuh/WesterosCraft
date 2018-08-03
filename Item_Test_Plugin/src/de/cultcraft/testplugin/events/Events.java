package de.cultcraft.testplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import de.cultcraft.testplugin.items.CustomItems;



public class Events implements Listener{

	private CustomItems cI = new CustomItems();

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {

		Action action = event.getAction();
		Player player =event.getPlayer();
		Block block = event.getClickedBlock();
		Location loc = block.getLocation();
		ItemStack stack = new ItemStack(Material.DIAMOND);
		stack.setAmount(64);
		ItemStack compare = cI.createWand();

		//Checks to make sure that the item is actually in the used slot
		if(player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
			return;
		}else if(event.getHand().equals(EquipmentSlot.HAND)) {			
			if(compare.getItemMeta().getDisplayName().equals(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName())) {
				if(action.equals(Action.RIGHT_CLICK_BLOCK) && block.getType().equals(Material.DIAMOND_ORE)) {
					block.setType(Material.AIR);
					block.getWorld().strikeLightningEffect(loc);
					player.getInventory().addItem(stack);
					player.sendMessage(ChatColor.GOLD + "You are a wizard");
				}
			}
		}


	}

}
