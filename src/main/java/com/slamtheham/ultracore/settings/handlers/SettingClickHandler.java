package com.slamtheham.ultracore.settings.handlers;

import com.slamtheham.ultracore.menu.ClickHandler;
import com.slamtheham.ultracore.settings.Setting;
import org.bukkit.entity.Player;

public interface SettingClickHandler {

    ClickHandler get(Player player, Setting setting);

}
