package ru.job4j;

/**
 * The Union of two sorted arrays.
 *
 * @author Ruzhev Alexander
 * @since 15.03.2017
 */
public class ArraysMerging {
    /**
     * Union of two sorted arrays.
     *
     * @param firstArray  sorted array is int[]
     * @param secondArray sorted array is int[]
     * @return resultArray - the result of combining arrays
     */
    public int[] mergingArray(int[] firstArray, int[] secondArray) {
        int[] resultArray = new int[firstArray.length + secondArray.length];
        for (int i = 0, j = 0; i + j < resultArray.length;) {
            resultArray[i + j] = firstArray[i] <= secondArray[j] ? firstArray[i++] : secondArray[j++];
            if (i == firstArray.length) {
                for (; j < secondArray.length; j++) {
                    resultArray[i + j] = secondArray[j];
                }
            }
            if (j == secondArray.length) {
                for (; i < firstArray.length; i++) {
                    resultArray[i + j] = firstArray[i];
                }
            }
        }
        return resultArray;
    }

}
