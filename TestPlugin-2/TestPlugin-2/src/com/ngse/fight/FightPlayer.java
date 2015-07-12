package com.ngse.fight;

import org.bukkit.entity.Player;

import com.ngse.fight.classes.FightClass;

public class FightPlayer {

	private FightClass fightClass;
	private Player player;

	public FightPlayer(Player p, String fightclassname) {
		this.player = p;
		this.fightClass = FightClass.allClasses.get(fightclassname);
	}

	public FightClass getFightClass() {
		return fightClass;
	}

	public void setFightClass(FightClass fightClass) {
		this.fightClass = fightClass;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
