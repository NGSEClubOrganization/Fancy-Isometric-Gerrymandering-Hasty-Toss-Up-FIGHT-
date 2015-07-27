package com.ngse.fight.classes.mages;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.classes.Ability;
import com.ngse.fight.classes.FightClass;
import com.ngse.fight.specials.Hover;
import com.ngse.fight.specials.TeleSwitch;
import com.ngse.fight.specials.TeleportBackward;
import com.ngse.fight.specials.TeleportForward;

public class Teleporter extends FightClass {

	public Teleporter() {
		super("Teleporter", 20);
	}

	@Override
	public ArrayList<ItemStack> getItems() {
		ItemStack[] i = {
				new ItemStack(Material.APPLE, 64),
				createItemStack(Material.STONE_SWORD, 1, "Sticker Wand",
						"Sword of the teleportation mage"),
				new ItemStack(Material.LEATHER_BOOTS),
				new ItemStack(Material.LEATHER_CHESTPLATE) };
		return itemstacksArray(i);
	}

	@Override
	public ArrayList<Ability> getAbilities() {
		Ability[] a = { new Hover(), new TeleportForward(),
				new TeleportBackward(), new TeleSwitch() };
		return abilitiesArray(a);
	}
}
