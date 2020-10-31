public class RotateLeft implements MarsCommand {
    public Position execute(Position position) {
        return position.rotateLeft();
    }
}
