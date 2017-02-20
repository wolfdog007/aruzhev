package ru.job4j;

/**
 * Class Counter - calculates the sum of even numbers in the range.
 *
 * @author Ruzhev Alexander
 * @since 15.02.2017
 */
public class Counter {
    /**
     * Returns the sum of even numbers in the range.
     *
     * @param start  first number
     * @param finish second number
     * @return int - the sum of even numbers
     */
    public int add(int start, int finish) {
        int result = 0;
        for (; start <= finish; start++) {
            if (start % 2 == 0) {
                result += start;
                System.out.println(start);
            }
        }
        return result;
    }
}