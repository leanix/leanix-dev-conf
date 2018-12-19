package net.leanix.dev;

import net.leanix.dev.tictactoe.*;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ConsoleOutput output = new ConsoleOutput();

        Player[] players = determinePlayers(args, output);

        GameLogic gameLogic = new GameLogic();

        GameLogic.GameState gameState = gameLogic.runGame(players, output);
        output.printMessage("" + gameState.name());
    }

    public static Player[] determinePlayers(String[] args, ConsoleOutput output) {
        if (args.length == 0) {
            return new Player[]{new StdinPlayer(0, output), new StdinPlayer(1, output)};
        } else if (args.length == 1 || args.length == 3 || args.length > 4) {
            throw new IllegalArgumentException("need 0, 2, or 4 cmd line arguments");
        } else {
            Player p1 = null;
            Player p2 = null;
            if ("-p1".equals(args[0])) {
                p1 = createPlayer(args[1], 1, output);
            } else if ("-p2".equals(args[0])) {
                p2 = createPlayer(args[1], 2, output);
            } else {
                throw new IllegalArgumentException("wrong cmd line arguments " + Arrays.toString(args));
            }

            if (args.length == 4) {
                if ("-p1".equals(args[2])) {
                    if (p1 != null) {
                        throw new IllegalArgumentException("p1 already selected");
                    }
                    p1 = createPlayer(args[3], 1, output);
                } else if ("-p2".equals(args[2])) {
                    if (p2 != null) {
                        throw new IllegalArgumentException("p2 already selected");
                    }
                    p2 = createPlayer(args[3], 2, output);
                } else {
                    throw new IllegalArgumentException("wrong cmd line arguments " + Arrays.toString(args));
                }
            } else {
                if (p1 == null) {
                    p1 = new StdinPlayer(1, output);
                }
                if (p2 == null) {
                    p2 = new StdinPlayer(2, output);
                }
            }
            return new Player[]{p1, p2};
        }
    }

    public static Player createPlayer(String argument, int playerNumber, ConsoleOutput output) {
        if ("human".equals(argument)) {
            return new StdinPlayer(playerNumber, output);
        } else if ("cpu".equals(argument)) {
            return new RandomCpuPlayer();
        } else {
            throw new IllegalArgumentException("unknown player type " + argument + " for player " + playerNumber);
        }
    }
}
