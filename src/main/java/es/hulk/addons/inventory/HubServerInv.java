package es.hulk.addons.inventory;

import es.hulk.addons.HubAddons;
import es.hulk.addons.utils.InventoryMaker;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class HubServerInv implements Listener {

    public static void openInventory(Player p) {
        Inventory selInv = InventoryMaker.createInventory(HubAddons.getInstance().getMenusConfig().getString("HUB-SELECTOR.TITLE"), HubAddons.getInstance().getMenusConfig().getInt("HUB-SELECTOR.ROWS"));

        int slot = 0;
        for(String path : HubAddons.getInstance().getMenusConfig().getConfigurationSection("HUB-SELECTOR.ITEMS").getKeys(false)) {

            List<String> lore = new ArrayList<>();

            for(String s : HubAddons.getInstance().getMenusConfig().getStringList("HUB-SELECTOR.ITEMS."+path+".LORE")) {
                String placeholder = PlaceholderAPI.setPlaceholders(p, s);
                lore.add(placeholder);
            }

            ItemStack item = InventoryMaker.createItemStack(HubAddons.getInstance().getMenusConfig().getString("HUB-SELECTOR.ITEMS."+path+".NAME"), lore, Material.valueOf(HubAddons.getInstance().getMenusConfig().getString("HUB-SELECTOR.ITEMS."+path+".ITEM")), 1, HubAddons.getInstance().getMenusConfig().getInt("HUB-SELECTOR.ITEMS."+path+".DATA"));
            selInv.setItem(HubAddons.getInstance().getMenusConfig().getInt("HUB-SELECTOR.ITEMS."+path+".SLOT"), item);

            slot++;
        }

        p.openInventory(selInv);

    }

}
