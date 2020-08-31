package es.hulk.addons.events;

import es.hulk.addons.utils.Utils;
import es.hulk.addons.main.Main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {

    @EventHandler
    public void ChatEvent(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (Main.getInstance().getConfig().getBoolean("CHAT-FORMAT.ENABLED")) {
            String s = Utils.color(Utils.stringConfig("CHAT-FORMAT.FORMAT").replace("<message>", Utils.color("%2$s")));
            String chat = PlaceholderAPI.setPlaceholders(p, s);
            e.setFormat(chat);
        }

    }

}
