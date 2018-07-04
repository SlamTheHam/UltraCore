package com.slamtheham.ultracore;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.slamtheham.ultracore.commands.Core;
import com.slamtheham.ultracore.commands.TP;
import com.slamtheham.ultracore.commands.TPO;
import com.slamtheham.ultracore.commands.Teleport;
import com.slamtheham.ultracore.commands.Tpa;
import com.slamtheham.ultracore.commands.Tphere;
import com.slamtheham.ultracore.commands.Tppos;
import com.slamtheham.ultracore.inventories.AdminMenu;
import com.slamtheham.ultracore.inventories.TeleportMenu;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {

    private static Plugin plugin;
    FileConfiguration config;
    FileConfiguration messages;
    File file;

    @SuppressWarnings("unused")
    public void onEnable() {
        plugin = this;
        Bukkit.getServer().getLogger().info(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "--------------------------------------------------");
        Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "██╗   ██╗██╗  ████████╗██████╗  █████╗  ██████╗ ██████╗ ██████╗ ███████╗");
        Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "██║   ██║██║  ╚══██╔══╝██╔══██╗██╔══██╗██╔════╝██╔═══██╗██╔══██╗██╔════╝");
        Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "██║   ██║██║     ██║   ██████╔╝███████║██║     ██║   ██║██████╔╝█████╗  ");
        Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "██║   ██║██║     ██║   ██╔══██╗██╔══██║██║     ██║   ██║██╔══██╗██╔══╝  ");
        Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "╚██████╔╝███████╗██║   ██║  ██║██║  ██║╚██████╗╚██████╔╝██║  ██║███████╗");
        Bukkit.getServer().getLogger().info(ChatColor.YELLOW + " ╚═════╝ ╚══════╝╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝ ╚═════╝ ╚═╝  ╚═╝╚══════╝");
        Bukkit.getServer().getLogger().info(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "--------------------------------------------------");
        Bukkit.getServer().getLogger().info(ChatColor.GREEN + "166" + ChatColor.YELLOW + "Commands have been loaded");
        Bukkit.getServer().getLogger().info(ChatColor.GREEN + "205" + ChatColor.YELLOW + "Permissions have been loaded");
        Bukkit.getServer().getLogger().info(ChatColor.GREEN + "ProtocalLib" + ChatColor.YELLOW + "has been Hooked");
        Bukkit.getServer().getLogger().info(ChatColor.GREEN + "PlaceholderAPI" + ChatColor.YELLOW + "has been Hooked");
        Bukkit.getServer().getLogger().info(ChatColor.GREEN + "Vault" + ChatColor.YELLOW + "has been Hooked");
        Bukkit.getServer().getLogger().info(ChatColor.GRAY + "[" + ChatColor.RED + "UltraCore v1" + ChatColor.GRAY + "]" + ChatColor.AQUA + " Has beeen Loaded and Enabled");
        Bukkit.getServer().getLogger().info(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "--------------------------------------------------");
        Bukkit.getServer().getPluginManager().registerEvents(new Events(), this);
        getServer().getPluginManager().registerEvents(new TeleportMenu(), this);
        getServer().getPluginManager().registerEvents(new AdminMenu(), this);
        getCommand("core").setExecutor(new Core());
        getCommand("teleport").setExecutor(new Teleport());
        getCommand("tp").setExecutor(new TP());
        getCommand("tpo").setExecutor(new TPO());
        getCommand("tppos").setExecutor(new Tppos());
        getCommand("tphere").setExecutor(new Tphere());
        getCommand("tpa").setExecutor(new Tpa());
        getCommand("tpaccept").setExecutor(new Tpa());
        getCommand("tpdeny").setExecutor(new Tpa());
        File f = new File("plugins/UltraCore/", "messages.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
        cfg.set("this.is.the.file.structure", "this_is_the_string");
        try {
            cfg.save(f);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String s = cfg.getString("this.is.the.file.structure");
        final FileConfiguration config = this.getConfig();
        config.addDefault("toggle.freezetime", "false");
        config.addDefault("toggle.noweather", "false");
        config.addDefault("toggle.nopvp", "false");
        config.addDefault("toggle.joinandleave", "false");
        config.addDefault("toggle.spawn", "false");
        config.addDefault("toggle.motd", "false");
        config.addDefault("toggle.chat", "false");
        config.addDefault("toggle.tablist", "false");
        config.addDefault("toggle.firstjoinkit", "false");
        config.options().copyDefaults(true);
        saveConfig();
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

            @Override
            public void run() {
                if (plugin.getConfig().getString("toggle.freezetime").equals(true)) {
                    for (World w : Bukkit.getServer().getWorlds()) {
                        w.setTime(0L);
                    }
                }
            }
        }, 0L, 10000L);
    }

    public void onDisable() {
        Bukkit.getServer().getLogger().info(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "--------------------------------------------------");
        Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "██╗   ██╗██╗  ████████╗██████╗  █████╗  ██████╗ ██████╗ ██████╗ ███████╗");
        Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "██║   ██║██║  ╚══██╔══╝██╔══██╗██╔══██╗██╔════╝██╔═══██╗██╔══██╗██╔════╝");
        Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "██║   ██║██║     ██║   ██████╔╝███████║██║     ██║   ██║██████╔╝█████╗  ");
        Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "██║   ██║██║     ██║   ██╔══██╗██╔══██║██║     ██║   ██║██╔══██╗██╔══╝  ");
        Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "╚██████╔╝███████╗██║   ██║  ██║██║  ██║╚██████╗╚██████╔╝██║  ██║███████╗");
        Bukkit.getServer().getLogger().info(ChatColor.YELLOW + " ╚═════╝ ╚══════╝╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝ ╚═════╝ ╚═╝  ╚═╝╚══════╝");
        Bukkit.getServer().getLogger().info(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "--------------------------------------------------");
        Bukkit.getServer().getLogger().info(ChatColor.GREEN + "166" + ChatColor.YELLOW + "Commands have been unloaded");
        Bukkit.getServer().getLogger().info(ChatColor.GREEN + "205" + ChatColor.YELLOW + "Permissions have been unloaded");
        Bukkit.getServer().getLogger().info(ChatColor.GREEN + "ProtocalLib" + ChatColor.YELLOW + "has been unHooked");
        Bukkit.getServer().getLogger().info(ChatColor.GREEN + "PlaceholderAPI" + ChatColor.YELLOW + "has been unHooked");
        Bukkit.getServer().getLogger().info(ChatColor.GREEN + "Vault" + ChatColor.YELLOW + "has been unHooked");
        Bukkit.getServer().getLogger().info(ChatColor.GRAY + "[" + ChatColor.RED + "UltraCore v1" + ChatColor.GRAY + "]" + ChatColor.AQUA + " Has beeen unloaded and Disabled");
        Bukkit.getServer().getLogger().info(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "--------------------------------------------------");


    }

    {

    }
}
