package com.ngse.fight.classes.mages;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;
import com.ngse.fight.classes.FightClass;

public class Shadow extends FightClass {

	public Shadow() {
		super("Shadow", 200);
	}

	@Override
	public ArrayList<Ability> getAbilities() {
		ArrayList<Ability> as = new ArrayList<Ability>();
		return as;
	}

	@Override
	public ArrayList<ItemStack> getItems() {
		ArrayList<ItemStack> is = new ArrayList<ItemStack>();
		is.add(new ItemStack(Material.DIAMOND_SWORD));
		return is;
	}

}
