package com.slamtheham.ultracore.Commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Tpa implements CommandExecutor {
	
	HashMap<Player, Player> tpa = new HashMap<Player, Player>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) {
			return true;
		}	
		Player player = (Player) sender;
		if (label.equalsIgnoreCase("tpa")) {
			if (args.length == 1) {
				Player target = (Player) Bukkit.getServer().getPlayer(args[0]);
				if(target != null) {
					tpa.put(target, player);
					target.sendMessage(ChatColor.GREEN + player.getName() + ChatColor.YELLOW + " has sent you a teleportation request.");
					TextComponent message1 = new TextComponent(ChatColor.YELLOW + "Click to accept the request -" + ChatColor.GREEN + ChatColor.BOLD + " [ACCEPT]");
					TextComponent message2 = new TextComponent(ChatColor.YELLOW + "Click to deny the request -" + ChatColor.RED + ChatColor.BOLD + " [DENY]");
					message1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpaccept"));
					message1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.AQUA + "Click accept the request").create()));
					message2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpdeny"));
					message2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.AQUA + "Click deny the request").create()));
					target.spigot().sendMessage(message1);
					target.spigot().sendMessage(message2);
					return true;
				}
			}
		}
		if (label.equalsIgnoreCase("tpaccept")) {
			if(tpa.get(player) != null) {
				player.sendMessage(ChatColor.YELLOW + "You have teleported to " + ChatColor.GREEN + tpa.get(player).getName());
				tpa.get(player).sendMessage(ChatColor.GREEN + tpa.get(player).getName() + ChatColor.YELLOW + " Has teleported to you.");
				tpa.get(player).teleport(player);
				tpa.put(player, null);
				return true;
			}
		if (label.equalsIgnoreCase("tpdeny")) {
			if(tpa.get(player) != null) {
				player.sendMessage(ChatColor.YELLOW + "Your teleportation request was denied");
				tpa.put(player, null);
				tpa.get(player).sendMessage(ChatColor.YELLOW + "You have denied the teleportation request");
				return true;
			}
			}			
		}	
	return false;	
	}
}
	
