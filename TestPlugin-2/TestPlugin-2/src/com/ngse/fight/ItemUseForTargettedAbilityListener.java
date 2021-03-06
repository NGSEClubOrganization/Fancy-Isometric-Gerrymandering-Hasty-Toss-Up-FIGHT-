package com.ngse.fight;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import com.ngse.fight.classes.FightClass;

public class ItemUseForTargettedAbilityListener implements Listener {

	@EventHandler
	public void onPlayerInteractEntity(PlayerInteractEntityEvent evt) {
		Player p = evt.getPlayer();
		FightClass f;

		if (p.hasMetadata("fightclass")) {
			f = (FightClass) FightClass.get(p);
			if (f != null) {
				if (evt.getRightClicked() instanceof Player) {
					f.useAbility(p, (Player) evt.getRightClicked());
				}
			}
		}
	}
}
