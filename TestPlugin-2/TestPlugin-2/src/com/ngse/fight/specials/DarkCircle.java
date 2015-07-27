package com.ngse.fight.specials;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;

public class DarkCircle extends Ability {

	public DarkCircle() {
		super("Dark Circle", 15, "darcir");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effect(Player user, Player target) {
		user.getLocation().add(2, 0, 2).getBlock().setType(Material.OBSIDIAN);
		user.getLocation().add(2, 0, -2).getBlock().setType(Material.OBSIDIAN);
		user.getLocation().add(-2, 0, 2).getBlock().setType(Material.OBSIDIAN);
		user.getLocation().add(-2, 0, -2).getBlock().setType(Material.OBSIDIAN);
	}

	@Override
	public void effect(Player user) {
		user.getLocation().add(2, 0, 2).getBlock().setType(Material.OBSIDIAN);
		user.getLocation().add(2, 0, -2).getBlock().setType(Material.OBSIDIAN);
		user.getLocation().add(-2, 0, 2).getBlock().setType(Material.OBSIDIAN);
		user.getLocation().add(-2, 0, -2).getBlock().setType(Material.OBSIDIAN);

	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.STICK, this);
	}

}
