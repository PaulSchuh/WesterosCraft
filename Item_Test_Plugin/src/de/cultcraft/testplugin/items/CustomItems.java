package de.cultcraft.testplugin.items;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomItems implements Listener{



	public ItemStack createItem(Material m, String name, String desc) {

		ItemStack item = new ItemStack(m, 1);

		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(name);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(desc);
		itemMeta.setLore(lore);
		item.setItemMeta(itemMeta);



		return item;

	}

	//Demo Custom Item
	public ItemStack createWand() {

		Material m = Material.STICK;
		String name = (ChatColor.BLUE + "Magic Wand");
		String desc = (ChatColor.DARK_AQUA + "A wizard needs a wand...");

		ItemStack item = createItem(m, name, desc);

		return item;

	}

}
