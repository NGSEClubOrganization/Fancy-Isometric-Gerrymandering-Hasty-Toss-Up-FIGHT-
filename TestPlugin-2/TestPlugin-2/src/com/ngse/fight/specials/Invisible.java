package com.ngse.fight.specials;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.ngse.fight.classes.PassiveAbility;
import com.ngse.utilities.Toggle;

public class Invisible extends PassiveAbility {

	public Invisible() {
		super("Invisiblility", 2, "inv");
	}

	@Override
	public void passiveEffect(Player p) {
		// nothing
	}

	@Override
	public void endPassiveEffect(Player p) {
		p.removePotionEffect(PotionEffectType.INVISIBILITY);
	}

	@Override
	public void effect(Player user, Player target) {
		effect(user);
	}

	@Override
	public void effect(Player user) {
		Toggle.toggleMeta(user, getName());
		if (Toggle.fromMeta(user, getName()).b) {
			user.addPotionEffect(new PotionEffect(
					PotionEffectType.INVISIBILITY, 100, 10, true, true));
		}

	}

	@Override
	public ItemStack getItem() {
		return setupItem(Material.BOWL, this);
	}

}
