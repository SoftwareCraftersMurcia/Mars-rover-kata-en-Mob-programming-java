package mars.command.move;

import mars.Movement;
import mars.orientation.Orientation;

public interface MovementCommand {
    Movement move(Orientation orientation);
}
