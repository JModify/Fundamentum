package com.modify.fundamentum.menu;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public abstract class PaginatedMenu extends Menu {

    protected int page;
    protected final int maxItemsPerPage = 28;
    protected int index = 0;

    public PaginatedMenu(Player player) {
        super(player);
    }

    /**
     * Retrieves the amount of slots the inventory holds.
     * Since this is a paginated menu, the slot value should always be 54.
     * @return the slot size of the inventory.
     */
    @Override
    public int getSlots() {
        return 54;
    }

    /**
     *
     */
    public abstract void addMenuBorder();


}
