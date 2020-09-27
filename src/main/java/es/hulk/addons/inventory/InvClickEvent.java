package es.hulk.addons.inventory;

import es.hulk.addons.HubAddons;
import es.hulk.addons.utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InvClickEvent implements Listener {

    @EventHandler
    public void ClickEvent(InventoryClickEvent e) {
        Inventory inv = e.getClickedInventory();
        if(inv == null) return;

        ItemStack is = e.getCurrentItem();
        if(is == null || is.getType() == Material.AIR) return;
        if(!is.hasItemMeta() || !is.getItemMeta().hasDisplayName()) return;

        if(inv.getTitle().equalsIgnoreCase(Utils.color(HubAddons.getInstance().getMenusConfig().getString("SERVER-SELECTOR.TITLE")))) {
            for(String path : HubAddons.getInstance().getMenusConfig().getConfigurationSection("SERVER-SELECTOR.ITEMS").getKeys(false)) {
                if(is.getType() == Material.valueOf(HubAddons.getInstance().getMenusConfig().getString("SERVER-SELECTOR.ITEMS."+path+".ITEM")) && is.getItemMeta().getDisplayName().equals(Utils.color(HubAddons.getInstance().getMenusConfig().getString("SERVER-SELECTOR.ITEMS."+path+".NAME")))) {
                    Player p = (Player) e.getWhoClicked();
                    HubAddons.getInstance().sendToServer(p, HubAddons.getInstance().getMenusConfig().getString("SERVER-SELECTOR.ITEMS."+path+".SERVER"));
                    p.closeInventory();
                }
            }
            e.setCancelled(true);
        }
        if(inv.getTitle().equalsIgnoreCase(Utils.color(Utils.stringConfig("HUB-SELECTOR.TITLE")))) {
            for(String path : HubAddons.getInstance().getMenusConfig().getConfigurationSection("HUB-SELECTOR.ITEMS").getKeys(false)) {
                if(is.getType() == Material.valueOf(HubAddons.getInstance().getMenusConfig().getString("HUB-SELECTOR.ITEMS."+path+".ITEM")) && is.getItemMeta().getDisplayName().equals(Utils.color(HubAddons.getInstance().getMenusConfig().getString("HUB-SELECTOR.ITEMS."+path+".NAME")))) {
                    Player p = (Player) e.getWhoClicked();
                    HubAddons.getInstance().sendToServer(p, HubAddons.getInstance().getMenusConfig().getString("HUB-SELECTOR.ITEMS."+path+".SERVER"));
                    p.closeInventory();
                }
            }
            e.setCancelled(true);
        }
    }




}
