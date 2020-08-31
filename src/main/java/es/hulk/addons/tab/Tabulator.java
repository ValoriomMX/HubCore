package es.hulk.addons.tab;

import es.hulk.addons.main.Main;
import es.hulk.addons.utils.Utils;
import org.bukkit.entity.Player;
import org.imanity.framework.bukkit.tablist.ImanityTabAdapter;
import org.imanity.framework.bukkit.tablist.utils.BufferedTabObject;
import org.imanity.framework.bukkit.tablist.utils.TabColumn;

import java.util.HashSet;
import java.util.Set;

public class Tabulator implements ImanityTabAdapter {
    @Override

    /*
    FIX TAB.ENABLED BOOLEAN
     */
    public Set<BufferedTabObject> getSlots(Player player) {
        if (Main.getInstance().getTabConfig().getBoolean("TAB.ENABLED")) {
            Set<BufferedTabObject> toReturn = new HashSet<>();
            toReturn.add(
                    new BufferedTabObject()
                            .text(Utils.color(Main.getInstance().getTabConfig().getString("TAB.LEFT.1")))
                            .column(TabColumn.LEFT)
                            .slot(1)
            );
            toReturn.add(
                    new BufferedTabObject()
                            .text(Utils.color(Main.getInstance().getTabConfig().getString("TAB.LEFT.2")))
                            .column(TabColumn.LEFT)
                            .slot(2)
            );
            return toReturn;
        } else {
            return null;
        }
    }

    @Override
    public String getFooter() {
        if (Main.getInstance().getConfig().getBoolean("FOOTER.ENABLED")) {
            String footer = Utils.color(Utils.stringConfig("FOOTER.MESSAGE"));
            return footer;
        }
        return null;
    }

    @Override
    public String getHeader() {
        if (Main.getInstance().getConfig().getBoolean("HEADER.ENABLED")) {
            String header = Utils.color(Utils.stringConfig("HEADER.MESSAGE"));
            return header;
        }
        return null;
    }
}
