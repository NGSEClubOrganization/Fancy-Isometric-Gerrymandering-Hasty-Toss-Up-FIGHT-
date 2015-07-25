package com.ngse.fight.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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
		for (ItemStack is : fightclass.getItems()) {
			sender.getInventory().addItem(is);
		}
		// give abilities (activated by these items)
		for (Ability a : fightclass.getAbilities()) {
			sender.getInventory().addItem(a.getItem());
		}
	}

	public boolean useAbility(Player sender) {
		ItemStack i = sender.getItemInHand();

		// sees if they are fightclassed
		FightClass f = FightClass.get(sender);
		if (f != null) {
			// goes through each ability, seeeing if any of the MID's match the
			// lore of the item
			for (Ability a : f.getAbilities()) {
				if (i.getItemMeta().getLore().get(0)
						.equalsIgnoreCase(a.getMID())) {
					// use ability

					// checks for nearby players
					List<Entity> nearbyPlayers = sender.getNearbyEntities(7, 7,
							7);
					for (Entity e : nearbyPlayers) {
						if (!(e instanceof Player)) {
							nearbyPlayers.remove(e);
						}
						if (nearbyPlayers.size() == 0)
							break;
					}

					// if no players nearby, does normal effect
					if (nearbyPlayers.size() == 0) {
						a.effect(sender);
					} else {
						// effect all players in radius
						for (Entity p : nearbyPlayers) {
							a.effect(sender, (Player) p);
						}
					}
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
}
