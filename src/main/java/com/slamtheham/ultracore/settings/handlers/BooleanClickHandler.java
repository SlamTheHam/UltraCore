package com.slamtheham.ultracore.settings.handlers;

import com.slamtheham.ultracore.Main;
import com.slamtheham.ultracore.menu.ClickHandler;
import com.slamtheham.ultracore.settings.Setting;
import me.blackness.black.Target;
import me.blackness.black.event.ElementBasicEvent;
import me.blackness.black.event.ElementClickEvent;
import me.blackness.black.target.BasicTarget;
import me.blackness.black.target.ClickTarget;
import org.bukkit.entity.Player;

import static com.slamtheham.ultracore.utils.StringUtils.cc;

public abstract class BooleanClickHandler implements ClickHandler {

    private Main plugin;
    private String path;
    private Setting setting;

    public BooleanClickHandler(String path, Setting setting) {
        this.plugin = Main.getInstance();
        this.path = path;
        this.setting = setting;
    }

    public abstract void run(ElementClickEvent event, Setting setting, boolean status);

    @Override
    public Target[] get() {
        return new Target[]{
                new ClickTarget(e -> {
                    boolean status = plugin.getMainConfig().getConfig().getBoolean(path);
                    boolean change = !status;
                    plugin.getMainConfig().getConfig().set(path, change);
                    run(e, setting, change);
                })
        };
    }

}
