package net.leanix.dev;

public class App {

    public static void main(String[] args)
    {
        Board board = new Board();
        InputHandler inputHandler = new InputHandler(board);
        Game game = new Game(inputHandler, board);
        game.run();
    }
}
