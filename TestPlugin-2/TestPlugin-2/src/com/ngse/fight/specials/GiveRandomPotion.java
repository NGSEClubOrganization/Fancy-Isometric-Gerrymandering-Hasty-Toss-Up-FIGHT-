package com.ngse.fight.specials;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import com.ngse.fight.classes.Ability;

public class GiveRandomPotion extends Ability {

	public GiveRandomPotion() {
		super("Random Potion Generator", 1, false, "ranpotgen");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effect(Player user, Player target) {
		effect(user);
	}

	@Override
	public void effect(Player user) {
		ItemStack it = new ItemStack(Material.POTION);
		
		// TODO: choose random potion from those possible
		
		Potion pt = new Potion(PotionType.JUMP).extend();
		pt.setSplash(false);
		pt.apply(it);
		user.getInventory().addItem(it);
	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.STICK, this);
	}

	@Override
	public void passiveEffect(Player user) {
		// TODO Auto-generated method stub
		
	}
}
