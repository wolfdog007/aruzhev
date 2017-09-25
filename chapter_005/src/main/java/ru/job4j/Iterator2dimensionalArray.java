package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An iterator for a two-dimensional array.
 *
 * @author Ruzhev Alexander
 * @since 18.09.2017
 */
public class Iterator2dimensionalArray implements Iterator {
    /**
     * A two-dimensional array.
     */
    private int[][] array;
    /**
     * The position of the iterator.
     */
    private int position = 0;

    /**
     * Constructor.
     *
     * @param array two-dimensional array
     */
    Iterator2dimensionalArray(int[][] array) {
        this.array = array;
    }

    /**
     * Get array length.
     *
     * @return array length. If null then return -1
     */
    private int getArrayLength() {
        int arrayLength = 0;
        if (array != null) {
            for (int[] anArray : this.array) {
                arrayLength += anArray.length;
            }
        }
        return arrayLength;
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
        return this.position < getArrayLength();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Object next() {
        int x = 0;
        int y = 0;
        int current = 0;
        for (int i = 0; i < this.array.length; i++, x++) {
            current += this.array[i].length;
            if (current > this.position) {
                y = this.array[i].length - (current - this.position);
                break;
            }
        }
        this.position++;
        try {
            return this.array[x][y];
        } catch (Exception ex) {
            throw new NoSuchElementException();
        }
    }
}
