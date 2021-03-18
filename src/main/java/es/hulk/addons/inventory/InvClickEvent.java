package es.hulk.addons.inventory;

import es.hulk.addons.HubAddons;
import es.hulk.addons.utils.Utils;
import me.joeleoli.portal.shared.queue.Queue;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InvClickEvent implements Listener {

    private String queue_name;

    @EventHandler
    public void ClickEvent(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        Inventory inv = e.getClickedInventory();
        if (inv == null) return;

        ItemStack is = e.getCurrentItem();
        if (is == null || is.getType() == Material.AIR) return;
        if (!is.hasItemMeta() || !is.getItemMeta().hasDisplayName()) return;

        if(inv.getTitle() == null) return;

        if (inv.getTitle().equalsIgnoreCase(Utils.color(HubAddons.getInstance().getMenusConfig().getString("SERVER-SELECTOR.TITLE")))) {
            for (String path : HubAddons.getInstance().getMenusConfig().getConfigurationSection("SERVER-SELECTOR.ITEMS").getKeys(false)) {
                if (is.getType() == Material.valueOf(HubAddons.getInstance().getMenusConfig().getString("SERVER-SELECTOR.ITEMS." + path + ".ITEM")) && is.getItemMeta().getDisplayName().equals(Utils.color(HubAddons.getInstance().getMenusConfig().getString("SERVER-SELECTOR.ITEMS." + path + ".NAME")))) {
                    Queue queue = Queue.getByName(HubAddons.getInstance().getMenusConfig().getString("SERVER-SELECTOR.ITEMS." + path + ".SERVER"));
                    queue.sendPlayer(p, HubAddons.getInstance().getMenusConfig().getString("SERVER-SELECTOR.ITEMS." + path + ".SERVER"));
                    p.closeInventory();
                }
            }
            e.setCancelled(true);
        }
        if (inv.getTitle().equalsIgnoreCase(Utils.color(HubAddons.getInstance().getMenusConfig().getString("HUB-SELECTOR.TITLE")))) {
            for (String path : HubAddons.getInstance().getMenusConfig().getConfigurationSection("HUB-SELECTOR.ITEMS").getKeys(false)) {
                if (is.getType() == Material.valueOf(HubAddons.getInstance().getMenusConfig().getString("HUB-SELECTOR.ITEMS." + path + ".ITEM")) && is.getItemMeta().getDisplayName().equals(Utils.color(HubAddons.getInstance().getMenusConfig().getString("HUB-SELECTOR.ITEMS." + path + ".NAME")))) {
                    HubAddons.getInstance().sendToServer(p, HubAddons.getInstance().getMenusConfig().getString("HUB-SELECTOR.ITEMS." + path + ".SERVER"));
                    p.closeInventory();
                }
            }
            e.setCancelled(true);
        }
        if (HubAddons.getInstance().getConfig().getBoolean("BOOLEANS.INVCLICK")) {
            e.setCancelled(true);
            p.updateInventory();
        } else {
            e.setCancelled(false);
        }
    }
}
