package com.modify.fundamentum.hook;

import com.modify.fundamentum.Fundamentum;
import com.modify.fundamentum.text.PlugLogger;
import lombok.Getter;
import org.bukkit.Bukkit;

public abstract class PlugHook {

    /** Whether the plugin is successfully hooked or not */
    @Getter private boolean hooked;

    /** Name of the plugin which is being hooked. */
    private String name;

    /** Does this plugin depends on this hook to function properly */
    private boolean depends;

    /**
     * Initializes a plugin hook.
     * @param name name of plugin to hook.
     */
    public PlugHook(String name, boolean depends) {
        this.hooked = false;
        this.name = name;
        this.depends = depends;
    }

    public void check() {
        if (Bukkit.getServer().getPluginManager().getPlugin(name) != null) {
            hooked = true;
            PlugLogger.logInfo(name + " detected. Plugin successfully hooked.");
        } else {
            if (depends) {
                PlugLogger.logError("Failed to hook into dependency " + name + ". Plugin shutting down.");
                Bukkit.getServer().getPluginManager().disablePlugin(Fundamentum.getPlugin());
            }
        }
    }

}
