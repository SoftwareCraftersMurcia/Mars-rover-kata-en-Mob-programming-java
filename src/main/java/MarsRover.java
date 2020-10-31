import orientation.North;

import java.util.Map;

public class MarsRover {
    public static final int LEFT_ROTATION = -1;
    private Position position;
    private final Map<Character, MarsCommand> commands;

    public MarsRover() {
        position = new Position(0, 0, new North());
        commands = Map.of(
                'M', new MoveForward(),
                'R', new RotateRight(),
                'L', new RotateLeft()
        );
    }

    public String execute(String commands) {
        for (int i = 0; i < commands.length(); i++) {
            MarsCommand command = this.commands.get(commands.charAt(i));
            position = command.execute(position);
        }

        return position.toString();
    }

}
