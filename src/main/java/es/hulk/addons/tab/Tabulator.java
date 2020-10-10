package es.hulk.addons.tab;

import cc.outlast.tablist.ITablist;
import cc.outlast.tablist.OutlastTab;
import cc.outlast.tablist.TablistElement;
import es.hulk.addons.HubAddons;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.Arrays;
import java.util.List;

public class Tabulator implements Listener, ITablist {


    @Override
    public String getHeader(Player player) {
        String header = HubAddons.getInstance().getConfig().getString("TAB.HEADER");
        String papi = PlaceholderAPI.setPlaceholders(player, header);
        return papi;
    }

    @Override
    public String getFooter(Player player) {
        String footer = HubAddons.getInstance().getConfig().getString("TAB.FOOTER");
        String papi = PlaceholderAPI.setPlaceholders(player, footer);
        return papi;
    }

    @Override
    public List<TablistElement> getElements(Player player) {
        if (HubAddons.getInstance().getTabConfig().getBoolean("TAB.ENABLED")) {
            return Arrays.asList(

                    //PRIMERA LINEA DE TAB
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.LEFT.1"), 1),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.LEFT.2"), 2),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.LEFT.3"), 3),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.LEFT.4"), 4),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.LEFT.5"), 5),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.LEFT.6"), 6),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.LEFT.7"), 7),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.LEFT.8"), 8),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.LEFT.9"), 9),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.LEFT.10"), 10),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.LEFT.11"), 11),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.LEFT.12"), 12),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.LEFT.13"), 13),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.LEFT.14"), 14),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.LEFT.15"), 15),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.LEFT.16"), 16),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.LEFT.17"), 17),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.LEFT.18"), 18),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.LEFT.19"), 19),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.LEFT.20"), 20),

                    //EL MEDIO DEL TAB
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.MIDDLE.1"), 21),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.MIDDLE.2"), 22),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.MIDDLE.3"), 23),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.MIDDLE.4"), 24),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.MIDDLE.5"), 25),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.MIDDLE.6"), 26),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.MIDDLE.7"), 27),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.MIDDLE.8"), 28),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.MIDDLE.9"), 29),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.MIDDLE.10"), 30),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.MIDDLE.11"), 31),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.MIDDLE.12"), 32),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.MIDDLE.13"), 33),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.MIDDLE.14"), 34),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.MIDDLE.15"), 35),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.MIDDLE.16"), 36),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.MIDDLE.17"), 37),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.MIDDLE.18"), 38),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.MIDDLE.19"), 39),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.MIDDLE.20"), 40),

                    //RIGHT PART FOR THE TAB

                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.RIGHT.1"), 41),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.RIGHT.2"), 42),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.RIGHT.3"), 43),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.RIGHT.4"), 44),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.RIGHT.5"), 45),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.RIGHT.6"), 46),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.RIGHT.7"), 47),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.RIGHT.8"), 48),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.RIGHT.9"), 49),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.RIGHT.10"), 50),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.RIGHT.11"), 51),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.RIGHT.12"), 52),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.RIGHT.13"), 53),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.RIGHT.14"), 54),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.RIGHT.15"), 55),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.RIGHT.16"), 56),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.RIGHT.17"), 57),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.RIGHT.18"), 58),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.RIGHT.19"), 59),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.RIGHT.20"), 60),

                    //FAR RIGHT TAB
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.FAR-RIGHT.1"), 61),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.FAR-RIGHT.2"), 62),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.FAR-RIGHT.3"), 63),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.FAR-RIGHT.4"), 64),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.FAR-RIGHT.5"), 65),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.FAR-RIGHT.6"), 66),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.FAR-RIGHT.7"), 67),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.FAR-RIGHT.8"), 68),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.FAR-RIGHT.9"), 69),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.FAR-RIGHT.10"), 70),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.FAR-RIGHT.11"), 71),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.FAR-RIGHT.12"), 72),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.FAR-RIGHT.13"), 73),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.FAR-RIGHT.14"), 74),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.FAR-RIGHT.15"), 75),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.FAR-RIGHT.16"), 76),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.FAR-RIGHT.17"), 77),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.FAR-RIGHT.18"), 78),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.FAR-RIGHT.19"), 79),
                    new TablistElement(HubAddons.getInstance().getTabConfig().getString("TAB.FAR-RIGHT.20"), 80)

            );
        } else {
            return null;
        }
    }
}

