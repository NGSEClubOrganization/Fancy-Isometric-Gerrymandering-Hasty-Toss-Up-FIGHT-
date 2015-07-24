package com.ngse.fight;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.ngse.fight.classes.FightClass;

public class ItemUseForAbilityListener implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent evt) {
		Player p = evt.getPlayer();
		FightClass f;

		if (p.hasMetadata("fightclass")) {
			f = (FightClass) FightClass.get(p);
			f.useAbility(p);
			p.sendMessage("Used your ability!");
		}
	}

}
