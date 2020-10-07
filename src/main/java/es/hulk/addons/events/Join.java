package es.hulk.addons.events;

import com.lunarclient.bukkitapi.LunarClientAPI;
import es.hulk.addons.HubAddons;
import es.hulk.addons.utils.Utils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class Join implements Listener {

    private final LunarClientAPI lunarClientAPI = LunarClientAPI.getInstance();

    @EventHandler
    public void JoinEvent(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if (p.hasPermission("LUNARCLIENT.STAFFMODULES.ENABLE-ON-JOIN")) {
            lunarClientAPI.giveAllStaffModules(p);
            p.sendMessage(Utils.color("&8[&bLunarClient&8] &7You have received all Staff-Modules. "));
        }

        if (HubAddons.getInstance().getConfig().getBoolean("BOOLEANS.CLEARINV-ON-JOIN")) {
            p.getInventory().clear();
            p.getInventory().setHelmet(null);
            p.getInventory().setChestplate(null);
            p.getInventory().setLeggings(null);
            p.getInventory().setBoots(null);
        }

        if (HubAddons.getInstance().getConfig().getBoolean("FLY.ENABLED")) {
            if (p.hasPermission("hulk.allow.fly")) {
                p.setAllowFlight(true);
                p.setFlying(true);
            }
        }

        if (HubAddons.getInstance().getConfig().getBoolean("DEFAULT-JOIN-MESSAGE.ENABLED")) {
            e.setJoinMessage(Utils.color(Utils.stringConfig("DEFAULT-JOIN-MESSAGE.MESSAGE")));
        } else {
            e.setJoinMessage("");
        }

        if (HubAddons.getInstance().getConfig().getBoolean("JOIN-MESSAGE.ENABLED")) {
            for (String s : HubAddons.getInstance().getConfig().getStringList("JOIN-MESSAGE.MESSAGE")) {
                String placeholder = PlaceholderAPI.setPlaceholders(p, s);
                p.sendMessage(Utils.color(placeholder));
            }
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                if (HubAddons.getInstance().getItemsConfig().getBoolean("SERVER-SELECTOR-ITEM.ENABLED")) {
                    ItemStack selitem = new ItemStack(Material.getMaterial(HubAddons.getInstance().getItemsConfig().getString("SERVER-SELECTOR-ITEM.MATERIAL")), HubAddons.getInstance().getItemsConfig().getInt("SERVER-SELECTOR-ITEM.AMOUNT"), (short) HubAddons.getInstance().getItemsConfig().getInt("SERVER-SELECTOR-ITEM.DATA"));
                    ItemMeta brujulaMeta = selitem.getItemMeta();
                    brujulaMeta.setDisplayName(Utils.color(HubAddons.getInstance().getItemsConfig().getString("SERVER-SELECTOR-ITEM.DISPLAYNAME")));
                    selitem.setItemMeta(brujulaMeta);
                    p.getInventory().setItem(HubAddons.getInstance().getItemsConfig().getInt("SERVER-SELECTOR-ITEM.SLOT"), selitem);
                }
                if (HubAddons.getInstance().getItemsConfig().getBoolean("LINKS-ITEM.ENABLED")) {
                    ItemStack selitem = new ItemStack(Material.getMaterial(HubAddons.getInstance().getItemsConfig().getString("LINKS-ITEM.MATERIAL")), HubAddons.getInstance().getItemsConfig().getInt("LINKS-ITEM.AMOUNT"), (short) HubAddons.getInstance().getItemsConfig().getInt("LINKS-ITEM.DATA"));
                    ItemMeta brujulaMeta = selitem.getItemMeta();
                    brujulaMeta.setDisplayName(Utils.color(HubAddons.getInstance().getItemsConfig().getString("LINKS-ITEM.DISPLAYNAME")));
                    selitem.setItemMeta(brujulaMeta);
                    p.getInventory().setItem(HubAddons.getInstance().getItemsConfig().getInt("LINKS-ITEM.SLOT"), selitem);
                }
                if (HubAddons.getInstance().getItemsConfig().getBoolean("HUB-SELECTOR-ITEM.ENABLED")) {
                    if (p.hasPermission("hubcore.giveitems.selector")) {
                        ItemStack hubitem = new ItemStack(Material.getMaterial(HubAddons.getInstance().getItemsConfig().getString("HUB-SELECTOR-ITEM.MATERIAL")), HubAddons.getInstance().getItemsConfig().getInt("HUB-SELECTOR-ITEM.AMOUNT"), (short) HubAddons.getInstance().getItemsConfig().getInt("HUB-SELECTOR-ITEM.DATA"));
                        ItemMeta brujulaMeta = hubitem.getItemMeta();
                        brujulaMeta.setDisplayName(Utils.color(HubAddons.getInstance().getItemsConfig().getString("HUB-SELECTOR-ITEM.DISPLAYNAME")));
                        hubitem.setItemMeta(brujulaMeta);
                        p.getInventory().setItem(HubAddons.getInstance().getItemsConfig().getInt("HUB-SELECTOR-ITEM.SLOT"), hubitem);
                    }
                }
            }
        }.runTaskLater(HubAddons.getInstance(), 5);

    }

}


