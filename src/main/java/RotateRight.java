public class RotateRight extends RotationCommand implements MarsCommand {
    @Override
    public Orientation rotate(Orientation orientation) {
        return orientation.rotateRight();
    }
}
