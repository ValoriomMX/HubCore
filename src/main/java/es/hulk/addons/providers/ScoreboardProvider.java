package es.hulk.addons.providers;

import es.hulk.addons.HubAddons;
import es.hulk.addons.queue.PortalAPI;
import es.hulk.addons.utils.Utils;
import io.github.thatkawaiisam.assemble.AssembleAdapter;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreboardProvider implements AssembleAdapter {

    @Override
    public String getTitle(final Player player) {
        return Utils.color(HubAddons.getInstance().getScoreboardConfig().getString("SCOREBOARD.TITLE"));
    }

    @Override
    public List<String> getLines(final Player player) {
        Player p = player.getPlayer();
        final List<String> board = new ArrayList<>();
        if (HubAddons.getQueue().inQueue(p)) {
            for (String add : HubAddons.getInstance().getScoreboardConfig().getStringList("SCOREBOARD.QUEUED").stream()
                    .map(a -> a.replace("%queue_name%", "" + HubAddons.getQueue().getQueueIn(p)))
                    .map(a -> a.replace("%queue_position%", "" + HubAddons.getQueue().getPosition(p)))
                    .map(a -> a.replace("%queue_size%", "" + HubAddons.getQueue().getInQueue(HubAddons.getQueue().getQueueIn(p))))
                    .collect(Collectors.toList())) {
                board.add(add);
            }
        } else {
            for (String add : HubAddons.getInstance().getScoreboardConfig().getStringList("SCOREBOARD.NORMAL")) {
                board.add(add);
            }
        }
        return board;
    }
}
