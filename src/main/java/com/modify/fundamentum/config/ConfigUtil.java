package com.modify.fundamentum.config;

import com.modify.fundamentum.Fundamentum;
import com.modify.fundamentum.text.PlugLogger;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.InputStream;
import java.util.UUID;

/**
 * Config utility used for config management
 */
public class ConfigUtil {

    /**
     * Copies config into it's file to include commenting.
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
            PlugLogger.logError("Failed to retrieve config file " + name + ".yml." +
                    "Contact plugin author.");
            return null;
        }
    }

    /**
     * Retrieve player data file using player uuid.
     * @param playerId player uuid
     * @return file configuration for player's data file.
     */
    public static FileConfiguration getPlayerDataByID(UUID playerId) {
        PlayerData pd = new PlayerData(playerId);
        if (pd.exists()) {
            return pd.getConfig();
        }else{
            PlugLogger.logError("Failed to retrieve player data file " +
                    playerId.toString() + ".yml. Contact plugin author.");
            return null;
        }
    }

}
