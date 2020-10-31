public class MoveForward implements MarsCommand {
    public Position execute(Position position) {
        return position.moveForward();
    }
}
