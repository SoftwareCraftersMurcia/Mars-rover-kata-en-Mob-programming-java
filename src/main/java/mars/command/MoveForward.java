package mars.command;

import mars.Position;

public class MoveForward implements MarsCommand {
    public Position execute(Position position) {
        return position.moveForward();
    }
}
