package ru.job4j.map4bank.exceptions;

/**
 * Account not found exception.
 *
 * @author Ruzhev Alexander
 * @since 13.09.2017
 */
public class AccountNotFoundException extends RuntimeException {
    /**
     * Constructor.
     *
     * @param msg - error message
     */
    public AccountNotFoundException(String msg) {
        super(msg);
    }
}
