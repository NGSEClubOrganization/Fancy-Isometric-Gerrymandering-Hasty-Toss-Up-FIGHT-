package com.ngse.fight.classes;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.ngse.fight.FIGHT;
import com.ngse.fight.classes.mages.Alchemist;
import com.ngse.fight.classes.mages.Shadow;
import com.ngse.fight.classes.mages.Teleporter;

public abstract class FightClass {

	public static HashMap<String, FightClass> allClasses = new HashMap<String, FightClass>();

	public static void fightClassesArraySetup() {
		Alchemist ach = new Alchemist();
		Shadow sha = new Shadow();
		Teleporter tel = new Teleporter();
	}

	public abstract ArrayList<ItemStack> getItems();

	public abstract ArrayList<Ability> getAbilities();

	@SuppressWarnings("unused")
	private ArrayList<Ability> abilities;
	@SuppressWarnings("unused")
	private ArrayList<ItemStack> items;
	private String name;

	public String getName() {
		return this.name;
	}

	public FightClass(String name) {
		this.name = name;
		items = getItems();
		abilities = getAbilities();
		allClasses.put(this.name, this);
	}

	public static void initiateClass(Player sender, FightClass fightclass) {
		// give items
		FIGHT.log("FC: " + fightclass.getName());
		for (ItemStack is : fightclass.getItems()) {
			FIGHT.log("Giving: " + is.getType().toString());
			sender.getInventory().addItem(is);
		}
		// give abilities (activated by these items)
		for (Ability a : fightclass.getAbilities()) {
			FIGHT.log("Ability: " + a.getName());
			sender.getInventory().addItem(a.getItem());
		}
	}

	@SuppressWarnings("unused")
	public boolean useAbility(Player sender) {
		ItemStack i = sender.getItemInHand();

		// sees if they are fightclassed
		FightClass f = FightClass.get(sender);
		FIGHT.log("Class: " + f.getName());
		if (f != null) {
			// goes through each ability, seeeing if any of the MID's match the
			// lore of the item
			for (Ability a : f.getAbilities()) {
				FIGHT.log("Possible Ability: " + a.getName());
				if (i.getItemMeta().getLore().get(0)
						.equalsIgnoreCase(a.getMID())) {
					// check if cost is able to be paid, and pay it
					/*
					 * if (a.useCost(sender)) { a.effect(sender); }
					 */
					// use ability
					a.effect(sender);

				}
			}
		} else {
			return false;
		}
		return true;
	}

	public boolean useAbility(Player sender, Player target) {
		ItemStack i = sender.getItemInHand();

		// sees if they are fightclassed
		FightClass f = FightClass.get(sender);
		if (f != null) {
			// goes through each ability, seeeing if any of the MID's match the
			// lore of the item
			for (Ability a : f.getAbilities()) {
				if (i.getItemMeta().getLore().get(0)
						.equalsIgnoreCase(a.getMID())) {
					// check if cost is able to be paid, and pay it
					/*
					 * if (a.useCost(sender)) { a.effect(sender, target); }
					 */

					// use ability
					a.effect(sender, target);
				}
			}
		} else {
			return false;
		}
		return true;
	}

	public static FightClass get(Player p) {
		FightClass f = null;
		if (p.hasMetadata("fightclass")) {
			f = (FightClass) p.getMetadata("fightclass").get(0).value();
		}
		return f;
	}

	public static ItemStack createItemStack(Material m, int amount,
			String name, String lore) {
		ItemStack it = new ItemStack(m, amount);
		ItemMeta im = it.getItemMeta();
		im.setDisplayName(name);
		ArrayList<String> l = new ArrayList<String>();
		l.add(lore);
		im.setLore(l);
		it.setItemMeta(im);
		return it;
	}
}
