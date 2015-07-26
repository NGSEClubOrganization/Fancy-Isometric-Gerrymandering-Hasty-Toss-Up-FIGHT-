package com.ngse.fight;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.ngse.fight.classes.Ability;
import com.ngse.fight.classes.FightClass;
import com.ngse.utilities.Energy;

public class Commands {

	private Player sender;
	@SuppressWarnings("unused")
	private Command cmd;
	@SuppressWarnings("unused")
	private String commandLabel;
	private String[] args;

	public Commands(CommandSender sender, Command cmd, String commandLabel,
			String[] args) {
		this.sender = (Player) sender;
		this.cmd = cmd;
		this.commandLabel = commandLabel;
		this.args = args;

	}

	public void help() {
		sender.sendMessage("No one can help you...");
	}

	public void tester() {
		Energy.sendEnergyStatus(sender, true);
	}

	// /fight class <classname>
	public boolean createPlayer() {
		if (!FightClass.allClasses.containsKey(args[1])) {
			sender.sendMessage(ChatColor.RED
					+ "Not a valid class name (class names are case senative)");
			sender.sendMessage(ChatColor.DARK_RED
					+ "Check class names with /f class info all");
			return false;
		}
		sender.getInventory().clear();
		FIGHT.createPlayer(sender, args[1]);
		FightClass f = FightClass.get(sender);
		FIGHT.plugin.getLogger().info(sender.getName() + " : " + (f).getName());
		sender.sendMessage(ChatColor.GOLD
				+ "You have entered a new class! You are a " + ChatColor.WHITE
				+ (f).getName());
		FightClass.initiateClass(sender, f);
		return false;
	}

	@SuppressWarnings("rawtypes")
	// /fight class info all
	public void getAllClassNames() {
		sender.sendMessage("All Classes: ");
		Iterator i = FightClass.allClasses.entrySet().iterator();
		while (i.hasNext()) {
			sender.sendMessage("- - " + ChatColor.GOLD
					+ ((Map.Entry) i.next()).getKey());
		}
	}

	// /fight class info <classname>
	public boolean getFightClassInfo() {
		FightClass f = null;
		if (FightClass.allClasses.containsKey(args[2])) {
			f = FightClass.allClasses.get(args[2]);
		} else {
			sender.sendMessage(ChatColor.RED + "Not a valid class name");
			sender.sendMessage(ChatColor.DARK_RED
					+ "Check class names with /f class info all");
			return false;
		}

		// header
		sender.sendMessage(ChatColor.GRAY + "Class info: " + ChatColor.GOLD
				+ f.getName().toUpperCase());

		// abilities
		sender.sendMessage(ChatColor.GRAY + "    Abilities:");
		for (Ability a : f.getAbilities()) {
			sender.sendMessage("      - " + ChatColor.BLUE + "(" + a.getLevel()
					+ ") " + ChatColor.YELLOW + a.getName());
		}

		// items
		sender.sendMessage(ChatColor.GRAY + "    Items:");
		for (ItemStack i : f.getItems()) {
			sender.sendMessage("      - " + ChatColor.GREEN
					+ i.getType().toString());
		}
		return false;
	}
}
