package com.slamtheham.ultracore.listener;

import com.slamtheham.ultracore.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import java.util.Arrays;
import java.util.HashMap;

public class ListenerManager {

    private Main plugin;
    private HashMap<Class, Listener> listenerMap;

    public ListenerManager(Main plugin, Listener... listeners) {
        this.plugin = plugin;
        Arrays.stream(listeners).forEach(this::add);
    }

    public ListenerManager(Main plugin, ListenerConsumer... listenerConsumers) {
        this.plugin = plugin;
        Arrays.stream(listenerConsumers).forEach(this::add);
    }

    public ListenerManager(Main plugin) {
        this.plugin = plugin;
    }

    public ListenerManager add(Listener listener) {
        if (has(listener)) return this;
        listenerMap.put(listener.getClass(), listener);
        return this;
    }

    public ListenerManager add(ListenerConsumer consumer) {
        Listener listener = consumer.get();
        if (listener == null || has(listener)) return this;
        listenerMap.put(listener.getClass(), listener);
        return this;
    }

    public ListenerManager addAll(Listener... listeners) {
        Arrays.stream(listeners).forEach(this::add);
        return this;
    }

    public ListenerManager addAll(ListenerConsumer... consumers) {
        Arrays.stream(consumers).forEach(this::add);
        return this;
    }

    public ListenerManager register(Listener listener) {
        if (!has(listener)) return this;
        Bukkit.getPluginManager().registerEvents(listener, plugin);
        return this;
    }

    public ListenerManager registerAll() {
        listenerMap.values().forEach(l -> Bukkit.getPluginManager().registerEvents(l, plugin));
        return this;
    }

    public ListenerManager unregisterAll() {
        listenerMap.values().forEach(HandlerList::unregisterAll);
        return this;
    }

    public ListenerManager unregister(Listener listener) {
        if (!has(listener)) return this;
        HandlerList.unregisterAll(listener);
        return this;
    }

    public ListenerManager removeAll() {
        listenerMap.values().forEach(HandlerList::unregisterAll);
        listenerMap.clear();
        return this;
    }

    public ListenerManager remove(Listener listener) {
        if (!has(listener)) return this;
        HandlerList.unregisterAll(listener);
        listenerMap.remove(listener.getClass());
        return this;
    }

    public ListenerManager restart() {
        listenerMap.values().forEach(HandlerList::unregisterAll);
        listenerMap.clear();
        return this;
    }

    public boolean has(Listener listener) {
        return listenerMap.containsKey(listener.getClass());
    }

    public Main getPlugin() {
        return plugin;
    }

    public HashMap<Class, Listener> getListenerMap() {
        return listenerMap;
    }
    
}
