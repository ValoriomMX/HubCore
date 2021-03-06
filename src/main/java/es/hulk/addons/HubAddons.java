package es.hulk.addons;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import es.hulk.addons.commands.*;
import es.hulk.addons.commands.gamemode.*;
import es.hulk.addons.events.*;
import es.hulk.addons.inventory.HubServerInv;
import es.hulk.addons.inventory.InvClickEvent;
import es.hulk.addons.inventory.SelectorInv;
import es.hulk.addons.queue.QueueManager;
import es.hulk.addons.providers.ScoreboardProvider;
import es.hulk.addons.utils.command.CommandFramework;
import io.github.thatkawaiisam.assemble.Assemble;
import io.github.thatkawaiisam.assemble.AssembleStyle;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.File;
import java.io.IOException;

public class HubAddons extends JavaPlugin implements PluginMessageListener {

    private File scoreboardFile;
    private FileConfiguration scoreboardConfig;

    private File tabFile;
    private FileConfiguration tabConfig;

    private File itemsFile;
    private FileConfiguration itemsConfig;

    private File menusFile;
    private FileConfiguration menusConfig;

    private CommandFramework commandFramework;
    @Getter
    public static HubAddons instance;

    @Getter public static QueueManager queue;

    @Override
    public void onEnable() {

        instance = this;
        commandFramework = new CommandFramework(this);

        this.saveDefaultConfig();

        createScoreboardConfig();
        createItemsConfig();
        createMenusConfig();
        createTabConfig();

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);

        registerEvents();
        registerCMDs();
        //registerTab();
        registerScoreboard();

    }

    public void registerScoreboard() {
        if (getConfig().getBoolean("BOOLEANS.SCOREBOARD")) {
            Assemble assemble = new Assemble(this, new ScoreboardProvider());
            assemble.setTicks(2L);
            assemble.setAssembleStyle(AssembleStyle.MODERN);
        }
    }

    public void registerTab() {
        /*if (getConfig().getBoolean("BOOLEANS.TAB")) {
            new OutlastTab(this, new TablistProvider(), 40L);
        }*/
    }

    public void registerInstances() {
        queue = new QueueManager();
    }

    @Override
    public void onDisable() {
    }

    public static HubAddons getInstance() {
        return instance;
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) {
            return;
        }
        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();

    }

    public void registerCMDs() {

        commandFramework.registerCommands(new FlyCMD());
        commandFramework.registerCommands(new ReloadCMD());
        commandFramework.registerCommands(new DebugCMD());
        commandFramework.registerCommands(new MainCMD());
        commandFramework.registerCommands(new HelpCMD());
        commandFramework.registerCommands(new ServersCMD());
        commandFramework.registerCommands(new HealCMD());
        commandFramework.registerCommands(new FeedCMD());

        commandFramework.registerCommands(new GamemodeCMD());
        commandFramework.registerCommands(new SurvivalCMD());
        commandFramework.registerCommands(new CreativeCMD());
        commandFramework.registerCommands(new AdventureCMD());
        commandFramework.registerCommands(new SpectatorCMD());
    }

    public void registerEvents() {

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Bukkit.getPluginManager().registerEvents(new Quit(), this);
            Bukkit.getPluginManager().registerEvents(new SelectorInv(), this);
            Bukkit.getPluginManager().registerEvents(new Join(), this);
            Bukkit.getPluginManager().registerEvents(new Interact(), this);
            Bukkit.getPluginManager().registerEvents(new InvClickEvent(), this);
            Bukkit.getPluginManager().registerEvents(new HubServerInv(), this);
            Bukkit.getPluginManager().registerEvents(new Chat(), this);
            Bukkit.getPluginManager().registerEvents(new Booleans(), this);
        } else {
            throw new RuntimeException("Could not find PlaceholderAPI!! Plugin can not work without it!");
        }
    }

    public FileConfiguration getScoreboardConfig() {
        return this.scoreboardConfig;
    }

    public void createScoreboardConfig() {
        scoreboardFile = new File(getDataFolder(), "scoreboard.yml");
        if (!scoreboardFile.exists()) {
            scoreboardFile.getParentFile().mkdirs();
            saveResource("scoreboard.yml", false);
        }
        scoreboardConfig = new YamlConfiguration();
        try {
            scoreboardConfig.load(scoreboardFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getTabConfig() {
        return this.tabConfig;
    }

    public void createTabConfig() {
        tabFile = new File(getDataFolder(), "tab.yml");
        if (!tabFile.exists()) {
            tabFile.getParentFile().mkdirs();
            saveResource("tab.yml", false);
        }
        tabConfig = new YamlConfiguration();
        try {
            tabConfig.load(tabFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getItemsConfig() {
        return itemsConfig;
    }

    public void createItemsConfig() {
        itemsFile = new File(getDataFolder(), "items.yml");
        if (!itemsFile.exists()) {
            itemsFile.getParentFile().mkdirs();
            saveResource("items.yml", false);
        }
        itemsConfig = new YamlConfiguration();
        try {
            itemsConfig.load(itemsFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getMenusConfig() {
        return this.menusConfig;
    }

    public void createMenusConfig() {
        menusFile = new File(getDataFolder(), "menus.yml");
        if (!menusFile.exists()) {
            menusFile.getParentFile().mkdirs();
            saveResource("menus.yml", false);
        }
        menusConfig = new YamlConfiguration();
        try {
            menusConfig.load(menusFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }


    public void sendToServer(Player p, String server) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        try {
            out.writeUTF("Connect");
            out.writeUTF(server);
        } catch (Exception e) {
            System.out.println("Error while connecting to server. The error was: " + e.getMessage());
            e.printStackTrace();
        }
        p.sendPluginMessage(this, "BungeeCord", out.toByteArray());
    }

    public CommandFramework getCommandFramework() {
        return commandFramework;
    }

    public void setCommandFramework(CommandFramework commandFramework) {
        this.commandFramework = commandFramework;
    }
}
