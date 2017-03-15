package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class ArraysMergingTest check work class ArraysMerging.
 *
 * @author Ruzhev Alexander
 * @since 15.03.2017
 */
public class ArraysMergingTest {
    /**
     * Test on ArraysMerging.mergingArray.
     */
    @Test
    public void whenMergingArrays() {
        ArraysMerging arraysMerging = new ArraysMerging();
        int[] first = {2, 5, 7, 7, 9};
        int[] second = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arrayTest = {1, 2, 2, 3, 4, 5, 5, 6, 7, 7, 7, 8, 9, 9};
        assertThat(arrayTest, is(arraysMerging.mergingArray(first, second)));
    }
}
