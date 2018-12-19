package net.leanix.dev;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Tic-Tac-Toe!" );
        Game game = new Game(args);
        game.playLoop();
        game.printResults();
        System.out.println( "Thanks for playing." );
    }
}
