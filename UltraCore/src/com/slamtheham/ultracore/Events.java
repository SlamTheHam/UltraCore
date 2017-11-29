package com.slamtheham.ultracore;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import com.slamtheham.ultracore.Inventories.AdminMenu;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Events implements Listener {
	
	private Plugin plugin = Main.getPlugin(Main.class);
			
	@EventHandler
	public void InvenClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		
		Inventory open = event.getClickedInventory();
		ItemStack item = event.getCurrentItem();
		
		if (open == null) {
			return;			
		}		
		if (open.getName().equals(ChatColor.DARK_GRAY + "Admin Menu - Page 1")) {
			
			event.setCancelled(true);	
			
			if (item == null || !item.hasItemMeta()) {
				return;	
			}	
			
			if (item.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "" + ChatColor.BOLD + "Toggle" + ChatColor.GREEN + "" + ChatColor.BOLD + " ON" )) {
				player.closeInventory();
				AdminMenu adminmenu = new AdminMenu();
				player.sendMessage("ITS WORKING FFS");
				adminmenu.newInventory(player);
				
			}	
		}
	}	
}
