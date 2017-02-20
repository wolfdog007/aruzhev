package ru.job4j;

/**
 * Class Factorial - calculates the factorial.
 *
 * @author Ruzhev Alexander
 * @since 15.02.2017
 */
public class Factorial {
    /**
     * Returns factorial of numder.
     *
     * @param number  first number
     * @return int - factorial
     */
    public int getFactorial(int number) {
        int result = 1;
        for (int multiplier = 1; multiplier <= number; multiplier++) {
            result *= multiplier;
        }
        return result;
    }
}