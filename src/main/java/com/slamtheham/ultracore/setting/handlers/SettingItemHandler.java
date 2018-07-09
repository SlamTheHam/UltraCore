package com.slamtheham.ultracore.setting.handlers;

import com.slamtheham.ultracore.setting.Setting;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface SettingItemHandler {

    ItemStack get(Player player, Setting setting);

}
