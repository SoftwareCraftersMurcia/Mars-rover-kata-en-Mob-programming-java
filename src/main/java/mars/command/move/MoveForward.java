package mars.command.move;

import mars.Movement;
import mars.Position;
import mars.command.MarsCommand;
import mars.orientation.Orientation;

public class MoveForward implements MarsCommand, MovementCommand {
    public Position execute(Position position) {
        return position.moveForward(this);
    }

    public Movement move(Orientation orientation) {
        return orientation.movement();
    }
}
