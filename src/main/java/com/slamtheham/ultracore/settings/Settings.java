package com.slamtheham.ultracore.settings;

import com.slamtheham.ultracore.settings.handlers.BooleanClickHandler;
import com.slamtheham.ultracore.settings.listeners.PvpListener;
import com.slamtheham.ultracore.utils.ItemManager;
import me.blackness.black.element.BasicElement;
import me.blackness.black.target.BasicTarget;
import org.bukkit.Bukkit;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Settings {

    private Settings() {
    }

    public static final Setting PVP = new SettingBuilder().id("PVP")
            .listener(new PvpListener()).clickHandler(
                    new BooleanClickHandler("pvp.disable", "", "")
            ).elementHandler((player, setting) ->
                    new BasicElement(setting.getSettingItemHandler().get(player, setting),
                            new BasicTarget(event -> setting.getClickHandler().runBasic(event)))
            ).itemHandler((player, setting) ->
                    new ItemManager.ItemCreator(Material.PAPER).setName("&3&lDISABLE PVP").build()
            ).build();

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
