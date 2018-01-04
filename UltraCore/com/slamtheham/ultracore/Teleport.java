package com.slamtheham.ultracore;

import com.slamtheham.ultracore.Inventories.TeleportMenu;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Teleport implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] strings) {
        if (sender instanceof ConsoleCommandSender) {
            return true;
        }
        if (string.equalsIgnoreCase("teleport")) {
            Player player = (Player) sender;
            TeleportMenu teleportmenu = new TeleportMenu();
            if (strings.length == 0) {
                teleportmenu.newInventory(player);
                return true;

            } else if (strings[0].equalsIgnoreCase("help"))
                player.sendMessage(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "--------------------------------------------------");
            player.sendMessage(ChatColor.WHITE + "" + ChatColor.BOLD + "ULTRACORE" + ChatColor.GRAY + " - How to use /teleport properly.");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.YELLOW + "Proper Usage:" + ChatColor.GREEN + " /teleport <arg0> <arg1>");
            player.sendMessage(ChatColor.AQUA + "All possible actions." + ChatColor.GRAY + "" + ChatColor.ITALIC + " (Click the text to autofill the command)");
            TextComponent message = new TextComponent(ChatColor.GREEN + "/teleport <player>" + ChatColor.YELLOW + " - Teleports you to player");
            message.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/teleport <player>"));
            message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to autofill command").create()));
            player.spigot().sendMessage(message);
            TextComponent message1 = new TextComponent(ChatColor.GREEN + "/teleport here <player>" + ChatColor.YELLOW + " - Teleports player to you");
            message1.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/teleport here <player>"));
            message1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to autofull command").create()));
            player.spigot().sendMessage(message1);
            TextComponent message2 = new TextComponent(ChatColor.GREEN + "/teleport pos <x> <y> <z>" + ChatColor.YELLOW + " - Sends plugin information message");
            message2.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/teleport pos <x> <y> <z>"));
            message2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to autofill command").create()));
            player.spigot().sendMessage(message2);
            player.sendMessage(ChatColor.YELLOW + "Command Aliases" + ChatColor.AQUA + " - /tp, /tpo");
            player.sendMessage(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "--------------------------------------------------");
            return true;
        }
        Player player = (Player) sender;
        Location location = player.getLocation();
        Player target = Bukkit.getPlayer(strings[0]);
        if (strings[0].equalsIgnoreCase(strings[0])) {
            if (!sender.hasPermission("core.tp")) {
                player.sendMessage(ChatColor.RED + "You need core.admin permission to execute this command!");
                return true;
            } else {
                if (strings[0].equals(player.getName())) {
                    player.sendMessage(ChatColor.RED + "Lol, you cannot teleport to yourself dummy.");
                    return true;
                } else {
                    player.playSound(location, Sound.ENTITY_ENDERMEN_TELEPORT, 100, 1);
                    player.teleport(target);
                    player.sendMessage(ChatColor.YELLOW + "You've teleported to " + ChatColor.GREEN + strings[0]);
                    return true;
                }
            }
        }
        return false;
    }
}	
