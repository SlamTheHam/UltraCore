package com.slamtheham.ultracore.settings;

import com.slamtheham.ultracore.menu.ClickHandler;
import com.slamtheham.ultracore.utils.ItemManager;
import me.blackness.black.Element;
import me.blackness.black.element.BasicElement;
import me.blackness.black.target.BasicTarget;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.Optional;

import static com.slamtheham.ultracore.utils.StringUtils.cc;

public class Setting implements Comparable<Setting> {

    private final String id;
    private final String name;
    private final Material icon;
    private final Listener listener;
    private final ClickHandler clickHandler;

    public Setting(String id, String name, Material icon, Listener listener, ClickHandler clickHandler) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.listener = listener;
        this.clickHandler = clickHandler;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Material getIcon() {
        return icon;
    }

    public Optional<Listener> getListener() {
        return Optional.ofNullable(listener);
    }

    public ClickHandler getClickHandler() {
        return clickHandler;
    }

    public Element toElement(Player player) {
        return new BasicElement(new ItemManager.ItemCreator(icon).setName(cc(name)).build(), new BasicTarget(clickHandler::run));
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
        return "Setting [id=" + id + ", icon=" + icon + ", listener=" + listener + ", clickHandler=" + clickHandler + "]";
    }

    @Override
    public int compareTo(Setting setting) {
        return getId().compareTo(setting.getId());
    }

}
