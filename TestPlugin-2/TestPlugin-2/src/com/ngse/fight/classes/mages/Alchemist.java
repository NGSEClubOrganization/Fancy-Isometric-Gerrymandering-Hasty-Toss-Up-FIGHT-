package com.ngse.fight.classes.mages;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;
import com.ngse.fight.classes.FightClass;
import com.ngse.fight.specials.GiveRandomPotion;
import com.ngse.fight.specials.Water;

public class Alchemist extends FightClass {

	public Alchemist() {
		super("Alchemist", 200);
	}

	@Override
	public ArrayList<ItemStack> getItems() {
		ArrayList<ItemStack> i = new ArrayList<ItemStack>();
		i.add(new ItemStack(Material.GLASS_BOTTLE, 1));
		return i;
	}

	@Override
	public ArrayList<Ability> getAbilities() {
		ArrayList<Ability> a = new ArrayList<Ability>();

		a.add(new GiveRandomPotion());
		a.add(new Water());

		return a;
	}
}
