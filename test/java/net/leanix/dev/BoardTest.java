package net.leanix.dev;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Test;

public class BoardTest {

    @Test
    public void getOngoingStateTest() {
        Board board = new Board();
        try {
            GameState state = board.getUpdatedState();
            assertEquals(state, GameState.ONGOING);
        } catch (Exception ex) {
            assertTrue(false);
        }
    }


    @Test
    public void getWin1FirstRowStateTest() {
        Board board = new Board();

        // set cells
        Arrays.fill(board.cells[0], CellState.X);

        try {
            GameState state = board.getUpdatedState();
            assertEquals(state, GameState.WIN1);
        } catch (Exception ex) {
            assertTrue(false);
        }
    }


    @Test
    public void getWin2FirstRowStateTest() {
        Board board = new Board();

        // set cells
        Arrays.fill(board.cells[0], CellState.O);

        try {
            GameState state = board.getUpdatedState();
            assertEquals(state, GameState.WIN2);
        } catch (Exception ex) {
            assertTrue(false);
        }
    }


    @Test
    public void getWin1FirstColumnStateTest() {
        Board board = new Board();

        // set cells
        board.cells[0][0] = CellState.X;
        board.cells[1][0] = CellState.X;
        board.cells[2][0] = CellState.X;

        try {
            GameState state = board.getUpdatedState();
            assertEquals(state, GameState.WIN1);
        } catch (Exception ex) {
            assertTrue(false);
        }
    }

    @Test
    public void getWin1DiagonalStateTest() {
        Board board = new Board();

        // set cells
        board.cells[0][0] = CellState.X;
        board.cells[1][1] = CellState.X;
        board.cells[2][2] = CellState.X;

        try {
            GameState state = board.getUpdatedState();
            assertEquals(state, GameState.WIN1);
        } catch (Exception ex) {
            assertTrue(false);
        }
    }
}
