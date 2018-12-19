package net.leanix.dev;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
}
