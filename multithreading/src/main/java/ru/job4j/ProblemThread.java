package ru.job4j;

/**
 * Test class illustrating the problem of multithreading.
 *
 * @author Ruzhev Alexander
 * @since 06.04.2018
 */
public class ProblemThread implements Runnable {
    /**
     * Object for test.
     */
    private Increment number;
    /**
     * Number of test calls.
     */
    private int count;

    /**
     * Constructor.
     *
     * @param number -Object for test
     * @param count  - Number of test calls
     */
    public ProblemThread(Increment number, int count) {
        this.number = number;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            number.inc();
        }
    }
}

/**
 * Object for test.
 */
class Increment {
    /**
     * Counter.
     */
    private int count = 0;

    /**
     * Getter for counter.
     *
     * @return - count
     */
    public int getCount() {
        return count;
    }

    /**
     * Incrementer for counter.
     */
    public void inc() {
        this.count++;
    }
}