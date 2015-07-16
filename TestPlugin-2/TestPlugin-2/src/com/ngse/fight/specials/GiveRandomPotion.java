package com.ngse.fight.specials;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;

public class GiveRandomPotion extends Ability {

	public GiveRandomPotion() {
		super("Random Potion Generator", 1, false, "ranpotgen");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effect(Player user, Player target) {
		effect(user);
	}

	@Override
	public void effect(Player user) {

	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.STICK, this);
	}
}
