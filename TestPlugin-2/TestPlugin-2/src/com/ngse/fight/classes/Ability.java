package com.ngse.fight.classes;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class Ability {

	public int level;
	public boolean isPassive;
	public ItemStack item;
	public String name;
	public String MID;

	// all abilities are attched to items

	public Ability(String name, int level, boolean isPassive, String MID) {
		this.name = name;
		this.level = level;
		this.isPassive = isPassive;
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

	public boolean isPassive() {
		return isPassive;
	}

	public abstract ItemStack getItem();

	public String getMID() {
		return MID;
	}

	public static ItemStack setupItem(Material m, Ability a) {
		ItemStack i = new ItemStack(m, 1);
		i.setType(m);
		i.getItemMeta().setDisplayName(a.getName());
		ArrayList<String> l = new ArrayList<String>();
		l.add(a.getMID());
		i.getItemMeta().setLore(l);
		return i;
	}

}
