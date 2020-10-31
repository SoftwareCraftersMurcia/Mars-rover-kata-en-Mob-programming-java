package mars.command.move;

import mars.Position;
import mars.command.MarsCommand;

public class MoveForward implements MarsCommand {
    public Position execute(Position position) {
        return position.moveForward();
    }
}
