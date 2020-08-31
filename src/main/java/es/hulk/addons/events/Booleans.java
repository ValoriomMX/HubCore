package es.hulk.addons.events;

import es.hulk.addons.utils.Utils;
import es.hulk.addons.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class Booleans implements Listener {

    @EventHandler
    public void InvMoveEvent(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (Main.getInstance().getConfig().getBoolean("BOOLEANS.INVCLICK")) {
            e.setCancelled(true);
            p.updateInventory();
        } else {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void InvDragEvent(InventoryDragEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (Main.getInstance().getConfig().getBoolean("BOOLEANS.INVDRAG")) {
            e.setCancelled(true);
            p.updateInventory();
        } else {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e) {
        if (Main.getInstance().getConfig().getBoolean("BOOLEANS.DROPITEMS")) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void BlockPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (Main.getInstance().getConfig().getBoolean("BOOLEANS.BLOCKPLACE.ENABLED")) {
            e.setCancelled(true);
            p.sendMessage(Utils.color(Utils.stringConfig("BOOLEANS.BLOCKPLACE.MESSAGE")));
        } else {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void BlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (Main.getInstance().getConfig().getBoolean("BOOLEANS.BLOCKBREAK.ENABLED")) {
            e.setCancelled(true);
            p.sendMessage(Utils.color(Utils.stringConfig("BOOLEANS.BLOCKBREAK.MESSAGE")));
        }
    }
}
