package ru.job4j.chess;

import static ru.job4j.chess.Board.LINE_X;

/**
 * Class Rook extends Figure.
 *
 * @author Ruzhev Alexander
 * @since 10.05.2017
 */
public class Rook extends Figure {
    /**
     * Figure name.
     */
    private String name = "Rook";
    /**
     * Figure color.
     */
    private String color;

    /**
     * Constructor.
     * @param position on board.
     */
    public Rook(Cell position) {
        super(position);
    }

    /**
     * Constructor.
     * @param position on board.
     * @param color - figure color
     */
    public Rook(Cell position, String color) {
        super(position);
        this.color = color;
    }

    /**
     * The method returns the path in the specified cell.
     * @param dist the end of the way
     * @return array of distance
     * @throws ImpossibleMoveException - illegal move for that figure
     */
    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        int distance = Math.abs(super.position.getPositionY() - dist.getPositionY());
        Cell[] result = new Cell[distance];
        int x = super.position.getPositionX();
        int y = super.position.getPositionY();
        int checkX = x > dist.getPositionX() ? x - distance : x + distance;
        int checkY = y > dist.getPositionY() ? y - distance : y + distance;
        if (dist.getPositionX() == checkX && dist.getPositionY() == checkY) {
            for (int i = 0; i < distance; i++) {
                x = super.position.getPositionX() > dist.getPositionX() ? --x : ++x;
                y = super.position.getPositionY() > dist.getPositionY() ? --y : ++y;
                result[i] = new Cell(String.format("%s%s", LINE_X[x], y + 1));
            }
        } else {
            throw new ImpossibleMoveException("Move impossible");
        }
        return result;
    }

    /**
     * Clone figure.
     * @param dist position Cell
     * @return new Figure
     */
    @Override
    public Figure clone(Cell dist) {
        return new Rook(dist);
    }

    /**
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return color
     */
    public String getColor() {
        return this.color;
    }
}
