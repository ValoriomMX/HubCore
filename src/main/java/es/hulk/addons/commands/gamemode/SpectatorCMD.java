package es.hulk.addons.commands.gamemode;

import es.hulk.addons.utils.Utils;
import es.hulk.addons.utils.command.BaseCommand;
import es.hulk.addons.utils.command.Command;
import es.hulk.addons.utils.command.CommandArgs;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class SpectatorCMD extends BaseCommand {

    @Command(name = "gamemode.spectator", aliases = "spectator", permission = "hubaddons.admin.gamemode", noPerm = "&cNo Permission")

    @Override
    public void onCommand(CommandArgs cmd) {

        Player p = cmd.getPlayer();
        p.setGameMode(GameMode.SPECTATOR);
        p.sendMessage(Utils.color(Utils.stringConfig("GAMEMODE.SPECTATOR")));

    }
}
