package com.slamtheham.ultracore.setting.handlers;

import com.slamtheham.ultracore.setting.Setting;
import me.blackness.black.Element;
import org.bukkit.entity.Player;

public interface SettingElementHandler {

    Element get(Player player, Setting setting);

}
