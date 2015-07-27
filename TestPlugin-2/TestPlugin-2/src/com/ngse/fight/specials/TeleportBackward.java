package com.ngse.fight.specials;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;

public class TeleportBackward extends Ability {

	public static final int RANGE = 3;

	public TeleportBackward() {
		super("Teleretreat", 15, "telret");
	}

	@Override
	public void effect(Player user, Player target) {
		effect(user);

	}

	@Override
	public void effect(Player user) {
		Location l = user.getLocation();
		l.add(l.getDirection().multiply(-RANGE));
		if (!l.getBlock().getType().isSolid()) {
			user.teleport(l);
		}
	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.STICK, this);
	}

}
