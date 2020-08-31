package es.hulk.addons.scoreboard;

import es.hulk.addons.utils.Utils;
import es.hulk.addons.utils.board.AssembleAdapter;
import es.hulk.addons.main.Main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard implements AssembleAdapter {

    @Override
    public String getTitle(final Player player) {
        if (Main.getInstance().getScoreboardConfig().getBoolean("SCOREBOARD.ENABLED")) {
            return Utils.color(Main.getInstance().getScoreboardConfig().getString("SCOREBOARD.TITLE"));
        }
        return null;
    }

    @Override
    public List<String> getLines(final Player player) {
        Player p = player.getPlayer();
        final List<String> board = new ArrayList<String>();
        if (Main.getInstance().getScoreboardConfig().getBoolean("SCOREBOARD.ENABLED")) {
            for (final String lines : Main.getInstance().getScoreboardConfig().getStringList("SCOREBOARD.LINES")) {
                String placeholder = PlaceholderAPI.setPlaceholders(p, lines);
                board.add(placeholder);
            }
            return board;
        }
        return null;
    }
}
