public class Game {

    private final Table table;
    private GameState state;

    public Game(Table table) {
        this.table = table;
        this.state = new GameState(Player.PLAYER_ONE, Message.ENTER_COMMAND);
    }

    public GameState getState() {
        return state;
    }

}
