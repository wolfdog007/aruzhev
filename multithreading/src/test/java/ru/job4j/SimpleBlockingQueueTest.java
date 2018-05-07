package ru.job4j;

import org.junit.Test;


/**
 * Test for SimpleBlockingQueue.
 *
 * @author Ruzhev Alexander
 * @since 07.05.2018
 */
public class SimpleBlockingQueueTest {
    /**
     * Test for two threads (producer, consumer).
     *
     * @throws Exception - any exceptions
     */
    @Test
    public void whenWork2threads() throws Exception {
        SimpleBlockingQueue<Integer> blockingQueue = new SimpleBlockingQueue<>();
        Thread producer = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    try {
                        System.out.println("prod = " + i);
                        blockingQueue.offer(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread consumer = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    try {
                        System.out.println("cons = " + blockingQueue.poll());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        producer.start();
        consumer.start();
        producer.join();
    }
}