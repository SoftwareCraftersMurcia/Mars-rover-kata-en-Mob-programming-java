public class MarsRover {
    public static final int LEFT_ROTATION = -1;
    public static final int RIGHT_ROTATION = +1;
    private Position position;

    public MarsRover() {
        position = new Position(0, 0, 'N', Orientation.North);
    }

    public String execute(String commands) {
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (command == 'M') {
                position.moveForward();
            }
            if ('R' == command) {
                position.rotate(RIGHT_ROTATION);
            }

            if ('L' == command) {
                position.rotate(LEFT_ROTATION);
            }
        }

        return position.toString();
    }

}
