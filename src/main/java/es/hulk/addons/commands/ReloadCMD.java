package es.hulk.addons.commands;

import es.hulk.addons.utils.CC;
import es.hulk.addons.utils.Utils;
import es.hulk.addons.main.Main;
import org.bukkit.entity.Player;
import org.imanity.framework.bukkit.command.Command;

public class ReloadCMD {

    @Command(names = "hubaddons", permissionNode = "hubaddons.admin")
    public void maincmd(Player cmd) {
        Player p = cmd.getPlayer();
        p.sendMessage(Utils.color("&aHubAddons Admin Help"));
        p.sendMessage(CC.CHAT_BAR);
        p.sendMessage(Utils.color("&a/hubaddons reload -> Reload all configs"));
        p.sendMessage(CC.CHAT_BAR);
    }

    @Command(names = {"hubaddons.reload", "hubaddons.reloadconfigs"}, permissionNode = "hubaddons.command.reloadconfig")
    public void reloadcmd(Player cmd) {
        Player p = cmd.getPlayer();
        Main.getInstance().reloadConfig();
        Main.getInstance().createMenusConfig();
        Main.getInstance().createItemsConfig();
        Main.getInstance().createScoreboardConfig();
        p.sendMessage(Utils.color("&aReload has been succsesfully done"));
    }
}

