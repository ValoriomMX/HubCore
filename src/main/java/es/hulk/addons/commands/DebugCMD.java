package es.hulk.addons.commands;

import es.hulk.addons.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DebugCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (p.hasPermission("retard")) {
                p.sendMessage(Utils.color("Comando para testear"));
            } else {
                p.sendMessage(Utils.color(Utils.stringConfig("INSUFICIENT-PERMISSIONS")));
            }
        }

        return true;
    }
}
