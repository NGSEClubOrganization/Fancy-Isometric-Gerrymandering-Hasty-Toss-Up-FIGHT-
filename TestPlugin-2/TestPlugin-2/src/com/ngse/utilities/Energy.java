package com.ngse.utilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import com.ngse.fight.FIGHT;

public class Energy {

	private int energy;

	public int getEnergy() {
		return energy;
	}

	public Energy(int a) {
		energy = a;
	}

	public static void updateExp(Player p) {
		p.setTotalExperience(get(p));
	}

	public static int get(Player p) {
		if (p.hasMetadata("energy")) {
			return ((Energy) (p.getMetadata("energy").get(0).value()))
					.getEnergy();
		} else {
			return -1;
		}
	}

	public static int set(Player p, int a) {
		int b = get(p);
		p.setMetadata("energy", new FixedMetadataValue(FIGHT.plugin,
				new Energy(a)));
		sendEnergyStatus(p, b - a);
		updateExp(p);
		return get(p);
	}

	public static int add(Player p, int a) {
		set(p, get(p) + a);
		sendEnergyStatus(p, a);
		updateExp(p);
		return get(p);
	}

	public static String convertToString(Energy e) {
		String str = " ";
		if (e.getEnergy() > 0) {
			for (int i = 0; i < e.getEnergy(); i++) {
				str += "• ";
			}
		}
		return str;
	}

	public static String convertToString(int a) {
		String str = " ";
		if (a > 0) {
			for (int i = 0; i < a; i++) {
				str += "•";
			}
		}
		return str;
	}

	/*
	 * Sends amount of energy the player has
	 * 
	 * @Param d: >0 means positive change recently. <0 means negative change
	 * recently. 0 means no change
	 */
	public static void sendEnergyStatus(Player p, int d) {
		if (d > 0) {
			p.sendMessage(ChatColor.BLUE + "[ENERGY] " + ChatColor.GREEN
					+ Energy.convertToString(Energy.get(p)));
		} else if (d < 0) {
			p.sendMessage(ChatColor.RED + "[ENERGY] " + ChatColor.GREEN
					+ Energy.convertToString(Energy.get(p)));
		} else if (d == 0) {
			// nothing
		}
	}
}
