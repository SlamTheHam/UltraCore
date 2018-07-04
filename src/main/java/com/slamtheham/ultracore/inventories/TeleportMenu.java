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

public class TeleportMenu implements Listener {

    public static void newInventory(CommandSender sender) {
        Inventory tpmenu = Bukkit.createInventory(null, 54, ChatColor.DARK_GRAY + "Teleport Menu - Page 1");

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
            skullsMeta.setDisplayName(ChatColor.YELLOW + "Teleport to " + ChatColor.GREEN + targetPlayer.getName());
            skullsMeta.setOwner(targetPlayer.getName());
            skulls.setItemMeta(skullsMeta);

            int beginningSlot = 9;
            tpmenu.setItem(i + beginningSlot, skulls);
        }

        tpmenu.setItem(0, empty);
        tpmenu.setItem(1, empty);
        tpmenu.setItem(2, empty);
        tpmenu.setItem(3, empty);
        tpmenu.setItem(4, empty);
        tpmenu.setItem(5, empty);
        tpmenu.setItem(6, empty);
        tpmenu.setItem(7, empty);
        tpmenu.setItem(8, empty);
        tpmenu.setItem(45, empty);
        tpmenu.setItem(46, empty);
        tpmenu.setItem(47, empty);
        tpmenu.setItem(48, empty);
        tpmenu.setItem(49, close);
        tpmenu.setItem(50, empty);
        tpmenu.setItem(51, empty);
        tpmenu.setItem(52, empty);
        tpmenu.setItem(53, nextpage);

        ((HumanEntity) sender).openInventory(tpmenu);
    }
}
