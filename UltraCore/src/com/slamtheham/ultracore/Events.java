package com.slamtheham.ultracore;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import com.slamtheham.ultracore.Inventories.AdminMenu;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Events implements Listener {
	
	private Plugin plugin = Main.getPlugin(Main.class);
			
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack is = event.getCurrentItem();
        AdminMenu adminmenu = new AdminMenu();
        if ((event.getCurrentItem() != null) && (event.getCurrentItem().getType() != Material.AIR)) {
            if (event.getInventory().getName().equals(ChatColor.DARK_GRAY + "Admin Menu - Page 1")) {
                event.setCancelled(true);
                if ((event.getCurrentItem().getType() == Material.INK_SACK) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Toggled:" + ChatColor.RED + "" + ChatColor.BOLD + " OFF"))) {
                    player.closeInventory();
                    player.sendMessage(ChatColor.GREEN + "You've toggled " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Freeze Weather " + ChatColor.GRAY + "- " + ChatColor.GREEN + "" + ChatColor.BOLD + "ON");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0F, 0.1F);
                    plugin.getConfig().set("Freeze.time", true);
                    plugin.saveConfig();
                    adminmenu.newInventory(player);
                    
                	}
                
                if ((event.getCurrentItem().getType() == Material.INK_SACK) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Toggled:" + ChatColor.GREEN + "" + ChatColor.BOLD + " ON"))) {
                    player.closeInventory();
                    player.sendMessage(ChatColor.GREEN + "You've toggled " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Freeze Weather " + ChatColor.GRAY + "- " + ChatColor.RED + "" + ChatColor.BOLD + "OFF");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0F, 0.1F);
                    plugin.getConfig().set("Freeze.time", false);
                    plugin.saveConfig();
                    adminmenu.newInventory(player);
                }
            }
        }
    }	
}    
