package com.slamtheham.ultracore.menu;

import com.slamtheham.ultracore.Main;

import java.util.HashMap;

public class MenuList {

    private Main plugin;
    private HashMap<String, UltraMenu> ultraMenuMap = new HashMap<>();

    public MenuList(Main plugin) {
        this.plugin = plugin;
    }

    public UltraMenu add(String id, UltraMenu menu) {
        if (has(id)) return null;
        return ultraMenuMap.put(id, menu);
    }

    public UltraMenu remove(String id) {
        if (!has(id)) return null;
        return ultraMenuMap.remove(id);
    }

    public <T extends UltraMenu> T get(String id) {
        return (T) ultraMenuMap.getOrDefault(id, null);
    }

    public boolean has(String id) {
        return ultraMenuMap.containsKey(id);
    }

    public Main getPlugin() {
        return plugin;
    }

    public HashMap<String, UltraMenu> getUltraMenuMap() {
        return ultraMenuMap;
    }
}
