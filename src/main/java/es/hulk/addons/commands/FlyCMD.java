package es.hulk.addons.commands;

import es.hulk.addons.HubAddons;
import es.hulk.addons.utils.Utils;
import es.hulk.addons.utils.command.BaseCommand;
import es.hulk.addons.utils.command.Command;
import es.hulk.addons.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class FlyCMD extends BaseCommand {

    @Command(name = "fly", aliases = "flymode", permission = "addons.command.fly", noPerm = "&cBuy rank to have access to this feature")

    @Override
    public void onCommand(CommandArgs cmd) {
        if (HubAddons.getInstance().getConfig().getBoolean("FLY.ENABLED")) {
            Player p = cmd.getPlayer();

            if (p.hasPermission("hulk.command.fly")) {
                if (p.getAllowFlight()) {
                    p.setAllowFlight(false);
                    p.setFlying(false);
                    p.sendMessage(Utils.color(HubAddons.getInstance().getConfig().getString("FLY.TURNED-OFF")));
                } else {
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    p.sendMessage(Utils.color(HubAddons.getInstance().getConfig().getString("FLY.TURNED-ON")));
                }
            }
        }
    }
}