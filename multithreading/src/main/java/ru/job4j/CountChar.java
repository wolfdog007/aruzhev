package ru.job4j;

/**
 * Counting symbols to text and output to console.
 *
 * @author Ruzhev Alexander
 * @since 31.03.2018
 */
public class CountChar implements Runnable {
    /**
     * The time for wait to milliseconds.
     */
    private long ms;
    /**
     * The text from work.
     */
    private String string;

    /**
     * Constructor.
     *
     * @param ms     - time for wait
     * @param string - text from work
     */
    public CountChar(long ms, String string) {
        this.ms = ms;
        this.string = string;
    }

    @Override
    public void run() {
        Thread time = new Thread(new Time(ms, Thread.currentThread()));
        time.start();
        int counter = 0;
        int index = 0;
        while (index < this.string.length() && !Thread.currentThread().isInterrupted()) {
            Thread.yield();
            if (this.string.charAt(index++) != ' ') {
                counter++;
            }
        }
        if (index == this.string.length()) {
            System.out.printf("This text have %d symbols;%s", counter, System.lineSeparator());
        }
        System.out.println("Thread counter is stopped.");
    }
}

/**
 * Wait time. If time is over, stopped other thread.
 */
class Time implements Runnable {
    /**
     * The time for wait to milliseconds.
     */
    private long ms;
    /**
     * The link to thread-work.
     */
    private Thread thread;

    /**
     * Constructor.
     *
     * @param ms     - time for wait
     * @param thread - thread for stopped, if time is over;
     */
    Time(long ms, Thread thread) {
        this.ms = ms;
        this.thread = thread;
    }


    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while (thread.isAlive()) {
            if (System.currentTimeMillis() - start >= this.ms) {
                System.out.println("The time is over. Stopping thread...");
                thread.interrupt();
                break;
            }
        }
    }
}
