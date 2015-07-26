package com.ngse.fight.specials;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import com.ngse.fight.classes.Ability;

public class GiveRandomPotion extends Ability {

	public GiveRandomPotion() {
		super("Random Potion Generator", 1, "ranpotgen");
	}

	@Override
	public void effect(Player user, Player target) {
		effect(user);
	}

	@Override
	public void effect(Player user) {
		ItemStack it = new ItemStack(Material.POTION);

		PotionType pty;

		Random r = new Random();
		int n = (int) (r.nextDouble() * 10) + 1;

		if (n == 1) {
			pty = PotionType.INSTANT_DAMAGE;
		} else if (n == 2) {
			pty = PotionType.INVISIBILITY;
		} else if (n == 3) {
			pty = PotionType.REGEN;
		} else if (n == 4) {
			pty = PotionType.JUMP;
		} else if (n == 5) {
			pty = PotionType.SPEED;
		} else if (n == 6) {
			pty = PotionType.STRENGTH;
		} else if (n == 7) {
			pty = PotionType.WEAKNESS;
		} else if (n == 8) {
			pty = PotionType.FIRE_RESISTANCE;
		} else if (n == 9) {
			pty = PotionType.NIGHT_VISION;
		} else {
			pty = PotionType.INSTANT_HEAL;
		}

		Potion pt = new Potion(pty).extend();

		pt.setSplash(false);
		pt.apply(it);
		user.getInventory().addItem(it);
	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.STICK, this);
	}
}
