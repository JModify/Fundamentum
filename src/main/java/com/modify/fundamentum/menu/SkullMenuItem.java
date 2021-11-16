package com.modify.fundamentum.menu;

import com.modify.fundamentum.text.ColorUtil;
import com.modify.fundamentum.text.PluginLogger;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class SkullMenuItem {

    /** Constants of MHF skulls for easy access */
    public static final String mhfArrowLeft = "MHF_ArrowLeft";
    public static final String mhfChest = "MHF_Chest";
    public static final String mhfArrowRight = "MHF_ArrowRight";

    /** The UUID of the skull owner. */
    private UUID skullOwner;

    /** Display name for this menu item. */
    private String itemName;

    /** Item lore for this menu item */
    private String[] lore;

    /** Stack size for this menu item */
    private int stackSize;

    /**
     * Create a skull item with it's item name, owner uuid and lore.
     * @param itemName item display name (supports hex and bukkit color codes)
     * @param skullOwner skull owner, used to set the skull skin.
     * @param lore lore to display below display name (supports hex and bukkit color codes)
     */
    public SkullMenuItem(String itemName, UUID skullOwner, String... lore) {
        this.itemName = itemName;
        this.lore = lore;
        this.skullOwner = skullOwner;
        this.stackSize = 1;
    }

    /**
     * Create a skull item with it's item name and owner uuid.
     * @param itemName item display name (supports hex and bukkit color codes)
     * @param skullOwner skull owner, used to set the skull skin.
     */
    public SkullMenuItem(String itemName, UUID skullOwner) {
        this.itemName = itemName;
        this.lore = null;
        this.skullOwner = skullOwner;
        this.stackSize = 1;
    }

    /**
     * Create a menu item using it's display name, material, stacksize and lore.
     * @param itemName item display name (supports hex and bukkit color codes)
     * @param skullOwner skull owner, used to set the skull skin.
     * @param stackSize size of menu item stack.
     * @param lore lore to display below display name (supports hex and bukkit color codes)
     */
    public SkullMenuItem(String itemName, UUID skullOwner, int stackSize, String... lore) {
        this.itemName = itemName;
        this.lore = lore;
        this.skullOwner = skullOwner;
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
    public void setLore(String... lore) {
        this.lore = lore;
    }

    /**
     * Retrieve the item stack for this skull item.
     * @return item stack of this skull item.
     */
    public ItemStack get() {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD, stackSize);
        SkullMeta skullMeta = (SkullMeta) item.getItemMeta();

        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(skullOwner));
        skullMeta.setDisplayName(ColorUtil.format(itemName));

        if (lore != null)
            skullMeta.setLore(ColorUtil.formatList(Arrays.asList(lore)));

        item.setItemMeta(skullMeta);
        return item;
    }

}
