package com.slamtheham.ultracore.settings.handlers;

import com.slamtheham.ultracore.settings.Setting;
import me.blackness.black.Element;
import org.bukkit.entity.Player;

public interface SettingElementHandler {

    Element get(Player player, Setting setting);

}
