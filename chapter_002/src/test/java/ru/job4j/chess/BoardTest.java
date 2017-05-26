package ru.job4j.chess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class BoardTest.
 *
 * @author Ruzhev Alexander
 * @since 13.05.2017.
 */
public class BoardTest {
    /**
     * test add new figure is true.
     *
     * @throws OccupiedCellException occupied cell
     */
    @Test
    public void whenAddFigure() throws OccupiedCellException {
        Board board = new Board();
        board.addFigure(new Rook(new Cell("e5")));
        board.addFigure(new Rook(new Cell("a5")));
        assertThat("e5", is(board.getFigure(0).position.getPosition()));
        assertThat("a5", is(board.getFigure(1).position.getPosition()));
    }

    /**
     * test add new figure is OccupiedCellException.
     *
     * @throws OccupiedCellException - occupied cell
     */
    @Test(expected = OccupiedCellException.class)
    public void whenAddFigureThenOccupiedCellException() throws OccupiedCellException {
        Board board = new Board();
        board.addFigure(new Rook(new Cell("e5")));
        board.addFigure(new Rook(new Cell("e5")));
    }

    /**
     * test deleteFigure is true.
     *
     * @throws OccupiedCellException   - occupied cell
     * @throws FigureNotFoundException - Figure not found
     */
    @Test
    public void whenDeleteFigure() throws OccupiedCellException, FigureNotFoundException {
        Board board = new Board();
        board.addFigure(new Rook(new Cell("e5")));
        board.deleteFigure(board.getFigure(0));
        assertThat(null, is(board.getFigure(0)));
    }

    /**
     * test deleteFigure is FigureNotFoundException.
     *
     * @throws OccupiedCellException   - occupied cell
     * @throws FigureNotFoundException - Figure not found
     */
    @Test
    public void whenDeleteFigureThenFigureNotFoundException() throws OccupiedCellException, FigureNotFoundException {
        Board board = new Board();
        board.deleteFigure(new Rook(new Cell("e5")));
    }

    /**
     * Test move is true.
     *
     * @throws OccupiedCellException   - occupied cell
     * @throws OccupiedWayException    - Occupied way
     * @throws FigureNotFoundException - Figure not found
     * @throws ImpossibleMoveException - impossible move
     */
    @Test
    public void whenMoveThenTrue() throws OccupiedCellException, OccupiedWayException, FigureNotFoundException, ImpossibleMoveException {
        Board board = new Board();
        board.addFigure(new Rook(new Cell("e5")));
        board.addFigure(new Rook(new Cell("a5")));
        assertThat(true, is(board.move(new Cell(board.getFigure(0).position.getPosition()), new Cell("e5"))));
    }

    /**
     * Test moveFigure is true.
     *
     * @throws OccupiedCellException   - occupied cell
     * @throws OccupiedWayException    - Occupied way
     * @throws FigureNotFoundException - Figure not found
     * @throws ImpossibleMoveException - impossible move
     */
    @Test
    public void whenMoveFigureThenNewPosition() throws OccupiedCellException, OccupiedWayException, FigureNotFoundException, ImpossibleMoveException {
        Board board = new Board();
        board.addFigure(new Rook(new Cell("e5")));
        board.moveFigure(new Cell("e5"), new Cell("c3"));
        assertThat("c3", is(board.getFigure(0).position.getPosition()));
    }

    /**
     * Test OccupiedWayException.
     *
     * @throws OccupiedCellException   - occupied cell
     * @throws OccupiedWayException    - Occupied way
     * @throws FigureNotFoundException - Figure not found
     * @throws ImpossibleMoveException - impossible move
     */
    @Test(expected = OccupiedWayException.class)
    public void whenMoveThenOccupiedWayException() throws OccupiedCellException, OccupiedWayException, FigureNotFoundException, ImpossibleMoveException {
        Board board = new Board();
        board.addFigure(new Rook(new Cell("e5")));
        board.addFigure(new Rook(new Cell("a5")));
        board.moveFigure(new Cell("a5"), new Cell("c3"));
        board.move(new Cell("e5"), new Cell("b2"));
    }

    /**
     * Test ImpossibleMoveException.
     *
     * @throws OccupiedCellException   - occupied cell
     * @throws OccupiedWayException    - Occupied way
     * @throws FigureNotFoundException - Figure not found
     * @throws ImpossibleMoveException - impossible move
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveThenImpossibleMoveException() throws OccupiedCellException, OccupiedWayException, FigureNotFoundException, ImpossibleMoveException {
        Board board = new Board();
        board.addFigure(new Rook(new Cell("e5")));
        board.move(new Cell("e5"), new Cell("b3"));
    }

    /**
     * Test FigureNotFoundException.
     *
     * @throws OccupiedCellException   - occupied cell
     * @throws OccupiedWayException    - Occupied way
     * @throws FigureNotFoundException - Figure not found
     * @throws ImpossibleMoveException - impossible move
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenMoveThenFigureNotFoundException() throws OccupiedCellException, OccupiedWayException, FigureNotFoundException, ImpossibleMoveException {
        Board board = new Board();
        board.addFigure(new Rook(new Cell("e5")));
        board.move(new Cell("f6"), new Cell("b2"));
    }
}
