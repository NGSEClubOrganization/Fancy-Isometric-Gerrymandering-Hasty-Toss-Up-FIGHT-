package com.ngse.fight;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.ngse.fight.classes.Ability;
import com.ngse.fight.classes.FightClass;

public class PlayerMovingListener implements Listener {

	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		FightClass f = FightClass.get(p);

		if (f != null) {
			for (Ability a : f.getAbilities()) {
				if (a.isPassive) {
					a.passiveEffect(p);
				}
			}
		}
	}

}
