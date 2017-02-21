package ru.job4j;

/**
 * Rotate square array to right and to left.
 *
 * @author Ruzhev Alexander
 * @since 21.02.2017
 */
public class RotateSquareArray {
    /**
     * Returns the array rotated to right.
     *
     * @param array square massive is int[][]
     * @return int[][] array - is rotated to right
     */
    public int[][] rotateRight(int[][] array) {
        int[][] resultArray = new int[array[0].length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                resultArray[j][array.length - i - 1] = array[i][j];
            }
        }
        return resultArray;
    }

    /**
     * Returns the array rotated to left.
     *
     * @param array square massive is int[][]
     * @return int[][] array - is rotated to left
     */
    public int[][] rotateLeft(int[][] array) {
        int[][] resultArray = new int[array[0].length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                resultArray[array[i].length - j - 1][i] = array[i][j];
            }
        }
        return resultArray;
    }
}
