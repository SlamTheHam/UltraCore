package com.slamtheham.ultracore.Inventories;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import com.slamtheham.ultracore.Main;

public class AdminMenu implements Listener {

	private Plugin plugin = Main.getPlugin(Main.class);
	
	@SuppressWarnings("unused")
	public void newInventory(Player player) {
		Inventory adminmenu = plugin.getServer().createInventory(null, 54, ChatColor.DARK_GRAY + "Admin Menu - Page 1");
		
		List<String> lore1 = new ArrayList<String>();
		List<String> lore2 = new ArrayList<String>();
		List<String> lore3 = new ArrayList<String>();
		List<String> lore4 = new ArrayList<String>();
		List<String> lore5 = new ArrayList<String>();
		List<String> lore6 = new ArrayList<String>();
		List<String> lore7 = new ArrayList<String>();
		List<String> lore8 = new ArrayList<String>();
		List<String> lore9 = new ArrayList<String>();
		List<String> togglelore1 = new ArrayList<String>();
		List<String> togglelore2 = new ArrayList<String>();
		List<String> togglelore3 = new ArrayList<String>();
		List<String> togglelore4 = new ArrayList<String>();
		List<String> togglelore5 = new ArrayList<String>();
		List<String> togglelore6 = new ArrayList<String>();
		List<String> togglelore7 = new ArrayList<String>();
		List<String> togglelore8 = new ArrayList<String>();
		List<String> togglelore9 = new ArrayList<String>();
		ItemStack empty = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15);
		ItemMeta emptyMeta = empty.getItemMeta();
		emptyMeta.setDisplayName(" ");
		empty.setItemMeta(emptyMeta);
		
		
		ItemStack toggleoffitem1 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 14);
		ItemStack toggleoffitem2 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 14);
		ItemStack toggleoffitem3 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 14);
		ItemStack toggleoffitem4 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 14);
		ItemStack toggleoffitem5 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 14);
		ItemStack toggleoffitem6 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 14);
		ItemStack toggleoffitem7 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 14);
		ItemStack toggleoffitem8 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 14);
		ItemStack toggleoffitem9 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 14);
		ItemStack toggleonitem1 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 5);
		ItemStack toggleonitem2 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 5);
		ItemStack toggleonitem3 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 5);
		ItemStack toggleonitem4 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 5);
		ItemStack toggleonitem5 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 5);
		ItemStack toggleonitem6 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 5);
		ItemStack toggleonitem7 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 5);
		ItemStack toggleonitem8 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 5);
		ItemStack toggleonitem9 = new ItemStack(Material.STAINED_CLAY, 1, (byte) 5);
		ItemStack close = new ItemStack(Material.BARRIER);
		ItemStack nextpage = new ItemStack(Material.SIGN);
		ItemStack previouspage = new ItemStack(Material.SIGN);
		
		ItemStack timefreeze1 = new ItemStack(Material.WATCH);
		ItemStack noweather1 = new ItemStack(Material.WATER_BUCKET);
		ItemStack nopvp1 = new ItemStack(Material.DIAMOND_SWORD);
		ItemStack joinleave1 = new ItemStack(Material.BOOK);
		ItemStack spawntp1 = new ItemStack(Material.ENDER_PEARL);
		ItemStack motd1 = new ItemStack(Material.ENCHANTED_BOOK);
		ItemStack chatformat1 = new ItemStack(Material.BOOK_AND_QUILL);
		ItemStack tablist1 = new ItemStack(Material.BEACON);
		ItemStack firstjoin1 = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta time1Meta = timefreeze1.getItemMeta();
		ItemMeta now1Meta = noweather1.getItemMeta();
		ItemMeta nop1Meta = nopvp1.getItemMeta();
		ItemMeta jl1Meta = joinleave1.getItemMeta();
		ItemMeta stp1Meta = spawntp1.getItemMeta();
		ItemMeta motd1Meta = motd1.getItemMeta();
		ItemMeta cf1Meta = chatformat1.getItemMeta();
		ItemMeta tab1Meta = tablist1.getItemMeta();
		ItemMeta fj1Meta = firstjoin1.getItemMeta();
		ItemMeta npMeta = nextpage.getItemMeta();
		ItemMeta closeMeta = close.getItemMeta();
		time1Meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Freeze Time" + ChatColor.RED + "" + ChatColor.BOLD + " DISABLED");
		now1Meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Disable/Enable Weather" + ChatColor.RED + "" + ChatColor.BOLD + " DISABLED");
		nop1Meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Disable/Enable PvP" + ChatColor.RED + "" + ChatColor.BOLD + " DISABLED");
		jl1Meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Join & Leave Messages" + ChatColor.RED + "" + ChatColor.BOLD + " DISABLED");
		stp1Meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Spawn Teleport" + ChatColor.RED + "" + ChatColor.BOLD + " DISABLED");
		motd1Meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Message Of The Day" + ChatColor.RED + "" + ChatColor.BOLD + " DISABLED");
		cf1Meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Chat Format" + ChatColor.RED + "" + ChatColor.BOLD + " DISABLED");
		tab1Meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Custom Tab List" + ChatColor.RED + "" + ChatColor.BOLD + " DISABLED");
		fj1Meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "First Join Kit" + ChatColor.RED + "" + ChatColor.BOLD + " DISABLED");
		closeMeta.setDisplayName(ChatColor.RED + "Close the menu.");
	    npMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Next Page");
		lore1.add(ChatColor.YELLOW + "Freeze ingame time to " + ChatColor.GREEN + "12:00");
		lore1.add(ChatColor.AQUA + "Click the item below to toggle!");
		lore1.add(" ");
		lore1.add(ChatColor.GREEN + "" + ChatColor.BOLD + "ENABLE " + ChatColor.YELLOW + "/" + ChatColor.RED + "" + ChatColor.BOLD + " DISABLE");
		lore2.add(ChatColor.YELLOW + "Set ingame weather to clear");
		lore2.add(ChatColor.YELLOW + "perminently.");
		lore2.add(ChatColor.AQUA + "Click the item below to toggle!");
		lore2.add(" ");
		lore2.add(ChatColor.GREEN + "" + ChatColor.BOLD + "ENABLE " + ChatColor.YELLOW + "/" + ChatColor.RED + "" + ChatColor.BOLD + " DISABLE");
		lore3.add(ChatColor.YELLOW + "Toggle ingame Player vs Player");
		lore2.add(ChatColor.YELLOW + "mechanic.");
		lore3.add(ChatColor.AQUA + "Click the item below to toggle!");
		lore3.add(" ");
		lore3.add(ChatColor.GREEN + "" + ChatColor.BOLD + "ENABLE " + ChatColor.YELLOW + "/" + ChatColor.RED + "" + ChatColor.BOLD + " DISABLE");
		lore4.add(ChatColor.YELLOW + "Enable/Disable custom join/leave");
		lore4.add(ChatColor.YELLOW + "messages.");
		lore4.add(ChatColor.DARK_GRAY + "TIP: You can edit these messages");
		lore4.add(ChatColor.DARK_GRAY + "with messages.yml.");
		lore4.add(ChatColor.AQUA + "Click the item below to toggle!");
		lore4.add(" ");
		lore4.add(ChatColor.GREEN + "" + ChatColor.BOLD + "ENABLE " + ChatColor.YELLOW + "/" + ChatColor.RED + "" + ChatColor.BOLD + " DISABLE");
		lore5.add(ChatColor.YELLOW + "Enable/Disable teleport to spawn");
		lore5.add(ChatColor.YELLOW + "when you join the server.");
		lore5.add(ChatColor.DARK_GRAY + "TIP: You can setspawn with /setspawn");
		lore5.add(ChatColor.AQUA + "Click the item below to toggle!");
		lore5.add(" ");
		lore5.add(ChatColor.GREEN + "" + ChatColor.BOLD + "ENABLE " + ChatColor.YELLOW + "/" + ChatColor.RED + "" + ChatColor.BOLD + " DISABLE");
		time1Meta.setLore(lore1);
		now1Meta.setLore(lore2);
		nop1Meta.setLore(lore3);
		jl1Meta.setLore(lore4);
		stp1Meta.setLore(lore5);
		timefreeze1.setItemMeta(time1Meta);
		noweather1.setItemMeta(now1Meta);
		nopvp1.setItemMeta(nop1Meta);
		joinleave1.setItemMeta(jl1Meta);
		spawntp1.setItemMeta(stp1Meta);
		close.setItemMeta(closeMeta);
		nextpage.setItemMeta(npMeta);
		
		adminmenu.setItem(0, empty);
		adminmenu.setItem(1, empty);
		adminmenu.setItem(2, empty);
		adminmenu.setItem(3, empty);
		adminmenu.setItem(4, empty);
		adminmenu.setItem(5, empty);
		adminmenu.setItem(6, empty);
		adminmenu.setItem(7, empty);
		adminmenu.setItem(8, empty);
		adminmenu.setItem(45, empty);
		adminmenu.setItem(46, empty);
		adminmenu.setItem(47, empty);
		adminmenu.setItem(48, empty);
		adminmenu.setItem(49, close);
		adminmenu.setItem(50, empty);
		adminmenu.setItem(51, empty);
		adminmenu.setItem(52, empty);
		adminmenu.setItem(53, nextpage);
		adminmenu.setItem(9, timefreeze1);
		adminmenu.setItem(11, noweather1);
		adminmenu.setItem(13, nopvp1);
		adminmenu.setItem(15, joinleave1);
		adminmenu.setItem(17, spawntp1);
		adminmenu.setItem(28, motd1);
		adminmenu.setItem(30, chatformat1);
		adminmenu.setItem(32, tablist1);
		adminmenu.setItem(34, firstjoin1);
		adminmenu.setItem(18, toggleoffitem1);
		adminmenu.setItem(20, toggleoffitem2);
		adminmenu.setItem(22, toggleoffitem3);
		adminmenu.setItem(24, toggleoffitem4);
		adminmenu.setItem(26, toggleoffitem5);
		adminmenu.setItem(37, toggleoffitem6);
		adminmenu.setItem(39, toggleoffitem7);
		adminmenu.setItem(41, toggleoffitem8);
		adminmenu.setItem(43, toggleoffitem9);
				
		player.openInventory(adminmenu);

	}
	
}
