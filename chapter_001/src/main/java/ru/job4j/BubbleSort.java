package ru.job4j;

/**
 * Sort array whit bubble.
 *
 * @author Ruzhev Alexander
 * @since 20.02.2017
 */
public class BubbleSort {
    /**
     * Returns sort massive.
     *
     * @param values  massive is int[]
     * @return int[] array - is sort
     */
    public int[] sortArray(int[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j] > values[j + 1]) {
                    int temp = values[j + 1];
                    values[j + 1] = values[j];
                    values[j] = temp;
                }
            }
        }
        return values;
    }
}