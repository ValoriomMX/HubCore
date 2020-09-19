package es.hulk.addons.utils.command;

import es.hulk.addons.main.Main;

/**
 * The type Base command.
 */
public abstract class BaseCommand {

    /**
     * The Plugin.
     */
    public Main plugin = Main.getInstance();

    /**
     * Instantiates a new Base command.
     */
    public BaseCommand() {
        this.plugin.getCommandFramework().registerCommands(this);
    }

    /**
     * On command.
     *
     * @param cmd the cmd
     */
    public abstract void onCommand(CommandArgs cmd);
}
