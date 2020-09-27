package es.hulk.addons.commands.lunarstaff;

import com.lunarclient.bukkitapi.LunarClientAPI;
import es.hulk.addons.HubAddons;
import es.hulk.addons.utils.Utils;
import es.hulk.addons.utils.command.BaseCommand;
import es.hulk.addons.utils.command.Command;
import es.hulk.addons.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class LunarStaffDisableCMD extends BaseCommand {

    @Command(name = "lunarstaff.disable", permission = "hubaddons.admin.lunarstaff")

    @Override
    public void onCommand(CommandArgs cmd) {
        Player p = cmd.getPlayer();
        LunarClientAPI.getInstance().disableAllStaffModules(p);
        p.sendMessage(Utils.color(HubAddons.getInstance().getConfig().getString("LUNARCLIENT.STAFFMODULES.COMMAND.DISABLE-MESSAGE")));
    }
}
