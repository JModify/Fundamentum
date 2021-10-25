package com.modify.fundamentum.text;

import lombok.Getter;
import org.bukkit.Bukkit;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PluginLogger {

    @Getter
    private static final Logger logger = Bukkit.getLogger();

    public static void logError(String message) {
        logger.severe(message);
    }

    public static void logWarning(String message) {
        logger.log(Level.WARNING, message);
    }

    public static void logInfo(String message){
        logger.info(message);
    }

}
