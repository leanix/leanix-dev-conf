package net.leanix.dev;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    Board board;
    GameState state;
    Player currentPlayer;
    List<Player> players = new ArrayList<>();

    public Game(String[] args) {
        initializePlayers(args);
        determineStartingPlayer();
        // init empty board
        board = new Board();
        state = GameState.ONGOING;
    }

    private void determineStartingPlayer() {
        Random rand = new Random();
        int randomNum = rand.nextInt((1 - 0) + 1) + 0;
        currentPlayer = players.get(randomNum);
        System.out.println( currentPlayer.getName() + " starts");
    }

    private void initializePlayers(String[] args) {
        int argsLength = args.length;
        if(argsLength == 4) {
            String type = args[1];
            if(type.equals(PlayerType.HUMAN)) {
                players.add(new HumanPlayer("Player 1", CellState.X)); // player 1
            }
            else if(type.equals(PlayerType.CPU)) {
                players.add(new CpuPlayer("Player 1", CellState.X)); // player 1
            }
            else {
                System.out.println( "Invalid argument for p1. P1 default type is human." );
                players.add(new HumanPlayer("Player 1", CellState.X)); // player 1
            }
            type = args[3];
            if(type.equals(PlayerType.HUMAN)) {
                players.add(new HumanPlayer("Player 2", CellState.O)); // player 2
            }
            else if(type.equals(PlayerType.CPU)) {
                players.add(new CpuPlayer("Player 2", CellState.O)); // player 2
            }
            else {
                System.out.println( "Invalid argument for p2. P2 default type is human." );
                players.add(new HumanPlayer("Player 2", CellState.O)); // player 2
            }
        }
        else {
            players.add(new HumanPlayer("Player 1", CellState.X)); // player 1
            players.add(new HumanPlayer("Player 2", CellState.O)); // player 2
        }
    }

    public void playLoop() {
        while(state == GameState.ONGOING) {
            board.render();
            currentPlayer.move(board);
            state = board.getUpdatedState();
        }
    }

    public void printResults() {
    }
}
