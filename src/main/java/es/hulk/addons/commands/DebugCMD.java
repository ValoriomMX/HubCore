package es.hulk.addons.commands;

import es.hulk.addons.utils.command.BaseCommand;
import es.hulk.addons.utils.command.Command;
import es.hulk.addons.utils.command.CommandArgs;
import me.joeleoli.portal.shared.queue.Queue;
import org.bukkit.entity.Player;

public class DebugCMD extends BaseCommand {

    @Command(name = "debugcmd", permission = "need.to.be.opped", noPerm = "&cNo Permission")

    @Override
    public void onCommand(CommandArgs cmd) {
        Player player = cmd.getPlayer();
        Queue queue = Queue.getByPlayer(player.getUniqueId());
        player.sendMessage("You are currently position " + queue.getPosition(player.getUniqueId()) + " out of " + queue.getPlayers().size() + " in the " + queue.getName() + " queue!");
    }
}
