package me.geek.tom.BulkBlockChange;

import me.geek.tom.BulkBlockChange.actions.TaskManager;
import me.geek.tom.BulkBlockChange.commands.CommandSet;
import me.geek.tom.BulkBlockChange.util.Perms;
import me.geek.tom.BulkBlockChange.util.PluginLogger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class BulkBlockChange extends JavaPlugin {

    public static BulkBlockChange plugin;

    private TaskManager manager;

    public PluginLogger obtainLogger() {
        return logger;
    }

    private PluginLogger logger;

    @Override
    public void onEnable() {
        plugin = this;
        logger = new PluginLogger(Bukkit.getLogger(), true, "BulkBlockChange");
        logger.info("onEnable:enter");
        // onEnable section

        // Load permissions
        logger.debug("loading permissions...");

        Perms.load();

        logger.debug("Loaded permissions!");

        logger.debug("Loading commands...");

        getCommand("set").setExecutor(new CommandSet());

        logger.debug("Loaded commands!");

        manager = new TaskManager(getServer());
        manager.runTaskTimerAsynchronously(this, 20, 20);

        // End onEnable section
        logger.info("onEnable:exit");
    }
}
