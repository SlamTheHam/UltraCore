package com.slamtheham.ultracore;

import co.aikar.commands.BukkitCommandManager;
import com.slamtheham.ultracore.commands.MainCommand;
import com.slamtheham.ultracore.config.Config;
import com.slamtheham.ultracore.config.Configs;
import com.slamtheham.ultracore.listener.ListenerManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    private BukkitCommandManager commandManager;
    private ListenerManager listenerManager;
    private Configs configs;

    @SuppressWarnings("unused")
    public void onEnable() {
        instance = this;
        listenerManager = new ListenerManager(this);
        commandManager = new BukkitCommandManager(this);
        configs = new Configs(this);
        setupListeners();
        setupCommandManager();
        setupConfigs();
    }

    public void setupConfigs() {
        configs.add("config", new Config(this, "config.yml", true));
        configs.add("messages", new Config(this, "messages.yml", true));
    }

    public void setupCommandManager() {
        commandManager.registerCommand(new MainCommand());
    }

    public void setupListeners() {

    }

    public void onDisable() {

    }

    public static Main getInstance() {
        return instance;
    }

    public Configs getConfigs() {
        return configs;
    }

    public Config getMainConfig() {
        return configs.get("config");
    }

    public Config getMessageConfig() {
        return configs.get("messages");
    }

    public BukkitCommandManager getCommandManager() {
        return commandManager;
    }

    public ListenerManager getListenerManager() {
        return listenerManager;
    }
}
