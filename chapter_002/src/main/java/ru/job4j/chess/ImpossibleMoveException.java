package ru.job4j.chess;

/**
 * @author Ruzhev Alexander
 * @since 08.05.2017
 */
public class ImpossibleMoveException extends Exception {
    /**
     * Constructor.
     * @param msg message
     */
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}
