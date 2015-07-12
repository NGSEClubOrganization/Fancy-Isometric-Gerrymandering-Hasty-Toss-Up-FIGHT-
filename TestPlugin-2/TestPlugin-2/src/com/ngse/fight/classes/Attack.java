package com.ngse.fight.classes;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public abstract class Attack {

	public int damage;
	public Player target;
	public PotionEffect targetPotionEffect;

	public Attack(int damage, Player target, PotionEffect targetPotionEffect) {
		super();
		this.damage = damage;
		this.target = target;
		this.targetPotionEffect = targetPotionEffect;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public Player getTarget() {
		return target;
	}

	public void setTarget(Player target) {
		this.target = target;
	}

	public PotionEffect getTargetPotionEffect() {
		return targetPotionEffect;
	}

	public void setTargetPotionEffect(PotionEffect targetPotionEffect) {
		this.targetPotionEffect = targetPotionEffect;
	}

}
