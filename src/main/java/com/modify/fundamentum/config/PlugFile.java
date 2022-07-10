package com.modify.fundamentum.config;

import com.modify.fundamentum.Fundamentum;
import com.modify.fundamentum.text.PlugLogger;
import lombok.NonNull;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public abstract class PlugFile {

    private String name;

    private FileConfiguration yaml;
    private File file;

    public PlugFile(String name) {
        this.name = name;
        startup();
    }

    public String getFileName() {
        return name.toLowerCase() + ".yml";
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
