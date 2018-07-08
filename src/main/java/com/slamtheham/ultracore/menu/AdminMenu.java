package com.slamtheham.ultracore.menu;

import com.slamtheham.ultracore.utils.ItemManager;
import me.blackness.black.element.BasicElement;
import me.blackness.black.pane.BasicPane;
import me.blackness.black.target.BasicTarget;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import static com.slamtheham.ultracore.utils.StringUtils.cc;

public class AdminMenu extends UltraMenu {

    private Player player;

    public AdminMenu(Player player) {
        super(cc("&8Admin Menu - Page 1"), 54);
        this.player = player;
        addPane(new BasicPane(0, 0, 6, 9));
        //TODO: Add more element
        addElement(0, new BasicElement(new ItemManager.ItemCreator(Material.BREWING_STAND_ITEM).setName(cc("&aConfig Settings")).build(),
                new BasicTarget(e -> {
                    e.cancel();
                    new ConfigSettingsMenu(e.player()).showToAll(Bukkit.getOnlinePlayers().toArray(new Player[0]));
                })
        ));
        buildChest();
    }

}
