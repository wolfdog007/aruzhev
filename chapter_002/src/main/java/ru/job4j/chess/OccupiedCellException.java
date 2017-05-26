package ru.job4j.chess;

/**
 * @author Ruzhev Alexander
 * @since 08.05.2017
 */
public class OccupiedCellException extends Exception {
    /**
     * Constructor.
     * @param msg message
     */
    public OccupiedCellException(String msg) {
        super(msg);
    }
}
