package es.hulk.addons.commands;

import es.hulk.addons.utils.CC;
import es.hulk.addons.utils.Utils;
import es.hulk.addons.utils.command.BaseCommand;
import es.hulk.addons.utils.command.Command;
import es.hulk.addons.utils.command.CommandArgs;
import es.hulk.addons.utils.command.Completer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class MainCMD extends BaseCommand {

    @Command(name = "hubaddons", permission = "hubaddons.admin", noPerm = "&cNo Permission")

    @Override
    public void onCommand(CommandArgs cmd) {
        Player p = cmd.getPlayer();
        p.sendMessage(CC.CHAT_BAR);
        p.sendMessage(Utils.color("&a&lAdmin Help"));
        p.sendMessage(Utils.color(" "));
        p.sendMessage(Utils.color("&a/hubaddons reload &7- &freloads the config"));
        p.sendMessage(Utils.color("&a/lunarstaff &7- &fopens a help for lunarstaff command"));
        p.sendMessage(Utils.color("&a/heal &7- &fheal the player"));
        p.sendMessage(CC.CHAT_BAR);
    }

    @Completer(name = "hubaddons", aliases = "hubaddons")
    public List<String> testCompleter(CommandArgs args) {
        List<String> list = new ArrayList<String>();
        list.add("reload");
        return list;
    }
}
