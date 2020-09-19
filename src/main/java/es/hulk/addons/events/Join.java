package es.hulk.addons.events;

import com.lunarclient.bukkitapi.LunarClientAPI;
import es.hulk.addons.utils.Utils;
import es.hulk.addons.main.Main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import static com.lunarclient.bukkitapi.object.StaffModule.*;

public class Join implements Listener {

    private final LunarClientAPI lunarClientAPI = LunarClientAPI.getInstance();

    @EventHandler
    public void JoinEvent(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if (p.hasPermission("lunar.utils.staff-modules")) {
            lunarClientAPI.giveAllStaffModules(p);
            p.sendMessage(Utils.color("&8[&bLunarClient&8] &7You have received all Staff-Modules. "));
        }

        if (Main.getInstance().getConfig().getBoolean("BOOLEANS.CLEARINV-ON-JOIN")) {
            p.getInventory().clear();
            p.getInventory().setHelmet(null);
            p.getInventory().setChestplate(null);
            p.getInventory().setLeggings(null);
            p.getInventory().setBoots(null);
        }

        if (Main.getInstance().getConfig().getBoolean("FLY.ENABLED")) {
            if (p.hasPermission("hulk.allow.fly")) {
                p.setAllowFlight(true);
                p.setFlying(true);
            }
        }

        if (Main.getInstance().getConfig().getBoolean("DEFAULT-JOIN-MESSAGE.ENABLED")) {
            e.setJoinMessage(Utils.color(Utils.stringConfig("DEFAULT-JOIN-MESSAGE.MESSAGE")));
        } else {
            e.setJoinMessage("");
        }

        if (Main.getInstance().getConfig().getBoolean("JOIN-MESSAGE.ENABLED")) {
            for (String s : Main.getInstance().getConfig().getStringList("JOIN-MESSAGE.MESSAGE")) {
                String placeholder = PlaceholderAPI.setPlaceholders(p, s);
                p.sendMessage(Utils.color(placeholder));
            }
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                if (Main.getInstance().getItemsConfig().getBoolean("SERVER-SELECTOR-ITEM.ENABLED")) {
                        ItemStack selitem = new ItemStack(Material.getMaterial(Main.getInstance().getItemsConfig().getString("SERVER-SELECTOR-ITEM.MATERIAL")), Main.getInstance().getItemsConfig().getInt("SERVER-SELECTOR-ITEM.AMOUNT"), (short) Main.getInstance().getItemsConfig().getInt("SERVER-SELECTOR-ITEM.DATA"));
                        ItemMeta brujulaMeta = selitem.getItemMeta();
                        brujulaMeta.setDisplayName(Utils.color(Main.getInstance().getItemsConfig().getString("SERVER-SELECTOR-ITEM.DISPLAYNAME")));
                        selitem.setItemMeta(brujulaMeta);
                        p.getInventory().setItem(Main.getInstance().getItemsConfig().getInt("SERVER-SELECTOR-ITEM.SLOT"), selitem);
                }
                if (Main.getInstance().getItemsConfig().getBoolean("LINKS-ITEM.ENABLED")) {
                    ItemStack selitem = new ItemStack(Material.getMaterial(Main.getInstance().getItemsConfig().getString("LINKS-ITEM.MATERIAL")), Main.getInstance().getItemsConfig().getInt("LINKS-ITEM.AMOUNT"), (short) Main.getInstance().getItemsConfig().getInt("LINKS-ITEM.DATA"));
                    ItemMeta brujulaMeta = selitem.getItemMeta();
                    brujulaMeta.setDisplayName(Utils.color(Main.getInstance().getItemsConfig().getString("LINKS-ITEM.DISPLAYNAME")));
                    selitem.setItemMeta(brujulaMeta);
                    p.getInventory().setItem(Main.getInstance().getItemsConfig().getInt("LINKS-ITEM.SLOT"), selitem);
                }
                if (Main.getInstance().getItemsConfig().getBoolean("HUB-SELECTOR-ITEM.ENABLED")) {
                    if (p.hasPermission("hubcore.giveitems.selector")) {
                        ItemStack hubitem = new ItemStack(Material.getMaterial(Main.getInstance().getItemsConfig().getString("HUB-SELECTOR-ITEM.MATERIAL")), Main.getInstance().getItemsConfig().getInt("HUB-SELECTOR-ITEM.AMOUNT"), (short) Main.getInstance().getItemsConfig().getInt("HUB-SELECTOR-ITEM.DATA"));
                        ItemMeta brujulaMeta = hubitem.getItemMeta();
                        brujulaMeta.setDisplayName(Utils.color(Main.getInstance().getItemsConfig().getString("HUB-SELECTOR-ITEM.DISPLAYNAME")));
                        hubitem.setItemMeta(brujulaMeta);
                        p.getInventory().setItem(Main.getInstance().getItemsConfig().getInt("HUB-SELECTOR-ITEM.SLOT"), hubitem);
                    }
                }
            }
        }.runTaskLater(Main.getInstance(), 5);

    }

}


