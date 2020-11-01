package mars.command.move;

import mars.Movement;
import mars.RoverSituation;
import mars.command.MarsCommand;
import mars.orientation.Orientation;

public class MoveForward implements MarsCommand, MovementCommand {
    public RoverSituation execute(RoverSituation roverSituation) {
        return roverSituation.moveForward(this);
    }

    public Movement move(Orientation orientation) {
        return orientation.movement();
    }
}
