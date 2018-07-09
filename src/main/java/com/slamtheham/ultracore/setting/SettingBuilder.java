package com.slamtheham.ultracore.setting;

import com.slamtheham.ultracore.setting.handlers.SettingClickHandler;
import com.slamtheham.ultracore.setting.handlers.SettingElementHandler;
import com.slamtheham.ultracore.setting.handlers.SettingItemHandler;
import com.slamtheham.ultracore.setting.handlers.SettingLoadHandler;
import org.bukkit.event.Listener;

public class SettingBuilder {

    private String id;
    private Listener listener;
    private SettingLoadHandler loadHandler;
    private SettingClickHandler clickHandler;
    private SettingElementHandler elementHandler;
    private SettingItemHandler itemHandler;

    public SettingBuilder id(String id) {
        this.id = id;
        return this;
    }

    public SettingBuilder listener(Listener listener) {
        this.listener = listener;
        return this;
    }

    public SettingBuilder load(SettingLoadHandler loadHandler) {
        this.loadHandler = loadHandler;
        return this;
    }

    public SettingBuilder click(SettingClickHandler clickHandler) {
        this.clickHandler = clickHandler;
        return this;
    }

    public SettingBuilder element(SettingElementHandler elementHandler) {
        this.elementHandler = elementHandler;
        return this;
    }

    public SettingBuilder item(SettingItemHandler itemHandler) {
        this.itemHandler = itemHandler;
        return this;
    }

    public Setting build() {
        if (id == null || loadHandler == null ||  clickHandler == null || elementHandler == null || itemHandler == null) return null;
        return new Setting(id, listener, loadHandler, clickHandler, elementHandler, itemHandler);
    }

}
