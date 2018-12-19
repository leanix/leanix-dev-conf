package net.leanix.dev.tictactoe;

import java.util.Optional;

import net.leanix.dev.tictactoe.GameLogic.GameState;

public class AlternativeCpuPlayer implements Player {
    private final int ownNumber; // 1 or 2
    private final GameLogic gameLogic = new GameLogic();

    public AlternativeCpuPlayer(int ownNumber) {
        this.ownNumber = ownNumber;
    }

    public Coordinate submitMove(Board board) {
        Coordinate winningMove = findWinningMove(board, ownNumber - 1);
        if (winningMove != null) {
            return winningMove; 
        }
        Coordinate blockingMove = findWinningMove(board, 2 - ownNumber);
        if (blockingMove != null) {
            return blockingMove; 
        }
        return findBestMove(board);
    };

    private Coordinate findWinningMove(Board board, int playerNumber) {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Coordinate coordinate = new Coordinate(x, y);
                if (board.getCellState(coordinate) == 0) {
                    board.setCellState(coordinate, playerNumber);
                    if (playerNumber == 1 && gameLogic.getGameState(board) == GameState.WIN_PLAYER_1 ||
                        playerNumber == 2 && gameLogic.getGameState(board) == GameState.WIN_PLAYER_2) {
                        return coordinate;
                    }
                }
            }
        }
        return null;
    }

    private Coordinate findBestMove(Board board) {
        return new Coordinate(1, 1);
    }
}
