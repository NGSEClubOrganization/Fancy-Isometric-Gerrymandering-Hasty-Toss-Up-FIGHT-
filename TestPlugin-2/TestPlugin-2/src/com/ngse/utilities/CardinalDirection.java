package com.ngse.utilities;

import org.bukkit.entity.Player;

public enum CardinalDirection {

	NORTH, SOUTH, EAST, WEST;

	public static CardinalDirection getCardinalDirection(Player p) {
		CardinalDirection cd = CardinalDirection.NORTH;
		
		p.getEyeLocation();
		
		
		
		return cd;
	}

}
