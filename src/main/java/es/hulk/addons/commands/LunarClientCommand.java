package es.hulk.addons.commands;

import com.lunarclient.bukkitapi.LunarClientAPI;
import es.hulk.addons.HubAddons;
import es.hulk.addons.utils.CC;
import es.hulk.addons.utils.Utils;
import es.hulk.addons.utils.command.BaseCommand;
import es.hulk.addons.utils.command.Command;
import es.hulk.addons.utils.command.CommandArgs;
import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;


public class LunarClientCommand extends BaseCommand {
    @Command(name = "lunarclient",aliases = {"lc", "lc-api", "lcapi"})

    @Override
    public void onCommand(CommandArgs cmd) {
        Player player = cmd.getPlayer();

        player.sendMessage(CC.CHAT_BAR);
        player.sendMessage(CC.translate("&b&lLunarClient &8- &7v"));
        player.sendMessage(CC.translate(" "));
        player.sendMessage(CC.translate("&3 ▶ &bPlayers using LunarClient&8: &f" + nonAntiCheatPlayers().size()));
        if (nonAntiCheatPlayers().isEmpty()) {
            player.sendMessage(CC.translate("&cNo players with LunarClient [AC-OFF]"));
        } else {
            player.sendMessage(CC.translate(StringUtils.join(nonAntiCheatPlayers(), "\n")));
        }
        player.sendMessage(CC.CHAT_BAR);
    }

    private List<String> nonAntiCheatPlayers() {
        List<String> players = new ArrayList<>();
        for (Player player : Utils.getOnlinePlayers()) {
            if (LunarClientAPI.getInstance().isRunningLunarClient(player)) {
                if (!LunarClientAPI.getInstance().isRunningAntiCheat(player)) {
                    players.add(CC.translate(" &7 ➥ " + player.getName()));
                }
            }
        }
        return players;
    }
}
