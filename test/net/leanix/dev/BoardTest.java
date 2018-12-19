package net.leanix.dev;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BoardTest {

    @Test
    public void isFinished_finishingRow_win() {
        Board b = new Board();
        b.setBoardState(new Cell[][]{
            {Cell.CROSS, Cell.CROSS, Cell.CROSS},
            {Cell.CIRCLE, Cell.EMPTY, Cell.EMPTY},
            {Cell.EMPTY, Cell.EMPTY, Cell.EMPTY}
        });

        assertTrue(b.checkRows().isPresent());
        assertFalse(b.checkColumns().isPresent());
    }

    @Test
    public void isFinished_finishingRow_noWin() {
        Board b = new Board();
        b.setBoardState(new Cell[][]{
            {Cell.CROSS, Cell.CIRCLE, Cell.CROSS},
            {Cell.CIRCLE, Cell.EMPTY, Cell.EMPTY},
            {Cell.EMPTY, Cell.EMPTY, Cell.EMPTY}
        });

        assertFalse(b.checkRows().isPresent());
    }

    @Test
    public void isFinished_finishingColumn_win() {
        Board b = new Board();
        b.setBoardState(new Cell[][]{
            {Cell.CROSS, Cell.CIRCLE, Cell.CROSS},
            {Cell.CROSS, Cell.EMPTY, Cell.EMPTY},
            {Cell.CROSS, Cell.EMPTY, Cell.EMPTY}
        });

        assertTrue(b.checkColumns().isPresent());

        b.setBoardState(new Cell[][]{
            {Cell.CIRCLE, Cell.CIRCLE, Cell.CIRCLE},
            {Cell.CROSS, Cell.EMPTY, Cell.CIRCLE},
            {Cell.CROSS, Cell.EMPTY, Cell.CIRCLE}
        });
        assertTrue(b.checkColumns().isPresent());
    }

    @Test
    public void isFinished_finishingDiagonal_win() {
        Board b = new Board();
        b.setBoardState(new Cell[][]{
            {Cell.CROSS, Cell.CIRCLE, Cell.CROSS},
            {Cell.CROSS, Cell.CROSS, Cell.EMPTY},
            {Cell.CIRCLE, Cell.EMPTY, Cell.CROSS}
        });

        assertTrue(b.checkDiagonal().isPresent());
        assertFalse(b.checkReverseDiagonal().isPresent());
    }

}