package es.hulk.addons.providers;

import es.hulk.addons.HubAddons;
import es.hulk.addons.utils.Utils;
import io.github.thatkawaiisam.assemble.AssembleAdapter;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardProvider implements AssembleAdapter {

    @Override
    public String getTitle(final Player player) {
        return Utils.color(HubAddons.getInstance().getScoreboardConfig().getString("SCOREBOARD.TITLE"));
    }

    @Override
    public List<String> getLines(final Player player) {
        List<String> toReturn = new ArrayList<>();

        if (HubAddons.getQueue().inQueue(player)) {
            HubAddons.getInstance().getConfig().getStringList("SCOREBOARD.QUEUED").forEach(line -> {
                line = Utils.color(line);
                line = PlaceholderAPI.setPlaceholders(player, line);

                toReturn.add(line.
                        replaceAll("%queue_position", String.valueOf(HubAddons.getQueue().getPosition(player))).
                        replaceAll("%queue_name%", String.valueOf(HubAddons.getQueue().getQueueIn(player))).
                        replaceAll("%queue_total%", String.valueOf(HubAddons.getQueue().getInQueue(HubAddons.getQueue().getQueueIn(player)))));
            });
        } else {
            HubAddons.getInstance().getScoreboardConfig().getStringList("SCOREBOARD.NORMAL").forEach(line -> toReturn.add(Utils.color(PlaceholderAPI.setPlaceholders(player, line))));
        }
        return toReturn;
    }
}