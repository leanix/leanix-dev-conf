package net.leanix.dev;

import java.util.HashSet;
import java.util.Set;
import net.leanix.dev.Game.Player;

public class App {

    public static void main(String[] args)
    {
        Set<Player> cpuPlayers = new HashSet<>();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-p1")) {
                if ("cpu".equals(args[++i])) {
                    cpuPlayers.add(Player.Player_1);
                }
            } else if(args[i].equals("-p2")) {
                if ("cpu".equals(args[++i])) {
                    cpuPlayers.add(Player.Player_2);
                }
            }
        }
        Game game = new Game(cpuPlayers);
        game.run();
        System.out.println("Thanks for playing.");
    }
}
