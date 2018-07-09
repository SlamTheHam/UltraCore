package com.slamtheham.ultracore.setting.handlers;

import com.slamtheham.ultracore.menu.ClickHandler;
import com.slamtheham.ultracore.setting.Setting;
import org.bukkit.entity.Player;

public interface SettingClickHandler {

    ClickHandler get(Player player, Setting setting);

}
