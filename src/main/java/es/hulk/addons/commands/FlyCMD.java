package es.hulk.addons.commands;

import es.hulk.addons.utils.Utils;
import es.hulk.addons.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (Main.getInstance().getConfig().getBoolean("FLY.ENABLED")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;

                if (p.hasPermission("hulk.command.fly")) {
                    if (p.getAllowFlight()) {
                        p.setAllowFlight(false);
                        p.setFlying(false);
                        p.sendMessage(Utils.color(Main.getInstance().getConfig().getString("FLY.TURNED-OFF")));
                    } else {
                        p.setAllowFlight(true);
                        p.setFlying(true);
                        p.sendMessage(Utils.color(Main.getInstance().getConfig().getString("FLY.TURNED-ON")));
                    }
                } else {
                    p.sendMessage(Utils.color(Utils.stringConfig("INSUFICIENT-PERMISSIONS")));
                }
            }
        } else {
            sender.sendMessage(Utils.color("&fUnknown Command. Type /help for help."));
        }
        return true;
    }
}