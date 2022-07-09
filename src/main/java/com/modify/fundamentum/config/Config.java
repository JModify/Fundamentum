package com.modify.fundamentum.config;

import com.modify.fundamentum.Fundamentum;
import com.modify.fundamentum.text.PlugLogger;
import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.logging.Level;

public abstract class Config {

    private FileConfiguration yaml;
    private File file;

    public Config() {
        startup();
    }

    public String getFileName() {
        return getClass().getSimpleName().toLowerCase(Locale.ROOT) + ".yml";
    }

    private void startup() {
        file = new File(Fundamentum.getPlugin().getDataFolder(), getFileName());
        createIfNotExists();

        reload();
    }

    public void reload() {
        if (file == null)
            startup();

        yaml = YamlConfiguration.loadConfiguration(file);
    }

    public @NonNull FileConfiguration get() {
        if (yaml == null)
            reload();

        return yaml;
    }

    public boolean save() {
        if (file == null || yaml == null)
            reload();

        try {
            yaml.save(file);

            return true;
        } catch (IOException e) {
            PlugLogger.logError("Failed to save file " + getFileName() + " to " + e.getMessage());
            e.printStackTrace();

            return false;
        }
    }

    private void createIfNotExists() {
        if (!file.exists())
            Fundamentum.getPlugin().saveResource(getFileName(), false);
    }


}
