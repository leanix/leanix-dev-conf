package net.leanix.dev;

import java.util.Random;
import javax.naming.OperationNotSupportedException;

public class Game {
    Board board;
    GameState state;
    int currentPlayerIndex;
    Player currentPlayer;
    Player[] players = new BasePlayer[2];

    public Game(String[] args) {
        initializePlayers(args);
        determineStartingPlayer();
        // init empty board
        board = new Board();
        state = GameState.ONGOING;
    }

    private void determineStartingPlayer() {
        Random rand = new Random();
        currentPlayerIndex = rand.nextInt((1 - 0) + 1) + 0;
        currentPlayer = players[currentPlayerIndex];
        System.out.println( currentPlayer.getName() + " starts");
    }

    private void initializePlayers(String[] args) {
        int argsLength = args.length;
        if(argsLength == 4) {
            String type = args[1];
            if(type.equals(PlayerType.HUMAN)) {
                players[0] = new HumanPlayer("Player 1", CellState.X); // player 1
            }
            else if(type.equals(PlayerType.CPU)) {
                players[0] = new CpuPlayer("Player 1", CellState.X); // player 1
            }
            else {
                System.out.println( "Invalid argument for p1. P1 default type is human." );
                players[0] = new HumanPlayer("Player 1", CellState.X); // player 1
            }
            type = args[3];
            if(type.equals(PlayerType.HUMAN)) {
                players[1] = new HumanPlayer("Player 2", CellState.O); // player 2
            }
            else if(type.equals(PlayerType.CPU)) {
                players[1] = new CpuPlayer("Player 2", CellState.O); // player 2
            }
            else {
                System.out.println( "Invalid argument for p2. P2 default type is human." );
                players[1] = new HumanPlayer("Player 2", CellState.O); // player 2
            }
        }
        else {
            players[0] = new HumanPlayer("Player 1", CellState.X); // player 1
            players[1] = new HumanPlayer("Player 2", CellState.O); // player 2
        }
    }

    public void playLoop() {
        while(state == GameState.ONGOING) {
            board.render();
            currentPlayer.move(board);

            try {
                state = board.getUpdatedState();
            } catch (OperationNotSupportedException ex) {
                System.out.println(ex.getMessage());
            }
            switchPlayers();
        }
    }

    private void switchPlayers() {
        currentPlayerIndex = 1 - currentPlayerIndex;
        currentPlayer = players[currentPlayerIndex];
    }

    public void printResults() {
        board.render();
        switch(state) {
            case WIN1:
                System.out.println( "Player 1 has won." );
                break;
            case WIN2:
                System.out.println( "Player 2 has won." );
                break;
            case DRAW:
                System.out.println( "Draw." );
                break;
        }
    }
}