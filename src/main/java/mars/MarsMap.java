package mars;

import mars.command.MarsCommand;

public class MarsMap {
    public static final int MARS_SIZE = 10;
    private RoverSituation roverSituation;

    public MarsMap(RoverSituation roverSituation) {
        this.roverSituation = roverSituation;
    }

    public void execute(MarsCommand command) {
        RoverSituation desiredRoverSituation = command.execute(roverSituation);
        Position position = positionWithSphericalWorld(desiredRoverSituation.getPosition());
        roverSituation = desiredRoverSituation.withPosition(position);
    }

    public RoverSituation getRoverSituation() {
        return roverSituation;
    }

    private Position positionWithSphericalWorld(Position expectedPosition) {
        return new Position(
                roundWorld(expectedPosition.getPositionX()),
                roundWorld(expectedPosition.getPositionY())
        );
    }

    private int roundWorld(int x) {
        return (x + MARS_SIZE) % MARS_SIZE;
    }
}
