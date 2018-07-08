package com.slamtheham.ultracore.config;

import com.slamtheham.ultracore.Main;

import java.io.File;
import java.util.HashMap;
import java.util.stream.Stream;

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
        if (has(name)) return null;
        return getConfigHashMap().remove(name);
    }

    public void reloadAll() {
        configHashMap.values().forEach(Config::load);
    }

    public void reload(String name) {
        if (!has(name)) return;
        get(name).load();
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
