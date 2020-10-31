public class RotateLeft implements MarsCommand, RotationCommand {
    public Position execute(Position position) {
        return position.rotate(this);
    }

    @Override
    public Orientation rotate(Orientation orientation) {
        return orientation.rotateLeft();
    }
}
