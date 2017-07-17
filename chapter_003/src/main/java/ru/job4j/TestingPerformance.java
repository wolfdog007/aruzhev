package ru.job4j;

import java.util.Collection;

/**
 * @author Ruzhev Alexander
 * @since 15.07.2017
 */
public class TestingPerformance {
    /**
     * current time.
     */
    private long startTime;

    /**
     * Method adds objects to the collection.
     *
     * @param collection - testing collection
     * @param amount     - amount of objects
     * @return - time
     */
    public long add(Collection<String> collection, int amount) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            collection.add(String.format("%s", i));
        }
        return System.currentTimeMillis() - startTime;
    }

    /**
     * Method remove objects to the collection.
     *
     * @param collection - testing collection
     * @param amount     - amount of objects
     * @return - time
     */
    public long delete(Collection<String> collection, int amount) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            collection.remove(String.format("%s", i));
        }
        return System.currentTimeMillis() - startTime;
    }
}
