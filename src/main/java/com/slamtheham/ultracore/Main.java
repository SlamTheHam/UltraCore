package com.slamtheham.ultracore;

import co.aikar.commands.BukkitCommandManager;
import com.slamtheham.ultracore.commands.MainCommand;
import com.slamtheham.ultracore.config.Config;
import com.slamtheham.ultracore.config.Configs;
import com.slamtheham.ultracore.listener.ListenerManager;
import com.slamtheham.ultracore.menu.AdminMenu;
import com.slamtheham.ultracore.menu.MenuList;
import com.slamtheham.ultracore.utils.Updater;
import me.blackness.black.Blackness;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    private BukkitCommandManager commandManager;
    private ListenerManager listenerManager;
    private Configs configs;
    private Updater updater;
    private MenuList menuList;

    @SuppressWarnings("unused")
    public void onEnable() {
        instance = this;
        listenerManager = new ListenerManager(this);
        commandManager = new BukkitCommandManager(this);
        configs = new Configs(this);
        updater = new Updater(this);
        new Blackness().prepareFor(this);
        menuList = new MenuList(this);
        setupMenu();
        setupListeners();
        setupCommandManager();
        setupConfigs();
    }

    public void reload() {
        configs.reloadAll();
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

    public void setupMenu() {
        menuList.add("admin", new AdminMenu());
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

    public Updater getUpdater() {
        return updater;
    }

    public MenuList getMenuList() {
        return menuList;
    }
}
