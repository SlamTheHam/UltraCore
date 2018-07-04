package com.slamtheham.ultracore.config;

import com.slamtheham.ultracore.Main;

import java.util.HashMap;

public class Configs {

    private Main plugin;

    private HashMap<String, Config> configHashMap;

    public Configs(Main plugin) {
        this.plugin = plugin;
        configHashMap = new HashMap<>();
    }

    public Config add(String name, Config config) {
        if (!has(name)) {
            return getConfigHashMap().put(name, config);
        }
        return null;
    }

    public Config remove(String name) {
        if (has(name)) {
            return getConfigHashMap().remove(name);
        }
        return null;
    }

    public Boolean has(String name) {
        return getConfigHashMap().containsKey(name);
    }

    public Config get(String name) {
        return getConfigHashMap().getOrDefault(name, null);
    }

    public Main getPlugin() {
        return plugin;
    }

    public HashMap<String, Config> getConfigHashMap() {
        return configHashMap;
    }
}
