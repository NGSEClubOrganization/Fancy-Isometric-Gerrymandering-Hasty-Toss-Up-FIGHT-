package com.ngse.fight.classes;

import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import com.ngse.fight.FIGHT;
import com.ngse.utilities.Toggle;

public abstract class PassiveAbility extends Ability {

	public PassiveAbility(String name, int level, boolean isPassive, String MID) {
		super(name, level, isPassive, MID);
	}

	public abstract void passiveEffect(Player p);

	public abstract void endPassiveEffect(Player p);

	public void togglePassiveAbility(Player p, PassiveAbility pass) {
		if (p.hasMetadata(getName())) {
			// set the metadata to the opposite Toggle value
			p.setMetadata(getName(), new FixedMetadataValue(FIGHT.plugin,
					!((Toggle) p.getMetadata(getName()).get(0).value()).b));
			FIGHT.log("Toggled " + pass.getName() + " to "
					+ String.valueOf(isActive(p)));
		} else {
			// set the metadata for this passive to true
			p.setMetadata(getName(), new FixedMetadataValue(FIGHT.plugin,
					new Toggle(true)));
			FIGHT.log("Toggled " + pass.getName() + " to "
					+ String.valueOf(isActive(p)));
		}
	}

	public boolean isActive(Player p) {
		return ((Toggle) p.getMetadata(getName()).get(0).value()).b;
	}
}