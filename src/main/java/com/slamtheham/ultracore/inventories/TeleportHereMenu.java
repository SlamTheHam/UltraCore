package com.slamtheham.ultracore.inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class TeleportHereMenu implements Listener {

    public static void newInventory(CommandSender sender) {
        Inventory tpheremenu = Bukkit.createInventory(null, 54, ChatColor.DARK_GRAY + "Teleport Here Menu - Page 1");

        ItemStack empty = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15);
        ItemMeta emptyMeta = empty.getItemMeta();
        emptyMeta.setDisplayName(" ");
        empty.setItemMeta(emptyMeta);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemStack nextpage = new ItemStack(Material.SIGN);
        ItemStack previouspage = new ItemStack(Material.SIGN);
        ItemMeta npMeta = nextpage.getItemMeta();
        ItemMeta ppMeta = previouspage.getItemMeta();
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close the menu.");
        npMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Next Page");
        ppMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Previous Page");

        for (int i = 0; i < Bukkit.getOnlinePlayers().size(); i++) {
            Player targetPlayer = (Player) Bukkit.getOnlinePlayers().toArray()[i];
            ItemStack skulls = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
            SkullMeta skullsMeta = (SkullMeta) skulls.getItemMeta();
            skullsMeta.setDisplayName(ChatColor.YELLOW + "Teleport " + ChatColor.GREEN + targetPlayer.getName() + ChatColor.YELLOW + " to you.");
            skullsMeta.setOwner(targetPlayer.getName());
            skulls.setItemMeta(skullsMeta);

            int beginningSlot = 9;
            tpheremenu.setItem(i + beginningSlot, skulls);
        }

        tpheremenu.setItem(0, empty);
        tpheremenu.setItem(1, empty);
        tpheremenu.setItem(2, empty);
        tpheremenu.setItem(3, empty);
        tpheremenu.setItem(4, empty);
        tpheremenu.setItem(5, empty);
        tpheremenu.setItem(6, empty);
        tpheremenu.setItem(7, empty);
        tpheremenu.setItem(8, empty);
        tpheremenu.setItem(45, empty);
        tpheremenu.setItem(46, empty);
        tpheremenu.setItem(47, empty);
        tpheremenu.setItem(48, empty);
        tpheremenu.setItem(49, close);
        tpheremenu.setItem(50, empty);
        tpheremenu.setItem(51, empty);
        tpheremenu.setItem(52, empty);
        tpheremenu.setItem(53, nextpage);

        ((HumanEntity) sender).openInventory(tpheremenu);
    }
}

