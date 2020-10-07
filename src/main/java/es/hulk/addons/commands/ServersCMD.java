package es.hulk.addons.commands;

import es.hulk.addons.HubAddons;
import es.hulk.addons.utils.Utils;
import es.hulk.addons.utils.command.BaseCommand;
import es.hulk.addons.utils.command.Command;
import es.hulk.addons.utils.command.CommandArgs;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public class ServersCMD extends BaseCommand {

    @Command(name = "servers", aliases = "playservers", noPerm = "&cNo Permission")

    @Override
    public void onCommand(CommandArgs cmd) {

        Player p = cmd.getPlayer();
        for (String s : HubAddons.getInstance().getConfig().getStringList("ONLINE-SERVERS")) {
            String placeholder = PlaceholderAPI.setPlaceholders(p, s);
            p.sendMessage(Utils.color(placeholder));
        }

    }
}
