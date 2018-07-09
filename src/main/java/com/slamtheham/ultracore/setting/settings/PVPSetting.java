package com.slamtheham.ultracore.setting.settings;

import com.slamtheham.ultracore.menu.ClickHandler;
import com.slamtheham.ultracore.setting.Setting;
import com.slamtheham.ultracore.setting.handlers.BooleanClickHandler;
import com.slamtheham.ultracore.setting.handlers.SettingClickHandler;
import com.slamtheham.ultracore.setting.listeners.PvpListener;
import com.slamtheham.ultracore.utils.ItemManager;
import me.blackness.black.element.BasicElement;
import org.bukkit.Bukkit;
import org.bukkit.Material;

import static com.slamtheham.ultracore.utils.StringUtils.cc;

public class PVPSetting extends Setting {

    public PVPSetting() {
        super("PVP", new PvpListener(),
                ((setting, manager) -> {
                    boolean status = manager.getPlugin().getMainConfig().getConfig().getBoolean("pvp.disable");
                    if (status) {
                        setting.getListener().ifPresent(l -> {
                            if (!manager.getRegisteredListeners().contains(l)) {
                                Bukkit.getServer().getPluginManager().registerEvents(l, manager.getPlugin());
                                manager.getRegisteredListeners().add(l);
                            }
                        });
                    } else {
                        setting.getListener().ifPresent(l -> {
                            if (!manager.getRegisteredListeners().contains(l)) {
                                manager.getRegisteredListeners().add(l);
                            }
                        });
                    }
                }),
                ((player, setting) -> new BooleanClickHandler("pvp.disable", setting).setNameChange(true)),
                ((player, setting) -> new BasicElement(setting.getItemHandler().get(player, setting),
                        setting.getClickHandler().get(player, setting).get())),
                ((player, setting) -> {
                    BooleanClickHandler clickHandler = (BooleanClickHandler) setting.getClickHandler();
                    String path = clickHandler.getPath();
                    String status = clickHandler.getPlugin().getMainConfig().getConfig().getBoolean(path) ? "&a&lTrue" : "&c&lFalse";
                    return new ItemManager.ItemCreator(Material.PAPER).setName(cc("&3&lDISABLE PVP &8: " + status)).build();
                })
        );
    }

}
