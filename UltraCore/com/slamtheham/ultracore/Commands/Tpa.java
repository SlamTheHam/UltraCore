package com.slamtheham.ultracore.Commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Tpa implements CommandExecutor {

    private Map<Player, Player> tpaPlayers = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            final Player playerSender = (Player) sender;
            if (args.length == 1) {
                if (label.equals("tpa")) {
                    final Player playerRequested = Bukkit.getPlayer(args[0]);
                    if (playerRequested != null) {
                        tpaPlayers.put(playerRequested, playerSender);
                        playerSender.sendMessage("Teleport request send to " + playerRequested.getName());
                        playerRequested.sendMessage(ChatColor.GREEN + playerSender.getName() + ChatColor.YELLOW + " has sent you a teleportation request.");
                        
                        TextComponent message1 = new TextComponent(ChatColor.YELLOW + "Click to accept the request -" + ChatColor.GREEN + ChatColor.BOLD + " [ACCEPT]");
                        message1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpaccept"));
                        message1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.AQUA + "Click to accept the request").create()));
                        playerRequested.spigot().sendMessage(message1);
                        
                        TextComponent message2 = new TextComponent(ChatColor.YELLOW + "Click to deny the request -" + ChatColor.RED + ChatColor.BOLD + " [DENY]");
                        message2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpdeny"));
                        message2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.AQUA + "Click to deny the request").create()));
                        playerRequested.spigot().sendMessage(message2);
                    } else {
                        playerSender.sendMessage(playerRequested.getName() + " is offline");
                    }
                }
            } else if (args.length == 0) {
                final Player playerToTeleport = tpaPlayers.get(playerSender);
                if (playerToTeleport != null) {
                    if (label.equals("tpaccept")) {
                        playerToTeleport.sendMessage(playerSender.getName() + " has accepted your teleport request");
                        playerSender.sendMessage("Teleporting " + playerToTeleport.getName() + " to you");
                        playerToTeleport.teleport(playerSender);
                    } else {
                        playerToTeleport.sendMessage(playerSender + " has denied your teleport request");
                        playerSender.sendMessage(playerToTeleport.getName() + " teleport request denied");
                    }
                    tpaPlayers.remove(playerSender);
                } else {
                    playerSender.sendMessage("You don't have any teleport request");
                }
            }
        }
        return true;
    }
}