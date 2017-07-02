package ru.job4j.chess;

/**
 * Abstract class figure.
 *
 * @author Ruzhev Alexander
 * @since 08.05.2017
 */
public abstract class Figure {
    /**
     * Position on the board.
     */
    final Cell position;

    /**
     * Constructor.
     * @param position on the board
     */
    public Figure(Cell position) {
        this.position = position;
    }
    /**
     * The method returns the path in the specified cell.
     * @param dist the end of the way
     * @return array of distance
     * @throws ImpossibleMoveException - illegal move for that figure
     */
    abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    /**
     * Clone figure.
     * @param dist position Cell
     * @return new Figure
     */
    abstract Figure clone(Cell dist);
}
