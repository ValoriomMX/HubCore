package es.hulk.addons.utils;

import es.hulk.addons.HubAddons;
import org.apache.commons.lang.StringEscapeUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static void sendConsole(String message) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static void broadcast(String message) {
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static void clearchat() {
        for (int i = 0; i < 100; i++) {
            broadcast("");
        }
    }

    public List<String> translateFromArray(List<String> text) {
        List<String> messages = new ArrayList<String>();
        for (String string : text) {
            messages.add(this.translateFromString(string));
        }
        return messages;
    }

    public String translateFromString(String text) {
        return StringEscapeUtils.unescapeJava(ChatColor.translateAlternateColorCodes('&', text));
    }

    public static void noPerm(Player p) {
        p.sendMessage(Utils.color(HubAddons.getInstance().getConfig().getString("NO-PERMISSION")));
    }

    public static String stringConfig(String path) {
        return HubAddons.getInstance().getConfig().getString(path);
    }

    public static List<Player> getOnlinePlayers() {
        List<Player> players = new ArrayList<>();
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            players.add(player);
        }
        return players;
    }
}
