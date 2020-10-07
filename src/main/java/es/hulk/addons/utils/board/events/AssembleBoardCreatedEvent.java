package es.hulk.addons.utils.board.events;

import es.hulk.addons.utils.board.AssembleBoard;
import org.bukkit.event.*;

public class AssembleBoardCreatedEvent extends Event
{
    public static HandlerList handlerList;
    private boolean cancelled;
    private final AssembleBoard board;
    
    static {
        AssembleBoardCreatedEvent.handlerList = new HandlerList();
    }
    
    public AssembleBoardCreatedEvent(final AssembleBoard board) {
        this.cancelled = false;
        this.board = board;
    }
    
    public HandlerList getHandlers() {
        return AssembleBoardCreatedEvent.handlerList;
    }
    
    public boolean isCancelled() {
        return this.cancelled;
    }
    
    public AssembleBoard getBoard() {
        return this.board;
    }
    
    public void setCancelled(final boolean cancelled) {
        this.cancelled = cancelled;
    }
    
    public static HandlerList getHandlerList() {
        return AssembleBoardCreatedEvent.handlerList;
    }
}
