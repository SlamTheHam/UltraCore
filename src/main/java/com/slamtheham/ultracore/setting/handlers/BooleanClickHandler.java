package com.slamtheham.ultracore.setting.handlers;

import com.slamtheham.ultracore.Main;
import com.slamtheham.ultracore.menu.ClickHandler;
import com.slamtheham.ultracore.setting.Setting;
import me.blackness.black.Target;
import me.blackness.black.event.ElementBasicEvent;
import me.blackness.black.req.ClickTypeReq;
import me.blackness.black.req.OrReq;
import me.blackness.black.target.BasicTarget;
import me.blackness.black.target.ClickTarget;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static com.slamtheham.ultracore.utils.StringUtils.cc;

public class BooleanClickHandler implements ClickHandler {

    private Main plugin;
    private String path;
    private Setting setting;
    private String trueMessage;
    private String falseMessage;
    private boolean nameChange;

    public BooleanClickHandler(String path, Setting setting) {
        this.plugin = Main.getInstance();
        this.path = path;
        this.setting = setting;
    }

    public Main getPlugin() {
        return plugin;
    }

    public String getPath() {
        return path;
    }

    public Setting getSetting() {
        return setting;
    }

    public String getTrueMessage() {
        return trueMessage;
    }

    public String getFalseMessage() {
        return falseMessage;
    }

    public boolean isNameChange() {
        return nameChange;
    }

    public BooleanClickHandler setTrueMessage(String trueMessage) {
        this.trueMessage = trueMessage;
        return this;
    }

    public BooleanClickHandler setFalseMessage(String falseMessage) {
        this.falseMessage = falseMessage;
        return this;
    }

    public BooleanClickHandler setNameChange(Boolean nameChange) {
        this.nameChange = nameChange;
        return this;
    }

    @Override
    public Target[] get() {
        return new Target[]{
                new ClickTarget(e -> {
                    e.cancel();
                    boolean status = plugin.getMainConfig().getConfig().getBoolean(path);
                    boolean change = !status;
                    plugin.getMainConfig().getConfig().set(path, change);
                    plugin.getMainConfig().save();
                    if (change) {
                        if (trueMessage != null) e.player().sendMessage(cc(trueMessage));
                        setting.getListener().ifPresent(l -> Bukkit.getServer().getPluginManager().registerEvents(l, Main.getInstance()));
                    } else {
                        if (falseMessage != null) e.player().sendMessage(cc(falseMessage));
                        setting.getListener().ifPresent(HandlerList::unregisterAll);
                    }
                    if (nameChange) {
                        ItemMeta meta = e.currentItem().getItemMeta();
                        List<String> lore = new ArrayList<>();
                        lore.add(cc("&a&l" + change));
                        meta.setLore(lore);
                        e.currentItem().setItemMeta(meta);
                    }
                }, new OrReq(new ClickTypeReq(ClickType.RIGHT), new ClickTypeReq(ClickType.LEFT))),
                new BasicTarget(ElementBasicEvent::cancel)
        };
    }

}
