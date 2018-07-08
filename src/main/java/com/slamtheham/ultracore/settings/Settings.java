package com.slamtheham.ultracore.settings;

import com.slamtheham.ultracore.Main;
import com.slamtheham.ultracore.settings.handlers.BooleanClickHandler;
import com.slamtheham.ultracore.settings.listeners.PvpListener;
import com.slamtheham.ultracore.utils.ItemManager;
import me.blackness.black.element.BasicElement;
import me.blackness.black.event.ElementClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.HandlerList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.slamtheham.ultracore.utils.StringUtils.*;

public class Settings {

    private Settings() {
    }

    public static final Setting PVP = new SettingBuilder().id("PVP")
            .listener(new PvpListener()).clickHandler((player, setting) ->
                    new BooleanClickHandler("pvp.disable", setting) {
                        @Override
                        public void run(ElementClickEvent event, Setting setting, boolean status) {
                            if (status) {
                                event.player().sendMessage("True Message");
                                setting.getListener().ifPresent(l -> Bukkit.getServer().getPluginManager().registerEvents(l, Main.getInstance()));
                            } else {
                                event.player().sendMessage("False Message");
                                setting.getListener().ifPresent(HandlerList::unregisterAll);
                            }
                        }
                    }
            ).elementHandler((player, setting) ->
                    new BasicElement(setting.getSettingItemHandler().get(player, setting),
                            setting.getSettingClickHandler().get(player, setting).get())
            ).itemHandler((player, setting) ->
                    new ItemManager.ItemCreator(Material.PAPER).setName(cc("&3&lDISABLE PVP")).build()
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
