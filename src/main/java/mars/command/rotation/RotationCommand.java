package mars.command.rotation;

import mars.Position;
import mars.command.MarsCommand;
import mars.orientation.Orientation;

public abstract class RotationCommand implements MarsCommand {
    public Position execute(Position position) {
        return position.rotate(this);
    }

    abstract public Orientation rotate(Orientation orientation);
}
