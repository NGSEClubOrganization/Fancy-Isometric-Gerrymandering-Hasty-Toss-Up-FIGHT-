package com.ngse.fight;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.ngse.fight.classes.FightClass;

public class FIGHT extends JavaPlugin {

	public void onEnable() {
		this.getLogger().info("FIGHT enabled!");

		// all initializing stuff
		initClasses();
	}

	public void onDisable() {
		getLogger().info("FIGHT disabled");
	}

	public static HashMap<Player, FightPlayer> players;

	public static void createPlayer(Player p, String fightclassname) {
		players.put(p, new FightPlayer(p, fightclassname));
	}

	public static FightPlayer getFightPlayer(Player p) {
		return players.get(p);
	}

	public static void initClasses() {
		// add all classes to FightClass.allClasses
		FightClass.fightClassesArraySetup();
	}
}
