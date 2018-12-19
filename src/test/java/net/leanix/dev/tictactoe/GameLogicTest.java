package net.leanix.dev.tictactoe;

import org.junit.Test;

public class GameLogicTest {

    private GameLogic gameLogic= new GameLogic();

    @Test
    public void testEmptyBoard() {
        Board board = new Board();
        org.junit.Assert.assertEquals(gameLogic.getGameState(board), GameLogic.GameState.IN_PROGRESS);
    }

    @Test
    public void testForInProgress() {
        Board board = new Board();
        board.setState(new int[]{
            1, 2, 2,
            0, 1, 1,
            2, 1, 2
        });
        org.junit.Assert.assertEquals(gameLogic.getGameState(board), GameLogic.GameState.IN_PROGRESS);
    }

    @Test
    public void testForDraw() {
        Board board = new Board();
        board.setState(new int[]{
            1, 2, 2,
            2, 1, 1,
            2, 1, 2
        });
        org.junit.Assert.assertEquals(gameLogic.getGameState(board), GameLogic.GameState.DRAW);
    }

    @Test
    public void testForRowWin() {
        Board board = new Board();
        board.setState(new int[]{
            1, 2, 2,
            1, 1, 1,
            2, 1, 2
        });
        org.junit.Assert.assertEquals(gameLogic.getGameState(board), GameLogic.GameState.WIN_PLAYER_1);
    }

    @Test
    public void testForColumnWin() {
        Board board = new Board();
        board.setState(new int[]{
            2, 2, 1,
            2, 0, 1,
            2, 1, 0
        });
        org.junit.Assert.assertEquals(gameLogic.getGameState(board), GameLogic.GameState.WIN_PLAYER_2);
    }

    @Test
    public void testForDiagonal1Win() {
        Board board = new Board();
        board.setState(new int[]{
            2, 2, 1,
            1, 2, 1,
            0, 1, 2
        });
        org.junit.Assert.assertEquals(gameLogic.getGameState(board), GameLogic.GameState.WIN_PLAYER_2);
    }

    @Test
    public void testForDiagonal2Win() {
        Board board = new Board();
        board.setState(new int[]{
            2, 0, 1,
            0, 1, 1,
            1, 2, 2
        });
        org.junit.Assert.assertEquals(gameLogic.getGameState(board), GameLogic.GameState.WIN_PLAYER_1);
    }
}

