package com.ngse.fight.classes;

import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import com.ngse.fight.FIGHT;
import com.ngse.utilities.Toggle;

public abstract class PassiveAbility extends Ability {

	public PassiveAbility(String name, int level, String MID) {
		super(name, level, MID);
	}

	public abstract void passiveEffect(Player p);

	public abstract void endPassiveEffect(Player p);

	public void togglePassiveAbility(Player p, PassiveAbility pass) {
		if (p.hasMetadata(getName())) {
			// set the metadata to the opposite Toggle value
			Toggle.setMetaToggle(p, getName(), Toggle.fromMeta(p, getName())
					.toggle().b);

			FIGHT.log("Toggled " + pass.getName() + " to "
					+ String.valueOf(isActive(p)));
		} else {
			// set the metadata for this passive to true
			p.setMetadata(getName(), new FixedMetadataValue(FIGHT.plugin,
					new Toggle(true)));
			FIGHT.log("Toggled " + pass.getName() + " to "
					+ String.valueOf(isActive(p)));
		}
		// when toggled off, then do endPassiveEffect()
		if (!Toggle.fromMeta(p, getName()).b) {
			endPassiveEffect(p);
		}
	}

	public boolean isActive(Player p) {
		if (Toggle.fromMeta(p, getName()) == null) {
			return false;
		} else {
			return Toggle.fromMeta(p, getName()).b;
		}
	}
}
