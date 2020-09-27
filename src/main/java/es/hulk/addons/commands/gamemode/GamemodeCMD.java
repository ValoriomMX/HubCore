package es.hulk.addons.commands.gamemode;

import es.hulk.addons.utils.CC;
import es.hulk.addons.utils.Utils;
import es.hulk.addons.utils.command.BaseCommand;
import es.hulk.addons.utils.command.Command;
import es.hulk.addons.utils.command.CommandArgs;
import es.hulk.addons.utils.command.Completer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GamemodeCMD extends BaseCommand {

    @Command(name = "gamemode", permission = "hubaddons.admin.gamemode", noPerm = "&cNo Permission")

    @Override
    public void onCommand(CommandArgs cmd) {

        Player p = cmd.getPlayer();
        p.sendMessage(CC.CHAT_BAR);
        p.sendMessage(Utils.color("&a&lGamemode"));
        p.sendMessage(Utils.color(" "));
        p.sendMessage(Utils.color("&a/gamemode creative &7- &fput you in gamemode creative"));
        p.sendMessage(Utils.color("&a/gamemode survival &7- &fput you in gamemode survival"));
        p.sendMessage(Utils.color("&a/gamemode adventure &7- &fput you in gamemode adventure"));
        p.sendMessage(CC.translate(" "));
        p.sendMessage(Utils.color("&7Remember to run stable 1.7.10 Lunar Client to use Staff Modules"));
        p.sendMessage(CC.CHAT_BAR);

    }

    @Completer(name = "gamemode", aliases = "gamemode")
    public List<String> testCompleter(CommandArgs args) {
        List<String> list = new ArrayList<String>();
        list.add("creative");
        list.add("survival");
        list.add("adventure");
        return list;
    }
}
