package com.modify.fundamentum.menu;

import com.modify.fundamentum.exceptions.PlayerNotFoundException;
import com.modify.fundamentum.text.ColorUtil;
import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Skull;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.UUID;

/**
 * Menu utility class used for a variety of different functions.
 */
public class MenuUtility {

    public static void addFillers(Inventory inv, ItemStack fillerItem){
        for(int i = 0; i < inv.getSize(); i++){
            ItemStack is = inv.getItem(i);
            if(is == null || is.getType() == Material.AIR){
                inv.setItem(i, fillerItem);
            }
        }
    }

    public static void addFillers(Inventory inv, ItemStack fillerItem, int rangeMin, int rangeMax){
        for(int i = 0; i < inv.getSize(); i++){
            ItemStack is = inv.getItem(i);
            if (i >= rangeMin && i <= rangeMax) {
                if(is == null || is.getType() == Material.AIR){
                    inv.setItem(i, fillerItem);
                }
            }
        }
    }

}
