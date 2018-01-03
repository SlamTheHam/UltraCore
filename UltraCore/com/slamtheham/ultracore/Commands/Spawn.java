package com.slamtheham.ultracore.Commands;

import com.slamtheham.ultracore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Spawn implements CommandExecutor {

    private Plugin plugin = Main.getPlugin(Main.class);

    @SuppressWarnings("unused")
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            return true;
        }

        Player player = (Player) sender;

        if (label.equalsIgnoreCase("setspawn")) {
            if (!sender.hasPermission("core.admin")) {
                player.sendMessage(" ");
                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + " ERROR!");
                player.sendMessage(ChatColor.YELLOW + " Sorry, you need core.admin permission to execute /setspawn.");
                player.sendMessage(" ");
                return true;
            }
            plugin.getConfig().set("spawn.world", player.getLocation().getWorld().getName());
            plugin.getConfig().set("spawn.x", player.getLocation().getX());
            plugin.getConfig().set("spawn.y", player.getLocation().getY());
            plugin.getConfig().set("spawn.z", player.getLocation().getZ());
            plugin.getConfig().set("spawn.yaw", player.getLocation().getYaw());
            plugin.getConfig().set("spawn.pitch", player.getLocation().getPitch());
            plugin.saveConfig();
            player.sendMessage(ChatColor.YELLOW + "You have setspawn at " + ChatColor.GREEN + "X: " + plugin.getConfig().getString("spawn.x") + " " + "Y: " + plugin.getConfig().getString("spawn.y") + " " + "Z: " + plugin.getConfig().getString("spawn.z"));
            return true;

        }
        if (label.equalsIgnoreCase("spawn")) {
            if (!sender.hasPermission("core.spawn")) {
                player.sendMessage(" ");
                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + " ERROR!");
                player.sendMessage(ChatColor.YELLOW + " Sorry, you need core.admin permission to execute /setspawn.");
                player.sendMessage(" ");
                return true;
            }
            if (plugin.getConfig().getConfigurationSection("spawn") == null) {
                player.sendMessage(" ");
                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + " ERROR!");
                player.sendMessage(ChatColor.YELLOW + " You must set spawn to use /spawn (use /setspawn to set)");
                player.sendMessage(" ");
                return true;

            }
            World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("spawn.world"));
            double x = plugin.getConfig().getDouble("spawn.x");
            double y = plugin.getConfig().getDouble("spawn.y");
            double z = plugin.getConfig().getDouble("spawn.z");
            float yaw = (float) plugin.getConfig().getDouble("spawn.yaw");
            float pitch = (float) plugin.getConfig().getDouble("spawn.pitch");
            player.teleport(new Location(w, x, y, z, yaw, pitch));
            player.sendMessage(ChatColor.YELLOW + "You have teleported to spawn set at" + ChatColor.GREEN + " X:" + x + " Y:" + y + " Z:" + z + ChatColor.YELLOW + "!");
            return true;


        }

        return false;
    }

}
