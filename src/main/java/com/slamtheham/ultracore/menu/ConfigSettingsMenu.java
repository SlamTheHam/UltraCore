package com.slamtheham.ultracore.menu;

import com.slamtheham.ultracore.Main;
import com.slamtheham.ultracore.settings.Setting;
import me.blackness.black.pane.BasicPane;
import org.bukkit.entity.Player;

import java.util.Comparator;

import static com.slamtheham.ultracore.utils.StringUtils.cc;

public class ConfigSettingsMenu extends UltraMenu {

    private Player player;

    public ConfigSettingsMenu(Player player) {
        super(cc("&8Config Settings Menu"), 54);
        this.player = player;
        addPane(new BasicPane(0, 0, 4, 9));
        Main.getInstance().getSettingsManager().getSettings().stream()
                .sorted(Comparator.comparing(Setting::getId))
                .forEach(setting -> {
                    if (!addToLastPage(setting.toElement(player))) {
                        addPane(new BasicPane(0, 0, 4, 9));
                        addToLastPage(setting.toElement(player));
                    }
                });
        buildChest();
    }

}
