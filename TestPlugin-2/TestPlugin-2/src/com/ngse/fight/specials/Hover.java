package com.ngse.fight.specials;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import com.ngse.fight.FIGHT;
import com.ngse.fight.classes.Ability;
import com.ngse.fight.classes.PassiveAbility;
import com.ngse.utilities.Toggle;

public class Hover extends PassiveAbility {

	public Hover() {
		super("Hover", 2, "hov");
	}

	@Override
	public void effect(Player user, Player target) {
		effect(user);
	}

	@Override
	public void effect(Player user) {
		// toggle hovering
		togglePassiveAbility(user, this);
	}

	@Override
	public ItemStack getItem() {
		return Ability.setupItem(Material.FEATHER, this);
	}

	@Override
	public void passiveEffect(Player user) {
		Player p = user;

		if (p.hasMetadata(getName())) {
			if (isActive(user)) {
				if (isActive(user)) {
					Location l = p.getLocation();
					Location below = l.add(0, -1, 0);

					destroyHoveringBlock(user, false);

					if (!below.getBlock().getType().isSolid()) {
						// if the block isnt solid, then set it to glass
						below.getBlock().setType(Material.GLASS);
						below.getBlock().getState().setType(Material.GLASS);
						below.getBlock().getState().update(true);
					}
				}
			}
		}
	}

	public static void destroyHoveringBlock(Player p, boolean all) {
		Location l = p.getLocation();
		Location below = l.add(0, -1, 0);

		// checks through all blocks around you, but right under you
		double y = 0;
		turnToAir(below, -1, y, -1);
		turnToAir(below, -1, y, 1);
		turnToAir(below, 1, y, -1);
		turnToAir(below, 1, y, 1);
		turnToAir(below, 0, y, -1);
		turnToAir(below, 0, y, 1);
		turnToAir(below, -1, y, 0);
		turnToAir(below, 1, y, 0);
		y = -1;
		turnToAir(below, -1, y, -1);
		turnToAir(below, -1, y, 1);
		turnToAir(below, 1, y, -1);
		turnToAir(below, 1, y, 1);
		turnToAir(below, 0, y, -1);
		turnToAir(below, 0, y, 1);
		turnToAir(below, -1, y, 0);
		turnToAir(below, 1, y, 0);

		if (all) {
			turnToAir(below, 0, y, 0);
		}
	}

	private static void turnToAir(Location below, double x, double y, double z) {
		Location nl = new Location(below.getWorld(), below.getX() + x,
				below.getY() + y, below.getZ() + z);
		if (nl.getBlock().getType().equals(Material.GLASS)) {
			nl.getBlock().setType(Material.AIR);
			nl.getBlock().getState().setType(Material.AIR);
			nl.getBlock().getState().update(true);
		}
	}

	@Override
	public void endPassiveEffect(Player p) {
		destroyHoveringBlock(p, true);
	}

}
