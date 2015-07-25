package com.ngse.fight;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FightCommandExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {

		Commands c = new Commands(sender, cmd, commandLabel, args);

		if (sender instanceof Player) {

			if (commandLabel.equalsIgnoreCase("fight")
					|| commandLabel.equalsIgnoreCase("f")) {

				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("help")) {
						c.help();
					} else if (args[0].equalsIgnoreCase("t")) {
						c.tester();
					}
				} else if (args.length == 2) {
					// become a certain class
					if (args[0].equalsIgnoreCase("class")) {
						c.createPlayer();
					}
				} else if (args.length == 3) {
					if (args[0].equalsIgnoreCase("class")
							&& args[1].equalsIgnoreCase("info")) {
						if (args[2].equalsIgnoreCase("all")) {
							c.getAllClassNames();
						} else {
							c.getFightClassInfo();
						}
					}
				}
			}
		}
		return false;
	}
}
