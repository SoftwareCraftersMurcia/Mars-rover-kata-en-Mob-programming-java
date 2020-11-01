package mars;

import mars.command.move.MovementCommand;
import mars.command.rotation.RotationCommand;
import mars.orientation.Orientation;

public class RoverSituation {
    private final Orientation orientation;

    private final int positionX;
    private final int positionY;

    public RoverSituation(int positionX, int positionY, Orientation orientation) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    public RoverSituation rotate(RotationCommand rotation) {
        return new RoverSituation(positionX, positionY, rotation.rotate(orientation));
    }

    public RoverSituation moveForward(MovementCommand movementCommand) {
        Movement movement = movementCommand.move(orientation);
        return new RoverSituation(
                roundWorld(positionX + movement.getHorizontalMovement()),
                roundWorld(positionY + movement.getVerticalMovement()),
                orientation
        );
    }

    private int roundWorld(int x) {
        return (x + 10) % 10;
    }

    @Override
    public String toString() {
        return positionX + ":" + positionY + ":" + orientation.toString();
    }
}