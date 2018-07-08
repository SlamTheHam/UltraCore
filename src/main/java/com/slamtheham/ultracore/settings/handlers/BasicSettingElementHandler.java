package com.slamtheham.ultracore.settings.handlers;

import com.slamtheham.ultracore.settings.Setting;
import me.blackness.black.Element;
import me.blackness.black.element.BasicElement;
import org.bukkit.entity.Player;

public class BasicSettingElementHandler implements SettingElementHandler {

    @Override
    public Element get(Player player, Setting setting) {
        return new BasicElement(setting.getSettingItemHandler().get(player, setting),
                setting.getSettingClickHandler().get(player, setting).get());
    }
}
