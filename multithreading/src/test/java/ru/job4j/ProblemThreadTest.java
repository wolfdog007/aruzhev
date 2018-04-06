package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ruzhev Alexander
 * @since 06.04.2018
 */
public class ProblemThreadTest {
    /**
     * Test counter.
     */
    private static final int NUMBER = 100_000_000;

    /**
     * Data race - demonstration of the problem.
     *
     * @throws Exception - any exception
     */
    @Test
    public void run() throws Exception {
        Increment inc = new Increment();
        Thread test1 = new Thread(new ProblemThread(inc, NUMBER));
        Thread test2 = new Thread(new ProblemThread(inc, NUMBER));
        Thread test3 = new Thread(new ProblemThread(inc, NUMBER));
        Thread test4 = new Thread(new ProblemThread(inc, NUMBER));
        Thread test5 = new Thread(new ProblemThread(inc, NUMBER));
        test1.start();
        test2.start();
        test3.start();
        test4.start();
        test5.start();
        test1.join();
        test2.join();
        test3.join();
        test4.join();
        test5.join();
        System.out.println(inc.getCount());
        assertThat(false, is(inc.getCount() == NUMBER * 5));
    }
}