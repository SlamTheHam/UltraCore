package com.slamtheham.ultracore;

import com.slamtheham.ultracore.Inventories.AdminMenu;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class Events implements Listener {

    private Plugin plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (plugin.getConfig().getString("toggle.nopvp").equals(true)) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onWeatherChange(WeatherChangeEvent event) {

        if (plugin.getConfig().getString("toggle.noweather").equals(true)) {
            boolean rain = event.toWeatherState();
            if (rain)
                event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onThunderChange(ThunderChangeEvent event) {

        if (plugin.getConfig().getString("toggle.noweather").equals(true)) {
            boolean storm = event.toThunderState();
            if (storm)
                event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack is = event.getCurrentItem();
        AdminMenu adminmenu = new AdminMenu();
        if ((event.getCurrentItem() != null) && (event.getCurrentItem().getType() != Material.AIR)) {
            if (event.getInventory().getName().equals(ChatColor.DARK_GRAY + "Admin Menu - Page 1")) {
                event.setCancelled(true);
                if ((event.getCurrentItem().getType() == Material.INK_SACK) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Toggled Freeze Time:" + ChatColor.RED + "" + ChatColor.BOLD + " OFF"))) {
                    player.closeInventory();
                    player.sendMessage(ChatColor.YELLOW + "You've toggled " + ChatColor.AQUA + "" + ChatColor.BOLD + "Freeze Time " + ChatColor.GRAY + "- " + ChatColor.GREEN + "" + ChatColor.BOLD + "ON");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0F, 2.0F);
                    plugin.getConfig().set("toggle.freezetime", true);
                    plugin.saveConfig();
                    adminmenu.newInventory(player);

                }

                if ((event.getCurrentItem().getType() == Material.INK_SACK) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Toggled Freeze Time:" + ChatColor.GREEN + "" + ChatColor.BOLD + " ON"))) {
                    player.closeInventory();
                    player.sendMessage(ChatColor.YELLOW + "You've toggled " + ChatColor.AQUA + "" + ChatColor.BOLD + "Freeze Time " + ChatColor.GRAY + "- " + ChatColor.RED + "" + ChatColor.BOLD + "OFF");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0F, 0.1F);
                    plugin.getConfig().set("toggle.freezetime", false);
                    plugin.saveConfig();
                    adminmenu.newInventory(player);

                }

                if ((event.getCurrentItem().getType() == Material.BARRIER) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.RED + "Close the menu."))) {
                    player.closeInventory();
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_PLING, 1.0F, 0.1F);

                }

                if ((event.getCurrentItem().getType() == Material.INK_SACK) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Toggled No Weather:" + ChatColor.GREEN + "" + ChatColor.BOLD + " ON"))) {
                    player.closeInventory();
                    player.sendMessage(ChatColor.YELLOW + "You've toggled " + ChatColor.AQUA + "" + ChatColor.BOLD + "No Weather " + ChatColor.GRAY + "- " + ChatColor.RED + "" + ChatColor.BOLD + "OFF");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0F, 0.1F);
                    plugin.getConfig().set("toggle.noweather", false);
                    plugin.saveConfig();
                    adminmenu.newInventory(player);

                }

                if ((event.getCurrentItem().getType() == Material.INK_SACK) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Toggled No Weather:" + ChatColor.RED + "" + ChatColor.BOLD + " OFF"))) {
                    player.closeInventory();
                    player.sendMessage(ChatColor.YELLOW + "You've toggled " + ChatColor.AQUA + "" + ChatColor.BOLD + "No Weather " + ChatColor.GRAY + "- " + ChatColor.GREEN + "" + ChatColor.BOLD + "ON");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0F, 0.1F);
                    plugin.getConfig().set("toggle.noweather", true);
                    plugin.saveConfig();
                    adminmenu.newInventory(player);
                }

                if ((event.getCurrentItem().getType() == Material.INK_SACK) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Toggled No Pvp:" + ChatColor.GREEN + "" + ChatColor.BOLD + " ON"))) {
                    player.closeInventory();
                    player.sendMessage(ChatColor.YELLOW + "You've toggled " + ChatColor.AQUA + "" + ChatColor.BOLD + "No Pvp " + ChatColor.GRAY + "- " + ChatColor.RED + "" + ChatColor.BOLD + "OFF");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0F, 0.1F);
                    plugin.getConfig().set("toggle.nopvp", false);
                    plugin.saveConfig();
                    adminmenu.newInventory(player);

                }

                if ((event.getCurrentItem().getType() == Material.INK_SACK) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Toggled No Pvp:" + ChatColor.RED + "" + ChatColor.BOLD + " OFF"))) {
                    player.closeInventory();
                    player.sendMessage(ChatColor.YELLOW + "You've toggled " + ChatColor.AQUA + "" + ChatColor.BOLD + "No Pvp " + ChatColor.GRAY + "- " + ChatColor.GREEN + "" + ChatColor.BOLD + "ON");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0F, 0.1F);
                    plugin.getConfig().set("toggle.nopvp", true);
                    plugin.saveConfig();
                    adminmenu.newInventory(player);

                }

                if ((event.getCurrentItem().getType() == Material.INK_SACK) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Toggled Join & Leave Message:" + ChatColor.GREEN + "" + ChatColor.BOLD + " ON"))) {
                    player.closeInventory();
                    player.sendMessage(ChatColor.YELLOW + "You've toggled " + ChatColor.AQUA + "" + ChatColor.BOLD + "Join & Leave Messages " + ChatColor.GRAY + "- " + ChatColor.RED + "" + ChatColor.BOLD + "OFF");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0F, 0.1F);
                    plugin.getConfig().set("toggle.joinandleave", false);
                    plugin.saveConfig();
                    adminmenu.newInventory(player);

                }

                if ((event.getCurrentItem().getType() == Material.INK_SACK) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Toggled Join & Leave Message:" + ChatColor.RED + "" + ChatColor.BOLD + " OFF"))) {
                    player.closeInventory();
                    player.sendMessage(ChatColor.YELLOW + "You've toggled " + ChatColor.AQUA + "" + ChatColor.BOLD + "Join & Leave Messages " + ChatColor.GRAY + "- " + ChatColor.GREEN + "" + ChatColor.BOLD + "ON");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0F, 0.1F);
                    plugin.getConfig().set("toggle.joinandleave", true);
                    plugin.saveConfig();
                    adminmenu.newInventory(player);
                }

                if ((event.getCurrentItem().getType() == Material.INK_SACK) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Toggled Spawn on Join:" + ChatColor.GREEN + "" + ChatColor.BOLD + " ON"))) {
                    player.closeInventory();
                    player.sendMessage(ChatColor.YELLOW + "You've toggled " + ChatColor.AQUA + "" + ChatColor.BOLD + "Spawn on Join " + ChatColor.GRAY + "- " + ChatColor.RED + "" + ChatColor.BOLD + "OFF");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0F, 0.1F);
                    plugin.getConfig().set("toggle.spawnjoin", false);
                    plugin.saveConfig();
                    adminmenu.newInventory(player);

                }

                if ((event.getCurrentItem().getType() == Material.INK_SACK) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Toggled Spawn on Join:" + ChatColor.RED + "" + ChatColor.BOLD + " OFF"))) {
                    player.closeInventory();
                    player.sendMessage(ChatColor.YELLOW + "You've toggled " + ChatColor.AQUA + "" + ChatColor.BOLD + "Spawn on Join " + ChatColor.GRAY + "- " + ChatColor.GREEN + "" + ChatColor.BOLD + "ON");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0F, 0.1F);
                    plugin.getConfig().set("toggle.spawnjoin", true);
                    plugin.saveConfig();
                    adminmenu.newInventory(player);

                }

                if ((event.getCurrentItem().getType() == Material.INK_SACK) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Toggled MOTD:" + ChatColor.GREEN + "" + ChatColor.BOLD + " ON"))) {
                    player.closeInventory();
                    player.sendMessage(ChatColor.YELLOW + "You've toggled " + ChatColor.AQUA + "" + ChatColor.BOLD + "MOTD " + ChatColor.GRAY + "- " + ChatColor.RED + "" + ChatColor.BOLD + "OFF");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0F, 0.1F);
                    plugin.getConfig().set("toggle.motd", false);
                    plugin.saveConfig();
                    adminmenu.newInventory(player);

                }

                if ((event.getCurrentItem().getType() == Material.INK_SACK) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Toggled MOTD:" + ChatColor.RED + "" + ChatColor.BOLD + " OFF"))) {
                    player.closeInventory();
                    player.sendMessage(ChatColor.YELLOW + "You've toggled " + ChatColor.AQUA + "" + ChatColor.BOLD + "MOTD " + ChatColor.GRAY + "- " + ChatColor.GREEN + "" + ChatColor.BOLD + "ON");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0F, 0.1F);
                    plugin.getConfig().set("toggle.motd", true);
                    plugin.saveConfig();
                    adminmenu.newInventory(player);

                }

                if ((event.getCurrentItem().getType() == Material.INK_SACK) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Toggled Chat Format:" + ChatColor.GREEN + "" + ChatColor.BOLD + " ON"))) {
                    player.closeInventory();
                    player.sendMessage(ChatColor.YELLOW + "You've toggled " + ChatColor.AQUA + "" + ChatColor.BOLD + "Freeze Weather " + ChatColor.GRAY + "- " + ChatColor.RED + "" + ChatColor.BOLD + "OFF");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0F, 0.1F);
                    plugin.getConfig().set("toggle.chat", false);
                    plugin.saveConfig();
                    adminmenu.newInventory(player);

                }

                if ((event.getCurrentItem().getType() == Material.INK_SACK) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Toggled Chat Format:" + ChatColor.RED + "" + ChatColor.BOLD + " OFF"))) {
                    player.closeInventory();
                    player.sendMessage(ChatColor.GREEN + "You've toggled " + ChatColor.AQUA + "" + ChatColor.BOLD + "Freeze Weather " + ChatColor.GRAY + "- " + ChatColor.GREEN + "" + ChatColor.BOLD + "ON");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0F, 0.1F);
                    plugin.getConfig().set("toggle.chat", true);
                    plugin.saveConfig();
                    adminmenu.newInventory(player);

                }

                if ((event.getCurrentItem().getType() == Material.INK_SACK) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Toggled Custom Tablist:" + ChatColor.GREEN + "" + ChatColor.BOLD + " ON"))) {
                    player.closeInventory();
                    player.sendMessage(ChatColor.GREEN + "You've toggled " + ChatColor.AQUA + "" + ChatColor.BOLD + "Freeze Weather " + ChatColor.GRAY + "- " + ChatColor.RED + "" + ChatColor.BOLD + "OFF");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0F, 0.1F);
                    plugin.getConfig().set("toggle.tablist", false);
                    plugin.saveConfig();
                    adminmenu.newInventory(player);

                }

                if ((event.getCurrentItem().getType() == Material.INK_SACK) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Toggled Custom Tablist:" + ChatColor.RED + "" + ChatColor.BOLD + " OFF"))) {
                    player.closeInventory();
                    player.sendMessage(ChatColor.GREEN + "You've toggled " + ChatColor.AQUA + "" + ChatColor.BOLD + "Freeze Weather " + ChatColor.GRAY + "- " + ChatColor.GREEN + "" + ChatColor.BOLD + "ON");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0F, 0.1F);
                    plugin.getConfig().set("toggle.tablist", true);
                    plugin.saveConfig();
                    adminmenu.newInventory(player);

                }

                if ((event.getCurrentItem().getType() == Material.INK_SACK) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Toggled First Join Kit:" + ChatColor.GREEN + "" + ChatColor.BOLD + " ON"))) {
                    player.closeInventory();
                    player.sendMessage(ChatColor.GREEN + "You've toggled " + ChatColor.AQUA + "" + ChatColor.BOLD + "Freeze Weather " + ChatColor.GRAY + "- " + ChatColor.RED + "" + ChatColor.BOLD + "OFF");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0F, 0.1F);
                    plugin.getConfig().set("toggle.firstjoinkit", false);
                    plugin.saveConfig();
                    adminmenu.newInventory(player);

                }

                if ((event.getCurrentItem().getType() == Material.INK_SACK) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Toggled First Join Kit:" + ChatColor.RED + "" + ChatColor.BOLD + " OFF"))) {
                    player.closeInventory();
                    player.sendMessage(ChatColor.GREEN + "You've toggled " + ChatColor.AQUA + "" + ChatColor.BOLD + "Freeze Weather " + ChatColor.GRAY + "- " + ChatColor.GREEN + "" + ChatColor.BOLD + "ON");
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 1.0F, 0.1F);
                    plugin.getConfig().set("toggle.firstjoinkit", true);
                    plugin.saveConfig();
                    adminmenu.newInventory(player);

                }
            }
        }
    }

    @EventHandler
    public void onInventoryClick1(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack is = event.getCurrentItem();
        if ((event.getCurrentItem() != null) && (event.getCurrentItem().getType() != Material.AIR)) {
            if (event.getInventory().getName().equals(ChatColor.DARK_GRAY + "Teleport Menu - Page 1")) {
                event.setCancelled(true);
                for (int i = 0; i < Bukkit.getOnlinePlayers().size(); i++) {
                    Player targetPlayer = (Player) Bukkit.getOnlinePlayers().toArray()[i];
                    Location location = player.getLocation();
                    if ((event.getCurrentItem().getType() == Material.SKULL_ITEM) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Teleport to " + ChatColor.GREEN + targetPlayer.getName()))) {
                        player.closeInventory();
                        player.teleport(targetPlayer);
                        player.sendMessage(ChatColor.YELLOW + "You've teleported to " + ChatColor.GREEN + targetPlayer.getDisplayName() + ChatColor.YELLOW + "!");
                        player.playSound(location, Sound.ENTITY_ENDERMEN_TELEPORT, 100, 1);
                        player.playEffect(location, Effect.ENDER_SIGNAL, 1);
                        targetPlayer.playEffect(location, Effect.ENDER_SIGNAL, 1);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onInventoryClick2(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack is = event.getCurrentItem();
        if ((event.getCurrentItem() != null) && (event.getCurrentItem().getType() != Material.AIR)) {
            if (event.getInventory().getName().equals(ChatColor.DARK_GRAY + "Teleport Here Menu - Page 1")) {
                event.setCancelled(true);
                for (int i = 0; i < Bukkit.getOnlinePlayers().size(); i++) {
                    Player targetPlayer = (Player) Bukkit.getOnlinePlayers().toArray()[i];
                    Location location = player.getLocation();
                    if ((event.getCurrentItem().getType() == Material.SKULL_ITEM) && (is.hasItemMeta()) && (is.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Teleport " + ChatColor.GREEN + targetPlayer.getName() + ChatColor.YELLOW + " to you."))) {
                        player.closeInventory();
                        targetPlayer.teleport(player);
                        player.sendMessage(ChatColor.YELLOW + "You've teleported " + ChatColor.GREEN + targetPlayer.getDisplayName() + ChatColor.YELLOW + " to you!");
                        player.playSound(location, Sound.ENTITY_ENDERMEN_TELEPORT, 100, 1);
                        player.playEffect(location, Effect.ENDER_SIGNAL, 1);
                        targetPlayer.playEffect(location, Effect.ENDER_SIGNAL, 1);
                    }
                }
            }
        }
    }
}    
