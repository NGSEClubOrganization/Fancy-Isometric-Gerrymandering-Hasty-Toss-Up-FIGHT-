package com.ngse.fight;

import java.util.ArrayList;

import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

import com.ngse.fight.classes.FightClass;

public class FIGHT extends JavaPlugin {

	public static CommandExecutor commandExecutor;

	public static ArrayList<Listener> listeners = new ArrayList<Listener>();

	public static JavaPlugin plugin;

	public void onEnable() {
		plugin = this;
		this.getLogger().info("FIGHT enabled!");

		// commandexecutor
		initCommands();

		// listeners
		initListeners();

		// all initializing stuff
		initClasses();
	}

	public void onDisable() {
		getLogger().info("FIGHT disabled");
	}

	private void initCommands() {
		commandExecutor = new FightCommandExecutor();
		this.getCommand("fight").setExecutor(commandExecutor);
		this.getCommand("f").setExecutor(commandExecutor);
	}

	public void initListeners() {
		setupListener(new ItemUseForUntargettedAbilityListener());
		setupListener(new PlayerMovingListener());
	}

	public static void initClasses() {
		// add all classes to FightClass.allClasses
		FightClass.fightClassesArraySetup();
	}

	public static void createPlayer(Player p, String fightclassname) {
		p.setMetadata("fightclass", new FixedMetadataValue(plugin,
				FightClass.allClasses.get(fightclassname)));
	}

	public static void setupListener(Listener l) {
		listeners.add(l);
		plugin.getServer().getPluginManager().registerEvents(l, plugin);
	}

	public static void log(String m) {
		plugin.getLogger().info(m);
	}
}
