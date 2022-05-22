package com.modify.fundamentum.util;

import com.modify.fundamentum.exceptions.UUIDFormatException;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.defaults.BukkitCommand;

import java.lang.reflect.Field;
import java.util.UUID;
import java.util.regex.Pattern;

public class PlugUtil {

    /**
     * Register command in the command map to avoid listing commands in the plugin.yml
     * @param command command to register
     */
    public static void registerCommand(BukkitCommand command) {
        try {
            final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");

            bukkitCommandMap.setAccessible(true);
            CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());

            commandMap.register(command.getName(), command);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static UUID parseUUID(String id) throws UUIDFormatException {
        UUID result;
        try {
            result = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new UUIDFormatException("Failed to parse " + id + " as UUID.");
        }

        return result;
    }

    public static boolean isUUID(String uuid) {
        String regex = "[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[34][0-9a-fA-F]{3}-[89ab][0-9a-fA-F]{3}-[0-9a-fA-F]{12}";
        Pattern pattern = Pattern.compile(regex);

        if (pattern.matcher(uuid).matches()) {
            return true;
        }
        return false;
    }

    public static String toTitleCase(String givenString) {
        String[] arr = givenString.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(Character.toUpperCase(s.charAt(0)))
                    .append(s.substring(1)).append(" ");
        }

        return sb.toString().trim();
    }

}
