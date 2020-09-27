package es.hulk.addons.events;

import es.hulk.addons.HubAddons;
import es.hulk.addons.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Quit implements Listener {

    @EventHandler
    public void QuitEvent(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if (HubAddons.getInstance().getConfig().getBoolean("DEFAULT-QUIT-MESSAGE.ENABLED")) {
            e.setQuitMessage(Utils.color(Utils.stringConfig("DEFAULT-QUIT-MESSAGE.MESSAGE")));
        } else {
            e.setQuitMessage("");
        }
    }

}
