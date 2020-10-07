package es.hulk.addons.utils.board;

import es.hulk.addons.utils.board.events.AssembleBoardCreatedEvent;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.scoreboard.*;
import org.bukkit.*;
import org.bukkit.event.*;
import java.util.concurrent.*;

public class AssembleBoard
{
    private final List<AssembleBoardEntry> entries;
    private final List<String> identifiers;
    private Scoreboard scoreboard;
    private Objective objective;
    private Objective healthName;
    private Objective tabHealth;
    private UUID uuid;
    private Assemble assemble;
    
    public AssembleBoard(final Player player, final Assemble assemble) {
        this.entries = new ArrayList<AssembleBoardEntry>();
        this.identifiers = new ArrayList<String>();
        this.assemble = assemble;
        this.setup(player);
        this.uuid = player.getUniqueId();
    }
    
    private void setup(final Player player) {
        if (this.getAssemble().isHook() || player.getScoreboard() != Bukkit.getScoreboardManager().getMainScoreboard()) {
            this.scoreboard = player.getScoreboard();
        }
        else {
            this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        }
        (this.objective = this.scoreboard.registerNewObjective("Default", "dummy")).setDisplaySlot(DisplaySlot.SIDEBAR);
        this.objective.setDisplayName(this.getAssemble().getAdapter().getTitle(player));
        player.setScoreboard(this.scoreboard);
        final AssembleBoardCreatedEvent createdEvent = new AssembleBoardCreatedEvent(this);
        Bukkit.getPluginManager().callEvent((Event)createdEvent);
    }
    
    public Objective getOrCreateObjective(final Scoreboard scoreboard, final String objective, final String type) {
        Objective value = scoreboard.getObjective(objective);
        if (value == null) {
            value = scoreboard.registerNewObjective(objective, type);
        }
        value.setDisplayName(objective);
        return value;
    }
    
    public AssembleBoardEntry getEntryAtPosition(final int pos) {
        if (pos >= this.entries.size()) {
            return null;
        }
        return this.entries.get(pos);
    }
    
    public String getUniqueIdentifier(final String text) {
        String identifier;
        for (identifier = String.valueOf(getRandomChatColor()) + ChatColor.WHITE; this.identifiers.contains(identifier); identifier = String.valueOf(identifier) + getRandomChatColor() + ChatColor.WHITE) {}
        if (identifier.length() > 16) {
            return this.getUniqueIdentifier(text);
        }
        this.identifiers.add(identifier);
        return identifier;
    }
    
    private static String getRandomChatColor() {
        return ChatColor.values()[ThreadLocalRandom.current().nextInt(ChatColor.values().length)].toString();
    }
    
    public List<AssembleBoardEntry> getEntries() {
        return this.entries;
    }
    
    public List<String> getIdentifiers() {
        return this.identifiers;
    }
    
    public Scoreboard getScoreboard() {
        return this.scoreboard;
    }
    
    public Objective getObjective() {
        return this.objective;
    }
    
    public Objective getHealthName() {
        return this.healthName;
    }
    
    public Objective getTabHealth() {
        return this.tabHealth;
    }
    
    public UUID getUuid() {
        return this.uuid;
    }
    
    public Assemble getAssemble() {
        return this.assemble;
    }
}
