package es.hulk.addons.commands.lunarstaff;

import es.hulk.addons.utils.CC;
import es.hulk.addons.utils.Utils;
import es.hulk.addons.utils.command.BaseCommand;
import es.hulk.addons.utils.command.Command;
import es.hulk.addons.utils.command.CommandArgs;
import es.hulk.addons.utils.command.Completer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class LunarStaffMainCMD extends BaseCommand {

    @Command(name = "lunarstaff", permission = "hubaddons.admin.lunarstaff", noPerm = "&cNo Permission")

    @Override
    public void onCommand(CommandArgs cmd) {
        Player p = cmd.getPlayer();
        p.sendMessage(CC.CHAT_BAR);
        p.sendMessage(Utils.color("&a&lLunarStaff"));
        p.sendMessage(Utils.color(" "));
        p.sendMessage(Utils.color("&a/lunarstaff enable &7- &fenables the staff modules"));
        p.sendMessage(Utils.color("&a/lunarstaff disable &7- &fdisable the staff modules"));
        p.sendMessage(CC.translate(" "));
        p.sendMessage(Utils.color("&7Remember to run stable 1.7.10 Lunar Client to use Staff Modules"));
        p.sendMessage(CC.CHAT_BAR);
    }

    @Completer(name = "lunarstaff", aliases = "lunarstaff")
    public List<String> testCompleter(CommandArgs args) {
        List<String> list = new ArrayList<String>();
        list.add("enable");
        list.add("disable");
        return list;
    }
}
