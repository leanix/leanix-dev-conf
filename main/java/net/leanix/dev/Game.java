package net.leanix.dev;

public class Game {
    Board board;
    GameState state;
    Player currentPlayer = new HumanPlayer();

    public Game(String[] args) {
        // determine players (human or cpu)
        // determine starting player
        // init empty board
        board = new Board();
        state = GameState.ONGOING;
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
