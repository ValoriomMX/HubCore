package es.hulk.addons.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class InventoryMaker {

    public static Inventory createInventory(String title, int rows) {
        Inventory inv = Bukkit.getServer().createInventory(null, rows * 9, Utils.color(title));
        return inv;
    }

    public static ItemStack createItemStack(String name, List<String> lore, Material material, int amount, int data) {
        ItemStack item = new ItemStack(material, amount, (short) data);
        ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(Utils.color(name));
        itemmeta.setLore(new Utils().translateFromArray(lore));
        item.setItemMeta(itemmeta);
        return item;
    }

    public static ItemStack createItemStackWithoutLore(String name, Material material, int amount, int data) {
        ItemStack item = new ItemStack(material, amount, (short) data);
        ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(Utils.color(name));
        item.setItemMeta(itemmeta);
        return item;
    }

}

