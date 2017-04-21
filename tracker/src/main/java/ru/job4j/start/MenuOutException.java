package ru.job4j.start;

/**
 * The output for valid values.
 *
 * @author Ruzhev Alexander
 * @since 21.04.2017
 */
public class MenuOutException extends RuntimeException {
    /**
     *Constructor.
     * @param msg - message.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
