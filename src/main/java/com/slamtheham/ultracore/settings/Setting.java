package com.slamtheham.ultracore.settings;

import com.slamtheham.ultracore.menu.ClickHandler;
import com.slamtheham.ultracore.settings.handlers.SettingElementHandler;
import com.slamtheham.ultracore.settings.handlers.SettingItemHandler;
import me.blackness.black.Element;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.Optional;

public class Setting implements Comparable<Setting> {

    private final String id;
    private final Listener listener;
    private final ClickHandler clickHandler;
    private final SettingElementHandler settingElementHandler;
    private final SettingItemHandler settingItemHandler;

    public Setting(String id, Listener listener, ClickHandler clickHandler, SettingElementHandler settingElementHandler, SettingItemHandler settingItemHandler) {
        this.id = id;
        this.listener = listener;
        this.clickHandler = clickHandler;
        this.settingElementHandler = settingElementHandler;
        this.settingItemHandler = settingItemHandler;
    }

    public String getId() {
        return id;
    }

    public Optional<Listener> getListener() {
        return Optional.ofNullable(listener);
    }

    public ClickHandler getClickHandler() {
        return clickHandler;
    }

    public SettingElementHandler getSettingElementHandler() {
        return settingElementHandler;
    }

    public SettingItemHandler getSettingItemHandler() {
        return settingItemHandler;
    }

    public Element toElement(Player player) {
        return settingElementHandler.get(player, this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Setting)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Setting [id=" + id + ", listener=" + listener + ", clickHandler=" + clickHandler + ", elementHandler=" + settingElementHandler + ", itemHandler=" + settingItemHandler + "]";
    }

    @Override
    public int compareTo(Setting setting) {
        return getId().compareTo(setting.getId());
    }

}