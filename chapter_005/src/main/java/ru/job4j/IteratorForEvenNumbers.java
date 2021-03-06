package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator for even numbers.
 *
 * @author Ruzhev Alexander
 * @since 25.09.2017
 */
public class IteratorForEvenNumbers implements Iterator {
    /**
     * Array is int.
     */
    private int[] array;
    /**
     * The position of the iterator.
     */
    private int position = 0;
    /**
     * the index of the next even number.
     */
    private int indexNextEventNumber;

    /**
     * Constructor.
     *
     * @param array is int.
     */
    public IteratorForEvenNumbers(final int[] array) {
        this.array = array;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int index = this.position; index < this.array.length; index++) {
            if (this.array[index] % 2 == 0) {
                this.indexNextEventNumber = index;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            this.position = this.indexNextEventNumber;
        }
        return this.array[this.position++];
    }
}
