package com.slamtheham.ultracore;

import java.net.URL;
import java.util.Scanner;

import javax.swing.text.Document;
import javax.swing.text.html.parser.Element;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	
	private static Plugin plugin;
	
	public void onEnable() {
		plugin = this;	
    	Bukkit.getServer().getLogger().info(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "--------------------------------------------------");	
	    Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "██╗   ██╗██╗  ████████╗██████╗  █████╗  ██████╗ ██████╗ ██████╗ ███████╗");
	    Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "██║   ██║██║  ╚══██╔══╝██╔══██╗██╔══██╗██╔════╝██╔═══██╗██╔══██╗██╔════╝");
	    Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "██║   ██║██║     ██║   ██████╔╝███████║██║     ██║   ██║██████╔╝█████╗  ");
	    Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "██║   ██║██║     ██║   ██╔══██╗██╔══██║██║     ██║   ██║██╔══██╗██╔══╝  ");
	    Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "╚██████╔╝███████╗██║   ██║  ██║██║  ██║╚██████╗╚██████╔╝██║  ██║███████╗");
	    Bukkit.getServer().getLogger().info(ChatColor.YELLOW + " ╚═════╝ ╚══════╝╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝ ╚═════╝ ╚═╝  ╚═╝╚══════╝");
	    Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "");
	    Bukkit.getServer().getLogger().info(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "--------------------------------------------------");
	    Bukkit.getServer().getLogger().info(ChatColor.GREEN + "166" + ChatColor.YELLOW + "Commands have been loaded");
	    Bukkit.getServer().getLogger().info(ChatColor.GREEN + "205" + ChatColor.YELLOW + "Permissions have been loaded");
	    Bukkit.getServer().getLogger().info(ChatColor.GREEN + "ProtocalLib" + ChatColor.YELLOW + "has been Hooked");
	    Bukkit.getServer().getLogger().info(ChatColor.GREEN + "PlaceholderAPI" + ChatColor.YELLOW + "has been Hooked");
	    Bukkit.getServer().getLogger().info(ChatColor.GREEN + "Vault" + ChatColor.YELLOW + "has been Hooked");
	    Bukkit.getServer().getLogger().info(ChatColor.GRAY + "[" + ChatColor.RED + "UltraCore v1" + ChatColor.GRAY + "]" + ChatColor.AQUA + " Has beeen Loaded and Enabled");
	    Bukkit.getServer().getLogger().info(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "--------------------------------------------------");
	    Bukkit.getServer().getPluginManager().registerEvents(new Events(), this);
		getCommand("core").setExecutor(new Core());
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		
	}
	
		
	public void onDisable() {	
    	Bukkit.getServer().getLogger().info(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "--------------------------------------------------");	
	    Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "██╗   ██╗██╗  ████████╗██████╗  █████╗  ██████╗ ██████╗ ██████╗ ███████╗");
	    Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "██║   ██║██║  ╚══██╔══╝██╔══██╗██╔══██╗██╔════╝██╔═══██╗██╔══██╗██╔════╝");
	    Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "██║   ██║██║     ██║   ██████╔╝███████║██║     ██║   ██║██████╔╝█████╗  ");
	    Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "██║   ██║██║     ██║   ██╔══██╗██╔══██║██║     ██║   ██║██╔══██╗██╔══╝  ");
	    Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "╚██████╔╝███████╗██║   ██║  ██║██║  ██║╚██████╗╚██████╔╝██║  ██║███████╗");
	    Bukkit.getServer().getLogger().info(ChatColor.YELLOW + " ╚═════╝ ╚══════╝╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝ ╚═════╝ ╚═╝  ╚═╝╚══════╝");
	    Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "");
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
