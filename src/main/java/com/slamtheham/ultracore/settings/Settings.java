package com.slamtheham.ultracore.settings;

import com.slamtheham.ultracore.settings.listeners.PvpListener;
import org.bukkit.Bukkit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Settings {

    private Settings() {
    }

    public static final Setting PVP = new SettingBuilder().id("pvp").name("&3&lPVP DISABLE").listener(new PvpListener()).click(
            event -> {

            }
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
