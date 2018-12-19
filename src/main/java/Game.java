public class Game {

    private final Table table;
    private GameState state;

    public Game(Table table, Player startingPlayer) {
        this.table = table;
        this.state = new GameState(startingPlayer, Message.ENTER_COMMAND);
    }

    public GameState getState() {
        return state;
    }

}
