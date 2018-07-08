package com.slamtheham.ultracore.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.slamtheham.ultracore.Main;
import com.slamtheham.ultracore.menu.AdminMenu;
import com.slamtheham.ultracore.utils.ProcessTime;
import com.slamtheham.ultracore.utils.Updater;
import net.md_5.bungee.api.chat.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.slamtheham.ultracore.utils.StringUtils.cc;

@CommandAlias("ultracore|core|ucore|uc")
public class MainCommand extends BaseCommand {

    public MainCommand() {

    }

    @Default
    @Subcommand("help")
    @Syntax("")
    @CommandPermission("ultracore.help")
    public void onHelp(CommandSender sender) {
        String label = getExecCommandLabel();
        sender.sendMessage(cc("&a&m--------------------------------------------------"));
        sender.sendMessage(cc("&f&lULTRACORE &7- How to use /" + label + " properly."));
        sender.sendMessage(cc(" "));
        sender.sendMessage(cc("&7Proper Usage: &e/" + label + " <arg>"));
        sender.sendMessage(cc("&bAll possible actions. &7&o(Click the text to auto fill the command)"));

        BaseComponent[] component1 =
                new ComponentBuilder(cc("&a/" + label + " help &e- Sends help message"))
                        .event(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/" + label + " help"))
                        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to autofill command").create()))
                        .create();
        sender.spigot().sendMessage(component1);
        BaseComponent[] component2 =
                new ComponentBuilder(cc("&a/" + label + " admin &e- Opens admin menu"))
                        .event(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/" + label + " admin"))
                        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to autofill command").create()))
                        .create();
        sender.spigot().sendMessage(component2);
        BaseComponent[] component3 =
                new ComponentBuilder(cc("&a/" + label + " info/information &e- Sends plugin information message"))
                        .event(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/" + label + " info"))
                        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to autofill command").create()))
                        .create();
        sender.spigot().sendMessage(component3);
        BaseComponent[] component4 =
                new ComponentBuilder(cc("&a/" + label + " ver/version &e- Sends version message"))
                        .event(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/" + label + " ver"))
                        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to autofill command").create()))
                        .create();
        sender.spigot().sendMessage(component4);
        BaseComponent[] component5 =
                new ComponentBuilder(cc("&a/" + label + " reload &e- Reloads the plugin and all configuration files"))
                        .event(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/" + label + " reload"))
                        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to autofill command").create()))
                        .create();
        sender.spigot().sendMessage(component5);
        BaseComponent[] component6 =
                new ComponentBuilder(cc("&a/" + label + " update &e- Updates the plugin if an update is available"))
                        .event(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/" + label + " update"))
                        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to autofill command").create()))
                        .create();
        sender.spigot().sendMessage(component6);
        sender.sendMessage(cc("&a&m--------------------------------------------------"));
    }

    @Subcommand("admin")
    @Syntax("")
    @CommandPermission("ultracore.admin")
    public void onAdmin(Player player) {
        AdminMenu menu = Main.getInstance().getMenuList().get("admin");
        menu.init(player);
    }

    @Subcommand("info|information")
    @Syntax("")
    @CommandPermission("ultracore.admin")
    public void onInformation(CommandSender sender) {
        //TODO: SEND INFORMATION
    }

    @Subcommand("ver|version")
    @Syntax("")
    @CommandPermission("ultracore.admin")
    public void onVersion(CommandSender sender) {
        String version = Main.getInstance().getDescription().getVersion();
        sender.sendMessage(cc("&f&lULTRACORE &7Version: &6" + version));
    }

    @Subcommand("reload")
    @Syntax("")
    @CommandPermission("ultracore.admin")
    public void onReload(CommandSender sender) {
        ProcessTime processTime = new ProcessTime(() -> Main.getInstance().reload());
        processTime.run();
        sender.sendMessage(cc("&eYou have reloaded the plugin and all configuration files"));
        sender.sendMessage(cc("&eAll systems reloaded in &a" + processTime.getTime() + "ms"));
    }

    @Subcommand("update")
    @Syntax("")
    @CommandPermission("ultracore.admin")
    public void onUpdate(CommandSender sender) {
        Updater updater = Main.getInstance().getUpdater();
        updater.check();
        if (updater.available()) {
            sender.sendMessage(cc("&a&m--------------------------------------------------"));
            sender.sendMessage(cc("&eUltraCore not up to date!"));
            sender.sendMessage(cc("&eCurrent version: &a" + updater.getNowVersion()));
            sender.sendMessage(cc("&eAvailable latest version: &a" + updater.getLatestVersion()));
            sender.sendMessage(cc("&eDownload Link: &a" + updater.getDownloadURL()));
            sender.sendMessage(cc("&a&m--------------------------------------------------"));
        } else {
            sender.sendMessage(cc("&eNo new updates!"));
        }
    }


}
