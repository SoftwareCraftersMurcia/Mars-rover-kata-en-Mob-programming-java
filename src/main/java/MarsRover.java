public class MarsRover {
    public static final int LEFT_ROTATION = -1;
    private Position position;

    public MarsRover() {
        position = new Position(0, 0, Orientation.North);
    }

    public String execute(String commands) {
        for (int i = 0; i < commands.length(); i++) {
            char charCommand = commands.charAt(i);
            MarsCommand command = null;
            if (charCommand == 'M') {
                command = new MoveForward(position);
            } else if ('R' == charCommand) {
                command = new RotateRight(position);
            } else if ('L' == charCommand) {
                command = new RotateLeft(position);
            }
            command.execute();
        }

        return position.toString();
    }

}
