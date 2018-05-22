package ru.job4j;

import org.junit.Test;

import java.util.LinkedList;

/**
 * Test for SimpleLock.
 *
 * @author Ruzhev Alexander
 * @since 22.05.2018
 */
public class SimpleLockTest {
    /**
     * Test for SimpleLock.
     *
     * @throws Exception - any exception
     */
    @Test
    public void whenLockAndUnlock() throws Exception {
        SimpleLock locker = new SimpleLock();
        LinkedList<Thread> threads = new LinkedList<>();
        for (int i = 1; i < 6; i++) {
            Thread thread = new Thread() {
                private int operationNumber = 1;

                @Override
                public void run() {
                    try {
                        locker.lock();
                        for (int i = 1; i < 5; i++) {
                            System.out.printf("%s %d%s", Thread.currentThread().getName(), i, System.lineSeparator());
                            Thread.sleep(100);
                        }
                        locker.unlock();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.setName("Thread " + i);
            threads.offer(thread);
            thread.start();
        }
        while (!threads.isEmpty()) {
            threads.poll().join();
        }
    }
}
