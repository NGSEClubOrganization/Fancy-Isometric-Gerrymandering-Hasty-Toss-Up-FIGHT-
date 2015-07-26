package com.ngse.fight.specials;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;

public class Water extends Ability {

	private static final int RANGE = 2;

	public Water() {
		super("Water", 15, "wat");
	}

	@Override
	public void effect(Player user, Player target) {
		effect(user);
	}

	@Override
	public void effect(Player user) {
		Location look = user.getLocation();
		look.add(look.getDirection().multiply(RANGE));
		look.getBlock().setType(Material.WATER);
	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.LAPIS_BLOCK, this);
	}
}
