public class MarsRover {
    public static final int LEFT_ROTATION = -1;
    private Position position;

    public MarsRover() {
        position = new Position(0, 0, Orientation.North);
    }

    public String execute(String commands) {
        for (int i = 0; i < commands.length(); i++) {
            MarsCommand command = createCommand(commands.charAt(i));
            command.execute(position);
        }

        return position.toString();
    }

    private MarsCommand createCommand(char charCommand) {
        if (charCommand == 'M') {
            return new MoveForward();
        } else if ('R' == charCommand) {
            return new RotateRight();
        } else if ('L' == charCommand) {
            return new RotateLeft();
        }
        throw new IllegalArgumentException("The command " + charCommand + " is not recognized");
    }

}
