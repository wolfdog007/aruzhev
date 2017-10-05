package ru.job4j;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ruzhev Alexander
 * @since 02.10.2017
 */
public class IteratorForPrimeNumberTest {
    /**
     * Test hasNext().
     */
    @Test
    public void whenHasNext() {
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        IteratorForPrimeNumber iterator = new IteratorForPrimeNumber(array);
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
    }

    /**
     * Test next().
     */
    @Test
    public void whenNextThenGetPrimeNumber() {
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        IteratorForPrimeNumber iterator = new IteratorForPrimeNumber(array);
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.next(), is(7));
    }

    /**
     * Test next() then NoSuchElementException.
     *
     * @throws NoSuchElementException when element not found.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextThenNoSuchElementException() throws NoSuchElementException {
        int[] array = new int[]{0, 4, 6, 8};
        IteratorForPrimeNumber iterator = new IteratorForPrimeNumber(array);
        iterator.next();
    }
}