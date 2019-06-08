package me.geek.tom.BulkBlockChange.actions;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.scheduler.BukkitRunnable;

public class TaskManager extends BukkitRunnable {

    private Server server;

    public TaskManager(Server server) {
        super();
        this.server = server;
    }

    public void run() {
        server.broadcast(ChatColor.LIGHT_PURPLE + "Running operations", "");
    }
}
