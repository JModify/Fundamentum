package com.modify.fundamentum.menu;

import lombok.Getter;
import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

/**
 * Abstract menu class used to represent inventory user interfaces.
 */
public abstract class Menu implements InventoryHolder {

    /** Menu object to create and modify */
    protected Inventory inventory;

    /** Player opening the menu */
    @Getter Player player;

    /**
     * Create a new instance of a menu.
     * @param player player opening the menu.
     */
    public Menu(Player player){
        this.player = player;
    }

    /**
     * Create the inventory, set it's required fields, set the items
     * then force the player to open it.
     */
    public void open(){
        inventory = Bukkit.createInventory(this, getSlots(), getMenuName());
        this.setMenuItems();
        player.openInventory(inventory);
    }

    /**
     * Retrieve the name of this menu.
     * @return display name of this menu/inventory.
     */
    public abstract String getMenuName();

    /**
     * Retrieve the number of inventory slots for this inventory.
     * @return inventory size/slots
     */
    public abstract int getSlots();

    /**
     * Set the menu items displayed inside the inventory interface.
     */
    public abstract void setMenuItems();

    /**
     * Handle an inventory click event. Should be executed
     * in the appropriate player listener.
     * @param e event instance
     */
    public abstract void handleMenu(InventoryClickEvent e);

    @Override
    public @NonNull Inventory getInventory() {
        return inventory;
    }
}
