package com.modify.fundamentum.hook;

import com.modify.fundamentum.text.PlugLogger;
import lombok.Getter;
import org.bukkit.Bukkit;

public abstract class PlugHook {

    /** Whether the plugin is successfully hooked or not */
    @Getter private boolean hooked;

    /** Name of the plugin which is being hooked. */
    private String name;

    /**
     * Initializes a plugin hook.
     * @param name name of plugin to hook.
     */
    public PlugHook(String name) {
        this.hooked = false;
        this.name = name;
    }

    private void check() {
        if (Bukkit.getServer().getPluginManager().getPlugin(name) != null) {
            hooked = true;
            PlugLogger.logInfo(name + " detected. Plugin successfully hooked.");
        }
    }

}
