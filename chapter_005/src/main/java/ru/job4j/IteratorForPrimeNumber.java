package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Ruzhev Alexander
 * @since 02.10.2017
 */
public class IteratorForPrimeNumber implements Iterator {
    /**
     * Array is int.
     */
    private int[] array;
    /**
     * The position of the iterator.
     */
    private int position = 0;
    /**
     * the index of the next prime number.
     */
    private int indexNextPrimeNumber;

    /**
     * Constructor.
     *
     * @param array is int.
     */
    public IteratorForPrimeNumber(final int[] array) {
        this.array = array;
    }

    /**
     * Check number for simplicity.
     *
     * @param number Number to test
     * @return true for prime number
     */
    private boolean checkPrime(int number) {
        boolean result = true;
        if (number <= 1) {
            result = false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                result = false;
            }
        }
        return result;
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
        for (int i = this.position; i < this.array.length; i++) {
            if (this.checkPrime(this.array[i])) {
                this.indexNextPrimeNumber = i;
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
            this.position = this.indexNextPrimeNumber;
        }
        return this.array[this.position++];
    }
}
