package es.hulk.addons.utils.board;

import org.bukkit.*;
import org.bukkit.scoreboard.*;

public class AssembleBoardEntry
{
    private final AssembleBoard board;
    private String text;
    private String identifier;
    private Team team;
    
    public AssembleBoardEntry(final AssembleBoard board, final String text) {
        this.board = board;
        this.text = text;
        this.identifier = this.board.getUniqueIdentifier(text);
        this.setup();
    }
    
    public void setup() {
        final Scoreboard scoreboard = this.board.getScoreboard();
        if (scoreboard == null) {
            return;
        }
        String teamName = this.identifier;
        if (teamName.length() > 16) {
            teamName = teamName.substring(0, 16);
        }
        Team team = scoreboard.getTeam(teamName);
        if (team == null) {
            team = scoreboard.registerNewTeam(teamName);
        }
        if (!team.getEntries().contains(this.identifier)) {
            team.addEntry(this.identifier);
        }
        if (!this.board.getEntries().contains(this)) {
            this.board.getEntries().add(this);
        }
        this.team = team;
    }
    
    public void send(final int position) {
        if (this.text.length() > 16) {
            String prefix = this.text.substring(0, 16);
            String suffix;
            if (prefix.charAt(15) == '�') {
                prefix = prefix.substring(0, 15);
                suffix = this.text.substring(15);
            }
            else if (prefix.charAt(14) == '�') {
                prefix = prefix.substring(0, 14);
                suffix = this.text.substring(14);
            }
            else if (ChatColor.getLastColors(prefix).equalsIgnoreCase(ChatColor.getLastColors(this.identifier))) {
                suffix = this.text.substring(16);
            }
            else {
                suffix = String.valueOf(ChatColor.getLastColors(prefix)) + this.text.substring(16);
            }
            if (suffix.length() > 16) {
                suffix = suffix.substring(0, 16);
            }
            this.team.setPrefix(prefix);
            this.team.setSuffix(suffix);
        }
        else {
            this.team.setPrefix(this.text);
            this.team.setSuffix("");
        }
        final Score score = this.board.getObjective().getScore(this.identifier);
        score.setScore(position);
    }
    
    public void remove() {
        this.board.getIdentifiers().remove(this.identifier);
        this.board.getScoreboard().resetScores(this.identifier);
    }
    
    public void setText(final String text) {
        this.text = text;
    }
    
    public void setIdentifier(final String identifier) {
        this.identifier = identifier;
    }
}
