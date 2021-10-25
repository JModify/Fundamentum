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

public class MenuItem {

    /** Constants of MHF skulls for easy access */
    private static final UUID mhfArrowLeft = UUID.fromString("a68f0b64-8d14-4000-a95f-4b9ba14f8df9");
    private static final UUID mhfChest = UUID.fromString("73d4e068-3a6d-4c8b-8f85-3323546955c4");
    private static final UUID mhfArrowRight = UUID.fromString("50c8510b-5ea0-4d60-be9a-7d542d6cd156");

    /** The UUID of the skull owner. */
    private UUID skullOwner;

    /** Display name for this menu item. */
    private String itemName;

    /** Material type for this menu item. */
    private Material material;

    /** Item lore for this menu item */
    private String[] lore;

    /**
     * Create a menu item using only it's display name and material.
     * @param itemName item display name (supports hex and bukkit color codes)
     * @param material material type to set item.
     */
    public MenuItem(String itemName, Material material) {
        this.itemName = itemName;
        this.lore = null;
        this.skullOwner = null;
        this.material = material;
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
        this.skullOwner = null;
        this.material = material;
    }

    /**
     * Create an expected skull item with it's item name, owner uuid and lore.
     * @param itemName item display name (supports hex and bukkit color codes)
     * @param skullOwner skull owner, used to set the skull skin.
     * @param lore lore to display below display name (supports hex and bukkit color codes)
     */
    public MenuItem(String itemName, UUID skullOwner, String... lore) {
        this.itemName = itemName;
        this.lore = lore;
        this.skullOwner = skullOwner;
        this.material = Material.PLAYER_HEAD;
    }

    /**
     * Create an expected skull item with it's item name and owner uuid.
     * @param itemName item display name (supports hex and bukkit color codes)
     * @param skullOwner skull owner, used to set the skull skin.
     */
    public MenuItem(String itemName, UUID skullOwner) {
        this.itemName = itemName;
        this.lore = null;
        this.skullOwner = skullOwner;
        this.material = Material.PLAYER_HEAD;
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
     * Set the skull owner of an expected skull item.
     * @param skullOwner skull owner to copy skin.
     */
    public void setSkullOwner(UUID skullOwner) {
        this.skullOwner = skullOwner;
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
    public ItemStack getSkullItem() {
        if (skullOwner != null) {
            ItemStack item = new ItemStack(material, 1);
            SkullMeta skullMeta = (SkullMeta) item.getItemMeta();
            Objects.requireNonNull(skullMeta);

            skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(skullOwner));
            skullMeta.setDisplayName(ColorUtil.format(itemName));

            if (lore != null)
                skullMeta.setLore(ColorUtil.formatList(Arrays.asList(lore)));

            item.setItemMeta(skullMeta);
            return item;
        }
        PluginLogger.logError("Attempted to retrieve skull item with no set owning player. " +
                "Contact plugin author.");
        return null;
    }

    /**
     * Retrieve the menu item as an item stack.
     * @return the menu item's respective item stack.
     */
    public ItemStack getMenuItem() {
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
