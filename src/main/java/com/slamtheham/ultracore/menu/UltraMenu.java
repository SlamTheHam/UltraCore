package com.slamtheham.ultracore.menu;

import org.bukkit.entity.Player;

public interface UltraMenu {

    void init(Player player);

    default void close(Player player){
        player.closeInventory();
    }

}
