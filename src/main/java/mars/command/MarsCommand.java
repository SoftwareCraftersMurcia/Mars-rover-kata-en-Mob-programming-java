package mars.command;

import mars.Position;

public interface MarsCommand {
    Position execute(Position position);
}
