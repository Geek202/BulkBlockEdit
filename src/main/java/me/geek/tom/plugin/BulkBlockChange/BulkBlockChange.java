package me.geek.tom.plugin.BulkBlockChange;

import me.geek.tom.plugin.BulkBlockChange.util.Perms;
import me.geek.tom.plugin.BulkBlockChange.util.PluginLogger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class BulkBlockChange extends JavaPlugin {

    public static BulkBlockChange plugin;

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

        // End onEnable section
        logger.info("onEnable:exit");
    }
}
