package es.hulk.addons.providers;

import es.hulk.addons.HubAddons;
import es.hulk.addons.utils.Utils;
import io.github.thatkawaiisam.assemble.AssembleAdapter;
import me.clip.placeholderapi.PlaceholderAPI;
import me.joeleoli.portal.shared.queue.Queue;
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

        /*for (String string : HubAddons.getInstance().getScoreboardConfig().getStringList("SCOREBOARD.NORMAL")) {
            string = Utils.color(string);
            if (HubAddons.getQueue().inQueue(player)) {
                string = string.replace("%queue_position", String.valueOf(HubAddons.getQueue().getPosition(player)));
                string = string.replace("%queue_name%", String.valueOf(HubAddons.getQueue().getQueueIn(player)));
                string = string.replace("%queue_total%", String.valueOf(HubAddons.getQueue().getInQueue(HubAddons.getQueue().getQueueIn(player))));
            }
            toReturn.add(string);
        }*/
        return toReturn;
    }
}

        /*HubAddons.getInstance().getConfig().getStringList("SCOREBOARD.NORMAL").forEach(line ->
                board.add(line));

        if (HubAddons.getQueue().inQueue(player)) {
            HubAddons.getInstance().getConfig().getStringList("SCOREBOARD.QUEUED").forEach(line ->
                    board.add(line.
                            replaceAll("%queue_position", String.valueOf(HubAddons.getQueue().getPosition(player))).
                            replaceAll("%queue_name%", String.valueOf(HubAddons.getQueue().getQueueIn(player))).
                            replaceAll("%queue_total%", String.valueOf(HubAddons.getQueue().getInQueue(HubAddons.getQueue().getQueueIn(player))))));
        }

        /*for (final String lines : HubAddons.getInstance().getScoreboardConfig().getStringList("SCOREBOARD.NORMAL")) {
            String placeholder = PlaceholderAPI.setPlaceholders(player, lines);
            board.add(placeholder);
        }


        if (HubAddons.getQueue().inQueue(player)) {
                board.add(
                        replaceAll("%queue_position", String.valueOf(HubAddons.getQueue().getPosition(player))).
                        replaceAll("%queue_name%", String.valueOf(HubAddons.getQueue().getQueueIn(player))).
                        replaceAll("%queue_total%", String.valueOf(HubAddons.getQueue().getInQueue(HubAddons.getQueue().getQueueIn(player))));
                String placeholder = PlaceholderAPI.setPlaceholders(player, lines);
            }
        }*/

    /*
    @Override
    public List<String> getLines(final Player player) {
        Player p = player.getPlayer();
        final List<String> board = new ArrayList<>();
        Queue queue = Queue.getByPlayer(player.getUniqueId());
        if (!queue.containsPlayer(player.getUniqueId())) {
            for (final String lines : HubAddons.getInstance().getScoreboardConfig().getStringList("SCOREBOARD.NORMAL")) {
                String placeholder = PlaceholderAPI.setPlaceholders(p, lines);
                board.add(placeholder);
            }
        } else {
            for (final String lines : HubAddons.getInstance().getScoreboardConfig().getStringList("SCOREBOARD.QUEUED")) {
                String queueConfig = new String();
                lines.replaceAll("%queue_position", String.valueOf(queue.getPosition(player.getUniqueId()))).replaceAll("%queue_name%", String.valueOf(queue.getByPlayer(player.getUniqueId()))).replaceAll("%queue_total%", String.valueOf(queue.getPlayers().size()));
                String placeholder = PlaceholderAPI.setPlaceholders(p, lines);
                board.add(placeholder);
            }
        }
        return board;
    }
     */

