package com.modify.fundamentum.item;

import com.modify.fundamentum.Fundamentum;
import com.modify.fundamentum.text.PlugLogger;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class ItemData {

    private ItemStack item;

    public ItemData(ItemStack item) {
        this.item = item;
    }

    public boolean addDataToItem(String key, PersistentDataType<?, ?> dataType, Object data) {
        NamespacedKey namespacedKey = new NamespacedKey(Fundamentum.getPlugin(), key);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return false;
        }

        Class<?> complexType = dataType.getComplexType();
        PlugLogger.logInfo(complexType.toString());

        if (complexType == Integer.class) {
            int i = (int) data;
            meta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.INTEGER, i);
            PlugLogger.logInfo("Integer type triggered!");
        } else if (complexType == Double.class) {
            double d = (double) data;
            meta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.DOUBLE, d);
            PlugLogger.logInfo("Double type triggered!");
        } else if (complexType == String.class) {
            String str = (String) data;
            meta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.STRING, str);
            PlugLogger.logInfo("String type triggered!");
        } else {
            return false;
        }

        item.setItemMeta(meta);
        return true;
    }
}
