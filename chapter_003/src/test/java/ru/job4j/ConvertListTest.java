package ru.job4j;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * @author Ruzhev Alexander
 * @since 19.07.2017
 */
public class ConvertListTest {
    /**
     * Test toList.
     */
    @Test
    public void whenToList() {
        int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        ConvertList convertList = new ConvertList();
        assertThat(expectedList, is(convertList.toList(array)));
    }

    /**
     * Test toArray.
     */
    @Test
    public void whenToArray() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int[][] expectedArray = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        ConvertList convertList = new ConvertList();
        assertThat(expectedArray, is(convertList.toArray(list, 3)));
    }
}
