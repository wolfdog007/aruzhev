package ru.job4j.chess;


/**
 * Chessboard class.
 *
 * @author Ruzhev Alexander
 * @since 08.05.2017
 */
public class Board {
    /**
     * Constant line x.
     */
    public static final String[] LINE_X = {"a", "b", "c", "d", "e", "f", "g", "h"};
    /**
     * Array of figures.
     */
    private Figure[] figures = new Figure[64];
    /**
     * index of figures array.
     */
    private int figureIndex = 0;

    /**
     * Add new figure.
     *
     * @param figure - new figure.
     * @throws OccupiedCellException Occupied cell
     */
    public void addFigure(Figure figure) throws OccupiedCellException {
        for (int i = 0; i < figureIndex; i++) {
            if (figures[i].position.getPosition().equals(figure.position.getPosition())) {
                throw new OccupiedCellException("Occupied Cell");
            }
        }
        figures[figureIndex++] = figure;
    }

    /**
     * Delete figure.
     *
     * @param figure - figure on removing.
     * @throws FigureNotFoundException - Figure not found
     */
    public void deleteFigure(Figure figure) throws FigureNotFoundException {
        boolean flag = true;
        for (int i = 0; i < figureIndex; i++) {
            if (figures[i].position.getPosition().equals(figure.position.getPosition())) {
                System.arraycopy(figures, i + 1, figures, i, figures.length - i - 1);
                figureIndex--;
                flag = false;
                break;
            }
            if (flag) {
                throw new FigureNotFoundException("Figure not found");
            }
        }
    }

    /**
     * This method checks the possibility of move.
     *
     * @param source cell
     * @param dist   cell
     * @return boolean true or exception
     * @throws ImpossibleMoveException - illegal move for that figure
     * @throws OccupiedWayException    - Occupied way
     * @throws FigureNotFoundException - Figure not found
     */
    boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean flag = false;
        for (int i = 0; i < figureIndex; i++) {
            if (figures[i].position.getPosition().equals(source.getPosition())) {
                Cell[] arrayWay = figures[i].way(dist);
                for (i = 0; i < arrayWay.length; i++) {
                    for (int j = 0; j < figureIndex; j++) {
                        if (figures[j].position.getPosition().equals(arrayWay[i].getPosition())) {
                            throw new OccupiedWayException("Occupied way");
                        }
                    }
                }
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new FigureNotFoundException("Figure not found");
        }
        return flag;
    }

    /**
     * @param index of figures array.
     * @return figure.
     */
    public Figure getFigure(int index) {
        return figures[index];
    }

    /**
     * Moves a figure to a new position.
     *
     * @param source cell
     * @param dist   cell
     * @throws OccupiedWayException    - Occupied way
     * @throws FigureNotFoundException - Figure not found
     * @throws ImpossibleMoveException - impossible move.
     */
    public void moveFigure(Cell source, Cell dist) throws OccupiedWayException, FigureNotFoundException, ImpossibleMoveException {
        if (move(source, dist)) {
            for (int i = 0; i < figureIndex; i++) {
                if (figures[i].position.getPosition().equals(source.getPosition())) {
                    figures[i] = figures[i].clone(dist);
                    break;
                }
            }
        }
    }
}
