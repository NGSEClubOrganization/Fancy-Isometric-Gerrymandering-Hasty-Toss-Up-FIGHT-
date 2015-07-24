package com.ngse.fight.specials;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import com.ngse.fight.FIGHT;
import com.ngse.fight.classes.Ability;
import com.ngse.utilities.Toggle;

public class Hover extends Ability {

	public Hover() {
		super("Hover", 2, true, "hov");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effect(Player user, Player target) {
		effect(user);
	}

	@Override
	public void effect(Player user) {
		// toggle hovering
		if (user.hasMetadata("hovering")) {
			user.setMetadata("hovering",
					new FixedMetadataValue(FIGHT.plugin, ((Toggle) user
							.getMetadata("hovering").get(0).value()).toggle()));
			;
		} else {
			user.setMetadata("hovering", new FixedMetadataValue(FIGHT.plugin,
					new Toggle(true)));
		}
	}

	@Override
	public ItemStack getItem() {
		return Ability.setupItem(Material.FEATHER, this);
	}

	@Override
	public void passiveEffect(Player user) {
		Player p = user;
		if (p.hasMetadata("hovering")) {
			if (((Toggle) p.getMetadata("hovering").get(0).value()).b) {
				Location l = p.getLocation();
				for (int x = -2; x <= 2; x++) {
					for (int z = -1; z <= 1; z++) {
						Location nl = l.add(x, 0, z);
						Block b = nl.getBlock();
						if (x == 2 || x == -2 || z == 2 || z == -2) {
							// if on the outer edges, set the block to its
							// metadata'd original block (if it has that)
							Block c = b.hasMetadata("originalblock") ? (Block) b
									.getMetadata("originalblock") : null;
							if (c != null) {
								nl.getBlock().setType(c.getType());
							}
						} else {
							// else, turn the block to glass and set its
							// "originalblock" metadata to what it was
							// originally
							nl.getBlock().setType(Material.GLASS, false);
							nl.getBlock().setMetadata("originalblock",
									new FixedMetadataValue(FIGHT.plugin, b));
						}
					}
				}
			}
			if (((Toggle) p.getMetadata("hovering").get(0).value()).b) {
				p.sendMessage(ChatColor.LIGHT_PURPLE + "[HOVERING] "
						+ ChatColor.GREEN + "ON");
			} else {
				p.sendMessage(ChatColor.LIGHT_PURPLE + "[HOVERING] "
						+ ChatColor.RED + "OFF");
			}
		}
	}

}
