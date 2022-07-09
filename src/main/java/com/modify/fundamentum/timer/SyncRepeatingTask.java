package com.modify.fundamentum.timer;

import com.modify.fundamentum.Fundamentum;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class SyncRepeatingTask implements Runnable {

    private int taskId;

    public SyncRepeatingTask() {
        this.taskId = -1;
    }

    public boolean isRunning() {
        return taskId != -1;
    }

    public void cancelTask() {
        if (taskId != -1) {
            Fundamentum.getPlugin().getServer().getScheduler().cancelTask(taskId);
        }
    }

    public void startTask(long startDelay, long interval) {
        if (!isRunning()) {
            JavaPlugin plugin = Fundamentum.getPlugin();
            taskId = plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, this, startDelay, interval);
        }
    }
}
