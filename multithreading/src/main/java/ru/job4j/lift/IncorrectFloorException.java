package ru.job4j.lift;

/**
 * @author Ruzhev Alexander
 * @since 27.09.2018
 */
public class IncorrectFloorException extends RuntimeException {
    /**
     * Constructor.
     * @param message - error message
     */
    public IncorrectFloorException(String message) {
        super(message);
    }
}
