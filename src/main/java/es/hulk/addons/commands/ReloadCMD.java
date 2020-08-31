package es.hulk.addons.commands;

import es.hulk.addons.utils.Utils;
import es.hulk.addons.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("addons.command.reload")) {
            if (args.length == 0) {
                sender.sendMessage(Utils.color("&cInsufficient arguments"));
                return true;
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    Main.getInstance().reloadConfig();
                    Main.getInstance().createMenusConfig();
                    Main.getInstance().createItemsConfig();
                    Main.getInstance().createScoreboardConfig();
                    Main.getInstance().createTabConfig();
                    sender.sendMessage(Utils.color("&aReload has been succsesfully done"));
                    return true;
                }
            }
        }

        return true;
    }
}
