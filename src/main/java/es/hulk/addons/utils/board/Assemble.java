package es.hulk.addons.utils.board;

import org.bukkit.plugin.java.*;
import java.util.*;
import java.util.concurrent.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;

public class Assemble
{
    private static Assemble instance;
    private JavaPlugin plugin;
    private AssembleAdapter adapter;
    private Map<UUID, AssembleBoard> boards;
    private AssembleThread thread;
    private AssembleListener listeners;
    private long ticks;
    private boolean hook;
    private AssembleStyle assembleStyle;
    
    public Assemble(final JavaPlugin plugin, final AssembleAdapter adapter) {
        this.ticks = 2L;
        this.hook = false;
        this.assembleStyle = AssembleStyle.MODERN;
        if (plugin == null) {
            throw new RuntimeException("Assemble can not be instantiated without a plugin instance!");
        }
        Assemble.instance = this;
        this.plugin = plugin;
        this.adapter = adapter;
        this.boards = new ConcurrentHashMap<UUID, AssembleBoard>();
        this.setup();
    }
    
    private void setup() {
        this.listeners = new AssembleListener(this);
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this.listeners, (Plugin)this.plugin);
        if (this.thread != null) {
            this.thread.stop();
            this.thread = null;
        }
        this.thread = new AssembleThread(this);
    }
    
    public void cleanup() {
        if (this.thread != null) {
            this.thread.stop();
            this.thread = null;
        }
        if (this.listeners != null) {
            HandlerList.unregisterAll((Listener)this.listeners);
            this.listeners = null;
        }
    }
    
    public JavaPlugin getPlugin() {
        return this.plugin;
    }
    
    public AssembleAdapter getAdapter() {
        return this.adapter;
    }
    
    public Map<UUID, AssembleBoard> getBoards() {
        return this.boards;
    }
    
    public AssembleThread getThread() {
        return this.thread;
    }
    
    public AssembleListener getListeners() {
        return this.listeners;
    }
    
    public long getTicks() {
        return this.ticks;
    }
    
    public boolean isHook() {
        return this.hook;
    }
    
    public AssembleStyle getAssembleStyle() {
        return this.assembleStyle;
    }
    
    public void setPlugin(final JavaPlugin plugin) {
        this.plugin = plugin;
    }
    
    public void setAdapter(final AssembleAdapter adapter) {
        this.adapter = adapter;
    }
    
    public void setBoards(final Map<UUID, AssembleBoard> boards) {
        this.boards = boards;
    }
    
    public void setThread(final AssembleThread thread) {
        this.thread = thread;
    }
    
    public void setListeners(final AssembleListener listeners) {
        this.listeners = listeners;
    }
    
    public void setTicks(final long ticks) {
        this.ticks = ticks;
    }
    
    public void setHook(final boolean hook) {
        this.hook = hook;
    }
    
    public void setAssembleStyle(final AssembleStyle assembleStyle) {
        this.assembleStyle = assembleStyle;
    }
    
    public static Assemble getInstance() {
        return Assemble.instance;
    }
}
