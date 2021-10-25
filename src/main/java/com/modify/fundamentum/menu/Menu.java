package com.modify.fundamentum.menu;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

/**
 * Abstract menu class used to represent inventory user interfaces.
 */
public abstract class Menu implements InventoryHolder {

    protected Inventory inventory;

    @Getter Player player;

    public Menu(Player player){
        this.player = player;
    }

    public void open(){
        inventory = Bukkit.createInventory(this, getSlots(), getMenuName());
        this.setMenuItems();
        player.openInventory(inventory);
    }

    public abstract String getMenuName();

    public abstract int getSlots();

    public abstract void setMenuItems();

    public abstract void handleMenu(InventoryClickEvent e);
}
