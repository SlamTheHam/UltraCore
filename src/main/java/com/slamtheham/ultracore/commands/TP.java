package com.slamtheham.ultracore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.slamtheham.ultracore.Main;
import com.slamtheham.ultracore.Inventories.TeleportHereMenu;
import com.slamtheham.ultracore.Inventories.TeleportMenu;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class TP implements CommandExecutor {
	
	private Plugin plugin = Main.getPlugin(Main.class);

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) {
			return true;
		}
		if (label.equalsIgnoreCase("tp")) {
			if (!(args.length == 0)) {
				if (args[0].equalsIgnoreCase("help")) {
					sender.sendMessage(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "--------------------------------------------------");
					sender.sendMessage(ChatColor.WHITE + "" + ChatColor.BOLD + "ULTRACORE" + ChatColor.GRAY + " - How to use /teleport properly.");
					sender.sendMessage(" ");
					sender.sendMessage(ChatColor.YELLOW + "Proper Usage:" + ChatColor.GREEN + " /teleport <arg0> <arg1>");
					sender.sendMessage(ChatColor.AQUA + "All possible actions." + ChatColor.GRAY + "" + ChatColor.ITALIC + " (Click the text to autofill the command)");
					TextComponent message = new TextComponent(ChatColor.GREEN + "/teleport <player>" + ChatColor.YELLOW + " - Teleports you to player");
					message.setClickEvent( new ClickEvent( ClickEvent.Action.SUGGEST_COMMAND, "/teleport <player>" ) );
					message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to autofill command").create() ) );
					sender.spigot().sendMessage(message);
					TextComponent message1 = new TextComponent(ChatColor.GREEN + "/teleport here <player>" + ChatColor.YELLOW + " - Teleports player to you");
					message1.setClickEvent( new ClickEvent( ClickEvent.Action.SUGGEST_COMMAND, "/teleport here <player>" ) );
					message1.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to autofull command").create() ) );
					sender.spigot().sendMessage(message1);
					TextComponent message2 = new TextComponent(ChatColor.GREEN + "/teleport pos <x> <y> <z>" + ChatColor.YELLOW + " - Sends plugin information message");
					message2.setClickEvent( new ClickEvent( ClickEvent.Action.SUGGEST_COMMAND, "/teleport pos <x> <y> <z>" ) );
					message2.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to autofill command").create() ) );
					sender.spigot().sendMessage(message2);
					sender.sendMessage(ChatColor.YELLOW + "Command Aliases" + ChatColor.AQUA + " - /tp, /tpo");
					sender.sendMessage(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "--------------------------------------------------");
					return true;
				}
		}
		else { 
			TeleportMenu.newInventory(sender);
			return true;
		}
		Player player = (Player) sender;
		Location location = player.getLocation();	
		if (args.length == 0) {
			player.sendMessage(ChatColor.RED + "Please specify the player you want to teleport to or use /teleport help for more info.");
			return true;
		}
		if (!sender.hasPermission("core.tp")) {
			player.sendMessage(ChatColor.RED + "Sorry, you need core.tp permission to execute /teleport.");
			return true;
		}  
		if (args[0].equals(player.getName())) {
			player.sendMessage(ChatColor.RED + "Lol, you cannot teleport to yourself dummy.");
			return true;				
		}
		Player target = Bukkit.getServer().getPlayer(args[0]);
		if (target == null) {
			player.sendMessage(ChatColor.RED + "Can't find user specified.");
			return true;	
		}
			player.teleport(target);
			player.sendMessage(ChatColor.YELLOW + "You've teleported to " + ChatColor.GREEN + target.getDisplayName() + ChatColor.YELLOW + "!");
			player.playSound(location, Sound.ENTITY_ENDERMEN_TELEPORT, 100, 1);
			player.playEffect(location, Effect.ENDER_SIGNAL, 1);
			target.playEffect(location, Effect.ENDER_SIGNAL, 1);
			return true;
		}
		Player player = (Player) sender;
		Location location = player.getLocation();
		if (!(args.length == 0)) {
			if (args[0].equalsIgnoreCase("here")) {
				if (args.length == 1) {
					player.sendMessage(ChatColor.RED + "Please specify the player you want to teleport to or use /teleport help for more info.");
					TeleportHereMenu.newInventory(sender);
					return true;
				}
				if (!sender.hasPermission("core.tp.here")) {
					player.sendMessage(ChatColor.RED + "Sorry, you need core.tp permission to execute /teleport.");
					return true;
				}
				if (args[1].equals(player.getName())) {
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
