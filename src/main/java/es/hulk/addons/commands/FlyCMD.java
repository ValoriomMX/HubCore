package es.hulk.addons.commands;

import es.hulk.addons.utils.Utils;
import es.hulk.addons.main.Main;
import org.bukkit.entity.Player;
import org.imanity.framework.bukkit.command.Command;

public class FlyCMD {

    @Command(names = {"fly", "flymode"}, permissionNode = "hubaddons.command.fly")

    public void flycmd(Player p) {
        if (Main.getInstance().getConfig().getBoolean("FLY.ENABLED")) {

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
    }
}