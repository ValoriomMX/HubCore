package es.hulk.addons.inventory;

import es.hulk.addons.utils.InventoryMaker;
import es.hulk.addons.main.Main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class SelectorInv implements Listener {

    public static void openInventory(Player p) {
        Inventory selInv = InventoryMaker.createInventory(Main.getInstance().getMenusConfig().getString("SERVER-SELECTOR.TITLE"), Main.getInstance().getMenusConfig().getInt("SERVER-SELECTOR.ROWS"));

        int slot = 0;
        for(String path : Main.getInstance().getMenusConfig().getConfigurationSection("SERVER-SELECTOR.ITEMS").getKeys(false)) {

            List<String> lore = new ArrayList<>();

            for(String s : Main.getInstance().getMenusConfig().getStringList("SERVER-SELECTOR.ITEMS."+path+".LORE")) {
                String placeholder = PlaceholderAPI.setPlaceholders(p, s);
                lore.add(placeholder);
            }

            ItemStack item = InventoryMaker.createItemStack(Main.getInstance().getMenusConfig().getString("SERVER-SELECTOR.ITEMS."+path+".NAME"), lore, Material.valueOf(Main.getInstance().getMenusConfig().getString("SERVER-SELECTOR.ITEMS."+path+".ITEM")), 1, Main.getInstance().getMenusConfig().getInt("SERVER-SELECTOR.ITEMS."+path+".DATA"));
            selInv.setItem(Main.getInstance().getMenusConfig().getInt("SERVER-SELECTOR.ITEMS."+path+".SLOT"), item);

            slot++;
        }

        p.openInventory(selInv);

    }
}
