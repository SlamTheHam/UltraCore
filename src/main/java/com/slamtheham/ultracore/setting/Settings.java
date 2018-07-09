package com.slamtheham.ultracore.setting;

import com.slamtheham.ultracore.setting.handlers.BooleanClickHandler;
import com.slamtheham.ultracore.setting.listeners.PvpListener;
import com.slamtheham.ultracore.utils.ItemManager;
import me.blackness.black.element.BasicElement;
import org.bukkit.Bukkit;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.slamtheham.ultracore.utils.StringUtils.cc;

public class Settings {

    private Settings() {

    }

    public static final Setting PVP = new SettingBuilder().id("PVP")
            .listener(new PvpListener())
            .load((setting, manager) -> {
                BooleanClickHandler clickHandler = (BooleanClickHandler) setting.getSettingClickHandler();
                String path = clickHandler.getPath();
                boolean status = manager.getPlugin().getMainConfig().getConfig().getBoolean(path);
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
            })
            .click((player, setting) -> new BooleanClickHandler("pvp.disable", setting).setNameChange(true))
            .element((player, setting) ->
                    new BasicElement(setting.getItemHandler().get(player, setting),
                            setting.getClickHandler().get(player, setting).get()))
            .item((player, setting) -> {
                BooleanClickHandler clickHandler = (BooleanClickHandler) setting.getSettingClickHandler();
                String path = clickHandler.getPath();
                String status = clickHandler.getPlugin().getMainConfig().getConfig().getBoolean(path) ? "&a&lTrue" : "&c&lFalse";
                return new ItemManager.ItemCreator(Material.PAPER).setName(cc("&3&lDISABLE PVP &8: " + status)).build();
            }).build();

    public static List<Setting> values() {
        return Arrays.stream(Settings.class.getFields()).map(field -> {
            try {
                return (Setting) field.get(null);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                Bukkit.getLogger().severe("Could not get Setting values " + e.getMessage());
            }
            return null;
        }).collect(Collectors.toList());
    }

}
