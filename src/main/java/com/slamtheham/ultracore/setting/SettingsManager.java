package com.slamtheham.ultracore.setting;

import com.slamtheham.ultracore.Main;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public class SettingsManager {

    private Main plugin;
    private List<Setting> settings = new ArrayList<>();

    private ArrayList<Listener> registeredListeners = new ArrayList<>();

    public SettingsManager(Main plugin) {
        this.plugin = plugin;

        Settings.values().forEach(this::registerSetting);
    }

    public boolean registerSetting(Setting setting) {
        if (hasSetting(setting)) return false;
        settings.add(setting);

        setting.getLoadHandler().run(setting, this);
        /*setting.getListener().ifPresent(l -> {
            if (!registeredListeners.contains(l)) {
                Bukkit.getServer().getPluginManager().registerEvents(l, plugin);
                registeredListeners.add(l);
            }
        });*/
        return true;
    }

    public Main getPlugin() {
        return plugin;
    }

    public List<Setting> getSettings() {
        return settings;
    }

    public ArrayList<Listener> getRegisteredListeners() {
        return registeredListeners;
    }

    public Setting getSettingById(String id) {
        return settings.stream().filter(setting -> setting.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean hasSetting(Setting setting) {
        boolean r = false;
        for (Setting s : settings) {
            if (s.getId().equals(setting.getId())) {
                r = true;
            }
        }
        return r;
    }

}
