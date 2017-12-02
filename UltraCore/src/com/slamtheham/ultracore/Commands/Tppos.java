package com.slamtheham.ultracore.Commands;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Tppos implements CommandExecutor {
	
	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) {
			return true;
		}
		Player player = (Player) sender;
		Location location = player.getLocation();
		if (label.equalsIgnoreCase("tppos")) {
			if (args.length == 0) {
				player.sendMessage(ChatColor.RED + "Please specify the location you want to teleport to or use /teleport help for more info.");
				return true;
			}
			if (!sender.hasPermission("core.tp")) {
				player.sendMessage(ChatColor.RED + "Sorry, you need core.tp permission to execute /teleport.");
				return true;
			}
			Location loc = new Location(player.getLocation().getWorld(), Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
			if (loc == null) {
				player.sendMessage(ChatColor.RED + "Location invalid or not typed correctly do /teleport help or contact an admin for help");
				return true;
			}
				player.teleport(loc);
				player.sendMessage(ChatColor.YELLOW + "You have been teleported to: " + ChatColor.GREEN + "X: " + args[0] + ", Y: " + args[1] + ", Z: " + args[2]);
				player.playSound(location, Sound.ENTITY_ENDERMEN_TELEPORT, 100, 1);
				player.playEffect(location, Effect.ENDER_SIGNAL, 1);
				return true;
		}
	return false;	
	}

}
