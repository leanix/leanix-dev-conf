package net.leanix.dev.tictactoe;

import java.util.Random;


public class GameLogic {
    public int determineStartPlayer() {
        return new Random().nextInt(2) + 1;
    }

    public GameState getGameState(Board board) {
        boolean gameIsInProgress = false;
        int[] cellStates = new int[3];
        // Check columns
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                cellStates[y] = board.getCellState(new Coordinate(x, y));
            }
            GameState columnGameState = checkCellStates(cellStates);
            if (columnGameState == GameState.IN_PROGRESS) {
                gameIsInProgress = true;
            } else if (columnGameState == GameState.WIN_PLAYER_1 || columnGameState == GameState.WIN_PLAYER_2) {
                return columnGameState;
            }
        }
        // Check rows
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                cellStates[x] = board.getCellState(new Coordinate(x, y));
            }
            GameState rowGameState = checkCellStates(cellStates);
            if (rowGameState == GameState.IN_PROGRESS) {
                gameIsInProgress = true;
            } else if (rowGameState == GameState.WIN_PLAYER_1 || rowGameState == GameState.WIN_PLAYER_2) {
                return rowGameState;
            }
        }
        // Check first diagonal
        for (int i = 0; i < 3; i++) {
            cellStates[i] = board.getCellState(new Coordinate(i, i));            
        }
        GameState diagonal1GameState = checkCellStates(cellStates);
        if (diagonal1GameState == GameState.IN_PROGRESS) {
            gameIsInProgress = true;
        } else if (diagonal1GameState == GameState.WIN_PLAYER_1 || diagonal1GameState == GameState.WIN_PLAYER_2) {
            return diagonal1GameState;
        }
        // Check first diagonal
        for (int i = 0; i < 3; i++) {
            cellStates[i] = board.getCellState(new Coordinate(i, 2-i));            
        }
        GameState diagonal2GameState = checkCellStates(cellStates);
        if (diagonal2GameState == GameState.IN_PROGRESS) {
            gameIsInProgress = true;
        } else if (diagonal2GameState == GameState.WIN_PLAYER_1 || diagonal2GameState == GameState.WIN_PLAYER_2) {
            return diagonal2GameState;
        }
        // No player has won yet
        return gameIsInProgress ? GameState.IN_PROGRESS : GameState.DRAW;
    }

    private GameState checkCellStates(int[] cellStates) {
        if (cellStates[0] == 0 || cellStates[1] == 0 || cellStates[2] == 0) {
            return GameState.IN_PROGRESS;
        } else if (cellStates[0] == cellStates[1] && cellStates[1] == cellStates[2]) {
            return cellStates[0] == 1 ? GameState.WIN_PLAYER_1 : GameState.WIN_PLAYER_2;
        } else {
            return GameState.DRAW;
        }
    }

    public GameState runGame(Player[] players, ConsoleOutput output) {
        int currentPlayerIdx = determineStartPlayer();

        Board board = new Board();

        while (true) {
            GameState gameState = getGameState(board);
            if (gameState != GameState.IN_PROGRESS) {
                return gameState;
            }

            Player currentPlayer = players[currentPlayerIdx - 1];

            boolean moveIsInvalid = true;
            while (moveIsInvalid) {
                Coordinate coordinate = currentPlayer.submitMove(board);

                moveIsInvalid = isValid(coordinate, board);

                if (moveIsInvalid) {
                    output.printMessage("Invalid move. Please submit correct move.");
                }
            }

            currentPlayerIdx = 3 - currentPlayerIdx;
        }
    }

    public boolean isValid(Coordinate coordinate, Board board) {
        return board.getCellState(coordinate) ==0;
    }

    public enum GameState {
        IN_PROGRESS,
        DRAW,
        WIN_PLAYER_1,
        WIN_PLAYER_2
    }

}
