package es.hulk.addons.utils.board;

import es.hulk.addons.utils.board.events.AssembleBoardCreateEvent;
import es.hulk.addons.utils.board.events.AssembleBoardDestroyEvent;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

public class AssembleListener implements Listener
{
    private Assemble assemble;
    
    public AssembleListener(final Assemble assemble) {
        this.assemble = assemble;
    }
    
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event) {
        final AssembleBoardCreateEvent createEvent = new AssembleBoardCreateEvent(event.getPlayer());
        Bukkit.getPluginManager().callEvent((Event)createEvent);
        if (createEvent.isCancelled()) {
            return;
        }
        this.getAssemble().getBoards().put(event.getPlayer().getUniqueId(), new AssembleBoard(event.getPlayer(), this.getAssemble()));
    }
    
    @EventHandler
    public void onPlayerQuit(final PlayerQuitEvent event) {
        final AssembleBoardDestroyEvent destroyEvent = new AssembleBoardDestroyEvent(event.getPlayer());
        Bukkit.getPluginManager().callEvent((Event)destroyEvent);
        if (destroyEvent.isCancelled()) {
            return;
        }
        this.getAssemble().getBoards().remove(event.getPlayer().getUniqueId());
        event.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
    }
    
    public Assemble getAssemble() {
        return this.assemble;
    }
}
