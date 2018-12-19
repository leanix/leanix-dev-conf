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

    public void runCommand(String command) {
        if (state.player == Player.PLAYER_ONE) {
            state = new GameState(Player.PLAYER_TWO, Message.ENTER_COMMAND);
        } else {
            state = new GameState(Player.PLAYER_ONE, Message.ENTER_COMMAND);
        }
    }

}
