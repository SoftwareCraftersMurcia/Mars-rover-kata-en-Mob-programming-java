package mars.command.rotation;

import mars.orientation.Orientation;

public class RotateRight extends RotationCommand  {
    @Override
    public Orientation rotate(Orientation orientation) {
        return orientation.rotateRight();
    }
}
