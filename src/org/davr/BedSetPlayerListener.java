package org.davr;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.event.player.*;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.*;
import org.bukkit.block.*;

public class BedSetPlayerListener implements Listener {

	@EventHandler(priority = EventPriority.LOW)
	public void onPlayerInteract(PlayerInteractEvent e) {
		Logger console = Logger.getLogger("Minecraft");
		if(e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
		Block b = e.getClickedBlock();
		if(b.getType() != Material.BED_BLOCK) return;
		Player p = e.getPlayer();
		Location lb = b.getLocation();
		Location ls = p.getBedSpawnLocation();
		if(lb == null) {
			console.log(Level.INFO, "null location of block click?");
			return;
		}
		double d = (ls != null)?lb.distance(ls):999;
		console.log(Level.INFO, "Bed click detected: "+lb+" old spawn: "+ls+" dist: "+d);
		if(d > 1) {
			console.log(Level.INFO, "Distance over 1, setting spawn");
			p.setBedSpawnLocation(lb);
		}
	}
}
	
