package com.modify.fundamentum.menu;

import com.modify.fundamentum.text.ColorUtil;
import com.modify.fundamentum.text.PluginLogger;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * A menu item represents an item stack which can be used to represent
 * different things in an inventory user interface.
 */
public class MenuItem {

    /** Display name for this menu item. */
    private String itemName;

    /** Material type for this menu item. */
    private Material material;

    /** Item lore for this menu item */
    private String[] lore;

    /** Set the stack size for this menu item */
    private int stackSize;

    /**
     * Create a menu item using only it's display name and material.
     * @param itemName item display name (supports hex and bukkit color codes)
     * @param material material type to set item.
     */
    public MenuItem(String itemName, Material material) {
        this.itemName = itemName;
        this.lore = null;
        this.material = material;
        this.stackSize = 1;
    }

    /**
     * Create a menu item using only it's display name, material and lore.
     * @param itemName item display name (supports hex and bukkit color codes)
     * @param material material type to set item.
     * @param lore lore to display below display name (supports hex and bukkit color codes)
     */
    public MenuItem(String itemName, Material material, String... lore) {
        this.itemName = itemName;
        this.lore = lore;
        this.material = material;
        this.stackSize = 1;
    }

    /**
     * Create a menu item using it's display name, material, stacksize and lore.
     * @param itemName item display name (supports hex and bukkit color codes)
     * @param material material type to set item.
     * @param stackSize size of menu item stack.
     * @param lore lore to display below display name (supports hex and bukkit color codes)
     */
    public MenuItem(String itemName, Material material, int stackSize, String... lore) {
        this.itemName = itemName;
        this.lore = lore;
        this.material = material;
        this.stackSize = stackSize;
    }

    /**
     * Set the display name to use for item stack.
     * @param itemName display name to use for this menu item.
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Set the material of to use for this menu item.
     * @param material material to use for item stack.
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * Sets the size of the menu item stack.
     * @param stackSize size to set.
     */
    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
    }

    /**
     * Set the lore of this menu item.
     * @param lore lore text to display below item name.
     */
    public void setLore(String... lore) {
        this.lore = lore;
    }

    /**
     * Retrieve the menu item as an item stack.
     * @return the menu item's respective item stack.
     */
    public ItemStack get() {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();
        Objects.requireNonNull(meta);

        meta.setDisplayName(itemName);

        if (lore != null)
            meta.setLore(ColorUtil.formatList(Arrays.asList(lore)));

        item.setItemMeta(meta);
        return item;
    }


}
