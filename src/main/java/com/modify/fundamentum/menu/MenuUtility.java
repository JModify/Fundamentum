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

public class MenuUtility {

    private static final UUID mhfArrowLeft = UUID.fromString("a68f0b64-8d14-4000-a95f-4b9ba14f8df9");
    private static final UUID mhfChest = UUID.fromString("73d4e068-3a6d-4c8b-8f85-3323546955c4");
    private static final UUID mhfArrowRight = UUID.fromString("50c8510b-5ea0-4d60-be9a-7d542d6cd156");

    public static ItemStack createSkullItem(String color, OfflinePlayer owner,
                                            String... lore) throws PlayerNotFoundException{

        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta skullMeta = (SkullMeta) item.getItemMeta();

        setOwningPlayer(skullMeta, owner);
        setDisplayName(skullMeta, color, owner);

        if (lore != null && skullMeta != null)
            skullMeta.setLore(ColorUtil.formatList(Arrays.asList(lore)));

        item.setItemMeta(skullMeta);
        return item;
    }

    public static ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ColorUtil.format(name));

        if (lore != null) {
            meta.setLore(ColorUtil.formatList(Arrays.asList(lore)));
        }

        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getChestHead(final String name, final String... lore) {

        final ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
        final SkullMeta skullMeta = (SkullMeta) item.getItemMeta();

        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(mhfArrowRight));
        skullMeta.setDisplayName(ColorUtil.format(name));

        if(lore != null) {
            skullMeta.setLore(ColorUtil.formatList(Arrays.asList(lore)));
        }

        item.setItemMeta(skullMeta);
        return item;
    }

    public static ItemStack getLeftArrow(final String name, final String... lore) {
        final ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
        final SkullMeta skullMeta = (SkullMeta) item.getItemMeta();

        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(mhfArrowLeft));
        skullMeta.setDisplayName(ColorUtil.format(name));

        if(lore != null) {
            skullMeta.setLore(ColorUtil.formatList(Arrays.asList(lore)));
        }

        item.setItemMeta(skullMeta);
        return item;
    }

    public static ItemStack getRightArrow(final String name, final String... lore) {
        final ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
        final SkullMeta meta = (SkullMeta) item.getItemMeta();

        meta.setOwningPlayer(Bukkit.getOfflinePlayer(mhfArrowRight));
        meta.setDisplayName(ColorUtil.format(name));

        if(lore != null) {
            meta.setLore(ColorUtil.formatList(Arrays.asList(lore)));
        }

        item.setItemMeta(meta);
        return item;
    }

    public static void addFillers(Inventory inv){
        for(int i = 0; i < inv.getSize(); i++){
            ItemStack is = inv.getItem(i);
            if(is == null || is.getType() == Material.AIR){
                inv.setItem(i, createGuiItem(Material.BLACK_STAINED_GLASS_PANE, null, null));
            }
        }
    }

    /**
     * Helper method used to set display name of a given skull meta.
     * @param skullMeta - skull meta to set
     * @param color - color code to set display name color.
     * @param player - player to retrieve username.
     * @throws PlayerNotFoundException - if the given player does not exist.
     */
    private static void setDisplayName(SkullMeta skullMeta, String color, OfflinePlayer player)
            throws PlayerNotFoundException {
            try {
                skullMeta.setDisplayName(ColorUtil.format(color + player.getName()));
            } catch (NullPointerException e) {
                throw new PlayerNotFoundException();
            }
    }

    /**
     * Helper method used to set owning player of a given skull meta.
     * @param skullMeta - skull meta to set.
     * @param player - player to set.
     * @throws PlayerNotFoundException - if the given player does not exist.
     */
    private static void setOwningPlayer(SkullMeta skullMeta, OfflinePlayer player)
            throws PlayerNotFoundException {
        try {
            skullMeta.setOwningPlayer(player);
        } catch (NullPointerException e) {
            throw new PlayerNotFoundException();
        }
    }

}
