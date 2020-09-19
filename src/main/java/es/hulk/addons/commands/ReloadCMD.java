package es.hulk.addons.commands;

import es.hulk.addons.utils.Utils;
import es.hulk.addons.main.Main;
import es.hulk.addons.utils.command.BaseCommand;
import es.hulk.addons.utils.command.Command;
import es.hulk.addons.utils.command.CommandArgs;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCMD extends BaseCommand {


    @Command(name = "hubaddons.reload", permission = "hubaddons.command.reloadconfig", aliases = {"hubaddons.reloadconfigs"})

    @Override
    public void onCommand(CommandArgs cmd) {
        Player p = cmd.getPlayer();
        Main.getInstance().reloadConfig();
        Main.getInstance().createMenusConfig();
        Main.getInstance().createItemsConfig();
        Main.getInstance().createScoreboardConfig();
        p.sendMessage(Utils.color("&aReload has been succsesfully done"));
    }
}

