package ru.job4j.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The class MyHashMap - use for storage key and value.
 *
 * @param <K> This describes my type parameter. Type for key;
 * @param <V> This describes my type parameter. Type for value;
 * @author Ruzhev Alexander
 * @since 16.12.2017
 */

public class MyHashMap<K, V> implements Iterable<MyHashMap.Entry> {
    /**
     * The number of elements.
     */
    private int size;
    /**
     * Size whit bucket.
     */
    private int bucketSize = 16;
    /**
     * Hash array.
     */
    private Entry[] entry;

    /**
     * Constructor.
     */
    MyHashMap() {
        this.size = 0;
        this.entry = new Entry[bucketSize];
    }

    /**
     * Getter for size.
     *
     * @return size
     */
    public int getSize() {
        return this.size;
    }

    /**
     * The method add new element to collection.
     *
     * @param key   - key
     * @param value - value
     * @return true if added new element, or false if not
     */
    public boolean insert(K key, V value) {
        boolean result = false;
        if (size > bucketSize / 2) {
            increase();
        }
        int index = Math.abs(key.hashCode() % bucketSize);
        if (this.entry[index] == null) {
            this.entry[index] = new Entry(key, value);
            result = true;
            this.size++;
        }
        return result;
    }

    /**
     * The method return value by key or if not search, return null.
     *
     * @param key - key
     * @return value.
     */
    public V get(K key) {
        int index = Math.abs(key.hashCode() % bucketSize);
        return this.entry[index] != null ? (V) this.entry[index].value : null;
    }

    /**
     * The method delete element to array by key.
     *
     * @param key - key
     * @return true - is delete; false - is not delete
     */
    public boolean delete(K key) {
        boolean result = false;
        int index = Math.abs(key.hashCode() % bucketSize);
        if (this.entry[index] != null) {
            this.entry[index] = null;
            this.size--;
            result = true;
        }
        return result;
    }

    /**
     * increasing the size of the array.
     */
    private void increase() {
        this.bucketSize = this.bucketSize * 3;
        Entry[] oldEntry = this.entry;
        this.entry = new Entry[bucketSize];
        this.size = 0;
        for (Entry element : oldEntry) {
            if (element != null) {
                insert((K) element.key, (V) element.value);
            }
        }
    }

    /**
     * Returns an iterator over elements of type {@code V}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<MyHashMap.Entry> iterator() {
        return new Iterator<MyHashMap.Entry>() {
            /**
             * Position in array.
             */
            private int position = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;
                int index = position;
                while (index < entry.length) {
                    if (entry[index] != null) {
                        result = true;
                        break;
                    }
                    index++;
                }
                return result;
            }

            @Override
            public Entry next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (entry[position] == null) {
                    position++;
                }
                return entry[position++];
            }
        };
    }

    /**
     * The inner class for storing key and values.
     * @param <K> This describes my type parameter. Type for key;
     * @param <V> This describes my type parameter. Type for value;
     */
    public class Entry<K, V> {
        /**
         * Key of Entry.
         */
        private K key;

        /**
         * Value of entry.
         */
        private V value;

        /**
         * Constructor of entry.
         *
         * @param key   key.
         * @param value value.
         */
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Getter for key.
         *
         * @return key.
         */
        public K getKey() {
            return key;
        }

        /**
         * Getter for values.
         *
         * @return values.
         */
        public V getValue() {
            return value;
        }
    }
}
