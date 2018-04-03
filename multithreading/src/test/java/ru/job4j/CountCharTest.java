package ru.job4j;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Ruzhev Alexander
 * @since 01.04.2018
 */
public class CountCharTest {
    /**
     * Work offer.
     */
    private static final String OFFER = "Every thread has a priority. Threads with higher priority are executed in preference to threads with lower priority. Each thread may or may not also be marked as a daemon. When code running in some thread creates a new Thread object, the new thread has its priority initially set equal to the priority of the creating thread, and is a daemon thread if and only if the creating thread is a daemon.";

    /**
     * When counter has completed work.
     * @throws Exception - any exceptions
     */
    @Test
    public void whenCounterHasCompletedWork() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Thread countChar = new Thread(new CountChar(100, OFFER));
        countChar.start();
        countChar.join();
        assertThat("This text have 325 symbols;" + System.lineSeparator() + "Thread counter is stopped." + System.lineSeparator(), is(out.toString()));
    }

    /**
     * When counter has been stopped.
     * @throws Exception - any exceptions
     */
    @Test
    public void whenCounterHasStopped() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Thread countChar = new Thread(new CountChar(0, OFFER));
        countChar.start();
        countChar.join();
        assertThat("The time is over. Stopping thread..." + System.lineSeparator() + "Thread counter is stopped." + System.lineSeparator(), is(out.toString()));
    }
}