package ru.job4j.chess;

/**
 * @author Ruzhev Alexander
 * @since 08.05.2017
 */
public class FigureNotFoundException extends Exception {
    /**
     * Constructor.
     * @param msg message
     */
    FigureNotFoundException(String msg) {
        super(msg);
    }
}
