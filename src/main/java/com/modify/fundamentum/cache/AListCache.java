package com.modify.fundamentum.cache;

import java.util.ArrayList;
import java.util.List;

/**
 * Object used for caching data in the form of an ArrayList.
 * @param <E> element type to store.
 */
public class AListCache<E> {

    /**
     * ArrayList containing data.
     * All entries will be stored here.
     */
    private List<E> cache = new ArrayList<>();

    /**
     * Determines whether an element is already cached or not.
     * @param element element to check.
     * @return true if the element is cached, else false.
     */
    public boolean isCached(E element) {
        return cache.contains(element);
    }

    /**
     * Cache an element into the list.
     * @param element element to cache.
     */
    public void cache(E element) {
        cache.add(element);
    }

    /**
     * Removes an element from the cache.
     * @param element element to remove.
     */
    public void remove(E element) {
        cache.remove(element);
    }
}
