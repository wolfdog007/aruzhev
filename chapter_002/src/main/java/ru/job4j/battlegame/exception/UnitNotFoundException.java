package ru.job4j.battlegame.exception;

/**
 * UnitNotFoundException.
 *
 * @author Ruzhev Alexander
 * @since on 30.06.2017.
 */
public class UnitNotFoundException extends RuntimeException {
    /**
     * Print Exception to console.
     *
     * @param msg - description.
     */
    public UnitNotFoundException(String msg) {
        super(msg);
    }
}
