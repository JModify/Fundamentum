package com.modify.fundamentum.text;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;

/**
 * Plugin utility class used for a variety of things.
 */
public class PlugUtil {

    /**
     * Register a command in the bukkit command map without having to specify it
     * in the plugins.yml.
     * @param command bukkit command to register.
     */
    public static void registerCommand(final BukkitCommand command) {
        try {
            final Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            commandMapField.setAccessible(true);
            final CommandMap commandMap = (CommandMap)commandMapField.get(Bukkit.getServer());
            commandMap.register(command.getLabel(), (Command)command);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Check permission method used to check if a player has
     * specific permission for a node or is opped.
     * @param p player to check
     * @param node node to check
     * @return true if the player is opped or has permission
     */
    public static boolean hasPermission(Player p, String node){
        if(p.hasPermission(node) || p.isOp()){
            return true;
        }
        return false;
    }

}
