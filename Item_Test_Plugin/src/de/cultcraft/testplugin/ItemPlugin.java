package de.cultcraft.testplugin;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import de.cultcraft.testplugin.commands.CustomCommands;
import de.cultcraft.testplugin.events.Events;


public class ItemPlugin extends JavaPlugin{
	
	
	public void onEnable() {
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "ItemPlugin Enabled");
		getServer().getPluginManager().registerEvents(new Events(), this);
		this.getCommand("magic").setExecutor(new CustomCommands(this));
	}
	
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "ItemPlugin Diabled");
	}
}
