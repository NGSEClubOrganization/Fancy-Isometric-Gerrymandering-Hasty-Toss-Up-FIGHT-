package com.ngse.fight.specials;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.ngse.fight.FightPlayer;
import com.ngse.fight.classes.Spell;

public class GiveRandomPotion extends Spell {

	public GiveRandomPotion(FightPlayer user) {
		super(user, false, null);
	}

	@Override
	public void specificEffect() {
		ItemStack i = new ItemStack(Material.POTION, 1);
		// i.setItemMeta(itemMeta)
		user.getPlayer().getInventory()
				.addItem(i);

	}
}
