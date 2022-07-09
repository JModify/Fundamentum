package com.modify.fundamentum.item;

import com.modify.fundamentum.Fundamentum;
import com.modify.fundamentum.text.PlugLogger;
import com.modify.fundamentum.util.PlugDebugger;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ClassUtils;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class ItemData {

    private ItemStack item;

    public ItemData(ItemStack item) {
        this.item = item;
    }

    public boolean addMetaData(String key, PersistentDataType<?, ?> type, Object data) {
        NamespacedKey namespacedKey = new NamespacedKey(Fundamentum.getPlugin(), key);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            PlugLogger.logError("Failed to apply meta data");
            return false;
        }

        Class<?> complexType = type.getComplexType();
        PlugLogger.logInfo(complexType.toString());

        if (!classEquals(data, complexType)) {
            PlugLogger.logError("Failed to apply meta data to item. Data type and provided data mismatch.");
            return false;
        }

        if (complexType == Integer.class) {
            int i = (int) data;
            meta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.INTEGER, i);
        } else if (complexType == Double.class) {
            double d = (double) data;
            meta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.DOUBLE, d);
        } else if (complexType == String.class) {
            String str = (String) data;
            meta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.STRING, str);
        } else if (complexType == Short.class) {
            Short shor = (short) data;
            meta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.SHORT, shor);
        } else if (complexType == Float.class) {
            float f = (float) data;
            meta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.FLOAT, f);
        } else if (complexType == Long.class) {
            long l = (long) data;
            meta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.LONG, l);
        } else if (complexType == Byte.class) {
            byte b = (byte) data;
            meta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.BYTE, b);
        } else {
            PlugLogger.logError("Unexpected error occured when adding data to item.");
            return false;
        }

        item.setItemMeta(meta);
        return true;
    }

    private boolean classEquals(Object object, Class<?> other) {
        if (object.getClass().isPrimitive()) {
            object = ClassUtils.primitiveToWrapper(object.getClass());
        }

        return other.equals(object.getClass());
    }
}
