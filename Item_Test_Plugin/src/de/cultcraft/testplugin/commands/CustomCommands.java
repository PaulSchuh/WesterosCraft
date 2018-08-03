package de.cultcraft.testplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.cultcraft.testplugin.ItemPlugin;
import de.cultcraft.testplugin.items.CustomItems;

public class CustomCommands implements CommandExecutor{

	private CustomItems cI = new CustomItems();


	public CustomCommands(ItemPlugin itemPlugin) {
		// TODO Auto-generated constructor stub
	}

	public void giveItemToPlayer(Player player, ItemStack item) {
		player.getInventory().addItem(item);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender instanceof Player) {
			Player player = (Player) sender;
			giveItemToPlayer(player, cI.createWand());
		}

		return true;
	}
}
