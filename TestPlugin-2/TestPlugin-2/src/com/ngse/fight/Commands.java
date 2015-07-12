package com.ngse.fight;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands {

	private CommandSender sender;
	private Command cmd;
	private String commandLabel;
	private String[] args;

	public Commands(CommandSender sender, Command cmd, String commandLabel,
			String[] args) {
		this.sender = sender;
		this.cmd = cmd;
		this.commandLabel = commandLabel;
		this.args = args;

	}

	public void createPlayer() {
		FIGHT.createPlayer((Player) sender, args[1]);
		sender.sendMessage(ChatColor.GOLD
				+ "You have entered a new class! You are a "
				+ ChatColor.WHITE
				+ FIGHT.getFightPlayer((Player) sender).getFightClass()
						.getName());
	}

	public void getAllClassNames() {

	}

	public void getFightClass() {

	}

	public void getAbilites() {
		// TODO
	}

}
