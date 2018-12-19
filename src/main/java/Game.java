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
        try {
            Coordinate coordinate = Parser.parse(command);
            boolean success = table.insert(state.player, coordinate.column, coordinate.row);

            if (!success) {
                state = new GameState(state.player, Message.CELL_NOT_EMPTY);
            } else if (table.isGameOver()) {
                state = new GameState(state.player, Message.GAME_OVER);
            } else if (state.player == Player.PLAYER_ONE) {
                state = new GameState(Player.PLAYER_TWO, Message.ENTER_COMMAND);
            } else {
                state = new GameState(Player.PLAYER_ONE, Message.ENTER_COMMAND);
            }
        } catch(IllegalArgumentException e) {
            state = new GameState(state.player, Message.INVALID_COMMAND);
        }
    }

}
