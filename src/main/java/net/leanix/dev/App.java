package net.leanix.dev;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    private static PlayerStrategy parsePlayer(String arg) {
        if (arg.equals("human")) return new HumanPlayerStrategy();
        if (arg.equals("cpu")) return new CPUPlayerStrategy();
        return null;
    }

    public static void main(String[] args) {
        PlayerStrategy playerOne = parsePlayer(args[1]);
        PlayerStrategy playerTwo = parsePlayer(args[3]);

        GameLoop game = new GameLoop();
        game.init(playerOne, playerTwo);
        game.play();
    }
}
