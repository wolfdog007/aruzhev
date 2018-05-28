package ru.job4j.nonblockingcache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Non blocking cache.
 *
 * @param <K> - key
 * @param <V> - value
 * @author Ruzhev Alexander
 * @since 24.05.2018
 */
public class NonBlockingCache<K, V extends Model> {
    /**
     * Collector of objects.
     */
    private final ConcurrentHashMap<K, V> map;

    /**
     * Constructor.
     */
    public NonBlockingCache() {
        this.map = new ConcurrentHashMap<K, V>();
    }

    /**
     * Add new object.
     *
     * @param key   - key for map
     * @param value - new object
     * @return - true if object has been added or false.
     */
    public boolean add(K key, V value) {
        return this.map.putIfAbsent(key, value) == null;
    }

    /**
     * Delete object.
     *
     * @param key - key for map
     * @return - true if object has been deleted or false.
     */
    public boolean delete(K key) {
        return this.map.remove(key) != null;
    }

    /**
     * Update object.
     *
     * @param key   - key for map.
     * @param value - the updated object
     * @return - value
     * @throws OptimisticException
     */
    public V update(K key, V value) {
        return this.map.computeIfPresent(key, (k, v) -> {
            if (value.getVersion() != v.getVersion()) {
                throw new OptimisticException("Incorrect version object.");
            } else {
                value.updateVersion();
            }
            return value;
        });
    }

    /**
     * Getter for value.
     *
     * @param key - key for map
     * @return - value
     */
    public V get(K key) {
        return this.map.get(key);
    }
}
