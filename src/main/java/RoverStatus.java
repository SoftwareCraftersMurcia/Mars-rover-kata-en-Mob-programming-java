import java.util.Arrays;
import java.util.List;

public class RoverStatus {
    private final List<Orientation> rotationList =
            Arrays.asList(new Orientation[] {
                    Orientation.NORTH,
                    Orientation.EAST,
                    Orientation.SOUTH,
                    Orientation.WEST
            });

    Orientation orientation;
    Position position;

    public RoverStatus(Orientation orientation, int x, int y) {
        this(orientation, new Position(x, y));
    }

    public RoverStatus(Orientation orientation, Position position) {
        this.orientation = orientation;
        this.position = position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public Position getPosition() {
        return position;
    }

    public RoverStatus rotateLeft() {
        return new RoverStatus(
                rotationList.get((rotationList.indexOf(orientation) + 3) % 4),
                position);
    }

    public RoverStatus rotateRight() {
        return new RoverStatus(
                rotationList.get((rotationList.indexOf(orientation) + 1) % 4),
                position);
    }

    @Override
    public String toString() {
        return position + ":" + orientation;
    }

}
