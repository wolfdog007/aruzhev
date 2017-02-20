package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class BubbleSortTest check work class BubbleSort.
 *
 * @author Ruzhev Alexander
 * @since 20.02.2017
 */
public class BubbleSortTest {
    /**
     * Test on Sort.
     */
    @Test
    public void whenSort() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arrayTest = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertThat(array, is(bubbleSort.sortArray(arrayTest)));
    }
}
