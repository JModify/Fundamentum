package com.modify.fundamentum.config;

import com.modify.fundamentum.Fundamentum;
import com.modify.fundamentum.text.PluginLogger;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.InputStream;

public class ConfigUtil {

    public static void copyConfig(String name){
        Config config = new Config(name);
        if (!config.exists()) {
            InputStream stream = Fundamentum.getPlugin().getResource(name + ".yml");
            Config.copy(stream, config.getFile());
        }
    }

    public static FileConfiguration getConfigByName(String name){
        Config config = new Config(name);
        if(config.exists()){
            return config.getConfig();
        }else{
            PluginLogger.logError("Failed to retrieve config file " + name + ".yml");
            return null;
        }
    }

}
