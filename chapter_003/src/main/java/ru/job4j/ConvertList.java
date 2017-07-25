package ru.job4j;


import java.util.ArrayList;
import java.util.List;

/**
 * Class ConvertList - converted array[][] to List<Integer> and List<Integer> to array[][].
 *
 * @author Ruzhev Alexander
 * @since 19.07.2017
 */
public class ConvertList {
    /**
     * Converted array[][] to List<Integer>.
     *
     * @param array - array[][] of int.
     * @return List<Integer>
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] line : array) {
            for (int number : line) {
                list.add(new Integer(number));
            }
        }
        return list;
    }

    /**
     * Converted List<Integer> to array[][].
     *
     * @param list - List<Integer>
     * @param rows - number of rows
     * @return array[rows][] is int
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int size = list.size();
        int column = size % rows != 0 ? size / rows + 1 : size / rows;
        int[][] array = new int[rows][column];
        int listIndex = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                array[i][j] = listIndex < size ? list.get(listIndex++) : 0;
            }
        }
        return array;
    }

    /**
     * Converted List<int[]> to List<Integer>.
     * @param list - List<int[]>
     * @return List<Integer>
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> arrayList = new ArrayList<>();
        for (int[] line : list) {
            for (int number : line) {
                arrayList.add(number);
            }
        }
        return arrayList;
    }
}
