package ru.job4j;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class Counter.
 * @author Ruzhev Alexander
 * @since 11.04.2018
 */
@ThreadSafe
public class Count {
    /**
     * Counter value.
     */
    @GuardedBy("this")
    private int value;

    /**
     * Increment.
     */
    public synchronized void increment() {
        this.value++;
    }

    /**
     * Getter for value.
     * @return - value
     */
    public synchronized int get() {
        return this.value;
    }
}
