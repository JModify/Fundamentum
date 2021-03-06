package com.modify.fundamentum.menu;

import com.modify.fundamentum.text.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.sql.Array;
import java.util.*;

public class SkullMenuItem {

    /** Constants of MHF skulls for easy access */
    public static final UUID mhfArrowLeft = UUID.fromString("a68f0b64-8d14-4000-a95f-4b9ba14f8df9");
    public static final UUID mhfChest = UUID.fromString("73d4e068-3a6d-4c8b-8f85-3323546955c4");
    public static final UUID mhfArrowRight = UUID.fromString("50c8510b-5ea0-4d60-be9a-7d542d6cd156");

    /** The UUID of the skull owner. */
    private UUID skullOwner;

    /** Display name for this menu item. */
    private String itemName;

    /** Item lore for this menu item */
    private List<String> lore;

    /** Stack size for this menu item */
    private int stackSize;

    /** Whether the skull menu item has an enchant glow */
    private boolean enchantGlow;


    /**
     * Create a skull item with it's item name and owner uuid.
     * @param itemName item display name (supports hex and bukkit color codes)
     * @param skullOwner skull owner, used to set the skull skin.
     */
    public SkullMenuItem(String itemName, UUID skullOwner) {
        this.itemName = itemName;
        this.lore = new ArrayList<>();
        this.skullOwner = skullOwner;
        this.stackSize = 1;
        this.enchantGlow = false;
    }
    
    /**
     * Create a skull item with it's item name, owner uuid and lore.
     * @param itemName item display name (supports hex and bukkit color codes)
     * @param skullOwner skull owner, used to set the skull skin.
     * @param lore lore to display below display name (supports hex and bukkit color codes)
     */
    public SkullMenuItem(String itemName, UUID skullOwner, boolean enchantGlow, List<String> lore) {
        this.itemName = itemName;
        this.lore = lore;
        this.skullOwner = skullOwner;
        this.stackSize = 1;
        this.enchantGlow = enchantGlow;
    }

    /**
     * Create a skull item with it's item name and owner uuid.
     * @param itemName item display name (supports hex and bukkit color codes)
     * @param skullOwner skull owner, used to set the skull skin.
     */
    public SkullMenuItem(String itemName, UUID skullOwner, List<String> lore) {
        this.itemName = itemName;
        this.lore = lore;
        this.skullOwner = skullOwner;
        this.stackSize = 1;
        this.enchantGlow = false;
    }

    /**
     * Create a menu item using it's display name, material, stacksize and lore.
     * @param itemName item display name (supports hex and bukkit color codes)
     * @param skullOwner skull owner, used to set the skull skin.
     * @param stackSize size of menu item stack.
     * @param lore lore to display below display name (supports hex and bukkit color codes)
     */
    public SkullMenuItem(String itemName, UUID skullOwner, int stackSize, boolean enchantGlow, List<String> lore) {
        this.itemName = itemName;
        this.lore = lore;
        this.skullOwner = skullOwner;
        this.stackSize = stackSize;
        this.enchantGlow = enchantGlow;
    }

    /**
     * Set the display name to use for item stack.
     * @param itemName display name to use for this menu item.
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Set the skull owner of this item.
     * @param skullOwner skull owner to copy skin.
     */
    public void setSkullOwner(UUID skullOwner) {
        this.skullOwner = skullOwner;
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
     * Retrieve the item stack for this skull item.
     * @return item stack of this skull item.
     */
    public ItemStack get() {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD, stackSize);
        SkullMeta skullMeta = (SkullMeta) item.getItemMeta();
        Objects.requireNonNull(skullMeta);

        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(skullOwner));
        skullMeta.setDisplayName(ColorUtil.format(itemName));

        if (lore != null)
            skullMeta.setLore(ColorUtil.formatList(lore));

        if (enchantGlow) {
            skullMeta.addEnchant(Enchantment.ARROW_INFINITE,1,true);
            skullMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        item.setItemMeta(skullMeta);
        return item;
    }

}
