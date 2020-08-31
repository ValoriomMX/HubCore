package es.hulk.addons.utils.board;

import org.bukkit.*;
import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.scoreboard.*;

public class AssembleThread extends Thread
{
    private Assemble assemble;
    
    AssembleThread(final Assemble assemble) {
        this.assemble = assemble;
        this.start();
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                this.tick();
            }
            catch (NullPointerException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(this.assemble.getTicks() * 50L);
            }
            catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }
    
    private void tick() {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = this.assemble.getPlugin().getServer().getOnlinePlayers().toArray(new Player[0])).length, k = 0; k < length; ++k) {
            final Player player = onlinePlayers[k];
            final AssembleBoard board = this.assemble.getBoards().get(player.getUniqueId());
            if (board != null) {
                final Scoreboard scoreboard = board.getScoreboard();
                final Objective objective = board.getObjective();
                final String title = ChatColor.translateAlternateColorCodes('&', this.assemble.getAdapter().getTitle(player));
                if (!objective.getDisplayName().equals(title)) {
                    objective.setDisplayName(title);
                }
                final List<String> newLines = this.assemble.getAdapter().getLines(player);
                if (newLines == null || newLines.isEmpty()) {
                    board.getEntries().forEach(AssembleBoardEntry::remove);
                    board.getEntries().clear();
                }
                else {
                    if (!this.assemble.getAssembleStyle().isDecending()) {
                        Collections.reverse(newLines);
                    }
                    if (board.getEntries().size() > newLines.size()) {
                        for (int i = newLines.size(); i < board.getEntries().size(); ++i) {
                            final AssembleBoardEntry entry = board.getEntryAtPosition(i);
                            if (entry != null) {
                                entry.remove();
                            }
                        }
                    }
                    int cache = this.assemble.getAssembleStyle().getStartNumber();
                    for (int j = 0; j < newLines.size(); ++j) {
                        AssembleBoardEntry entry2 = board.getEntryAtPosition(j);
                        final String line = ChatColor.translateAlternateColorCodes('&', (String)newLines.get(j));
                        if (entry2 == null) {
                            entry2 = new AssembleBoardEntry(board, line);
                        }
                        entry2.setText(line);
                        entry2.setup();
                        entry2.send(this.assemble.getAssembleStyle().isDecending() ? cache-- : cache++);
                    }
                }
                if (player.getScoreboard() != scoreboard) {
                    player.setScoreboard(scoreboard);
                }
            }
        }
    }
}
