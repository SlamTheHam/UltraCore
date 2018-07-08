package com.slamtheham.ultracore.settings.handlers;

import com.slamtheham.ultracore.settings.Setting;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface SettingItemHandler {

    ItemStack get(Player player, Setting setting);

}
