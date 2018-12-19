import java.util.Objects;

public class GameState {
    public final Player player;
    public final Message message;

    public GameState(Player player, Message message) {
        this.player = player;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameState gameState = (GameState) o;
        return player == gameState.player &&
            message == gameState.message;
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, message);
    }

    @Override
    public String toString() {
        return "GameState{" +
            "player=" + player +
            ", message=" + message +
            '}';
    }
}
