package es.hulk.addons.commands;

import es.hulk.addons.utils.CC;
import es.hulk.addons.utils.Utils;
import es.hulk.addons.utils.command.BaseCommand;
import es.hulk.addons.utils.command.Command;
import es.hulk.addons.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class HelpCMD extends BaseCommand {

    @Command(name = "help", aliases = "hubaddons.help")

    @Override
    public void onCommand(CommandArgs cmd) {
        Player p = cmd.getPlayer();

        p.sendMessage(Utils.color("HubAddons Help"));
        p.sendMessage(CC.CHAT_BAR);
        p.sendMessage(Utils.color("&a/fly &7-> &eOnly for vips"));
        p.sendMessage(CC.CHAT_BAR);

    }
}
