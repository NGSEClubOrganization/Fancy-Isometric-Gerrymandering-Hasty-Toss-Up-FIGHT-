package com.ngse.testplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin {

	public static JavaPlugin plugin;

	public void onEnable() {
		getServer().getPluginManager().registerEvents(
				new PlayerMovementListener(), this);
		getLogger().info(getName() + " has been enabled! woo");
	}

	@Override
	public void onDisable() {
		getLogger().info(plugin.getName() + " has been disabled! aww");
	}

}
