package com.modify.fundamentum.config;

import com.modify.fundamentum.Fundamentum;
import com.modify.fundamentum.text.PluginLogger;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.InputStream;

/**
 * Config utility used for config management
 */
public class ConfigUtil {

    /**
     * Copy config to file to include commenting.
     * @param name name of config to copy.
     */
    public static void copyConfig(String name){
        Config config = new Config(name);
        if (!config.exists()) {
            InputStream stream = Fundamentum.getPlugin().getResource(name + ".yml");
            Config.copy(stream, config.getFile());
        }
    }

    /**
     * Retrieve config instance using config name.
     * @param name config to retrieve.
     * @return retrieves the config using name.
     */
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
