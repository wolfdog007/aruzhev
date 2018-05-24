package ru.job4j.nonblockingcache;

/**
 * @author Ruzhev Alexander
 * @since 24.05.2018
 */
public class OptimisticException extends RuntimeException {
    /**
     * Constructor.
     * @param message - exception message
     */
    OptimisticException(String message) {
        super(message);
    }
}
