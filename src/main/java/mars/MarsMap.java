package mars;

public class MarsMap {
    public static final int MARS_SIZE = 10;

    public RoverSituation move(RoverSituation to) {
        Position expectedPosition = to.getPosition();
        Position position = new Position(
                roundWorld(expectedPosition.getPositionX()),
                roundWorld(expectedPosition.getPositionY())
        );
        return new RoverSituation(position, to.getOrientation());
    }

    private int roundWorld(int x) {
        return (x + MARS_SIZE) % MARS_SIZE;
    }
}
