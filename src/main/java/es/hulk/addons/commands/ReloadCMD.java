package es.hulk.addons.commands;

import es.hulk.addons.HubAddons;
import es.hulk.addons.utils.Utils;
import es.hulk.addons.utils.command.BaseCommand;
import es.hulk.addons.utils.command.Command;
import es.hulk.addons.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class ReloadCMD extends BaseCommand {


    @Command(name = "hubaddons.reload", permission = "hubaddons.command.reloadconfig", aliases = {"hubaddons.reloadconfigs"}, noPerm = "&cNo Permission")

    @Override
    public void onCommand(CommandArgs cmd) {
        Player p = cmd.getPlayer();
        HubAddons.getInstance().reloadConfig();
        HubAddons.getInstance().createMenusConfig();
        HubAddons.getInstance().createItemsConfig();
        HubAddons.getInstance().createScoreboardConfig();
        p.sendMessage(Utils.color("&aReload has been succsesfully done"));
    }
}

