package com.slamtheham.ultracore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.slamtheham.ultracore.Main;
import com.slamtheham.ultracore.Inventories.AdminMenu;
import com.slamtheham.ultracore.Inventories.TeleportMenu;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Core implements CommandExecutor {
	
	private Plugin plugin = Main.getPlugin(Main.class);

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] strings) {
		if (sender instanceof ConsoleCommandSender) {
			return true;
		}
		
		if (string.equalsIgnoreCase("core")) {
			Player player = (Player) sender;
			Location location = player.getLocation();
			AdminMenu adminmenu = new AdminMenu();
			if (strings.length == 0) {
				sender.sendMessage(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "--------------------------------------------------");
				sender.sendMessage(ChatColor.WHITE + "" + ChatColor.BOLD + "ULTRACORE" + ChatColor.GRAY + " - How to use /core properly.");
				sender.sendMessage(" ");
				sender.sendMessage(ChatColor.YELLOW + "Proper Usage:" + ChatColor.GREEN + " /core <arg>");
				sender.sendMessage(ChatColor.AQUA + "All possible actions." + ChatColor.GRAY + "" + ChatColor.ITALIC + " (Click the text to autofill the command)");
				TextComponent message = new TextComponent(ChatColor.GREEN + "/core help" + ChatColor.YELLOW + " - Sends help message");
				message.setClickEvent( new ClickEvent( ClickEvent.Action.SUGGEST_COMMAND, "/core help" ) );
				message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to autofill command").create() ) );
				player.spigot().sendMessage(message);
				TextComponent message1 = new TextComponent(ChatColor.GREEN + "/core admin" + ChatColor.YELLOW + " - Opens admin menu");
				message1.setClickEvent( new ClickEvent( ClickEvent.Action.SUGGEST_COMMAND, "/core admin" ) );
				message1.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to autofill command").create() ) );
				player.spigot().sendMessage(message1);
				TextComponent message2 = new TextComponent(ChatColor.GREEN + "/core info/information" + ChatColor.YELLOW + " - Sends plugin information message");
				message2.setClickEvent( new ClickEvent( ClickEvent.Action.SUGGEST_COMMAND, "/core info" ) );
				message2.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to autofill command").create() ) );
				player.spigot().sendMessage(message2);
				TextComponent message3 = new TextComponent(ChatColor.GREEN + "/core ver/version" + ChatColor.YELLOW + " - Sends version message");
				message3.setClickEvent( new ClickEvent( ClickEvent.Action.SUGGEST_COMMAND, "/core ver" ) );
				message3.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to autofill command").create() ) );
				player.spigot().sendMessage(message3);
				TextComponent message4 = new TextComponent(ChatColor.GREEN + "/core reload" + ChatColor.YELLOW + " - Reloads the plugin");
				message4.setClickEvent( new ClickEvent( ClickEvent.Action.SUGGEST_COMMAND, "/core reload" ) );
				message4.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to autofill command").create() ) );
				player.spigot().sendMessage(message4);
				TextComponent message5 = new TextComponent(ChatColor.GREEN + "/core update" + ChatColor.YELLOW + " - Updates the plugin if an update is avalible");
	
				message5.setClickEvent( new ClickEvent( ClickEvent.Action.SUGGEST_COMMAND, "/core update" ) );
				message5.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to autofill command").create() ) );
				player.spigot().sendMessage(message5);
				sender.sendMessage(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "--------------------------------------------------");
				return true;				
			}
			if (strings[0].equalsIgnoreCase("help")) {
				if (!sender.hasPermission("core.help"))
				{
					sender.sendMessage(ChatColor.RED + "You need core.admin permission to execute this command!");
					return true;
				} else {
					sender.sendMessage(ChatColor.RED + "works");
					return true;
				}
				
			}
			else if (strings[0].equalsIgnoreCase("admin")) {
				if (!sender.hasPermission("core.admin")) 
				{
					sender.sendMessage(ChatColor.RED + "You need core.admin permission to execute this command!");
					return true;
				} else {
					adminmenu.newInventory(player);
					player.playSound(location, Sound.BLOCK_NOTE_PLING, 100, 1);
					return true;
				}
					
			}	
			else if (strings[0].equalsIgnoreCase("info")) {
				if (!sender.hasPermission("core.admin")) 
				{
					sender.sendMessage(ChatColor.RED + "You need core.admin permission to execute this command!");
					return true;
				} else {
					sender.sendMessage(ChatColor.RED + "works");
					return true;
				}	
			}		
			else if (strings[0].equalsIgnoreCase("ver")) {
				if (!sender.hasPermission("core.admin")) 
				{
					sender.sendMessage(ChatColor.RED + "You need core.admin permission to execute this command!");
					return true;
				} else {
					sender.sendMessage(ChatColor.RED + "works");
					return true;
				}
			}		
			else if (strings[0].equalsIgnoreCase("reload")) {
				if (!sender.hasPermission("core.admin")) 
				{
					sender.sendMessage(ChatColor.RED + "Sorry, you need core.admin permission to execute this /core reload.");
					return true;
				} else {
					sender.sendMessage(ChatColor.YELLOW + "You have reloaded the file " + ChatColor.GREEN + "config.yml");
					sender.sendMessage(ChatColor.YELLOW + "You have reloaded the file " + ChatColor.GREEN + "messages.yml");
					sender.sendMessage(ChatColor.YELLOW + "All files reloaded in " + ChatColor.GREEN + "1.003 ms");
					plugin.reloadConfig();
					return true;
				}
			}
		}
		return false;
	}
}
		