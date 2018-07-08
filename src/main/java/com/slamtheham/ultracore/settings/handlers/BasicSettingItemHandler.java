package com.slamtheham.ultracore.settings.handlers;

import com.slamtheham.ultracore.settings.Setting;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BasicSettingItemHandler implements SettingItemHandler {

    private ItemStack item;

    public BasicSettingItemHandler(ItemStack item) {
        this.item = item;
    }

    @Override
    public ItemStack get(Player player, Setting setting) {
        return item;
    }
}
