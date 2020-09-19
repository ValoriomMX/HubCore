package es.hulk.addons.commands;

import es.hulk.addons.utils.CC;
import es.hulk.addons.utils.Utils;
import es.hulk.addons.utils.command.BaseCommand;
import es.hulk.addons.utils.command.Command;
import es.hulk.addons.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class MainCMD extends BaseCommand {

    @Command(name = "hubaddons", permission = "hubaddons.admin")

    @Override
    public void onCommand(CommandArgs cmd) {
        Player p = cmd.getPlayer();
        p.sendMessage(Utils.color("&aHubAddons Admin Help"));
        p.sendMessage(CC.CHAT_BAR);
        p.sendMessage(Utils.color("&a/hubaddons reload -> Reload all configs"));
        p.sendMessage(CC.CHAT_BAR);
    }
}
