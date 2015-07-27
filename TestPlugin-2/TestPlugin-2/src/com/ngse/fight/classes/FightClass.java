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

	@SuppressWarnings("unused")
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
	private int maxEnergy;

	public String getName() {
		return this.name;
	}

	public int getmaxEnergy() {
		return maxEnergy;
	}

	public FightClass(String name, int maxEnergy) {
		this.name = name;
		this.maxEnergy = maxEnergy;
		items = getItems();
		abilities = getAbilities();
		allClasses.put(this.name, this);
	}

	public static void initiateClass(Player sender, FightClass fightclass) {
		// give items
		FIGHT.log("FC: " + fightclass.getName());
		for (ItemStack is : fightclass.getItems()) {
			sender.getInventory().addItem(is);
		}
		// give abilities (activated by these items)
		for (Ability a : fightclass.getAbilities()) {
			sender.getInventory().addItem(a.getItem());
		}
	}

	@SuppressWarnings("unused")
	public boolean useAbility(Player sender) {
		// check if they're holding anything
		if (!(sender.getItemInHand() == null)) {
			// return false;
		}
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
					if (a.useCost(sender)) {
						a.effect(sender);
					}
				}
			}
		} else {
			return false;
		}
		return true;
	}

	public boolean useAbility(Player sender, Player target) {
		// check if they're holding anything
		if (!(sender.getItemInHand() == null)) {
			// return false;
		}

		ItemStack i = sender.getItemInHand();
		// sees if they are fightclassed
		FightClass f = FightClass.get(sender);
		if (f != null) {
			// goes through each ability, seeeing if any of the MID's match
			// the
			// lore of the item
			for (Ability a : f.getAbilities()) {
				if (i.getItemMeta().getLore().get(0)
						.equalsIgnoreCase(a.getMID())) {
					// check if cost is able to be paid, and pay it
					if (a.useCost(sender)) {
						a.effect(sender, target);
						return true;
					}
				}
			}
		} else {
			return false;
		}

		return false;
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

	public static ArrayList<Ability> abilitiesArray(Ability[] a) {
		ArrayList<Ability> as = new ArrayList<Ability>();
		for (Ability ab : a) {
			as.add(ab);
		}
		return as;
	}

	public static ArrayList<ItemStack> itemstacksArray(ItemStack[] a) {
		ArrayList<ItemStack> as = new ArrayList<ItemStack>();
		for (ItemStack ab : a) {
			as.add(ab);
		}
		return as;
	}

	public static ItemStack is(Material m, int a) {
		return new ItemStack(m, a);
	}

	public static ItemStack is(Material m) {
		return new ItemStack(m);
	}
}
