package ru.job4j.map4bank.exceptions;

/**
 * User not found exception.
 *
 * @author Ruzhev Alexander
 * @since 13.09.2017
 */
public class UserNotFoundException extends RuntimeException {
    /**
     * Constructor.
     *
     * @param msg - error message
     */
    public UserNotFoundException(String msg) {
        super(msg);
    }
}
