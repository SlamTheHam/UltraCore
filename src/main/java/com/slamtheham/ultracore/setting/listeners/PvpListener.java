package com.slamtheham.ultracore.setting.listeners;

import com.slamtheham.ultracore.Main;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PvpListener implements Listener {

    private Main plugin;

    public PvpListener() {
        this.plugin = Main.getInstance();
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        Entity damager = event.getDamager();
        Player hitter = null;
        Projectile arrow = null;
        if (!(entity instanceof Player)) return;
        final Player receiver = (Player) entity;
        if (damager instanceof Player) {
            hitter = (Player) damager;
        } else if (damager instanceof Projectile) {
            if (((Projectile) damager).getShooter() instanceof Player) {
                arrow = (Projectile) damager;
            }
        }
        if (arrow != null || hitter != null) {
            event.setCancelled(true);
        }
    }
}
