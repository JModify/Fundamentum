package com.modify.fundamentum;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Fundamentum is a bukkit library project which offers a range of
 * utility classes that are helpful when creating bukkit plugins.
 */
public class Fundamentum {

    /** Bukkit plugin currently working with this library */
    private static JavaPlugin plugin;

    /**
     * Get the plugin this library is currently working with.
     * @return the plugin being worked with.
     */
    public static JavaPlugin getPlugin() {
        return plugin;
    }

    /**
     * Set the library of which this plugin is currently working with.
     * @param plugin plugin to set
     */
    public static void setPlugin(final JavaPlugin plugin) {
        Fundamentum.plugin = plugin;
    }
}
