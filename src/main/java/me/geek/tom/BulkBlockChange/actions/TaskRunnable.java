package me.geek.tom.BulkBlockChange.actions;

import org.bukkit.scheduler.BukkitRunnable;

public class TaskRunnable extends BukkitRunnable {

    private TaskExecutor executor;

    public TaskManager manager;

    public TaskRunnable(TaskExecutor executor, TaskManager manager) {
        super();

        this.manager = manager;
        this.executor = executor;
    }

    public void run() {

        executor.runOneAction();

        manager.taskDone(this);

    }

}
