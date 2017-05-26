package ru.job4j.chess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class RookTest.
 *
 * @author Ruzhev Alexander
 * @since 11.05.2017
 */
public class RookTest {
    /**
     * test true way.
     * @throws OccupiedCellException occupied cell
     * @throws ImpossibleMoveException - impossible move
     */
    @Test
    public void whenRookWayThenReturnWayArray() throws OccupiedCellException, ImpossibleMoveException {
        Board board = new Board();
        Cell[] checkedArray = new Cell[]{new Cell("d4"), new Cell("c3"), new Cell("b2"), new Cell("a1")};
        board.addFigure(new Rook(new Cell("e5")));
        Cell[] wayArray = board.getFigure(0).way(new Cell("a1"));
        assertThat(wayArray[0].getPosition(), is(checkedArray[0].getPosition()));
        assertThat(wayArray[1].getPosition(), is(checkedArray[1].getPosition()));
        assertThat(wayArray[2].getPosition(), is(checkedArray[2].getPosition()));
        assertThat(wayArray[3].getPosition(), is(checkedArray[3].getPosition()));
    }

    /**
     * test ImpossibleMoveException.
     * @throws ImpossibleMoveException impossible move
     * @throws OccupiedCellException occupied cell
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenRookWayThenImpossibleMoveException() throws ImpossibleMoveException, OccupiedCellException {
        Board board = new Board();
        board.addFigure(new Rook(new Cell("e5")));
        Cell[] wayArray = board.getFigure(0).way(new Cell("e8"));
    }
}