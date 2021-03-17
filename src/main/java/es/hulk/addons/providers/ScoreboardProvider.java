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
        Player p = player.getPlayer();
        final List<String> board = new ArrayList<String>();
        for (final String lines : HubAddons.getInstance().getScoreboardConfig().getStringList("SCOREBOARD.LINES")) {
            String placeholder = PlaceholderAPI.setPlaceholders(p, lines);
            board.add(placeholder);
        }
        return board;
    }
}
