package ru.job4j.map4bank.exceptions;

/**
 * Account funds exception.
 *
 * @author Ruzhev Alexander
 * @since 13.09.2017
 */
public class AccountFundsException extends RuntimeException {
    /**
     * Constructor.
     *
     * @param msg - error message
     */
    public AccountFundsException(String msg) {
        super(msg);
    }
}
