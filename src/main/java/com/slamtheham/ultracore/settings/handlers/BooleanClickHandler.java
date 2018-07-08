package com.slamtheham.ultracore.settings.handlers;

import com.slamtheham.ultracore.Main;
import com.slamtheham.ultracore.menu.ClickHandler;
import me.blackness.black.event.ElementBasicEvent;

import static com.slamtheham.ultracore.utils.StringUtils.cc;

public class BooleanClickHandler implements ClickHandler {

    private Main plugin;
    private String path;
    private String trueMessage;
    private String falseMessage;

    public BooleanClickHandler(String path) {
        this.plugin = Main.getInstance();
        this.path = path;
    }

    public BooleanClickHandler(String path, String trueMessage, String falseMessage) {
        this.plugin = Main.getInstance();
        this.path = path;
        this.trueMessage = trueMessage;
        this.falseMessage = falseMessage;
    }

    public BooleanClickHandler setTrueMessage(String message) {
        this.trueMessage = message;
        return this;
    }

    public BooleanClickHandler setFalseMessage(String message) {
        this.falseMessage = message;
        return this;
    }

    @Override
    public void runBasic(ElementBasicEvent event) {
        boolean status = plugin.getMainConfig().getConfig().getBoolean(path);
        boolean change = !status;
        plugin.getMainConfig().getConfig().set(path, change);
        if (change) {
            event.player().sendMessage(cc(trueMessage));
        } else {
            event.player().sendMessage(cc(falseMessage));
        }
    }

}
