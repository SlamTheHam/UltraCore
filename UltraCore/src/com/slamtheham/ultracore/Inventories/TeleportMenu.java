package com.slamtheham.ultracore.Inventories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import com.slamtheham.ultracore.Main;

public class TeleportMenu implements Listener {
	
	private Plugin plugin = Main.getPlugin(Main.class);
   
    @SuppressWarnings("deprecation")
	public void newInventory(Player player) {
        Inventory teleportmenu = plugin.getServer().createInventory(null, 45, ChatColor.DARK_GRAY + "TeleportMenu - Use /teleport help for more info");       
        	Player players =  (Player) Bukkit.getOnlinePlayers();
                ItemStack skull  =  new ItemStack(Material.SKULL_ITEM);
                String headName = players.getName();
                skull.setDurability((short)3);
                SkullMeta sm = (SkullMeta)skull.getItemMeta();
                sm.setOwner(headName);
               
                sm.setDisplayName(ChatColor.YELLOW + "Teleport to: " + ChatColor.GREEN + players.getName());
                List<String> lore = new ArrayList<String>();
                lore.add(ChatColor.BOLD + "Left-Click to teleport to this player.");
                sm.setLore(lore);
                skull.setItemMeta(sm);
               
                ItemStack back = new ItemStack(Material.SIGN);
                ItemStack close = new ItemStack(Material.BARRIER);
                ItemMeta closeMeta = close.getItemMeta();
                ItemMeta backMeta = back.getItemMeta();
                backMeta.setDisplayName(ChatColor.RED + "Back");
                backMeta.setLore(Arrays.asList("Go back to the main menu"));
                back.setItemMeta(backMeta);
               
                teleportmenu.setItem(35, back);
                teleportmenu.addItem(skull);
    			}
    		}
