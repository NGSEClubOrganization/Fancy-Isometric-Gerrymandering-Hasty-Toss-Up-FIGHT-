package com.ngse.fight.classes.mages;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;
import com.ngse.fight.classes.FightClass;
import com.ngse.fight.specials.Hover;
import com.ngse.fight.specials.TeleportForward;

public class Teleporter extends FightClass {

	public Teleporter() {
		super("Teleporter");
	}

	@Override
	public ArrayList<ItemStack> getItems() {
		ArrayList<ItemStack> is = new ArrayList<ItemStack>();
		is.add(new ItemStack(Material.APPLE, 64));
		return is;
	}

	@Override
	public ArrayList<Ability> getAbilities() {
		ArrayList<Ability> as = new ArrayList<Ability>();
		as.add(new Hover());
		as.add(new TeleportForward());
		return as;
	}

}
