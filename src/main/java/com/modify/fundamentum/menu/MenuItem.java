package com.modify.fundamentum.menu;

import com.modify.fundamentum.text.ColorUtil;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private List<String> lore;

    /** Set the stack size for this menu item */
    private int stackSize;

    /** Whether or not the menu item has an enchant glow */
    boolean enchantGlow;

    /**
     * Constructs a menu item using the given properties.
     * @param itemName item display name (supports hex and bukkit color codes)
     * @param material material type to set item.
     * @param stackSize size of menu item stack.
     * @param enchantGlow whether the item should enchant glow
     * @param lore lore to display below display name (supports hex and bukkit color codes)
     */
    public MenuItem(String itemName, Material material, int stackSize, boolean enchantGlow, List<String> lore) {
        this.itemName = itemName;
        this.lore = lore;
        this.material = material;
        this.stackSize = stackSize;
        this.enchantGlow = enchantGlow;
    }

    /**
     * Constructs a menu item using the given properties.
     * @param itemName item display name (supports hex and bukkit color codes)
     * @param material material type to set item.
     * @param enchantGlow whether the item should enchant glow
     * @param lore lore to display below display name (supports hex and bukkit color codes)
     */
    public MenuItem(String itemName, Material material, boolean enchantGlow, List<String> lore) {
        this(itemName, material, 1, enchantGlow, lore);
    }

    /**
     * Constructs a menu item using the given properties.
     * @param itemName item display name (supports hex and bukkit color codes)
     * @param material material type to set item.
     * @param enchantGlow whether the item should enchant glow
     */
    public MenuItem(String itemName, Material material, boolean enchantGlow) {
        this(itemName, material, enchantGlow, new ArrayList<>());
    }

    /**
     * Create a menu item using only it's display name and material.
     * @param itemName item display name (supports hex and bukkit color codes)
     * @param material material type to set item.
     */
    public MenuItem(String itemName, Material material) {
        this(itemName, material, false);
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
    public void setLore(List<String> lore) {
        this.lore = lore;
    }

    /**
     * Retrieve the menu item as an item stack.
     * @return the menu item's respective item stack.
     */
    public ItemStack get() {
        ItemStack item = new ItemStack(material, stackSize);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ColorUtil.format(itemName));

        if (!lore.isEmpty())
            meta.setLore(ColorUtil.formatList(lore));

        if (enchantGlow) {
            meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        item.setItemMeta(meta);
        return item;
    }


}
