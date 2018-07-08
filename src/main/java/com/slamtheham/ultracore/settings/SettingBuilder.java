package com.slamtheham.ultracore.settings;

import com.slamtheham.ultracore.menu.ClickHandler;
import com.slamtheham.ultracore.settings.handlers.SettingElementHandler;
import com.slamtheham.ultracore.settings.handlers.SettingItemHandler;
import org.bukkit.event.Listener;

public class SettingBuilder {

    private String id;
    private Listener listener;
    private ClickHandler clickHandler;
    private SettingElementHandler settingElementHandler;
    private SettingItemHandler settingItemHandler;

    public SettingBuilder id(String id) {
        this.id = id;
        return this;
    }

    public SettingBuilder listener(Listener listener) {
        this.listener = listener;
        return this;
    }

    public SettingBuilder clickHandler(ClickHandler clickHandler) {
        this.clickHandler = clickHandler;
        return this;
    }

    public SettingBuilder elementHandler(SettingElementHandler settingElementHandler) {
        this.settingElementHandler = settingElementHandler;
        return this;
    }

    public SettingBuilder itemHandler(SettingItemHandler settingItemHandler) {
        this.settingItemHandler = settingItemHandler;
        return this;
    }

    public Setting build() {
        if (id == null || settingElementHandler == null || settingItemHandler == null) return null;
        return new Setting(id, listener, clickHandler, settingElementHandler, settingItemHandler);
    }

}
