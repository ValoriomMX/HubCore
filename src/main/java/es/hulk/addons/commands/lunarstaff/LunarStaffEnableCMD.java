package es.hulk.addons.commands.lunarstaff;

import com.lunarclient.bukkitapi.LunarClientAPI;
import es.hulk.addons.HubAddons;
import es.hulk.addons.utils.Utils;
import es.hulk.addons.utils.command.BaseCommand;
import es.hulk.addons.utils.command.Command;
import es.hulk.addons.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class LunarStaffEnableCMD extends BaseCommand {
    @Command(name = "lunarstaff.enable", permission = "hubaddons.admin.lunarstaff", noPerm = "&cNo Permission")

    @Override
    public void onCommand(CommandArgs cmd) {

        Player p = cmd.getPlayer();
        LunarClientAPI.getInstance().giveAllStaffModules(p);
        p.sendMessage(Utils.color(HubAddons.getInstance().getConfig().getString("LUNARCLIENT.STAFFMODULES.COMMAND.ENABLE-MESSAGE")));

    }
}
