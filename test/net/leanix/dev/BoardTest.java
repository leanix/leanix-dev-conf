package net.leanix.dev;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;
import net.leanix.dev.Board.FinishedState;
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

    @Test
    public void isFinished_finishingReverseDiagonal_win() {
        Board b = new Board();
        b.setBoardState(new Cell[][]{
            { Cell.CROSS, Cell.CIRCLE, Cell.CROSS},
            { Cell.CROSS, Cell.CROSS, Cell.EMPTY},
            { Cell.CROSS, Cell.EMPTY, Cell.CIRCLE}
        });

        assertFalse(b.checkDiagonal().isPresent());
        assertTrue(b.checkReverseDiagonal().isPresent());
    }

    @Test
    public void isBoardFull_empty() {
        Board b = new Board();
        b.setBoardState(new Cell[][]{
            { Cell.CROSS, Cell.CIRCLE, Cell.CROSS},
            { Cell.CROSS, Cell.CROSS, Cell.EMPTY},
            { Cell.CROSS, Cell.CIRCLE, Cell.CIRCLE}
        });

        assertFalse(b.isBoardFull());

        b.setBoardState(new Cell[][]{
            { Cell.CROSS, Cell.CIRCLE, Cell.CROSS},
            { Cell.CROSS, Cell.CROSS, Cell.CIRCLE},
            { Cell.CROSS, Cell.CIRCLE, Cell.CIRCLE}
        });
        assertTrue(b.isBoardFull());
    }

    @Test
    public void isDraw() {
        Board b = new Board();
        b.setBoardState(new Cell[][]{
            { Cell.CROSS, Cell.CIRCLE, Cell.CIRCLE},
            { Cell.CIRCLE, Cell.CROSS, Cell.CROSS},
            { Cell.CROSS, Cell.CIRCLE, Cell.CIRCLE}
        });

        Optional<FinishedState> finished = b.isFinished();
        assertTrue(finished.isPresent());
        assertTrue(finished.get().isDraw());


        b.setBoardState(new Cell[][]{
            { Cell.CROSS, Cell.CIRCLE, Cell.CROSS},
            { Cell.CIRCLE, Cell.CIRCLE, Cell.CIRCLE},
            { Cell.CIRCLE, Cell.CIRCLE, Cell.CROSS}
        });
        assertTrue(b.isBoardFull());
    }
}