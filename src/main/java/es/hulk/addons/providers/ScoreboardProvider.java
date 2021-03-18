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
        Player p = player.getPlayer();
        final List<String> board = new ArrayList<>();
        /*for (final String lines : HubAddons.getInstance().getScoreboardConfig().getStringList("SCOREBOARD.NORMAL")) {
            String placeholder = PlaceholderAPI.setPlaceholders(p, lines);
            board.add(placeholder);
        }
        Queue queue = Queue.getByPlayer(player.getUniqueId());

        int queue_position = queue.getPosition(player.getUniqueId());
        String queue_name = queue.getName();
        int queue_size = queue.getPlayers().size();

        if (!queue.containsPlayer(player.getUniqueId())) {
            for (final String lines : HubAddons.getInstance().getScoreboardConfig().getStringList("SCOREBOARD.NORMAL")) {
                String placeholder = PlaceholderAPI.setPlaceholders(p, lines);
                board.add(placeholder);
            }
        } else {
            for (final String lines : HubAddons.getInstance().getScoreboardConfig().getStringList("SCOREBOARD.QUEUED")) {
                String placeholder = PlaceholderAPI.setPlaceholders(p, lines);
                board.add(placeholder +
                        queue_name.replaceAll("%queue_name%", queue.getName()) +
                        Integer.toString(queue_position).replaceAll("%queue_position%", String.valueOf(queue.getPosition(player.getUniqueId()))) +
                        Integer.toString(queue_size).replaceAll("%queue_size%", String.valueOf(queue.getPlayers().size())));
            }
        }

 */
        return board;
    }
}
