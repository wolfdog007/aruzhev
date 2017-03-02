package ru.job4j;

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
        int temp = 0;
        for (int i = 0; i < array.length - temp; i++) {
            for (int j = i + 1; j < array.length - temp; j++) {
                if (array[i].equals(array[j])) {
                    System.arraycopy(array, j + 1, array, j, array.length - j - 1);
                    temp++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - temp);
    }
}