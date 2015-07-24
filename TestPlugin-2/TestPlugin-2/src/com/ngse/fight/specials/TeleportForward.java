package com.ngse.fight.specials;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;
import com.ngse.utilities.Direction;

public class TeleportForward extends Ability {

	public TeleportForward() {
		super("Teleboost", 1, false, "telboo");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effect(Player user, Player target) {
		// teleport right behind the target
		Location tloc = target.getLocation();
		tloc.add(Direction.getOppDir(target));
	}

	@Override
	public void effect(Player user) {
		// teleport in the direction you are facing by 10 blocks
		Location loc = user.getLocation();
		loc.add(loc.getDirection().multiply(10));
		user.teleport(loc);
	}

	@Override
	public ItemStack getItem() {
		Ability.setupItem(Material.ARROW, this);
		return null;
	}

	@Override
	public void passiveEffect(Player user) {
		// TODO Auto-generated method stub
		
	}

}
