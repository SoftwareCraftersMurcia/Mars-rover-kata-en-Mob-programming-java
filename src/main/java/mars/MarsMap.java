package mars;

import mars.command.MarsCommand;

import java.util.List;

public class MarsMap {
    public static final int MARS_SIZE = 10;
    private RoverSituation roverSituation;
    private final List<Position> obstacles;
    private boolean blocked;

    public MarsMap(RoverSituation roverSituation, List<Position> obstacles) {
        this.roverSituation = roverSituation;
        this.obstacles = obstacles;
    }

    public void execute(MarsCommand command) {
        RoverSituation desiredRoverSituation = command.execute(roverSituation);
        Position position = positionWithSphericalWorld(desiredRoverSituation.getPosition());
        moveRoverTo(desiredRoverSituation.withPosition(position));
    }

    public void moveRoverTo(RoverSituation roverSituation) {
        blocked = obstacles.contains(roverSituation.getPosition());
        if (!blocked){
            this.roverSituation = roverSituation;
        }
    }

    public String getRoverSituation() {
        if (blocked) {
            return "O:" + roverSituation.toString();
        }
        return roverSituation.toString();
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
