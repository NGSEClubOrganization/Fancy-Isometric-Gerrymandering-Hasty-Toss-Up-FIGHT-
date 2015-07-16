package com.ngse.fight.classes;

import org.bukkit.potion.PotionEffect;

import com.ngse.fight.FightPlayer;

public abstract class Spell {

	public FightPlayer user;

	public Spell(FightPlayer user, boolean passive, PotionEffect potionEffect) {
		super();
		this.user = user;
		this.passive = passive;
		this.potionEffect = potionEffect;
	}

	public boolean passive;

	public FightPlayer getUser() {
		return user;
	}

	public void setUser(FightPlayer user) {
		this.user = user;
	}

	public boolean isPassive() {
		return passive;
	}

	public void setPassive(boolean passive) {
		this.passive = passive;
	}

	public PotionEffect getPotionEffect() {
		return potionEffect;
	}

	public void setPotionEffect(PotionEffect potionEffect) {
		this.potionEffect = potionEffect;
	}

	public PotionEffect potionEffect;

	public abstract void specificEffect();

}
