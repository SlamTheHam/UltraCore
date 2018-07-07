package com.slamtheham.ultracore.menu;

import me.blackness.black.Element;
import me.blackness.black.Page;
import me.blackness.black.Pane;
import me.blackness.black.element.BasicElement;
import me.blackness.black.event.ElementBasicEvent;
import me.blackness.black.page.ChestPage;
import me.blackness.black.pane.BasicPane;
import me.blackness.black.req.ClickTypeReq;
import me.blackness.black.req.OrReq;
import me.blackness.black.target.BasicTarget;
import me.blackness.black.target.ClickTarget;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import static com.slamtheham.ultracore.utils.StringUtils.cc;

public class AdminMenu implements UltraMenu {

    @Override
    public void init(Player player) {
        final Pane pane = new BasicPane(0, 0, 6, 9);
        //TODO: Elements to be created
        final Page page = new ChestPage(cc("&8Admin Menu - Page 1"), 54, pane);
        page.showTo(player);
    }

}
