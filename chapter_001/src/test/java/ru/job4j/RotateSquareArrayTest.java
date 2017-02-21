package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class RotateSquareArrayTest check work class RotateSquareArray.
 *
 * @author Ruzhev Alexander
 * @since 21.02.2017
 */
public class RotateSquareArrayTest {
    /**
     * Test on rotate right.
     */
    @Test
    public void whenRotateRight() {
        RotateSquareArray rotateSquareArray = new RotateSquareArray();
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arrayTest = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertThat(arrayTest, is(rotateSquareArray.rotateRight(array)));
    }

    /**
     * Test on rotate left.
     */
    @Test
    public void whenRotateLeft() {
        RotateSquareArray rotateSquareArray = new RotateSquareArray();
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arrayTest = {{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
        assertThat(arrayTest, is(rotateSquareArray.rotateLeft(array)));
    }
}
