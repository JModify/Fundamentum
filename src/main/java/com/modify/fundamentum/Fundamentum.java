package com.modify.fundamentum;

import org.bukkit.plugin.java.JavaPlugin;

public class Fundamentum {

    private static JavaPlugin plugin;

    public static JavaPlugin getPlugin() {
        return plugin;
    }

    public static void setPlugin(final JavaPlugin plugin) {
        Fundamentum.plugin = plugin;
    }
}
