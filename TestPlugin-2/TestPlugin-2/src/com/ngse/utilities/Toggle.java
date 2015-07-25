package com.ngse.utilities;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import com.ngse.fight.FIGHT;

public class Toggle {

	public boolean b;

	public Toggle(boolean b) {
		this.b = b;
	}

	public Toggle toggle() {
		b = !b;
		return this;
	}

	public static Toggle fromMeta(Player p, String metadataKey) {
		return p.hasMetadata(metadataKey) ? (Toggle) (p
				.getMetadata(metadataKey).get(0).value()) : null;
	}

	public static Toggle fromMeta(Block b, String metadataKey) {
		return b.hasMetadata(metadataKey) ? (Toggle) (b
				.getMetadata(metadataKey).get(0).value()) : null;
	}

	public static boolean setMetaToggle(Player p, String metadataKey,
			boolean boo) {
		p.setMetadata(metadataKey, new FixedMetadataValue(FIGHT.plugin,
				new Toggle(boo)));
		return fromMeta(p, metadataKey).b;
	}

	public static boolean setMetaToggle(Block b, String metadataKey, boolean boo) {
		b.setMetadata(metadataKey, new FixedMetadataValue(FIGHT.plugin,
				new Toggle(boo)));
		return fromMeta(b, metadataKey).b;
	}

}
