package com.modify.fundamentum;

import com.modify.fundamentum.text.ColorUtil;
import com.modify.fundamentum.text.PlugLogger;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Main utility class used for a variety of different convenience functions
 */
public class Common {

    public static final CommandSender CONSOLE_SENDER = Bukkit.getServer().getConsoleSender();

    public static final String PLUGIN_AUTHOR = "Modify";

    public static String consoleLine(){
        return "-------------------------------------------------------";
    }

    public static String chatLineSmooth(){
        return "&m-----------------------------------------------------";
    }

    public static void broadcast(final String message) {
        for (final Player online : Bukkit.getOnlinePlayers()) {
            online.sendMessage(ColorUtil.format(message));
        }
    }

    public static void broadcast(final String... messages) {
        for (final String message : messages) {
            broadcast(message);
        }
    }

    public static void tell(final CommandSender sender, String message) {
        sender.sendMessage(ColorUtil.format(message));
    }

    public static void tell(final CommandSender sender, String... message) {
        for (String m : message) {
            tell(sender, m);
        }
    }

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
            PlugLogger.logError("Failed to register bukkit command " + command.getName()
                    + ". Contact plugin author.");
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

    public static <T> List<T> joinArrays(final Iterable<T>... arrays) {
        final List<T> all = new ArrayList<>();

        for (final Iterable<T> array : arrays)
            for (final T element : array)
                all.add(element);

        return all;
    }


    public static String shortLocation(final Location loc) {
        if (loc == null)
            return "Location(null)";

        if (loc.equals(new Location(null, 0, 0, 0)))
            return "Location(null, 0, 0, 0)";

        return loc.getWorld().getName() + " [" + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ() + "]";
    }

}
