package com.ngse.fight.classes;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.ngse.fight.Finals;
import com.ngse.utilities.Energy;

public abstract class Ability {

	public int level;
	public ItemStack item;
	public String name;
	public String MID;

	// all abilities are attched to items

	public Ability(String name, int level, String MID) {
		this.name = name;
		this.level = level;
		this.item = getItem();
		this.MID = MID;
	}

	public abstract void effect(Player user, Player target);

	public abstract void effect(Player user);

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public int getCost() {
		return (int) (level * Finals.energyCostPerAbilityLevel);
	}

	/*
	 * @Return: True means that the cost was subtracted and the ability should
	 * be activated. False mean that the cost > energy and the ability should
	 * not be activated
	 */
	public boolean useCost(Player p) {
		if (Energy.get(p) >= this.getCost()) {
			Energy.add(p, -getCost());
			return true;
		}
		return false;
	}

	public abstract ItemStack getItem();

	public String getMID() {
		return MID;
	}

	// common setupitem method for making Ability-linked items
	public static ItemStack setupItem(Material m, Ability a) {
		ItemStack i = new ItemStack(m, 1);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(a.getName());
		List<String> l = new ArrayList<String>();
		l.add(a.getMID());
		im.setLore(l);
		i.setItemMeta(im);
		return i;
	}

}
