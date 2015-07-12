package com.ngse.fight.classes;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.mages.Alchemist;

public abstract class FightClass {

	// arraylist of all classes, make sure to add them here
	public static FightClass[] fightClassesArray = new FightClass[100];

	public static void fightClassesArraySetup() {
		fightClassesArray[0] = new Alchemist();
	}

	private ArrayList<FightAbility> abilities = new ArrayList<FightAbility>();
	private ArrayList<ItemStack> items;
	private String name;

	public String getName() {
		return this.name;
	}

	public FightClass(String name) {
		this.name = name;
		allClasses.put(this.name, this);
	}

	public static HashMap<String, FightClass> allClasses;

}
