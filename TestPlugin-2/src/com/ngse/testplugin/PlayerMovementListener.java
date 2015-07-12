package com.ngse.testplugin;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerMovementListener implements Listener {

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		e.getPlayer().sendMessage(
				Double.toString(e.getPlayer().getLocation().getX()));
		e.getPlayer().sendMessage(
				Double.toString(e.getBlock().getLocation().getX()));
		if (!e.getPlayer().getItemInHand().getType().equals(Material.WOOD_AXE)) {
			e.setCancelled(true);
		}
	}
}
