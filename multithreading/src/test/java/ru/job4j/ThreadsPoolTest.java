package ru.job4j;

import org.junit.Test;

/**
 * Test for ThreadsPool.
 *
 * @author Ruzhev Alexander
 * @since 08.05.2018
 */
public class ThreadsPoolTest {
    /**
     * Time in ms.
     */
    private static final int TIME_DELAY_WORK = 100;

    /**
     * Test for add.
     *
     * @throws Exception - any exception
     */
    @Test
    public void add() throws Exception {
        ThreadsPool pool = new ThreadsPool();
        for (int i = 0; i < 100; i++) {
            pool.add(new Work(String.format("Work:%d", i), TIME_DELAY_WORK));
            if (i == 50) {
                pool.startThread();
            }
        }
        Thread.currentThread().sleep(10000);
        System.out.println("Stopped");
        pool.stopThreads();
    }
}