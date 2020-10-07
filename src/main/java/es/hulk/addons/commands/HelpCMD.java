package es.hulk.addons.commands;

import es.hulk.addons.utils.CC;
import es.hulk.addons.utils.Utils;
import es.hulk.addons.utils.command.BaseCommand;
import es.hulk.addons.utils.command.Command;
import es.hulk.addons.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class HelpCMD extends BaseCommand {

    @Command(name = "help", aliases = {"hubaddons.help", "?", "bukkit:?"})

    @Override
    public void onCommand(CommandArgs cmd) {
        Player p = cmd.getPlayer();

        p.sendMessage(CC.CHAT_BAR);
        p.sendMessage(Utils.color("&a&lHelp Menu"));
        p.sendMessage(Utils.color(" "));
        p.sendMessage(Utils.color("&a/fly &7- &fflymode for donators"));
        p.sendMessage(Utils.color("&a/joinqueue <server> &7- &fjoins the queue of a server"));
        p.sendMessage(Utils.color("&a/servers &7- &fsee the server you can queue for"));
        p.sendMessage(Utils.color("&a/help &7- &fShows this help"));
        p.sendMessage(Utils.color("&a/lunarclient &7- &fsee the people who has lunar client"));
        p.sendMessage(CC.CHAT_BAR);

    }
}
