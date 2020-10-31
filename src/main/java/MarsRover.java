public class MarsRover {
    public static final int LEFT_ROTATION = -1;
    private Position position;

    public MarsRover() {
        position = new Position(0, 0, Orientation.North);
    }

    public String execute(String commands) {
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (command == 'M') {
                new MoveForward(position).execute();
            }
            if ('R' == command) {
                new RotateRight(position).execute();
            }

            if ('L' == command) {
                position.rotate(LEFT_ROTATION);
            }
        }

        return position.toString();
    }

}
