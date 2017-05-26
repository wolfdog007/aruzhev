package ru.job4j.chess;

import static ru.job4j.chess.Board.LINE_X;

/**
 * class Cell, describes a cell on board.
 *
 * @author Ruzhev Alexander
 * @since 08.05.2017
 */
public class Cell {
    /**
     * Position on the board.
     */
    private String position;

    /**
     * Constructor.
     * @param position on the board
     */
    public Cell(String position) {
        this.position = position;
    }

    /**
     * Method returns Y from position.
     * @return position y
     */
    public int getPositionY() {
        char crY = this.position.charAt(1);
        int positionY = Character.getNumericValue(crY);
        return positionY - 1;
    }

    /**
     * Method returns X from position.
     * @return position x
     */
    public int getPositionX() {
        int positionX = -1;
        for (int i = 0; i < LINE_X.length; i++) {
            if (this.position.contains(LINE_X[i])) {
                positionX = i;
                break;
            }
        }
        return positionX;
    }

    /**
     *
     * @return position
     */
    public String getPosition() {
        return this.position;
    }
}
