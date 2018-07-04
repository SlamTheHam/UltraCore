package com.slamtheham.ultracore.commands;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.slamtheham.ultracore.inventories.TeleportHereMenu;

import net.md_5.bungee.api.ChatColor;

public class Tphere implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) {
			return true;
		}
		Player player = (Player) sender;
		Location location = player.getLocation();
		if (label.equalsIgnoreCase("tphere")) {
			if (!(args.length == 0)) {
				if (args.length == 0) {
					player.sendMessage(ChatColor.RED + "Please specify the player you want to teleport to or use /teleport help for more info.");
					TeleportHereMenu.newInventory(sender);
					return true;
				}
				if (!sender.hasPermission("core.tp")) {
					player.sendMessage(ChatColor.RED + "Sorry, you need core.tp permission to execute /tphere.");
					return true;
				}
				if (args[0].equals(player.getName())) {
					player.sendMessage(ChatColor.RED + "Lol, you cannot teleport to yourself dummy.");
					return true;				
				}
				Player target1 = Bukkit.getServer().getPlayer(args[1]);
				if (target1 == null) {
					player.sendMessage(ChatColor.RED + "Can't find user specified.");
					return true;	
				}
				target1.teleport(player);
				player.sendMessage(ChatColor.YELLOW + "You've teleported " + ChatColor.GREEN + target1.getDisplayName() + ChatColor.YELLOW + " to you!");
				player.playSound(location, Sound.ENTITY_ENDERMEN_TELEPORT, 100, 1);
				player.playEffect(location, Effect.ENDER_SIGNAL, 1);
				target1.playEffect(location, Effect.ENDER_SIGNAL, 1);
				return true;
			}
		}
	return false;	
	}
}
