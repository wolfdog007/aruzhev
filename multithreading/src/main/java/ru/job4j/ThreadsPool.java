package ru.job4j;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The class ThreadPool - work with queue, use threads.
 *
 * @author Ruzhev Alexander
 * @since 15.05.2018
 */
@ThreadSafe
public class ThreadsPool {
    /**
     * The constant - amount processors to computer.
     */
    private static final int AMOUNT_CPU = Runtime.getRuntime().availableProcessors();
    /**
     * The collection queue for work threads.
     */
    @GuardedBy("itself")
    private final LinkedList<Work> queue;
    /**
     * The collection for threads.
     */
    private final List<Producer> groupThread;

    /**
     * Constructor.
     */
    public ThreadsPool() {
        this.queue = new LinkedList<>();
        this.groupThread = new ArrayList<>();
    }

    /**
     * Add new work.
     *
     * @param work new work
     */
    public void add(Work work) {
        synchronized (this.queue) {
            this.queue.addLast(work);
            System.out.println("add " + work);
            this.queue.notify();
        }
    }

    /**
     * The method start threads, equals amount cpu to computer.
     */
    public void startThread() {
        Producer producer;
        for (int amount = 0; amount < AMOUNT_CPU; amount++) {
            producer = new Producer(String.format("Thread:%d", amount + 1));
            this.groupThread.add(producer);
            producer.start();
        }
    }

    /**
     * The method stopped threads.
     *
     * @throws InterruptedException - interrupted exception
     */
    public void stopThreads() throws InterruptedException {
        for (Producer producer : this.groupThread) {
            producer.interrupt();
        }
    }

    /**
     * The inner class producer.
     */
    private class Producer extends Thread {
        /**
         * Constructor.
         *
         * @param name - work name
         */
        Producer(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.printf("%s is start;%s", this.getName(), System.lineSeparator());
            try {
                while (!this.isInterrupted()) {
                    synchronized (ThreadsPool.this.queue) {
                        while (ThreadsPool.this.queue.isEmpty()) {
                            System.out.printf("%s is wait...%s", Thread.currentThread().getName(), System.lineSeparator());
                            ThreadsPool.this.queue.wait();
                        }
                        Work work = ThreadsPool.this.queue.poll();
                        work.run();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s is stop;%s", this.getName(), System.lineSeparator());
        }
    }
}