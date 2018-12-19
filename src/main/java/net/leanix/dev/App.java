package net.leanix.dev;

import net.leanix.dev.tictactoe.Board;
import net.leanix.dev.tictactoe.ConsoleOutput;
import net.leanix.dev.tictactoe.Coordinate;
import net.leanix.dev.tictactoe.StdinPlayer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ConsoleOutput output = new ConsoleOutput();
        Board board = new Board();
        output.printMessage("Empty board:");
        output.printBoard(board);
        output.printMessage("Board with B0 being chosen by play 1:");
        board.setCellState(new Coordinate(1, 0), 1);
        output.printBoard(board);
        StdinPlayer player = new StdinPlayer(0, output);
        Coordinate coordinate = player.submitMove(board);
        output.printMessage("entered x:" + coordinate.getX() + " y:" + coordinate.getY());
    }
}
