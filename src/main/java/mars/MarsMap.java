package mars;

public class MarsMap {
    public RoverSituation move(RoverSituation from, RoverSituation to) {
        Position expectedPosition = to.getPosition();
        Position position = new Position(
                roundWorld(expectedPosition.getPositionX()),
                roundWorld(expectedPosition.getPositionY())
        );
        return new RoverSituation(position, to.getOrientation());
    }

    private int roundWorld(int x) {
        return (x + 10) % 10;
    }
}
