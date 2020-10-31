package mars.command.rotation;

import mars.command.MarsCommand;
import mars.orientation.Orientation;

public class RotateLeft extends RotationCommand implements MarsCommand {
    @Override
    public Orientation rotate(Orientation orientation) {
        return orientation.rotateLeft();
    }
}
