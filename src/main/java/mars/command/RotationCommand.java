package mars.command;

import mars.Position;
import mars.orientation.Orientation;

public abstract class RotationCommand {
    public Position execute(Position position) {
        return position.rotate(this);
    }

    abstract public Orientation rotate(Orientation orientation);
}
