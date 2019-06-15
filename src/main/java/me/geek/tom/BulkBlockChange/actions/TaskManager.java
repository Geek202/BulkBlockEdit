package me.geek.tom.BulkBlockChange.actions;

// import org.bukkit.ChatColor;
import com.google.common.collect.Lists;
import me.geek.tom.BulkBlockChange.BulkBlockChange;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class TaskManager extends BukkitRunnable {

    private Server server;

    private List<TaskRunnable> runnableList;

    public TaskManager(Server server) {
        super();
        this.server = server;
        runnableList = Lists.newArrayList();
    }

    public void queueOperation(TaskRunnable taskRunnable) {
        runnableList.add(taskRunnable);
        taskRunnable.runTask(BulkBlockChange.plugin);
    }

    public void run() {
        // server.broadcastMessage(ChatColor.LIGHT_PURPLE + "Running operations...");
    }

    public void taskDone(TaskRunnable runnable) {
        server.broadcastMessage(ChatColor.LIGHT_PURPLE + "Task complete!");
        runnableList.remove(runnable);
    }
}
