package es.hulk.addons.utils.board.events;

import org.bukkit.event.*;
import org.bukkit.entity.*;

public class AssembleBoardDestroyEvent extends Event implements Cancellable
{
    public static HandlerList handlerList;
    private Player player;
    private boolean cancelled;
    
    static {
        AssembleBoardDestroyEvent.handlerList = new HandlerList();
    }
    
    public AssembleBoardDestroyEvent(final Player player) {
        this.cancelled = false;
        this.player = player;
    }
    
    public void setCancelled(final boolean b) {
        this.cancelled = b;
    }
    
    public HandlerList getHandlers() {
        return AssembleBoardDestroyEvent.handlerList;
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public boolean isCancelled() {
        return this.cancelled;
    }
    
    public static HandlerList getHandlerList() {
        return AssembleBoardDestroyEvent.handlerList;
    }
}
