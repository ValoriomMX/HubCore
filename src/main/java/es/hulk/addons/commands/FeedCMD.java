package es.hulk.addons.commands;

import es.hulk.addons.HubAddons;
import es.hulk.addons.utils.Utils;
import es.hulk.addons.utils.command.BaseCommand;
import es.hulk.addons.utils.command.Command;
import es.hulk.addons.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class FeedCMD extends BaseCommand {

    @Command(name = "feed", permission = "hubaddons.admin.feed", noPerm = "&cNo Permission")

    @Override
    public void onCommand(CommandArgs cmd) {
        Player p = cmd.getPlayer();

        p.setFoodLevel(20);
        p.sendMessage(Utils.color(HubAddons.getInstance().getConfig().getString("FEED-COMMAND.MESSAGE")));

    }
}
