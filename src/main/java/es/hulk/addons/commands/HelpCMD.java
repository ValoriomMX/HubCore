package es.hulk.addons.commands;

import es.hulk.addons.utils.CC;
import es.hulk.addons.utils.Utils;
import org.bukkit.entity.Player;
import org.imanity.framework.bukkit.command.Command;

public class HelpCMD {

    @Command(names = {"help", "hubaddons.help"})

    public void onCommand(Player cmd) {
        Player p = cmd.getPlayer();

        p.sendMessage(Utils.color("HubAddons Help"));
        p.sendMessage(CC.CHAT_BAR);
        p.sendMessage(Utils.color("&a/fly &7-> &eOnly for vips"));
        p.sendMessage(CC.CHAT_BAR);

    }
}
