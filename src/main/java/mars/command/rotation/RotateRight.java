package mars.command.rotation;

import mars.command.MarsCommand;
import mars.orientation.Orientation;

public class RotateRight extends RotationCommand implements MarsCommand {
    @Override
    public Orientation rotate(Orientation orientation) {
        return orientation.rotateRight();
    }
}
