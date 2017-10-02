package ru.job4j;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for IteratorForEvenNumbers.
 * @author Ruzhev Alexander
 * @since 25.09.2017
 */
public class IteratorForEvenNumbersTest {
    /**
     * Test hasNext().
     */
    @Test
    public void whenHasNext() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        IteratorForEvenNumbers iterator = new IteratorForEvenNumbers(array);
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        iterator.next();
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
    }

    /**
     * Test next().
     */
    @Test
    public void whenNext() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        IteratorForEvenNumbers iterator = new IteratorForEvenNumbers(array);
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(6));
    }

    /**
     * Test next() then NoSuchElementException.
     * @throws NoSuchElementException when next element not found.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextThenNoSuchElementException() throws NoSuchElementException {
        int[] array = new int[]{1, 3, 5, 7};
        IteratorForEvenNumbers iterator = new IteratorForEvenNumbers(array);
        iterator.next();
    }
}