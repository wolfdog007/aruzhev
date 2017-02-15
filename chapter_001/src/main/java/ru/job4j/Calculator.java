package ru.job4j;

/**
 * Class Calculator job chapter_001 calculator.
 *
 * @author Ruzhev Alexander
 * @since 15.02.2017
 */
class Calculator {
    /**
     * @param result is double
     */
    private double result;

    /**
     * Returns result.
     *
     * @return result
     */
    public double getResult() {
        return this.result;
    }

    /**
     * Add sum two numbers.
     *
     * @param first  first arg
     * @param second second arg
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Subtraction.
     *
     * @param first  first arg
     * @param second second arg
     */
    public void substruct(double first, double second) {
        this.result = first - second;
    }

    /**
     * Div.
     *
     * @param first  first arg
     * @param second second arg
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Multiple.
     *
     * @param first  first arg
     * @param second second arg
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }
}