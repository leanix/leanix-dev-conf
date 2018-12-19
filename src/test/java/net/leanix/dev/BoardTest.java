package net.leanix.dev;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;
import org.junit.Test;

public class BoardTest {
    @Test
    public void checksIsFull() {
        Board board = new Board();
        board.set(BoardConstants.PLAYER_ONE, 0, 0);
        board.set(BoardConstants.PLAYER_ONE, 1, 0);
        board.set(BoardConstants.PLAYER_TWO, 2, 0);
        board.set(BoardConstants.PLAYER_TWO, 0, 1);
        board.set(BoardConstants.PLAYER_TWO, 1, 1);
        board.set(BoardConstants.PLAYER_ONE, 2, 1);
        board.set(BoardConstants.PLAYER_ONE, 0, 2);
        board.set(BoardConstants.PLAYER_ONE, 1, 2);
        board.set(BoardConstants.PLAYER_ONE, 2, 2);
        assertTrue(board.isFull());
    }

    @Test
    public void checkIsNotFull() {
        Board board = new Board();
        assertFalse(board.isFull());
    }

    @Test
    public void checksIsNotFullPartial() {
        Board board = new Board();
        board.set(BoardConstants.PLAYER_ONE, 0, 0);
        board.set(BoardConstants.PLAYER_ONE, 1, 0);
        board.set(BoardConstants.PLAYER_ONE, 2, 0);
        assertFalse(board.isFull());
    }

    @Test
    public void checksIsNotFullPartialEmpty() {
        Board board = new Board();
        board.set(BoardConstants.EMPTY, 0, 0);
        board.set(BoardConstants.EMPTY, 1, 0);
        assertFalse(board.isFull());
    }

    @Test
    public void determinesWinnerOneHorizontal() {
        Board board = new Board();
        board.set(BoardConstants.PLAYER_ONE, 0, 0);
        board.set(BoardConstants.PLAYER_ONE, 0, 1);
        board.set(BoardConstants.PLAYER_ONE, 0, 2);

        Optional<BoardConstants> winner = board.determineWinner();
        assertEquals(Optional.of(BoardConstants.PLAYER_ONE), winner);
    }

    @Test
    public void determinesNotWinnerOneHorizontal() {
        Board board = new Board();
        board.set(BoardConstants.PLAYER_ONE, 0, 0);
        board.set(BoardConstants.PLAYER_ONE, 0, 1);
        board.set(BoardConstants.PLAYER_TWO, 0, 2);

        Optional<BoardConstants> winner = board.determineWinner();
        assertEquals(Optional.empty(), winner);
    }

    @Test
    public void determinesWinnerOneVertical() {
        Board board = new Board();
        board.set(BoardConstants.PLAYER_ONE, 0, 0);
        board.set(BoardConstants.PLAYER_ONE, 1, 0);
        board.set(BoardConstants.PLAYER_ONE, 2, 0);

        Optional<BoardConstants> winner = board.determineWinner();
        assertEquals(Optional.of(BoardConstants.PLAYER_ONE), winner);
    }

    @Test
    public void determinesNotWinnerOneVertical() {
        Board board = new Board();
        board.set(BoardConstants.PLAYER_ONE, 0, 0);
        board.set(BoardConstants.PLAYER_TWO, 1, 0);
        board.set(BoardConstants.PLAYER_ONE, 2, 0);

        Optional<BoardConstants> winner = board.determineWinner();
        assertEquals(Optional.empty(), winner);
    }

    @Test
    public void determinesWinnerOneDiagonal1() {
        Board board = new Board();
        board.set(BoardConstants.PLAYER_ONE, 0, 0);
        board.set(BoardConstants.PLAYER_ONE, 1, 1);
        board.set(BoardConstants.PLAYER_ONE, 2, 2);

        Optional<BoardConstants> winner = board.determineWinner();
        assertEquals(Optional.of(BoardConstants.PLAYER_ONE), winner);
    }

    @Test
    public void determinesNotWinnerOneDiagonal1() {
        Board board = new Board();
        board.set(BoardConstants.PLAYER_ONE, 0, 0);
        board.set(BoardConstants.PLAYER_TWO, 1, 1);
        board.set(BoardConstants.PLAYER_ONE, 2, 2);

        Optional<BoardConstants> winner = board.determineWinner();
        assertEquals(Optional.empty(), winner);
    }

    @Test
    public void determinesWinnerOneDiagonal2() {
        Board board = new Board();
        board.set(BoardConstants.PLAYER_ONE, 2, 0);
        board.set(BoardConstants.PLAYER_ONE, 1, 1);
        board.set(BoardConstants.PLAYER_ONE, 0, 2);

        Optional<BoardConstants> winner = board.determineWinner();
        assertEquals(Optional.of(BoardConstants.PLAYER_ONE), winner);
    }

    @Test
    public void determinesNotWinnerOneDiagonal2() {
        Board board = new Board();
        board.set(BoardConstants.PLAYER_ONE, 2, 0);
        board.set(BoardConstants.PLAYER_TWO, 1, 1);
        board.set(BoardConstants.PLAYER_ONE, 0, 2);

        Optional<BoardConstants> winner = board.determineWinner();
        assertEquals(Optional.empty(), winner);
    }

    @Test
    public void getsColumn() {
        Board board = new Board();
        board.set(BoardConstants.PLAYER_ONE, 0, 0);
        board.set(BoardConstants.PLAYER_TWO, 1, 0);
        board.set(BoardConstants.PLAYER_ONE, 2, 0);

        BoardConstants[] col = board.getCol(0);
        assertEquals(col[0], BoardConstants.PLAYER_ONE);
        assertEquals(col[1], BoardConstants.PLAYER_TWO);
        assertEquals(col[2], BoardConstants.PLAYER_ONE);
    }

    @Test
    public void getsElement() {
        Board board = new Board();
        board.set(BoardConstants.PLAYER_ONE, 0, 0);
        board.set(BoardConstants.PLAYER_TWO, 1, 0);
        board.set(BoardConstants.PLAYER_ONE, 2, 0);

        Optional<BoardConstants> element = board.get(0, 0);
        assertEquals(Optional.of(BoardConstants.PLAYER_ONE), element);
    }

    @Test
    public void doesNotGetElement() {
        Board board = new Board();
        board.set(BoardConstants.PLAYER_ONE, 0, 0);
        board.set(BoardConstants.PLAYER_TWO, 1, 0);
        board.set(BoardConstants.PLAYER_ONE, 2, 0);

        Optional<BoardConstants> element = board.get(3, 0);
        assertEquals(Optional.empty(), element);
    }
}
