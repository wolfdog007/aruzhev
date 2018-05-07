package ru.job4j;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementing the producer consumer template.
 *
 * @param <T> generic type
 * @author Ruzhev Alexander
 * @since 07.05.2018
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    /**
     * The queue.
     */
    @GuardedBy("itself")
    private final Queue<T> queue = new LinkedList<>();
    /**
     * The constant - max amount elements to queue.
     */
    private static final int MAX_SIZE = 5;

    /**
     * Add new element to queue.
     *
     * @param value - value for add
     * @throws InterruptedException - exception for thread
     */
    public void offer(T value) throws InterruptedException {
        synchronized (this.queue) {
            while (this.queue.size() == MAX_SIZE) {
                System.out.println("The queue is full: wait...");
                this.queue.wait();
            }
            this.queue.offer(value);
            this.queue.notifyAll();
        }
    }

    /**
     * Returns the head of the queue.
     *
     * @return the head of the queue
     * @throws InterruptedException - exception for thread
     */
    public T poll() throws InterruptedException {
        T result;
        synchronized (this.queue) {
            while (this.queue.isEmpty()) {
                System.out.println("The queue is empty: wait...");
                this.queue.wait();
            }
            result = this.queue.poll();
            this.queue.notifyAll();
        }
        return result;
    }
}