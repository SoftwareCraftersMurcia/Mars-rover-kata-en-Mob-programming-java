import java.util.Arrays;
import java.util.List;

public enum Orientation {
    North("N"), East("E"), South("S"), West("W");
    private final String representation;

    Orientation(String representation) {
        this.representation = representation;
    }

    @Override
    public String toString() {
        return representation;
    }

    public Orientation next() {
        List<Orientation> rotations = Arrays.asList(North, East, South, West);
        return rotations.get((rotations.indexOf(this) + 1 + 4) % 4);
    }

    public Orientation previous() {
        List<Orientation> rotations = Arrays.asList(North, East, South, West);
        return rotations.get((rotations.indexOf(this) - 1 + 4) % 4);
    }
}
