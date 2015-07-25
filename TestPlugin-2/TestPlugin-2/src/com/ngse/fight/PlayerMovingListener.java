package com.ngse.fight;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.ngse.fight.classes.Ability;
import com.ngse.fight.classes.FightClass;

public class PlayerMovingListener implements Listener {

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		FightClass f = FightClass.get(p);

		if (f != null) {
			// recharge xp (mana / stanima)
			p.setExp(p.getExp() + Finals.xpCharge);

			// check passive abilities
			for (Ability a : f.getAbilities()) {
				if (a.isPassive) {
					a.passiveEffect(p);
				}
			}
		}
	}

}
