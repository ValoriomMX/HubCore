package es.hulk.addons.events;

import es.hulk.addons.utils.Utils;
import es.hulk.addons.inventory.HubServerInv;
import es.hulk.addons.inventory.SelectorInv;
import es.hulk.addons.main.Main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Interact implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack is = e.getItem();
            if(is == null || is.getType() == Material.AIR) return;
            if(!is.hasItemMeta() || !is.getItemMeta().hasDisplayName()) return;

            if(is.getType() == Material.valueOf(Main.getInstance().getItemsConfig().getString("SERVER-SELECTOR-ITEM.MATERIAL")) && is.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color(Main.getInstance().getItemsConfig().getString("SERVER-SELECTOR-ITEM.DISPLAYNAME")))) {
                SelectorInv.openInventory(e.getPlayer());
            }

            if(is.getType() == Material.valueOf(Main.getInstance().getItemsConfig().getString("HUB-SELECTOR-ITEM.MATERIAL")) && is.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color(Main.getInstance().getItemsConfig().getString("HUB-SELECTOR-ITEM.DISPLAYNAME")))) {
                HubServerInv.openInventory(e.getPlayer());
            }

            if(is.getType() == Material.valueOf(Main.getInstance().getItemsConfig().getString("LINKS-ITEM.MATERIAL")) && is.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color(Main.getInstance().getItemsConfig().getString("LINKS-ITEM.DISPLAYNAME")))) {
                for (String s : Main.getInstance().getConfig().getStringList("LINKS-ITEM.MESSAGE")) {
                    String placeholder = PlaceholderAPI.setPlaceholders(e.getPlayer(), s);
                    e.getPlayer().sendMessage(Utils.color(placeholder));
                }
            }
        }
    }

}
