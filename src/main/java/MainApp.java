import java.util.Scanner;

public class MainApp {
    public static void main (String[] arg){
        Scanner scanner = new Scanner(System.in);

        Table table = new Table();
        Game game = new Game(table, Player.PLAYER_ONE);

        while (game.getState().message != Message.GAME_OVER) {
            System.out.println(game.drawTable());
            System.out.print(game.getState().player + ">");

            String command = scanner.nextLine();
            game.runCommand(command);

            switch (game.getState().message) {
                case CELL_NOT_EMPTY:
                    System.out.println("Cell not empty, please retry.");
                    break;

                case INVALID_COMMAND:
                    System.out.println("Invalid command.");
                    break;
            }
        }

        System.out.println(game.drawTable());
        System.out.println(game.getState().player + " won!");
    }
}
