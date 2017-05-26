package ru.job4j.chess;

/**
 * @author Ruzhev Alexander
 * @since 08.05.2017
 */
public class OccupiedWayException extends Exception {
    /**
     * Constructor.
     *
     * @param msg message
     */
    public OccupiedWayException(String msg) {
        super(msg);
    }
}
