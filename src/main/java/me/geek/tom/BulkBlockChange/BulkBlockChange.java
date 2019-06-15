package me.geek.tom.BulkBlockChange;

import me.geek.tom.BulkBlockChange.actions.TaskManager;
import me.geek.tom.BulkBlockChange.commands.CommandPosOne;
import me.geek.tom.BulkBlockChange.commands.CommandPosTwo;
import me.geek.tom.BulkBlockChange.commands.CommandSet;
import me.geek.tom.BulkBlockChange.selection.SelectionManager;
import me.geek.tom.BulkBlockChange.util.Perms;
import me.geek.tom.BulkBlockChange.util.PluginLogger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class BulkBlockChange extends JavaPlugin {

    public static BulkBlockChange plugin;

    public TaskManager getManager() {
        return manager;
    }

    private TaskManager manager;

    public SelectionManager getSelectionManager() {
        return selectionManager;
    }

    private SelectionManager selectionManager;

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
        getCommand("pos1").setExecutor(new CommandPosOne());
        getCommand("pos2").setExecutor(new CommandPosTwo());

        logger.debug("Loaded commands!");

        logger.debug("Loading managers and timers...");
        manager = new TaskManager(getServer());
        manager.runTaskTimerAsynchronously(this, 20, 20);

        selectionManager = new SelectionManager(getServer().matchPlayer(""));
        getServer().getPluginManager().registerEvents(selectionManager, this);

        logger.debug("Loaded managers and timers!");

        // End onEnable section
        logger.info("onEnable:exit");
    }
}
