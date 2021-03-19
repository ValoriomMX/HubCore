package es.hulk.addons.events;

import es.hulk.addons.HubAddons;
import es.hulk.addons.utils.Utils;
import es.hulk.addons.inventory.HubServerInv;
import es.hulk.addons.inventory.SelectorInv;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Interact implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack is = e.getItem();
            if (is == null || is.getType() == Material.AIR) return;
            if (!is.hasItemMeta() || !is.getItemMeta().hasDisplayName()) return;

            if (is.getType() == Material.valueOf(HubAddons.getInstance().getItemsConfig().getString("SERVER-SELECTOR-ITEM.MATERIAL")) && is.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color(HubAddons.getInstance().getItemsConfig().getString("SERVER-SELECTOR-ITEM.DISPLAYNAME")))) {
                SelectorInv.openInventory(e.getPlayer());
            }

            if (is.getType() == Material.valueOf(HubAddons.getInstance().getItemsConfig().getString("HUB-SELECTOR-ITEM.MATERIAL")) && is.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color(HubAddons.getInstance().getItemsConfig().getString("HUB-SELECTOR-ITEM.DISPLAYNAME")))) {
                HubServerInv.openInventory(e.getPlayer());
            }

            if (is.getType() == Material.valueOf(HubAddons.getInstance().getItemsConfig().getString("LINKS-ITEM.MATERIAL")) && is.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color(HubAddons.getInstance().getItemsConfig().getString("LINKS-ITEM.DISPLAYNAME")))) {
                for (String s : HubAddons.getInstance().getConfig().getStringList("LINKS-ITEM.MESSAGE")) {
                    String placeholder = PlaceholderAPI.setPlaceholders(e.getPlayer(), s);
                    e.getPlayer().sendMessage(Utils.color(placeholder));
                }
            }

            if (is.getType() == Material.valueOf(HubAddons.getInstance().getItemsConfig().getString("VISIBILITY-TOGGLE.ON.MATERIAL")) && is.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color(HubAddons.getInstance().getItemsConfig().getString("VISIBILITY-TOGGLE.ON.DISPLAYNAME")))) {
                Bukkit.getOnlinePlayers().forEach(online -> e.getPlayer().hidePlayer(online));

                ItemStack onItemStack = new ItemStack(Material.getMaterial(HubAddons.getInstance().getItemsConfig().getString("VISIBILITY-TOGGLE.OFF.MATERIAL")), HubAddons.getInstance().getItemsConfig().getInt("VISIBILITY-TOGGLE.OFF.AMOUNT"), (short) HubAddons.getInstance().getItemsConfig().getInt("VISIBILITY-TOGGLE.OFF.DATA"));
                ItemMeta onItemMeta = onItemStack.getItemMeta();
                onItemMeta.setDisplayName(Utils.color(HubAddons.getInstance().getItemsConfig().getString("VISIBILITY-TOGGLE.OFF.DISPLAYNAME")));
                onItemStack.setItemMeta(onItemMeta);
                e.getPlayer().getInventory().setItem(HubAddons.getInstance().getItemsConfig().getInt("VISIBILITY-TOGGLE.OFF.SLOT"), onItemStack);
            }

            if (is.getType() == Material.valueOf(HubAddons.getInstance().getItemsConfig().getString("VISIBILITY-TOGGLE.OFF.MATERIAL")) && is.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color(HubAddons.getInstance().getItemsConfig().getString("VISIBILITY-TOGGLE.OFF.DISPLAYNAME")))) {
                Bukkit.getOnlinePlayers().forEach(online -> e.getPlayer().showPlayer(online));

                ItemStack onItemStack = new ItemStack(Material.getMaterial(HubAddons.getInstance().getItemsConfig().getString("VISIBILITY-TOGGLE.ON.MATERIAL")), HubAddons.getInstance().getItemsConfig().getInt("VISIBILITY-TOGGLE.ON.AMOUNT"), (short) HubAddons.getInstance().getItemsConfig().getInt("VISIBILITY-TOGGLE.ON.DATA"));
                ItemMeta onItemMeta = onItemStack.getItemMeta();
                onItemMeta.setDisplayName(Utils.color(HubAddons.getInstance().getItemsConfig().getString("VISIBILITY-TOGGLE.ON.DISPLAYNAME")));
                onItemStack.setItemMeta(onItemMeta);
                e.getPlayer().getInventory().setItem(HubAddons.getInstance().getItemsConfig().getInt("VISIBILITY-TOGGLE.ON.SLOT"), onItemStack);
            }
        }

    }
}
