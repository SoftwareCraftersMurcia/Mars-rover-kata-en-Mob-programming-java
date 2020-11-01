package mars;

import mars.command.move.MovementCommand;
import mars.command.rotation.RotationCommand;
import mars.orientation.Orientation;

public class RoverSituation {
    private final Orientation orientation;

    private final Position position;

    public RoverSituation(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public RoverSituation rotate(RotationCommand rotation) {
        return new RoverSituation(new Position(position.getPositionX(), position.getPositionY()), rotation.rotate(orientation));
    }

    public RoverSituation moveForward(MovementCommand movementCommand) {
        Movement movement = movementCommand.move(orientation);
        return new RoverSituation(
                new Position(roundWorld(position.getPositionX() + movement.getHorizontalMovement()), roundWorld(position.getPositionY() + movement.getVerticalMovement())), orientation
        );
    }

    private int roundWorld(int x) {
        return (x + 10) % 10;
    }

    @Override
    public String toString() {
        return position.getPositionX() + ":" + position.getPositionY() + ":" + orientation.toString();
    }
}