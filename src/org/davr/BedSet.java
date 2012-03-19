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
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
* BedSet 1.0
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Public License as published by
* the Free Software Foundation, either version 2 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Permissions Public License for more details.
*
* You should have received a copy of the GNU Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

/**
* This plugin was written for Craftbukkit
* @author davr
*/

public class BedSet extends JavaPlugin {
	protected static final Logger console = Logger.getLogger("Minecraft");
	private final BedSetPlayerListener playerListener = new BedSetPlayerListener();
//	public static PermissionHandler permissionHandler = null;
//	public static PermissionManager permissionExHandler = null;
	
	@Override
	public void onDisable() {
		console.log(Level.INFO, "[BedSet] version " + this.getDescription().getVersion() + " disabled.");
	}

	@Override
	public void onEnable() {		
		PluginManager pm = this.getServer().getPluginManager();	
		pm.registerEvents(playerListener, this);
		console.log(Level.INFO, "[BedSet] version " + this.getDescription().getVersion() + " enabled.");
	}

}
