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
import java.util.List;
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

    public static ItemStack getChestHead(final String name, final String... lore) {
        final ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
        final SkullMeta meta = (SkullMeta) item.getItemMeta();

        meta.setOwningPlayer(Bukkit.getOfflinePlayer("MHF_Chest"));

        // Set the name of the item
        if(name != null){
            meta.setDisplayName(ColorUtil.format(name));
        }else{
            meta.setDisplayName("");
        }
        // Set the lore of the item
        if(lore != null) {
            meta.setLore(ColorUtil.formatList(Arrays.asList(lore)));
        }
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getLeftArrow(final String name, final String... lore) {
        final ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
        final SkullMeta meta = (SkullMeta) item.getItemMeta();

        meta.setOwningPlayer(Bukkit.getOfflinePlayer("MHF_ArrowLeft"));

        // Set the name of the item
        if(name != null){
            meta.setDisplayName(ColorUtil.format(name));
        }else{
            meta.setDisplayName("");
        }
        // Set the lore of the item
        if(lore != null) {
            meta.setLore(ColorUtil.formatList(Arrays.asList(lore)));
        }
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getRightArrow(final String name, final String... lore) {
        final ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
        final SkullMeta meta = (SkullMeta) item.getItemMeta();

        meta.setOwningPlayer(Bukkit.getOfflinePlayer("MHF_ArrowRight"));

        // Set the name of the item
        if(name != null){
            meta.setDisplayName(ColorUtil.format(name));
        }else{
            meta.setDisplayName("");
        }
        // Set the lore of the item
        if(lore != null) {
            meta.setLore(ColorUtil.formatList(Arrays.asList(lore)));
        }
        item.setItemMeta(meta);

        return item;
    }




}
