package com.slamtheham.ultracore.setting;

import com.slamtheham.ultracore.setting.handlers.SettingClickHandler;
import com.slamtheham.ultracore.setting.handlers.SettingElementHandler;
import com.slamtheham.ultracore.setting.handlers.SettingItemHandler;
import com.slamtheham.ultracore.setting.handlers.SettingLoadHandler;
import me.blackness.black.Element;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.Optional;

public class Setting implements Comparable<Setting> {

    private final String id;
    private final Listener listener;
    private final SettingLoadHandler loadHandler;
    private final SettingClickHandler clickHandler;
    private final SettingElementHandler elementHandler;
    private final SettingItemHandler itemHandler;

    public Setting(String id, Listener listener, SettingLoadHandler loadHandler, SettingClickHandler clickHandler, SettingElementHandler elementHandler, SettingItemHandler itemHandler) {
        this.id = id;
        this.listener = listener;
        this.loadHandler = loadHandler;
        this.clickHandler = clickHandler;
        this.elementHandler = elementHandler;
        this.itemHandler = itemHandler;
    }

    public String getId() {
        return id;
    }

    public Optional<Listener> getListener() {
        return Optional.ofNullable(listener);
    }

    public SettingLoadHandler getLoadHandler() {
        return loadHandler;
    }

    public SettingClickHandler getClickHandler() {
        return clickHandler;
    }

    public SettingElementHandler getElementHandler() {
        return elementHandler;
    }

    public SettingItemHandler getItemHandler() {
        return itemHandler;
    }

    public Element toElement(Player player) {
        return elementHandler.get(player, this);
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
        return "Setting [id=" + id + ", listener=" + listener + ", loadHandler=" + loadHandler + ", clickHandler=" + clickHandler + ", elementHandler=" + elementHandler + ", itemHandler=" + itemHandler + "]";
    }

    @Override
    public int compareTo(Setting setting) {
        return getId().compareTo(setting.getId());
    }

}
