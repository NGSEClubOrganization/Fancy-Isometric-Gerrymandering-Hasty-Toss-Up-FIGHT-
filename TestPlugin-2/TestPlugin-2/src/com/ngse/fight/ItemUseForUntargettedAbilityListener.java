package com.ngse.fight;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.ngse.fight.classes.FightClass;

public class ItemUseForUntargettedAbilityListener implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent evt) {
		Player p = evt.getPlayer();
		FightClass f;

		if (p.hasMetadata("fightclass")) {
			f = (FightClass) FightClass.get(p);
			if (f != null) {
				f.useAbility(p);
			}
		}
	}

}
