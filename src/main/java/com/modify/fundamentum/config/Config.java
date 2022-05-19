package com.modify.fundamentum.config;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Config file object used for easy configuration management.
 */
public class Config
{
    private final String n;
    private FileConfiguration fc;
    private File file;
    private final JavaPlugin plugin;

    public static List<Config> configs;

    public Config(final String n) {
        this.plugin = JavaPlugin.getProvidingPlugin(this.getClass());
        this.n = n;
        Config.configs.add(this);
    }

    public static void copy(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        if (this.n == null) {
            try {
                throw new Exception();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.n;
    }

    public JavaPlugin getInstance() {
        if (this.plugin == null) {
            try {
                throw new Exception();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.plugin;
    }

    public static Config getConfig(final String n) {
        for (final Config c : Config.configs) {
            if (c.getName().equals(n)) {
                return c;
            }
        }
        return new Config(n);
    }

    public boolean delete() {
        return this.getFile().delete();
    }

    public boolean exists() {
        if (this.fc == null || this.file == null) {
            final File temp = new File(this.getDataFolder(), String.valueOf(this.getName()) + ".yml");
            if (!temp.exists()) {
                return false;
            }
            this.file = temp;
        }
        return true;
    }

    public File getFile() {
        if (this.file == null) {
            this.file = new File(this.getDataFolder(), String.valueOf(this.getName() + ".yml"));
            if (!this.file.exists()) {
                try {
                    this.file.createNewFile();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return this.file;
    }

    public FileConfiguration getConfig() {
        if (this.fc == null) {
            this.fc = (FileConfiguration)YamlConfiguration.loadConfiguration(this.getFile());
        }
        return this.fc;
    }

    public File getDataFolder() {
        final File dir = new File(Config.class.getProtectionDomain().getCodeSource().getLocation().getPath().replaceAll("%20", " "));
        final File d = new File(dir.getParentFile().getPath(), this.getInstance().getName());
        if (!d.exists()) {
            d.mkdirs();
        }
        return d;
    }

    public void reload() {
        if (this.file == null) {
            this.file = new File(this.getDataFolder(), String.valueOf(this.getName() + ".yml"));
            if (!this.file.exists()) {
                try {
                    this.file.createNewFile();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            this.fc = (FileConfiguration)YamlConfiguration.loadConfiguration(this.file);
            final File defConfigStream = new File(this.plugin.getDataFolder(), String.valueOf(this.getName()) + ".yml");
            if (defConfigStream != null) {
                final YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
                this.fc.setDefaults((Configuration)defConfig);
            }
        }
    }

    public void saveConfig() {
        try {
            this.getConfig().save(this.getFile());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        Config.configs = new ArrayList<Config>();
    }
}