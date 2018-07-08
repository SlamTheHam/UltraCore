package com.slamtheham.ultracore.menu;

import me.blackness.black.element.BasicElement;
import me.blackness.black.pane.BasicPane;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static com.slamtheham.ultracore.utils.StringUtils.cc;

public class ConfigSettingsMenu extends UltraMenu {

    private Player player;

    public ConfigSettingsMenu(Player player) {
        super(cc("&8Config Settings Menu"), 54);
        this.player = player;
        addPane(new BasicPane(0, 0, 6, 9));
        //test
        addElement(0, new BasicElement(new ItemStack(Material.APPLE)));
        buildChest();
    }

}
