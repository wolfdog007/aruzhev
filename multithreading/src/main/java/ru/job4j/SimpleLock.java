package ru.job4j;

import net.jcip.annotations.ThreadSafe;

/**
 * SimpleLock - locker.
 *
 * @author Ruzhev Alexander
 * @since 22.05.2018
 */
@ThreadSafe
public class SimpleLock {
    /**
     * Flag of lock state.
     */
    private boolean isLocked = false;

    /**
     * When lock.
     *
     * @throws InterruptedException - exception for thread
     */
    public void lock() throws InterruptedException {
        synchronized (this) {
            while (isLocked) {
                this.wait();
            }
            this.isLocked = true;
        }
    }

    /**
     * When unlock.
     *
     * @throws InterruptedException - exception for thread
     */
    public void unlock() throws InterruptedException {
        synchronized (this) {
            while (!isLocked) {
                this.wait();
            }
            this.isLocked = false;
            this.notifyAll();
        }
    }
}
