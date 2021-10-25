package com.modify.fundamentum.text;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;

public class PlugUtil {

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

    public static boolean hasPermission(Player p, String node){
        if(p.hasPermission(node) || p.isOp()){
            return true;
        }
        return false;
    }

}
