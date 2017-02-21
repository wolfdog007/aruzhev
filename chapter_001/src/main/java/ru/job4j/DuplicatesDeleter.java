package ru.job4j;

import java.util.Arrays;

/**
 * Removes duplicates from the array.
 *
 * @author Ruzhev Alexander
 * @since 21.02.2017
 */
public class DuplicatesDeleter {
    /**
     * Removes duplicates from the String[] array.
     *
     * @param array massive is String[]
     * @return String[] array - array without duplicates
     */
    public String[] removeDuplicates(String[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    System.arraycopy(array, j + 1, array, j, array.length - j - 1);
                    array = Arrays.copyOf(array, array.length - 1);
                }
            }
        }
        return array;
    }
}
