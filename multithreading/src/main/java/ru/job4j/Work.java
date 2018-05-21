package ru.job4j;

/**
 * @author Ruzhev Alexander
 * @since 17.05.2018
 */
public class Work extends Thread {
    /**
     * Time in ms.
     */
    private final int delayMS;

    /**
     * Constructor.
     *
     * @param name    work name
     * @param delayMS - time in ms
     */
    public Work(String name, int delayMS) {
        super(name);
        this.delayMS = delayMS;
    }

    @Override
    public void run() {
        System.out.printf("   %s start work...;%s%s", Thread.currentThread().getName(), this.getName(), System.lineSeparator());
        try {
            Thread.sleep(this.delayMS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("   %s stop work...;%s", this.getName(), System.lineSeparator());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
