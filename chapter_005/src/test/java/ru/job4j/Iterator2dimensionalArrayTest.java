package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Iterator2dimensionalArrayTest.
 *
 * @author Ruzhev Alexander
 * @since 18.09.2017
 */
public class Iterator2dimensionalArrayTest {
    /**
     * Test hasNext is true.
     */
    @Test
    public void whenHasNextThenTrue() {
        int[][] arr = new int[][]{{1, 2, 3}, {4}};
        Iterator2dimensionalArray iterator = new Iterator2dimensionalArray(arr);
        assertThat(iterator.hasNext(), is(true));
    }

    /**
     * Test hasNext is false.
     */
    @Test
    public void whenHasNextThenFalse() {
        int[][] arr = new int[][]{{1, 2}, {3, 4}};
        Iterator2dimensionalArray iterator = new Iterator2dimensionalArray(arr);
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
    }

    /**
     * Test hasNext when array is null.
     */
    @Test
    public void whenArrayIsNullThenFalse() {
        Iterator2dimensionalArray iterator = new Iterator2dimensionalArray(null);
        assertThat(iterator.hasNext(), is(false));
    }

    /**
     * Test hasNext when array is empty.
     */
    @Test
    public void whenArrayIsEmptyThenFalse() {
        Iterator2dimensionalArray iterator = new Iterator2dimensionalArray(new int[][]{{}});
        assertThat(iterator.hasNext(), is(false));
    }

    /**
     * Test next is true for simple array.
     */
    @Test
    public void whenNext() {
        int[][] arr = new int[][]{{}, {1, 2, 3, 4}};
        Iterator2dimensionalArray iterator = new Iterator2dimensionalArray(arr);
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));
    }

    /**
     * Test next for different length array.
     */
    @Test
    public void whenGetNextElementDifferentLength() {
        int[][] inArray = {
                {},
                {1, 2, 3},
                {},
                {4},
                {5, 6, 7, 8, 9},
                {},
                {}
        };
        Iterator2dimensionalArray iterator = new Iterator2dimensionalArray(inArray);
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.next(), is(6));
        assertThat(iterator.next(), is(7));
        assertThat(iterator.next(), is(8));
        assertThat(iterator.next(), is(9));
    }
}