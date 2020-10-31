public class RotateRight implements MarsCommand, RotationCommand {
    public Position execute(Position position) {
        return position.rotate(this);
    }

    @Override
    public Orientation rotate(Orientation orientation) {
        return orientation.rotateRight();
    }
}
