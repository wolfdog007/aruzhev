package ru.job4j;

/**
 * Class Turn - reverse int[].
 *
 * @author Ruzhev Alexander
 * @since 20.02.2017
 */
public class Turn {
    /**
     * Returns reverse massive.
     *
     * @param array  massive is int[]
     * @return int[] array - is reverse
     */
    public int[] back(int[] array) {
        int temp = 0;
        for (int index = 0; index < array.length >> 1; index++) {
            temp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = temp;
        }
        return array;
    }
}