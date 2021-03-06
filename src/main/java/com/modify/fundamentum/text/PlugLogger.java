package com.modify.fundamentum.text;

import com.modify.fundamentum.Fundamentum;
import lombok.Getter;
import org.bukkit.Bukkit;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Logger class used for communication between the plugin
 * and server console.
 */
public class PlugLogger {

    /** Retrieves the bukkit logger */
    @Getter private static final Logger logger = Fundamentum.getPlugin().getLogger();

    /**
     * Log an error to the server console.
     * @param message message to send.
     */
    public static void logError(String message) {
        logger.severe(message);
    }

    /**
     * Log a warning to the server console.
     * @param message message to send.
     */
    public static void logWarning(String message) {
        logger.log(Level.WARNING, message);
    }

    /**
     * Log an info message to the server console.
     * @param message message to send.
     */
    public static void logInfo(String message){
        logger.info(message);
    }

}
