package com.slamtheham.ultracore.settings;

import com.slamtheham.ultracore.menu.ClickHandler;
import org.bukkit.Material;
import org.bukkit.event.Listener;

public class SettingBuilder {

    private String id;
    private String name;
    private Material icon = Material.PAPER;
    private Listener listener;
    private ClickHandler clickHandler;

    public SettingBuilder id(String id) {
        this.id = id;
        return this;
    }

    public SettingBuilder name(String name) {
        this.name = name;
        return this;
    }

    public SettingBuilder icon(Material icon) {
        this.icon = icon;
        return this;
    }

    public SettingBuilder listener(Listener listener) {
        this.listener = listener;
        return this;
    }

    public SettingBuilder click(ClickHandler clickHandler) {
        this.clickHandler = clickHandler;
        return this;
    }

    public Setting build() {
        if (id == null) return null;
        if (name == null) name = id;
        return new Setting(id, name, icon, listener, clickHandler);
    }

}
