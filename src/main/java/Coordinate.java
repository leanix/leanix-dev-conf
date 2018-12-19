import java.util.Objects;

public class Coordinate {
public final int column;
public final int row;

    public Coordinate(int column, int row) {
        this.column = column;
        this.row = row;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
            "column=" + column +
            ", row=" + row +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coordinate that = (Coordinate) o;
        return column == that.column &&
            row == that.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }
}
