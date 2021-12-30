package com.modify.fundamentum.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Object used for caching data in the form of a HashMap.
 * @param <K> cache key
 * @param <V> cache value
 */
public class HMapCache<K, V> {

    /**
     * Hashmap containing data.
     * All entries will be stored here.
     */
    private Map<K, V> cache = new HashMap<>();

    /**
     * Retrieves the value stored at a key in the map.
     * @param key entry to retrieve value for.
     * @return The value stored under this key.
     */
    public V get(K key) {
        return cache.get(key);
    }

    /**
     * Method used to determine whether an entry is already
     * cached or not.
     * @param key entry to check
     * @return true if this entry is already cached, else false.
     */
    public boolean isCached(K key) {
        return cache.containsKey(key);
    }

    /**
     * Add an entry to the cache.
     * @param key key to store under.
     * @param value value to store.
     */
    public void cache(K key, V value) {
        cache.put(key, value);
    }

    /**
     * Removes an entry from the cache.
     * @param key key entry exists under.
     */
    public void remove(K key) {
        cache.remove(key);
    }

    /**
     * Updates a pre-existing entry in the cache.
     *
     * @requires cache does not already contain entry
     * @ensures update to cache is made rather than a
     *          new entry being inserted
     *
     * @param key key to update.
     * @param value new value to set.
     */
    public void update(K key, V value) {
        cache.put(key, value);
    }
}
