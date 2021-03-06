package com.ngse.fight.specials;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;
import com.ngse.utilities.Direction;

public class TeleportForward extends Ability {

	private static final int MAXHEIGHT = 2;
	private static final int RANGE = 3;

	public TeleportForward() {
		super("Teleboost Wand", 10, "telboo");
	}

	@Override
	public void effect(Player user, Player target) {
		// teleport right behind the target
		Location tloc = target.getLocation();
		tloc = tloc.add(Direction.getOppDir(target));
		user.teleport(tloc);
	}

	@Override
	public void effect(Player user) {
		// teleport in the direction you are facing by RANGE blocks
		Location loc = user.getLocation();
		loc.add(loc.getDirection().multiply(RANGE));

		// check where you are trying to go. If its not air, then will add 1 to
		// y and try again. If not good MaxHeigh blocks above, then fails
		boolean safe = false;
		for (int x = 0; x <= MAXHEIGHT; x++) {
			loc.add(0, x, 0);
			if (!loc.getBlock().getType().isSolid()) {
				safe = true;
				break;
			}
		}
		if (safe) {
			Hover.destroyHoveringBlock(user, true);
			user.getWorld().playEffect(user.getLocation(), Effect.DOOR_TOGGLE,
					10);
			user.teleport(loc);
			user.getWorld().playEffect(user.getLocation(), Effect.DOOR_TOGGLE,
					10);
		}

	}

	@Override
	public ItemStack getItem() {
		return Ability.setupItem(Material.ARROW, this);
	}

}
