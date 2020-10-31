package mars.command.rotation;

import mars.orientation.Orientation;

public class RotateLeft extends RotationCommand {
    @Override
    public Orientation rotate(Orientation orientation) {
        return orientation.rotateLeft();
    }
}
