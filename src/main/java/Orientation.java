import java.util.Arrays;
import java.util.List;

public enum Orientation {
    North("N"), East("E"), South("S"), West("W");
    private final String representation;
    private static final List<Orientation> rotations = Arrays.asList(Orientation.values());

    Orientation(String representation) {
        this.representation = representation;
    }

    @Override
    public String toString() {
        return representation;
    }

    public Orientation next() {
        return rotations.get((rotations.indexOf(this) + 1 + 4) % 4);
    }

    public Orientation previous() {
        return rotations.get((rotations.indexOf(this) - 1 + 4) % 4);
    }
}
